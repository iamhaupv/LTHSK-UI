package tuan1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Bai1 extends JFrame implements ActionListener{
	private JPanel pNorth;
	private JLabel lblTitle;
	private JPanel pCenter;
	private JLabel lblNhapA;
	private JLabel lblNhapB;
	private JLabel lblNhapC;
	private JLabel lblKetQua;
	private JTextField txtA;
	private JTextField txtB;
	private JTextField txtC;
	private JTextField txtKetQua;
	private JPanel pSouth;
	private JButton btnGiai;
	private JButton btnXoa;
	private JButton btnThoat;
	public Bai1() {
		setTitle("Giải phương trình bậc hai");
//		setLocationRelativeTo(null);
		setSize(500, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		pNorth = new JPanel();
		Font f = new Font("Times new Roman", Font.BOLD, 20);
		pNorth.add(lblTitle = new JLabel("GIẢI PHƯƠNG TRÌNH BẬC HAI"));
		lblTitle.setFont(f);
		pNorth.setBackground(Color.blue);
		add(pNorth, BorderLayout.NORTH);
		
		int x = 30, y = 50, width = 50, height = 30;
		pCenter = new JPanel();
		pCenter.add(lblNhapA = new JLabel("Nhập a:"));
		lblNhapA.setBounds(x, y, width, height);
		y+= 50;
		
		pCenter.add(lblNhapB = new JLabel("Nhập b:"));
		lblNhapB.setBounds(x, y, width, height);
		y+=50;
		
		pCenter.add(lblNhapC = new JLabel("Nhập c:"));
		lblNhapC.setBounds(x, y, width, height);
		y+=50;
		
		pCenter.add(lblKetQua = new JLabel("Kết quả:"));
		lblKetQua.setBounds(x, y, width, height);
		y+=50;
		
		y = 50; x += 100; width = 300; height = 30;
		pCenter.add(txtA = new JTextField());
		txtA.setBounds(x, y, width, height);
		y+=50;
		
		pCenter.add(txtB = new JTextField());
		txtB.setBounds(x, y, width, height);
		y+=50;
		
		pCenter.add(txtC = new JTextField());
		txtC.setBounds(x, y, width, height);
		y+=50;
		
		pCenter.add(txtKetQua = new JTextField());
		txtKetQua.setBounds(x, y, width, height);
		y+=50;
		
		txtKetQua.setEnabled(false);
		add(pCenter, BorderLayout.CENTER);
		pCenter.setLayout(null);
		
		pSouth = new JPanel();
		pSouth.add(btnGiai = new JButton("Giải"));
		pSouth.add(btnXoa = new JButton("Xóa rỗng"));
		pSouth.add(btnThoat = new JButton("Thoát"));
		pSouth.setBorder(BorderFactory.createTitledBorder("Chọn tác vụ"));
		add(pSouth, BorderLayout.SOUTH);
		btnGiai.addActionListener(this);
		btnXoa.addActionListener(this);
		btnThoat.addActionListener(this);
	}
	public static void main(String[] args) {
		new Bai1().setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		int a = 0, b = 0, c = 0, result = 0;
		String s1 = txtA.getText();
		String s2 = txtB.getText();
		String s3 = txtC.getText();
		if(s1.equals("")) {
			JOptionPane.showMessageDialog(this, "Nhap a");
			txtA.requestFocus();
		}
		else if(s2.equals("")){
			JOptionPane.showMessageDialog(this, "Nhap b");
			txtB.requestFocus();
			
		}
		else if(s3.equals("")) {
			JOptionPane.showMessageDialog(this, "Nhap c");
			txtC.requestFocus();
		}
		else {
			try {
				a = Integer.parseInt(txtA.getText());
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this, "Nhập không đúng định dạng");
				txtA.selectAll();
				txtA.requestFocus();
			}
			try {
				b = Integer.parseInt(txtB.getText());
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this, "Nhập không đúng định dạng");
				txtB.selectAll();
				txtB.requestFocus();
			}
			try {
				c = Integer.parseInt(txtC.getText());
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this, "Nhập không đúng định dạng");
				txtC.selectAll();
				txtC.requestFocus();
			}
			if(o.equals(btnGiai)) {
				if(a == 0) {
					if(b == 0) {
						if(c == 0) {
							txtKetQua.setText("Phương trình vô số nghiệm");
						}
						else {
							txtKetQua.setText("Phương trinh vô nghiệm");
						}
					}
					else {
						float x = -1*c/b;
						txtKetQua.setText(Double.toString(x));
					}
				}
				else {
					double d = b * b - 4 * a * c;
					if(d > 0) {
						double x1, x2;
						x1 = (-b + Math.sqrt(d)) / (2*a);
						x2 = (-b - Math.sqrt(d)) / (2 *a);
						txtKetQua.setText("X1 = " + Double.toString(x1) + "X2 = " + Double.toString(x2));
						
					}
					else if(d == 0) {
						double x;
						x = (-1 * b)/(2 * a);
						txtKetQua.setText("X1 = X2 = " + Double.toString(x));
					}
					else {
						txtKetQua.setText("Phương trình vô nghiệm");
					}
				}
			}
			else if(o.equals(btnThoat)) {
				System.exit(0);
			}
			else {
				txtA.setText("");
				txtB.setText("");
				txtC.setText("");
			}
		}
	}
}
