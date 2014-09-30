/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ngat.opsgui;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import ngat.astrometry.AstroCatalog;
import ngat.astrometry.AstrometrySimulator;
import ngat.astrometry.BasicSite;
import ngat.astrometry.BasicTargetTrackCalculatorFactory;
import ngat.ems.SkyModelSeeingUpdate;
import ngat.opsgui.base.Resources;
import ngat.opsgui.beans.NewJPanel;
import ngat.opsgui.login.UserDescriptor;
import ngat.opsgui.perspectives.tracking.TrackingPerspective;
import ngat.opsgui.xcomp.AstroSimControlPanel;
import ngat.opsgui.xcomp.CatalogDisplayEditorPanel2;
import ngat.opsgui.xcomp.GroupDisplayPanel;
import ngat.opsgui.xcomp.LogEntryPanel;
import ngat.opsgui.xcomp.OperationsHistoryPanel;
import ngat.opsgui.xcomp.SeeingPanel2;
import ngat.phase2.XAirmassConstraint;
import ngat.phase2.XExecutiveComponent;
import ngat.phase2.XExtraSolarTarget;
import ngat.phase2.XGroup;
import ngat.phase2.XHourAngleConstraint;
import ngat.phase2.XIteratorComponent;
import ngat.phase2.XProposal;
import ngat.phase2.XSeeingConstraint;
import ngat.phase2.XSkyBrightnessConstraint;
import ngat.sms.GroupItem;

/**
 *
 * @author eng
 */
public class OpsUIExtraLauncher {

    final static  String[] things = new String[] {"AKAK", "bahhe", "ghghgh", "Narrby", "opkdk", "klorrmk", "juhtgt", "hunanan", "lkasgde", "yuprye", "poretyu"};
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        Resources.setDefaults(null);
        
       /* AstroCatalog catalog = new AstroCatalog("Test");
        for (int it = 0; it < 20; it++) {
            catalog.addTarget(createTarget(it));
        }*/
        
         
        LogEntryPanel lp = new LogEntryPanel();
        
        lp.showLogDialog(new UserDescriptor("abc", "Dr", "Andrew", "Bielinski"));
        
        OperationsHistoryPanel ohp = new OperationsHistoryPanel();
        JFrame f6 = new JFrame("Ops");
        f6.getContentPane().setLayout(new BorderLayout());
        f6.getContentPane().add(ohp, BorderLayout.CENTER);
        f6.pack();
        //f6.setBounds(100, 100, 900, 500);
        f6.setVisible(true);
        
        
        // add some shit
        for (int i = 0; i < 1000; i++) {
            
            ohp.updateState((int)(Math.random()*6.0));
            
            try {Thread.sleep(10000L);} catch (InterruptedException x) {}
        }
        
        
        /*final XExtraSolarTarget tgt = createTarget(1);
     
        final NewJPanel njp = new NewJPanel();
        
         
        
    
        JFrame f6 = new JFrame("Rotators");
        f6.getContentPane().setLayout(new BorderLayout());
        f6.getContentPane().add(njp, BorderLayout.CENTER);
        f6.pack();
        f6.setBounds(100, 100, 900, 500);
        f6.setVisible(true);
        
       
        
            System.err.println("update track display...");
             SwingUtilities.invokeLater(new Runnable() {
                 
                 public void run() {
                     
                 try {
                     njp.updateTarget(tgt, System.currentTimeMillis(), System.currentTimeMillis()+12*3600*1000L);
                 } catch (Exception e) {
                     e.printStackTrace();
                 }
                 }});
                 
                 
                 */
        
       /* JFrame f = new JFrame("Dialog test");
        TrackingPerspective tp = new TrackingPerspective(f, new BasicSite("home", Math.toRadians(28.0), Math.toRadians(-17.0)));
        f.getContentPane().add(tp);
        f.pack();
        f.setVisible(true);
        
        AstrometrySimulator sim = new AstrometrySimulator();
        JFrame f2 = new JFrame("Astrometry Simulation");
        AstroSimControlPanel ast = new AstroSimControlPanel(sim);
        sim.addSimulationListener(ast);
        f2.getContentPane().add(ast);
        f2.pack();
        f2.setVisible(true);
        
  
        
        SeeingPanel2 sp2 = new SeeingPanel2();
        sp2.createSeeingDisplay();
        
        for (int i = 0; i < 25; i++) {
            SkyModelSeeingUpdate sm = new SkyModelSeeingUpdate(System.currentTimeMillis(), Math.random(), Math.random(), Math.random(), false, "RATCAM");
            sm.setAzimuth(Math.random()*2.0*Math.PI);
            sm.setElevation(Math.random()*0.5*Math.PI);
            sm.setWavelength(Math.random()*500.0+500.0);
            sm.setSource("AAA");
            sm.setTargetName("Astar");
            sp2.seeingUpdate(sm);
            try {Thread.sleep(2000L);} catch (Exception e) {}
        }
        
        
        CatalogDisplayEditorPanel2 c2 = new CatalogDisplayEditorPanel2(tp, catalog);
        c2.createCatalogDisplay();
        
        
        
        
        GroupDisplayPanel gdp = new GroupDisplayPanel();
        JFrame f3 = new JFrame("Group display");
        f3.getContentPane().add(gdp);
        f3.pack();
        f3.setVisible(true);

       for (int i = 0; i < 10; i++) {
            gdp.notifyGroupStarted(createGroup(things[i]));
            try {Thread.sleep(5000L);} catch (Exception e) {}
       }
       
       */
        
    }

    private static XExtraSolarTarget createTarget(int i) {
        XExtraSolarTarget t = new XExtraSolarTarget("target-"+i);
        t.setRa(Math.random()*Math.PI*2.0);
        t.setDec(Math.random()*Math.PI*0.5);
        return t;
    }
    
    private static GroupItem createGroup(String thing) {
           XGroup g = new XGroup();
        g.setName("mygroup");
        
        
        g.addObservingConstraint(new XAirmassConstraint(Math.random()*3.0));
        g.addObservingConstraint(new XSkyBrightnessConstraint(XSkyBrightnessConstraint.MAG_2));
        g.addObservingConstraint(new XSeeingConstraint(Math.random()*2.0));
        g.addObservingConstraint(new XHourAngleConstraint(-0.2, 0.2));
        XIteratorComponent mroot = new XIteratorComponent(thing+"-root", null);
        XExecutiveComponent slew = new XExecutiveComponent("Slew "+thing, null);
        mroot.addElement(slew);
        XExecutiveComponent cfg = new XExecutiveComponent("Config sdss-b 2x2", null);
        mroot.addElement(cfg);
        XExecutiveComponent ap = new XExecutiveComponent("Aperture "+Math.random()*8, null);
        mroot.addElement(ap);
       
         
        GroupItem group = new GroupItem(g, mroot);
        group.setProposal(new XProposal("AHA"));
        return group;
    }
    
}
