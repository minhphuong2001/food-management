package QLMONAN;

public class NguyenLieu {
    private String maNL;
    private String name;
    private int soLuong;
    private double giaTien;

    public void Output(){
        System.out.printf("%-20s%-20s%-20d%-20f\n", maNL, name, soLuong, giaTien);
    }

    public NguyenLieu(String maNL, String name, int soLuong, double giaTien) {
        this.maNL = maNL;
        this.name = name;
        this.soLuong = soLuong;
        this.giaTien = giaTien;
    }

    public NguyenLieu() {
    }

    public String getMaNL() {
        return maNL;
    }

    public void setMaNL(String maNL) {
        this.maNL = maNL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(double giaTien) {
        this.giaTien = giaTien;
    }
}
