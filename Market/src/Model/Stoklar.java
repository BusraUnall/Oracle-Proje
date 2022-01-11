package Model;

public class Stoklar {
    private int stokNo;
    private int grupNo;
    private int tedarikciNo;
    private int urunNo;
    private String girisTarihi;
    private int urunSayisi;
    private int rafOmru;

    public Stoklar(int stokNo, int grupNo, int tedarikciNo, int urunNo, String girisTarihi, int urunSayisi, int rafOmru) {
        this.stokNo = stokNo;
        this.grupNo = grupNo;
        this.tedarikciNo = tedarikciNo;
        this.urunNo = urunNo;
        this.girisTarihi = girisTarihi;
        this.urunSayisi = urunSayisi;
        this.rafOmru = rafOmru;
    }

    public int getStokNo() {
        return stokNo;
    }

    public void setStokNo(int stokNo) {
        this.stokNo = stokNo;
    }

    public int getGrupNo() {
        return grupNo;
    }

    public void setGrupNo(int grupNo) {
        this.grupNo = grupNo;
    }

    public int getTedarikciNo() {
        return tedarikciNo;
    }

    public void setTedarikciNo(int tedarikciNo) {
        this.tedarikciNo = tedarikciNo;
    }

    public int getUrunNo() {
        return urunNo;
    }

    public void setUrunNo(int urunNo) {
        this.urunNo = urunNo;
    }

    public String getGirisTarihi() {
        return girisTarihi;
    }

    public void setGirisTarihi(String girisTarihi) {
        this.girisTarihi = girisTarihi;
    }

    public int getUrunSayisi() {
        return urunSayisi;
    }

    public void setUrunSayisi(int urunSayisi) {
        this.urunSayisi = urunSayisi;
    }

    public int getRafOmru() {
        return rafOmru;
    }

    public void setRafOmru(int rafOmru) {
        this.rafOmru = rafOmru;
    }


}
