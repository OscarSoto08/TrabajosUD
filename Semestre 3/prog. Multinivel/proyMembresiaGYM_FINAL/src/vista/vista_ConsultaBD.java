/**
 * @author Daniel López Valderrama
 * @author Oscar Gonzalez Soto
 */
package vista;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author FAMILIA
 */
public class vista_ConsultaBD extends javax.swing.JInternalFrame {

    /**
     * Creates new form JIFrmConsulta
     */
    public vista_ConsultaBD() {
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

        btnBuscar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDatos_Fact = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblDatos_Clientes = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblDatos_Membresias = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 102));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        btnBuscar.setBackground(new java.awt.Color(102, 204, 255));
        btnBuscar.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        tblDatos_Fact.setBackground(new java.awt.Color(204, 204, 204));
        tblDatos_Fact.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        tblDatos_Fact.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Fecha Factura", "Nombre Propietario", "Tipo Membresia"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblDatos_Fact);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel3.setText("Facturas:");

        tblDatos_Clientes.setBackground(new java.awt.Color(204, 204, 204));
        tblDatos_Clientes.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        tblDatos_Clientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id_Cliente", "Ciudad", "Correo", "Telefono", "Fecha_Nac"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tblDatos_Clientes);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel4.setText("Clientes:");

        tblDatos_Membresias.setBackground(new java.awt.Color(204, 204, 204));
        tblDatos_Membresias.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        tblDatos_Membresias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id_Membresia", "Valor_Pago"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tblDatos_Membresias);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel5.setText("Membresias:");

        btnEliminar.setBackground(new java.awt.Color(102, 204, 255));
        btnEliminar.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnActualizar.setBackground(new java.awt.Color(102, 204, 255));
        btnActualizar.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        btnActualizar.setText("ACTUALIZAR");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(85, 85, 85)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActualizarActionPerformed

    /**
     *
     * @return
     */
    public JButton getBtnActualizar() {
        return btnActualizar;
    }

    /**
     *
     * @param btnActualizar
     */
    public void setBtnActualizar(JButton btnActualizar) {
        this.btnActualizar = btnActualizar;
    }

    /**
     *
     * @return
     */
    public JButton getBtnBuscar() {
        return btnBuscar;
    }

    /**
     *
     * @param btnBuscar
     */
    public void setBtnBuscar(JButton btnBuscar) {
        this.btnBuscar = btnBuscar;
    }

    /**
     *
     * @return
     */
    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    /**
     *
     * @param btnEliminar
     */
    public void setBtnEliminar(JButton btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

    /**
     *
     * @return
     */
    public JLabel getjLabel3() {
        return jLabel3;
    }

    /**
     *
     * @param jLabel3
     */
    public void setjLabel3(JLabel jLabel3) {
        this.jLabel3 = jLabel3;
    }

    /**
     *
     * @return
     */
    public JLabel getjLabel4() {
        return jLabel4;
    }

    /**
     *
     * @param jLabel4
     */
    public void setjLabel4(JLabel jLabel4) {
        this.jLabel4 = jLabel4;
    }

    /**
     *
     * @return
     */
    public JLabel getjLabel5() {
        return jLabel5;
    }

    /**
     *
     * @param jLabel5
     */
    public void setjLabel5(JLabel jLabel5) {
        this.jLabel5 = jLabel5;
    }

    /**
     *
     * @return
     */
    public JScrollPane getjScrollPane3() {
        return jScrollPane3;
    }

    /**
     *
     * @param jScrollPane3
     */
    public void setjScrollPane3(JScrollPane jScrollPane3) {
        this.jScrollPane3 = jScrollPane3;
    }

    /**
     *
     * @return
     */
    public JScrollPane getjScrollPane4() {
        return jScrollPane4;
    }

    /**
     *
     * @param jScrollPane4
     */
    public void setjScrollPane4(JScrollPane jScrollPane4) {
        this.jScrollPane4 = jScrollPane4;
    }

    /**
     *
     * @return
     */
    public JScrollPane getjScrollPane5() {
        return jScrollPane5;
    }

    /**
     *
     * @param jScrollPane5
     */
    public void setjScrollPane5(JScrollPane jScrollPane5) {
        this.jScrollPane5 = jScrollPane5;
    }

    /**
     *
     * @return
     */
    public JTable getTblDatos_Clientes() {
        return tblDatos_Clientes;
    }

    /**
     *
     * @param tblDatos_Clientes
     */
    public void setTblDatos_Clientes(JTable tblDatos_Clientes) {
        this.tblDatos_Clientes = tblDatos_Clientes;
    }

    /**
     *
     * @return
     */
    public JTable getTblDatos_Fact() {
        return tblDatos_Fact;
    }

    /**
     *
     * @param tblDatos_Fact
     */
    public void setTblDatos_Fact(JTable tblDatos_Fact) {
        this.tblDatos_Fact = tblDatos_Fact;
    }

    /**
     *
     * @return
     */
    public JTable getTblDatos_Membresias() {
        return tblDatos_Membresias;
    }

    /**
     *
     * @param tblDatos_Membresias
     */
    public void setTblDatos_Membresias(JTable tblDatos_Membresias) {
        this.tblDatos_Membresias = tblDatos_Membresias;
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable tblDatos_Clientes;
    private javax.swing.JTable tblDatos_Fact;
    private javax.swing.JTable tblDatos_Membresias;
    // End of variables declaration//GEN-END:variables
}
