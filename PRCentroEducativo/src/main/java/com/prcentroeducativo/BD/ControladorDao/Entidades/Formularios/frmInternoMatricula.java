 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.prcentroeducativo.BD.ControladorDao.Entidades.Formularios;

import com.prcentroeducativo.BD.ControladorDao.AlumnoDaoImp;
import com.prcentroeducativo.BD.ControladorDao.Entidades.Alumno;
import com.prcentroeducativo.BD.ControladorDao.Entidades.CursoAcademico;
import com.prcentroeducativo.BD.ControladorDao.Entidades.Matricula;
import com.prcentroeducativo.BD.ControladorDao.Entidades.Unidad;
import com.prcentroeducativo.BD.ControladorDao.MatriculaDaoImp;
import com.prcentroeducativo.BD.ControladorDao.UnidadDaoImp;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author javip
 */
public class frmInternoMatricula extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmInternoAlumnos
     */
    public frmInternoMatricula() {
        initComponents();
        configTabla();
        configTablaAlumnos();
        configTablaUnidad();
        cargaTablaUnidad();
        cargaTabla();
        cargaTablaAlumnos();
    }
    
    private void configTablaUnidad(){ 
    
     String col[]={"ID","CODIGO","NOMBRE","OBSERVACIONES","IDCURSO","IDTUTOR","IDAULA"};
        
        DefaultTableModel modelo=new DefaultTableModel(col,0){
        
              @Override
              public boolean isCellEditable(int row, int column){
                  return false;
              }
        
        };
        
        jtUnidad.setModel(modelo);
        jtUnidad.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                
        //configuro evento valor cambiado...
/*        jtCursos.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
        public void valueChanged(ListSelectionEvent event) {
            System.out.println(jtCursos.getValueAt(jtCursos.getSelectedRow(), 0).toString());
            setCampos();
        }
    });
  */      
}
   
   
    private void cargaTablaUnidad(){
        DefaultTableModel modelo=(DefaultTableModel)jtUnidad.getModel();
        
        UnidadDaoImp unidadcontroller=UnidadDaoImp.getInstance();
        System.out.println(unidadcontroller);
        String[] fila=new String[7];
        
        modelo.setNumRows(0);
        try{
            List<Unidad> lst=unidadcontroller.getAll();
            
            for( Unidad u :lst){
                fila[0]=""+u.getId();
                fila[1]=""+u.getCodigo();
                fila[2]=""+u.getNombre();
                fila[3]=""+u.getObservaciones();
                fila[4]=""+u.getIdcurso();
                fila[5]=""+u.getIdtutor();
                fila[6]=""+u.getIdaula();
                modelo.addRow(fila);
            }
            //selecciono la primera fila
           jtUnidad.setRowSelectionInterval(0,0); 
           
        }catch(Exception e){
            System.out.println("Error:"+e.getMessage());
        }
    }
    
    
    
    
    
    
    
    private void configTablaAlumnos(){ 
    
     String col[]={"ID","DNI","NOMBRE","APELLIDO1","APELLIDO2","FNACIMIENTO","TELEFONO","EMAIL","DIRECCION","CP","POBLACION","PROVINCIA"};
        
        DefaultTableModel modelo=new DefaultTableModel(col,0){
        
              @Override
              public boolean isCellEditable(int row, int column){
                  return false;
              }
        
        };
        
        jtAlumnos.setModel(modelo);
        jtAlumnos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                
        //configuro evento valor cambiado...
/*        jtCursos.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
        public void valueChanged(ListSelectionEvent event) {
            System.out.println(jtCursos.getValueAt(jtCursos.getSelectedRow(), 0).toString());
            setCampos();
        }
    });
  */      
}

     private void configTabla(){ 
    
     String col[]={"ID","ID ALUM","ID UNIDAD","DESCRIPCION","FECHA","FECHA BAJA"};
        
        DefaultTableModel modelo=new DefaultTableModel(col,0){
        
              @Override
              public boolean isCellEditable(int row, int column){
                  return false;
              }
        
        };
        
        jtMatricula.setModel(modelo);
        jtMatricula.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                
        //configuro evento valor cambiado...
/*        jtCursos.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
        public void valueChanged(ListSelectionEvent event) {
            System.out.println(jtCursos.getValueAt(jtCursos.getSelectedRow(), 0).toString());
            setCampos();
        }
    });
  */      
}
   
   
    private void cargaTabla(){
        DefaultTableModel modelo=(DefaultTableModel)jtMatricula.getModel();
        
        MatriculaDaoImp matriculacontroller=MatriculaDaoImp.getInstance();
        System.out.println(matriculacontroller);
        String[] fila=new String[7];
        
        modelo.setNumRows(0);
        try{
            List<Matricula> lst=matriculacontroller.getAll();
            
            for( Matricula m :lst){
                fila[0]=""+m.getIdmatricula();
                fila[1]=""+m.getIdalumno();
                fila[2]=""+m.getIdunidad();
                fila[3]=""+m.getDescripcion();
                fila[4]=""+m.getfMatricula();
                fila[5]=""+m.getfBaja();
                modelo.addRow(fila);
            }
            //selecciono la primera fila
           jtMatricula.setRowSelectionInterval(0,0); 
           
        }catch(Exception e){
            System.out.println("Error:"+e.getMessage());
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
        jtMatricula = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtAlumnos = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtUnidad = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtxtIdMatricula = new javax.swing.JTextField();
        jtxtIdUnidad = new javax.swing.JTextField();
        jtxtIdAlumno = new javax.swing.JTextField();
        jtxtDescripcion = new javax.swing.JTextField();
        jtxtFmatricula = new javax.swing.JTextField();
        jtxtFbaja = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jtxtBuscar = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Matricula");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtMatricula.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtMatricula.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtMatriculaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtMatricula);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 260, 480, 170));

        jtAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtAlumnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtAlumnosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtAlumnos);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, 470, 350));

        jtUnidad.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtUnidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtUnidadMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jtUnidad);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 460, 530, 350));

        jLabel1.setText("Id Matricula");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, -1, -1));

        jLabel2.setText("Id Unidad");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 40, -1, -1));

        jLabel3.setText("Id Alumno");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 40, -1, -1));

        jLabel4.setText("Descripcion");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 40, -1, -1));

        jLabel5.setText("Fecha Matricula");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, -1, -1));

        jLabel6.setText("Fecha Baja");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 140, -1, -1));

        jtxtIdMatricula.setText("jTextField1");
        getContentPane().add(jtxtIdMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, -1, -1));

        jtxtIdUnidad.setText("jTextField2");
        getContentPane().add(jtxtIdUnidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, -1, -1));

        jtxtIdAlumno.setText("jTextField3");
        getContentPane().add(jtxtIdAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 80, -1, -1));

        jtxtDescripcion.setText("jTextField4");
        getContentPane().add(jtxtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 80, -1, -1));

        jtxtFmatricula.setText("jTextField5");
        getContentPane().add(jtxtFmatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, -1, -1));

        jtxtFbaja.setText("jTextField6");
        getContentPane().add(jtxtFbaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 180, -1, -1));

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 170, -1, -1));

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 170, -1, -1));

        jButton1.setText("Eliminar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, -1, -1));

        jLabel7.setText("Buscar");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 280, -1, -1));

        jtxtBuscar.setText("jTextField1");
        jtxtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtBuscarKeyPressed(evt);
            }
        });
        getContentPane().add(jtxtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 310, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtAlumnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtAlumnosMouseClicked
        // TODO add your handling code here:
        setCampos();
        if (evt.getClickCount()==2){
            // System.out.println("Doble click.....");
            //Cargar el detalle de un alumno
            /*JDialog frame=new JDialog(this,"Detalle Alumno",true);

            jpAlumnoDetalle panel=new jpAlumnoDetalle();

            int idseleccion=Integer.parseInt(jtAlumnos.getValueAt(jtAlumnos.getSelectedRow(), 0).toString());

            panel.CargaDetalle(idseleccion);

            frame.getContentPane().add(panel);
            frame.pack();
            frame.setVisible(true);
            */
        }
    }//GEN-LAST:event_jtAlumnosMouseClicked

    private void jtUnidadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtUnidadMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount()==2){
            // System.out.println("Doble click.....");
            //Cargar el detalle de un alumno
            /*JDialog frame=new JDialog(this,"Detalle Alumno",true);

            jpAlumnoDetalle panel=new jpAlumnoDetalle();

            int idseleccion=Integer.parseInt(jtAlumnos.getValueAt(jtAlumnos.getSelectedRow(), 0).toString());

            panel.CargaDetalle(idseleccion);

            frame.getContentPane().add(panel);
            frame.pack();
            frame.setVisible(true);
            */
        }
    }//GEN-LAST:event_jtUnidadMouseClicked

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        MatriculaDaoImp matri=MatriculaDaoImp.getInstance();
        
        try{
            matri.update(getCampos());
            JOptionPane.showMessageDialog(this, "Curso actualizado correctamente");
            int fila=jtAlumnos.getSelectedRow();
            cargaTabla();
            jtAlumnos.setRowSelectionInterval(fila,fila);
        }catch(Exception e){
            System.out.println("Error:"+e.getMessage());
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void jtMatriculaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtMatriculaMouseClicked
        setCampos();

    }//GEN-LAST:event_jtMatriculaMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        MatriculaDaoImp matri=MatriculaDaoImp.getInstance();
        
