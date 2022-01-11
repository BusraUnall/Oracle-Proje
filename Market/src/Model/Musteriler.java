
package Model;

public class Musteriler {
    private String musteriKartNo;
    private String isim;
    private String soyisim;
    private String adres;
    private String telefon;
    private String cinsiyet;
    private String kartAlimTarihi;
    private int toplamPuan;

    public Musteriler(String musteriKartNo, String isim, String soyisim, String adres, String telefon, String cinsiyet, String kartAlimTarihi, int toplamPuan) {
        this.musteriKartNo = musteriKartNo;
        this.isim = isim;
        this.soyisim = soyisim;
        this.adres = adres;
        this.telefon = telefon;
        this.cinsiyet = cinsiyet;
        this.kartAlimTarihi = kartAlimTarihi;
        this.toplamPuan = toplamPuan;
    }

    public String getMusteriKartNo() {
        return musteriKartNo;
    }

    public void setMusteriKartNo(String musteriKartNo) {
        this.musteriKartNo = musteriKartNo;
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

    public String getKartAlimTarihi() {
        return kartAlimTarihi;
    }

    public void setKartAlimTarihi(String kartAlimTarihi) {
        this.kartAlimTarihi = kartAlimTarihi;
    }

    public int getToplamPuan() {
        return toplamPuan;
    }

    public void setToplamPuan(int toplamPuan) {
        this.toplamPuan = toplamPuan;
    }


}
