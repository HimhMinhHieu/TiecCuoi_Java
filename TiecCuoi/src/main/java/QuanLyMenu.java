import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.invoke.MutableCallSite;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class QuanLyMenu implements QuanLy<Menu> {
    private List<Menu> ds = new ArrayList<>();
    Scanner j = new Scanner(System.in);
    private List<ThucAn> dsta = new ArrayList<>();
    private List<ThucUong> dstu = new ArrayList<>();

    @Override
    public void them(Menu s) {
        this.ds.add(s);
    }

    @Override
    public void capNhat(int id) {
        for (Menu c : this.ds) {
            if (c.getIdMenu() == id) {

                String name = null;
                System.out.print("Nhap lai ten: ");
                name = j.nextLine();
                c.setTenMenu(name);

                double gt = 0;
                System.out.print("Nhap lai gia thue: ");
                gt = Double.parseDouble(j.nextLine());
                c.setGiaMenu(gt);
            }
        }
    }

    @Override
    public boolean xoa(String kw) {
        return this.ds.removeIf(h -> h.getTenMenu().contains(kw));
    }

    @Override
    public List<Menu> traCuu(String kw) {
        return this.ds.stream().filter(h -> h.getTenMenu().contains(kw) == true).collect(Collectors.toList());
    }

    @Override
    public void xuatds() {
        this.ds.forEach(h -> h.xuat());
    }

    public void docFileTA() throws FileNotFoundException {
        File f = new File("src/main/resources/Menu.txt");
        try (Scanner s = new Scanner(f)) {
            while (s.hasNext()) {
                ThucAn a = new ThucAn();
                a.setTenMenu(s.nextLine());
                a.setGiaMenu(Double.parseDouble(s.nextLine()));
                a.setAnChay(s.nextLine());
                them(a);
            }
        }
    }

//    public void ghiFileTA() throws FileNotFoundException {
//        File f = new File("src/main/resources/Menu.txt");
//        try (PrintWriter w = new PrintWriter(f)) {
//            this.dsta.forEach(s -> {
//                w.println(s.getIdMenu());
//                w.println(s.getTenMenu());
//                w.println(s.getGiaMenu());
//                w.println(s.getAnChay());
//            });
//        }
//    }

    public void docFileTU() throws FileNotFoundException {
        File f = new File("src/main/resources/ThucUong.txt");
        try (Scanner s = new Scanner(f)) {
            while (s.hasNext()) {
                ThucUong u = new ThucUong();
                u.setIdMenu(Integer.parseInt(s.nextLine()));
                u.setTenMenu(s.nextLine());
                u.setGiaMenu(Double.parseDouble(s.nextLine()));
                u.setHangSX(s.nextLine());
                them(u);
            }
        }
    }
//    public void ghiFileTU() throws FileNotFoundException {
//        File f = new File("src/main/resources/ThucUong.txt");
//        try (PrintWriter w =new PrintWriter(f)){
//            this.dstu.forEach(s -> {
//                w.println(s.getIdMenu());
//                w.println(s.getTenMenu());
//                w.println(s.getGiaMenu());
//                w.println(s.getHangSX());
//            });
//        }
//    }

    @Override
    public void console() throws FileNotFoundException {
        QuanLyMenu qlmenu = new QuanLyMenu();
        Menu menu = new Menu();
        ThucAn ta = new ThucAn();
        ThucUong tu = new ThucUong();
        String chon = null;
        String chon1 = null;
        String chon2 = null;
        System.out.print("========Ban dang lua chon MENU======== \n");
        do {
            System.out.print("Nhap lua chon(Thuc An/Thuc Uong): ");
            chon = j.nextLine();
            switch (chon) {
                case "Thuc An":
                    System.out.println("Ban da vao thuc an !!!\n" +
                            "a.Xuat danh sach Mon An\n" +
                            "b.Cap nhap Mon An (Co chon mon chay)\n" +
                            "c.Xoa Mon An\n" +
                            "d.Luu lai\n" +
                            "e.Mon An Da Chon\n");

                    do {
                        System.out.print("Nhap lua chon: ");
                        chon1 = j.nextLine();
                        switch (chon1) {
                            case "a":
                                System.out.println("a.Danh sach Mon An:");
                                qlmenu.docFileTA();
                                qlmenu.xuatds();
                                break;
                            case "b":
                                System.out.println("b.Cap nhap Mon An\n");
                                int id = 0;
                                System.out.print("Nhap ID can tim: ");
                                id = Integer.parseInt(j.nextLine());
                                qlmenu.capNhat(id);
                                String fresh = null;
                                System.out.print("An Chay(Co/Khong): ");
                                fresh = j.nextLine();
                                ta.setAnChay(fresh);

                                qlmenu.xuatds();
//                                qlmenu.ghiFileTA();
                                break;
                            case "c":
                                System.out.println("c.Xoa Mon An: \n");
                                String kw = null;
                                kw = j.nextLine();
                                do {
                                    System.out.print("Nhap ten mon an can xoa: ");
                                    qlmenu.xoa(kw);
                                    System.out.println("Xoa Khong Thanh Cong\n" +
                                            "Vui long nhap lai ten!!!!!");
                                } while (qlmenu.xoa(kw) == false);
                                System.out.println("Xoa Thanh Cong  \n");
//                                qlmenu.ghiFileTA();
                                qlmenu.xuatds();
                                break;
                            case "d":
                                System.out.println("d.Luu lai Mon An \n");
                                qlmenu.xuatds();
//                                qlmenu.ghiFileTA();
                                break;
                            case "e":
                                System.out.println("e.Mon An Da Chon: \n");
                                qlmenu.xuatds();
                                qlmenu.docFileTA();
                                break;
                        }
                    } while (chon1 == "0");
                    break;
                case "Thuc Uong":
                    System.out.println("Ban da vao thuc uong !!!" +
                            "a.Xuat danh sach thuc uong" +
                            "b.Cap nhap thuc uong " +
                            "c.Xoa thuc uong" +
                            "d.Luu lai menu thuc uong" +
                            "e.Thuc Uong Da Chon");
                    do {
                        System.out.println("Nhap lua chon: ");
                        chon2 = j.nextLine();
                        switch (chon2) {
                            case "a":
                                System.out.println("a.Danh sach thuc uong");
                                qlmenu.xuatds();
                                qlmenu.docFileTU();
                                break;
                            case "b":
                                System.out.println("b.Cap nhap thuc uong");
                                int ID = 0;
                                System.out.print("Nhap ID can tim: ");
                                ID = Integer.parseInt(j.nextLine());
                                qlmenu.capNhat(ID);
                                String hsx = null;
                                System.out.print("Nhap lai hang SX: ");
                                hsx = j.nextLine();
                                tu.setHangSX(hsx);

                                qlmenu.xuatds();
//                        qlmenu.ghiFileTU();
                                break;
                            case "c":
                                String kw = null;
                                kw = j.nextLine();
                                do {
                                    System.out.print("Nhap ten thuc uong can xoa: ");
                                    qlmenu.xoa(kw);
                                    System.out.println("Xoa Khong Thanh Cong\n" +
                                            "Vui long nhap lai ten!!!!!");
                                } while (qlmenu.xoa(kw) == false);
                                System.out.println("Xoa Thanh Cong   \n");
//                        qlmenu.ghiFileTU();
                                qlmenu.xuatds();
                                break;
                            case "d":
                                System.out.println("d.Luu menu thuc uong ");
                                qlmenu.xuatds();
//                        qlmenu.ghiFileTU();
                                break;
                            case "e":
                                System.out.println("e.Thuc Uong da chon");
                                qlmenu.xuatds();
                                qlmenu.docFileTU();
                                break;
                        }
                    } while (chon2 == "0");
            }
        } while (chon == "0");
    }
}


