package tuan2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.http.WebSocket.Listener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Bai2ThaoTacTrenJList extends JFrame implements ActionListener{
	private JPanel pNorth;
	private JPanel pWest;
	private JPanel pCen;
	private JPanel pSouth;
	private JLabel lblTitle;
	private JButton btnChan;
	private JButton btnLe;
	private JButton btnNguyeTo;
	private JButton btnBo;
	private JButton btnXoa;
	private JButton btnTong;
	private JPanel pA;
	private JButton btnNhap;
	private JTextField txt;
	private JCheckBox cb;
	private JPanel pB;
	private DefaultListModel<Integer> lstModel;
	private JList<Integer> list;
	private JButton btnDongChuongTrinh;
	public Bai2ThaoTacTrenJList() {
		setTitle("Thao tác trên Jlist - Checkbox");
		setSize(600, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		// phần khai báo
		pNorth = new JPanel();
		pWest = new JPanel();
		pCen = new JPanel();
		pSouth = new JPanel();
		
		// phần pNorth
		pNorth.add(lblTitle = new JLabel("Thao tác trên JList - Checkbox"));
		lblTitle.setFont(new Font("Times new roman", Font.BOLD, 30));
		add(pNorth, BorderLayout.NORTH);
		
		// phần pWest
		pWest.setLayout(new BoxLayout(pWest, BoxLayout.Y_AXIS));
		pWest.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.red), "Chọn tác vụ"));
		pWest.add(Box.createVerticalStrut(10));
		pWest.add(btnChan = new JButton("Tô đen số chẵn"));
		pWest.add(Box.createVerticalStrut(10));
		pWest.add(btnLe = new JButton("Tô đen số lẻ"));
		pWest.add(Box.createVerticalStrut(10));
		pWest.add(btnNguyeTo = new JButton("Tô đen số nguyên tố"));
		pWest.add(Box.createVerticalStrut(10));
		pWest.add(btnBo = new JButton("Bỏ tô đen"));
		pWest.add(Box.createVerticalStrut(10));
		pWest.add(btnXoa = new JButton("Xóa các giá trị đang tô đen"));
		pWest.add(Box.createVerticalStrut(10));
		pWest.add(btnTong = new JButton("Tổng giá trị trong JList"));
		add(pWest, BorderLayout.WEST);
		
		// phần pCen
		pCen.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.red), "Nhập thông tin"));
		pCen.setLayout(new BoxLayout(pCen, BoxLayout.Y_AXIS));
		// phần Jpain Trên
		pCen.add(pA = new JPanel());
		
		pA.setLayout(new BoxLayout(pA, BoxLayout.X_AXIS));
		pA.add(btnNhap = new JButton("Nhập"));
		pA.add(Box.createHorizontalStrut(10));
		pA.add(txt = new JTextField(15));
		pA.add(cb = new JCheckBox("Cho nhập số âm"));
		// phần Jpain Dưới
		pCen.add(Box.createVerticalStrut(10));
		pCen.add(pB = new JPanel());
		pB.setLayout(new BoxLayout(pB, BoxLayout.X_AXIS));
		lstModel = new DefaultListModel<Integer>();
		list = new JList<Integer>(lstModel);
		list.setVisibleRowCount(25);
		pB.add(new JScrollPane(list));
		pCen.add(pB);
		
		add(pCen, BorderLayout.CENTER);
		
		// phần south 
		pSouth.add(btnDongChuongTrinh = new JButton("Đóng chương trình"));
		pSouth.setBackground(Color.gray);
		add(pSouth, BorderLayout.SOUTH);
		btnChan.addActionListener(this);
		btnLe.addActionListener(this);
		btnNguyeTo.addActionListener(this);
		btnBo.addActionListener(this);
		btnXoa.addActionListener(this);
		btnTong.addActionListener(this);
		btnDongChuongTrinh.addActionListener(this);
		btnNhap.addActionListener(this);
	}
	public static void main(String[] args) {
		new Bai2ThaoTacTrenJList().setVisible(true);
	}
	public boolean ktSNT(int n) {
		if(n < 2)
			return false;
		else {
			for(int i = 2; i <= n/2; i++) {
				if(n%i == 0)
					return false;
			}
		}
		return true;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String s = txt.getText();
		Object o = e.getSource();
		if(o.equals(btnNhap)) {
			if(s.equals("")) {
				JOptionPane.showMessageDialog(this, "Bạn chưa nhập dữ liệu!");
				txt.requestFocus();
			}
			else {
				try {
					lstModel.addElement(Integer.parseInt(txt.getText()));
					txt.setText("");
					txt.requestFocus();
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(this, "Nhập sai định dạng!");
					txt.selectAll();
					txt.requestFocus();
				}
			}
		}
		else if(o.equals(btnChan)) {
			list.clearSelection();
			for(int i = 0; i < lstModel.getSize(); i++) {
				if(lstModel.getElementAt(i) % 2 == 0)
					list.addSelectionInterval(i, i);
			}
		}
		else if(o.equals(btnLe)) {
			list.clearSelection();
			for(int i = 0; i < lstModel.getSize(); i++) {
				if(lstModel.getElementAt(i) % 2 != 0)
					list.addSelectionInterval(i, i);
			}
		}
		else if(o.equals(btnNguyeTo)) {
			list.clearSelection();
			for(int i = 0; i < lstModel.getSize(); i++) {
				if(ktSNT(lstModel.getElementAt(i))==true) {
					list.addSelectionInterval(i, i);
				}
			}
		}
		else if(o.equals(btnTong)) {
			int tong = 0;
			for(int i = 0; i < lstModel.getSize(); i++) {
				tong += i;
			}
			JOptionPane.showMessageDialog(this, "Tong la: " + tong);
		}
		else {
			System.exit(0);
		}
	}
}
