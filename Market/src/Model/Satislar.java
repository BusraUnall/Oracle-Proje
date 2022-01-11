
package Model;

public class Satislar {
    private int satisNo;
    private int urunNo;
    private int calisanNo;
    private String musteriKartNo;
    private String satisTarihi;

    public Satislar(int satisNo, int urunNo, int calisanNo, String musteriKartNo, String satisTarihi) {
        this.satisNo = satisNo;
        this.urunNo = urunNo;
        this.calisanNo = calisanNo;
        this.musteriKartNo = musteriKartNo;
        this.satisTarihi = satisTarihi;
    }

    public int getSatisNo() {
        return satisNo;
    }

    public void setSatisNo(int satisNo) {
        this.satisNo = satisNo;
    }

    public int getUrunNo() {
        return urunNo;
    }

    public void setUrunNo(int urunNo) {
        this.urunNo = urunNo;
    }

    public int getCalisanNo() {
        return calisanNo;
    }

    public void setCalisanNo(int calisanNo) {
        this.calisanNo = calisanNo;
    }

    public String getMusteriKartNo() {
        return musteriKartNo;
    }

    public void setMusteriKartNo(String musteriKartNo) {
        this.musteriKartNo = musteriKartNo;
    }

    public String getSatisTarihi() {
        return satisTarihi;
    }

    public void setSatisTarihi(String satisTarihi) {
        this.satisTarihi = satisTarihi;
    }


}
