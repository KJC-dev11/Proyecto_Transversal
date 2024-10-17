/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Alumno;
import Modelo.Materia;
import Persistencia.alumnoData;
import Persistencia.inscripcionData;
import Persistencia.materiaData;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Augusto
 */
public class VistaCargarNotas extends javax.swing.JInternalFrame {
    
    private alumnoData ad;
    private inscripcionData inscrData;
    private ArrayList<Alumno> listaB;
    private ArrayList<Materia> listaMaterias;
    private materiaData matData;
    private DefaultTableModel modelo;
    

    /**
     * Creates new form VistaCargarNotas
     */
    public VistaCargarNotas() {
        initComponents();
        ad = new alumnoData();
        inscrData = new inscripcionData();
        matData = new materiaData();
        listaB = (ArrayList<Alumno>) ad.listarAlumnos();
        listaMaterias = (ArrayList<Materia>) matData.listarMaterias();
        modelo = new DefaultTableModel();
        cargarAlumnos();
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cboxAlumnos = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableMaterias = new javax.swing.JTable();
        jguardar = new javax.swing.JButton();
        jsalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        cboxAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxAlumnosActionPerformed(evt);
            }
        });

        tableMaterias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Nota"
            }
        ));
        jScrollPane1.setViewportView(tableMaterias);

        jguardar.setText("Guardar");
        jguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jguardarActionPerformed(evt);
            }
        });

        jsalir.setText("Salir");
        jsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jsalirActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Carga de notas");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Seleccion de alumnos :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel2)
                        .addGap(29, 29, 29)
                        .addComponent(cboxAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(129, 129, 129))
            .addGroup(layout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addComponent(jguardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jsalir)
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cboxAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jguardar)
                    .addComponent(jsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jsalirActionPerformed
        // TODO add your handling code here:
            dispose();
    }//GEN-LAST:event_jsalirActionPerformed
 
    private void jguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jguardarActionPerformed
        // TODO add your handling code here:
        guardarNotas();
    }//GEN-LAST:event_jguardarActionPerformed

    private void cboxAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxAlumnosActionPerformed
        // TODO add your handling code here:
        cargarMateriasCursadas();
    }//GEN-LAST:event_cboxAlumnosActionPerformed

     

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Alumno> cboxAlumnos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jguardar;
    private javax.swing.JButton jsalir;
    private javax.swing.JTable tableMaterias;
    // End of variables declaration//GEN-END:variables


     private void cargarAlumnos() {
 Alumno alumnoSeleccionado = (Alumno) cboxAlumnos.getSelectedItem();

        if (alumnoSeleccionado == null) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un alumno");
            return;
        }

        List<Materia> materias = inscrData.obtenerMateriasCursadas(alumnoSeleccionado.getIdAlumno());
        List<Double> notas = inscrData.obtenerNotas(alumnoSeleccionado.getIdAlumno());

        DefaultTableModel model = (DefaultTableModel) tableMaterias.getModel();
        model.setRowCount(0);

        for (int i = 0; i < materias.size(); i++) {
            Materia materia = materias.get(i);
            Double nota = notas.get(i);
            model.addRow(new Object[]{materia.getIdMateria(), materia.getNombre(), nota});
        }
    }

private void cargarMateriasCursadas() {
        Alumno alumnoSeleccionado = (Alumno) cboxAlumnos.getSelectedItem();

        if (alumnoSeleccionado == null) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un alumno");
            return;
        }

        List<Materia> materias = inscrData.obtenerMateriasCursadas(alumnoSeleccionado.getIdAlumno());
        List<Double> notas = inscrData.obtenerNotas(alumnoSeleccionado.getIdAlumno());

        DefaultTableModel model = (DefaultTableModel) tableMaterias.getModel();
        model.setRowCount(0);

        for (int i = 0; i < materias.size(); i++) {
            Materia materia = materias.get(i);
            Double nota = notas.get(i);
            model.addRow(new Object[]{materia.getIdMateria(), materia.getNombre(), nota});
        }
    }

  private void guardarNotas() {
  Alumno alumnoSeleccionado = (Alumno) cboxAlumnos.getSelectedItem();
        
        if (alumnoSeleccionado == null) {
            JOptionPane.showMessageDialog(this, "Seleccione un alumno");
            return;
        }

        DefaultTableModel model = (DefaultTableModel) tableMaterias.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            int idMateria = (int) model.getValueAt(i, 0);
            double nota;
            try {
                nota = Double.parseDouble(model.getValueAt(i, 2).toString());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Por favor, ingrese una nota válida.");
                return;
            }

            inscrData.actualizarNota(alumnoSeleccionado.getIdAlumno(), idMateria, nota);
        }

        JOptionPane.showMessageDialog(this, "Notas actualizadas con éxito.");
    }


    }


