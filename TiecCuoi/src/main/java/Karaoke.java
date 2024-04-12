import java.util.Calendar;
import java.util.Scanner;

public class Karaoke extends DichVu{
    public Calendar c = Calendar.getInstance();
    private int tgThue;
    private int soluongBH;

    public Karaoke(){

    }

    public Karaoke(int  id, String t, double g, int thue,int sl){
        super(id, t, g);
        this.setTgThue(thue);
        this.setSoluongBH(sl);
    }

    public static void showCalendar(Calendar c) {

        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        System.out.println(hour + ":" + minute);
    }

    @Override
    public void nhap() {
        super.nhap();
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap thoi gian thue: ");
        this.setTgThue(Integer.parseInt(input.nextLine()));
    }

    public Calendar tThue(){
        c.add(Calendar.HOUR_OF_DAY, this.getTgThue());
        return c;
    }

    @Override
    public void xuat() {
        super.xuat();
//        Calendar a = Calendar.getInstance();
//        c.add(Calendar.HOUR_OF_DAY, this.getTgThue());
//        System.out.print("Thoi gian dang ky: ");
//        showCalendar(a);
        System.out.printf("Thoi gian thue: %d\n"
//                "Thoi gian ket thuc: "
                , this.getTgThue());
//        showCalendar(c);
    }
    public int getSoluongBH() {
        return soluongBH;
    }

    public void setSoluongBH(int soluongBH) {
        this.soluongBH = soluongBH;
    }

    public int getTgThue() {
        return tgThue;
    }

    public void setTgThue(int tgThue) {
        this.tgThue = tgThue;
    }
}
