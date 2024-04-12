import java.util.Scanner;

public class SanhCuoi {
    private static int dem = 0;
    private int id = ++dem;
    private String ten;
    private int viTri;
    private int sucChua;
    private double giathue;
    private TD td;
    private NCT ct;

    public SanhCuoi(){

    }

    public SanhCuoi(int id, String t, int vt, int sc, double gt, TD td, NCT ct){
        this.id = id;
        this.ten = t;
        this.viTri = vt;
        this.sucChua = sc;
        this.giathue = gt;
        this.td = td;
        this.ct = ct;
    }

    public void nhap(){
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap ten: ");
        this.ten = input.nextLine();
        System.out.print("Nhap vi tri: ");
        this.viTri = Integer.parseInt(input.nextLine());
        System.out.print("Nhap suc chua: ");
        this.sucChua = Integer.parseInt(input.nextLine());
        System.out.print("Nhap Thoi diem: ");
        this.td = TD.valueOf(input.nextLine());
        System.out.print("Nhap cuoi tuan: ");
        this.ct = NCT.valueOf(input.nextLine());
        System.out.print("Nhap Tien: ");
        this.giathue = Double.parseDouble(input.nextLine());
    }

    public void xuat(){
        System.out.println("=============");
        System.out.printf("ID: S%03d\n " +
                "Ten: %s\n " +
                "Vi Tri: %d tang\n " +
                "Suc Chua: %d ban\n " +
                "Thoi Diem: %s\n " +
                "Thoi Gian: %s\n " +
                "Tien Thue: %f\n",
                this.id, this.ten, this.viTri, this.sucChua,
                this.td, this.ct, this.giathue);
        System.out.println("=============");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getViTri() {
        return viTri;
    }

    public void setViTri(int viTri) {
        this.viTri = viTri;
    }

    public int getSucChua() {
        return sucChua;
    }

    public void setSucChua(int sucChua) {
        this.sucChua = sucChua;
    }

    public double getGiathue() {
        return giathue;
    }

    public void setGiathue(double giathue) {
        this.giathue = giathue;
    }

    public TD getTd() {
        return td;
    }

    public void setTd(TD td) {
        this.td = td;
    }

    public NCT getCt() {
        return ct;
    }

    public void setCt(NCT ct) {
        this.ct = ct;
    }
}
