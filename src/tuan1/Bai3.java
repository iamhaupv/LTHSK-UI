package tuan1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Bai3 extends JFrame implements ActionListener{
	private JPanel pNorth;
	private JLabel lblTitle;
	private JPanel pWest;
	private JButton btnGiai;
	private JButton btnXoa;
	private JButton btnThoat;
	private JPanel pCenter;
	private JPanel pNhapA;
	private JLabel lblNhapA;
	private JTextField txtA;
	private JPanel pNhapB;
	private JLabel lblNhapB;
	private JTextField txtB;
	private JPanel pPhepToan;
	private JRadioButton rdbCong;
	private JRadioButton rdbTru;
	private JRadioButton rdbNhan;
	private JRadioButton rdbChia;
	private JPanel jKetQua;
	private JLabel lblKetQua;
	private JTextField txtKetQua;
	private JPanel pSouth;
	private JPanel j1;
	private JPanel j2;
	private JPanel j3;
	public Bai3() {
		setTitle("Cộng - Trừ - Nhân - Chia");
		setSize(500, 400);
		setLocationRelativeTo(null);
		setResizable(false);
		
		// phần này là north
		pNorth = new JPanel();
		Font f = new Font("Times new roman", Font.BOLD, 30);
		pNorth.add(lblTitle = new JLabel("Cộng Trừ Nhân Chia"));
		lblTitle.setFont(f);
		add(pNorth, BorderLayout.NORTH);
		
		// phần này là west
		pWest = new JPanel();
		pWest.setBorder(BorderFactory.createTitledBorder("Chọn tác vụ"));
		Box west = Box.createVerticalBox();
		west.add(btnGiai = new JButton("Giải"));
		west.add(Box.createVerticalStrut(10));
		west.add(btnXoa = new JButton("Xóa"));
		west.add(Box.createVerticalStrut(10));
		west.add(btnThoat = new JButton("Thoát"));
		pWest.add(west);
		pWest.setBackground(Color.gray);
		add(pWest, BorderLayout.WEST);
		
		// phần này là center
		
		pCenter = new JPanel();
		pCenter.setBorder(BorderFactory.createTitledBorder("Tính toán"));
		
		// jp nhập a
		pNhapA = new JPanel();
		pNhapA.add(lblNhapA = new JLabel("Nhập a:"));
		pNhapA.add(txtA = new JTextField(30));
		// jp nhập b
		pNhapB = new JPanel();
		pNhapB.add(lblNhapB = new JLabel("Nhập b:"));
		pNhapB.add(txtB = new JTextField(30));
		
		// phép toán 
		
		pPhepToan = new JPanel();
		pPhepToan.setBorder(BorderFactory.createTitledBorder("Phép toán"));
		pPhepToan.add(rdbCong = new JRadioButton("Cộng"));
		pPhepToan.add(rdbTru = new JRadioButton("Trừ"));
		pPhepToan.add(rdbNhan = new JRadioButton("Nhân"));
		pPhepToan.add(rdbChia = new JRadioButton("Chia"));
		pPhepToan.setLayout(new GridLayout(2, 2));
		pCenter.add(pNhapA);
		pCenter.add(pNhapB);
		pCenter.add(pPhepToan);
		ButtonGroup group = new ButtonGroup();
		group.add(rdbCong);
		group.add(rdbTru);
		group.add(rdbNhan);
		group.add(rdbChia);
		
		// phần này là kết quả
		jKetQua = new JPanel();
		jKetQua.add(lblKetQua = new JLabel("Kết quả: "));
		jKetQua.add(txtKetQua = new JTextField(30));
		txtKetQua.setEnabled(false);
		
		
		pCenter.add(jKetQua);
		
		add(pCenter, BorderLayout.CENTER);
		
		
		// phần này là south
		
		pSouth = new JPanel();
		pSouth.add(j1 = new JPanel());
		j1.setBackground(Color.BLUE);
		pSouth.add(j2 = new JPanel());
		j2.setBackground(Color.red);
		pSouth.add(j3 = new JPanel());
		j3.setBackground(Color.yellow);
		pSouth.setBackground(Color.pink);
		add(pSouth, BorderLayout.SOUTH);
		
		btnGiai.addActionListener(this);
		btnXoa.addActionListener(this);
		btnThoat.addActionListener(this);
		
	}
	public static void main(String[] args) {
		new Bai3().setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
//		String s1, s2;
//		float a = 0, b = 0;
//		s1 = txtA.getText();
//		s2 = txtB.getText();
//		if(s1.equals("")) {
//			JOptionPane.showMessageDialog(this, "Nhập a");
//			txtA.requestFocus();
//		}
//		else {
//			if(s2.equals("")) {
//				JOptionPane.showMessageDialog(this, "Nhập b");
//				txtB.requestFocus();
//			}
//			// kiểm tra kiểu dữ liệu nhập vào
//			else {
//				try {
//					a = Float.parseFloat(txtA.getText());
//				} catch (Exception e2) {
//					JOptionPane.showMessageDialog(this, "Nhập sai định dạng");
//					txtA.selectAll();
//					txtA.requestFocus();
//				}
//				try {
//					b = Float.parseFloat(txtB.getText());
//				} catch (Exception e2) {
//					JOptionPane.showMessageDialog(this, "Nhập sai định dạng");
//					txtB.selectAll();
//					txtB.requestFocus();
//				}
//				Object o = e.getSource();
//				if(o.equals(btnGiai)) {
//					if(rdbCong.isSelected()) {
//						txtKetQua.setText(Double.toString(a + b));
//					}
//					else if(rdbTru.isSelected()) {
//						txtKetQua.setText(Double.toString(a - b));
//					}
//					else if(rdbNhan.isSelected()) {
//						txtKetQua.setText(Double.toString(a * b));
//					}
//					else{
//						txtKetQua.setText(Double.toString(a / b));
//					}
//				}
//				else if(o.equals(btnXoa)) {
//					txtA.setText("");
//					txtB.setText("");
//					txtKetQua.setText("");
//					txtA.requestFocus();
//				}
//				else {
//					System.exit(0);
//				}
//			}
//		}
		String s1, s2;
		float a = 0, b = 0;
		s1 = txtA.getText();
		s2 = txtB.getText();
		if(s1.equals("")) {
			JOptionPane.showMessageDialog(this, "Nhập a");
			txtA.requestFocus();
		}
		else {
			if(s2.equals("")) {
				JOptionPane.showMessageDialog(this, "Nhập b");
				txtB.requestFocus();
			}
			else {
				try {
					a = Float.parseFloat(txtA.getText());
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(this, "Nhập sai kiểu dữ liệu");
					txtA.selectAll();
					txtA.requestFocus();
				}
				try {
					b = Float.parseFloat(txtB.getText());
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(this, "Nhập sai kiểu dữ liệu");
					txtB.selectAll();
					txtB.requestFocus();
				}
				Object o = e.getSource();
				if(o.equals(btnGiai)) {
					if(rdbCong.isSelected()) {
						txtKetQua.setText(Double.toString(a + b));
					}
				}
			}
		}
	}
}
