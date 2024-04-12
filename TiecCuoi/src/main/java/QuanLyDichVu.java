//package quanLy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class QuanLyDichVu implements QuanLy<DichVu> {
    public static final Scanner s = new Scanner(System.in);
    private List<DichVu> ds = new ArrayList<>();
    private  List<CaSi> cs = new ArrayList<>();
    private  List<Karaoke> kara = new ArrayList<>();
    private  List<TrangTri> ttri = new ArrayList<>();
    Scanner j = new Scanner(System.in);

    @Override
    public void them(DichVu d) {
        this.ds.add(d);
    }

    @Override
    public void capNhat(int id) throws NoSuchMethodException, ClassNotFoundException {
        for(DichVu d: this.ds){
            if(d.getID() == id) {

                String name = null;
                System.out.print("Nhap lai ten dich vu: ");
                name = s.nextLine();
                d.setTenDV(name);

                double gt = 0;
                System.out.print("Nhap lai gia thue: ");
                gt = Double.parseDouble(s.nextLine());
                d.setGiaDV(gt);

            }
        }
    }
    public void docFileKR() throws FileNotFoundException {
        File f = new File("src/main/resources/Karaoke.txt");
        try (Scanner s = new Scanner(f)) {
            while (s.hasNext()) {
                Karaoke k = new Karaoke();
                k.setID(Integer.parseInt(s.nextLine()));
               k.setTenDV(s.nextLine());

                //k.setSoluongBH(Integer.parseInt(s.nextLine()));
                k.setGiaDV(Double.parseDouble(s.nextLine()));
                k.setTgThue(Integer.parseInt(s.nextLine()));
//                System.out.print("Nhap thoi gian thue: ");
//                int tgThue = 0;
//                tgThue = Integer.parseInt(s.nextLine());
//                k.setTgThue(tgThue);
                them(k);
            }
        }
    }
//    public void ghiFileKR() throws FileNotFoundException {
//        File f = new File("src/main/resources/Karaoke.txt");
//        try (PrintWriter w = new PrintWriter(f)){
//            this.kara.forEach(c -> {
//                w.println(c.getID());
//                w.println(c.getTenDV());
//                w.println(c.getGiaDV());
//                w.println(c.getTgThue());
//                //w.println(s.getSoluongBH());
//            } );
//        }
//    }

    public void docFileCS() throws FileNotFoundException {
        File f = new File("src/main/resources/CaSi.txt");
        try (Scanner s = new Scanner(f)) {
            while (s.hasNext()) {
                CaSi c = new CaSi();
                c.setID(Integer.parseInt(s.nextLine()));
                c.setTenCS(s.nextLine());
                c.setGiaDV(Double.parseDouble(s.nextLine()));
                them(c);
            }
        }
    }
    @Override
    public void console() throws FileNotFoundException {
        DichVu dv = new DichVu();
        String b = null;
            System.out.println("3. Dich Vu: ");
            System.out.println("a. Ca Si:\n" +
                    "b. Karaoke\n" +
                    "c. Trang Trí\n");
            // "d.+ Hien thi dich vu da dang ky:\n" +
            //"e. Luu lai");
            do {
                System.out.print("Nhap lua chon: ");
                b = j.nextLine();
                switch (b) {
                    case "a":
                        String c = null;

                        CaSi cs = new CaSi();
                        System.out.println("Ban vao dang ky thong tin ca si!!!\n" +
                                "a1. Hien danh sach ca si\n" +
                                "a2. Them ca si\n" +
                                "a3. Xoa ca si\n");
                            System.out.println("Chon: ");
                        c = j.nextLine();
                            switch (c) {
                                case "a1":
                                    System.out.println("====Danh sach ca si=====\n");
                                    docFileCS();
                                    xuatds();
                                    break;
                                case "a2":
                                    System.out.println("Them ca si\n");
                                    them(cs);
                                    cs.nhap();
                                    cs.xuat();
                                    break;
                                case "a3":
                                    System.out.println("Xoa ca si \n");
                                    String kw = null;
                                    System.out.print("Nhap ten can xoa: ");
                                    kw = j.nextLine();
                                    xoa(kw);
                                    if(xoa(kw) == true){
                                        System.out.println("Success");
                                    }
                                    break;
                            }
                            case "b":
                                String d = null;
                                d = j.nextLine();
                                Karaoke kara = new Karaoke();
                                System.out.println("Ban vao dang ky dich vu Karaoke!!!\n");
                            kara.nhap();
                            kara.xuat();
                            break;
                            case "c":
                                TrangTri ttri = new TrangTri();
                                System.out.println("Ban vao dang ky dich vu trang tri!!!\n");
                                ttri.nhap();
                                ttri.xuat();
                                break;
//                case "d":
//                    System.out.println("Hien thi thong tin dich vu da dang ky\n");
//                    break;
//                case "e":
//                    System.out.println("Luu lai thong tin dang ky\n");
//                    break;
                        }
            }while (b != "0");
            }

    public List<DichVu> timKiemTheoLoai(String duongDan) throws ClassNotFoundException {
        Class c = Class.forName(duongDan);

        return this.ds.stream().filter(h -> c.isInstance(h)).collect(Collectors.toList());
    }


    @Override
    public boolean xoa(String kw) {
        return this.ds.removeIf(h -> h.getTenDV().contains(kw));
    }


    @Override
    public List<DichVu> traCuu(String kw) {
        return this.ds.stream().filter(h -> h.getTenDV().contains(kw)).collect(Collectors.toList());
    }

    @Override
    public void xuatds() {
        this.ds.forEach(h -> h.xuat());
    }
}
