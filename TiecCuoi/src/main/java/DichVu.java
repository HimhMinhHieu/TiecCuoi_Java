import java.util.Scanner;

public class DichVu {
    private int ID;
    private String tenDV;
    private double giaDV;

    public DichVu(){

    }

    public DichVu(int id, String t, double g){
        this.ID = id;
        this.tenDV = t;
        this.giaDV = g;
    }

    public void nhap(){
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap ID dich vu: ");
        this.ID = Integer.parseInt(input.nextLine());
        System.out.print("Nhap Ten dich vu: ");
        this.tenDV = input.nextLine();
        System.out.print("Nhap gia dich vu: ");
        this.giaDV = Double.parseDouble(input.nextLine());
    }

    public void xuat(){
        System.out.printf("ID dich vu: %d\n" +
                "Gia dich vu: %f\n", this.ID, this.giaDV);
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTenDV() {
        return tenDV;
    }

    public void setTenDV(String ten) {
        this.tenDV = ten;
    }

    public double getGiaDV() {
        return giaDV;
    }

    public void setGiaDV(double gia) {
        this.giaDV = gia;
    }
}
