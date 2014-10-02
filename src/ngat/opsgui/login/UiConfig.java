/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ngat.opsgui.login;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import ngat.util.XmlConfigurable;
import org.jdom.Comment;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

/**
 *
 * @author eng
 */
public class UiConfig implements XmlConfigurable {

    /**
     * List of users.
     */
    List<User> users;

    /**
     * Map user ID to user.
     */
    Map<String, User> userNameMap;

    /**
     * Map full name and title to user.
     */
    Map<String, User> userFullNameMap;

    /**
     * List of available services.
     */
    List<ServiceDescriptor> services;

    /**
     * Map name to service.
     */
    Map<String, ServiceDescriptor> serviceNameMap;

    public UiConfig() {
        users = new Vector<User>();
        userNameMap = new HashMap<String, User>();
        userFullNameMap = new HashMap<String, User>();
        services = new Vector<ServiceDescriptor>();
        serviceNameMap = new HashMap<String, ServiceDescriptor>();
    }

    public void addUser(User user) {
        users.add(user);
        userNameMap.put(user.getDescriptor().getId(), user);
        userFullNameMap.put(user.getDescriptor().getFullName(), user);

        System.err.println("Add user: " + user.getDescriptor().getFullName());

    }

    public List<User> getUsers() {
        return users;
    }

    public User getUserByName(String name) {
        return userNameMap.get(name);
    }

    public User getUserByFullName(String fullName) {
        return userFullNameMap.get(fullName);
    }

    public void addService(ServiceDescriptor service) {
        services.add(service);
        serviceNameMap.put(service.getName(), service);

        System.err.println("Add service: "+service);
    }

    public ServiceDescriptor getServiceByName(String name) {
        return serviceNameMap.get(name);
    }

    /**
     *
     * @param node
     * @throws Exception
     */
    @Override
    public void configure(Element node) throws Exception {
        System.err.println("Configure UI: rootnode: " + node);
        //Element cnode = node.getChild("config");

        // Users
        List unodes = node.getChildren("user");
        for (int il = 0; il < unodes.size(); il++) {
            Element unode = (Element) unodes.get(il);
            // extract user details
            String userName = unode.getAttributeValue("name").trim();
            String title = unode.getChildText("title").trim();
            String first = unode.getChildText("first").trim();
            String last = unode.getChildText("last").trim();
            // may be null for now
            String iconPath = unode.getChildText("icon").trim();

            UserDescriptor udesc = new UserDescriptor(userName, title, first, last);
            User user = new User(udesc);
            user.configure(unode);
            addUser(user);

        }
        
        // Services
        List snodes = node.getChildren("service");
        for (int is = 0; is < snodes.size(); is++) {
            Element snode = (Element) snodes.get(is);
             String serviceName = snode.getAttributeValue("name").trim();
            // extract service details
            ServiceDescriptor service = new ServiceDescriptor(serviceName);
            service.configure(snode);
            addService(service);
          
        }
    }

    public Element createNode() throws Exception {

        Element node = new Element("config");

        for (int i = 0; i < users.size(); i++) {
            User u = users.get(i);
            Element unode = u.createNode();
            node.addContent(new Comment("User: "+u.getDescriptor().getFullName()));
            node.addContent(unode);
        }
        
        for (int i = 0; i < services.size(); i++) {
            ServiceDescriptor s = services.get(i);
            Element snode = s.createNode();
            node.addContent(new Comment("Service: "+s.getDescription()));
            node.addContent(snode);
        }
        return node;
    }

    public void xmlout() throws Exception {

        XMLOutputter xmlout = new XMLOutputter(Format.getPrettyFormat());
        Element root = createNode();
        Document doc = new Document(root);
        long time = System.currentTimeMillis();
        doc.addContent(new Comment(String.format("Generated: %tF %tT ", time, time)));
        xmlout.output(doc, new FileOutputStream("/Users/eng/gui_saved.xml"));

    }

}
