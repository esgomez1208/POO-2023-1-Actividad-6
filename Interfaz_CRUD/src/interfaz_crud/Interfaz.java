package interfaz_crud;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.NumberFormatException;

public class Interfaz extends javax.swing.JFrame {

    public Interfaz() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCreate = new javax.swing.JButton();
        btnRead = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        txtNumero = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnCreate.setText("Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnRead.setText("Read");
        btnRead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReadActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre:");

        jLabel2.setText("Numero:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(btnCreate)
                .addGap(66, 66, 66)
                .addComponent(btnRead)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addComponent(btnUpdate)
                .addGap(55, 55, 55)
                .addComponent(btnDelete)
                .addGap(32, 32, 32))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(143, 143, 143)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(90, 90, 90)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRead, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(80, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        try {
            String newName = String.valueOf(txtNombre.getText());
            
            long newNumber = Long.parseLong(txtNumero.getText());
 
            String nameNumberString;
            String name;
            long number;
            int index;
            
            File file = new File("D:\\Documents\\National University Of Colombia\\Seventh Semester\\POO\\Actividades\\Actividad #6\\Amigos.txt");
 
            if (!file.exists()) {
                
                file.createNewFile();
            }
 
            // Opening file in reading and write mode.
 
            RandomAccessFile raf
                = new RandomAccessFile(file, "rw");
            boolean found = false;
 
            // Checking whether the name
            // of contact already exists.
            // getFilePointer() give the current offset
            // value from start of the file.
            while (raf.getFilePointer() < raf.length()) {
 
                // reading line from the file.
                nameNumberString = raf.readLine();
 
                // splitting the string to get name and
                // number
                String[] lineSplit
                    = nameNumberString.split("!");
 
                // separating name and number.
                name = lineSplit[0];
                number = Long.parseLong(lineSplit[1]);
 
                // if condition to find existence of record.
                if (name == newName || number == newNumber) {
                    found = true;
                    break;
                }
            }
 
            if (found == false) {

                nameNumberString = newName + "!" + String.valueOf(newNumber);
                
                raf.writeBytes(nameNumberString);
 
                raf.writeBytes(System.lineSeparator());
 
                System.out.println(" Friend added. ");
 
                raf.close();
            }
            
            else {
 
                // Closing the resources.
                raf.close();
 
                // Print the message
                System.out.println(" Input name" + " does not exists. ");
            }
        }
 
        catch (IOException ioe) {
 
            System.out.println(ioe);
        }
        catch (NumberFormatException nef) {
 
            System.out.println(nef);
        }
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReadActionPerformed
        try {
 
            String nameNumberString;
            String name;
            long number;
            int index;
 
            File file = new File("D:\\Documents\\National University Of Colombia\\Seventh Semester\\POO\\Actividades\\Actividad #6\\Amigos.txt");
 
            if (!file.exists()) {
 
                file.createNewFile();
            }
 
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            boolean found = false;
 
            while (raf.getFilePointer() < raf.length()) {
 
                nameNumberString = raf.readLine();
 
                String[] lineSplit = nameNumberString.split("!");
 
                name = lineSplit[0];
                number = Long.parseLong(lineSplit[1]);
 
                System.out.println("Nombre Amigo: " + name + "\n" + "Numero Contacto: " + number + "\n");
            }
        }
 
        catch (IOException ioe)
        {

            System.out.println(ioe);
        }
        catch (NumberFormatException nef)
        {

            System.out.println(nef);
        }
    }//GEN-LAST:event_btnReadActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
 
            String newName = String.valueOf(txtNombre.getText());
 
            long newNumber = Long.parseLong(txtNumero.getText());
 
            String nameNumberString;
            String name;
            long number;
            int index;
 
            File file = new File("D:\\Documents\\National University Of Colombia\\Seventh Semester\\POO\\Actividades\\Actividad #6\\Amigos.txt");
 
            if (!file.exists()) {
 
                file.createNewFile();
            }
 
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            boolean found = false;
 
            while (raf.getFilePointer() < raf.length()) {
 
                nameNumberString = raf.readLine();
 
                String[] lineSplit = nameNumberString.split("!");
 
                name = lineSplit[0];
                number = Long.parseLong(lineSplit[1]);
 
                if (name.equals(newName) || number == newNumber) {
                    found = true;
                    break;
                }
            }
 
            if (found == true) {
 
                File tmpFile = new File("D:\\Documents\\National University Of Colombia\\Seventh Semester\\POO\\Actividades\\Actividad #6\\temp.txt");
 
                RandomAccessFile tmpraf = new RandomAccessFile(tmpFile, "rw");
 
                raf.seek(0);
 
                while (raf.getFilePointer() < raf.length()) {
                    
                    long currentPosition = raf.getFilePointer();
 
                    nameNumberString = raf.readLine();
 
                    index = nameNumberString.indexOf('!');
                    name = nameNumberString.substring(0, index);
 
                    if (name.equals(newName)) {
                        
                        nameNumberString = name + "!" + String.valueOf(newNumber);
                    }
 
                    tmpraf.writeBytes(nameNumberString);
 
                    tmpraf.writeBytes(System.lineSeparator());
                }
 
                raf.seek(0);
                tmpraf.seek(0);
 
                while (tmpraf.getFilePointer() < tmpraf.length()) {
                    raf.writeBytes(tmpraf.readLine());
                    raf.writeBytes(System.lineSeparator());
                }
 
                raf.setLength(tmpraf.length());
 
                tmpraf.close();
                raf.close();
 
                tmpFile.delete();
 
                System.out.println(" Friend updated. ");
            }
 
            else {
 
                raf.close();
 
                System.out.println(" Input name" + " does not exists. ");
            }
        }
 
