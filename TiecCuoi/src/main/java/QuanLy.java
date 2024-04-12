import java.io.FileNotFoundException;
import java.util.List;

public interface QuanLy<T> {
    // Cac phuong thuc truu tuong
    void them(T s);
    void capNhat(int id) throws NoSuchMethodException, ClassNotFoundException;
    boolean xoa(String kw);
    List<T> traCuu(String kw); //List<Object>
    void xuatds();
    void console() throws FileNotFoundException;
}