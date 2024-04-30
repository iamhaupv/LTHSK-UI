package Bai1Tuan2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class frmNhanVien extends JFrame implements ActionListener,
MouseListener{
      private DanhSachNhanVien dao;
      private List<NhanVien> list;
      private JTable table;
	private JTextField txtMaNV;
	private JTextField txtHo;
	private JTextField txtTen;
	private JTextField txtTuoi;
	private JRadioButton radNu;
	private JTextField txtTienLuong;
	private DefaultTableModel tableModel;
	private JTextField txtTim;
	private JButton btnTim;
	private JButton btnThem;
	private JButton btnXoaTrang;
	private JButton btnXoa;
	private JButton btnLuu;
	private double tienLuong;
	
	
	public frmNhanVien(DanhSachNhanVien dao) {
		// TODO Auto-generated constructor stub
		setTitle("Danh sách nhân viên");
		setSize(700,450);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		this.dao = dao;
		list = dao.getList();
		JPanel pnlNorth;
		add(pnlNorth = new JPanel(), BorderLayout.NORTH);
		JLabel lblTieuDe;
		pnlNorth.add(lblTieuDe = new JLabel("Thông tin nhân viên"));
		lblTieuDe.setFont(new Font("Time new roman", Font.BOLD, 20));
		lblTieuDe.setForeground(Color.blue);
		Box b = Box.createVerticalBox();
		
		Box b1,b2,b3,b4,b5;
		JLabel lblMaNV, lblHo, lblTen, lblTuoi, lblPhai, lblTienLuong;
		b.add(b1= Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b1.add(lblMaNV = new JLabel("Mã nhân viên: "));
		b1.add(txtMaNV = new JTextField());
		
		b.add(b2= Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b2.add(lblHo = new JLabel("H�?: "));
		b2.add(txtHo = new JTextField());
		b2.add(lblTen = new JLabel("Tên: "));
		b2.add(txtTen = new JTextField());
		
		b.add(b3= Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b3.add(lblTuoi = new JLabel("Tuổi: "));
		b3.add(txtTuoi = new JTextField());
		b3.add(lblPhai = new JLabel("Phái: "));
		b3.add(radNu = new JRadioButton("Nữ"));
		
		b.add(b4= Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b4.add(lblTienLuong = new JLabel("Ti�?n lương: "));
		b4.add(txtTienLuong = new JTextField());
		
		lblHo.setPreferredSize(lblMaNV.getPreferredSize());
		lblPhai.setPreferredSize(lblMaNV.getPreferredSize());
		lblTienLuong.setPreferredSize(lblMaNV.getPreferredSize());
		lblTuoi.setPreferredSize(lblMaNV.getPreferredSize());
		
		b.add(b5= Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		String[] headers = "MaNV;Ho;Ten;Phai;Tuoi;TienLuong".split(";");
		tableModel = new DefaultTableModel(headers,0);
		JScrollPane scroll= new JScrollPane();
		scroll.setViewportView(table = new JTable(tableModel));
		table.setRowHeight(25);
		b5.add(scroll);
		add(b, BorderLayout.CENTER);
		JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		add(split, BorderLayout.SOUTH);
		JPanel pnlLeft, pnlRight;
		split.add(pnlLeft = new JPanel());
		split.add(pnlRight = new JPanel());
		
		pnlLeft.add(new JLabel("Nhập mã số cần tìm: "));
		pnlLeft.add(txtTim = new JTextField(10));
		pnlLeft.add(btnTim = new JButton("Tìm"));
		
		pnlRight.add(btnThem = new JButton("Thêm"));
		pnlRight.add(btnXoaTrang = new JButton("Xóa trắng"));
		pnlRight.add(btnXoa = new JButton("Xóa"));
		pnlRight.add(btnLuu = new JButton("Lưu"));
		
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		
		table.addMouseListener(this);
		
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();
		txtMaNV.setText(table.getValueAt(row, 0).toString());
		txtHo.setText(table.getValueAt(row, 1).toString());
		txtTen.setText(table.getValueAt(row, 2).toString());
		radNu.setSelected(false);
		if(table.getValueAt( row, 3).toString().equalsIgnoreCase("true")) 
			radNu.setSelected(true);
		txtTuoi.setText(table.getValueAt(row, 4).toString());
		txtTienLuong.setText(table.getValueAt(row, 5).toString());
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o= e.getSource();
		if(o.equals(btnThem))
			themAction();
		if(o.equals(btnXoa))
			xoaAction();
		if(o.equals(btnXoaTrang))
			xoaTrangAction();
		
	}
	
	private void xoaTrangAction() {
		txtMaNV.setText("");
		txtHo.setText("");
		txtTen.setText("");
		txtTuoi.setText("");
		txtTim.setText("");
		txtTienLuong.setText("");
		radNu.setSelected(false);
		txtMaNV.requestFocus();		
	}
	
	private void themAction() {
		try {
			int maNV = Integer.parseInt(txtMaNV.getText());
		    String ho = txtHo.getText();
			String ten = txtTen.getText();
			boolean phai = (radNu.isSelected()) ? true: false;
			int tuoi = Integer.parseInt(txtTuoi.getText());
			NhanVien nv = new NhanVien(maNV, ho, ten, phai, tuoi,tienLuong);
			
			if(dao.themNhanVien(nv)) {
				String []row= {Integer.toString(maNV),ho,ten,Boolean.toString(phai),Integer.toString(tuoi),tienLuong+""
			};
				tableModel.addRow(row);
				xoaTrangAction();
		}else {
			JOptionPane.showMessageDialog(null, "Trùng mã nhân viên");
			txtMaNV.selectAll();
			txtMaNV.requestFocus();
		}
			
			
		}	catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Lỗi nhập liệu");
			return;
		}
	}
	private void xoaAction() {
		int row = table.getSelectedRow();
		if(row !=1) {
			int maNV = Integer.parseInt((String)table.getModel().getValueAt(row, 0));
			int hoiNhac = JOptionPane.showConfirmDialog(this,"Chắc chắn xóa không?","Chú ý",JOptionPane.YES_NO_CANCEL_OPTION);
			if(hoiNhac == JOptionPane.YES_OPTION)
				if(dao.xoaNhanVien(maNV))
        			tableModel.removeRow(row);
		}			
	}
}
