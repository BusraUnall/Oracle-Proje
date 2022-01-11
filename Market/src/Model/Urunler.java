package Model;

public class Urunler {
    private int urunNo;
    private int grupNo;
    private String urunIsim;
    private String marka;
    private Float fiyat;
    private int gramaj;

    public Urunler(int urunNo, int grupNo, String urunIsim, String marka, Float fiyat, int gramaj) {
        this.urunNo = urunNo;
        this.grupNo = grupNo;
        this.urunIsim = urunIsim;
        this.marka = marka;
        this.fiyat = fiyat;
        this.gramaj = gramaj;
    }

    public int getUrunNo() {
        return urunNo;
    }

    public void setUrunNo(int urunNo) {
        this.urunNo = urunNo;
    }

    public int getGrupNo() {
        return grupNo;
    }

    public void setGrupNo(int grupNo) {
        this.grupNo = grupNo;
    }

    public String getUrunIsim() {
        return urunIsim;
    }

    public void setUrunIsim(String urunIsim) {
        this.urunIsim = urunIsim;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public Float getFiyat() {
        return fiyat;
    }

    public void setFiyat(Float fiyat) {
        this.fiyat = fiyat;
    }

    public int getGramaj() {
        return gramaj;
    }

    public void setGramaj(int gramaj) {
        this.gramaj = gramaj;
    }


}
