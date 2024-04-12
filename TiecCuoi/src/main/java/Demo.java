import java.io.FileNotFoundException;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner j = new Scanner(System.in);
        QuanLySanhCuoi s = new QuanLySanhCuoi();
        QuanLyMenu qlmenu = new QuanLyMenu();
        QuanLyDichVu qldv = new QuanLyDichVu();
        ThongTinThue ttt = new ThongTinThue();
        int lc = 0;
        do {
        System.out.println("=== CHAO MUNG DEN VOI TIEC CUOI ===");
        //1. có bao gồm:tên tiệc, bàn, sảnh, vị trí tầng
        System.out.println("1. Sanh Cuoi \n" +
                //2. chọn thức ăn ; nước uống(pepsi,cola,bia, rượu, nước lọc)
                "2. Menu\n" +
                //3. hỏi thêm chọn dịch vụ nào và cho chọn nhìu dv
                "3. Dich Vu\n" +
                "4.Thong Tin Thue\n" + //4. danh sach thue, ten, ....
                "5.Thanh Toan Hoa Don\n" +//5. tong ket lai don gia
                "0.Thoat.");
        System.out.println("===================================");

        System.out.print("Lua chon: ");
        lc = Integer.parseInt(j.nextLine());
            switch (lc) {
                case 1:
                    s.console();
                    break;
                case 2:
                    qlmenu.console();
                    break;
                case 3:
                    qldv.console();
                    break;
                case 4:
                    System.out.println("Ban vao Thong tin thue!!!\n");
                    ttt.nhapThongTin();
                    ttt.hienThi();
                    break;
                case 5:
                    System.out.println("Dang xuat Hoa Don!!!\n");
                    ttt.hienThi();
                    break;
            }
        }while (lc != 0);
    }
}

//
//
//        QuanLySanhCuoi q = new QuanLySanhCuoi();
//        int lc;
//
//        while (true) {
//            SanhCuoi s = new SanhCuoi();
//            s.nhap();
//            q.them(s);
//            System.out.print("Them Sanh(1/0): ");
//            lc = Integer.parseInt(j.nextLine());
//            if(lc == 0) break;
//        }
//
//        q.xuatds();
//        int id = 0;
//        System.out.print("Nhap id can cap nhat: ");
//        id = Integer.parseInt(j.nextLine());
//        q.capNhat(id);
//        q.xuatds();
//
//        String kw;
//        System.out.print("Nhap ten can xoa: ");
//        kw = j.nextLine();
//        q.xoa(kw);
//        q.xuatds();
//        q.traCuu(kw).forEach(h->h.xuat());
//
//        DichVu d = new Karaoke();
//        d.nhap();
//        d.xuat();
//
//        Karaoke d = new Karaoke();
//        QuanLyDichVu q = new QuanLyDichVu();
//
//        q.docFileKR();
//        q.xuatds();
//    }
//}
