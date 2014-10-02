/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ngat.opsgui.login;

import java.io.File;
import javax.swing.JFrame;
import org.jdom.Document;
import org.jdom.input.SAXBuilder;

/**
 *
 * @author eng
 */
public class StartLogin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
        SAXBuilder builder = new SAXBuilder();
        Document doc = builder.build(new File(System.getProperty("user.home")+"/gui.xml"));
        
        UiConfig config = new UiConfig();
        config.configure(doc.getRootElement());
        //System.err.println("Root element: "+doc.getRootElement());
        LoginPanel panel = new LoginPanel(config);
        JFrame f = new JFrame("Operations UI Login");
        f.getContentPane().add(panel);
        f.pack();
        f.setVisible(true);
    
        /*UserDetailsPanel udp = new UserDetailsPanel();
        JFrame f2 = new JFrame("New User Details");
        f2.getContentPane().add(udp);
        f2.pack();
        f2.setVisible(true);*/
        
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
