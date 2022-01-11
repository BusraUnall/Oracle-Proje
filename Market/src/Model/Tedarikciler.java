package Model;

public class Tedarikciler {
    private int tedarikciNo;
    private String firmaIsmi;
    private String adres;
    private String telefon;
    private String e_mail;

    public Tedarikciler(int tedarikciNo, String firmaIsmi, String adres, String telefon, String e_mail) {
        this.tedarikciNo = tedarikciNo;
        this.firmaIsmi = firmaIsmi;
        this.adres = adres;
        this.telefon = telefon;
        this.e_mail = e_mail;
    }

    public int getTedarikciNo() {
        return tedarikciNo;
    }

    public void setTedarikciNo(int tedarikciNo) {
        this.tedarikciNo = tedarikciNo;
    }

    public String getFirmaIsmi() {
        return firmaIsmi;
    }

    public void setFirmaIsmi(String firmaIsmi) {
        this.firmaIsmi = firmaIsmi;
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

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }


}
