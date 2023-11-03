
package controler;
import java.sql.SQLException;


// Deklarasi class `drum` yang merupakan subkelas dari class `kursusmusik`
public class keyboard extends kursusmusik {
    public String ID_Kursus;
    public String jumlah_siswa;
    public String INSTRUKTUR_ID_Instruktur;
    public String Jenis_Kursus_Keyboard;
    
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
        return this.jeniskursuskey;
    }
    
    public boolean tampilkeyboard() {
        
        // Inisialisasi flag keberhasilan operasi
        boolean isOperationSuccess = false;
        try {
            // Membuka koneksi ke database
            this.koneksi.openConnection();
        
            
            String sql = "SELECT k.*, b.Jenis_Kursus_Keyboard FROM kursus_musik k JOIN keyboard b ON k.ID_Kursus = b.ID_Kursus WHERE k.jumlah_siswa = ? AND k.INSTRUKTUR_ID_Instruktur = ?;";
            
            // Mempersiapkan statement SQL
            this.koneksi.preparedStatement = this.koneksi.connection.prepareStatement(sql);
            
            // Mengatur parameter ID Kursus
            this.koneksi.preparedStatement.setString(1, ID_Kursus);
            
            // Mengatur parameter Jumlah siswa
            this.koneksi.preparedStatement.setString(2, jumlah_siswa);
            
            // Mengatur parameter id insturktur
            this.koneksi.preparedStatement.setString(3, INSTRUKTUR_ID_Instruktur);
            
            // Mengatur parameter materi kursus drum
            this.koneksi.preparedStatement.setString(4, Jenis_Kursus_Keyboard);
            
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
