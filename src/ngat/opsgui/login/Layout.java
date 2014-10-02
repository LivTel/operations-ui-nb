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
public class Layout implements XmlConfigurable {
    
    private String name;
    
    private List<Display> displays;

    public Layout(String name) {
        this.name = name;
        displays = new Vector<Display>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Display> getDisplays() {
        return displays;
    }

    public boolean addDisplay(Display d) {
        return displays.add(d);
    }

    public boolean removeDisplay(Display d) {
        return displays.remove(d);
    }

    @Override
    public void configure(Element node) throws Exception {
      System.err.println("Configuring layout: "+this);
        List dlist = node.getChildren("display");
        for (int id = 0; id < dlist.size(); id++) {
            Element dnode = (Element)dlist.get(id);
            String name = dnode.getAttributeValue("name");
            Display display = new Display(name);
            display.configure(dnode);
            displays.add(display);
        }
        System.err.println("Layout completed");
    }
    
 public Element createNode() {
 
     Element node = new Element("layout");
     node.setAttribute("name", name);
     
     for (int i = 0; i < displays.size(); i++) {
         Display d = displays.get(i);
         Element dnode = d.createNode();
         node.addContent(dnode);
     }
     
     return node;
     
 }
 
    @Override
    public String toString() {
        return "Layout{" + "name=" + name + '}';
    }

}
