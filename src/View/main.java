package View;
import BILL.bill;
import Controler.Controler;
import KhachHang.KhachAnTaiCho;
import KhachHang.KhachMuaVe;
import KhachHang.KhachOrder;
import Nguoi.DauBep;
import Nguoi.PhucVu;
import Nguoi.taikhoan;
import QLMONAN.DataController;
import QLMONAN.MonAn;
import QLMONAN.NguyenLieu;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import sun.awt.AWTAccessor;

import java.sql.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        String TaiKhoanFile = "taikhoan.txt";
        String DauBepFile = "daubep.txt";
        String PhucVuFile = "phucvu.txt";
        String KhachAnTaiChoFile = "khachantaicho.txt";
        String KhachMuaVeFile = "khachmuave.txt";
        String KhachOrderFile = "khachorder.txt";
        Controler controler = new Controler();
        ArrayList<KhachAnTaiCho> khachAnTaiChos = controler.CreateKhachAnTaiChoFromData(KhachAnTaiChoFile);
        ArrayList<KhachMuaVe> khachMuaVes = (ArrayList<KhachMuaVe>) controler.CreateKhachMuaVeFromData(KhachMuaVeFile);
        ArrayList<KhachOrder> khachOrders = controler.CreateKhachOrderFromData(KhachOrderFile);
        ArrayList<DauBep> dauBeps = controler.CreateDauBepFromData(DauBepFile);
        ArrayList<PhucVu> phucVus = controler.CreatePhucVuFromData(PhucVuFile);
        //phần dưới này của MIn
        String MaterialFileName = "nguyenlieu.txt";
        String DishFileName = "monan.txt";
        DataController dataController = new DataController();
        ArrayList<NguyenLieu> materials = dataController.CreateMaterialFromData(MaterialFileName);
        ArrayList<MonAn> dishes = (ArrayList<MonAn>) dataController.CreateDishFromData(DishFileName);
        ArrayList<taikhoan> taikhoans = dataController.CreateTaiKhoanFromData(TaiKhoanFile);

        MonAn a1=new MonAn("ma1", "xuc xich", 10000);   dishes.add(a1);
        MonAn a2=new MonAn("ma2", "lau nuong", 100000); dishes.add(a2);
        MonAn a3=new MonAn("ma3", "thit bo", 105000);   dishes.add(a3);
        MonAn a4=new MonAn("ma4", "ca kho", 200000);    dishes.add(a4);
        MonAn a5=new MonAn("ma5", "thit ga", 199000);   dishes.add(a5);
        MonAn a6=new MonAn("ma6", "bo kho", 990000);    dishes.add(a6);
        MonAn a7=new MonAn("ma7", "Bun Ngan", 25000);   dishes.add(a7);
        dataController.WriteDishToFile(DishFileName, a1);
        dataController.WriteDishToFile(DishFileName, a2);
        dataController.WriteDishToFile(DishFileName, a3);
        dataController.WriteDishToFile(DishFileName, a4);
        dataController.WriteDishToFile(DishFileName, a5);
        dataController.WriteDishToFile(DishFileName, a6);
        dataController.WriteDishToFile(DishFileName, a7);

        ArrayList<bill> listBill=new ArrayList<>();
        ArrayList<MonAn> listma=new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int ch;

        while (true) {
            System.out.println("====================WELCOME TO HA PHONG RESTAURENT======================");
            System.out.println("1. ĐĂNG NHẬP QUẢN LÍ HỆ THỐNG \t\t 2. ĐĂNG NHẬP TÀI KHOẢN \t\t 3. ĐĂNG KÝ TÀI KHOẢN\n");
            System.out.printf("YOUR CHOSSE: "); ch=sc.nextInt();


            if (ch==1){
                System.out.println("ĐĂNG NHẬP THÀNH CÔNG\n");
                int choice;
                do {
                    System.out.println("====================MENU===================");
                    System.out.println("======NHAN VIÊN======");
                    System.out.println("0. EXIT");
                    System.out.print("1. Thêm Nhân Viên Phục Vụ");
                    System.out.print("\t\t2. Hiển Thị Danh sách nhân viên");
                    System.out.print("\t\t3. Sửa danh sách nhân viên");
                    System.out.println("\t\t4. Xóa nhân viên\n");
                    System.out.println("======ĐẦU BẾP========");
                    System.out.print("5. Thêm Đầu Bếp");
                    System.out.print("\t\t6. Hiển Thị Danh Sách Đầu Bếp");
                    System.out.print("\t\t7. Sửa Danh Sách đầu bếp");
                    System.out.println("\t\t8. Xóa Đầu Bếp\n");
                    System.out.println("=======KHACH HÀNG========");
                    System.out.print("9. Thêm Lịch Sử Khách Hàng Ăn Tại Chỗ");
                    System.out.println("\t\t10. Hiển Thị Lịch Sử Khách Hàng Ăn Tại Chỗ");
                    System.out.print("11. Thêm Lịch Sử Khách hàng Mua Về");
                    System.out.println("\t\t\t12. Hiển Thị Lịch Sử Khách hàng mua về");
                    System.out.print("13. Thêm Lịch Sử Khách Hàng Order");
                    System.out.println("\t\t\t14. Hiển Thị Lịch Sử Khách Hàng Order");
                    System.out.println("15. Thêm món ăn \t\t 16. Show Món Ăn\t\t17. Sửa Món Ăn \t\t18. Xóa Món Ăn\n19. Sắp xếp Món Ăn");
                    System.out.println("20. Search Dish By ID");
                    System.out.print("Your Choose: ");
                    choice=sc.nextInt(); sc.nextLine();
                    switch (choice) {
                        case 20:
                            String searchDish;
                            System.out.print("Enter the ID of the dish to be searched: ");
//                            sc.nextLine();
                            searchDish = sc.nextLine();
                            ArrayList<MonAn> dish1 = searchDishByID(dishes, searchDish);
                            if(dish1.size()!=0){
                                System.out.printf("\n%-10s%-20s%-20s%-20s\n", "", "Mã Món", "Tên Món", "Giá Bán" );
                                for(int i=0;i<dish1.size();i++){
                                    dish1.get(i).Output();
                                }
                            }else{
                                System.out.println("Not found");
                            }
                            break;
                        case 15://thêm món ăn
                            dishes = (ArrayList<MonAn>) dataController.CreateDishFromData(DishFileName);
                            String tenMonAn, mm;
                            double money;
                            System.out.println("Nhập mã món: "); mm=sc.nextLine();
                            System.out.print("Nhập tên món: ");
                            tenMonAn = sc.nextLine();
                            System.out.print("Nhập giá: ");
                            money = sc.nextDouble(); sc.nextLine();
                            MonAn dish = new MonAn(mm, tenMonAn, money);
                            dataController.WriteDishToFile(DishFileName, dish);
                            System.out.println("Thêm thành công");
                            break;
                        case 16://show món ăn
                            ShowMonAn(dishes);
                            break;
                        case 17:  //sửa món ăn
                            String id;
                            boolean isF=false;
                            System.out.println("Nhập mã món cần sửa");
                            id=sc.nextLine();
                            for (int i=0; i<dishes.size(); i++){
                                if (dishes.get(i).getMaMon().compareToIgnoreCase(id)==0){
                                    System.out.println("Sửa tên món: ");
                                    dishes.get(i).setTenMonAn(sc.nextLine());
                                    System.out.println("Sửa giá món: ");
                                    dishes.get(i).setMoney(sc.nextDouble());
                                    isF=true;
                                }
                            }
                            if(isF==false) System.out.println("MÃ MÓN KHÔNG TỒN TẠI");
                            else {
                                dataController.UpdateDishToFile(dishes, DishFileName);
                                System.out.println("Đã chỉnh sửa");
                            }
                            break;
                        case 18: //xóa món ăn
                            System.out.println("Nhập mã món cần xóa: ");
                            id=sc.nextLine();
                            isF=false;
                            for (int i=0; i<dishes.size(); i++){
                                if (dishes.get(i).getMaMon().compareToIgnoreCase(id)==0){
                                    dishes.remove(i);
                                    isF=true;
                                }
                            }
                            if (isF==false) System.out.println("Mã món không tồn tại");
                            else {
                                dataController.UpdateDishToFile(dishes, DishFileName);
                                System.out.println("Xóa thành công");
                            }
                            break;
                        case 19: //sort dishes
//                            dishes = (ArrayList<MonAn>) dataController.CreateDishFromData(DishFileName);
                            for(int i=0;i<dishes.size()-1;i++)
                                for(int j=i+1;j<dishes.size();j++)
                                    if(dishes.get(i).getTenMonAn().compareTo(dishes.get(j).getTenMonAn())>0){
                                        MonAn temp = dishes.get(i);
                                        dishes.set(i, dishes.get(j));
                                        dishes.set(j, temp);
                                    }
                            dataController.UpdateDishToFile(dishes, DishFileName);
                            System.out.println("Da sap xep mon an");
                            break;

                        case 1: //add phục vụ
                            String ID, name, gender, caLam, viTri;
                            int age, soNgayLamViec, soNgayNghi;
                            System.out.println("Nhập Mã Nhân Viên: ");
                            ID = sc.nextLine();
                            System.out.println("Nhập Tên Nhân Viên: ");
                            name = sc.nextLine();
                            System.out.println("Nhập Tuổi: ");
                            age = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Nhập Giới Tính: ");
                            gender = sc.nextLine();
                            System.out.println("Nhập Ca Làm: ");
                            caLam = sc.nextLine();
                            System.out.println("Nhập Vị Trí: ");
                            viTri = sc.nextLine();
                            System.out.println("Nhập Số Ngày Làm Việc");
                            soNgayLamViec = sc.nextInt();
                            System.out.println("Nhập Số Ngày Nghỉ: ");
                            soNgayNghi = sc.nextInt();
                            PhucVu phucVu = new PhucVu(ID, name, gender, age, soNgayLamViec, caLam, viTri, soNgayNghi);
                            controler.WritePhucVuToFile(PhucVuFile, phucVu);
                            break;
                        case 2: //show phục vụ
                            phucVus = controler.CreatePhucVuFromData(PhucVuFile);
                            System.out.println("==================DANH SÁCH PHỤC VỤ==============");
                            System.out.printf("%-20s%-20s%-10s%-10s%-10s%-15s%-20s%-20s\n", "Ma NV", "Tên", "GioiTinh", "Tuổi", "SoNgayLam", "Ca Lam", "Vị Trí", "SO Ngay Nghỉ");
                            for (PhucVu a : phucVus) {
                                a.Output();
                            }
                            break;
                        case 3: //edit nhân viên
//                        String id;
                            boolean check = false;
                            System.out.print("Nhập Mã Nhân Viên Cần chỉnh Sửa: ");
                            id = sc.nextLine();
                            for (int i = 0; i < phucVus.size(); i++) {
                                if (phucVus.get(i).getMaNhanVien().compareToIgnoreCase(id) == 0) {
                                    check = true;
                                    System.out.println("Sửa Tên: ");
                                    phucVus.get(i).setName(sc.nextLine());
                                    System.out.println("Sửa tuổi: ");
                                    phucVus.get(i).setAge(sc.nextInt());
                                    sc.nextLine();
                                    System.out.println("Sửa giới tính: ");
                                    phucVus.get(i).setGender(sc.nextLine());
                                    System.out.println("Sửa Ca làm: ");
                                    phucVus.get(i).setCaLam(sc.nextLine());
                                    System.out.println("Sửa vị trí: ");
                                    phucVus.get(i).setViTri(sc.nextLine());
                                    System.out.println("Sửa số ngày làm: ");
                                    phucVus.get(i).setNgayLamViec(sc.nextInt());
                                    System.out.println("Sửa số ngày nghỉ: ");
                                    phucVus.get(i).setSoNgayNghi(sc.nextInt());
                                    sc.nextLine();
                                }
                            }
                            controler.UpdatePhucVuToFile(phucVus, PhucVuFile);
                            if (check == false) System.out.println("MÃ NHÂN VIÊN KHÔNG TỒN TẠI");
                            else System.out.println("ĐÃ CHỈNH SỬA");
                            break;
                        case 4: // xóa nhân viên
                            String iD;
                            boolean checkID = false;
                            System.out.print("Nhập Mã Nhân Viên Cần Xóa: ");
                            iD = sc.nextLine();
                            for (int i = 0; i < phucVus.size(); i++) {
                                if (phucVus.get(i).getMaNhanVien().compareToIgnoreCase(iD) == 0) {
                                    phucVus.remove(i);
                                    checkID = true;
                                }
                            }
                            controler.UpdatePhucVuToFile(phucVus, PhucVuFile);
                            if (checkID == false) System.out.println("MÃ NHÂN VIÊN KHÔNG TỒN TẠI");
                            else System.out.println("ĐÃ XÓA");
                            break;
                        case 5: //thêm đầu bếp
                            String iddb, namedb, gd, vt;
                            int agedb, kn, nlv;
                            System.out.println("Nhập mã đầu bếp: "); iddb=sc.nextLine();
                            System.out.println("Nhập Tên đầu bếp: "); namedb=sc.nextLine();
                            System.out.println("Nhập giới tính: "); gd=sc.nextLine();
                            System.out.println("Nhập tuổi: "); agedb=sc.nextInt();
                            System.out.println("Nhập số ngày làm việc: "); nlv=sc.nextInt(); sc.nextLine();
                            System.out.println("Nhập vị trí: ");  vt=sc.nextLine();
                            System.out.println("Nhập số năm kinh nghiệm: "); kn=sc.nextInt();
                            DauBep d=new DauBep(iddb, namedb, gd, agedb, nlv, vt, kn);
                            controler.WriteDauBepToFile(DauBepFile, d);
                            break;
                        case 6: // show đầu bếp
                            dauBeps = controler.CreateDauBepFromData(DauBepFile);
                            System.out.println("=============DANH SÁCH ĐẦU BẾP=================");
                            System.out.printf("%-20s%-20s%-15s%-10s%-20s%-20s%-20s\n", "MÃ NHÂN VIÊN", "NAME", "GENDER", "AGE", "Số Ngày Làm", "Vị Trí", "Kinh Nghiệm");
                            for (DauBep a: dauBeps ) {
                                a.Output();
                            }
                            break;
                        case 7: //sửa đầu bếp
                            check=false;
                            System.out.print("Nhập Mã Nhân Viên Cần chỉnh Sửa: ");
                            id = sc.nextLine();
                            for (int i = 0; i < dauBeps.size(); i++) {
                                if (dauBeps.get(i).getMaNhanVien().compareToIgnoreCase(id) == 0) {
                                    check = true;
                                    System.out.println("Sửa Tên: ");
                                    dauBeps.get(i).setName(sc.nextLine());
                                    System.out.println("Sửa giới tính: ");
                                    dauBeps.get(i).setGender(sc.nextLine());
                                    System.out.println("Sửa tuổi: ");
                                    dauBeps.get(i).setAge(sc.nextInt());
                                    sc.nextLine();
                                    System.out.println("Sửa Số Ngày làm việc: ");
                                    dauBeps.get(i).setNgayLamViec(sc.nextInt());
                                    System.out.println("Sửa vị trí: ");
                                    dauBeps.get(i).setViTri(sc.nextLine());
                                    System.out.println("Sửa số Năm kinh nghiệm: ");
                                    dauBeps.get(i).setNamKn(sc.nextInt());
                                    sc.nextLine();
                                }
                            }
                            controler.UpdateDauBepToFile(dauBeps, DauBepFile);
                            if (check == false) System.out.println("MÃ ĐẦU BẾP KHÔNG TỒN TẠI");
                            else System.out.println("ĐÃ CHỈNH SỬA");
                            break;

                        case 8:// xáo đầu bếp
                            boolean checkI = false;
                            String iDD;
                            System.out.print("Nhập Mã Đầu Bếp Cần Xóa: ");
                            iDD = sc.nextLine();
                            for (int i = 0; i < dauBeps.size(); i++) {
                                if (dauBeps.get(i).getMaNhanVien().compareToIgnoreCase(iDD) == 0) {
                                    dauBeps.remove(i);
                                    checkI = true;
                                }
                            }
                            controler.UpdateDauBepToFile(dauBeps, DauBepFile);
                            if (checkI == false) System.out.println("MÃ ĐẦU BẾP KHÔNG TỒN TẠI");
                            else System.out.println("ĐÃ XÓA");
                            break;
                        case 9: // thêm khách ăn tại nhà hàng
                            int ban;
                            System.out.println("Nhập ID khách hàng: ");
                            ID=sc.nextLine();
                            System.out.println("Nhập Tên khách hàng: ");
                            name=sc.nextLine();
                            System.out.println("Nhập số bàn: ");
                            ban=sc.nextInt(); sc.nextLine();
                            KhachAnTaiCho khachAnTaiCho =new KhachAnTaiCho(ID, name, ban);
                            controler.WriteKhachAnTaiChoToFile(KhachAnTaiChoFile, khachAnTaiCho);
                            break;
                        case 10: // hiển thị lịch sử khách hàng ăn tại nhà hàng
                            khachAnTaiChos = controler.CreateKhachAnTaiChoFromData(KhachAnTaiChoFile);
                            System.out.println("========KHACH ĂN TẠI NHÀ HÀNG=========");
                            System.out.printf("%-20s%-20s%-20s\n", "ID Khach", "Tên Khách", "Số Bàn");
                            for (KhachAnTaiCho a: khachAnTaiChos) {
                                a.Output();
                            }
                            break;
                        case 11: //thêm lịch sử khách mua về
                            int soMon;
                            System.out.println("Nhập ID khách: "); ID=sc.nextLine();
                            System.out.println("Nhập tên khách: "); name=sc.nextLine();
                            System.out.println("Nhập số món ăn: "); soMon=sc.nextInt(); sc.nextLine();
                            KhachMuaVe khachMuaVe=new KhachMuaVe(ID, name, soMon);
                            controler.WriteKhachMuaVeToFile(KhachMuaVeFile, khachMuaVe);
                            break;
                        case 12://showw khách mua về
                            System.out.println("=========KHACH MUA VỀ============");
                            khachMuaVes=controler.CreateKhachMuaVeFromData(KhachMuaVeFile);
                            System.out.printf("%-20s%-20s%-20s\n", "ID Khách", "Tên Khach", "Số Món");
                            for (KhachMuaVe muaVe: khachMuaVes) {
                                muaVe.Output();
                            }
                            break;
                        case 13://thêm lịch sử khách Order
                            String sdt, dc;
                            System.out.println("Nhập ID khách: "); ID=sc.nextLine();
                            System.out.println("Nhập Tên khách: "); name=sc.nextLine();
                            System.out.println("Nhập số điện thoại: "); sdt=sc.nextLine();
                            System.out.println("Nhập địa chỉ: ");   dc=sc.nextLine();
                            KhachOrder khachOrder=new KhachOrder(ID, name, sdt, dc);
                            controler.WriteKhachOrderToFile(KhachOrderFile, khachOrder);
                            break;

                        case 14://show lịch sử khách order
                            System.out.println("============KHACH ORDER============");
                            khachOrders = controler.CreateKhachOrderFromData(KhachOrderFile);
                            System.out.printf("%-20s%-20s%-20s%-20s\n", "ID khach", "Tên Khach", "Số ĐT", "Địa Chỉ");
                            for (KhachOrder k: khachOrders ) {
                                k.Outpu();
                            }
                            break;
                        case 0:
                            break;
                        default:
                            System.out.println("++++++***** Lựa chọn không hợp lệ");
                    }

                }while (choice!=0);


            }else {
                int isAcNow=0;
                if(ch==3) {
                    String tk, mk;
                    String m;
                    System.out.println("====ĐĂNG KÝ TÀI KHOẢN====");
                    sc.nextLine();
                    do {
                        System.out.println("Nhập tên tài khoản: ");
                        tk = sc.nextLine();
                        if (checktk(taikhoans, tk)) System.out.println("********Tên đăng nhập đã tồn tại, hãy đặt tên khác!");
                    }while (checktk(taikhoans, tk));

                    do {
                        System.out.println("Nhập mật khẩu: ");
                        mk = sc.nextLine();
                        System.out.println("Xác nhận mật khẩu: ");
                        m = sc.nextLine();
                        if (m.compareTo(mk) != 0) System.out.println("Xác nhận mật khẩu chưa đúng. Hãy nhập lại!!!");
                    } while (mk.compareTo(m) != 0);
                    taikhoan a = new taikhoan(tk, mk, 0);
                    taikhoans.add(a);
                    isAcNow=taikhoans.size()-1; //xác định vị trí tài khoản trong list tài khoản
                    dataController.WriteTaiKhoanToFile(TaiKhoanFile, a);
                    System.out.println("===ĐĂNG KÍ THÀNH CÔNG====");
                }else if (ch==2){
                    boolean isF=false;
                    sc.nextLine();
                    do {
                        String t, k;
                        System.out.println("++++ĐĂNG NHẬP++++++");
                        System.out.println("TÀi KHOẢN: "); t=sc.nextLine();
                        System.out.println("MẬT KHẨU: "); k=sc.nextLine();
                        for (int i=0; i<taikhoans.size(); i++){
                            if (taikhoans.get(i).getTenDn().compareToIgnoreCase(t)==0 && taikhoans.get(i).getPass().compareToIgnoreCase(k)==0){
                                isAcNow=i;
                                isF=true;  //xác định vị trí tài khoản trong list tài khoản
                                System.out.println("ĐĂNG NHẬP THÀNH CÔNG");
                                break;
                            }
                        }
                        if(isF==false) System.out.println("Tên ĐĂNG NHẬP HOẶC TÀI KHOẢN KHÔGN CHÍNH XÁC");
                    }while (isF==false);

                }
                int chon;
                do {
                    System.out.println("\n\nKHÁCH VIP: "+taikhoans.get(isAcNow).getTenDn() +"\t\t SỐ DƯ TÀI KHOẢN: "+taikhoans.get(isAcNow).getTk() +" VND");
                    System.out.println("1. Nạp tiền vào tài khoản");
                    System.out.println("2. Hiển thị danh sách món ăn");
                    System.out.println("3. Đặt bàn");
                    System.out.println("4. Order");
                    System.out.println("0. Exit");
                    System.out.print("Your choose: "); chon=sc.nextInt();
                    switch (chon){
                        case 1://nạp tiền
                            long tien;
                            System.out.println("Nhập số tiền cần nạp: "); tien=sc.nextLong();
                            taikhoans.get(isAcNow).setTk(taikhoans.get(isAcNow).getTk()+tien);
                            dataController.UpdateTaiKhoanToFile(taikhoans, TaiKhoanFile);
                            System.out.println("NẠP TIỀN THÀNH CÔNG. CẢM ƠN QUÝ KHÁCH");
                            break;
                        case 2://show món
                            ShowMonAn(dishes);
                            break;
                        case 3://đặt bàn
                            listma=new ArrayList<>();
                            String hden;
                            int s, sl, sb;
                            sc.nextLine();
                            System.out.println("Nhap gio den: "); hden=sc.nextLine();
                            System.out.println("Chon so ban: ");    sb=sc.nextInt();
                            System.out.println("====== BAN CO MUON CHON MON DE NHA HANG CHUAN BI ==========");
                            System.out.println("1. Cos\t\t 2. Khong");
                            if(sc.nextInt()==1){
                                do {
                                    ShowMonAn(dishes);
                                    System.out.println("XIN MOI CHON MON THEO STT, NHAP 0 DE THOAT!");
                                    s=sc.nextInt();
                                    if(s>8) {
                                        System.out.println("Nhap sai!!!");
                                        continue;
                                    }
                                    if(s!=0){
                                        System.out.println("Chon so luong: ");
                                        sl=sc.nextInt();
                                        MonAn a=new MonAn(dishes.get(s-1).getMaMon(), dishes.get(s-1).getTenMonAn(), dishes.get(s-1).getMoney(), sl);
                                        listma.add(a);
                                    }
                                }while (s!=0);

                            }
                            bill b2=new bill("HD_Online", hden, "", listma);
                            KhachAnTaiCho khachAnTaiCho=new KhachAnTaiCho("KhachDB", taikhoans.get(isAcNow).getTenDn(), sb);
                            controler.WriteKhachAnTaiChoToFile(KhachAnTaiChoFile,khachAnTaiCho);
                            b2.Output();
                            System.out.println("***Vui long chuan bi so tien tuong ung :))");
                            break;
                        case 4://order
                            listma=new ArrayList<>();
//                            int s, sl;
                            String dt, dc;
                            do {
                                ShowMonAn(dishes);
                                System.out.println("XIN MOI CHON MON THEO STT, NHAP 0 DE THOAT!");
                                s=sc.nextInt();
                                if(s>8) {
                                    System.out.println("Nhap sai!!!");
                                    continue;
                                }
                                if(s!=0){
                                    System.out.println("Chon so luong: ");
                                    sl=sc.nextInt();
                                    MonAn a=new MonAn(dishes.get(s-1).getMaMon(), dishes.get(s-1).getTenMonAn(), dishes.get(s-1).getMoney(), sl);
                                    listma.add(a);
                                }

                            }while (s!=0);
                            sc.nextLine();
                            System.out.println("Nhap SDT: "); dt=sc.nextLine();
                            System.out.println("Nhap Dia Chi: "); dc=sc.nextLine();
                            KhachOrder khachOrder =new KhachOrder(taikhoans.get(isAcNow).getTenDn()+"001", taikhoans.get(isAcNow).getTenDn(), dt, dc);
                            controler.WriteKhachOrderToFile(KhachOrderFile,khachOrder);
                            bill b1=new bill("HD-ONLINE", "0", "0", listma );
                            System.out.println("=========Chon hinh thuc thanh toan==========");
                            System.out.println("1. Thanh toan khi nhan hang");
                            System.out.println("2. Su dung tai khoan");
                            System.out.println("Your choose: ");
                            if (sc.nextInt()==2){
                                boolean du= taikhoans.get(isAcNow).getTk()-b1.getT()>0 ?true: false;
                                if(du==false){
                                    System.out.println("So du khong du su dung, vui long nap them tien");
                                }
                                else {
                                    taikhoans.get(isAcNow).setTk( taikhoans.get(isAcNow).getTk()-b1.Tien() );
                                    System.out.println("Thanh toan thanh cong");
                                }
                            }
                            b1.Output();
                            break;

                        case 0: break;
                        default:
                            System.out.println("Lựa chọn không phù hợp");
                    }

                }while(chon!=0);


            }

        }

    }

//    }

    //method static
    public static void ShowMonAn(ArrayList<MonAn> l){
        System.out.println("=========DANH SÁCH MÓN ĂN===========");
        System.out.printf("%-10s%-20s%-20s%-20s\n", "STT", "Mã Món", "Tên Món", "Giá Bán" );
        for (int i=0; i<l.size(); i++) {
            System.out.print((i+1));
            l.get(i).Output();
        }
    }
    public static boolean checktk(ArrayList<taikhoan> t, String check){
        for (int i=0; i<t.size(); i++){
            if (t.get(i).getTenDn().compareToIgnoreCase(check)==0)
                return true;
        }
        return false;
    }
    public static ArrayList<MonAn> searchDishByID (ArrayList<MonAn> list, String id){
        ArrayList<MonAn> l=new ArrayList<>();
        for(int i=0;i<list.size();i++){
            if(list.get(i).getMaMon().contains(id)){
                l.add(list.get(i));
            }
        }
        return l;
    }


}