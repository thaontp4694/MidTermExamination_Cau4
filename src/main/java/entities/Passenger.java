package entities;

import java.util.Scanner;

public class Passenger {
    private String hoTen, gioiTinh;
    private int tuoi;
    private Ticket[] danhSachVe;

    public Passenger() {
    }

    public Passenger(String hoTen, String gioiTinh, int tuoi, Ticket[] danhSachVe) {
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.tuoi = tuoi;
        this.danhSachVe = danhSachVe;
    }

    public String getHoTen() {
        return this.hoTen;
    }

    public String getGioiTinh() {
        return this.gioiTinh;
    }

    public int getTuoi() {
        return this.tuoi;
    }

    public Ticket[] danhSachVe() {
        return this.danhSachVe;
    }

    public void setDanhSachVe(Ticket[] danhSachVe) {
        this.danhSachVe = danhSachVe;
    }

    public void nhapThongTinHanhKhach() {
        System.out.print("Nhập tên hành khách: ");
        this.hoTen = new Scanner(System.in).nextLine();
        System.out.print("Nhập giới tính: ");
        this.gioiTinh = new Scanner(System.in).next();
        System.out.print("Nhập tuổi: ");
        this.tuoi = new Scanner(System.in).nextInt();
        System.out.print("Nhập số lượng vé: ");
        int soLuongVe = new Scanner(System.in).nextInt();
        Ticket[] danhSachVe = new Ticket[soLuongVe];
        if (soLuongVe > 0) {
            for (int i = 0; i < soLuongVe; i++) {
                System.out.println("Thông tin vé " + (i+1));
                danhSachVe[i] = new Ticket();
                danhSachVe[i].nhapThongTinChuyenBay();
            }
            this.danhSachVe = danhSachVe;
        } else {
            System.out.println("Số lương vé không hợp lệ");
        }
    }

    public String xuatThongTinHanhKhach() {
            String thongTinHanhKhach = "";
            thongTinHanhKhach += "Họ tên: " + this.hoTen + "\nGiới tính: " + this.gioiTinh + "\nTuổi: " + this.tuoi;
            for (int i = 0; i < this.danhSachVe.length; i++) {
                thongTinHanhKhach += "\nThông tin vé " + (i+1) + ":\n" + this.danhSachVe[i].xuatThongTinVe();
            }
            return thongTinHanhKhach;
    }

    public int tongGiaVe() {
        int totalFee = 0;
        for (int i = 0; i < this.danhSachVe.length; i++) {
            totalFee += this.danhSachVe[i].getGiaVe();
        }
        return totalFee;
    }

    public static Passenger[] nhapDSHanhKhach(int n) {
        Passenger[] listPassenger = new Passenger[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Hành khách " + (i+1) + ":");
            listPassenger[i] = new Passenger();
            listPassenger[i].nhapThongTinHanhKhach();
        }
        return listPassenger;
    }

    public static void xuatDSHanhKhach(Passenger[] listPassenger) {
        for (int i = 0; i < listPassenger.length; i++) {
            System.out.println((i+1) + ". " + listPassenger[i].xuatThongTinHanhKhach());
            System.out.println("Tổng giá vé: " + listPassenger[i].tongGiaVe());
            System.out.println();
        }
    }

    public static void sapXepGiaVeGiamDan(Passenger[] listPassenger) {
        for (int i = 0; i < listPassenger.length - 1; i++) {
            for (int j = i + 1; j < listPassenger.length; j++) {
                if (listPassenger[j].tongGiaVe() > listPassenger[i].tongGiaVe()) {
                    Passenger tmp = listPassenger[i];
                    listPassenger[i] = listPassenger[j];
                    listPassenger[j] = tmp;
                }
            }
        }

        for (int i = 0; i < listPassenger.length; i++) {
            System.out.println("Hành khách " + (i+1) +":");
            System.out.println(listPassenger[i].xuatThongTinHanhKhach());
        }
    }
}
