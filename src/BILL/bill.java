package BILL;

import QLMONAN.MonAn;

import java.util.ArrayList;

public class bill {
    private String maHD, gioVao, gioRa;
    private int soLuong;
    ArrayList<MonAn> listMonAn=new ArrayList<>();
    private long t;
    public void Output(){
        System.out.println("========================== BILL ============================");
        long tongTien=0;
        System.out.printf("%-20s%-20s%-20s\n", "Ma HD", "Gio Vao", "Gio Ra");
        System.out.printf("%-20s%-20s%-20s\n", maHD, gioVao, gioRa);
        System.out.printf("%-20s%-20s%-20s%-20s\n", "Mã Món", "Tên Món", "Giá Bán" , "So Luong");
        for (int i=0; i<listMonAn.size(); i++) {
            listMonAn.get(i).Out();
            tongTien+=listMonAn.get(i).getMoney()*listMonAn.get(i).getsL();
        }
        System.out.println("TONG TIEN CAN THANH TOAN: "+ tongTien);
        t=tongTien;
        System.out.println("========================== BILL ============================");
    }
    public long Tien(){
        long tongTien=0;
        for (int i=0; i<listMonAn.size(); i++) {
            listMonAn.get(i).Out();
            tongTien+=listMonAn.get(i).getMoney()*listMonAn.get(i).getsL();
        }
        return tongTien;
    }

    public long getT() {
        return t;
    }

    public void setT(long t) {
        this.t = t;
    }

    public bill(String maHD, String gioVao, String gioRa, ArrayList<MonAn> listMonAn) {
        this.maHD = maHD;
        this.gioVao = gioVao;
        this.gioRa = gioRa;
        this.listMonAn = listMonAn;
    }
    public bill(){
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getGioVao() {
        return gioVao;
    }

    public void setGioVao(String gioVao) {
        this.gioVao = gioVao;
    }

    public String getGioRa() {
        return gioRa;
    }

    public void setGioRa(String gioRa) {
        this.gioRa = gioRa;
    }

    public int getSoMon() {
        return soLuong;
    }

    public void setSoMon(int soMon) {
        this.soLuong = soMon;
    }

    public ArrayList<MonAn> getListMonAn() {
        return listMonAn;
    }

    public void setListMonAn(ArrayList<MonAn> listMonAn) {
        this.listMonAn = listMonAn;
    }
}
