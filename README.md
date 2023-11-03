# Dokumentasi Sistem Pengelolaan Data Pada Sebuah Kursus Musik Gratis
[Sistem Pengelolaan Data Pada Sebuah Kursus Musik Gratis](#Tema PA Kelompok 18 PBO)

# KELOMPOK 18:
  Nama Anggota:
- JOVIANA YOUNG (2209116012)
- RIKAD ANGGORO PUTRA (2209116044)
  
# Kelas:
  SISTEM INFORMASI A 2022

# Deskripsi Proyek
Sistem Pengelolaan Data Pada Sebuah Kursus Musik Gratis adalah sebuah sistem yang digunakan untuk membantu admin
dalam mengelola data yang terdapat pada sebuah kursus musik, yang dulunya data disimpan dalam bentuk catatan yang
dimana besar kemungkinan akan mengalami kehilangan data, dan dengan dibuatnya sistem ini dapat membantu serta
meminimalisir terjadinya kesalahan dalam penginputan data maupun kerentanan hilangnya data.
sistem ini dibuat dengan menggunakan bahasa pemrograman java.
   
# Flowchart
![FLOWCHART PA PBO drawio](https://github.com/PA-PBO-Kelompok-18/.github/assets/124419335/29c8ed02-0989-4580-8959-a096faa1d958)

# Entity Relationship Diagram (ERD)
- [Logical Model](#logical-model)
![Logical](https://github.com/PA-PBO-Kelompok-18/.github/assets/124419335/2ab1d8df-1aee-4f6b-93ca-c6d2fd6d88fa)

- [Relational Model](#relational-model)
![Relational_1](https://github.com/PA-PBO-Kelompok-18/.github/assets/124419335/7e423bd6-aef0-4ce9-935e-61a1b6f9d35e)

# Hierarki Kelas
![hierarki drawio](https://github.com/PA-PBO-Kelompok-18/.github/assets/124419335/53548cdd-1c0e-4274-96eb-3e9423306ba0)

# Screenshot Kodingan
Pada program yang dibuat terdapat 4 package yaitu Controler, Databases, Gambar, dan View. Dimana Controler berisi kelas yang digunakan untuk mengatur logika pada suatu program,
Databases berisi kelas yang digunakan untuk menghubungkan codingan dengan database, Gambar digunakan untuk menyimpan file gambar yang digunakan pada GUI,
View berisi kelas yang digunakan untuk mengatur tampilan. Berikut adalah screenshoot codingan program. 

# Package Controler 
## kelas admin
Kode ini adalah bagian dari sebuah Java class yang disebut "admin" dalam paket "controler."
 Tujuannya adalah untuk melakukan proses login admin ke dalam sistem dengan menggunakan data yang tersimpan dalam sebuah database.
``` java

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

```
## kelas siswa
Pada kelas ini memungkinkan pengelolaan data siswa dan kursus musik, yang mencakup operasi pencarian data, pembuatan data baru, pembaruan data yang ada, dan penghapusan data yang tidak diperlukan.
Data ini disimpan dalam sebuah database, dan kodingan ini memfasilitasi interaksi dengan database untuk mengelola data dengan lebih efisien dalam konteks manajemen kursus musik.
``` java

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

```

## kelas instruktur
Kode ini adalah bagian dari sebuah Java class yang disebut "instruktur" yang bertujuan untuk mengakses dan mengelola data tentang instruktur dalam sebuah sistem yang 
digunakan untuk mencari dan mengambil informasi tentang instruktur berdasarkan ID_Instruktur tertentu dari database,
dan ini dapat digunakan dalam manajemen data instruktur dalam sistem.
```java

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
```

## kelas kursusmusik
Kode ini adalah sebuah Java class yang disebut "kursusmusik" yang berperan dalam mengelola data kursus musik dalam sebuah sistem. 
ini berfungsi untuk mencari dan mengupdate data kursus musik dalam database berdasarkan ID_Kursus tertentu,
serta mengambil nilai-nilai terkait kursus musik dari variabel instance.
```java

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
```

## kelas drum
 Kode ini adalah bagian dari sebuah Java class yang disebut "drum," yang merupakan subkelas dari class "kursusmusik."
 Tujuannya adalah untuk mengakses data kursus musik tipe "drum" dari database berdasarkan sejumlah kriteria tertentu. Tetapi saya tidak memanggil subkelas ini untuk digunakan.
```java

package controler;
import java.sql.SQLException;

// Deklarasi class `drum` yang merupakan subkelas dari class `kursusmusik`
public class drum extends kursusmusik {
    public String ID_Kursus;
    public String jumlah_siswa;
    public String INSTRUKTUR_ID_Instruktur;
    public String Materi_Kursus_Drum;
    
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
    
    // Metode untuk mendapatkan materi drum pada subtype drum
    @Override
    public String getmateridrum(){
        return this.materidrum;
    }

        
    public boolean tampildrum() {
        
        // Inisialisasi flag keberhasilan operasi
        boolean isOperationSuccess = false;
        try {
            // Membuka koneksi ke database
            this.koneksi.openConnection();
        
            
            String sql = "SELECT k.*, d.Materi_Kursus_Drum FROM kursus_musik k JOIN drum d ON k.ID_Kursus = d.ID_Kursus WHERE k.jumlah_siswa = ? AND k.INSTRUKTUR_ID_Instruktur = ?";
            
            // Mempersiapkan statement SQL
            this.koneksi.preparedStatement = this.koneksi.connection.prepareStatement(sql);
            
            // Mengatur parameter ID Kursus
            this.koneksi.preparedStatement.setString(1, ID_Kursus);
            
            // Mengatur parameter Jumlah siswa
            this.koneksi.preparedStatement.setString(2, jumlah_siswa);
            
            // Mengatur parameter id insturktur
            this.koneksi.preparedStatement.setString(3, INSTRUKTUR_ID_Instruktur);
            
            // Mengatur parameter materi kursus drum
            this.koneksi.preparedStatement.setString(4, Materi_Kursus_Drum);
            
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
```

## kelas keyboard
Kode ini adalah bagian dari sebuah Java class yang disebut "keyboard," yang merupakan subkelas dari class "kursusmusik."
Tujuannya adalah untuk mengakses data kursus musik tipe "keyboard" dari database berdasarkan sejumlah kriteria tertentu. Tetapi saya tidak memanggil subkelas ini untuk digunakan.
```java

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
```

## kelas gitar
Kode ini adalah bagian dari sebuah Java class yang disebut "gitar," yang juga merupakan subkelas dari class "kursusmusik."
Tujuannya adalah untuk mengakses data kursus musik tipe "gitar" dari database berdasarkan sejumlah kriteria tertentu. Tetapi saya tidak memanggil subkelas ini untuk digunakan.
```java

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
```

# Package Databases
## kelas koneksi_database
Secara keseluruhan, kelas "koneksi_database" ini bertujuan untuk mengelola koneksi dan operasi dasar dengan database MySQL,
yang dapat digunakan dalam aplikasi Java untuk berinteraksi dengan database dan melakukan operasi seperti pengambilan,
penyimpanan, pembaruan, dan penghapusan data.
``` java

package databases;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import java.util.ArrayList;


public class koneksi_database {
    private final static String dbhost = "localhost"; // nama hostnya
    private final static String dbname = "pa_pbo"; // nama databasenya
    private final static String username = "root"; // username mysql
    private final static String password = ""; // password mysql
    
    public Connection connection = null;
    
    protected Statement statement;
    public PreparedStatement preparedStatement;
    public ResultSet resultSet;
    
    public final void openConnection() {
        try {
            // Bentuk stringnya: "jdbc:mysql://dbhost/dbname?user=username&password=password"
            this.connection = DriverManager.getConnection(
                "jdbc:mysql://"
                + koneksi_database.dbhost
                + "/"
                + koneksi_database.dbname
                + "?user="
                + koneksi_database.username
                + "&password="
                + koneksi_database.password
            );
        } catch (SQLException ex) {
            this.displayErrors(ex);
        }
    }
    
    public final void closeConnection() {
        try {
            if (this.resultSet != null) this.resultSet.close();
            if (this.statement != null) this.statement.close();
            if (this.preparedStatement != null) this.preparedStatement.close();
            if (this.connection != null) this.connection.close();
            
            this.resultSet = null;
            this.statement = null;
            this.preparedStatement = null;
            this.connection = null;
        } catch (SQLException ex) {
            this.displayErrors(ex);
        }
    }
    
     public final ArrayList<ArrayList> all(String query) {
        ArrayList<ArrayList> rows = new ArrayList();
        
        try {
            this.statement = this.connection.createStatement();
            this.resultSet = this.statement.executeQuery(query);
            
            while (this.resultSet.next()) {
                // mengambil jumlah kolom yang ada di tabel
                ResultSetMetaData rsMetaData = this.resultSet.getMetaData();
                int columnCount = rsMetaData.getColumnCount();
                
                ArrayList<String> columns = new ArrayList();
                
                for (int i = 1; i <= columnCount; i++) {
                    columns.add(this.resultSet.getString(i));
                }
                
                rows.add(columns);
            }
        } catch (SQLException ex) {
            this.displayErrors(ex);
        }
        
        return rows;
    }
    
    public final int generateLastId() {
        try {
            if (this.statement != null) {
                this.resultSet = this.statement.getGeneratedKeys();
            }
            
            if (this.preparedStatement != null) {
                this.resultSet = this.preparedStatement.getGeneratedKeys();
            }
            
            if (this.resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (SQLException ex) {
            this.displayErrors(ex);
        }
        
        return 0;
    }
    
    public final void displayErrors(SQLException ex) {
        System.out.println("SQLException: " + ex.getMessage());
        System.out.println("SQLState: " + ex.getSQLState());
        System.out.println("VendorError: " + ex.getErrorCode());
    }    
}

```

# Package Gambar
Dalam package ini hanya berupa gambar yang disimpan untuk keperluan desain di gui.

![image](https://github.com/PA-PBO-Kelompok-18/.github/assets/124419335/cb42a62b-11a7-4ad8-a723-53c60d0aae5c)


# Package View
## kelas login
Kode ini berisi form login dengan dua input: username (usertxt) dan password (passwordtxt). Pengguna dapat memasukkan username dan password,
kemudian mengklik tombol "LOGIN" untuk memproses login. Ini adalah bagian dari antarmuka pengguna (UI) untuk form login dalam sebuah aplikasi Java.
Pengguna dapat memasukkan informasi login, dan aplikasi akan memproses login berdasarkan informasi yang dimasukkan.
```java
// Package view: Ini adalah package yang berisi kelas-kelas yang mengatur tampilan antarmuka pengguna (UI).
// Import controler.admin: Mengimpor kelas 'admin' dari package 'controler' untuk mengakses fungsionalitas login.
// Import javax.swing.JOptionPane: Mengimpor JOptionPane untuk menampilkan pesan dialog.
package view;
import controler.admin;
import javax.swing.JOptionPane;

// Konstruktor ini digunakan untuk menginisialisasi komponen-komponen UI.
public class login extends javax.swing.JFrame {

    public login() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        usertxt = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        passwordtxt = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 153, 204));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/RUMAH MUSIK.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel2.setText("SELAMAT DATANG PADA MENU LOGIN!");

        jLabel4.setText("Username:");

        jLabel5.setText("Password:");

        usertxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usertxtActionPerformed(evt);
            }
        });

        jButton1.setText("LOGIN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(60, 60, 60)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(usertxt, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                                    .addComponent(passwordtxt))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usertxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(passwordtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(113, 113, 113))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    private void usertxtActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    }                                       

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // Membuat objek 'admin' untuk mengelola proses login.
        admin lgn = new admin();
        
        // Mengambil nama admin dan kata sandi dari inputan pengguna.
        lgn.Nama_Admin = usertxt.getText();     // Mengambil nama admin dari inputan
        lgn.Password = passwordtxt.getText(); // Mengambil kata sandi dari inputan
        
        // Memeriksa hasil dari proses login menggunakan metode 'login' dari objek 'admin'.
        if (lgn.login()){
            // Jika login berhasil, tampilkan pesan "Login Berhasil".
            JOptionPane.showMessageDialog(null, "Login Berhasil");
            
            // Buka tampilan menu (menu utama) dan tutup tampilan login.
            menu mn = new menu();
            mn.setVisible(true);
            this.dispose();
            
        }else {
            // Jika login gagal, tampilkan pesan "Login Gagal".
            JOptionPane.showMessageDialog(null, "Login Gagal");
        }
    }                                        

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField passwordtxt;
    private javax.swing.JTextField usertxt;
    // End of variables declaration                   
}
```

## kelas menu
 kode digunakan untuk untuk mengatur tampilan antarmuka pengguna dan method-event yang berkaitan dengan tombol yang memproses tindakan pengguna ketika tombol ditekan pada kelas menu.
```java

package view;

public class menu extends javax.swing.JFrame {

    public menu() {
        // Memanggil method `initComponents()` untuk menginisialisasi komponen GUI dari frame `menu`.
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 153, 204));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/MENU.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 18)); // NOI18N
        jLabel2.setText("MENU UTAMA");

        jButton1.setBackground(new java.awt.Color(153, 255, 255));
        jButton1.setText("Menampilkan Data Instruktur");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 204));
        jButton2.setText("CRUD Siswa");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(204, 255, 204));
        jButton3.setText("Edit Jumlah Siswa Kursus Musik");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("LOGOUT");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(76, 76, 76))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addGap(48, 48, 48))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(jButton4)
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
            .addGap(0, 731, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>                        

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // Membuat objek `menu_instruktur` yang merupakan tampilan menu instruktur.
        menu_instruktur mnins = new menu_instruktur();
        // Menampilkan tampilan menu instruktur.
        mnins.setVisible(true);
        // Menutup tampilan menu utama (frame saat ini).
        this.dispose();        
    }                                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // Membuat objek `menu_siswa` yang merupakan tampilan menu siswa.
        menu_siswa mnsis = new menu_siswa();
        // Menampilkan tampilan menu siswa.
        mnsis.setVisible(true);
        // Menutup tampilan menu utama (frame saat ini).
        this.dispose();        
    }                                        

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // Membuat objek `menu_kursus_musik` yang merupakan tampilan menu kursus_musik.
        menu_kursus_musik mnkurs = new menu_kursus_musik();
        // Menampilkan tampilan menu kursus_musik.
        mnkurs.setVisible(true);
        // Menutup tampilan menu utama (frame saat ini).
        this.dispose();        
    }                                        

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // Membuat objek login yang merupakan tampilan untuk halaman login yang akan ditampilkan.
        login ln = new login();
        //  Mengatur visibilitas objek login menjadi true, sehingga tampilan halaman login akan ditampilkan di layar.
        ln.setVisible(true);
        // Menutup tampilan menu utama (frame saat ini) dengan menghapusnya dari layar.
        this.dispose();
    }                                        

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
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration                   
}
```

## kelas menu_instruktur
kode ini digunakan untuk menampilkan data instruktur dari database ke dalam tabel saat tampilan menu instruktur diakses, dan memberikan kemampuan pengguna untuk kembali ke menu utama.
```java

package view;

import databases.koneksi_database;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;


public class menu_instruktur extends javax.swing.JFrame {
    
private void showdData(){
    // Membuat objek koneksi_database
    koneksi_database db = new koneksi_database();
        
        // Membuka koneksi ke database
        db.openConnection();
        
        // Mengambil data dari database dengan mengirimkan perintah SQL
        ArrayList<ArrayList> pengajar = db.all("SELECT * FROM instruktur");
        
        // Membuat model tabel dengan DefaultTableModel
        DefaultTableModel model = new DefaultTableModel();

       // Menambahkan kolom-kolom ke model tabel
        model.addColumn("ID_Instruktur");
        model.addColumn("Nama_Instruktur");
        model.addColumn("Bidang_Musik");
        model.addColumn("Admin ID");
        model.addColumn("Dikepalai Oleh");
        
    // Mengisi model tabel dengan data dari database
    for (ArrayList<String> rowData : pengajar) {
        model.addRow(rowData.toArray());
    }
        // Menutup koneksi ke database
        db.closeConnection();
        // Mengatur model tabel ke tabel instrukturtabel
        instrukturtabel.setModel(model);
}
    // konstruktor kelas menu_instruktur yang dipanggil ketika objek tampilan menu instruktur dibuat.
    public menu_instruktur() {
        // Metode initComponents() dijalankan untuk menginisialisasi komponen GUI.
        initComponents();
        // Kemudian, metode showdData() dipanggil untuk menampilkan data instruktur ke dalam tabel pada saat tampilan menu instruktur dibuat.
        showdData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        instrukturtabel = new javax.swing.JTable();
        kembalibtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(2835, 581));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/instruktur.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 153));
        jLabel2.setText("DATA INSTRUKTUR");

        instrukturtabel.setModel(new javax.swing.table.DefaultTableModel(
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
        instrukturtabel.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(instrukturtabel);

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
                .addComponent(jLabel1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(kembalibtn)
                                .addGap(49, 49, 49))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
                                .addContainerGap())))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(140, 140, 140))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(kembalibtn)
                .addGap(72, 72, 72))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 802, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 805, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 2, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 1, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 501, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>                        

    private void kembalibtnActionPerformed(java.awt.event.ActionEvent evt) {                                           

        menu mn = new menu();
        mn.setVisible(true);
        this.dispose();
    }                                          

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
            java.util.logging.Logger.getLogger(menu_instruktur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu_instruktur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu_instruktur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu_instruktur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu_instruktur().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JTable instrukturtabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton kembalibtn;
    // End of variables declaration                   
}
```

## kelas menu_kursus_musik
kode ini digunakan untuk menampilkan data kursus musik dari database ke dalam tabel, memungkinkan pengguna untuk mengedit data kursus musik, dan kembali ke menu utama.
Pemrosesan data input dari pengguna juga dilakukan, termasuk validasi input.
```java

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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
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
    }// </editor-fold>                        

    private void kembalibtnActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // Membuat objek menu (kelas lain) yang akan digunakan untuk kembali ke menu utama.
        menu mn = new menu();
        // Menampilkan menu utama dengan menjadikan objek mn visible.
        mn.setVisible(true);
        // Menutup jendela (frame) saat ini, yaitu jendela tempat tombol kembalibtn ditempatkan.
        this.dispose();        
    }                                          

    private void tabelkursusMouseClicked(java.awt.event.MouseEvent evt) {                                         
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
    }                                        

    private void editbtnActionPerformed(java.awt.event.ActionEvent evt) {                                        
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

        
        
    }                                       

    private void jumlahsiswatxtActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
    }                                              

    private void editbtnMouseClicked(java.awt.event.MouseEvent evt) {                                     
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
    }                                    

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

    // Variables declaration - do not modify                     
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
    // End of variables declaration                   

}
```

## kelas menu siswa
Kode ini adalah untuk melakukan berbagai operasi CRUD (Create, Read, Update, Delete) terhadap data siswa yang disimpan dalam database.
yang digunakan untuk mengelola data siswa.
```java

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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
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
    }// </editor-fold>                        

    private void idsiswatxtActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void kembalibtnActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // Membuat objek "menu" (kelas lain) yang akan digunakan untuk kembali ke menu utama.
        menu mn = new menu();
        
        // Menampilkan menu utama dengan menjadikan objek "mn" visible.
        mn.setVisible(true);
        
        // Menutup jendela (frame) saat ini, yaitu jendela tempat tombol "kembalibtn" ditempatkan.
        this.dispose();        
    }                                          

    private void tambahbtnActionPerformed(java.awt.event.ActionEvent evt) {                                          
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

    }                                         

    private void editbtnActionPerformed(java.awt.event.ActionEvent evt) {                                        
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

        
             
    }                                       

    private void hapusbtnActionPerformed(java.awt.event.ActionEvent evt) {                                         
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
    }                                        

    private void siswatabelMouseClicked(java.awt.event.MouseEvent evt) {                                        
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
    }                                       

    private void editbtnMouseClicked(java.awt.event.MouseEvent evt) {                                     
        // TODO add your handling code here:
    
    }                                    

    private void kursusMusikActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           


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

    // Variables declaration - do not modify                     
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
    // End of variables declaration                   
}
```


# Screenshot Output
## Halaman Login
Pada halamann login berisikan username dan password yang harus di input oleh admin dengan username dan password yang telah ditentukan untuk dapat masuk ke dalam sistem. jika inputan
password atau username salah, maka akan memunculkan pesan "login gagal" jika username dan password benar maka akan memunculkan tampilan "login berhasil".
![image](https://github.com/PA-PBO-Kelompok-18/.github/assets/124419335/071a1557-2b77-4e90-8e63-cc39e42eeae1)

![image](https://github.com/PA-PBO-Kelompok-18/.github/assets/124419335/d294f079-f3b5-4278-96d3-964226be1714)

![image](https://github.com/PA-PBO-Kelompok-18/.github/assets/124419335/fb8f8a7c-d11e-4f4a-a6e5-dd4e1e67afcc)


## Halaman Menu Utama
Pada halaman utama terdapat 3 menu yang dapat dipilih oleh admin untuk melihat data maupun merubah data. Admin dapat memilih salah satu menu yang ingin ia operasikan/jalankan sesuai dengan keperluannya.
![image](https://github.com/PA-PBO-Kelompok-18/.github/assets/124419335/ab923ad9-22a0-47c1-bd36-ffe062b87827)


## Halaman Menu Instruktur
Pada halaman menu instruktur kita dapat melihat data-data instruktur yang mengajar pada kursus musik, khususnya dapat mengetahui nama instruktur berdasarkan bidang musik yang ia kuasai. 
![image](https://github.com/PA-PBO-Kelompok-18/.github/assets/124419335/5b241c90-d446-4c14-ab8c-ee155cad4e98)


## Halaman Menu Siswa
Pada halaman menu siswa, admin dapat melakukan tambah, edit atau menghapus data sesuai dengan keperluan dan kebutuhan, yang dimana pada meenu ini hanya nama dan jenis kelamin saja yang bisa diubah karena,
setiap siswa hanya boleh memilik satu id siswa, jika siswa tersebut sudah dinyatan keluar dari kursus musik maka datanya bisa langsung dihapus,
untuk mengedit hanya bisa mengedit nama dan jenis kelamin.
![image](https://github.com/PA-PBO-Kelompok-18/.github/assets/124419335/c798da24-bcdc-4d34-9a77-4b14c15ce9db)

- Menambah Data Siswa
  Data Sebelum Ditambah:
  ![image](https://github.com/PA-PBO-Kelompok-18/.github/assets/124419335/32470343-0bbf-4eba-af71-395869b068ed)
  
  Data Sesudah Ditambah:
  ![image](https://github.com/PA-PBO-Kelompok-18/.github/assets/124419335/80c01208-b6ff-47ad-9e9b-a47960851d18)

- Mengedit Data Siswa
  Data Sebelum Diedit:
  ![image](https://github.com/PA-PBO-Kelompok-18/.github/assets/124419335/22af1ed0-9fc3-4b0a-8238-85d88a4c950e)
  
  Data Sesudah Diedit:
  ![image](https://github.com/PA-PBO-Kelompok-18/.github/assets/124419335/0b0f7f85-58a4-4e29-83e3-b2d1b31d1ed4)

- Menghapus Data Siswa
  Data Sebelum Dihapus:
  ![image](https://github.com/PA-PBO-Kelompok-18/.github/assets/124419335/cf79b0e2-8da0-4ff9-bd6e-638e2a87d26c)
  
  ![image](https://github.com/PA-PBO-Kelompok-18/.github/assets/124419335/b592ddc5-ae9b-40f1-9d4c-6e58165eeee1)
  
  Data Sesudah Dihapus:
  ![image](https://github.com/PA-PBO-Kelompok-18/.github/assets/124419335/0291e72b-d3a4-4f40-9fc7-74dfc0c5e997)


## Halaman Kursus Musik
Pada halaman kursus musik, admin dapat mengedit jumlah siswa berdasarkan kondisi yang ada semisalnya siswa bertambah maupun ada siswa yang telah keluar dari kursus.
![image](https://github.com/PA-PBO-Kelompok-18/.github/assets/124419335/906fd1d8-8f33-4f00-a8d6-28dc98b1473d)

- Mengedit Jumlah Siswa Pada Kursus Musik
  Tampilan Sebelum Diedit:
  ![image](https://github.com/PA-PBO-Kelompok-18/.github/assets/124419335/4fac44e5-a73c-498e-8349-a7f4440932d0)
  
  Sesudah Diedit:
  ![image](https://github.com/PA-PBO-Kelompok-18/.github/assets/124419335/c04367f8-cf7b-4f7c-bd2b-8e739df79637)


# NOTE:
  Untuk penjelasan detail codingan dapat dilihat pada setiap komen yang terdapat pada baris codingan.


# Terima Kasih.
