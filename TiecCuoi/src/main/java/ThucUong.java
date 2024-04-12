import java.util.Scanner;

public class ThucUong extends Menu{
    private String hangSX;

    public ThucUong(int id, String t, double gia, String hangSX){
        super(id, t, gia);
        this.hangSX = hangSX;
    }

    public ThucUong(){

    }

    @Override
    public void nhap() {
        super.nhap();
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap hang SX: ");
        this.hangSX = input.nextLine();
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.printf("Hang SX: %s\n", this.hangSX);
    }

    public String getHangSX() {
        return hangSX;
    }

    public void setHangSX(String hangSX) {
        this.hangSX = hangSX;
    }
}
