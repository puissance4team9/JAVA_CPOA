/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm;


import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import metier.Evenement;

/**
 *
 * @author p1406759
 */
public class FenetreSaisieDivorce extends javax.swing.JDialog {

    /**
     * Creates new form NewJDialog
     */
    private Evenement Event;
    private boolean etatSortie;
    
    public FenetreSaisieDivorce(java.awt.Frame parent, Evenement Event) {
        super(parent, true);
        this.Event = Event;
        etatSortie = false;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbDateDivorce = new javax.swing.JLabel();
        lbTitre = new javax.swing.JLabel();
        btValiderDivorce = new javax.swing.JButton();
        txDateDivorce = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lbDateDivorce.setText("Date de Divorce");

        lbTitre.setText("Défaire une Union ");

        btValiderDivorce.setText("Valider");
        btValiderDivorce.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btValiderDivorceActionPerformed(evt);
            }
        });

        txDateDivorce.setDateFormatString("d-MM-yyyy");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(139, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTitre)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btValiderDivorce)
                        .addGap(10, 10, 10)))
                .addGap(137, 137, 137))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(lbDateDivorce)
                .addGap(18, 18, 18)
                .addComponent(txDateDivorce, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lbTitre)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbDateDivorce)
                    .addComponent(txDateDivorce, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(btValiderDivorce)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btValiderDivorceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btValiderDivorceActionPerformed
          // TODO add your handling code here:
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
           
           if (txDateDivorce.getDate()==null) {
                throw new Exception("champ date de naissance vide");
            }
            Event.setDateDivorce(Date.valueOf(format.format(txDateDivorce.getDate())));
            
            etatSortie = true;
            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erreur", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btValiderDivorceActionPerformed
    
    public boolean doModal() {
        setVisible(true);
        return etatSortie;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btValiderDivorce;
    private javax.swing.JLabel lbDateDivorce;
    private javax.swing.JLabel lbTitre;
    private com.toedter.calendar.JDateChooser txDateDivorce;
    // End of variables declaration//GEN-END:variables
}
