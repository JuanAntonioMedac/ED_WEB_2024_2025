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
    private Date date;
    private String tratamientos;
    private String medication;
    private String symptom;
    private int id_vet;
    private int id_mascota;
    
    public Fichamedica(Date date, String tratamientos, String medication, String symptom, int id_vet, int id_mascota){
        this.date=date;
        this.tratamientos=tratamientos;
        this.medication=medication;
        this.symptom=symptom;
        this.id_vet=id_vet;
        this.id_mascota=id_mascota;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTratamientos() {
        return tratamientos;
    }

    public void setTratamientos(String tratamientos) {
        this.tratamientos = tratamientos;
    }

    public String getMedication() {
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    public int getId_vet() {
        return id_vet;
    }

    public void setId_vet(int id_vet) {
        this.id_vet = id_vet;
    }

    public int getId_mascota() {
        return id_mascota;
    }

    public void setId_mascota(int id_mascota) {
        this.id_mascota = id_mascota;
    }
    
    
    
    /**
     * Creates new form Fichamedica
     */
    public Fichamedica() {
        initComponents();
        setLocationRelativeTo(null);
        //jLabel1.setVisible(false);
        panelSecundario.setVisible(false);
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

            tablaDatos.setModel(tabla); // Asignar el tabla a la tabla

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
        int filaSeleccionada = tablaDatos.getSelectedRow();
        if (filaSeleccionada < 0) {
            JOptionPane.showMessageDialog(null, "Seleccione una ficha");
            return;
        }
        DefaultTableModel tabla = (DefaultTableModel) tablaDatos.getModel();
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
        int filaSeleccionada = tablaDatos.getSelectedRow();

        DefaultTableModel tabla = (DefaultTableModel) tablaDatos.getModel();
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
        int filaSeleccionada = tablaDatos.getSelectedRow();
        DefaultTableModel tabla = (DefaultTableModel) tablaDatos.getModel();
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

        panelPrincipal = new javax.swing.JPanel();
        agregar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        modificar = new javax.swing.JButton();
        scrollInicio = new javax.swing.JScrollPane();
        tablaDatos = new javax.swing.JTable();
        panelCabeceraPrincipal = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        panelSecundario = new javax.swing.JPanel();
        textoMascota = new javax.swing.JLabel();
        textoFecha = new javax.swing.JLabel();
        textoSintomas = new javax.swing.JLabel();
        scrollSintomas = new javax.swing.JScrollPane();
        sintomas = new javax.swing.JTextArea();
        textoTratamiento = new javax.swing.JLabel();
        scrollTratamiento = new javax.swing.JScrollPane();
        tratamiento = new javax.swing.JTextArea();
        textoMedicacion = new javax.swing.JLabel();
        scrollMedicacion = new javax.swing.JScrollPane();
        medicacion = new javax.swing.JTextArea();
        guardar = new javax.swing.JButton();
        volver = new javax.swing.JButton();
        textoVeterinario = new javax.swing.JLabel();
        fecha = new com.toedter.calendar.JDateChooser();
        comboVeterinarios = new javax.swing.JComboBox<>();
        comboMascotas = new javax.swing.JComboBox<>();
        guardar1 = new javax.swing.JButton();
        panelCabecera = new javax.swing.JPanel();
        subTitulo = new javax.swing.JLabel();
        titulo2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        tablaDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        scrollInicio.setViewportView(tablaDatos);

        panelCabeceraPrincipal.setBackground(new java.awt.Color(0, 153, 0));

        titulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setText("Centro de control de Fichas Médicas");

        javax.swing.GroupLayout panelCabeceraPrincipalLayout = new javax.swing.GroupLayout(panelCabeceraPrincipal);
        panelCabeceraPrincipal.setLayout(panelCabeceraPrincipalLayout);
        panelCabeceraPrincipalLayout.setHorizontalGroup(
            panelCabeceraPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCabeceraPrincipalLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 689, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelCabeceraPrincipalLayout.setVerticalGroup(
            panelCabeceraPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCabeceraPrincipalLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCabeceraPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(scrollInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addComponent(panelCabeceraPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(scrollInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(198, Short.MAX_VALUE))
        );

        getContentPane().add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 740));

        textoMascota.setText("Mascota");

        textoFecha.setText("Fecha");

        textoSintomas.setText("Sintomas");

        sintomas.setColumns(20);
        sintomas.setRows(5);
        scrollSintomas.setViewportView(sintomas);

        textoTratamiento.setText("Tratamiento");

        tratamiento.setColumns(20);
        tratamiento.setRows(5);
        scrollTratamiento.setViewportView(tratamiento);

        textoMedicacion.setText("Medicación");

        medicacion.setColumns(20);
        medicacion.setRows(5);
        scrollMedicacion.setViewportView(medicacion);

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

        textoVeterinario.setText("Número de colegiado");

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

        panelCabecera.setBackground(new java.awt.Color(0, 153, 0));

        subTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        subTitulo.setForeground(new java.awt.Color(255, 255, 255));
        subTitulo.setText("Agregar Ficha");
        subTitulo.setFocusable(false);

        titulo2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        titulo2.setForeground(new java.awt.Color(255, 255, 255));
        titulo2.setText("Centro de control de Fichas Médicas");

        javax.swing.GroupLayout panelCabeceraLayout = new javax.swing.GroupLayout(panelCabecera);
        panelCabecera.setLayout(panelCabeceraLayout);
        panelCabeceraLayout.setHorizontalGroup(
            panelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCabeceraLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(titulo2, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103)
                .addComponent(subTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelCabeceraLayout.setVerticalGroup(
            panelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCabeceraLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(panelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subTitulo)
                    .addComponent(titulo2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        subTitulo.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout panelSecundarioLayout = new javax.swing.GroupLayout(panelSecundario);
        panelSecundario.setLayout(panelSecundarioLayout);
        panelSecundarioLayout.setHorizontalGroup(
            panelSecundarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSecundarioLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(panelSecundarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollSintomas, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelSecundarioLayout.createSequentialGroup()
                        .addGroup(panelSecundarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textoVeterinario)
                            .addComponent(textoMascota)
                            .addComponent(textoSintomas))
                        .addGap(40, 40, 40)
                        .addGroup(panelSecundarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(comboMascotas, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboVeterinarios, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(textoMedicacion)
                    .addComponent(scrollMedicacion))
                .addGroup(panelSecundarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSecundarioLayout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(panelSecundarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelSecundarioLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(textoFecha)
                                .addGap(37, 37, 37)
                                .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(textoTratamiento)
                            .addComponent(scrollTratamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSecundarioLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelSecundarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSecundarioLayout.createSequentialGroup()
                                .addComponent(guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(volver, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(guardar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(60, Short.MAX_VALUE))
            .addComponent(panelCabecera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelSecundarioLayout.setVerticalGroup(
            panelSecundarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSecundarioLayout.createSequentialGroup()
                .addComponent(panelCabecera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(panelSecundarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSecundarioLayout.createSequentialGroup()
                        .addGroup(panelSecundarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textoVeterinario)
                            .addComponent(comboVeterinarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textoFecha))
                        .addGap(26, 26, 26)
                        .addGroup(panelSecundarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textoMascota)
                            .addComponent(comboMascotas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51)
                        .addComponent(textoSintomas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(scrollSintomas, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                        .addGap(57, 57, 57)
                        .addComponent(textoMedicacion)
                        .addGap(18, 18, 18))
                    .addGroup(panelSecundarioLayout.createSequentialGroup()
                        .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(99, 99, 99)
                        .addComponent(textoTratamiento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollTratamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(panelSecundarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelSecundarioLayout.createSequentialGroup()
                        .addComponent(scrollMedicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79))
                    .addGroup(panelSecundarioLayout.createSequentialGroup()
                        .addComponent(guardar1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addGroup(panelSecundarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(volver, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(68, 68, 68))))
        );

        getContentPane().add(panelSecundario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 740));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed

        panelPrincipal.setVisible(false);
        panelSecundario.setVisible(true);
        cargarVeterinarios();
        cargarMascotas();
        guardar.setVisible(true);
        guardar1.setVisible(false);
        subTitulo.setText("Agregar ficha");

    }//GEN-LAST:event_agregarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        borrarDatos();
    }//GEN-LAST:event_eliminarActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        int filaSeleccionada = tablaDatos.getSelectedRow();
        if (filaSeleccionada < 0) {
            JOptionPane.showMessageDialog(null, "Seleccione una ficha");
            return;
        }
        panelPrincipal.setVisible(false);
        panelSecundario.setVisible(true);
        modificarFicha();
        //cargarVeterinarios();
        //cargarMascotas();
        guardar.setVisible(false);
        guardar1.setVisible(true);
        subTitulo.setText("Modificar ficha");

    }//GEN-LAST:event_modificarActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        guardarDatos();
        panelPrincipal.setVisible(true);
        panelSecundario.setVisible(false);
        limpiarCampos(panelSecundario);
        cargarFichas();
    }//GEN-LAST:event_guardarActionPerformed

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        panelPrincipal.setVisible(true);
        panelSecundario.setVisible(false);
        limpiarCampos(panelSecundario);
        cargarFichas();

    }//GEN-LAST:event_volverActionPerformed

    private void comboVeterinariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboVeterinariosActionPerformed

    }//GEN-LAST:event_comboVeterinariosActionPerformed

    private void comboMascotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboMascotasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboMascotasActionPerformed

    private void guardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardar1ActionPerformed
        actualizarDatos();
        panelPrincipal.setVisible(true);
        panelSecundario.setVisible(false);
        limpiarCampos(panelSecundario);
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
    private javax.swing.JTextArea medicacion;
    private javax.swing.JButton modificar;
    private javax.swing.JPanel panelCabecera;
    private javax.swing.JPanel panelCabeceraPrincipal;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelSecundario;
    private javax.swing.JScrollPane scrollInicio;
    private javax.swing.JScrollPane scrollMedicacion;
    private javax.swing.JScrollPane scrollSintomas;
    private javax.swing.JScrollPane scrollTratamiento;
    private javax.swing.JTextArea sintomas;
    private javax.swing.JLabel subTitulo;
    private javax.swing.JTable tablaDatos;
    private javax.swing.JLabel textoFecha;
    private javax.swing.JLabel textoMascota;
    private javax.swing.JLabel textoMedicacion;
    private javax.swing.JLabel textoSintomas;
    private javax.swing.JLabel textoTratamiento;
    private javax.swing.JLabel textoVeterinario;
    private javax.swing.JLabel titulo;
    private javax.swing.JLabel titulo2;
    private javax.swing.JTextArea tratamiento;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}
