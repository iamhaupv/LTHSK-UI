package Bai1Tuan2;

public class Main {
	public static void main(String[] args) {
		DanhSachNhanVien dao = new DanhSachNhanVien();
		new frmNhanVien(dao).setVisible(true);
	}
}
