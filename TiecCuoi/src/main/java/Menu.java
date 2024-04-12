import java.util.Scanner;

public class Menu {
    private static int dem = -1;
    private int idMenu = ++dem;
    private String tenMenu;
    private double giaMenu;
//    private String danhMuc;

    public Menu(int id,String ten, double gia) {
        this.setIdMenu(id);
        this.setTenMenu(ten);
        this.setGiaMenu(gia);
//        this.danhMuc = dm;
    }

    public Menu(){

    }

//    public Menu(int id, String ten, double gia) {
//    }

    public void nhap(){
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap ten: ");
        this.tenMenu = input.nextLine();
        System.out.print("Nhap gia: ");
        this.setGiaMenu(Double.parseDouble(input.nextLine()));
    }

    public void xuat(){
        System.out.printf("ID: %d\n" +
                "Ten: %s\n" +
                "Gia: %f\n", this.idMenu, this.tenMenu, this.getGiaMenu());
    }


//    public abstract void nhap();
//    public abstract void xuat();
    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public String getTenMenu() {
        return tenMenu;
    }

    public void setTenMenu(String tenMenu) {
        this.tenMenu = tenMenu;
    }

    public double getGiaMenu() {
        return giaMenu;
    }

    public void setGiaMenu(double giaMenu) {
        this.giaMenu = giaMenu;
    }


//    public String getDanhMuc() {
//        return danhMuc;
//    }
//
//    public void setDanhMuc(String danhMuc) {
//        this.danhMuc = danhMuc;
//    }
}
