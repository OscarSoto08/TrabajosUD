/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author Estudiante
 */
public class Ventana1 extends javax.swing.JFrame {

    /**
     * Creates new form Ventana1
     */
    public Ventana1() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        respuestas = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        TxtPregunta = new javax.swing.JLabel();
        rbresp3 = new javax.swing.JRadioButton();
        rbresp1 = new javax.swing.JRadioButton();
        rbresp4 = new javax.swing.JRadioButton();
        rbresp2 = new javax.swing.JRadioButton();
        Opciones = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TxtPregunta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TxtPregunta.setText("Preguntaaa");
        TxtPregunta.setToolTipText("");
        TxtPregunta.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        rbresp3.setText("jRadioButton3");
        rbresp3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbresp3ActionPerformed(evt);
            }
        });

        rbresp1.setText("jRadioButton1");
        rbresp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbresp1ActionPerformed(evt);
            }
        });

        rbresp4.setText("jRadioButton3");

        rbresp2.setText("jRadioButton4");

        Opciones.setText("jButton1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbresp1)
                    .addComponent(rbresp3))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rbresp2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(rbresp4)
                        .addContainerGap(101, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Opciones)
                .addContainerGap())
            .addComponent(TxtPregunta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(Opciones)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addComponent(TxtPregunta)
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbresp1)
                    .addComponent(rbresp2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbresp3)
                    .addComponent(rbresp4))
                .addGap(64, 64, 64))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbresp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbresp1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbresp1ActionPerformed

    private void rbresp3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbresp3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbresp3ActionPerformed

    public JRadioButton getRbresp1() {
        return rbresp1;
    }

    public void setRbresp1(JRadioButton rbresp1) {
        this.rbresp1 = rbresp1;
    }

    public JRadioButton getRbresp2() {
        return rbresp2;
    }

    public void setRbresp2(JRadioButton rbresp2) {
        this.rbresp2 = rbresp2;
    }

    public JRadioButton getRbresp3() {
        return rbresp3;
    }

    public void setRbresp3(JRadioButton rbresp3) {
        this.rbresp3 = rbresp3;
    }

    public ButtonGroup getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(ButtonGroup respuestas) {
        this.respuestas = respuestas;
    }

    public JRadioButton getRbresp4() {
        return rbresp4;
    }

    public void setRbresp4(JRadioButton rbresp4) {
        this.rbresp4 = rbresp4;
    }

    public JLabel getTxtPregunta() {
        return TxtPregunta;
    }

    public void setTxtPregunta(JLabel TxtPregunta) {
        this.TxtPregunta = TxtPregunta;
    }

    public JButton getOpciones() {
        return Opciones;
    }

    public void setOpciones(JButton Opciones) {
        this.Opciones = Opciones;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Opciones;
    private javax.swing.JLabel TxtPregunta;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton rbresp1;
    private javax.swing.JRadioButton rbresp2;
    private javax.swing.JRadioButton rbresp3;
    private javax.swing.JRadioButton rbresp4;
    private javax.swing.ButtonGroup respuestas;
    // End of variables declaration//GEN-END:variables
}
