import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Sua extends JFrame{
	private JLabel lbSbd, lbTen, lbGender, lbChonth, lbToan, lbVan, lbAnh, lbTohop;
	private JTextField txtSbd, txtTen, txtToan, txtVan, txtAnh, txtTohop;
	private JComboBox cbogender, cbotohop;
//	List<Diem> DiemList = new ArrayList<Diem>();
	public Sua() {
		setSize(500,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Sửa thông tin điểm");
		
		JPanel pnlNorth;
		add(pnlNorth = new JPanel(), BorderLayout.NORTH);
		pnlNorth.setBorder(new EmptyBorder(5,5,5,5));
		pnlNorth.setLayout(new GridLayout(8,2));
		
		lbSbd = new JLabel("Số báo danh");
		txtSbd = new JTextField();
		
		lbTen = new JLabel("Họ và tên");
		txtTen = new JTextField();
		
		lbGender = new JLabel("Giới tính");
		cbogender = new JComboBox();
		cbogender.addItem("Nam");
		cbogender.addItem("Nữ");
		
		lbChonth = new JLabel("Chọn tổ hợp");
		cbotohop = new JComboBox();
		cbotohop.addItem("KHTN");
		cbotohop.addItem("KHXH");
		
		lbToan = new JLabel("Điểm Toán");
		txtToan = new JTextField();
		
		lbVan = new JLabel("Điểm Ngữ Văn");
		txtVan = new JTextField();
		
		lbAnh = new JLabel("Điểm Tiếng Anh");
		txtAnh = new JTextField();
		
		lbTohop = new JLabel("Điểm Tổ Hợp");
		txtTohop = new JTextField();
		
		pnlNorth.add(lbSbd);
		pnlNorth.add(txtSbd);
		pnlNorth.add(lbTen);
		pnlNorth.add(txtTen);
		pnlNorth.add(lbGender);
		pnlNorth.add(cbogender);
		pnlNorth.add(lbChonth);
		pnlNorth.add(cbotohop);
		pnlNorth.add(lbToan);
		pnlNorth.add(txtToan);
		pnlNorth.add(lbVan);
		pnlNorth.add(txtVan);
		pnlNorth.add(lbAnh);
		pnlNorth.add(txtAnh);
		pnlNorth.add(lbTohop);
		pnlNorth.add(txtTohop);
		
		
		JPanel pnlSouth;
		add(pnlSouth = new JPanel(), BorderLayout.SOUTH);
		pnlSouth.setBorder(new EmptyBorder(5,5,5,5));
		JButton btnLuu = new JButton("Lưu");
		JButton btnBack = new JButton("Back");
		pnlSouth.add(btnLuu);
		pnlSouth.add(btnBack);
		
		
		btnLuu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int sbd  =Integer.parseInt(txtSbd.getText());
				String ten = txtTen.getText();
				String gender = cbogender.getSelectedItem().toString();
				String chonTh = cbotohop.getSelectedItem().toString();
				float toan = Float.parseFloat(txtToan.getText());
				float van = Float.parseFloat(txtVan.getText());
				float anh = Float.parseFloat(txtAnh.getText());
				float tohop = Float.parseFloat(txtTohop.getText());
				
				Diem Diem = new Diem(sbd, ten, gender, chonTh, toan, van, anh, tohop);
				Module.update(Diem);
				JOptionPane.showMessageDialog(Sua.this, "Sửa thành công");
				QLDIEM frame = new QLDIEM();
				frame.setVisible(true);
				dispose();
			}
		});
		btnBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				QLDIEM frame = new QLDIEM();
				frame.setVisible(true);
				dispose();
				
			}
		});
	}
	
	

	public static void main(String[] args) {
		Sua edit = new Sua();
		edit.setVisible(true);

	}

	public void setEditData(Diem p) {
		txtSbd.setText(p.getSbd()+ "");
		txtSbd.setEditable(false);
		txtTen.setText(p.getTen());
		cbogender.setSelectedItem(p.getGender());
		cbotohop.setSelectedItem(p.getChonTh());
		txtToan.setText(p.getToan()+ "");
		txtVan.setText(p.getVan()+ "");
		txtAnh.setText(p.getAnh()+ "");
		txtTohop.setText(p.getTohop()+ "");
	}

}
