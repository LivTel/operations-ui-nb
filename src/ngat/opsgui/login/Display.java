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
public class Display implements XmlConfigurable {
    
    
    private String name;
    
    private List<String> perspectiveNames;
    
    public Display(String name) {
        this.name = name;
        perspectiveNames = new Vector<String>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public int countPerspectives() {
        return perspectiveNames.size();
    }

    public boolean addPerspective(String name) {
        return perspectiveNames.add(name);
    }

    public boolean removePerspective(String name) {
        return perspectiveNames.remove(name);
    }

    public List<String> getPerspectiveNames() {
        return perspectiveNames;
    }

    @Override
    public void configure(Element node) throws Exception {
        System.err.println("Configuring diaplay: "+this);
        List plist = node.getChildren("perspective");
        for (int ip = 0; ip < plist.size(); ip++) {
            Element pnode = (Element)plist.get(ip);
            String name = pnode.getAttributeValue("name");                     
            perspectiveNames.add(name);
  
        }
    }

    public Element createNode() {
        
        Element node = new Element("display");
        node.setAttribute("name", name);
        
        return node;
        
    }
    
    @Override
    public String toString() {
        return "Display{" + "name=" + name + ", perspectiveNames=" + perspectiveNames + '}';
    }
    

    
}
