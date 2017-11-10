
package eventplanner;

import java.awt.Dimension;
import java.awt.Toolkit;



public final class createModifyWindow extends javax.swing.JDialog {
    
    int dialogAction; // create /modify
    static event dialogEvent = new event("",""); // evenimentul care se creeaza/modifica
    
    public createModifyWindow(java.awt.Frame parent, boolean modal, int rowIndex) { // rowidex = -1 => creare
        super(parent, modal);
        initComponents();
        
        
      this.setSize(430, 150);
      final Toolkit toolkit = Toolkit.getDefaultToolkit();
      final Dimension screenSize = toolkit.getScreenSize();
      final int x = (screenSize.width - this.getWidth()) / 2;
      final int y = (screenSize.height - this.getHeight()) / 2;
      this.setLocation(x, y);
     
      
      dialogAction = rowIndex;
      setupWindow();
      
    }
    
    
    
    
        
    void setupWindow(){
      int i;
      
      String s;
      for (i=1; i<=9; i++){
           s = '0' + Integer.toString(i);
           lstData.addItem(s);
      }
      for (i=10; i<=31; i++){
           s = Integer.toString(i);
           lstData.addItem(s);
      }
      
      // lunile
      for (i=1; i<=9; i++){
           s = '0' + Integer.toString(i);
           lstLuna.addItem(s);
      }
      
      lstLuna.addItem("10");
      lstLuna.addItem("11");
      lstLuna.addItem("12");
      
      
      
      for (i=0; i<=9; i++){
           s = '0' + Integer.toString(i);
           lstOra.addItem(s);
      }
      for (i=10; i<=23; i++){
           s = Integer.toString(i);
           lstOra.addItem(s);
      }
      
       for (i=0; i<=9; i++){
           s = '0' + Integer.toString(i);
           lstMinut.addItem(s);
      }
      for (i=10; i<=59; i++){
           s = Integer.toString(i);
           lstMinut.addItem(s);
      }
      
    if (dialogAction > -1)
    {
        dialogEvent = mainDialog.tableModel.lista.get(dialogAction);
        setValues(dialogEvent);
    };
      
    }

   public void setValues(event e){

    if (dialogAction < 0)
        return;
      String dateTime = dialogEvent.getDate();

      String day = "";
      String month= "";
      String hour="";
      String minute = "";
       if (dateTime != "")
         {
          String[] parts = dateTime.split(":");
          day = parts[0];
          month = parts[1];
          hour = parts[2];
          minute = parts[3];
         }

       int i;
        for (i = 0; i<lstData.getItemCount(); i++)
            if (lstData.getItemAt(i).toString().endsWith(day))
                lstData.setSelectedIndex(i);
       
        for (i = 0; i<lstLuna.getItemCount(); i++)
            if (lstLuna.getItemAt(i).toString().endsWith(month))
                lstLuna.setSelectedIndex(i);
        
        for (i = 0; i<lstOra.getItemCount(); i++)
            if (lstOra.getItemAt(i).toString().endsWith(hour))
                lstOra.setSelectedIndex(i);
        
        for (i = 0; i<lstMinut.getItemCount(); i++)
            if (lstMinut.getItemAt(i).toString().endsWith(minute))
                lstMinut.setSelectedIndex(i);
      
        
        if ("DA".equals(e.getStatus()))
            cbActiv.setSelected(true);
        else
            cbActiv.setSelected(false);
        
        txtDescriere.setText(e.getDescription());
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lstLuna = new javax.swing.JComboBox();
        lstData = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        txtDescriere = new javax.swing.JTextField();
        lstOra = new javax.swing.JComboBox();
        lstMinut = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        btnOK = new javax.swing.JButton();
        cbActiv = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Creare / Modificare eveniment");
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setText("Data si ora eveniment : ");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(6, 14, 140, 14);

        getContentPane().add(lstLuna);
        lstLuna.setBounds(210, 10, 50, 22);

        getContentPane().add(lstData);
        lstData.setBounds(150, 10, 50, 22);

        jLabel2.setText("Descriere eveniment : ");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(6, 53, 140, 14);

        txtDescriere.setText("Descriere Alarma");
        getContentPane().add(txtDescriere);
        txtDescriere.setBounds(150, 50, 240, 20);

        getContentPane().add(lstOra);
        lstOra.setBounds(280, 10, 50, 22);

        getContentPane().add(lstMinut);
        lstMinut.setBounds(343, 10, 50, 22);

        jButton1.setText("Cancel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(310, 80, 80, 30);

        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });
        getContentPane().add(btnOK);
        btnOK.setBounds(220, 80, 80, 30);

        cbActiv.setSelected(true);
        cbActiv.setText("Activ");
        getContentPane().add(cbActiv);
        cbActiv.setBounds(150, 80, 60, 23);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel3.setText(":");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(334, 15, 3, 13);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("/");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(200, 10, 8, 17);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    public event getValues(){
        
        String dt = lstData.getSelectedItem().toString() + ":" + lstLuna.getSelectedItem().toString() + ":";
        dt = dt + lstOra.getSelectedItem().toString() + ':' + lstMinut.getSelectedItem().toString();
        
        
        if (cbActiv.isSelected())
            dt = dt + ":" + "DA";
        else
            dt = dt + ":" + "NU";
      
        event e = new event(dt,txtDescriere.getText());
      return e;
    }
    
    
    
    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        
        if (dialogAction == -1){ //creare
          mainDialog.tableModel.lista.add(getValues());
          mainDialog.tableModel.fireTableDataChanged();
        }   
        else
        {
          event e = mainDialog.tableModel.lista.get(dialogAction);
            
          String dt = lstData.getSelectedItem().toString() + ":" + lstLuna.getSelectedItem().toString() + ":";
          dt = dt + lstOra.getSelectedItem().toString() + ':' + lstMinut.getSelectedItem().toString();
        
          if (cbActiv.isSelected())
            dt = dt + ":" + "DA";
          else
           dt = dt + ":" + "NU";
            
            
            e.setDate(dt);
            e.setDescription(txtDescriere.getText());
            
            mainDialog.tableModel.fireTableDataChanged();
        }   
        
       this.dispose();
       
       
    }//GEN-LAST:event_btnOKActionPerformed


    public static void main(String args[]) {
      
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOK;
    private javax.swing.JCheckBox cbActiv;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JComboBox lstData;
    private javax.swing.JComboBox lstLuna;
    private javax.swing.JComboBox lstMinut;
    private javax.swing.JComboBox lstOra;
    private javax.swing.JTextField txtDescriere;
    // End of variables declaration//GEN-END:variables
}
