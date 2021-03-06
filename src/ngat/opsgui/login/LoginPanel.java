/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ngat.opsgui.login;

import java.awt.Component;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;
import javax.swing.SwingUtilities;

/**
 *
 * @author eng
 */
public class LoginPanel extends javax.swing.JPanel {

    private UiConfig config;

    /**
     * Creates new form LoginPanel
     */
    public LoginPanel(UiConfig config) {
        this.config = config;
        initComponents();
        userCombo.setSelectedIndex(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        userCombo = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        layoutList = new javax.swing.JList();
        editUserButton = new javax.swing.JButton();
        newUserButton = new javax.swing.JButton();
        selectLayoutButton = new javax.swing.JButton();
        addLayoutButton = new javax.swing.JButton();
        editLayoutButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ngat/opsgui/resources/login-icon.png"))); // NOI18N
        jLabel2.setText("jLabel2");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel3.setText("LT Operations Login");

        jLabel4.setText("User");

        userCombo.setModel(createUserListModel());
        userCombo.setRenderer(createUserListRenderer());
        userCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userComboboxHandler(evt);
            }
        });

        jLabel5.setText("Layout");

        layoutList.setModel(createLayoutListModel());
        layoutList.setCellRenderer(createLayoutListRenderer());
        layoutList.setVisibleRowCount(6);
        jScrollPane1.setViewportView(layoutList);

        editUserButton.setText("Edit");
        editUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editUserHandler(evt);
            }
        });

        newUserButton.setText("New");
        newUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newUserButtonHandler(evt);
            }
        });

        selectLayoutButton.setBackground(new java.awt.Color(153, 255, 153));
        selectLayoutButton.setText("Select");
        selectLayoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectButtonHandler(evt);
            }
        });

        addLayoutButton.setText("Add");

        editLayoutButton.setText("Edit");
        editLayoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editLayoutsHandler(evt);
            }
        });

        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonHandler(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(15, 15, 15)
                .add(jLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 98, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(jLabel5)
                        .add(18, 18, 18)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(exitButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 66, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(layout.createSequentialGroup()
                                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 145, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(addLayoutButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 66, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(editLayoutButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 66, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(selectLayoutButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 66, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(newUserButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 66, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(editUserButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 66, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))))
                    .add(jLabel3)
                    .add(layout.createSequentialGroup()
                        .add(jLabel4)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(userCombo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 182, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(15, 15, 15)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(layout.createSequentialGroup()
                        .add(jLabel2)
                        .add(22, 22, 22))
                    .add(layout.createSequentialGroup()
                        .add(jLabel3)
                        .add(20, 20, 20)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel4)
                            .add(userCombo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(newUserButton))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(editUserButton)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)))
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(selectLayoutButton)
                                .add(7, 7, 7)
                                .add(addLayoutButton)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(editLayoutButton))
                            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(exitButton))
                    .add(jLabel5))
                .addContainerGap(20, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void userComboboxHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userComboboxHandler

        // work out which user
        User user = (User) userCombo.getSelectedItem();
        String userFullName = user.getDescriptor().getFullName();

        // Map them to a user entry and update the layouts list
        // *User user = findUserByFullName(userFullName)
        List<Layout> layouts = user.getLayouts();
        // Append default layouts to user's list
        // *appendDefaultLayouts(layouts);
        // *showLayoutList(layouts)
        ((DefaultListModel) layoutList.getModel()).removeAllElements();
        ((DefaultListModel) layoutList.getModel()).addElement(new Layout("Operations"));
        ((DefaultListModel) layoutList.getModel()).addElement(new Layout("Engineering"));
        ((DefaultListModel) layoutList.getModel()).addElement(new Layout("Astronomer"));
        for (int i = 0; i < layouts.size(); i++) {
            Layout l = layouts.get(i);
            ((DefaultListModel) layoutList.getModel()).addElement(l);
        }

    }//GEN-LAST:event_userComboboxHandler

    private void newUserButtonHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newUserButtonHandler

        UserDetailsPanel udp = new UserDetailsPanel(this);
        udp.createNewUserDialog(null);

    }//GEN-LAST:event_newUserButtonHandler

    private void editUserHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editUserHandler

        User user = (User) userCombo.getSelectedItem();

        UserDetailsPanel udp = new UserDetailsPanel(this);
        udp.createEditUserDialog(null, user.getDescriptor());

    }//GEN-LAST:event_editUserHandler

    private void exitButtonHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonHandler

        // time for off
        // save the latest config
        try {
            config.xmlout();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.exit(0);

    }//GEN-LAST:event_exitButtonHandler

    private void selectButtonHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectButtonHandler

       
        User selectedUser = (User) userCombo.getSelectedItem();

        if (selectedUser == null) {
             JOptionPane.showMessageDialog(this,
                     "I fear you have forgotten to select a User !",
                      "Gui startup",
                JOptionPane.WARNING_MESSAGE);
             return;
        }

        Layout selectedLayout = (Layout) layoutList.getSelectedValue();

            if (selectedLayout == null) {
             JOptionPane.showMessageDialog(this,
                     "I fear you have forgotten to select a Layout !",
                      "Gui startup",
                JOptionPane.WARNING_MESSAGE);
             return;
        }
        JOptionPane.showMessageDialog(this,
                "Starting GUI for User: " + selectedUser.getDescriptor().getFullName()
                + " with Layout: " + selectedLayout.getName(),
                "Gui startup",
                JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_selectButtonHandler

    private void editLayoutsHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editLayoutsHandler
        
         User selectedUser = (User) userCombo.getSelectedItem();

        if (selectedUser == null) {
             JOptionPane.showMessageDialog(this,
                     "I fear you have forgotten to select a User !",
                      "Gui startup",
                JOptionPane.WARNING_MESSAGE);
             return;
        }
        
        LayoutDetailsPanel ldp = new LayoutDetailsPanel();
        ldp.editLayouts(selectedUser);
        JDialog dlg = new JDialog();
        dlg.getContentPane().add(ldp);
        dlg.pack();
        dlg.setVisible(true);
        
    }//GEN-LAST:event_editLayoutsHandler

    /**
     * Add a new user.
     */
    public void addUser(UserDescriptor udesc) {
        // add into config

        final UserDescriptor fudesc = udesc;
    //SwingUtilities.invokeLater(new Runnable() {

        //public void run() {
        // where were we before
        //User lastUser = (User)userCombo.getModel().getSelectedItem();
        User user = new User(fudesc);
        config.addUser(user);
        // Force the model to update otherwise it just locks up - this is naff
        userCombo.getModel().setSelectedItem(user);

        try {
            config.xmlout();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // }
        //});
    }

    public void editUser(UserDescriptor udesc) {

        User user = config.getUserByName(udesc.getId());
        user.setDescriptor(udesc);
        userCombo.getModel().setSelectedItem(user);

        try {
            config.xmlout();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addLayoutButton;
    private javax.swing.JButton editLayoutButton;
    private javax.swing.JButton editUserButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList layoutList;
    private javax.swing.JButton newUserButton;
    private javax.swing.JButton selectLayoutButton;
    private javax.swing.JComboBox userCombo;
    // End of variables declaration//GEN-END:variables

    private ComboBoxModel createUserListModel() {

        DefaultComboBoxModel model = new DefaultComboBoxModel((Vector) config.getUsers());
        return model;
    }

    private ListCellRenderer createUserListRenderer() {

        ListCellRenderer renderer = new UserListRenderer();

        return renderer;

    }

    private ListModel createLayoutListModel() {

        DefaultListModel model = new DefaultListModel();
        return model;

    }

    private ListCellRenderer createLayoutListRenderer() {
        
        ListCellRenderer renderer = new LayoutListRenderer();
        return renderer;
        
    }

    
    
    private static class UserListRenderer extends DefaultListCellRenderer {

        public UserListRenderer() {
        }

        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            JLabel l = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            User user = (User) value;
            l.setText(user.getDescriptor().getFullName());
            return this;
        }

    }

    private static class LayoutListRenderer extends DefaultListCellRenderer {

        public LayoutListRenderer() {
        }

        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            JLabel l = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            Layout layout = (Layout) value;
            l.setText(layout.getName());
            return this;
        }

    }
}
