import java.util.ArrayList;
import java.util.Scanner;

public class Book {
	static Scanner key = new Scanner(System.in);
	static ArrayList<tacGia> tg = new ArrayList<>();
	static ArrayList<Book> bk = new ArrayList<>();

	String tenB, ngayXB, butDanh;

	public Book() {

	}

	public Book(String tenB, String ngayXB, String butDanh) {
		this.tenB = tenB;
		this.ngayXB = ngayXB;
		this.butDanh = butDanh;
	}

	public static Scanner getKey() {
		return key;
	}

	public static void setKey(Scanner key) {
		Book.key = key;
	}

	public String getTenB() {
		return tenB;
	}

	public void setTenB(String tenB) {
		this.tenB = tenB;
	}

	public String getNgayXB() {
		return ngayXB;
	}

	public void setNgayXB(String ngayXB) {
		this.ngayXB = ngayXB;
	}

	public String getButDanh() {
		return butDanh;
	}

	public void setButDanh(String butDanh) {
		this.butDanh = butDanh;
	}

	public void nhapThongTinB() {
		System.out.print("Nhap Ten Sach: ");
		tenB = key.nextLine();
		System.out.print("Nhap Ngay Xuat Ban: ");
		ngayXB = key.nextLine();
		System.out.print("Nhap But Danh: ");
		butDanh = key.nextLine();
	}

	public void hienThiB() {
		System.out.printf("%-20s %-20s %-20s \n", tenB, ngayXB, butDanh);
	}

	public static void Menu() {
		System.out.println("**** Chon Chuong Trinh ****\n" + "1. Nhap Thong Tin Sach\n" + "2. Hien Thi Sach\n"
				+ "3. Nhap thong tin Tac Gia\n" + "4. Tim kiem Ten Sach theo But Danh\n" + "5. Thoat");
	}

	public static void main(String[] args) {
		int n = 0;
		boolean kt = true;
		do {
			Menu();
			System.out.print("Nhap ma: ");
			int ma = Integer.parseInt(key.nextLine());
			switch (ma) {
			case 1:
				System.out.print("Nhap so Sach can them: ");
				n = Integer.parseInt(key.nextLine());
				for (int i = 0; i < n; i++) {
					System.out.println("**** Sach " + (i + 1) + " ****");
					Book b = new Book();
					b.nhapThongTinB();
					boolean xm = false;
					for (int j = 0; j < tg.size(); j++) {
						if (tg.get(j).getButDanh().equalsIgnoreCase(b.getButDanh())) {
							xm = true;
							break;
						}
					}
					if (!xm) {
						tacGia a = new tacGia(b.getButDanh());
						a.nhapThongTinTG();
						tg.add(a);
					}
					bk.add(b);
				}
				break;
			case 2:
				System.out.printf("%-20s %-20s %-20s \n", "Ten Sach", "Ngay Xuat Ban", "But Danh");
				for (Book b : bk) {
					b.hienThiB();
				}
				break;
			case 3:
				System.out.print("Nhap so Tac Gia can them: ");
				n = Integer.parseInt(key.nextLine());

				for (int i = 0; i < n; i++) {
					System.out.println("**** Tac Gia " + (i + 1) + " ****");
					tacGia a = new tacGia();
					a.nhapThongTinTG(tg);
					tg.add(a);
				}
				break;
			case 4:
				System.out.print("Nhap Ten But Danh Tim Kiem: ");
				String name = key.nextLine();

				for (int i = 0; i < bk.size(); i++) {
					if (bk.get(i).getButDanh().equalsIgnoreCase(name)) {
						bk.get(i).hienThiB();
					}
				}
				break;
			default:
				System.out.println("Good Bye !!!");
				kt = false;
				break;
			}
		} while (kt);
	}
}

class tacGia {
	static Scanner key = new Scanner(System.in);
	private String ten, butDanh, ngaySinh, queQuan;
	private int tuoi;

	public tacGia() {

	}

	public tacGia(String butDanh) {
		this.butDanh = butDanh;
	}

	public tacGia(String ten, String butDanh, String ngaySinh, String queQuan, int tuoi) {
		this.ten = ten;
		this.butDanh = butDanh;
		this.ngaySinh = ngaySinh;
		this.queQuan = queQuan;
		this.tuoi = tuoi;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getButDanh() {
		return butDanh;
	}

	public void setButDanh(String butDanh) {
		this.butDanh = butDanh;
	}

	public String getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getQueQuan() {
		return queQuan;
	}

	public void setQueQuan(String queQuan) {
		this.queQuan = queQuan;
	}

	public int getTuoi() {
		return tuoi;
	}

	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

	public void nhapThongTinTG(ArrayList<tacGia> tg) {
		nhapThongTinTG();
		System.out.print("Nhap But Danh: ");
		while (true) {
			butDanh = key.nextLine();
			boolean kt = false;

			for (int i = 0; i < tg.size(); i++) {
				if (tg.get(i).getButDanh().equalsIgnoreCase(butDanh)) {
					kt = true;
					break;
				}
			}
			if (!kt) {
				break;
			} else
				System.err.print("Nhap But Danh Khac: ");
		}

	}

	public void nhapThongTinTG() {
		System.out.print("Nhap Ten Tac Gia: ");
		ten = key.nextLine();
		System.out.print("Nhap Tuoi: ");
		tuoi = Integer.parseInt(key.nextLine());
		System.out.print("Nhap Ngay Sinh: ");
		ngaySinh = key.nextLine();
		System.out.print("Nhap Que Quan: ");
		queQuan = key.nextLine();
	}

	public void hienThiTG() {
		System.out.printf("%-20s %-20s %-20s %-20s %-20s \n", ten, tuoi, butDanh, ngaySinh, queQuan);
	}
}