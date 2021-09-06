package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Ticket {
    private String tenChuyen;
    private LocalDateTime ngayBay;
    private int giaVe;

    public Ticket() {
    }

    public String getTenChuyen() {
        return tenChuyen;
    }

    public LocalDateTime getNgayBay() {
        return ngayBay;
    }

    public int getGiaVe() {
        return giaVe;
    }

    public Ticket(String tenChuyen, LocalDateTime ngayBay, int giaVe) {
        this.tenChuyen = tenChuyen;
        this.ngayBay = ngayBay;
        this.giaVe = giaVe;
    }

    public Ticket nhapThongTinChuyenBay() {
        System.out.print("Nhập tên chuyến bay: ");
        this.tenChuyen = new Scanner(System.in).nextLine();
        System.out.print("Nhập ngày bay (Định dạng dd/MM/yyyy HH:mm): ");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        this.ngayBay = LocalDateTime.parse(new Scanner(System.in).nextLine(), formatter);
        System.out.print("Nhập giá vé: ");
        this.giaVe = new Scanner(System.in).nextInt();
        return new Ticket(tenChuyen, ngayBay, giaVe);
    }

    public String xuatThongTinVe() {
        return "Tên chuyến bay: " + getTenChuyen() + "\tNgày bay: " + getNgayBay().toString() + "\tGiá vé: " + getGiaVe() + "\n";
    }

    public Ticket[] nhapDSVe() {
        Scanner input = new Scanner(System.in);
        System.out.print("- Ticket quantity: ");
        int quantityTicket = input.nextInt();
        Ticket[] listTicket = new Ticket[quantityTicket];
        Ticket ticket = new Ticket();
        for (int i = 0; i < listTicket.length; i++) {
            listTicket[i] = ticket.nhapThongTinChuyenBay();
        }
        return listTicket;
    }

    public String xuatDSVe() {
        Ticket ticket = new Ticket();
        String listTicket = " ";
        for (int i = 0; i < nhapDSVe().length; i++) {
            ticket = nhapDSVe()[i];
            listTicket = listTicket + (i + 1) + ". " + ticket.getTenChuyen() + " " +
                    ticket.getNgayBay().toString() + " " + ticket.getGiaVe() + "\n";
            System.out.println();
        }
        return listTicket;
    }

    public Double getTongGiaVe(Ticket[] DSVe) {
        Double tongGiaVe = 0D;
        for (int i = 0; i < DSVe.length; i++) {
            tongGiaVe += DSVe[i].getGiaVe();
        }
        return tongGiaVe;
    }
}