        catch (IOException ioe) {
            System.out.println(ioe);
        }
 
        catch (NumberFormatException nef) {
            System.out.println(nef);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
 
            String newName = String.valueOf(txtNombre.getText());
 
            String nameNumberString;
            String name;
            long number;
            int index;
 
            File file = new File("D:\\Documents\\National University Of Colombia\\Seventh Semester\\POO\\Actividades\\Actividad #6\\Amigos.txt");
 
            if (!file.exists()) {
 
                file.createNewFile();
            }
 
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            boolean found = false;
 
            while (raf.getFilePointer() < raf.length()) {
 
                nameNumberString = raf.readLine();
 
                String[] lineSplit = nameNumberString.split("!");
 
                name = lineSplit[0];
                number = Long.parseLong(lineSplit[1]);
 
                if (name.equals(newName)) {
                    found = true;
                    break;
                }
            }
 
            if (found == true) {
 
                File tmpFile = new File("D:\\Documents\\National University Of Colombia\\Seventh Semester\\POO\\Actividades\\Actividad #6\\temp.txt");
 
                RandomAccessFile tmpraf = new RandomAccessFile(tmpFile, "rw");
 
                raf.seek(0);
 
                while (raf.getFilePointer() < raf.length()) {
 
                    nameNumberString = raf.readLine();
 
                    index = nameNumberString.indexOf('!');
                    name = nameNumberString.substring(0, index);
 
                    if (name.equals(newName)) {
 
                        raf.readLine();
                        continue;
                    }
 
                    tmpraf.writeBytes(nameNumberString);
 
                    tmpraf.writeBytes(System.lineSeparator());
                }
 
                raf.seek(0);
                tmpraf.seek(0);
 
                while (tmpraf.getFilePointer() < tmpraf.length()) {
                    raf.writeBytes(tmpraf.readLine());
                    raf.writeBytes(System.lineSeparator());
                }
 
                raf.setLength(tmpraf.length());
 
                tmpraf.close();
                raf.close();
 
                tmpFile.delete();
 
                System.out.println(" Friend deleted. ");
            }
 
            else {
 
                raf.close();
 
                System.out.println(" Input name" + " does not exists. ");
            }
        }
 
        catch (IOException ioe) {
            System.out.println(ioe);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    
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
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnRead;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumero;
    // End of variables declaration//GEN-END:variables
}
