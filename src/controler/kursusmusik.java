
package controler;
import databases.koneksi_database;
import java.sql.SQLException;


// Deklarasi class `kursusmusik`
public class kursusmusik {
    
    // Membuat objek koneksi_database untuk terhubung ke database
    koneksi_database koneksi = new koneksi_database();
    
    // Deklarasi variabel instance untuk menyimpan informasi tentang kursus musik
    public String ID_Kursus;        // ID kursus musik
    public String Jumlah_Siswa;     // Jumlah siswa yang mengikuti kursus musik
    public String id_ins;           // ID instruktur yang mengajar kursus musik
    public String materidrum;       // Materi Kursus Drum
    public String tipekursusgitar;  // tipe kursus gitar
    public String jeniskursuskey;   // jenis kursus keyboard
    
    // Konstruktor untuk class `kursusmusik` dengan tiga parameter
    public kursusmusik(String idKursus, String jumlahSiswa, String idIns) {
        this.ID_Kursus = idKursus;
        this.Jumlah_Siswa = jumlahSiswa;
        this.id_ins = idIns;
    }
    
    // Konstruktor kosong untuk class `kursusmusik`
    public kursusmusik(){
    }
    
    // Metode untuk mendapatkan ID kursus musik
    public String getId() {
        return this.ID_Kursus;
    }
    
    // Metode untuk mendapatkan jumlahsiswa
    public String getjumlahsiswa(){
        return this.Jumlah_Siswa;
    }
    
    // Metode untuk mendapatkan ID instruktur
    public String getidinstruktur(){
        return this.id_ins;
    }
    
    // Metode untuk mendapatkan materi drum pada subtype drum
    public String getmateridrum(){
        return this.materidrum;
    }
    
    // Metode untuk mendapatkan tipe kursus gitar pada subtype gitar
    public String gettipekursusgitar(){
        return this.tipekursusgitar;
    }
    
    // Metode untuk mendapatkan jenis kursus keyboard pada subtype keyboard
    public String getjeniskursuskey(){
        return this.jeniskursuskey;
    }
    
    
    // Metode untuk mencari kursus musik berdasarkan ID_Kursus
    public boolean find(String id) {
        boolean isOperationSuccess = false;
        
        try {
            // Membuka koneksi ke database
            this.koneksi.openConnection();
            
            // Mempersiapkan pernyataan SQL untuk mengambil data kursus musik berdasarkan ID_Kursus
            this.koneksi.preparedStatement = this.koneksi.connection.prepareStatement("SELECT * FROM kursus_musik WHERE ID_Kursus = ?");
            
            // Mengatur parameter dengan nilai ID_Kursus
            this.koneksi.preparedStatement.setString(1, id);
            
            // Mengeksekusi pernyataan SQL dan mendapatkan hasilnya
            this.koneksi.resultSet = this.koneksi.preparedStatement.executeQuery();
            
            // Jika data kursus musik ditemukan, mengisi variabel-variabel instance dengan data yang sesuai
            if (this.koneksi.resultSet.next()) {
                this.ID_Kursus = id;
                this.Jumlah_Siswa = this.koneksi.resultSet.getString("Jumlah_Siswa");

                isOperationSuccess = true;
            }
        } catch (SQLException ex) {
            // Menampilkan pesan kesalahan jika terjadi kesalahan SQL
            this.koneksi.displayErrors(ex);
            
        } finally {
            // Selalu menutup koneksi ke database, baik setelah berhasil maupun gagal
            this.koneksi.closeConnection();
        }
        
        return isOperationSuccess;
    }
    
    // Metode untuk memperbarui data kursus musik
    public boolean update() {
        boolean isOperationSuccess = false;
        
        try {
            // Membuka koneksi ke database
            this.koneksi.openConnection();
            
            // Mendefinisikan pernyataan SQL untuk mengupdate data kursus musik
            String sql = "UPDATE kursus_musik "
                    + "SET jumlah_siswa = ? "
                    + "WHERE ID_Kursus = ?";
            
            // Mempersiapkan pernyataan SQL
            this.koneksi.preparedStatement = this.koneksi.connection.prepareStatement(sql);
            
            this.koneksi.preparedStatement.setString(1, this.Jumlah_Siswa);
            this.koneksi.preparedStatement.setString(2, this.ID_Kursus);

            // Mengeksekusi pernyataan SQL dan mendapatkan hasilnya
            int result = this.koneksi.preparedStatement.executeUpdate();
            
            // Jika operasi update berhasil, mengubah nilai isOperationSuccess menjadi true
            if (result > 0) {
                isOperationSuccess = true;
            }
        } catch (SQLException ex) {
            // Menampilkan pesan kesalahan jika terjadi kesalahan SQL
            System.out.println(ex);
            
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
}    