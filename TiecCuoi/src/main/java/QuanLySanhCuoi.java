import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class QuanLySanhCuoi implements QuanLy<SanhCuoi> {
    private List<SanhCuoi> ds = new ArrayList<>();
    Scanner j = new Scanner(System.in);

    @Override
    public void them(SanhCuoi s) {
       // System.out.println("Them thanh cong");
        this.ds.add(s);
    }

    @Override
    public void capNhat(int id) {
        for(SanhCuoi c: this.ds){
            if(c.getId() == id) {

                String name = null;
                System.out.print("Nhap lai ten: ");
                name = j.nextLine();
                c.setTen(name);

                int vt = 0;
                System.out.print("Nhap lai vi tri: ");
                vt = Integer.parseInt(j.nextLine());
                c.setViTri(vt);

                int sc = 0;
                System.out.print("Nhap lai suc chua: ");
                sc = Integer.parseInt(j.nextLine());
                c.setSucChua(sc);

                double gt = 0;
                System.out.print("Nhap lai gia thue: ");
                gt = Double.parseDouble(j.nextLine());
                c.setGiathue(gt);

            }
        }
    }
//    public void ghiFileSC() throws FileNotFoundException {
//        File f = new File("src/main/resources/SanhCuoi.txt");
//        try (PrintWriter w =new PrintWriter(f)){
//            this.ds.forEach(s -> {
//                w.println(s.getTen());
//                w.println(s.getViTri());
//                w.println(s.getSucChua());
//                w.println(s.getTd());
//                w.println(s.getCt());
//                w.println(s.getGiathue());
//
//            } );
//           // System.out.println("");
//        }
//    }
    public void docFileSC() throws FileNotFoundException {
        File f = new File("src/main/resources/SanhCuoi.txt");
        try (Scanner s = new Scanner(f)) {
            while (s.hasNext()) {
                SanhCuoi l = new SanhCuoi();
                l.setTen(s.nextLine());
                l.setViTri(Integer.parseInt(s.nextLine()));
                l.setSucChua(Integer.parseInt(s.nextLine()));
                l.setTd(TD.valueOf(s.nextLine()));
                l.setCt(NCT.valueOf(s.nextLine()));
                l.setGiathue(Double.parseDouble(s.nextLine()));
                them(l);
            }
        }
    }
    public void console() throws FileNotFoundException {
        SanhCuoi s = new SanhCuoi();
        QuanLySanhCuoi q = new QuanLySanhCuoi();
        //q.docFileSC();
        String a = null;
        System.out.println("1. Sanh Cuoi");
        System.out.println("a. Them sanh\n" +
                "b. Cap Nhat\n" +
                "c. Xoa\n" +
                "d. Hien thi danh sach\n" +
                "e. Luu lai");
        do{
        System.out.print("Nhap lua chon: ");
        a = j.nextLine();

        switch (a) {
            case "a":
                    System.out.println("a. Them");
                    s.nhap();
                    q.them(s);
                    q.xuatds();

//                q.ghiFileSC();
                break;

            case "b":
                System.out.println("b. Cap Nhat");
                System.out.print("ID muon tim: ");
                int id = 0;
                id = Integer.parseInt(j.nextLine());
                q.capNhat(id);
//                q.ghiFileSC();
                break;

            case "c":
                System.out.println("c. Xoa");
                System.out.print("Ten muon xoa: ");
                String kw = null;
                kw = j.nextLine();
                q.xoa(kw);
//                q.ghiFileSC();
                break;

            case "d":
                System.out.println("d. Hien Thi Danh Sach");
                q.docFileSC();
                q.xuatds();
                break;
//
//            case "e":
//                System.out.println("e. Luu lai");
////                q.ghiFileSC();
//                break;
//
        }
    }while(a == "a" || a == "b" || a == "c" || a == "d");
    }
    @Override
    public boolean xoa(String kw) {
        return this.ds.removeIf(h -> h.getTen().contains(kw));
    }

    @Override
    public List<SanhCuoi> traCuu(String kw) {
        return this.ds.stream().filter(h->h.getTen().contains(kw) == true).collect(Collectors.toList());
    }

    @Override
    public void xuatds() {
        this.ds.forEach(h -> h.xuat());
    }
}
