public class PesananModel {
    private int id;
    private String resi;
    private String nama;
    private String alamat;
    private String no_telp;
    private String produk;
    private int jumlah_produk;
    private String informasi;
    private String status;

    public PesananModel(int id, String resi, String nama, String alamat, String no_telp, String produk, int jumlah_produk, String informasi, String status) {
        this.id = id;
        this.resi = resi;
        this.nama = nama;
        this.alamat = alamat;
        this.no_telp = no_telp;
        this.produk = produk;
        this.jumlah_produk = jumlah_produk;
        this.informasi = informasi;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResi() {
        return resi;
    }

    public void setResi(String resi) {
        this.resi = resi;
    }


    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }


    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }


    public String getNoTelp() {
        return no_telp;
    }

    public void setNoTelp(String no_telp) {
        this.no_telp = no_telp;
    }


    public String getProduk() {
        return produk;
    }

    public void setProduk(String produk) {
        this.produk = produk;
    }

 
    public int getJumlahProduk() {
        return jumlah_produk;
    }

    public void setJumlahProduk(int jumlah_produk) {
        this.jumlah_produk = jumlah_produk;
    }


    public String getInformasi() {
        return informasi;
    }

    public void setInformasi(String informasi) {
        this.informasi = informasi;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
