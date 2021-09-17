/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectodatos;

import clases.Repuesto;
import clases.Sede;
import clases.Venta_cliente;
import database.ClienteDB;
import database.RepuestoDB;
import database.StockDB;
import database.Venta_clienteDB;
import java.awt.Image;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Roger
 */
public class Interfaz_venta extends javax.swing.JFrame {

    /**
     * Creates new form ventana
     */
        ArrayList <Repuesto> repuesto;
        Repuesto rep = new Repuesto();
    RepuestoDB db = new RepuestoDB();
    Venta_cliente vt = new Venta_cliente();
    Venta_clienteDB vdb = new Venta_clienteDB();
    ClienteDB cliente_db = new ClienteDB();
    public Interfaz_venta() {
        initComponents();
        this.setLocationRelativeTo(null);
         ImageIcon imagen = new ImageIcon(getClass().getResource("/imagenes/logo.JPG"));
        Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_DEFAULT));
        logo.setIcon(icono);
        
        ImageIcon imagen1 = new ImageIcon(getClass().getResource("/imagenes/fondo.jpg"));
        Icon icono1 = new ImageIcon(imagen1.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_DEFAULT));
        fondo.setIcon(icono1);
        listSistema.addItem("--Tipo de Sistema--");
        listSistema.addItem("Sistema de distribucion");
        listSistema.addItem("Sistema de direccion");
        listSistema.addItem("Sistema de frenos");
        listSistema.addItem("Sistema de lubricacion");
        listSistema.addItem("Sistema de alimentaciona");
        listSistema.addItem("Sistema electrico");
        listSistema.addItem("Sistema de refrigeración");
        
        cborepuesto.addItem("--Nombre del repuesto--");
        cborepuesto.addItem("Aceite");
        cborepuesto.addItem("Amortiguado barra torsion");
        cborepuesto.addItem("Amortiguador ballesta");
        cborepuesto.addItem("Amortiguador muelle");
        cborepuesto.addItem("Arbol de levas");
        cborepuesto.addItem("Bomba inyeccion rotativa");
        cborepuesto.addItem("Bombin");
        cborepuesto.addItem("Botella de expansion");
        cborepuesto.addItem("Cables");
        cborepuesto.addItem("Carter");
        cborepuesto.addItem("Claxon");
        cborepuesto.addItem("Columna de direccion");
        cborepuesto.addItem("Common rail");
        cborepuesto.addItem("Cremallera");
        cborepuesto.addItem("Crucetas");
        cborepuesto.addItem("Culata");
        cborepuesto.addItem("Engranajes");
        cborepuesto.addItem("Filtro de aceite");
        cborepuesto.addItem("Freno de mano");
        cborepuesto.addItem("Freno de pie");
        cborepuesto.addItem("Fusibles");
        cborepuesto.addItem("Hidrogrupo");
        cborepuesto.addItem("Interruptores");
        cborepuesto.addItem("Inyeccion directa");
        cborepuesto.addItem("Inyeccion indirecta");
        cborepuesto.addItem("Inyeccion monopunto");
        cborepuesto.addItem("Inyeccion multipunto");
        cborepuesto.addItem("Inyectores electricos");
        cborepuesto.addItem("Inyectores electromagneticos");
        cborepuesto.addItem("Inyectores piezoelectricos");
        cborepuesto.addItem("Lamparas");
        cborepuesto.addItem("Radiador");
        cborepuesto.addItem("Relesr");
        cborepuesto.addItem("Rotula");
        cborepuesto.addItem("Seguro");
        cborepuesto.addItem("Servo");
        cborepuesto.addItem("Timon");
        cborepuesto.addItem("Valvulas");
        cborepuesto.addItem("Ventilador");
        
        cbomarca.addItem("--Marca del vehiculo--");
        cbomarca.addItem("Susuki");
        cbomarca.addItem("MercedesBenz");
        cbomarca.addItem("Nissan");
        cbomarca.addItem("Toyota");
        
        cbomodelo.addItem("--Modelo de vehiculo--");
        cbomodelo.addItem("Automovil");
        cbomodelo.addItem("Bus");
        cbomodelo.addItem("Camion");
        cbomodelo.addItem("Camioneta");
        cbomodelo.addItem("Moto");
        
        listSede.addItem("--Eliga sede a recoger--");
        listSede.addItem("Los Olivos");
        listSede.addItem("La Molina");
        listSede.addItem("Surco");
        listSede.addItem("ATE");
        listSede.addItem("San Miguel");
        listSede.addItem("San Borja");
        listSede.addItem("ENVIO A DOMICILIO");
    }
    
    public void MostrarLista(){
        
        repuesto = db.getListaFiltrada(
                String.valueOf(this.cborepuesto.getSelectedItem()), String.valueOf(this.cbomodelo.getSelectedItem()), 
                String.valueOf(this.cbomarca.getSelectedItem()), String.valueOf(this.listSistema.getSelectedItem()));
         DefaultTableModel tb =(DefaultTableModel)this.tabla_ventas.getModel();
            
        for (Repuesto rp : repuesto){
            rep.setID_repuesto(rp.getID_repuesto());
            rep.setPrecio(rp.getPrecio());
            tb.addRow(new Object[]{
                rp.getNombre_rep(),
                rp.getMedidas(),
                rp.getMaterial(),
                rp.getCalidad(),
                rp.getGarantia(),
                rp.getPrecio(),
                this.textCant.getText(),
                (rp.getPrecio() * Integer.parseInt(this.textCant.getText()))
            });
    }
    }
    
    
         public void Limpiar_tabla_ventas(){
          DefaultTableModel tb =(DefaultTableModel)this.tabla_ventas.getModel();
          for(int i = tb.getRowCount()-1;i>=0;i--){
              tb.removeRow(i);
          }
      }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        logo = new javax.swing.JLabel();
        textCant = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_ventas = new javax.swing.JTable();
        listSistema = new javax.swing.JComboBox<>();
        jToggleButton1 = new javax.swing.JToggleButton();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        cborepuesto = new javax.swing.JComboBox<>();
        cbomarca = new javax.swing.JComboBox<>();
        cbomodelo = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        textDni = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();
        listSede = new javax.swing.JComboBox<>();
        jButton5 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 90, 260, 230));
        getContentPane().add(textCant, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 310, 70, 30));

        tabla_ventas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "nombre", "medidas", "material", "calidad", "garantia", "Precio", "cantidad", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla_ventas);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 440, 888, 74));

        listSistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listSistemaActionPerformed(evt);
            }
        });
        getContentPane().add(listSistema, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 290, 40));

        jToggleButton1.setBackground(new java.awt.Color(255, 204, 51));
        jToggleButton1.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        jToggleButton1.setText("Buscar");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 150, 170, 50));

        jButton1.setBackground(new java.awt.Color(255, 204, 51));
        jButton1.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        jButton1.setText("Comprar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 360, 170, 50));

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 21)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("unidades");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 310, -1, -1));

        jButton2.setBackground(new java.awt.Color(255, 204, 51));
        jButton2.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        jButton2.setText("Ver Lista de Repuestos");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 230, -1, 50));

        getContentPane().add(cborepuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 290, 40));

        getContentPane().add(cbomarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 290, 40));

        getContentPane().add(cbomodelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 290, 40));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 21)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setText("DNI:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        textDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textDniActionPerformed(evt);
            }
        });
        getContentPane().add(textDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 241, 38));

        jButton4.setBackground(new java.awt.Color(255, 204, 51));
        jButton4.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        jButton4.setText("Ingresar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 40, 130, 60));
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 1160, 560));

        listSede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listSedeActionPerformed(evt);
            }
        });
        getContentPane().add(listSede, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 290, 40));

        jButton5.setText("el kks");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 410, -1, -1));

        jButton3.setText("stock");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listSistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listSistemaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_listSistemaActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        Limpiar_tabla_ventas();
        MostrarLista();
        
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        interfaz_Repuesto vent = new interfaz_Repuesto();
        vent.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            try {
                StockDB stDB = new StockDB();
                
                
                
                vt.setCantidad_venta(Integer.parseInt(this.textCant.getText()));
                cliente_db.setDNI_test(Integer.parseInt(this.textDni.getText()));
                
                
                vt.getCantidad_venta();
                vdb.max_venta();
                //long aux_ruc = vdb.seleccionar_ruc_sede(String.valueOf(this.listSistema.getSelectedItem()));
                int aux_stock;
                aux_stock = db.seleccionar_Stock(rep);
                stDB.actualizar_stock_venta(aux_stock, Integer.parseInt(this.textCant.getText()));
                System.out.println("codido stock es: " + aux_stock);
                
                vdb.insertar_vents(vt,rep,cliente_db);
            } catch (SQLException ex) {
                Logger.getLogger(Interfaz_venta.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void textDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textDniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textDniActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        cliente_db.comprobar_cliente(Long.parseLong(this.textDni.getText()));

        System.out.println("codigo: " + cliente_db.getDNI_test());
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
                int aux_stock;
                aux_stock = db.seleccionar_Stock(rep);
                System.out.println("codigo stock es: " + aux_stock);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void listSedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listSedeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_listSedeActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       vdb.seleccionar_ruc_sede(String.valueOf(listSede.getSelectedItem()));
    
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interfaz_venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz_venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz_venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz_venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz_venta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbomarca;
    private javax.swing.JComboBox<String> cbomodelo;
    private javax.swing.JComboBox<String> cborepuesto;
    private javax.swing.JLabel fondo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JComboBox<String> listSede;
    private javax.swing.JComboBox<String> listSistema;
    private javax.swing.JLabel logo;
    private javax.swing.JTable tabla_ventas;
    private javax.swing.JTextField textCant;
    private javax.swing.JTextField textDni;
    // End of variables declaration//GEN-END:variables
}
