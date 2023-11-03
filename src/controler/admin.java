
package controler;
import java.sql.SQLException;
import databases.koneksi_database;


public class admin {
    // Membuat objek koneksi_database untuk terhubung ke database
    koneksi_database koneksi = new koneksi_database();
    
    // Deklarasi variabel yang akan digunakan untuk login
    public String Nama_Admin;
    public String Password;
    
    // Fungsi untuk melakukan login
    public boolean login() {
        
        // Inisialisasi flag keberhasilan operasi
        boolean isOperationSuccess = false;
        try {
            // Membuka koneksi ke database
            this.koneksi.openConnection();
        
            // Query SQL untuk mengambil admin berdasarkan Nama_Admin dan Password
            String sql = "SELECT * FROM admin WHERE Nama_Admin = ? AND Password = ?";
            
            // Mempersiapkan statement SQL
            this.koneksi.preparedStatement = this.koneksi.connection.prepareStatement(sql);
            
            // Mengatur parameter Nama_Admin
            this.koneksi.preparedStatement.setString(1, Nama_Admin);
            
            // Mengatur parameter Password
            this.koneksi.preparedStatement.setString(2, Password);
            
            // Mengeksekusi pernyataan SQL dan mendapatkan hasilnya
            this.koneksi.resultSet = this.koneksi.preparedStatement.executeQuery();
            
            // Jika ada hasil dari query (admin ditemukan), set isOperationSuccess menjadi true
            if (this.koneksi.resultSet.next()) {
                isOperationSuccess = true;
            }

        }catch (SQLException ex) {
            // Menampilkan pesan kesalahan jika terjadi kesalahan SQL
            this.koneksi.displayErrors(ex);
            
        }finally {
            // Selalu menutup koneksi ke database, baik setelah berhasil maupun gagal
            this.koneksi.closeConnection();
        }
        // Mengembalikan status keberhasilan operasi
        return isOperationSuccess;
    }    
}
