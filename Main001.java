import java.util.ArrayList;
import java.util.List;

class Laptop {
    private String maSo;
    private String thuongHieu;
    private double giaMua;
    private String cpu;

    public Laptop(String maSo, String thuongHieu, double giaMua, String cpu) {
        this.maSo = maSo;
        this.thuongHieu = thuongHieu;
        this.giaMua = giaMua;
        this.cpu = cpu;
    }

    public String getMaSo() {
        return maSo;
    }

    public String getThuongHieu() {
        return thuongHieu;
    }

    public double getGiaMua() {
        return giaMua;
    }

    public String getCpu() {
        return cpu;
    }

    public double getGiaBan() {
        return giaMua * 1.35;
    }
}

class MayDeBan {
    private String maSo;
    private String cpu;
    private String tenMainboard;
    private double giaMua;
    private double trongLuong;

    public MayDeBan(String maSo, String cpu, String tenMainboard, double giaMua, double trongLuong) {
        this.maSo = maSo;
        this.cpu = cpu;
        this.tenMainboard = tenMainboard;
        this.giaMua = giaMua;
        this.trongLuong = trongLuong;
    }

    public String getMaSo() {
        return maSo;
    }

    public String getCpu() {
        return cpu;
    }

    public String getTenMainboard() {
        return tenMainboard;
    }

    public double getGiaMua() {
        return giaMua;
    }

    public double getTrongLuong() {
        return trongLuong;
    }

    public double getGiaBan() {
        return giaMua * 1.2 + getPhiGiaoHang();
    }

    public double getPhiGiaoHang() {
        return 3 * trongLuong;
    }
}

class UngDung {
    private List<Laptop> laptops;
    private List<MayDeBan> mayDeBans;

    public UngDung() {
        laptops = new ArrayList<>();
        mayDeBans = new ArrayList<>();
    }

    public void themLaptop(Laptop laptop) {
        laptops.add(laptop);
    }

    public void themMayDeBan(MayDeBan mayDeBan) {
        mayDeBans.add(mayDeBan);
    }

    public double tinhTongTienLoi() {
        double tongTienLoi = 0;
        for (Laptop laptop : laptops) {
            tongTienLoi += laptop.getGiaBan() - laptop.getGiaMua();
        }
        for (MayDeBan mayDeBan : mayDeBans) {
            tongTienLoi += mayDeBan.getGiaBan() - mayDeBan.getGiaMua();
        }
        return tongTienLoi;
    }
}

public class Main001 {
    public static void main(String[] args) {
        // Khởi tạo đối tượng UngDung
        UngDung ungDung = new UngDung();

        // Thêm các đối tượng máy tính vào ungDung
        ungDung.themLaptop(new Laptop("L001", "Lenovo", 1000, "Intel i5"));
        ungDung.themLaptop(new Laptop("L002", "Dell", 1200, "Intel i7"));
        ungDung.themLaptop(new Laptop("L003", "HP", 900, "AMD Ryzen 5"));

        ungDung.themMayDeBan(new MayDeBan("D001", "Intel i5", "Asus", 800, 5.2));
        ungDung.themMayDeBan(new MayDeBan("D002", "AMD Ryzen 7", "Gigabyte", 1000, 7.8));

        // Tính tổng tiền lời
        double tongTienLoi = ungDung.tinhTongTienLoi();

        // Xuất kết quả tổng tiền lời
        System.out.println("Tổng tiền lời khi bán các thiết bị: $" + tongTienLoi);
    }
}
