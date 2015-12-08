
package javagui;

import WealthManagement.Asset;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class WealthManagerForm  implements WindowFocusListener, Observer {
    
    private JMenuBar mbar;
    private JMenu newFile;
    private JMenuItem bookingaccountitem,stockitem,caritem,houseitem;
    private JSeparator jSeparator1;
    private JSeparator jSeparator2;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JList jListAssets;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JTextArea jTextArea1;
    private JTextField jTextField1;
    private JTextField jTextField2;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JPanel jPanel2;
    private JPanel jPanel3;
    
    private JFrame myframe= new JFrame();
    private final int WINDOW_WIDTH = 500;
    private final int WINDOW_HEIGHT = 450;
    
    public static List<WealthManagement.Asset> assets = new Vector<Asset>();
   
    DefaultListModel model;
    
    public WealthManagerForm()
    {
        model = new DefaultListModel();
        mbar=new JMenuBar();
        myframe.setJMenuBar(mbar);
        myframe.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        newFile=new JMenu("New");
        
        jSeparator2 = new JSeparator();
        jLabel1 = new JLabel();
        jScrollPane1 = new JScrollPane();
        jListAssets = new JList(model);
        jLabel2 = new JLabel();
        jScrollPane2 = new JScrollPane();
        jTextArea1 = new JTextArea();
        jPanel1 = new JPanel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jPanel2 = new JPanel();
        jLabel5 = new JLabel();
       
        jPanel3 = new JPanel();
        jLabel6 = new JLabel(); 
        jLabel5.setBorder(BorderFactory.createLineBorder(Color.red));
        
        jSeparator1 = new javax.swing.JPopupMenu.Separator();

        myframe.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        myframe.setTitle("Wealth Manager");

        jLabel1.setText("Assets");

        jScrollPane1.setViewportView(jListAssets);

        jLabel2.setText("Asset Detail");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jLabel3.setText("Net Worth:");

        jLabel4.setText("0.00");

        jLabel5.setText("-$0.00");

        
        newFile.add(bookingaccountitem=new JMenuItem("Bank Account"));
        newFile.add(jSeparator1);
        newFile.add(stockitem=new JMenuItem("Stock"));
        newFile.add(jSeparator2);
        newFile.add(caritem=new JMenuItem("Car"));
        newFile.add(houseitem=new JMenuItem("House"));
        mbar.add(newFile);
        
        bookingaccountitem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BankAccount ba = new BankAccount();
                ba.addObserver(instance());
            }
        });
        
        stockitem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Stock ba=new Stock();
                ba.addObserver(instance());
            }
        });
        
        caritem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                CarForm ba = new CarForm();
                ba.addObserver(instance());
            }
        });
        
        houseitem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                HouseForm ba = new HouseForm();
                ba.addObserver(instance());
            }
        });

        jListAssets.addKeyListener(new KeyListener() {

            @Override
            public void keyPressed(KeyEvent e) {
                //System.out.println("Not supported yet. keyPressed");
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyTyped(KeyEvent e) {
                
                if (e.getKeyChar() == 'd') {
                    int what = JOptionPane.showConfirmDialog(myframe, "Delete ?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
                    if (what == JOptionPane.YES_OPTION) {
                        model.remove(jListAssets.getSelectedIndex());
                        jLabel4.setText("");
                        jLabel6.setText("");
                        jTextArea1.setText("");
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                  //System.out.println("Not supported yet. keyReleased");
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });
        
        jListAssets.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                //System.err.println("Not supported yet. mouseClicked");
                //throw new UnsupportedOperationException("Not supported yet. mouseClicked"); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mousePressed(MouseEvent e) {
                Asset ass = (Asset) model.get(jListAssets.getSelectedIndex());
                jTextArea1.setText(ass.toString());
                
                /*Graphics does not work */
                
                if (ass instanceof WealthManagement.Property) {
                    WealthManagement.Property p = (WealthManagement.Property) ass;
                    /*
                     if value of total asset or debt is 0, then width is 50 using ‘drawRect’
                     • else, using fillRect
                     • width of asset = ( asset total / (asset + debt) ) * panelWidth
                     • width of debt = ( debt total / (asset + debt) ) * panelWidth
                     • asset amounts are green
                     • debt amounts are red
                     */
                    int width = 50, widthAss = 0, widthDeb = 0;
                    if (p.getDebtAmount() == 0 || p.getPropertyValue() == 0) {
                      
                        jPanel3.getGraphics().drawRect(120, 250, width, 30);
                        jPanel3.repaint();
                        
                        jLabel4.setText("" + p.getPropertyValue());
                        jLabel6.setText("" + p.getDebtAmount());
                    } else {
                        widthAss = (int) (p.getPropertyValue() / (p.getAssetValue() + p.getDebtAmount()) * WINDOW_HEIGHT);
                        jPanel3.getGraphics().fillRect(20, 150, widthAss, 30);
                        jPanel3.repaint();
                        
                        widthDeb = (int) (p.getDebtAmount() / (p.getAssetValue() + p.getDebtAmount()) * WINDOW_HEIGHT);
                       jPanel3.getGraphics().fillRect(20, 150, widthDeb, 30);
                       jPanel3.repaint();
                        jLabel4.setText("" + p.getPropertyValue());
                        jLabel6.setText("" + p.getDebtAmount());
                    }
                } else {
                    jLabel4.setText("" + ass.getAssetValue());
                    jLabel6.setText("" + ass.getAssetValue());
                }

                
              

                // throw new UnsupportedOperationException("Not supported yet. mousePressed"); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent e) {
               //System.err.println("Not supported yet. mouseReleased");
                //throw new UnsupportedOperationException("Not supported yet. mouseReleased"); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                //System.err.println("Not supported yet. mouseEntered");
                //throw new UnsupportedOperationException("Not supported yet. mouseEntered"); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent e) {
                  //System.err.println("Not supported yet. mouseExited");
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
        jListAssets.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                System.out.println("Not supported yet. valueChanged");
                //throw new UnsupportedOperationException("Not supported yet. valueChanged"); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5))
        );

        jLabel6.setText("$0.00");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(myframe.getContentPane());
        myframe.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(109, 109, 109)
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addGap(11, 11, 11)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        myframe.setVisible(true);
    }
    
     public void windowGainedFocus(WindowEvent e) {
        System.err.println("WindowFocusListener method called: windowGainedFocus.");
         
         if(!assets.isEmpty())
         {
             for(WealthManagement.Asset string : assets) {
                 model.addElement(string);
             }
         }
         
    }

    public void windowLostFocus(WindowEvent e) {
        System.err.println("WindowFocusListener method called: windowLostFocus.");
    }
    
    public void windowClosing(WindowEvent e) {
    
        myframe.dispose();
    }
    
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(WealthManagerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WealthManagerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WealthManagerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WealthManagerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       
    }

    private WealthManagerForm instance() {
        return this;
    }
    
    @Override
    public void update(Observable o, Object arg) {
        Asset ass = (Asset) arg;
        model.addElement(ass);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
