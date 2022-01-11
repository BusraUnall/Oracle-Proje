
package Model;


public class SistemeGiris {
    private int calisanNo;
    private String gorev;
    private String sifre;

    public SistemeGiris(int calisanNo, String gorev, String sifre) {
        this.calisanNo = calisanNo;
        this.gorev = gorev;
        this.sifre = sifre;
    }

    public SistemeGiris() {
    }

    public int getCalisanNo() {
        return calisanNo;
    }

    public void setCalisanNo(int calisanNo) {
        this.calisanNo = calisanNo;
    }

    public String getGorev() {
        return gorev;
    }

    public void setGorev(String gorev) {
        this.gorev = gorev;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }


}
