package fichamedica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.util.Date;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

/**
 *
 * @author acc31
 */
public class Fichamedica extends javax.swing.JFrame {

    /**
     * Creates new form Fichamedica
     */
    public Fichamedica() {
        initComponents();
        setLocationRelativeTo(null);
        //jLabel1.setVisible(false);
        jPanel2.setVisible(false);
        cargarFichas();

    }

    public void cargarFichas() {
        String url = "jdbc:mysql://localhost:3306/clinica_veterinaria";
        String usuario = "root";
        String contraseña = "";

        String sql = "SELECT ID_ficha, fecha, ID_mascota, ID_veterinario FROM fichamedica";

        try (Connection conn = DriverManager.getConnection(url, usuario, contraseña); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            DefaultTableModel tabla = new DefaultTableModel();
            tabla.addColumn("ID Ficha");
            tabla.addColumn("Fecha");
            tabla.addColumn("Mascota");
            tabla.addColumn("Veterinario");

            jTable2.setModel(tabla); // Asignar el tabla a la tabla

            while (rs.next()) {

                tabla.addRow(new Object[]{
                    rs.getInt("ID_ficha"),
                    rs.getDate("fecha"),
                    rs.getInt("ID_mascota"),
                    rs.getInt("ID_veterinario") // Mostrar el veterinario asociado
                });
            }

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
    }

    public void limpiarCampos(JPanel panel) {
        for (Component comp : panel.getComponents()) {
            if (comp instanceof JTextField) {
                ((JTextField) comp).setText("");
            } else if (comp instanceof JScrollPane) {
                Component contenido = ((JScrollPane) comp).getViewport().getView();
                if (contenido instanceof JTextArea) {
                    ((JTextArea) contenido).setText("");
                }
            } else if (comp instanceof JPanel) {
                limpiarCampos((JPanel) comp);
            }
        }
    }

    private void cargarVeterinarios() {
        String url = "jdbc:mysql://localhost:3306/clinica_veterinaria";
        String usuario = "root";
        String contraseña = "";

        String sql = "SELECT ID_VET, NumeroColegiado FROM veterinario";

        try (Connection conn = DriverManager.getConnection(url, usuario, contraseña); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            comboVeterinarios.removeAllItems();

            while (rs.next()) {
                String item = (rs.getInt("ID_VET") + " - " + rs.getString("NumeroColegiado")); // Agregar ID y nombre
                comboVeterinarios.addItem(item);

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void cargarVeterinarios(int idSeleccionado) {
        comboVeterinarios.removeAllItems();
        String url = "jdbc:mysql://localhost:3306/clinica_veterinaria";
        String usuario = "root";
        String contraseña = "";

        String sql = "SELECT ID_VET, NumeroColegiado FROM veterinario";

        try (Connection conn = DriverManager.getConnection(url, usuario, contraseña); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            String veterinarioSeleccionado = null;

            while (rs.next()) {
                String item = (rs.getInt("ID_VET") + " - " + rs.getString("NumeroColegiado")); // Agregar ID y nombre
                comboVeterinarios.addItem(item);
                if (rs.getInt("ID_VET") == idSeleccionado) {
                    veterinarioSeleccionado = item;
                }
            }
            if (veterinarioSeleccionado != null) {
                comboVeterinarios.setSelectedItem(veterinarioSeleccionado);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void cargarMascotas() {
        String url = "jdbc:mysql://localhost:3306/clinica_veterinaria";
        String usuario = "root";
        String contraseña = "";

        String sql = "SELECT ID_mascota, nombre FROM mascota";

        try (Connection conn = DriverManager.getConnection(url, usuario, contraseña); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            comboMascotas.removeAllItems();

            while (rs.next()) {
                comboMascotas.addItem(rs.getInt("ID_mascota") + " - " + rs.getString("nombre")); // Agregar ID y nombre
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void cargarMascotas(int idSeleccionado) {
        comboMascotas.removeAllItems();
        String url = "jdbc:mysql://localhost:3306/clinica_veterinaria";
        String usuario = "root";
        String contraseña = "";

        String sql = "SELECT ID_mascota, nombre FROM mascota";

        try (Connection conn = DriverManager.getConnection(url, usuario, contraseña); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            String mascotaSeleccionada = null;

            while (rs.next()) {
                String item = rs.getInt("ID_mascota") + " - " + rs.getString("nombre"); // Agregar ID y nombre
                comboMascotas.addItem(item);
                if (rs.getInt("ID_mascota") == idSeleccionado) {
                    mascotaSeleccionada = item;
                }
            }
            if (mascotaSeleccionada != null) {
                comboMascotas.setSelectedItem(mascotaSeleccionada);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void guardarDatos() {
        String sintoma = sintomas.getText();
        String medica = medicacion.getText();
        Date fechaFicha = fecha.getDate();
        java.sql.Date fechaSQL = new java.sql.Date(fechaFicha.getTime());
        String trata = tratamiento.getText();
        String seleccionado1 = (String) comboVeterinarios.getSelectedItem();
        int idV = Integer.parseInt(seleccionado1.split(" - ")[0]); // Extraer el ID
        String seleccionado2 = (String) comboMascotas.getSelectedItem();
        int idM = Integer.parseInt(seleccionado2.split(" - ")[0]); // Extraer el ID
        /*int idM = Integer.parseInt(idMascota.getText());
        int idV = Integer.parseInt(idVeterinario.getText());*/
        String url = "jdbc:mysql://localhost:3306/clinica_veterinaria";
        String usuario = "root";
        String contraseña = "";

        String sql = "INSERT INTO fichamedica (fecha, sintomas, tratamiento, medicacion, ID_mascota, ID_veterinario) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, usuario, contraseña); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDate(1, fechaSQL);
            stmt.setString(2, sintoma);
            stmt.setString(3, trata);
            stmt.setString(4, medica);
            stmt.setInt(5, idM);
            stmt.setInt(6, idV);
            stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
    }

    public void borrarDatos() {
        int filaSeleccionada = jTable2.getSelectedRow();
        if (filaSeleccionada < 0) {
            JOptionPane.showMessageDialog(null, "Seleccione una ficha");
            return;
        }
        DefaultTableModel tabla = (DefaultTableModel) jTable2.getModel();
        int idFicha = (int) tabla.getValueAt(filaSeleccionada, 0); // Obtener el ID de la ficha médica

        String url = "jdbc:mysql://localhost:3306/clinica_veterinaria";
        String usuario = "root";
        String contraseña = "";

        String sql = "DELETE FROM fichamedica WHERE ID_ficha = ?";

        try (Connection conn = DriverManager.getConnection(url, usuario, contraseña); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idFicha); // Establecer el ID en la consulta
            int filasEliminadas = stmt.executeUpdate();

            if (filasEliminadas > 0) {
                tabla.removeRow(filaSeleccionada); // Eliminar la fila de la tabla en la interfaz

            } else {

            }

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
    }

    public void modificarFicha() {
        int filaSeleccionada = jTable2.getSelectedRow();
        
        DefaultTableModel tabla = (DefaultTableModel) jTable2.getModel();
        int idFicha = (int) tabla.getValueAt(filaSeleccionada, 0); // Obtener el ID de la ficha médica
        int idVeterinario = Integer.parseInt(tabla.getValueAt(filaSeleccionada, 3).toString());
        int idMascota = Integer.parseInt(tabla.getValueAt(filaSeleccionada, 2).toString());

        String url = "jdbc:mysql://localhost:3306/clinica_veterinaria";
        String usuario = "root";
        String contraseña = "";

        String sql = "SELECT fecha, ID_mascota, ID_veterinario, sintomas, tratamiento, medicacion FROM fichamedica WHERE ID_ficha = ?";

        try (Connection conn = DriverManager.getConnection(url, usuario, contraseña); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idFicha);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Date fechaFicha = rs.getDate("fecha");
                //int idMascota = rs.getInt("ID_mascota");
                //int idVeterinario = rs.getInt("ID_veterinario");
                String sintoma = rs.getString("sintomas");
                String trata = rs.getString("tratamiento");
                String medica = rs.getString("medicacion");

                sintomas.setText(sintoma);
                fecha.setDate(fechaFicha);
                tratamiento.setText(trata);
                medicacion.setText(medica);
                cargarVeterinarios(idVeterinario);
                cargarMascotas(idMascota);

            } else {

            }

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
    }
    
    public void actualizarDatos() {
        int filaSeleccionada = jTable2.getSelectedRow();
        DefaultTableModel tabla = (DefaultTableModel) jTable2.getModel();
        String sintoma = sintomas.getText();
        String medica = medicacion.getText();
        Date fechaFicha = fecha.getDate();
        java.sql.Date fechaSQL = new java.sql.Date(fechaFicha.getTime());
        String trata = tratamiento.getText();
        String seleccionado1 = (String) comboVeterinarios.getSelectedItem();
        int idV = Integer.parseInt(seleccionado1.split(" - ")[0]); // Extraer el ID
        String seleccionado2 = (String) comboMascotas.getSelectedItem();
        int idM = Integer.parseInt(seleccionado2.split(" - ")[0]); // Extraer el ID
        /*int idM = Integer.parseInt(idMascota.getText());
        int idV = Integer.parseInt(idVeterinario.getText());*/
        int idFicha = (int) tabla.getValueAt(filaSeleccionada, 0);
        System.out.println("ID de ficha a actualizar: " + idFicha);
        String url = "jdbc:mysql://localhost:3306/clinica_veterinaria";
        String usuario = "root";
        String contraseña = "";

        String sql = "UPDATE fichamedica SET fecha = ?, sintomas = ?, tratamiento = ?, medicacion = ?, ID_mascota = ?, ID_veterinario = ? WHERE ID_ficha = ?";

        try (Connection conn = DriverManager.getConnection(url, usuario, contraseña); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDate(1, fechaSQL);
            stmt.setString(2, sintoma);
            stmt.setString(3, trata);
            stmt.setString(4, medica);
            stmt.setInt(5, idM);
            stmt.setInt(6, idV);
            stmt.setInt(7, idFicha);
            stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();

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

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        sintomas = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tratamiento = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        medicacion = new javax.swing.JTextArea();
        guardar = new javax.swing.JButton();
        volver = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        fecha = new com.toedter.calendar.JDateChooser();
        comboVeterinarios = new javax.swing.JComboBox<>();
        comboMascotas = new javax.swing.JComboBox<>();
        guardar1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        agregar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        modificar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Agregar Ficha");
        jLabel1.setFocusable(false);

        jLabel3.setText("Mascota");

        jLabel5.setText("Fecha");

        jLabel6.setText("Sintomas");

        sintomas.setColumns(20);
        sintomas.setRows(5);
        jScrollPane1.setViewportView(sintomas);

        jLabel7.setText("Tratamiento");

        tratamiento.setColumns(20);
        tratamiento.setRows(5);
        jScrollPane2.setViewportView(tratamiento);

        jLabel8.setText("Medicación");

        medicacion.setColumns(20);
        medicacion.setRows(5);
        jScrollPane3.setViewportView(medicacion);

        guardar.setText("Guardar");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });

        volver.setText("Volver");
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });

        jLabel9.setText("Número de colegiado");

        comboVeterinarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboVeterinariosActionPerformed(evt);
            }
        });

        comboMascotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboMascotasActionPerformed(evt);
            }
        });

        guardar1.setText("Guardar");
        guardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(guardar1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel5)
                                .addGap(36, 36, 36)
                                .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(87, 87, 87))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(40, 40, 40))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(40, 40, 40)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(66, 66, 66))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(comboVeterinarios, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel3)
                                                .addGap(37, 37, 37)))
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(comboMascotas, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                        .addComponent(guardar)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(volver))
                                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))))))))))
                .addGap(88, 88, 88))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel5))
                    .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel9)
                    .addComponent(comboVeterinarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboMascotas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(89, 89, 89)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(41, 41, 41)
                .addComponent(guardar1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guardar)
                    .addComponent(volver))
                .addGap(50, 50, 50))
        );

        jLabel1.getAccessibleContext().setAccessibleDescription("");

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 740));

        agregar.setText("Agregar");
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });

        eliminar.setText("Eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        modificar.setText("Modficar");
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });

        jLabel4.setText("Centro de control de Fichas Médicas");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(257, 257, 257)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(agregar)
                                .addGap(100, 100, 100)
                                .addComponent(eliminar)
                                .addGap(102, 102, 102)
                                .addComponent(modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(318, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eliminar)
                    .addComponent(agregar)
                    .addComponent(modificar))
                .addGap(210, 210, 210))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 740));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed

        jPanel1.setVisible(false);
        jPanel2.setVisible(true);
        cargarVeterinarios();
        cargarMascotas();
        guardar.setVisible(true);
        guardar1.setVisible(false);

    }//GEN-LAST:event_agregarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        borrarDatos();
    }//GEN-LAST:event_eliminarActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        int filaSeleccionada = jTable2.getSelectedRow();
        if (filaSeleccionada < 0) {
            JOptionPane.showMessageDialog(null, "Seleccione una ficha");
            return;
        }
        jPanel1.setVisible(false);
        jPanel2.setVisible(true);
        modificarFicha();
        //cargarVeterinarios();
        //cargarMascotas();
        guardar.setVisible(false);
        guardar1.setVisible(true);

    }//GEN-LAST:event_modificarActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        guardarDatos();
        jPanel1.setVisible(true);
        jPanel2.setVisible(false);
        limpiarCampos(jPanel2);
        cargarFichas();
    }//GEN-LAST:event_guardarActionPerformed

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        jPanel1.setVisible(true);
        jPanel2.setVisible(false);
        limpiarCampos(jPanel2);
        cargarFichas();

    }//GEN-LAST:event_volverActionPerformed

    private void comboVeterinariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboVeterinariosActionPerformed

    }//GEN-LAST:event_comboVeterinariosActionPerformed

    private void comboMascotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboMascotasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboMascotasActionPerformed

    private void guardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardar1ActionPerformed
        actualizarDatos();
        jPanel1.setVisible(true);
        jPanel2.setVisible(false);
        limpiarCampos(jPanel2);
        cargarFichas();
    }//GEN-LAST:event_guardar1ActionPerformed

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
            java.util.logging.Logger.getLogger(Fichamedica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Fichamedica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Fichamedica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Fichamedica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Fichamedica().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregar;
    private javax.swing.JComboBox<String> comboMascotas;
    private javax.swing.JComboBox<String> comboVeterinarios;
    private javax.swing.JButton eliminar;
    private com.toedter.calendar.JDateChooser fecha;
    private javax.swing.JButton guardar;
    private javax.swing.JButton guardar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea medicacion;
    private javax.swing.JButton modificar;
    private javax.swing.JTextArea sintomas;
    private javax.swing.JTextArea tratamiento;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}
