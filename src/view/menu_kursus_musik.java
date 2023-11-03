
package view;

import controler.kursusmusik;
import databases.koneksi_database;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class menu_kursus_musik extends javax.swing.JFrame {

    // // Metode untuk melempar pengecualian "Not Supported Yet" jika digunakan
    private void throwError(){
        throw new UnsupportedOperationException("Not Supported Yet");
    }

    // Konstruktor untuk kelas menu_kursus_musik
    public menu_kursus_musik() {
        initComponents();
        showData(); // Memanggil metode showdData() saat objek menu_kursus_musik dibuat.
    }
    
    // Metode untuk menampilkan data dari database ke tabel
    private void showData(){
    koneksi_database db = new koneksi_database();
        
        db.openConnection(); // Membuka koneksi ke database.
        
        // Mengambil data dari database dengan query SQL dan menyimpannya dalam ArrayList.
        ArrayList<ArrayList> pengajar = db.all("SELECT * FROM kursus_musik");
        
        DefaultTableModel model = new DefaultTableModel();

       // Menambahkan kolom-kolom ke model tabel.
        model.addColumn("ID_Kursus");
        model.addColumn("Jumlah_Siswa");
        model.addColumn("INSTRUKTUR_ID_Instruktur");
        
    // Mengisi data dari ArrayList ke tabel model.
    for (ArrayList<String> rowData : pengajar) {
        model.addRow(rowData.toArray());
    }
        db.closeConnection(); // Menutup koneksi ke database setelah selesai.
        tabelkursus.setModel(model); // Menetapkan model tabel ke tabelkursus di GUI.
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jumlahsiswatxt = new javax.swing.JTextField();
        editbtn = new javax.swing.JButton();
        idKursus = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelkursus = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        kembalibtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/kursusmusik.png"))); // NOI18N

        jPanel3.setBackground(new java.awt.Color(255, 204, 204));

        jLabel3.setText("ID_Kursus:");

        jLabel4.setText("Jumlah_Siswa:");

        jumlahsiswatxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jumlahsiswatxtActionPerformed(evt);
            }
        });

        editbtn.setText("Edit");
        editbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editbtnMouseClicked(evt);
            }
        });
        editbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editbtnActionPerformed(evt);
            }
        });

        idKursus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "G01", "D02", "K03" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jumlahsiswatxt, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idKursus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(editbtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(idKursus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jumlahsiswatxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(editbtn)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        tabelkursus.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelkursus.getTableHeader().setReorderingAllowed(false);
        tabelkursus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelkursusMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelkursus);

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 0));
        jLabel2.setText("MENU KURSUS MUSIK");

        kembalibtn.setText("KEMBALI");
        kembalibtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kembalibtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 27, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(kembalibtn)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 19, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(kembalibtn)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 759, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 484, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void kembalibtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kembalibtnActionPerformed
        // Membuat objek menu (kelas lain) yang akan digunakan untuk kembali ke menu utama.
        menu mn = new menu();
        // Menampilkan menu utama dengan menjadikan objek mn visible.
        mn.setVisible(true);
        // Menutup jendela (frame) saat ini, yaitu jendela tempat tombol kembalibtn ditempatkan.
        this.dispose();        
    }//GEN-LAST:event_kembalibtnActionPerformed

    private void tabelkursusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelkursusMouseClicked
        // Mengambil baris yang diklik dalam tabel "tabelkursus" menggunakan koordinat mouse.
        int baris = tabelkursus.rowAtPoint(evt.getPoint());
        
        // Mengambil nilai dari kolom pertama (indeks 0) pada baris yang diklik dan mengonversinya ke string.
        String idkursus = tabelkursus.getValueAt(baris, 0) .toString();
        
        // Menetapkan nilai "idkursus" ke item yang dipilih pada elemen JComboBox "idKursus".
        idKursus.setSelectedItem(idkursus);
        
        // Mengambil nilai dari kolom kedua (indeks 1) pada baris yang diklik dan mengonversinya ke string.
        String inst = tabelkursus.getValueAt(baris, 1). toString();
        
        // Menetapkan nilai "inst" ke elemen JTextField "jumlahsiswatxt".
        jumlahsiswatxt.setText(inst);  
    }//GEN-LAST:event_tabelkursusMouseClicked

    private void editbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editbtnActionPerformed
        kursusmusik km = new kursusmusik();
        // Mendapatkan nilai dari inputan
        String ID_Kursus = (String) idKursus.getSelectedItem();
        String jumlahsiswa = jumlahsiswatxt.getText().trim();

        if (ID_Kursus.isEmpty() || jumlahsiswa.isEmpty()) {
            JOptionPane.showMessageDialog(null, "ID Kursus dan Jumlah Siswa tidak boleh kosong.");
        } else {
            km.ID_Kursus = ID_Kursus;

            try {
                // Coba parsing jumlah siswa ke dalam tipe data integer
                int jumlahSiswaInt = Integer.parseInt(jumlahsiswa);
                km.Jumlah_Siswa = Integer.toString(jumlahSiswaInt);

                if (km.update()) {
                    JOptionPane.showMessageDialog(null, "Berhasil Diupdate.");
                    System.out.println("Berhasil Diupdate.");
                    showData();
                } else {
                    JOptionPane.showMessageDialog(null, "Terjadi Kesalahan.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Jumlah Siswa harus berupa angka.");
            }
        }

        
        
    }//GEN-LAST:event_editbtnActionPerformed

    private void jumlahsiswatxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jumlahsiswatxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jumlahsiswatxtActionPerformed

    private void editbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editbtnMouseClicked
        // Mengambil nilai terpilih dari JComboBox "idKursus" dan mengonversinya ke dalam string.
        String stringValue = idKursus.getSelectedItem().toString();
        
        // Membuat objek "kursusmusik".
        kursusmusik instruktur = new kursusmusik();
        
        // Mengatur nilai atribut "Jumlah_Siswa" pada objek "instruktur" dari nilai yang ada di JTextField "jumlahsiswatxt".
        instruktur.Jumlah_Siswa = jumlahsiswatxt.getText();
        
        // Mencari data dengan ID yang sesuai dan mengisi objek "instruktur" dengan data yang ditemukan.
        instruktur.find(stringValue);

        // Memperbarui data di database dengan nilai yang ada dalam objek "instruktur".
        if (instruktur.update()) {
            
            // Menampilkan data yang diperbarui pada antarmuka pengguna.
            showData();
            
            // Menampilkan pesan sukses kepada pengguna menggunakan dialog JOptionPane.
            JOptionPane.showMessageDialog(null, "Berhasil Diupdate");
            
            // Mencetak pesan sukses ke konsol
            System.out.println("Berhasil Diupdate.");
            
            // Melempar pengecualian "Not Supported Yet" jika metode "update" berhasil dieksekusi.
            throwError();
        }        
    }//GEN-LAST:event_editbtnMouseClicked

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
            java.util.logging.Logger.getLogger(menu_kursus_musik.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu_kursus_musik.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu_kursus_musik.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu_kursus_musik.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu_kursus_musik().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton editbtn;
    private javax.swing.JComboBox<String> idKursus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jumlahsiswatxt;
    private javax.swing.JButton kembalibtn;
    private javax.swing.JTable tabelkursus;
    // End of variables declaration//GEN-END:variables

}
