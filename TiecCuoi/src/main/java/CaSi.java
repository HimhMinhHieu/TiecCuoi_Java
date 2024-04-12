//package dichVu;

import java.util.Scanner;

public class CaSi extends DichVu {

    private String tenCS;
    public static final Scanner s = new Scanner(System.in);


    public CaSi (int id, String ten, Double gia, String t){
        super(id,ten,gia);
        this.tenCS = t;
    }

    public CaSi(){
        super();
    }

    public void nhap(){
        super.nhap();
        System.out.printf("Ten ca si: \n");
        this.tenCS = s.nextLine();
    }
    public void xuat(){
        super.xuat();
        System.out.printf("Ten ca si: %s\n",this.tenCS);
    }

    public String getTenCS() {
        return tenCS;
    }

    public void setTenCS(String tenCS) {
        this.tenCS = tenCS;
    }

}
