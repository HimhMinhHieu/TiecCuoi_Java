import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ThongTinThue {
    private static final SimpleDateFormat F2 = new SimpleDateFormat("dd/MM/yyyy");
    QuanLySanhCuoi qlsc = new QuanLySanhCuoi();
    QuanLyMenu qlmn = new QuanLyMenu();
    QuanLyDichVu qldv = new QuanLyDichVu();
    SanhCuoi s = new SanhCuoi();
    private String ten;
    private List<SanhCuoi> sanhCuoi = new ArrayList<>();
    private double donGiaSanh;
    private TD td;
    private Date ngay;
    private List<ThucAn> m = new ArrayList<>();
    private List<ThucUong> u = new ArrayList<>();
    private List<DichVu> d = new ArrayList<>();
    private double donGia;

    public ThongTinThue(){

    }

    public ThongTinThue(String t, List<SanhCuoi> sc, double dgs, TD td, Date n, List<ThucAn> m, List<ThucUong> u, List<DichVu> d, double dg){
        this.ten = t;
        this.sanhCuoi = sc;
        this.donGiaSanh = dgs;
        this.td = td;
        this.ngay = n;
        this.m = m;
        this.u = u;
        this.d = d;
        this.donGia = dg;
    }

    public ThongTinThue(String t, List<SanhCuoi> sc, double dgs, TD td, String n, List<ThucAn> m, List<ThucUong> u, List<DichVu> d, double dg) throws ParseException {
        this(t, sc, dgs, td, F2.parse(n), m, u, d, dg);
    }

    public List<SanhCuoi> traCuu(int id) {
        return this.sanhCuoi.stream().filter(h->h.getId() == id).collect(Collectors.toList());
    }

    public List<ThucAn> traCuuTA(int id) {
        return this.m.stream().filter(h -> h.getIdMenu() == id).collect(Collectors.toList());
    }
    public List<ThucUong> traCuuTU(int id) {
        return this.u.stream().filter(h -> h.getIdMenu() == id).collect(Collectors.toList());
    }
    public void xuatds() {
        this.sanhCuoi.forEach(h -> h.xuat());
    }
    public void xuatdsTA() {
        this.m.forEach(h -> h.xuat());
    }
    public void xuatdsTU() {
        this.u.forEach(h -> h.xuat());
    }

    public void Tong(){
        int tong = 0;
        tong += getDonGia();
    }

    public double tinhDonGiaTA(int id){
        int tong = 0;
        traCuuTA(id);
        for(ThucAn c : this.traCuuTA(id)){
            tong += c.getGiaMenu();
        }
        return tong;
    }

    public double tinhDonGiaTU(int id){
        int tong = 0;
        traCuuTU(id);
        for(ThucUong c : this.traCuuTU(id)){
            tong += c.getGiaMenu();
        }
        return tong;
    }

    public double tinhDonGiaSanh(int id){
        int tong = 0;
        traCuu(id);
        for(SanhCuoi c : this.traCuu(id)){
            tong += c.getGiathue();
        }

        return tong;
    }

    public double tongTat(int id, int Id, int ID) {
        return this.tinhDonGiaSanh(id) + this.tinhDonGiaTA(Id) + this.tinhDonGiaTU(ID);
    }


    public void nhapThongTin(){
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap ten buoi tiec: ");
        this.ten = input.nextLine();

    }

    public void docFileTTT() throws FileNotFoundException, ParseException {
        File f = new File("src/main/resources/TTT.txt");
        try (Scanner s = new Scanner(f)) {
            while (s.hasNext()) {
                ThongTinThue ttt = new ThongTinThue();
                ttt.setTen(s.nextLine());
                ttt.setNgay(F2.parse(s.nextLine()));
            }
        }
    }

    public void hienThi(){
        Scanner input = new Scanner(System.in);
        System.out.printf("Ten buoi tiec: %s\n", this.ten);
        int id = 0;
        System.out.print("Nhap ID sanh muon thue: ");
        id = Integer.parseInt(input.nextLine());
        traCuu(id).forEach(h->xuatds());
        System.out.print("Nhap ID mon an muon them: ");
        int Id = 0;
        Id = Integer.parseInt(input.nextLine());
        traCuuTA(Id).forEach(h->xuatdsTA());
        int ID = 0;
        System.out.print("Nhap ID thuc uong muon them: ");
        ID = Integer.parseInt(input.nextLine());
        traCuuTU(ID).forEach(h->xuatdsTU());
        System.out.printf("Tong Gia: ", this.tongTat(id, Id, ID));
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public List<SanhCuoi> getSanhCuoi() {
        return sanhCuoi;
    }

    public void setSanhCuoi(List<SanhCuoi> sanhCuoi) {
        this.sanhCuoi = sanhCuoi;
    }

    public double getDonGiaSanh() {
        return donGiaSanh;
    }

    public void setDonGiaSanh(double donGiaSanh) {
        this.donGiaSanh = donGiaSanh;
    }

    public TD getTd() {
        return td;
    }

    public void setTd(TD td) {
        this.td = td;
    }

    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }

    public List<ThucAn> getM() {
        return m;
    }

    public void setM(List<ThucAn> m) {
        this.m = m;
    }

    public List<DichVu> getD() {
        return d;
    }

    public void setD(List<DichVu> d) {
        this.d = d;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }
}
