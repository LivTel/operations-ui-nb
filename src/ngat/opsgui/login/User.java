/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ngat.opsgui.login;

import java.util.List;
import java.util.Vector;
import ngat.util.XmlConfigurable;
import org.jdom.Element;

/**
 *
 * @author eng
 */
public class User implements XmlConfigurable {

    private UserDescriptor descriptor;

    private List<Layout> layouts;

    public User(UserDescriptor descriptor) {
        this.descriptor = descriptor;
        layouts = new Vector<Layout>();
    }

    public UserDescriptor getDescriptor() {
        return descriptor;
    }

    public void setDescriptor(UserDescriptor descriptor) {
        this.descriptor = descriptor;
    }

    public List<Layout> getLayouts() {
        return layouts;
    }

    public boolean addLayout(Layout l) {
        return layouts.add(l);
    }

    public boolean removeLayout(Layout l) {
        return layouts.remove(l);
    }

    public void configure(Element node) throws Exception {
        System.err.println("Configure user: " + this);
        List lnodes = node.getChildren("layout");
        System.err.println("User: "+this+" has "+lnodes.size()+" layouts");
        for (int il = 0; il < lnodes.size(); il++) {
            Element lnode = (Element) lnodes.get(il);
            Layout l = new Layout(lnode.getAttributeValue("name"));
            l.configure(lnode);
            layouts.add(l);
        }
        System.err.println("User done");
    }

    public Element createNode() {

        Element node = new Element("user");
        node.setAttribute("name", descriptor.getId());

        Element tnode = new Element("title");
        tnode.setText(descriptor.getTitle());
        node.addContent(tnode);

        Element fnode = new Element("first");
        fnode.setText(descriptor.getFirstName());
        node.addContent(fnode);

        Element lnode = new Element("last");
        lnode.setText(descriptor.getLastName());
        node.addContent(lnode);

        Element inode = new Element("icon");
        inode.setText(descriptor.getIconPath());
        node.addContent(inode);

        for (int i = 0; i < layouts.size(); i++) {
            Layout l = layouts.get(i);
            Element ynode = l.createNode();
            node.addContent(ynode);
        }

        return node;

    }

    @Override
    public String toString() {
        return "User{" + "descriptor=" + descriptor + '}';
    }

}
