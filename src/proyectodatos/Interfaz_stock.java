/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectodatos;

import clases.Compra_proveedor;
import clases.GestionRepuestos;
import java.util.Date;
import clases.Repuesto;
import clases.Stock;
import database.CompraProveedorDB;
import database.GestionRepuestosDB;
import database.RepuestoDB;
import database.StockDB;
import java.awt.Image;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Roger
 */
public class Interfaz_stock extends javax.swing.JFrame {

    /**
     * Creates new form intefaz_stock
     */
    ArrayList <Repuesto> repuesto;
    RepuestoDB db = new RepuestoDB();
    RepuestoDB rDB ;
    public Interfaz_stock() {
        initComponents();
        this.setLocationRelativeTo(null);
        lista_sistema.addItem("--Tipo de Sistema--");
        lista_sistema.addItem("Sistema de distribucion");
        lista_sistema.addItem("Sistema de direccion");
        lista_sistema.addItem("Sistema de frenos");
        lista_sistema.addItem("Sistema de lubricacion");
        lista_sistema.addItem("Sistema de alimentaciona");
        lista_sistema.addItem("Sistema electrico");
        lista_sistema.addItem("Sistema de refrigeración");
        rDB = new RepuestoDB();
        
        this.listaMedioPago.addItem("--Medio de Pago--");
        this.listaMedioPago.addItem("crédito");
        this.listaMedioPago.addItem("efectivo");
        
        this.lista_ubicacion.addItem("--Ubicacion repuesto--");
        this.lista_ubicacion.addItem("gondola A1");
        this.lista_ubicacion.addItem("gondola A2");
        this.lista_ubicacion.addItem("gondola A3");
        this.lista_ubicacion.addItem("gondola B1");
        this.lista_ubicacion.addItem("gondola B2");
        this.lista_ubicacion.addItem("gondola B3");
        this.lista_ubicacion.addItem("gondola C1");
        this.lista_ubicacion.addItem("gondola C2");
        
                 ImageIcon imagen = new ImageIcon(getClass().getResource("/imagenes/logo.JPG"));
        Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_DEFAULT));
        logo.setIcon(icono);
        
        ImageIcon imagen1 = new ImageIcon(getClass().getResource("/imagenes/fondo_sistema.jpg"));
        Icon icono1 = new ImageIcon(imagen1.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_DEFAULT));
        fondo.setIcon(icono1);
    }
    
     public void ListarDatos(){
        repuesto =db.BuscarRepuesto(Integer.parseInt(this.text_repuesto_id.getText()));
        DefaultTableModel tb =(DefaultTableModel)this.tabla_rep.getModel();
        for (Repuesto rp : repuesto){
            tb.addRow(new Object[]{
                rp.getID_repuesto(),
                rp.getNombre_rep(),
                rp.getDescripcion(),
                rp.getModelo_vehiculo(),
                rp.getMarca_vehiculo(),
                rp.getPrecio(),
                rp.getTipo_sistema(),
                rp.getMedidas(),
                rp.getMaterial(),
                rp.getCalidad(),
                rp.getGarantia(),
                rp.getID_Stock()           
            });
        }
     }
     
     public void ListarInv(){
         ArrayList <Stock> Stock_arr;
         StockDB stDB = new StockDB();
        Stock_arr =  stDB.mostrar_stock(Integer.parseInt(this.text_stock_ver_inv.getText()));
        DefaultTableModel tb =(DefaultTableModel)this.tabla_inv.getModel();
        for (Stock rp : Stock_arr){
            tb.addRow(new Object[]{
                this.text_stock_ver_inv.getText(),
                rp.getID_Stock(),
                rp.getCantidad(),
                rp.getStock_inicial(),
                rp.getFecha_stock_inicial(),
                rp.getUbicacion_repuesto()
            });
        }
     }
     
     public void Listar_busqueda_compras(){
         ArrayList <Compra_proveedor> compra;
         CompraProveedorDB cpDB = new CompraProveedorDB();
         compra = cpDB.mostrar_compra_filtrada(Integer.parseInt(this.textId_compra.getText()));
         DefaultTableModel tb =(DefaultTableModel)this.tabla_compra.getModel();
         for(Compra_proveedor cp : compra){
             tb.addRow(new Object[] {
                cp.getId_compra(),
                cp.getFecha_compra(),
                cp.getCosto(),
                cp.getCantidad_compra(),
                cp.getMonto(),
                cp.getMedio_pago(),
                cp.getRuc_proveedor(),
                cp.getId_Stock()
             });
             }
         }
     
      public void Listar_compras(){
         ArrayList <Compra_proveedor> compra;
         CompraProveedorDB cpDB = new CompraProveedorDB();
         compra = cpDB.mostrar_compras();
         DefaultTableModel tb =(DefaultTableModel)this.tabla_compra.getModel();
         for(Compra_proveedor cp : compra){
             tb.addRow(new Object[] {
                cp.getId_compra(),
                cp.getFecha_compra(),
                cp.getCosto(),
                cp.getCantidad_compra(),
                cp.getMonto(),
                cp.getMedio_pago(),
                cp.getRuc_proveedor(),
                cp.getId_Stock()
             });
             }
         }
      
      public void Limpiar_tabla_compra(){
          DefaultTableModel tb =(DefaultTableModel)this.tabla_compra.getModel();
          for(int i = tb.getRowCount()-1;i>=0;i--){
              tb.removeRow(i);
          }
      }
      
            public void Limpiar_tabla_rep(){
          DefaultTableModel tb =(DefaultTableModel)this.tabla_rep.getModel();
          for(int i = tb.getRowCount()-1;i>=0;i--){
              tb.removeRow(i);
          }
      }
            
                  public void Limpiar_tabla_inv(){
          DefaultTableModel tb =(DefaultTableModel)this.tabla_inv.getModel();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_inv = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabla_rep = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        textDescrip = new javax.swing.JTextField();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton4 = new javax.swing.JToggleButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        textMarca = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lista_sistema = new javax.swing.JComboBox<>();
        textNombre = new javax.swing.JTextField();
        textGarantia_actualizar = new javax.swing.JTextField();
        textModelo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        textMedidas = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        textMaterial = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        textGarantia = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        text_repuesto_id = new javax.swing.JTextField();
        jToggleButton5 = new javax.swing.JToggleButton();
        jToggleButton6 = new javax.swing.JToggleButton();
        jLabel12 = new javax.swing.JLabel();
        text_stock_ver_inv = new javax.swing.JTextField();
        jToggleButton7 = new javax.swing.JToggleButton();
        jLabel13 = new javax.swing.JLabel();
        text_id_stock = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        textProveedor = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_compra = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        textCant = new javax.swing.JTextField();
        jToggleButton9 = new javax.swing.JToggleButton();
        listaMedioPago = new javax.swing.JComboBox<>();
        lista_ubicacion = new javax.swing.JComboBox<>();
        textId_compra = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        logo = new javax.swing.JLabel();
        textFecha = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        textPrecio1 = new javax.swing.JTextField();
        textPrecio_actualizar = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla_inv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id_repuesto", "id_Stock", "cantidad", "cant_Stock_inicial", "Fecha_Stock_inicial", "Ubicación_repuesto"
            }
        ));
        jScrollPane1.setViewportView(tabla_inv);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 290, 780, 60));

        tabla_rep.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id_repuesto", "nombre", "descripcion", "modelo vehiculo", "marca vehiculo", "precio", "tipo_sistema", "medidas", "material", "calidad", "garantía", "id_Stock"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tabla_rep);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 1250, 60));

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel1.setText("gestion de inventarios/compras");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, -1, -1));
        getContentPane().add(textDescrip, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 160, -1));

        jToggleButton1.setText("insertar repuesto");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 120, -1, -1));

        jToggleButton2.setText("actualizar precio ");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jToggleButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 160, -1, -1));

        jToggleButton4.setSelected(true);
        jToggleButton4.setText("Ver inventario");
        jToggleButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jToggleButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 290, -1, 30));

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 13)); // NOI18N
        jLabel2.setText("nombre Repuesto");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 20));

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 13)); // NOI18N
        jLabel3.setText("Descripción");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 110, -1));

        jButton1.setText("Mostrar repuestos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));
        getContentPane().add(textMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, 160, -1));

        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 13)); // NOI18N
        jLabel4.setText("modelo");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, 70, -1));

        jLabel5.setFont(new java.awt.Font("Arial Black", 1, 13)); // NOI18N
        jLabel5.setText("marca");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, 60, -1));

        jLabel6.setFont(new java.awt.Font("Arial Black", 1, 13)); // NOI18N
        jLabel6.setText("precio");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 60, 60, -1));
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 100, -1, -1));

        lista_sistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lista_sistemaActionPerformed(evt);
            }
        });
        getContentPane().add(lista_sistema, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 100, 200, 30));
        getContentPane().add(textNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 160, -1));

        textGarantia_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textGarantia_actualizarActionPerformed(evt);
            }
        });
        getContentPane().add(textGarantia_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 160, 110, -1));
        getContentPane().add(textModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 60, 160, -1));

        jLabel8.setFont(new java.awt.Font("Arial Black", 1, 13)); // NOI18N
        jLabel8.setText("medidas");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 60, 80, -1));
        getContentPane().add(textMedidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 60, 140, -1));

        jLabel9.setFont(new java.awt.Font("Arial Black", 1, 13)); // NOI18N
        jLabel9.setText("material");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 100, 80, -1));
        getContentPane().add(textMaterial, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 100, 140, -1));

        jLabel10.setFont(new java.awt.Font("Arial Black", 1, 13)); // NOI18N
        jLabel10.setText("garantía");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 90, 70, -1));
        getContentPane().add(textGarantia, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 90, 150, -1));

        jLabel11.setFont(new java.awt.Font("Arial Black", 1, 13)); // NOI18N
        jLabel11.setText("id_Repuesto");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 110, 30));

        text_repuesto_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_repuesto_idActionPerformed(evt);
            }
        });
        getContentPane().add(text_repuesto_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 160, 70, 30));

        jToggleButton5.setText("ver compras");
        jToggleButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jToggleButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 370, 110, 30));

        jToggleButton6.setText("Buscar repuesto");
        jToggleButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jToggleButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 160, -1, -1));

        jLabel12.setFont(new java.awt.Font("Arial Black", 1, 13)); // NOI18N
        jLabel12.setText("id_Stock");
        jLabel12.setToolTipText("");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 80, 20));

        text_stock_ver_inv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_stock_ver_invActionPerformed(evt);
            }
        });
        getContentPane().add(text_stock_ver_inv, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 290, 70, 30));

        jToggleButton7.setText("comprar_repuesto");
        jToggleButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jToggleButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 440, -1, -1));

        jLabel13.setFont(new java.awt.Font("Arial Black", 1, 13)); // NOI18N
        jLabel13.setText("id_stock");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, 80, -1));
        getContentPane().add(text_id_stock, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 370, 80, -1));

        jLabel14.setFont(new java.awt.Font("Arial Black", 1, 13)); // NOI18N
        jLabel14.setText("cantidad");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 410, 80, -1));
        getContentPane().add(textProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 450, 80, -1));

        tabla_compra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id repuesto", "fecha_compra", "costo", "cantidad", "total", "medio_pago", "Ruc proveedor", "id_Stock"
            }
        ));
        jScrollPane2.setViewportView(tabla_compra);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 410, 790, 140));

        jLabel15.setFont(new java.awt.Font("Arial Black", 1, 13)); // NOI18N
        jLabel15.setText("Fecha entrega");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, 130, -1));
        getContentPane().add(textCant, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 410, 80, -1));

        jToggleButton9.setText("Actualizar garantia");
        jToggleButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton9ActionPerformed(evt);
            }
        });
        getContentPane().add(jToggleButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 160, -1, -1));

        getContentPane().add(listaMedioPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 520, 180, -1));

        getContentPane().add(lista_ubicacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 330, 180, 30));
        getContentPane().add(textId_compra, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 370, 90, 30));

        jLabel16.setFont(new java.awt.Font("Arial Black", 1, 13)); // NOI18N
        jLabel16.setText("ID_compra");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 370, 90, 20));

        jButton2.setText("Buscar compra");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 370, 120, 30));
        getContentPane().add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 10, 90, 70));
        getContentPane().add(textFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 490, 80, -1));

        jLabel17.setFont(new java.awt.Font("Arial Black", 1, 13)); // NOI18N
        jLabel17.setText("Proveedor");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 450, 90, -1));

        textPrecio1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textPrecio1ActionPerformed(evt);
            }
        });
        getContentPane().add(textPrecio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 60, 50, -1));

        textPrecio_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textPrecio_actualizarActionPerformed(evt);
            }
        });
        getContentPane().add(textPrecio_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 160, 60, -1));

        jButton4.setText("Actualizar Ubicación");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 150, 30));
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1290, 560));

        jButton3.setText("el kks");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 400, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lista_sistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lista_sistemaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lista_sistemaActionPerformed

    private void text_repuesto_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_repuesto_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_repuesto_idActionPerformed

    private void jToggleButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton7ActionPerformed
        try {
            Compra_proveedor prov = new Compra_proveedor();
            CompraProveedorDB provDB = new CompraProveedorDB();
            GestionRepuestos gt = new GestionRepuestos();
            GestionRepuestosDB gtDB = new GestionRepuestosDB();
            RepuestoDB rpDB = new RepuestoDB();
            
            
            Date fecha = new Date();
            SimpleDateFormat formatofecha =  new SimpleDateFormat("MM/dd/yyyy");
            String aux_fecha =formatofecha.format(fecha);
            
            Stock stc = new Stock();
            StockDB stockDB = new StockDB();
            stc.setID_Stock(Integer.valueOf(this.text_id_stock.getText()));
            stc.setCantidad(Integer.valueOf(this.textCant.getText()));
            stc.setUbicacion_repuesto(String.valueOf(this.lista_ubicacion.getSelectedItem()));
            stc.setFecha_stock_inicial(aux_fecha);
            stockDB.actualizar_stock_compra(stc);
            stockDB.actualizar_fecha(stc);
            stockDB.actualizar_stock_inicial(stc);
            // stockDB.actualizar_stock_inicial(stc);
            prov.setCantidad_compra(Integer.parseInt(this.textCant.getText()));
            prov.setId_Stock(Integer.parseInt(this.text_id_stock.getText()));
            prov.setRuc_proveedor(Long.valueOf(this.textProveedor.getText()));
            prov.setMedio_pago(String.valueOf(this.listaMedioPago.getSelectedItem()));
            prov.setFecha_compra(aux_fecha);
            
            provDB.ajustar_costo(Long.valueOf(this.textProveedor.getText()));
            int aux_id_compra = provDB.max_compra();
            provDB.registrar_compra(prov);
            int aux_id_repuesto = rpDB.seleccionar_id_repuesto(Integer.parseInt(this.text_id_stock.getText()));
            gt.setId_Repuesto(aux_id_repuesto);
            gt.setId_compra(aux_id_compra);
            gt.setFecha_entregable(this.textFecha.getText());
            gtDB.Insertar_gt_repuestos(gt);
        } catch (SQLException ex) {
            Logger.getLogger(Interfaz_stock.class.getName()).log(Level.SEVERE, null, ex);
        }
  
    }//GEN-LAST:event_jToggleButton7ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        
        //JOptionPane.showMessageDialog(null,"Repuesto ingresado");
        Repuesto rp = new Repuesto();
        rp.setNombre_rep(this.textNombre.getText());
        rp.setDescripcion(this.textDescrip.getText());
        rp.setModelo_vehiculo(this.textModelo.getText());
        rp.setMarca_vehiculo(this.textMarca.getText());
        rp.setPrecio(80);
        rp.setTipo_sistema(String.valueOf(this.lista_sistema.getSelectedItem()));
        rp.setMedidas(this.textMedidas.getText());
        rp.setMaterial(this.textMaterial.getText());
        rp.setCalidad("Alta");
        rp.setGarantia(this.textGarantia.getText());
       
        rDB.insertar_stock();
        rDB.insertar_repuesto(rp);
        
        
        
        
        this.textDescrip.setText("");
        this.textMarca.setText("");
        this.textNombre.setText("");
        this.textGarantia_actualizar.setText("");
        this.textModelo.setText("");
        this.textMedidas.setText("");
        this.textMaterial.setText("");
        this.textGarantia.setText("");
        
        
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        interfaz_Repuesto ventana = new interfaz_Repuesto();
        ventana.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void textGarantia_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textGarantia_actualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textGarantia_actualizarActionPerformed

    private void jToggleButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton5ActionPerformed
        Limpiar_tabla_compra();
        Listar_compras();
    }//GEN-LAST:event_jToggleButton5ActionPerformed

    private void jToggleButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton6ActionPerformed
        Limpiar_tabla_rep();
        ListarDatos();
        
    }//GEN-LAST:event_jToggleButton6ActionPerformed

    private void jToggleButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton4ActionPerformed
        Limpiar_tabla_inv();
        ListarInv();
    }//GEN-LAST:event_jToggleButton4ActionPerformed

    private void text_stock_ver_invActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_stock_ver_invActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_stock_ver_invActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        Repuesto repu = new Repuesto();
        RepuestoDB repuDB = new RepuestoDB();
        repu.setID_repuesto(Integer.parseInt(this.text_repuesto_id.getText()));
        repu.setPrecio(Integer.parseInt(this.textPrecio_actualizar.getText()));
        repuDB.actualizar_precio(repu);
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jToggleButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton9ActionPerformed
             Repuesto repu = new Repuesto();
        RepuestoDB repuDB = new RepuestoDB();
        repu.setID_repuesto(Integer.parseInt(this.text_repuesto_id.getText()));
        repu.setGarantia(this.textGarantia_actualizar.getText());
        repuDB.actualizar_garantia(repu);
    }//GEN-LAST:event_jToggleButton9ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Limpiar_tabla_compra();
        Listar_busqueda_compras();
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            CompraProveedorDB provDB = new CompraProveedorDB();
            provDB.max_compra();
        } catch (SQLException ex) {
            Logger.getLogger(Interfaz_stock.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void textPrecio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textPrecio1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textPrecio1ActionPerformed

    private void textPrecio_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textPrecio_actualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textPrecio_actualizarActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        StockDB st = new StockDB();
        st.actualizar_ubicacion(
                String.valueOf(this.lista_ubicacion.getSelectedItem()), 
                Integer.parseInt(this.text_stock_ver_inv.getText())
        );
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(Interfaz_stock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz_stock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz_stock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz_stock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz_stock().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fondo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton4;
    private javax.swing.JToggleButton jToggleButton5;
    private javax.swing.JToggleButton jToggleButton6;
    private javax.swing.JToggleButton jToggleButton7;
    private javax.swing.JToggleButton jToggleButton9;
    private javax.swing.JComboBox<String> listaMedioPago;
    private javax.swing.JComboBox<String> lista_sistema;
    private javax.swing.JComboBox<String> lista_ubicacion;
    private javax.swing.JLabel logo;
    private javax.swing.JTable tabla_compra;
    private javax.swing.JTable tabla_inv;
    private javax.swing.JTable tabla_rep;
    private javax.swing.JTextField textCant;
    private javax.swing.JTextField textDescrip;
    private javax.swing.JTextField textFecha;
    private javax.swing.JTextField textGarantia;
    private javax.swing.JTextField textGarantia_actualizar;
    private javax.swing.JTextField textId_compra;
    private javax.swing.JTextField textMarca;
    private javax.swing.JTextField textMaterial;
    private javax.swing.JTextField textMedidas;
    private javax.swing.JTextField textModelo;
    private javax.swing.JTextField textNombre;
    private javax.swing.JTextField textPrecio1;
    private javax.swing.JTextField textPrecio_actualizar;
    private javax.swing.JTextField textProveedor;
    private javax.swing.JTextField text_id_stock;
    private javax.swing.JTextField text_repuesto_id;
    private javax.swing.JTextField text_stock_ver_inv;
    // End of variables declaration//GEN-END:variables
}
