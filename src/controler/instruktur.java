
package controler;
import databases.koneksi_database;
import java.sql.SQLException;


// Deklarasi class `instruktur`
public class instruktur {
    // Membuat objek koneksi_database untuk terhubung ke database
    koneksi_database koneksi = new koneksi_database();
    
    // Deklarasi variabel instance untuk menyimpan informasi tentang instruktur
    public String ID_Instruktur;      // ID instruktur
    public String Nama_Instruktur;   // Nama instruktur 
    public String Bidang_Musik;     // Bidang musik yang dikuasai oleh instruktur

    
    // Metode untuk mendapatkan ID instruktur
    public String getId() {
        return this.ID_Instruktur;
    }
    
    // Metode untuk mencari instruktur berdasarkan ID_Instruktur
    public boolean find(String ID_Instruktur) {
        boolean isOperationSuccess = false;
        
        try {
            // Membuka koneksi ke database
            this.koneksi.openConnection();
            
            // Mempersiapkan pernyataan SQL untuk mengambil data instruktur berdasarkan ID_Instruktur
            this.koneksi.preparedStatement = this.koneksi.connection.prepareStatement("SELECT * FROM instruktur WHERE ID_Instruktur = ?");
            
            // Mengatur parameter dengan nilai ID_Instruktur
            this.koneksi.preparedStatement.setString(1, ID_Instruktur);
            
            // Mengeksekusi pernyataan SQL dan mendapatkan hasilnya
            this.koneksi.resultSet = this.koneksi.preparedStatement.executeQuery();
            
            // Jika data instruktur ditemukan, mengisi variabel-variabel instance dengan data yang sesuai
            if (this.koneksi.resultSet.next()) {
                this.ID_Instruktur = ID_Instruktur;
                this.Nama_Instruktur = this.koneksi.resultSet.getString("Nama_Instruktur");
                this.Bidang_Musik = this.koneksi.resultSet.getString("Bidang_Musik");                

                
                isOperationSuccess = true;
            }
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
}    