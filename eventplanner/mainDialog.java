
package eventplanner;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

 
public class mainDialog extends javax.swing.JDialog {

   
    
public static eventTableModel tableModel = new eventTableModel();
public static boolean muted = false; // nu este MUTE  


String saveFileName = "";

File f = null;
FileInputStream fis = null;
FileOutputStream  fos = null;
ObjectInputStream ois = null;
ObjectOutputStream oos = null;

   
    public mainDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    
        
     Timer t = new Timer(10000, new  ActionListener() { //timer 10 secunde
          @Override
          public void actionPerformed(ActionEvent e) {
              compareTime();
          };
      });
      
      t.start();   
        
        
    }
   
    
    public void playSound(){
    
    if (muted)
        return;         
    try
     {
        InputStream inputStream = getClass().getResourceAsStream("alarm.au");
        AudioStream audioStream = new AudioStream(inputStream);     
        
        AudioPlayer.player.start(audioStream);
      }
      catch (Exception e)
      {
       JOptionPane.showMessageDialog(this,"Nu se poate reda audio !");
      } 
    }
   
    void compareTime(){
        
     SimpleDateFormat sdfDate = new SimpleDateFormat("MM:dd:HH:mm");//dd/MM/yyyy
     Date now = new Date();
     String strDate = sdfDate.format(now);
     
     String[] timeParts = strDate.split(":");
     
     String month=timeParts[0];
     String day=timeParts[1];
     String hour=timeParts[2];
     String min=timeParts[3];
     
    for (event e : mainDialog.tableModel.lista) {
      if (e.getStatus().equals("DA"))
      if ( month.equals(e.getMonth()) && day.equals(e.getDay()) && hour.equals(e.getHour()) && min.equals(e.getMinute())) 
         {
          playSound();
          JOptionPane.showConfirmDialog(this, "Eveniment : " + e.getDescription(), "Alarma eveniment", JOptionPane.PLAIN_MESSAGE, JOptionPane.INFORMATION_MESSAGE);
          e.setStatus("NU");
          tableModel.fireTableDataChanged();
         }
        }
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JFO = new javax.swing.JFileChooser();
        JFS = new javax.swing.JFileChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelEvenimente = new javax.swing.JTable();
        btnAdaugare = new javax.swing.JButton();
        btnModificare = new javax.swing.JButton();
        btnStergere = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btnMute = new javax.swing.JButton();
        btnSalvare = new javax.swing.JButton();
        btnIncarcare = new javax.swing.JButton();
        btnDisableAll = new javax.swing.JButton();

        JFO.setDialogTitle("Deschidere lista evenimente");

        JFS.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);
        JFS.setDialogTitle("Salvare lista evenimente");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Event Planner");
        setBounds(new java.awt.Rectangle(300, 300, 600, 250));
        setResizable(false);
        getContentPane().setLayout(null);

        tabelEvenimente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tabelEvenimente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data si ora", "Descriere", "Activ"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabelEvenimente.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        tabelEvenimente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelEvenimenteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelEvenimente);
        tabelEvenimente.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 10, 640, 150);

        btnAdaugare.setText("Adaugare");
        btnAdaugare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdaugareActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdaugare);
        btnAdaugare.setBounds(10, 170, 150, 30);

        btnModificare.setText("Modificare");
        btnModificare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificareActionPerformed(evt);
            }
        });
        getContentPane().add(btnModificare);
        btnModificare.setBounds(180, 170, 150, 30);

        btnStergere.setText("Stergere");
        btnStergere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStergereActionPerformed(evt);
            }
        });
        getContentPane().add(btnStergere);
        btnStergere.setBounds(340, 170, 150, 30);

        jButton4.setText("Inchidere aplicatie");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(500, 220, 150, 30);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(10, 210, 640, 10);

        btnMute.setText("Dezactivare sunet");
        btnMute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMuteActionPerformed(evt);
            }
        });
        getContentPane().add(btnMute);
        btnMute.setBounds(340, 220, 150, 30);

        btnSalvare.setText("Salvare lista");
        btnSalvare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvareActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalvare);
        btnSalvare.setBounds(10, 220, 150, 30);

        btnIncarcare.setText("Incarcare lista");
        btnIncarcare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncarcareActionPerformed(evt);
            }
        });
        getContentPane().add(btnIncarcare);
        btnIncarcare.setBounds(180, 220, 150, 30);

        btnDisableAll.setText("Dezactiveaza toate");
        btnDisableAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisableAllActionPerformed(evt);
            }
        });
        getContentPane().add(btnDisableAll);
        btnDisableAll.setBounds(500, 170, 150, 30);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnStergereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStergereActionPerformed
        int i = tabelEvenimente.getSelectedRow();
        if (i < 0)
           return;
       if (JOptionPane.showConfirmDialog(this, "Stergeti evenimentul selectat ?", "Atentie", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.OK_OPTION)
       {
           tableModel.lista.remove(i);
           tableModel.fireTableDataChanged();
       }
    }//GEN-LAST:event_btnStergereActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
                
        System.exit(0);        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnSalvareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvareActionPerformed
     if (tableModel.lista.isEmpty())
     {
       JOptionPane.showConfirmDialog(this, "Lista este goala", "Salvare", JOptionPane.PLAIN_MESSAGE, JOptionPane.WARNING_MESSAGE);
       return;
     }
        
       saveFileName = "asav.jav";
        
            try {
                fos = new FileOutputStream(saveFileName); // se considera ca s-a mai salvat anterior ...
                oos = new ObjectOutputStream(fos);
                oos.writeObject(tabelEvenimente.getModel());// java.io.NotSerializableException

                oos.close();
                JOptionPane.showConfirmDialog(this, "Lista s-a salvat", "Salvare", JOptionPane.PLAIN_MESSAGE, JOptionPane.INFORMATION_MESSAGE);
             

             } catch (IOException ex) {
                System.err.println("Eroare IO salvare");
               }

        
        
        
    }//GEN-LAST:event_btnSalvareActionPerformed

    private void btnIncarcareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncarcareActionPerformed
        
            String openFileName = "asav.jav";
            try {
                fis = new FileInputStream(openFileName);
                ois = new ObjectInputStream(fis);
                
                eventTableModel c = (eventTableModel)ois.readObject();
               
                tabelEvenimente.setModel(c);
                tableModel = c;
                tableModel.fireTableDataChanged();

                
                ois.close();
                fis.close();
                
            } catch (ClassNotFoundException ex) {
                System.err.println("Class not found");
            } 
            
            catch (IOException ex) {
                System.err.println("IO error incarcare");
            }
       

    }//GEN-LAST:event_btnIncarcareActionPerformed

    private void btnAdaugareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdaugareActionPerformed
     createModifyWindow cm = new createModifyWindow(null, rootPaneCheckingEnabled, -1); // -1 = new event; altceva = modify elementul resepctiv din lista
     cm.setTitle("Adaugare eveniment");
     cm.setVisible(true);
     tabelEvenimente.setModel(tableModel);
     
        
    }//GEN-LAST:event_btnAdaugareActionPerformed

    private void btnDisableAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisableAllActionPerformed
       // String timeStamp = new SimpleDateFormat("dd/MM/yyyy_HH:mm").format(Calendar.getInstance().getTime());
       // JOptionPane.showConfirmDialog(this, timeStamp);
       for (int i = 0; i < tableModel.lista.size(); i++) 
           tableModel.lista.get(i).active = "NU";
       mainDialog.tableModel.fireTableDataChanged();
        
    }//GEN-LAST:event_btnDisableAllActionPerformed

    private void btnModificareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificareActionPerformed
     
     int i = tabelEvenimente.getSelectedRow();
     if (i <0)
         return;
     createModifyWindow cm = new createModifyWindow(null, rootPaneCheckingEnabled, i);
     cm.setTitle("Modificare eveniment");
     cm.setVisible(true);
            
    }//GEN-LAST:event_btnModificareActionPerformed

    private void tabelEvenimenteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelEvenimenteMouseClicked
        if (evt.getClickCount() == 2) 
            btnModificareActionPerformed(null);
    }//GEN-LAST:event_tabelEvenimenteMouseClicked

    
    
    private void btnMuteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMuteActionPerformed
    
        muted = !muted;
        if (muted)
            btnMute.setText("Activare sunet");
        else
            btnMute.setText("Dezactivare sunet");
    }//GEN-LAST:event_btnMuteActionPerformed

   
   private void setupWindow(){
       tabelEvenimente.getColumnModel().getColumn(0).setPreferredWidth(150);
       tabelEvenimente.getColumnModel().getColumn(1).setPreferredWidth(300);
       
   }
    public static void main(String args[]) {
       
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Motif".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(mainDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

       
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                mainDialog dialog = new mainDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                
                dialog.setBounds(300, 300, 670, 280);
                
                Toolkit toolkit = Toolkit.getDefaultToolkit();
                Dimension screenSize = toolkit.getScreenSize();
                int iWidth = (screenSize.width - dialog.getWidth()) / 2;
                int iHeight = (screenSize.height - dialog.getHeight()) / 2;
   
                dialog.setLocation(iWidth, iHeight);

                dialog.setupWindow();
                dialog.setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser JFO;
    private javax.swing.JFileChooser JFS;
    private javax.swing.JButton btnAdaugare;
    private javax.swing.JButton btnDisableAll;
    private javax.swing.JButton btnIncarcare;
    private javax.swing.JButton btnModificare;
    private javax.swing.JButton btnMute;
    private javax.swing.JButton btnSalvare;
    private javax.swing.JButton btnStergere;
    private javax.swing.JButton jButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tabelEvenimente;
    // End of variables declaration//GEN-END:variables
}
