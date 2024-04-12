import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ThucAn extends Menu{
    private String anChay;

    public ThucAn(int id, String ten, double gia,String anChay) {
        super(id, ten, gia);
        this.anChay = anChay;
    }

    public ThucAn(String fresh){
        this.anChay = fresh;
    }

    public ThucAn(){
        super();
    }

    @Override
    public void nhap() {
        super.nhap();
        Scanner input = new Scanner(System.in);
        System.out.print("Co/Khong an chay: ");
        this.anChay = input.nextLine();
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.printf("An Chay: %s\n", this.getAnChay());
    }


//    @Override
//    public void nhap() {
//        Scanner input = new Scanner(System.in)
//        System.out.print("Nhap ID: ");
//         = Integer.parseInt(input.nextLine());
//    }
//
//    @Override
//    public void xuat() {
//
//    }

    public String getAnChay() {
        return anChay;
    }

    public void setAnChay(String anChay) {
        this.anChay = anChay;
    }
}
