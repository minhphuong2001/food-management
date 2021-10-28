package Nguoi;

public class taikhoan {
    private String tenDn;
    private String pass;
    private long tk;

    public taikhoan(String tenDn, String pass, long tk) {
        this.tenDn = tenDn;
        this.pass = pass;
        this.tk = tk;
    }
    public taikhoan(){

    }

    public String getTenDn() {
        return tenDn;
    }

    public void setTenDn(String tenDn) {
        this.tenDn = tenDn;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public long getTk() {
        return tk;
    }

    public void setTk(long tk) {
        this.tk = tk;
    }
}