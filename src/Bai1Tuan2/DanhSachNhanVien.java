package Bai1Tuan2;

import java.util.ArrayList;

public class DanhSachNhanVien{
	private ArrayList<NhanVien> list;
	
	
	public DanhSachNhanVien() {
		list = new ArrayList<NhanVien>();
	}
	
	public boolean themNhanVien(NhanVien nv) {
		if(list.contains(nv))
			return false;
		list.add(nv);
		return true;
	}
	public boolean xoaNhanVien(int maNV) {
		NhanVien nv= new NhanVien(maNV);
		if(list.contains(nv)) {
			list.remove(nv);
			return true;
		}
		return false;
	}
	public NhanVien timKiem(int maNV) {
		NhanVien nv= new NhanVien(maNV);
		if(list.contains(nv))
			return list.get(list.indexOf(nv));
		return null;
	}
	public ArrayList<NhanVien> getList(){
		return list;
	}	
}
