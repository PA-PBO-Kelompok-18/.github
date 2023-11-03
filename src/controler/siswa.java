
package controler;
import databases.koneksi_database;
import java.sql.SQLException;


// Deklarasi class `siswa`
public class siswa {
    // Membuat objek koneksi_database untuk terhubung ke database
    koneksi_database koneksi = new koneksi_database();
    
    // Deklarasi variabel instance untuk menyimpan informasi tentang siswa
    public String ID_Siswa;          // ID siswa
    public String Nama_Siswa;        // Nama siswa   
    public String Jenis_Kelamin;    // Jenis kelamin siswa
    public String KursusMusikID;    // ID kursus musik yang diikuti siswa
    public String Jumlah_Siswa;     // Jumlah siswa yang diikuti dalam kursus musik
    public String idadmin;          // ID admin yang mengelola siswa

    // Metode `getId()`: Mengembalikan ID_Siswa.
    public String getId() {
        return this.ID_Siswa;
    }
    
    // Metode `getJumlah()`: Mengembalikan Jumlah_Siswa.
    public String getJumlah() {
        return this.Jumlah_Siswa;
    }
    
    // Metode `find(String ID_Siswa)`: Digunakan untuk mencari siswa berdasarkan ID_Siswa.
    public String find(String ID_Siswa) {
        boolean isOperationSuccess = false;
        
        try {
            // Membuka koneksi ke database
            this.koneksi.openConnection();
            
            // Mempersiapkan pernyataan SQL untuk mengambil data siswa berdasarkan ID_Siswa
            this.koneksi.preparedStatement = this.koneksi.connection.prepareStatement("SELECT * FROM siswa WHERE ID_Siswa = ?");
            
            // Mengatur parameter dengan nilai ID_Siswa
            this.koneksi.preparedStatement.setString(1, ID_Siswa);
            
            // Mengeksekusi pernyataan SQL dan mendapatkan hasilnya
            this.koneksi.resultSet = this.koneksi.preparedStatement.executeQuery();
            
            // Jika data siswa ditemukan, mengisi variabel-variabel instance dengan data yang sesuai
            if (this.koneksi.resultSet.next()) {
                this.ID_Siswa = ID_Siswa;
                this.Nama_Siswa = this.koneksi.resultSet.getString("Nama_Siswa");
                this.Jenis_Kelamin = this.koneksi.resultSet.getString("Jenis_Kelamin");                

                isOperationSuccess = true;
            }
        } catch (SQLException ex) {
            // Menampilkan pesan kesalahan jika terjadi kesalahan SQL
            this.koneksi.displayErrors(ex);
        } finally {
            // Selalu menutup koneksi ke database, baik setelah berhasil maupun gagal
            this.koneksi.closeConnection();
        }
        
        return ID_Siswa;
    }
    
    // Metode `create()`: Digunakan untuk membuat data siswa baru.
    public boolean create() {
        boolean isOperationSuccess = false;
        
        try {
            // Membuka koneksi ke database
            this.koneksi.openConnection();
            
            // Mendefinisikan pernyataan SQL untuk menambahkan data siswa ke tabel siswa
            String sql = "INSERT INTO siswa VALUES (?, ?, ?, ?, ?)";
            this.koneksi.preparedStatement = this.koneksi.connection.prepareStatement(sql);
            
            // Mengatur parameter dengan nilai-nilai dari variabel instance
            this.koneksi.preparedStatement.setString(1, this.ID_Siswa);
            this.koneksi.preparedStatement.setString(2, this.Nama_Siswa);
            this.koneksi.preparedStatement.setString(3, this.idadmin);         
            this.koneksi.preparedStatement.setString(4, this.Jenis_Kelamin);
            this.koneksi.preparedStatement.setString(5, this.KursusMusikID);

            // Mengeksekusi pernyataan SQL dan mendapatkan hasilnya
            int result = this.koneksi.preparedStatement.executeUpdate();
            
            // Jika operasi penambahan berhasil, mengubah nilai isOperationSuccess menjadi true
            isOperationSuccess = result > 0;
        } catch (SQLException ex) {
            // Menampilkan pesan kesalahan jika terjadi kesalahan SQL
            this.koneksi.displayErrors(ex);
        } finally {
            // Selalu menutup koneksi ke database, baik setelah berhasil maupun gagal
            this.koneksi.closeConnection();
        }
        
        return isOperationSuccess;
    } 
    
    // Metode `update()`: Digunakan untuk memperbarui data siswa yang sudah ada.
    public boolean update() {
        boolean isOperationSuccess = false;
        
        try {
            // Membuka koneksi ke database
            this.koneksi.openConnection();
            
            // Mendefinisikan pernyataan SQL untuk memperbarui data siswa
            String sql = "UPDATE siswa "
            + "SET Nama_Siswa = ?, "     // Mengupdate Nama_Siswa
            + "Jenis_Kelamin = ? "      // Mengupdate Jenis_Kelamin                
            + "WHERE ID_Siswa = ?";    // Berdasarkan ID_Siswa
            
            this.koneksi.preparedStatement = this.koneksi.connection.prepareStatement(sql);
            
            // Mengatur parameter dengan nilai-nilai dari variabel instance
            this.koneksi.preparedStatement.setString(1, this.Nama_Siswa);       // Mengupdate Nama_Siswa      
            this.koneksi.preparedStatement.setString(2, this.Jenis_Kelamin);    // Mengupdate Jenis_Kelamin              
            this.koneksi.preparedStatement.setString(3, this.ID_Siswa);         // Berdasarkan ID_Siswa     
            
            // Mengeksekusi pernyataan SQL dan mendapatkan hasilnya
            int result = this.koneksi.preparedStatement.executeUpdate();
            
            // Jika operasi update berhasil, mengubah nilai isOperationSuccess menjadi true
            isOperationSuccess = result > 0;
        } catch (SQLException ex) {
            // Menampilkan pesan kesalahan jika terjadi kesalahan SQL
            this.koneksi.displayErrors(ex);
            
        } finally {
            // Selalu menutup koneksi ke database, baik setelah berhasil maupun gagal
            this.koneksi.closeConnection();
        }
        
        return isOperationSuccess;
    }
    
    // Metode `delete()`: Digunakan untuk menghapus data siswa.
    public boolean delete() {
        boolean isOperationSuccess = false;
        
        try {
            // Membuka koneksi ke database
            this.koneksi.openConnection();
            
            // Mendefinisikan pernyataan SQL untuk menghapus data siswa berdasarkan ID_Siswa
            String sql = "DELETE FROM siswa WHERE ID_Siswa = ?";
            this.koneksi.preparedStatement = this.koneksi.connection.prepareStatement(sql);
            
            // Mengatur parameter dengan nilai ID_Siswa
            this.koneksi.preparedStatement.setString(1, this.ID_Siswa);
            
            // Mengeksekusi pernyataan SQL dan mendapatkan hasilnya
            int result = this.koneksi.preparedStatement.executeUpdate();
            
            // Jika operasi penghapusan berhasil, mengubah nilai isOperationSuccess menjadi true
            isOperationSuccess = result > 0;
            
        } catch (SQLException ex) {
            // Menampilkan pesan kesalahan jika terjadi kesalahan SQL
            this.koneksi.displayErrors(ex);
            
        } finally {
            // Selalu menutup koneksi ke database, baik setelah berhasil maupun gagal
            this.koneksi.closeConnection();
        }
        // Mengembalikan status keberhasilan operasi
        return isOperationSuccess;
    }
    

    public void find(int intValue) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setJumlahSiswa(int Jumla_Siswa) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setJumlahSiswa(String jumlahsiswa) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}   
