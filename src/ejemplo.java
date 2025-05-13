
public class ejemplo extends javax.swing.JFrame {

    public ejemplo() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        saludo = new javax.swing.JLabel();
        boton = new javax.swing.JButton();
        texto = new javax.swing.JTextField();
        box = new javax.swing.JCheckBox();
        combo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.FlowLayout());

        saludo.setBackground(new java.awt.Color(100, 200, 0));
        saludo.setText("Hola");
        getContentPane().add(saludo);

        boton.setText("hola bebito");
        boton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActionPerformed(evt);
            }
        });
        getContentPane().add(boton);

        texto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoActionPerformed(evt);
            }
        });
        getContentPane().add(texto);

        box.setText("confirmar");
        box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxActionPerformed(evt);
            }
        });
        getContentPane().add(box);

        combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "pene", "vagina", "pollita", "chochillo" }));
        combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboActionPerformed(evt);
            }
        });
        getContentPane().add(combo);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActionPerformed
    if(box.isSelected()){
        texto.setText("activado");
        
    }else{
        texto.setText("desactivado");
    }
    }//GEN-LAST:event_botonActionPerformed

    private void textoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoActionPerformed
    
    }//GEN-LAST:event_textoActionPerformed

    private void boxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxActionPerformed

    private void comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboActionPerformed
    texto.setText(combo.getSelectedItem().toString());
    }//GEN-LAST:event_comboActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ejemplo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton;
    private javax.swing.JCheckBox box;
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JLabel saludo;
    private javax.swing.JTextField texto;
    // End of variables declaration//GEN-END:variables
}
