/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ngat.opsgui.login;

import java.awt.Component;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.List;
import javax.swing.DropMode;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTree;
import javax.swing.TransferHandler;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

/**
 *
 * @author eng
 */
public class LayoutDetailsPanel extends javax.swing.JPanel {

    private DefaultTreeModel ltm;

    private DefaultMutableTreeNode root;

    TransferHandler th;

    /**
     * Creates new form LayoutDetailsPanel
     */
    public LayoutDetailsPanel() {
        initComponents();

        testButton.setTransferHandler(new TransferHandler("text"));
    testButton1.setTransferHandler(new TransferHandler("text"));
    testButton2.setTransferHandler(new TransferHandler("text"));
    layoutTree.setTransferHandler(th);
    layoutTree.setDropMode(DropMode.INSERT);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        layoutTree = createLayoutTree();
        createTransferHandler();
        jPanel1 = new javax.swing.JPanel();
        testButton = new javax.swing.JButton();
        testButton1 = new javax.swing.JButton();
        testButton2 = new javax.swing.JButton();

        jLabel1.setText("Name");

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        layoutTree.setModel(createLayoutTreeModel());
        layoutTree.setCellRenderer(createLayoutRenderer());
        layoutTree.setDropMode(javax.swing.DropMode.INSERT);
        jScrollPane1.setViewportView(layoutTree);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        testButton.setText("XYZ");
        testButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                testButtonSelected(evt);
            }
        });

        testButton1.setText("ABC");
        testButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                testButton1Selected(evt);
            }
        });

        testButton2.setText("QZX");
        testButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                testButton2Selected(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(testButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(testButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(testButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(testButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(testButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(testButton2)
                .addContainerGap(180, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void testButtonSelected(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_testButtonSelected

        JButton button = (JButton) evt.getSource();
        TransferHandler handle = button.getTransferHandler();
        handle.exportAsDrag(button, evt, TransferHandler.COPY);
        System.err.println("Enabled drag event on button: "+button.getText());
    }//GEN-LAST:event_testButtonSelected

    private void testButton1Selected(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_testButton1Selected
        JButton button = (JButton) evt.getSource();
        TransferHandler handle = button.getTransferHandler();
        handle.exportAsDrag(button, evt, TransferHandler.COPY);
        System.err.println("Enabled drag event on button: "+button.getText());
    }//GEN-LAST:event_testButton1Selected

    private void testButton2Selected(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_testButton2Selected
        JButton button = (JButton) evt.getSource();
        TransferHandler handle = button.getTransferHandler();
        handle.exportAsDrag(button, evt, TransferHandler.COPY);
        System.err.println("Enabled drag event on button: "+button.getText());
    }//GEN-LAST:event_testButton2Selected


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTree layoutTree;
    private javax.swing.JButton testButton;
    private javax.swing.JButton testButton1;
    private javax.swing.JButton testButton2;
    // End of variables declaration//GEN-END:variables

    public void editLayouts(User user) {
        DefaultMutableTreeNode myroot = createTree(user);
        ltm.setRoot(myroot);
    }

    private DefaultMutableTreeNode createTree(User user) {

        DefaultMutableTreeNode node = new DefaultMutableTreeNode(user);

        List<Layout> layouts = user.getLayouts();
        for (int il = 0; il < layouts.size(); il++) {

            Layout l = layouts.get(il);

            DefaultMutableTreeNode lnode = new DefaultMutableTreeNode(l);
            node.add(lnode);

            List<Display> displays = l.getDisplays();
            for (int id = 0; id < displays.size(); id++) {

                Display d = displays.get(id);

                DefaultMutableTreeNode dnode = new DefaultMutableTreeNode(d);
                lnode.add(dnode);
                System.err.println("add display: " + d);
                List<String> perspectives = d.getPerspectiveNames();
                for (int ip = 0; ip < perspectives.size(); ip++) {

                    String p = perspectives.get(ip);

                    DefaultMutableTreeNode pnode = new DefaultMutableTreeNode(p);
                    dnode.add(pnode);
                    System.err.println("add perspective: " + p);
                }

            }
        }

        return node;

    }

    private JTree createLayoutTree() {
        System.err.println("Creating a tree using: STM: " + ltm);
        JTree tree = new JTree(ltm);
        th = new LayoutTreeTransferHandler();
        tree.setTransferHandler(th);
        System.err.println("Set th to: " + th);
        return tree;

    }

    private TreeModel createLayoutTreeModel() {
        root = new DefaultMutableTreeNode("root");
        ltm = new DefaultTreeModel(root);

        System.err.println("Created LTM: " + ltm);
        return ltm;

    }

    private TreeCellRenderer createLayoutRenderer() {

        LayoutRenderer renderer = new LayoutRenderer();
        return renderer;
    }

    private TransferHandler createTransferHandler() {

        LayoutTreeTransferHandler th = new LayoutTreeTransferHandler();

        return th;

    }

    private class LayoutTreeTransferHandler extends TransferHandler {

        @Override
        public boolean canImport(TransferHandler.TransferSupport support) {
            System.err.println("canimport...");
            DataFlavor[] flavprs = support.getDataFlavors();
            for (int i = 0; i < flavprs.length; i++) {
                System.err.println("Flav: " + flavprs[i].getHumanPresentableName() + "," + flavprs[i].getMimeType());
            }

            //if (!support.  new DataFlavor(DataFlavor.javaJVMLocalObjectMimeType)) {
           
              //  System.err.println("Not a stringflavor, return: false");
               // return false;
           // }
            if (!support.isDrop()) {
                System.err.println("Not a drop: return false");
                return false;
            }

            JTree.DropLocation dropLocation
                    = (JTree.DropLocation) support.getDropLocation();

            System.err.println("Found drop location: " + dropLocation.toString());
            return dropLocation.getPath() != null;
        }

        @Override
        public boolean importData(TransferHandler.TransferSupport support) {
            System.err.println("importdata: " + support);
            if (!canImport(support)) {
                return false;
            }

            JTree.DropLocation dropLocation
                    = (JTree.DropLocation) support.getDropLocation();

            TreePath path = dropLocation.getPath();

            Transferable transferable = support.getTransferable();

            String transferData;
            try {
                transferData = (String) transferable.getTransferData(
                        DataFlavor.stringFlavor);
            } catch (IOException e) {
                return false;
            } catch (UnsupportedFlavorException e) {
                return false;
            }

            int childIndex = dropLocation.getChildIndex();
            if (childIndex == -1) {
                childIndex = ltm.getChildCount(path.getLastPathComponent());
            }

            DefaultMutableTreeNode newNode
                    = new DefaultMutableTreeNode(transferData);
            DefaultMutableTreeNode parentNode
                    = (DefaultMutableTreeNode) path.getLastPathComponent();
            ltm.insertNodeInto(newNode, parentNode, childIndex);

            TreePath newPath = path.pathByAddingChild(newNode);
            layoutTree.makeVisible(newPath);
            layoutTree.scrollRectToVisible(layoutTree.getPathBounds(newPath));

            return true;
        }
    }

    private static class LayoutRenderer extends DefaultTreeCellRenderer {

        @Override
        public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
            super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);

            DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;

            Object uo = node.getUserObject();

            if (uo instanceof User) {
                User user = (User) uo;
                setText(user.getDescriptor().getId());
            } else if (uo instanceof Layout) {

                Layout layout = (Layout) uo;
                setText(layout.getName());
            } else if (uo instanceof Display) {
                Display display = (Display) uo;
                setText(display.getName());

            } else if (uo instanceof String) {
                String string = (String) uo;
                setText(string);

            } else {
                setText(uo.toString());
            }

            return this;
        }
    }
}
