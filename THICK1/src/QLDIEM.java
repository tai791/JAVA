
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


public class QLDIEM extends JFrame{
	private JLabel lbSbd, lbTen, lbGender, lbChonth, lbToan, lbVan, lbAnh, lbTohop;
	private JTextField txtSbd, txtTen, txtToan, txtVan, txtAnh, txtTohop;
	private JComboBox cbogender, cbotohop;
	private JButton btnLuu, btnReset, btnXoa, btnFind, btnSua, btnView;
	private JTable table;
	DefaultTableModel defaultTableModel;
	List<Diem> List = new ArrayList<Diem>();
	public QLDIEM()
	{
		setTitle("Quản lý điểm thi tốt nghiệp PTTH");
		setSize(900,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
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
		
		btnLuu = new JButton("Lưu");
		btnReset = new JButton("Reset");
		btnXoa = new JButton("Xóa");
		btnFind = new JButton("Tìm");
		btnSua = new JButton("Sửa");
		btnView = new JButton("Hiển thị");
		pnlSouth.add(btnLuu);
		pnlSouth.add(btnReset);
		pnlSouth.add(btnXoa);
		pnlSouth.add(btnFind);
		pnlSouth.add(btnSua);
		pnlSouth.add(btnView);
		
		Box b= Box.createVerticalBox();
		Box b1;
		b.add(b1 =Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(table = new JTable());
		b1.add(scrollPane);
		add(b, BorderLayout.CENTER);
		
		defaultTableModel = new DefaultTableModel();
		table.setModel(defaultTableModel);
		defaultTableModel.addColumn("SBD");
		defaultTableModel.addColumn("Họ và tên");
		defaultTableModel.addColumn("Giới tính");
		defaultTableModel.addColumn("Tổ hợp");
		defaultTableModel.addColumn("Điểm Toán");
		defaultTableModel.addColumn("Điểm Văn");
		defaultTableModel.addColumn("Điểm Anh");
		defaultTableModel.addColumn("Điểm Tổ Hợp");	
		
		
		showDiem();
		

		btnView.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				showDiem();
				
			}
		});
		btnReset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				txtSbd.setText("");
				txtTen.setText("");
				cbogender.setSelectedIndex(0);
				cbotohop.setSelectedIndex(0);
				txtToan.setText("");
				txtVan.setText("");
				txtAnh.setText("");
				txtTohop.setText("");
			}
		});
		btnLuu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int sbd  =Integer.parseInt(txtSbd.getText());
				String ten = txtTen.getText();
				String gender = cbogender.getSelectedItem().toString();
				String chonTh = cbotohop.getSelectedItem().toString();
				float toan = Float.parseFloat(txtToan.getText());
				float van = Float.parseFloat(txtVan.getText());
				float anh = Float.parseFloat(txtAnh.getText());
				float tohop = Float.parseFloat(txtTohop.getText());
				
				Diem Diem = new Diem(sbd, ten, gender, chonTh, toan, van, anh, tohop);
				Module.insert(Diem);
				showDiem();
				JOptionPane.showMessageDialog(QLDIEM.this, "Thêm thành công");
			}
		});
		btnXoa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = table.getSelectedRow();
				if(selectedIndex == -1)
				{
					 JOptionPane.showMessageDialog(QLDIEM.this, "Hãy chọn dòng cần xóa", "Lỗi", JOptionPane.ERROR_MESSAGE);
				}else {
					int confirm = JOptionPane.showConfirmDialog(QLDIEM.this, "Ban có chắc chắn muốn xóa không ?");
					if(confirm == JOptionPane.YES_OPTION) {
						int id = Integer.valueOf(String.valueOf(table.getValueAt(selectedIndex, 0)));
						Module.delete(id);
						
						defaultTableModel.setRowCount(0);
						showDiem();
						JOptionPane.showMessageDialog(QLDIEM.this, "Đã xóa");
					}
				}
				
			}
		});
		btnFind.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String input = JOptionPane.showInputDialog(QLDIEM.this,"Nhập tên để tìm kiếm");
				if(input != null && input.length() > 0) {
					List = Module.findByTen(input);
					
					defaultTableModel.setRowCount(0);
					
					for(Diem Diem: List) {
						defaultTableModel.addRow(new Object[] {Diem.getSbd(), Diem.getTen(), Diem.getGender(), Diem.getChonTh(),
								Diem.getToan(), Diem.getVan(), Diem.getAnh(), Diem.getTohop()});
					}
				}else {
					showDiem();
				}
				
			}
		});
		btnSua.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = table.getSelectedRow();
				if(List.size() == 0) {
					JOptionPane.showMessageDialog(rootPane, "Hãy nhập thêm thông tin");
				}else if(selectedIndex == -1) {
					JOptionPane.showMessageDialog(rootPane, "Hãy chọn dòng cần sửa");
				}
				else {
					Sua edit = new Sua();
					edit.setEditData(List.get(selectedIndex));
					edit.setVisible(true);
					dispose();
				}
	
					
					
				}
		});
	}
	private void showDiem() {
		List = Module.findAll();
		
		defaultTableModel.setRowCount(0);
		
		for(Diem Diem: List) {
			defaultTableModel.addRow(new Object[] {Diem.getSbd(), Diem.getTen(), Diem.getGender(), Diem.getChonTh(),
					Diem.getToan(), Diem.getVan(), Diem.getAnh(), Diem.getTohop()});
		}
	}

	public static void main(String[] args) {
		QLDIEM frame = new QLDIEM();
		frame.setVisible(true);

	}

}
