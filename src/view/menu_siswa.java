
package view;
import controler.siswa;
import databases.koneksi_database;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class menu_siswa extends javax.swing.JFrame {

// Metode untuk menampilkan data siswa pada tabel    
private void showData(){
    koneksi_database db = new koneksi_database();
        
        db.openConnection();
        
        // Mengambil data siswa dari database dengan query SQL.
        ArrayList<ArrayList> pengajar = db.all("SELECT ID_Siswa, Nama_Siswa, Jenis_Kelamin, KURSUS_MUSIK_ID_Kursus FROM siswa;");
        
        DefaultTableModel model = new DefaultTableModel();

        // Menambahkan kolom-kolom ke model tabel.
        model.addColumn("Siswa ID");
        model.addColumn("Nama Siswa");
        model.addColumn("Jenis Kelamin");
        model.addColumn("ID Kursus");
        
    // Mengisi data dari ArrayList ke model tabel.
    for (ArrayList<String> rowData : pengajar) {
        model.addRow(rowData.toArray());
        }
        db.closeConnection();
        
        // Menetapkan model tabel ke elemen JTable "siswatabel" dalam GUI.
        siswatabel.setModel(model);
    }    

    // Konstruktor untuk kelas menu_siswa
    public menu_siswa() {
        initComponents();
        
        // Memanggil metode showdData() saat objek menu_siswa dibuat untuk menampilkan data siswa.
        showData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        idsiswatxt = new javax.swing.JTextField();
        namasiswatxt = new javax.swing.JTextField();
        jeniskelcb = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        kursusMusik = new javax.swing.JComboBox<>();
        tambahbtn = new javax.swing.JButton();
        editbtn = new javax.swing.JButton();
        hapusbtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        siswatabel = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        kembalibtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/menu siswa.png"))); // NOI18N

        jPanel3.setBackground(new java.awt.Color(255, 204, 255));

        jLabel1.setText("ID_Siswa");

        jLabel3.setText("Nama_Siswa:");

        jLabel4.setText("Jenis_Kelamin");

        idsiswatxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idsiswatxtActionPerformed(evt);
            }
        });

        jeniskelcb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "laki-laki", "perempuan" }));

        jLabel6.setText("ID_Kursus:");

        kursusMusik.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "G01", "D02", "K03" }));
        kursusMusik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kursusMusikActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(idsiswatxt)
                        .addComponent(namasiswatxt, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE))
                    .addComponent(jeniskelcb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kursusMusik, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(idsiswatxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(namasiswatxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jeniskelcb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kursusMusik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        tambahbtn.setText("Tambah");
        tambahbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahbtnActionPerformed(evt);
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

        hapusbtn.setText("Hapus");
        hapusbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusbtnActionPerformed(evt);
            }
        });

        siswatabel.setModel(new javax.swing.table.DefaultTableModel(
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
        siswatabel.getTableHeader().setReorderingAllowed(false);
        siswatabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                siswatabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(siswatabel);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel5.setText("CRUD DATA SISWA");

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
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(113, 113, 113))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(tambahbtn)
                        .addGap(70, 70, 70)
                        .addComponent(editbtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(hapusbtn)
                        .addGap(51, 51, 51))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(kembalibtn)
                        .addContainerGap(389, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel5)
                .addGap(30, 30, 30)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tambahbtn)
                    .addComponent(editbtn)
                    .addComponent(hapusbtn))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(kembalibtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 779, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 506, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idsiswatxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idsiswatxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idsiswatxtActionPerformed

    private void kembalibtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kembalibtnActionPerformed
        // Membuat objek "menu" (kelas lain) yang akan digunakan untuk kembali ke menu utama.
        menu mn = new menu();
        
        // Menampilkan menu utama dengan menjadikan objek "mn" visible.
        mn.setVisible(true);
        
        // Menutup jendela (frame) saat ini, yaitu jendela tempat tombol "kembalibtn" ditempatkan.
        this.dispose();        
    }//GEN-LAST:event_kembalibtnActionPerformed

    private void tambahbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahbtnActionPerformed
        siswa ins = new siswa();

        // Mendapatkan nilai dari inputan
        String idSiswa = idsiswatxt.getText();
        String namaSiswa = namasiswatxt.getText();
        String jenisKelamin = (String) jeniskelcb.getSelectedItem();
        String kursusMusikID = kursusMusik.getSelectedItem().toString();

        // Validasi input tidak boleh kosong
        if (idSiswa.isEmpty() || namaSiswa.isEmpty() || jenisKelamin.isEmpty() || kursusMusikID.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Semua Kolom Input Harus Diisi!");
            return; // Menghentikan operasi jika ada input yang kosong
        }

        // Validasi ID Siswa (3 huruf awalan "sws" dan 2 angka bebas di belakangnya)
        if (!idSiswa.matches("^sws\\d{2}$")) {
            JOptionPane.showMessageDialog(null, "ID Siswa Harus dimulai dengan 'sws' dan diikuti oleh 2 angka!");
            return; // Menghentikan operasi jika ID Siswa tidak valid
        }

        // Validasi Nama siswa saat mengedit (hanya huruf dan spasi, maksimal 25 karakter)
        if (!namaSiswa.matches("^[a-zA-Z\\s]{1,25}$")) {
            JOptionPane.showMessageDialog(null, "Nama Siswa Harus Maksimal 25 Karakter (Hanya Berisi Huruf dan Spasi)!");
            return; // Menghentikan operasi jika Nama Siswa tidak valid
        }

        // Mengisi objek siswa dengan data yang valid
        ins.ID_Siswa = idSiswa;
        ins.Nama_Siswa = namaSiswa;
        ins.idadmin = "jovi";
        ins.Jenis_Kelamin = jenisKelamin;
        ins.KursusMusikID = kursusMusikID;

        // Menyimpan data jika valid
        if (ins.create()){
            showData();
            JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan.");            
            System.out.println(">>> Data Berhasil Ditambahkan <<<"); 
        } else {
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan.");
        }

    }//GEN-LAST:event_tambahbtnActionPerformed

    private void editbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editbtnActionPerformed
    siswa ank = new siswa();
    
    int getSelectedRow = siswatabel.getSelectedRow();
    if (getSelectedRow != -1) {
        // Mengambil data yang dipilih dari baris terpilih di tabel
        String idSiswa = siswatabel.getValueAt(getSelectedRow, 0).toString();
        String namaSiswa = namasiswatxt.getText();
        String jenisKelamin = jeniskelcb.getSelectedItem().toString();
        String kursusMusikID = kursusMusik.getSelectedItem().toString();

        // Validasi input tidak boleh kosong
        if (idSiswa.isEmpty() || namaSiswa.isEmpty() || jenisKelamin.isEmpty() || kursusMusikID.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Semua Kolom Input Harus Diisi!");
            return; // Menghentikan operasi jika ada input yang kosong
        }

        // Validasi Nama siswa saat mengedit (hanya huruf dan spasi, maksimal 25 karakter)
        if (!namaSiswa.matches("^[a-zA-Z\\s]{1,25}$")) {
            JOptionPane.showMessageDialog(null, "Nama Siswa Harus Maksimal 25 Karakter (Hanya Berisi Huruf dan Spasi)!");
            return; // Menghentikan operasi jika Nama Siswa tidak valid
        }

        // Mengisi objek siswa dengan data yang valid
        ank.ID_Siswa = idSiswa;
        ank.Nama_Siswa = namaSiswa;
        ank.Jenis_Kelamin = jenisKelamin;
        ank.KursusMusikID = kursusMusikID;

        if (ank.update()) {
            showData();
            JOptionPane.showMessageDialog(null, "Data Berhasil Diubah.");
            System.out.println(">>> Data Berhasil Diubah <<<");
            showData();
        } else {
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan.");
        }
    } else {
        JOptionPane.showMessageDialog(null, "Pilih baris terlebih dahulu.");
    }

        
             
    }//GEN-LAST:event_editbtnActionPerformed

    private void hapusbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusbtnActionPerformed
        // Membuat objek "siswa" untuk mengelola data siswa.
        siswa sws = new siswa();
        
        // Mengambil nilai yang akan dihapus dari JTextField "idsiswatxt".
        String hapus = idsiswatxt.getText();

        // Mencari data siswa dengan ID yang sesuai.
        sws.find(hapus);

        // Menampilkan dialog konfirmasi untuk mengonfirmasi penghapusan data.
        int confirm = JOptionPane.showConfirmDialog(null, "Anda Yakin Ingin Menghapus Data Siswa Ini?", "Konfirmasi Hapus Data", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            // Jika pengguna memilih "Ya" dalam dialog konfirmasi
            
            if (sws.delete()) {
            // Menghapus data siswa dari database dan menampilkan data siswa yang diperbarui.
                
                showData();
                // Menampilkan pesan sukses kepada pengguna menggunakan dialog JOptionPane.
                JOptionPane.showMessageDialog(null, "Berhasil Dihapus.");
                
                // Mencetak pesan sukses ke konsol.
                System.out.println("Siswa Berhasil Dihapus.");
            }
        } else {
            // Tidak ada tindakan jika pengguna memilih "Tidak"
        }       
    }//GEN-LAST:event_hapusbtnActionPerformed

    private void siswatabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_siswatabelMouseClicked
        // Mendapatkan baris yang dipilih oleh pengguna dalam tabel "siswatabel".
        int selectedrow = siswatabel.getSelectedRow();
        
        // Mengambil nilai ID Siswa dari kolom pertama (indeks 0) pada baris yang dipilih dan menetapkannya pada JTextField "idsiswatxt".
        String id = siswatabel.getValueAt(selectedrow, 0).toString();
        idsiswatxt.setText(id);
        
        // Mengambil nama siswa dari kolom kedua (indeks 1) pada baris yang dipilih dan menetapkannya pada JTextField "namasiswatxt".
        String nama = siswatabel.getValueAt(selectedrow, 1).toString();
        namasiswatxt.setText(nama);
        
        // Mengambil jenis kelamin dari kolom ketiga (indeks 2) pada baris yang dipilih dan menetapkannya pada JComboBox "jeniskelcb".
        String jeniskelamin = siswatabel.getValueAt(selectedrow, 2) .toString();
        jeniskelcb.setSelectedItem(jeniskelamin);
        
        // Mengambil ID kursus dari kolom keempat (indeks 3) pada baris yang dipilih dan menetapkannya pada JComboBox "kursusMusik".
        String idkursus = siswatabel.getValueAt(selectedrow, 3) .toString();
        kursusMusik.setSelectedItem(idkursus);       
    }//GEN-LAST:event_siswatabelMouseClicked

    private void editbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editbtnMouseClicked
        // TODO add your handling code here:
    
    }//GEN-LAST:event_editbtnMouseClicked

    private void kursusMusikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kursusMusikActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kursusMusikActionPerformed


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
            java.util.logging.Logger.getLogger(menu_siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu_siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu_siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu_siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu_siswa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton editbtn;
    private javax.swing.JButton hapusbtn;
    private javax.swing.JTextField idsiswatxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jeniskelcb;
    private javax.swing.JButton kembalibtn;
    private javax.swing.JComboBox<String> kursusMusik;
    private javax.swing.JTextField namasiswatxt;
    private javax.swing.JTable siswatabel;
    private javax.swing.JButton tambahbtn;
    // End of variables declaration//GEN-END:variables
}
