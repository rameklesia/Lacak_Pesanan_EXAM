import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class Database {
    private Connection conn;
    private ResultSet rs;
    Database(){
        System.out.println("Trying to connect database");
        try { 
            // Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ps", "root", "");
           
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void createData(PesananModel psn) throws SQLException{
        String sql = "INSERT INTO pesanan (nama,alamat,no_telp,produk,jumlah_produk,informasi,status,resi) VALUES (?,?,?,?,?,?,?,?)";
        PreparedStatement ptstmt = conn.prepareStatement(sql);

        ptstmt.setString(1, psn.getNama());
        ptstmt.setString(2, psn.getAlamat());
        ptstmt.setString(3, psn.getNoTelp());
        ptstmt.setString(4, psn.getProduk());
        ptstmt.setInt(5, psn.getJumlahProduk());
        ptstmt.setString(6, psn.getInformasi());
        ptstmt.setString(7, psn.getStatus());
        ptstmt.setString(8, psn.getResi());

        ptstmt.execute();
    };

    public ArrayList<PesananModel> readData() throws SQLException{
        String sql = "SELECT * FROM pesanan";
    
        PreparedStatement ptsmt = conn.prepareStatement(sql);
      

       rs =  ptsmt.executeQuery();
       ArrayList<PesananModel> pesananList = new ArrayList<>();
       
       while(rs.next()){
        int id = rs.getInt("id");
        String nama = rs.getString("nama");
        String resi = rs.getString("resi");
        String alamat = rs.getString("alamat");
        String no_telp = rs.getString("no_telp");
        String produk = rs.getString("produk");
        int jumlah_produk = rs.getInt("jumlah_produk");
        String informasi = rs.getString("informasi");
        String status = rs.getString("status");
       
        PesananModel pesananModel = new PesananModel(id, resi, nama, alamat, no_telp, produk, jumlah_produk, informasi, status);
        pesananList.add(pesananModel);
       }
    return pesananList;
    }

   public void deleteData(int id) throws SQLException{
    String sql = "DELETE FROM pesanan where id = ?";


    PreparedStatement ptstmt = conn.prepareStatement(sql);

    ptstmt.setInt(1, id);
    int rowsAffected = ptstmt.executeUpdate();
    
    if(rowsAffected<=0){
        throw new SQLException("Terjadi kesalahan");
    }
   }

   public void deleteDataByDetails(int id)throws SQLException{
    String sql = "DELETE FROM pesanan where id = ?";
    PreparedStatement ptsmt = conn.prepareStatement(sql);

    ptsmt.setInt(1, id);
    
    int rowsAffected = ptsmt.executeUpdate();
    if(rowsAffected<=0){
        throw new SQLException("Terjadi kesalahan");
    }
   }

   public void editData(PesananModel psn) throws SQLException{
    
    String sql = "UPDATE pesanan SET id = ?, nama = ?,alamat = ?,no_telp = ?,produk = ?,jumlah_produk = ?,informasi = ?,status= ?,resi= ? WHERE id = ? ";

    PreparedStatement ptstmt = conn.prepareStatement(sql);

  
    ptstmt.setInt(1, psn.getId());
    ptstmt.setString(2, psn.getNama());
    ptstmt.setString(3, psn.getAlamat());
    ptstmt.setString(4, psn.getNoTelp());
    ptstmt.setString(5, psn.getProduk());
    ptstmt.setInt(6, psn.getJumlahProduk());
    ptstmt.setString(7, psn.getInformasi());
    ptstmt.setString(8, psn.getStatus());
    ptstmt.setString(9, psn.getResi());
    ptstmt.setInt(10, psn.getId());

  
    int rowsAffected = ptstmt.executeUpdate();
  
   }

   public ArrayList<PesananModel> searchData(String keyword)throws SQLException{


    // String sqlFormat = String.format("SELECT * FROM pesanan WHERE nama LIKE '%' OR resi LIKE ?'%'", keyword) ;
    // String sql = "SELECT * FROM pesanan WHERE nama LIKE " + "'"+keyword+"%'";
    String sql=  "SELECT * FROM pesanan WHERE nama LIKE ?";
    // keyword = "'" + keyword+ "%'";
    System.out.println(keyword);
    PreparedStatement ptstmt = conn.prepareStatement(sql);
    
    ptstmt.setString(1, keyword + "%");
    // ptstmt.setString(2, keyword);

    ArrayList<PesananModel> psnList = new ArrayList<>();
    rs = ptstmt.executeQuery();
    while (rs.next()) {
        int id = rs.getInt("id");
        String nama = rs.getString("nama");
        String resi = rs.getString("resi");
        String alamat = rs.getString("alamat");
        String no_telp = rs.getString("no_telp");
        String produk = rs.getString("produk");
        int jumlah_produk = rs.getInt("jumlah_produk");
        String informasi = rs.getString("informasi");
        String status = rs.getString("status");
       
        PesananModel pesananModel = new PesananModel(id, resi, nama, alamat, no_telp, produk, jumlah_produk, informasi, status);
        psnList.add(pesananModel);
    }
    return psnList;

   }
}

