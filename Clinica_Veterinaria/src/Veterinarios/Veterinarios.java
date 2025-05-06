package Veterinarios;

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
public class Veterinarios extends javax.swing.JFrame {
    private Date date;
    private String nombre;
    private String apellidos;
    private int id_vet;
    
    public Veterinarios(Date date, String nombre, String apellidos, int id_vet){
        this.date=date;
        this.nombre=nombre;
        this.apellidos=apellidos;
        this.id_vet=id_vet;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getId_vet() {
        return id_vet;
    }

    public void setId_vet(int id_vet) {
        this.id_vet = id_vet;
    }

    
    
     /**
     * Creates new form veterinario
     */
    public Veterinarios() {
        initComponents();
        setLocationRelativeTo(null);
        //jLabel1.setVisible(false);
        Veterinarios2.setVisible(false);
        cargarVeterinario();

    }

    public void cargarVeterinario() {
    String url = "jdbc:mysql://localhost:3306/clinica_veterinaria";
    String usuario = "root";
    String contraseña = "";

    String sql = "SELECT NumeroColegiado, fechaNacimiento, nombre, apellidos FROM veterinario";

    try (Connection conn = DriverManager.getConnection(url, usuario, contraseña);
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {

        DefaultTableModel tabla = new DefaultTableModel();
        tabla.addColumn("Número Colegiado");
        tabla.addColumn("Fecha Nacimiento");
        tabla.addColumn("Nombre");
        tabla.addColumn("Apellidos");

        jTable2.setModel(tabla);

        while (rs.next()) {
            tabla.addRow(new Object[]{
                rs.getString("NumeroColegiado"),
                rs.getDate("fechaNacimiento"),
                rs.getString("nombre"),
                rs.getString("apellidos")
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

    // En cargarVeterinarios()
private void cargarVeterinarios() {
    String url = "jdbc:mysql://localhost:3306/clinica_veterinaria?useUnicode=true&characterEncoding=UTF-8";
    String usuario = "root";
    String contraseña = "";

    String sql = "SELECT NumeroColegiado, fechaNacimiento, nombre, apellidos FROM veterinario";

    try (Connection conn = DriverManager.getConnection(url, usuario, contraseña);
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {

        // Crear el modelo para la tabla
        DefaultTableModel tabla = new DefaultTableModel();
        tabla.addColumn("Número Colegiado");
        tabla.addColumn("Fecha Nacimiento");
        tabla.addColumn("Nombre");
        tabla.addColumn("Apellidos");

        // Asignar el modelo a la tabla
        jTable2.setModel(tabla);

        // Recorrer los resultados de la consulta y añadir filas al modelo
        while (rs.next()) {
            // Obtener el numero colegiado como int
            int numeroColegiado = rs.getInt("NumeroColegiado"); // Ahora es int
            Date fechaNacimiento = rs.getDate("fechaNacimiento");
            String nombre = rs.getString("nombre");
            String apellidos = rs.getString("apellidos");

            // Mostrar por consola los valores recuperados para depuración
            System.out.println("Número Colegiado: " + numeroColegiado + ", Nombre: " + nombre + ", Apellidos: " + apellidos);  // Depuración

            // Verificar si los valores de nombre y apellidos no son nulos
            if (nombre == null) {
                nombre = "No disponible";
            }
            if (apellidos == null) {
                apellidos = "No disponible";
            }

            // Añadir una nueva fila a la tabla
            tabla.addRow(new Object[]{
                numeroColegiado,  // Ahora es un int
                fechaNacimiento,
                nombre,
                apellidos
            });
        }

    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al cargar los veterinarios.");
    }
}
    
    
    // En cargarVeterinarios(String numeroColegiado)
private void cargarVeterinarios(String numeroColegiado) {
    String url = "jdbc:mysql://localhost:3306/clinica_veterinaria";
    String usuario = "root";
    String contraseña = "";

    String sql = "SELECT NumeroColegiado FROM veterinario WHERE NumeroColegiado = ?";

    try (Connection conn = DriverManager.getConnection(url, usuario, contraseña);
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, numeroColegiado);
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                numVeterinario.setText(rs.getString("NumeroColegiado"));
            } else {
                numVeterinario.setText("Veterinario no encontrado.");
            }
        }

    } catch (SQLException ex) {
        ex.printStackTrace();
        numVeterinario.setText("Error al cargar el veterinario.");
    }
}


   // guardarDatos(): ahora usa NumeroColegiado como clave
public void guardarDatos() {
   String nombre = name.getText();
    Date fechaNacimiento = fecha.getDate();
    java.sql.Date fechaSQL = new java.sql.Date(fechaNacimiento.getTime());
    String apellidos = subname.getText();
    String numeroColegiadoText = numVeterinario.getText().trim();
    int numeroColegiado = 0;

    // Verificar si el número de colegiado es un entero
    try {
        numeroColegiado = Integer.parseInt(numeroColegiadoText);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "El número de colegiado debe ser un número entero.");
        return;
    }

    String url = "jdbc:mysql://localhost:3306/clinica_veterinaria";
    String usuario = "root";
    String contraseña = "";

    String sql = "INSERT INTO veterinario (NumeroColegiado, fechaNacimiento, nombre, apellidos) VALUES (?, ?, ?, ?)";

    try (Connection conn = DriverManager.getConnection(url, usuario, contraseña);
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, numeroColegiado);
        stmt.setDate(2, fechaSQL);
        stmt.setString(3, nombre);
        stmt.setString(4, apellidos);

        stmt.executeUpdate();

        // Actualizar la tabla sin borrar nada
        DefaultTableModel tabla = (DefaultTableModel) jTable2.getModel();
        tabla.addRow(new Object[]{numeroColegiado, fechaSQL, nombre, apellidos});

        JOptionPane.showMessageDialog(null, "Veterinario guardado correctamente.");
        limpiarCampos(Veterinarios2); // Limpiar los campos solo si el guardado es exitoso

    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al guardar el veterinario.");
    }
}

    public void borrarDatos() {
    int filaSeleccionada = jTable2.getSelectedRow();
    if (filaSeleccionada < 0) {
        JOptionPane.showMessageDialog(null, "Seleccione un veterinario");
        return;
    }

    DefaultTableModel tabla = (DefaultTableModel) jTable2.getModel();
    String numeroColegiado = (String) tabla.getValueAt(filaSeleccionada, 0);

    String url = "jdbc:mysql://localhost:3306/clinica_veterinaria";
    String usuario = "root";
    String contraseña = "";

    String sql = "DELETE FROM veterinario WHERE NumeroColegiado = ?";

    try (Connection conn = DriverManager.getConnection(url, usuario, contraseña);
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, numeroColegiado);
        int filasEliminadas = stmt.executeUpdate();

        if (filasEliminadas > 0) {
            tabla.removeRow(filaSeleccionada);
            JOptionPane.showMessageDialog(null, "Veterinario eliminado.");
        }

    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}


public void modificarVeterinarios() {
   // Obtener la fila seleccionada en la tabla
    int filaSeleccionada = jTable2.getSelectedRow();
    System.out.println("Fila seleccionada: " + filaSeleccionada);  // Depuración
    if (filaSeleccionada < 0) {
        JOptionPane.showMessageDialog(null, "Seleccione un veterinario para modificar.");
        return;
    }

    // Obtener el número de colegiado de la tabla
    DefaultTableModel tabla = (DefaultTableModel) jTable2.getModel();
    String numeroColegiado = (String) tabla.getValueAt(filaSeleccionada, 0);
    System.out.println("Número de colegiado: " + numeroColegiado);  // Depuración

    // Limpiar los campos antes de llenarlos
    name.setText("");
    subname.setText("");
    fecha.setDate(null);
    numVeterinario.setText("");

    // Conectar a la base de datos para obtener la información del veterinario
    String url = "jdbc:mysql://localhost:3306/clinica_veterinaria";
    String usuario = "root";
    String contraseña = "";

    String sql = "SELECT fechaNacimiento, nombre, apellidos FROM veterinario WHERE NumeroColegiado = ?";

    try (Connection conn = DriverManager.getConnection(url, usuario, contraseña);
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, numeroColegiado);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            Date fechaNacimiento = rs.getDate("fechaNacimiento");
            String nombre = rs.getString("nombre");
            String apellidos = rs.getString("apellidos");

            // Depuración: mostrar los datos recuperados
            System.out.println("Nombre: " + nombre + ", Apellidos: " + apellidos + ", Fecha Nacimiento: " + fechaNacimiento);

            // Llenar los campos con los datos recuperados
            name.setText(nombre);
            subname.setText(apellidos);
            fecha.setDate(fechaNacimiento);
            numVeterinario.setText(numeroColegiado);  // Este es el número de colegiado

        } else {
            JOptionPane.showMessageDialog(null, "No se encontró información para el veterinario seleccionado.");
        }

    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al cargar los datos para modificar.");
    }
}

    // actualizarDatos()
public void actualizarDatos() {
     int filaSeleccionada = jTable2.getSelectedRow();
    if (filaSeleccionada < 0) {
        JOptionPane.showMessageDialog(null, "Seleccione un veterinario para actualizar.");
        return;
    }

    // Obtener los nuevos valores de los campos del formulario
    String nombre = name.getText();
    Date fechaNacimiento = fecha.getDate();
    java.sql.Date fechaSQL = new java.sql.Date(fechaNacimiento.getTime());
    String apellidos = subname.getText();
    
    // Validar que el número de colegiado sea un número entero
    String numeroColegiadoText = numVeterinario.getText().trim();
    int numeroColegiado = 0;

    try {
        numeroColegiado = Integer.parseInt(numeroColegiadoText);  // Intentar convertir a int
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "El número de colegiado debe ser un número entero.");
        return;
    }

    // Verificar que los campos no estén vacíos
    if (nombre.isEmpty() || apellidos.isEmpty() || fechaNacimiento == null) {
        JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.");
        return;
    }

    String url = "jdbc:mysql://localhost:3306/clinica_veterinaria";
    String usuario = "root";
    String contraseña = "";

    String sql = "UPDATE veterinario SET fechaNacimiento = ?, nombre = ?, apellidos = ? WHERE NumeroColegiado = ?";

    try (Connection conn = DriverManager.getConnection(url, usuario, contraseña);
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setDate(1, fechaSQL);
        stmt.setString(2, nombre);
        stmt.setString(3, apellidos);
        stmt.setInt(4, numeroColegiado);  // Ahora es int

        stmt.executeUpdate();

        // Actualizar la tabla sin eliminarla
        DefaultTableModel tabla = (DefaultTableModel) jTable2.getModel();
        tabla.setValueAt(fechaSQL, filaSeleccionada, 1);  // Actualizar la fecha
        tabla.setValueAt(nombre, filaSeleccionada, 2);    // Actualizar el nombre
        tabla.setValueAt(apellidos, filaSeleccionada, 3); // Actualizar los apellidos

        // Mostrar mensaje de éxito
        JOptionPane.showMessageDialog(null, "Veterinario actualizado correctamente.");

    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al actualizar veterinario.");
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

        Veterinarios1 = new javax.swing.JPanel();
        agregar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        modificar = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        Veterinarios2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        name = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        subname = new javax.swing.JTextArea();
        guardar = new javax.swing.JButton();
        volver = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        fecha = new com.toedter.calendar.JDateChooser();
        guardar1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        numVeterinario = new javax.swing.JTextArea();

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

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(jTable2);

        jPanel3.setBackground(new java.awt.Color(0, 153, 0));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Centro de control de Veterinarios");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 689, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Veterinarios1Layout = new javax.swing.GroupLayout(Veterinarios1);
        Veterinarios1.setLayout(Veterinarios1Layout);
        Veterinarios1Layout.setHorizontalGroup(
            Veterinarios1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(Veterinarios1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addGroup(Veterinarios1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        Veterinarios1Layout.setVerticalGroup(
            Veterinarios1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Veterinarios1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(Veterinarios1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Veterinarios1Layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Veterinarios1Layout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(198, Short.MAX_VALUE))
        );

        getContentPane().add(Veterinarios1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 740));

        jLabel5.setText("Fecha Nacimiento");

        jLabel6.setText("nombre");

        name.setColumns(20);
        name.setRows(5);
        jScrollPane1.setViewportView(name);

        jLabel7.setText("Apellidos");

        subname.setColumns(20);
        subname.setRows(5);
        jScrollPane2.setViewportView(subname);

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

        guardar1.setText("Guardar");
        guardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardar1ActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(0, 153, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Agregar Veterinario");
        jLabel1.setFocusable(false);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Centro de control de Veterinarios");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jLabel1.getAccessibleContext().setAccessibleDescription("");

        numVeterinario.setColumns(20);
        numVeterinario.setRows(5);
        jScrollPane3.setViewportView(numVeterinario);

        javax.swing.GroupLayout Veterinarios2Layout = new javax.swing.GroupLayout(Veterinarios2);
        Veterinarios2.setLayout(Veterinarios2Layout);
        Veterinarios2Layout.setHorizontalGroup(
            Veterinarios2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(Veterinarios2Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(Veterinarios2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Veterinarios2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Veterinarios2Layout.createSequentialGroup()
                        .addGroup(Veterinarios2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(Veterinarios2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(Veterinarios2Layout.createSequentialGroup()
                                .addComponent(guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(guardar1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)))
                        .addGroup(Veterinarios2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Veterinarios2Layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(Veterinarios2Layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(volver, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(148, Short.MAX_VALUE))
        );
        Veterinarios2Layout.setVerticalGroup(
            Veterinarios2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Veterinarios2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                .addGroup(Veterinarios2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Veterinarios2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(fecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(Veterinarios2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel5)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(Veterinarios2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Veterinarios2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(Veterinarios2Layout.createSequentialGroup()
                            .addGap(44, 44, 44)
                            .addComponent(jLabel6))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Veterinarios2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(Veterinarios2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(68, 68, 68)
                .addGroup(Veterinarios2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(volver, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(guardar1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(330, 330, 330))
        );

        getContentPane().add(Veterinarios2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 740));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed

        Veterinarios1.setVisible(false);
        Veterinarios2.setVisible(true);
        cargarVeterinarios();
        guardar.setVisible(true);
        guardar1.setVisible(false);
        jLabel1.setText("Agregar Veterinario");

    }//GEN-LAST:event_agregarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        borrarDatos();
    }//GEN-LAST:event_eliminarActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        int filaSeleccionada = jTable2.getSelectedRow();
        if (filaSeleccionada < 0) {
            JOptionPane.showMessageDialog(null, "Seleccione un Veterinario");
            return;
        }
        Veterinarios1.setVisible(false);
        Veterinarios2.setVisible(true);
        modificarVeterinarios();
        //cargarVeterinarios();
        //cargarMascotas();
        guardar.setVisible(false);
        guardar1.setVisible(true);
        jLabel1.setText("Modificar Veterinario");

    }//GEN-LAST:event_modificarActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        guardarDatos();
        Veterinarios1.setVisible(true);
        Veterinarios2.setVisible(false);
        limpiarCampos(Veterinarios2);
        cargarVeterinarios();
    }//GEN-LAST:event_guardarActionPerformed

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        Veterinarios1.setVisible(true);
        Veterinarios2.setVisible(false);
        limpiarCampos(Veterinarios2);
        cargarVeterinarios();

    }//GEN-LAST:event_volverActionPerformed

    private void guardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardar1ActionPerformed
        actualizarDatos();
        Veterinarios1.setVisible(true);
        Veterinarios2.setVisible(false);
        limpiarCampos(Veterinarios2);
        cargarVeterinarios();
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
            java.util.logging.Logger.getLogger(Veterinarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Veterinarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Veterinarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Veterinarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Veterinarios().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Veterinarios1;
    private javax.swing.JPanel Veterinarios2;
    private javax.swing.JButton agregar;
    private javax.swing.JButton eliminar;
    private com.toedter.calendar.JDateChooser fecha;
    private javax.swing.JButton guardar;
    private javax.swing.JButton guardar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton modificar;
    private javax.swing.JTextArea name;
    private javax.swing.JTextArea numVeterinario;
    private javax.swing.JTextArea subname;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}
