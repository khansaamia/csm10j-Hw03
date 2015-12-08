
package javagui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class HouseForm extends AssetForm{
   
    private JButton cancelBtnLable;
    private JButton saveBtnLable;
    private JComboBox jComboBox1;
    private JLabel typeLabel;
    private JLabel nameLabel;
    private JLabel valueLabel;
    private JLabel debtLable;
    private JTextField jTextField2;
    private JTextField jTextField3;
    private JTextField jTextField4;
      private JFrame myframe= new JFrame();
    public HouseForm()
    {
        super();
        myframe.setTitle("House");
        myframe.setSize(300, 250);
        typeLabel = new JLabel();
        nameLabel = new JLabel();
        jTextField2 = new JTextField();
        cancelBtnLable = new JButton();
        saveBtnLable = new JButton();
        jTextField3 = new JTextField();
        valueLabel = new JLabel();
        jTextField4 = new JTextField();
        debtLable = new JLabel();
        jComboBox1 = new JComboBox();

        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        typeLabel.setText("Type");

        nameLabel.setText("Name");

        cancelBtnLable.setText("Cancel");

        saveBtnLable.setText("Save");

        valueLabel.setText("Value");

        debtLable.setText("Debt");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Car", "House" }));

        jComboBox1.setSelectedIndex(1);
        jComboBox1.setEnabled(true);
        
        cancelBtnLable.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                myframe.dispose();
            }
        });
        
        saveBtnLable.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

               double d3 = 0.0, d4 = 0.0;
                try {
                    d3 = Double.parseDouble(jTextField3.getText());
                } catch (NumberFormatException n) {
                    JOptionPane.showMessageDialog(myframe, "The value of Value\n" + jTextField3.getText() + "\nis not a number!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    d4 = Double.parseDouble(jTextField4.getText());
                } catch (NumberFormatException n) {
                    JOptionPane.showMessageDialog(myframe, "The value of Debt\n" + jTextField4.getText() + "\nis not a number!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                WealthManagement.Asset assetObject = new WealthManagement.House(jTextField2.getText().toString(), d3, d4);
                assets.add(assetObject);
                notifyObservers(assetObject);
                myframe.dispose();
            }
        });
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(myframe.getContentPane());
        myframe.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cancelBtnLable)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(saveBtnLable))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(debtLable)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(valueLabel)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nameLabel)
                                    .addComponent(typeLabel))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 21, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typeLabel)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(valueLabel)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(debtLable)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelBtnLable)
                    .addComponent(saveBtnLable))
                .addGap(19, 19, 19))
        );
        myframe.setVisible(true);
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
    
    
}