Object valor = jtAlumnos.getValueAt(jtAlumnos.getSelectedRow(), 0);
        String strValor = (String) valor;
        int id = Integer.parseInt(strValor);
        
        if (jtAlumnos.getSelectedRow() != -1) { // Verifica si se ha seleccionado una fila
        int confirm = JOptionPane.showConfirmDialog(this, "¿Estás seguro de eliminar la fila seleccionada?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION) {            
            try {
                matri.delete(id);
                
                cargaTabla();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    } else {
        JOptionPane.showMessageDialog(this, "No se ha seleccionado ninguna fila.");
}
        

    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        MatriculaDaoImp matri=MatriculaDaoImp.getInstance();

        try{
            matri.add(getCampos());
            JOptionPane.showMessageDialog(this, "Curso agregado correctamente");
            cargaTabla();

        }catch(Exception e){
            System.out.println("Error:"+e.getMessage());
        }
           

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void jtxtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtBuscarKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER){
            DefaultTableModel modelo=(DefaultTableModel) jtMatricula.getModel();
            TableRowSorter<TableModel> trSorter = new TableRowSorter<TableModel>(modelo);

            jtMatricula.setRowSorter(trSorter);

            if (jtxtBuscar.getText().length()==0) {
                trSorter.setRowFilter(null);
            }else{

                trSorter.setRowFilter(RowFilter.regexFilter(jtxtBuscar.getText().trim()));
            }

        }


    }//GEN-LAST:event_jtxtBuscarKeyPressed


    private Matricula getCampos(){
        Matricula m=new Matricula();
        m.setIdmatricula(Integer.parseInt(jtxtIdMatricula.getText()));
        m.setIdalumno(Integer.parseInt(jtxtIdAlumno.getText()));
        m.setIdunidad(Integer.parseInt(jtxtIdUnidad.getText()));
        m.setDescripcion(jtxtDescripcion.getText());
        m.setfBaja(Date.valueOf(jtxtFbaja.getText()));
        m.setfMatricula(Date.valueOf(jtxtFmatricula.getText()));
        
        return m;        
    }
    
    /**
     * Establece los valores de los txt con los 
     * valores de la fisa actual
     */
    private void setCampos(){
    
        jtxtIdMatricula.setText(jtMatricula.getValueAt(jtMatricula.getSelectedRow(),0).toString());
        jtxtIdAlumno.setText(jtMatricula.getValueAt(jtMatricula.getSelectedRow(),1).toString());
        jtxtIdUnidad.setText(jtMatricula.getValueAt(jtMatricula.getSelectedRow(),2).toString());
        jtxtDescripcion.setText(jtMatricula.getValueAt(jtMatricula.getSelectedRow(), 3).toString());
        jtxtFmatricula.setText(jtMatricula.getValueAt(jtMatricula.getSelectedRow(),4).toString());
        jtxtFbaja.setText(jtMatricula.getValueAt(jtMatricula.getSelectedRow(),0).toString());

        
         
          
    }
     private void cargaTablaAlumnos(){
        DefaultTableModel modelo=(DefaultTableModel)jtAlumnos.getModel();
        
        AlumnoDaoImp alumControler=AlumnoDaoImp.getInstance();
        String[] fila=new String[12];
        
        modelo.setNumRows(0);
        try{
            List<Alumno> lst=alumControler.getAll();
            
            for( Alumno alum :lst){
                fila[0]=""+alum.getId();
                fila[1]=""+alum.getDni();
                fila[2]=""+alum.getNombre();
                fila[3]=""+alum.getApellido1() + " " + alum.getApellido2();
                fila[4]=""+alum.getFnacimiento();
                fila[5]=""+alum.getTelefono();
                fila[6]=""+alum.getEmail();
                fila[7]=""+alum.getDireccion();
                fila[8]=""+alum.getCp();
                fila[9]=""+alum.getPoblacion();
                fila[10]=""+alum.getProvincia();
                modelo.addRow(fila);
            }
            //selecciono la primera fila
           jtAlumnos.setRowSelectionInterval(0,0); 
           
        }catch(Exception e){
            System.out.println("Error:"+e.getMessage());
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jtAlumnos;
    private javax.swing.JTable jtMatricula;
    private javax.swing.JTable jtUnidad;
    private javax.swing.JTextField jtxtBuscar;
    private javax.swing.JTextField jtxtDescripcion;
    private javax.swing.JTextField jtxtFbaja;
    private javax.swing.JTextField jtxtFmatricula;
    private javax.swing.JTextField jtxtIdAlumno;
    private javax.swing.JTextField jtxtIdMatricula;
    private javax.swing.JTextField jtxtIdUnidad;
    // End of variables declaration//GEN-END:variables
}
