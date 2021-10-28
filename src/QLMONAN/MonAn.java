package QLMONAN;

public class MonAn {
    private String maMon;
    private String tenMonAn;
    private double money;
    private int sL;
    public MonAn() {
    }
    public MonAn(String maMon, String tenMonAn, double money, int sL) {
        this.maMon=maMon;
        this.tenMonAn = tenMonAn;
        this.money = money;
        this.sL=sL;
    }
    public MonAn(String maMon, String tenMonAn, double money) {
        this.maMon=maMon;
        this.tenMonAn = tenMonAn;
        this.money = money;
    }
    public void Output(){
        System.out.printf("%-10s%-20s%-20s%-20f\n","", maMon, tenMonAn, money);

    }
    public void Out(){
        System.out.printf("%-20s%-20s%-20f%-20d\n", maMon, tenMonAn, money, sL);

    }

    public int getsL() {
        return sL;
    }

    public void setsL(int sL) {
        this.sL = sL;
    }

    public String getMaMon() {
        return maMon;
    }

    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }

    public String getTenMonAn() {
        return tenMonAn;
    }

    public void setTenMonAn(String tenMonAn) {
        this.tenMonAn = tenMonAn;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}