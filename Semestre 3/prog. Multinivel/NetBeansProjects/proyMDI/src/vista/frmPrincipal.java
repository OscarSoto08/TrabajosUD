/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/MDIApplication.java to edit this template
 */
package vista;

import javax.swing.JDesktopPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

/**
 *
 * @author FAMILIA
 */
public class frmPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form frmPrincipal
     */
    public frmPrincipal() {
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

        escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        opcSuma = new javax.swing.JMenuItem();
        opcResta = new javax.swing.JMenuItem();
        opcPotencia = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        opcSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Operaciones matemáticas");
        setIconImages(null);

        escritorio.setPreferredSize(new java.awt.Dimension(800, 600));

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 765, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 437, Short.MAX_VALUE)
        );

        jMenuBar1.setFont(new java.awt.Font("Times New Roman", 3, 16)); // NOI18N

        jMenu1.setText("Archivo");
        jMenu1.setFont(new java.awt.Font("Times New Roman", 3, 16)); // NOI18N

        opcSuma.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        opcSuma.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        opcSuma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/plus.png"))); // NOI18N
        opcSuma.setText("Suma");
        jMenu1.add(opcSuma);

        opcResta.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        opcResta.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        opcResta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/minus.png"))); // NOI18N
        opcResta.setText("Resta");
        jMenu1.add(opcResta);

        opcPotencia.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        opcPotencia.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        opcPotencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/power.png"))); // NOI18N
        opcPotencia.setText("Potencia");
        jMenu1.add(opcPotencia);
        jMenu1.add(jSeparator1);

        opcSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        opcSalir.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        opcSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/back.png"))); // NOI18N
        opcSalir.setText("Salir");
        opcSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcSalirActionPerformed(evt);
            }
        });
        jMenu1.add(opcSalir);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 765, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void opcSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcSalirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opcSalirActionPerformed

    public JDesktopPane getEscritorio() {
        return escritorio;
    }

    public void setEscritorio(JDesktopPane escritorio) {
        this.escritorio = escritorio;
    }

    public JMenu getjMenu1() {
        return jMenu1;
    }

    public void setjMenu1(JMenu jMenu1) {
        this.jMenu1 = jMenu1;
    }

    public JMenuBar getjMenuBar1() {
        return jMenuBar1;
    }

    public void setjMenuBar1(JMenuBar jMenuBar1) {
        this.jMenuBar1 = jMenuBar1;
    }

    public JPopupMenu.Separator getjSeparator1() {
        return jSeparator1;
    }

    public void setjSeparator1(JPopupMenu.Separator jSeparator1) {
        this.jSeparator1 = jSeparator1;
    }

    public JMenuItem getOpcPotencia() {
        return opcPotencia;
    }

    public void setOpcPotencia(JMenuItem opcPotencia) {
        this.opcPotencia = opcPotencia;
    }

    public JMenuItem getOpcSalir() {
        return opcSalir;
    }

    public void setOpcSalir(JMenuItem opcSalir) {
        this.opcSalir = opcSalir;
    }

    public JMenuItem getOpcSuma() {
        return opcSuma;
    }

    public void setOpcSuma(JMenuItem opcSuma) {
        this.opcSuma = opcSuma;
    }

    public JMenuItem getOpcResta() {
        return opcResta;
    }

    public void setOpcResta(JMenuItem opcResta) {
        this.opcResta = opcResta;
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuItem opcPotencia;
    private javax.swing.JMenuItem opcResta;
    private javax.swing.JMenuItem opcSalir;
    private javax.swing.JMenuItem opcSuma;
    // End of variables declaration//GEN-END:variables

}
