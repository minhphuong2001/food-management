package QLMONAN;

import Nguoi.taikhoan;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class DataController {
    private FileWriter fileWriter;
    private BufferedWriter buffereWriter;
    private PrintWriter printWriter;
    private Scanner scanner;

    public void OpenFileToWrite(String fileName){
        try{
            fileWriter = new FileWriter(fileName, true);
            buffereWriter = new BufferedWriter(fileWriter);
            printWriter = new PrintWriter(buffereWriter);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    public void OpenFileDToWrite(String fileName){   //false se mat du lieu khi chay lai
        try{
            fileWriter = new FileWriter(fileName, false);
            buffereWriter = new BufferedWriter(fileWriter);
            printWriter = new PrintWriter(buffereWriter);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public void CloseFileAfterWriter(){
        try{
            printWriter.close();
            buffereWriter.close();
            fileWriter.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void OpenFileToRead(String fileName){
        try{
            File file = new File(fileName);
            if(!file.exists()){
                file.createNewFile();
            }
            scanner = new Scanner(Paths.get(fileName),"UTF-8");
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void CloseFileAfterRead(){
        try{
            scanner.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void WriteMaterialToFile(String fileName, NguyenLieu nguyenLieu){
        OpenFileToWrite(fileName);
        printWriter.println(nguyenLieu.getMaNL()+ "|"+ nguyenLieu.getName()+ "|"+ nguyenLieu.getSoLuong()+"|"+nguyenLieu.getGiaTien());
        CloseFileAfterWriter();
    }

    public void WriteDishToFile(String fileName, MonAn monAn){
        OpenFileDToWrite(fileName);
        printWriter.println(monAn.getMaMon() + "|"+monAn.getTenMonAn()+"|" + monAn.getMoney());
        CloseFileAfterWriter();
    }

    public ArrayList<NguyenLieu> CreateMaterialFromData(String fileName){
        OpenFileToRead(fileName);
        ArrayList<NguyenLieu> listMaterial = new ArrayList<>();
        while(scanner.hasNext()){
            String data = scanner.nextLine();
            String[] materialStr = data.split("\\|");
            NguyenLieu material = new NguyenLieu(materialStr[0],materialStr[1], Integer.parseInt(materialStr[2]),Double.parseDouble(materialStr[3]));
            listMaterial.add(material);
        }
        CloseFileAfterRead();
        return listMaterial;
    }

    public ArrayList<MonAn> CreateDishFromData(String fileName){
        OpenFileToRead(fileName);
        ArrayList<MonAn> listDish = new ArrayList<>();
        while(scanner.hasNext()){
            String data = scanner.nextLine();
            String [] dishStr = data.split("\\|");
            MonAn dish = new MonAn(dishStr[0], dishStr[1], Double.parseDouble(dishStr[2]));
            listDish.add(dish);
        }
        CloseFileAfterRead();
        return listDish;
    }

    public void UpdateMaterialToFile(ArrayList<NguyenLieu> materials ,String fileName){
        File file = new File(fileName);
        if(file.exists()){
            file.delete();
        }
        for(NguyenLieu x : materials){
            WriteMaterialToFile(fileName, x);
        }
    }

    public void UpdateDishToFile(ArrayList<MonAn> dishes , String fileName){
        File file = new File(fileName);
        if(file.exists()){
            file.delete();
        }
        OpenFileDToWrite(fileName);
        for(MonAn a : dishes){
            WriteDishToFile(fileName, a);
        }
    }

    //tai khoan
    public void WriteTaiKhoanToFile(String fileName, taikhoan tkhoan){
        OpenFileToWrite(fileName);
        printWriter.println(tkhoan.getTenDn() +"|"+ tkhoan.getPass()+"|"+tkhoan.getTk());
        CloseFileAfterWriter();
    }
    public ArrayList<taikhoan> CreateTaiKhoanFromData(String fileName){
        OpenFileToRead(fileName);
        ArrayList<taikhoan> listtaikhoan = new ArrayList<>();
        while(scanner.hasNext()){
            String data = scanner.nextLine();
            String[] materialStr = data.split("\\|");
            taikhoan tkhoan = new taikhoan(materialStr[0],materialStr[1], Long.parseLong(materialStr[2]));
            listtaikhoan.add(tkhoan);
        }
        CloseFileAfterRead();
        return listtaikhoan;
    }
    public void UpdateTaiKhoanToFile(ArrayList<taikhoan> tks , String fileName){
        File file = new File(fileName);
        if(file.exists()){
            file.delete();
        }
        OpenFileToWrite(fileName);
        for(taikhoan tk : tks){
            WriteTaiKhoanToFile(fileName, tk);
        }
    }
}