
package controler;
import java.sql.SQLException;

// Deklarasi class `drum` yang merupakan subkelas dari class `kursusmusik`
public class gitar extends kursusmusik {
    public String ID_Kursus;
    public String jumlah_siswa;
    public String INSTRUKTUR_ID_Instruktur;
    public String Tipe_Kursus_Gitar;
    
    @Override
    public String getId() {
        return this.ID_Kursus;
    }
    
    // Metode untuk mendapatkan jumlahsiswa
    @Override
    public String getjumlahsiswa(){
        return this.Jumlah_Siswa;
    }
    
    // Metode untuk mendapatkan ID instruktur
    @Override
    public String getidinstruktur(){
        return this.id_ins;
    }
    
    // Metode untuk mendapatkan tipe kursus gitar pada subtype gitar
    @Override
    public String gettipekursusgitar(){
        return this.tipekursusgitar;
    }
    
    public boolean tampilgitar() {
        
        // Inisialisasi flag keberhasilan operasi
        boolean isOperationSuccess = false;
        try {
            // Membuka koneksi ke database
            this.koneksi.openConnection();
        
            
            String sql = "SELECT t.*, g.Tipe_Kursus_Gitar FROM kursus_musik t JOIN gitar g ON t.ID_Kursus = g.ID_Kursus WHERE t.jumlah_siswa = ? AND t.INSTRUKTUR_ID_Instruktur = ?;";
            
            // Mempersiapkan statement SQL
            this.koneksi.preparedStatement = this.koneksi.connection.prepareStatement(sql);
            
            // Mengatur parameter ID Kursus
            this.koneksi.preparedStatement.setString(1, ID_Kursus);
            
            // Mengatur parameter Jumlah siswa
            this.koneksi.preparedStatement.setString(2, jumlah_siswa);
            
            // Mengatur parameter id insturktur
            this.koneksi.preparedStatement.setString(3, INSTRUKTUR_ID_Instruktur);
            
            // Mengatur parameter materi kursus drum
            this.koneksi.preparedStatement.setString(4, Tipe_Kursus_Gitar);
            
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
