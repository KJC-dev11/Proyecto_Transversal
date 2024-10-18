/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Alumno;
import Modelo.Inscripcion;
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
    private ArrayList<Alumno> listaAlumnos;
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
        listaAlumnos = (ArrayList<Alumno>) ad.listarAlumnos();
        listaMaterias = (ArrayList<Materia>) matData.listarMaterias();
        modelo = new DefaultTableModel();
        armarCabeceraTabla();
        cargarAlumnos();
        
        if (listaAlumnos.isEmpty()) {
            cboxAlumnos.setEnabled(false);
            tableMaterias.setEnabled(false);
            jguardar.setEnabled(false);
            JOptionPane.showMessageDialog(this, "No hay alumnos disponibles.");
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
        cboxAlumnos.removeAllItems();
        for (Alumno alumno : listaAlumnos) {
            cboxAlumnos.addItem(alumno);
        }
        if (cboxAlumnos.getItemCount() == 0) {
            JOptionPane.showMessageDialog(this, "No hay alumnos disponibles.");
        }
    }

private void cargarMateriasCursadas() {
    Alumno alumnoSeleccionado = (Alumno) cboxAlumnos.getSelectedItem();

        if (alumnoSeleccionado == null) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un alumno.");
            return;
        }

        List<Inscripcion> inscripciones = inscrData.obtenerInscripciones(alumnoSeleccionado.getIdAlumno());

        modelo.setRowCount(0);

        if (inscripciones.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El alumno no está inscripto en ninguna materia.");
            return;
        }

        for (Inscripcion inscripcion : inscripciones) {
            modelo.addRow(new Object[]{inscripcion.getIdInscripcion(), inscripcion.getMateria().getNombre(), inscripcion.getNota()});
        }
}

  private void guardarNotas() {
           Alumno alumnoSeleccionado = (Alumno) cboxAlumnos.getSelectedItem();

        if (alumnoSeleccionado == null) {
            JOptionPane.showMessageDialog(this, "Seleccione un alumno.");
            return;
        }

        for (int i = 0; i < modelo.getRowCount(); i++) {
    int idInscripcion = (int) modelo.getValueAt(i, 0); 
    double nota;

    try {
        String notaStr = modelo.getValueAt(i, 2).toString();
        if (notaStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "La nota de la fila " + (i + 1) + " está vacía.");
            return;
        }

        nota = Double.parseDouble(notaStr);
        if (nota < 0 || nota > 10) {
            JOptionPane.showMessageDialog(this, "La nota debe estar entre 0 y 10.");
            return;
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Error en el formato de la nota en la fila " + (i + 1));
        return;
    }

    inscrData.actualizarNota(idInscripcion, nota);
}

JOptionPane.showMessageDialog(this, "Notas guardadas exitosamente.");
    }

    private void armarCabeceraTabla() {
        ArrayList<Object> columnas = new ArrayList<>();
        columnas.add("ID Inscripción");
        columnas.add("Materia");
        columnas.add("Nota");
        for (Object columna : columnas) {
            modelo.addColumn(columna);
        }
        tableMaterias.setModel(modelo);
    }
    }
  



