/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ngat.opsgui.login;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import ngat.util.XmlConfigurable;
import org.jdom.Element;

/**
 *
 * @author eng
 */
public class PerspectiveDescriptor implements XmlConfigurable {
    
    private String name;
    
    private Icon icon;
    
    private String description;
    
    private List<String> serviceNames;

    public PerspectiveDescriptor(String name) {
        this.name = name;
        serviceNames = new Vector<String>();
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public Iterator<String> listServiceName() {
        return serviceNames.iterator();
    }
    
    

    @Override
    public void configure(Element node) throws Exception {
        
        description = node.getChildTextTrim("description");
        
        String stricon = node.getChildTextTrim("icon");
        System.err.println("Cfg: "+name+" Looking for: "+stricon);
        icon = new ImageIcon(getClass().getResource("/ngat/opsgui/login/resources/"+stricon));
        List slist = node.getChildren("service");
        for (int is = 0; is < slist.size(); is++) {
            Element snode = (Element)slist.get(is);
            String svcName = (String)snode.getTextTrim();
            serviceNames.add(svcName);               
        }
        
        
    }

    
    
    
}
