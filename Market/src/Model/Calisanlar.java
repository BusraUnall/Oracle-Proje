package Model;

public class Calisanlar {
    private int calisanNo;
    private String isim;
    private String soyisim;
    private String dogumTarihi;
    private String dogumYeri;
    private String adres;
    private String telefon;
    private String cinsiyet;
    private String gorev;
    private String sigortaNo;
    private String bankaHesapNo;
    private int maas;

    public Calisanlar(int calisanNo, String isim, String soyisim, String dogumTarihi, String dogumYeri, String adres, String telefon, String cinsiyet, String gorev, String sigortaNo, String bankaHesapNo, int maas) {
        this.calisanNo = calisanNo;
        this.isim = isim;
        this.soyisim = soyisim;
        this.dogumTarihi = dogumTarihi;
        this.dogumYeri = dogumYeri;
        this.adres = adres;
        this.telefon = telefon;
        this.cinsiyet = cinsiyet;
        this.gorev = gorev;
        this.sigortaNo = sigortaNo;
        this.bankaHesapNo = bankaHesapNo;
        this.maas = maas;
    } 

    public int getCalisanNo() {
        return calisanNo;
    }

    public void setCalisanNo(int calisanNo) {
        this.calisanNo = calisanNo;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getSoyisim() {
        return soyisim;
    }

    public void setSoyisim(String soyisim) {
        this.soyisim = soyisim;
    }

    public String getDogumTarihi() {
        return dogumTarihi;
    }

    public void setDogumTarihi(String dogumTarihi) {
        this.dogumTarihi = dogumTarihi;
    }

    public String getDogumYeri() {
        return dogumYeri;
    }

    public void setDogumYeri(String dogumYeri) {
        this.dogumYeri = dogumYeri;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public String getGorev() {
        return gorev;
    }

    public void setGorev(String gorev) {
        this.gorev = gorev;
    }

    public String getSigortaNo() {
        return sigortaNo;
    }

    public void setSigortaNo(String sigortaNo) {
        this.sigortaNo = sigortaNo;
    }

    public String getBankaHesapNo() {
        return bankaHesapNo;
    }

    public void setBankaHesapNo(String bankaHesapNo) {
        this.bankaHesapNo = bankaHesapNo;
    }

    public int getMaas() {
        return maas;
    }

    public void setMaas(int maas) {
        this.maas = maas;
    }


}
