import entities.Passenger;
import java.util.Scanner;

/*
 * Nhập vào 1 danh sách n hành khách (n nhập từ bàn phím).
 * Hiển thị danh sách hành khách và số tiền phải trả tương ứng của mỗi khách hàng.
 * Sắp xếp danh sách hành khách theo chiều giảm dần của Tổng tiền.
 * Hiển thị lại danh sách hành khách và số tiền phải trả tương ứng của mỗi khách hàng.
 */

public class App {
    public static void main(String[] args) {
        System.out.print("Nhập số lượng hành khách: ");
        int soLuong = new Scanner(System.in).nextInt();

        Passenger[] dsHanhKhach = Passenger.nhapDSHanhKhach(soLuong);
        System.out.println("----------");
        System.out.println("Danh sách hành khách: ");
        Passenger.xuatDSHanhKhach(dsHanhKhach);

        System.out.println("Danh sách hành khách sau khi sắp xếp: ");
        Passenger[] dsSapXep = dsHanhKhach;
        Passenger.sapXepGiaVeGiamDan(dsSapXep);
    }
}
