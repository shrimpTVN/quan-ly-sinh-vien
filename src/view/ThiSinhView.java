package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import controller.ThiSinhListener;
import model.ThiSinh;
import model.ThiSinhModel;
import model.Tinh;

import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;

public class ThiSinhView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField textFieldMaThiSinh;
	private JTextField textFieldHoVaTen;
	private JTextField textFieldNgaySinh;
	private JTextField textFieldMon1;
	private JTextField textFieldMon2;
	private JTextField textFieldMon3;
	private JComboBox comboBoxNorth;
	private JRadioButton radioButtonNam;
	private JRadioButton radioButtonNu;
	private ButtonGroup set;
	private JComboBox comboBoxSouth;
	//private ArrayList<ThiSinh> dsThiSinh;
	private ThiSinhModel thiSinhModel;
	private int index;
	private JTextField textFieldFilter;
	private JLabel labelFileName;
		
	/**
	 * Launch the application.
	 */
	
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SinhVienView frame = new SinhVienView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	public ThiSinhView() {
		thiSinhModel = new ThiSinhModel();
		this.setTitle("Chương trình quản lý thí sinh");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		//setBounds(100, 100, 850, 650);
		this.setSize(850,650);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.draw();
						
		this.setVisible(true);
	}

	public void draw()
	{
		
		//dsThiSinh= new ArrayList<ThiSinh>();
				ActionListener listener = new ThiSinhListener(this);
				
				setContentPane(contentPane);
				contentPane.setLayout(null);
				//MenuBar	
				JMenuBar menuBar = new JMenuBar();
				menuBar.setBounds(0, 0, 834, 22);
				contentPane.add(menuBar);
				
				JMenu menuFile = new JMenu("File");
				menuBar.add(menuFile);
				
				JMenuItem menuItemNew = new JMenuItem("New");
				menuFile.add(menuItemNew);
				menuItemNew.addActionListener(listener);
				
				JMenuItem menuItemOpen = new JMenuItem("Open");
				menuFile.add(menuItemOpen);
				menuItemOpen.addActionListener(listener);
				
				JMenuItem menuItemSave = new JMenuItem("Save");
				menuFile.add(menuItemSave);
				menuItemSave.addActionListener(listener);
				menuFile.setName("SaveFile");
				
				JMenuItem menuItemClose = new JMenuItem("Close");
				menuFile.add(menuItemClose);
				menuItemClose.addActionListener(listener);
				
				JMenuItem menuItemExit = new JMenuItem("Exit");
				menuFile.add(menuItemExit);
				menuItemExit.addActionListener(listener);
				
				JMenu menuAbout = new JMenu("About");
				menuBar.add(menuAbout);
				
				JMenuItem menuItemAboutMe = new JMenuItem("About Me");
				menuAbout.add(menuItemAboutMe);
				menuItemAboutMe.addActionListener(listener);
				
				JPanel panel = new JPanel();
				panel.setBounds(0, 21, 834, 590);
				contentPane.add(panel);
				panel.setLayout(new BorderLayout(0, 0));
				
				JPanel panelNorth = new JPanel();
				panelNorth.setBackground(Color.GRAY);
				panel.add(panelNorth, BorderLayout.NORTH);
				panelNorth.setLayout(new GridLayout(0, 6, 0, 0));
				
				JLabel labelTinh = new JLabel("Quê quán");
				labelTinh.setFont(new Font("Tahoma", Font.BOLD, 16));
				labelTinh.setHorizontalAlignment(SwingConstants.CENTER);
				panelNorth.add(labelTinh);
				
				 comboBoxNorth = new JComboBox();
				panelNorth.add(comboBoxNorth);
				
				ArrayList <Tinh> dsTinh= Tinh.getDSTinh();
				comboBoxNorth.addItem("");
				for (int i=0; i<dsTinh.size(); i++)
				{
					comboBoxNorth.addItem(dsTinh.get(i).getTenTinh());
				}
				
				
				
				
				JLabel labelMSSV = new JLabel("Mã thí sinh");
				labelMSSV.setFont(new Font("Tahoma", Font.BOLD, 16));
				labelMSSV.setHorizontalAlignment(SwingConstants.CENTER);
				panelNorth.add(labelMSSV);
				
				textFieldFilter = new JTextField();
				panelNorth.add(textFieldFilter);
				textFieldFilter.setColumns(10);
				
				JButton buttonFilter = new JButton("Filter");
				panelNorth.add(buttonFilter);
				buttonFilter.addActionListener(listener);
				
				JButton buttonCancleFilter = new JButton("Cancle");
				panelNorth.add(buttonCancleFilter);
				buttonCancleFilter.setName("CancleButton1");
				buttonCancleFilter.addActionListener(listener);
				
				
				JPanel panelSouth = new JPanel();
				panel.add(panelSouth, BorderLayout.SOUTH);
				
				JButton buttonThem = new JButton("Add");
				buttonThem.setFont(new Font("Tahoma", Font.BOLD, 16));
				panelSouth.add(buttonThem);
				buttonThem.addActionListener(listener);
				
				JButton buttonXoa = new JButton("Delete");
				buttonXoa.setFont(new Font("Tahoma", Font.BOLD, 16));
				panelSouth.add(buttonXoa);
				buttonXoa.addActionListener(listener);
				
				JButton buttonCapNhat = new JButton("Update");
				buttonCapNhat.setFont(new Font("Tahoma", Font.BOLD, 16));
				panelSouth.add(buttonCapNhat);
				buttonCapNhat.addActionListener(listener);
				
				JButton buttonLuu = new JButton("Save");
				buttonLuu.setFont(new Font("Tahoma", Font.BOLD, 16));
				panelSouth.add(buttonLuu);
				buttonLuu.addActionListener(listener);
				buttonLuu.setName("SaveThiSinh");
				
				JButton buttonHuyBo = new JButton("Cancle");
				buttonHuyBo.setName("CancleButton2");
				buttonHuyBo.setFont(new Font("Tahoma", Font.BOLD, 16));
				panelSouth.add(buttonHuyBo);
				buttonHuyBo.addActionListener(listener);
				
				JPanel panelCenter = new JPanel();
				panel.add(panelCenter, BorderLayout.CENTER);
				
				//JGroup set = new JGroup();
					set = new ButtonGroup();
					panelCenter.setLayout(null);
					
					JPanel panelThongTin = new JPanel();
					panelThongTin.setBounds(0, 264, 834, 264);
					panelCenter.add(panelThongTin);
					panelThongTin.setLayout(null);
					
					JLabel lblNewLabel = new JLabel("Thông tin thi sinh");
					lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
					lblNewLabel.setBounds(0, 11, 261, 25);
					panelThongTin.add(lblNewLabel);
					
					JLabel lblNewLabel_1 = new JLabel("Mã thí sinh");
					lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
					lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
					lblNewLabel_1.setBounds(40, 47, 132, 36);
					panelThongTin.add(lblNewLabel_1);
					
					JLabel lblNewLabel_1_1 = new JLabel("Họ và tên");
					lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
					lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
					lblNewLabel_1_1.setBounds(40, 98, 132, 36);
					panelThongTin.add(lblNewLabel_1_1);
					
					JLabel lblNewLabel_1_2 = new JLabel("Quê quán");
					lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
					lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
					lblNewLabel_1_2.setBounds(40, 149, 132, 36);
					panelThongTin.add(lblNewLabel_1_2);
					
					JLabel lblNewLabel_1_3 = new JLabel("Ngày sinh");
					lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 16));
					lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
					lblNewLabel_1_3.setBounds(40, 196, 132, 36);
					panelThongTin.add(lblNewLabel_1_3);
					
					
					JLabel lblNewLabel_1_5 = new JLabel("Môn 1");
					lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 14));
					lblNewLabel_1_5.setBounds(458, 98, 132, 36);
					panelThongTin.add(lblNewLabel_1_5);
					
					JLabel lblNewLabel_1_5_2 = new JLabel("Môn 3");
					lblNewLabel_1_5_2.setFont(new Font("Tahoma", Font.BOLD, 14));
					lblNewLabel_1_5_2.setBounds(458, 196, 132, 36);
					panelThongTin.add(lblNewLabel_1_5_2);
					
					JLabel lblNewLabel_1_5_1 = new JLabel("Môn 2");
					lblNewLabel_1_5_1.setFont(new Font("Tahoma", Font.BOLD, 14));
					lblNewLabel_1_5_1.setBounds(458, 149, 132, 36);
					panelThongTin.add(lblNewLabel_1_5_1);
					
						// Giới tính
						JLabel lblNewLabel_1_4 = new JLabel("Giới tính");
						lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 16));
						lblNewLabel_1_4.setBounds(448, 47, 132, 36);
						panelThongTin.add(lblNewLabel_1_4);
				//Điền thông tin		
						 radioButtonNam = new JRadioButton("Nam");
						radioButtonNam.setFont(new Font("Tahoma", Font.PLAIN, 13));
						radioButtonNam.setBounds(594, 54, 94, 23);
						panelThongTin.add(radioButtonNam);
						
						 radioButtonNu = new JRadioButton("Nữ");
						radioButtonNu.setFont(new Font("Tahoma", Font.PLAIN, 13));
						radioButtonNu.setBounds(723, 54, 94, 23);
						panelThongTin.add(radioButtonNu);
						set.add(radioButtonNam);
						set.add(radioButtonNu);
						
						 comboBoxSouth = new JComboBox();
						comboBoxSouth.setBounds(207, 149, 183, 36);
						panelThongTin.add(comboBoxSouth);
						
						comboBoxSouth.addItem("");
						for (int i=0; i<dsTinh.size(); i++)
						{
							comboBoxSouth.addItem(dsTinh.get(i).getTenTinh());
						}
						
						
						
						textFieldMaThiSinh = new JTextField();
						textFieldMaThiSinh.setBounds(205, 47, 185, 36);
						panelThongTin.add(textFieldMaThiSinh);
						textFieldMaThiSinh.setColumns(10);
						
						textFieldHoVaTen = new JTextField();
						textFieldHoVaTen.setColumns(10);
						textFieldHoVaTen.setBounds(205, 98, 185, 36);
						panelThongTin.add(textFieldHoVaTen);
						
						textFieldNgaySinh = new JTextField();
						textFieldNgaySinh.setColumns(10);
						textFieldNgaySinh.setBounds(205, 196, 185, 36);
						panelThongTin.add(textFieldNgaySinh);
						
						textFieldMon1 = new JTextField();
						textFieldMon1.setColumns(10);
						textFieldMon1.setBounds(551, 106, 146, 25);
						panelThongTin.add(textFieldMon1);
						
						textFieldMon2 = new JTextField();
						textFieldMon2.setColumns(10);
						textFieldMon2.setBounds(551, 159, 146, 25);
						panelThongTin.add(textFieldMon2);
						
						textFieldMon3 = new JTextField();
						textFieldMon3.setColumns(10);
						textFieldMon3.setBounds(551, 206, 146, 25);
						panelThongTin.add(textFieldMon3);
						
						labelFileName = new JLabel("Tên File");
						labelFileName.setBounds(458, 243, 376, 21);
						panelThongTin.add(labelFileName);
				
					//Tạo bảng
						//muốn table hiện được tiêu đề cột thì phải sử dụng scrollpane và add table vào
						table = new JTable();
						table.setFont(new Font("Tahoma", Font.PLAIN, 16));
						table.setModel(new DefaultTableModel(
							new Object[][] {
							},
							new String[] {
								"Ma thi sinh", "Ho va ten", "Que quan", "Ngay sinh", "Gioi tinh", "Diem 1", "Diem 2", "Diem 3"
							}
						));
						table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 16));
						JScrollPane scrollPane = new JScrollPane(table);
						scrollPane.setBounds(0, 14, 834, 249);
						
					
						
						panelCenter.add(scrollPane);
						
						JSeparator separator = new JSeparator();
						separator.setBounds(0, 11, 834, 2);
						panelCenter.add(separator);
						
	}
	
	
	public void clearData() {
		textFieldMaThiSinh.setText("");
		textFieldHoVaTen.setText("");
		comboBoxSouth.setSelectedIndex(-1);
		textFieldNgaySinh.setText("");
		set.clearSelection();

		textFieldMon1.setText("");
		textFieldMon2.setText("");
		textFieldMon3.setText("");
	}
	
	public ThiSinh getData()
	{
		boolean check=false;
		while (!check)
		{
			String maThiSinh=textFieldMaThiSinh.getText();
			String hoVaTen=textFieldHoVaTen.getText();
			
			String tenQue=comboBoxSouth.getSelectedItem()+"";
			int indexQue=comboBoxSouth.getSelectedIndex();
			
			Tinh que= new Tinh(tenQue, indexQue);
			
			Date ngaySinh;
			try {
				ngaySinh = new SimpleDateFormat("dd/MM/yyyy").parse(textFieldNgaySinh.getText());
				
				String gioiTinh="";	
				if (radioButtonNam.isSelected())
						gioiTinh="Nam";
				else
						gioiTinh="Nữ";
			
				boolean sex=gioiTinh.equals("Nam");
				
				float mon1=Float.valueOf(textFieldMon1.getText());
				float mon2=Float.valueOf(textFieldMon2.getText());
				float mon3=Float.valueOf(textFieldMon3.getText());
				
				ThiSinh ts= new ThiSinh(maThiSinh, hoVaTen, que, ngaySinh, sex, mon1, mon2, mon3);
				
				//Việc lấy thông tin không xảy ra lỗi
				check=true;
				return ts;
			}
			catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	return new ThiSinh();
	}
	
	public void addThiSinh(ThiSinh ts)
	{

		DefaultTableModel modelTable = (DefaultTableModel) table.getModel();
		modelTable.addRow(new Object[]{ 
							 ts.getMaThiSinh()
							, ts.getHoVaTen()
							, ts.getQueQuan().getTenTinh()
							, ts.getNgaySinh().getDate() +"/" + (ts.getNgaySinh().getMonth()+1) +"/" + (ts.getNgaySinh().getYear()+1900)
							, (ts.isGioiTinh()?"Nam":"Nữ")
							, ts.getDiem1()+""
							, ts.getDiem2()+""
							, ts.getDiem3()+""
							});
	}
	
	public void printData(ThiSinh ts)
	{
		table.setValueAt(ts.getMaThiSinh(),index,0);
		table.setValueAt(ts.getHoVaTen(),index,1);
		table.setValueAt(ts.getQueQuan().getTenTinh(),index,2);
		table.setValueAt(ts.getNgaySinh().getDate() +"/" + (ts.getNgaySinh().getMonth()+1) +"/" + (ts.getNgaySinh().getYear()+1900), index, 3);
		table.setValueAt((ts.isGioiTinh()?"Nam":"Nữ"),index,4);
		table.setValueAt(ts.getDiem1(),index,5);
		table.setValueAt(ts.getDiem2(),index,6);
		table.setValueAt(ts.getDiem3(),index,7);
	}
	
	public void pushData() {
	
		
			ThiSinh ts=this.getData();
			
			int indexTS= thiSinhModel.check(ts.getMaThiSinh());
			
			if (thiSinhModel.getUpdateButton()==false )
			{
					if (indexTS>=0)
						JOptionPane.showMessageDialog(this, "Mã thí sinh đã tồn tại", "Lỗi thêm thí sinh", JOptionPane.ERROR_MESSAGE, null);
					else
					{
						thiSinhModel.add(ts);
						this.addThiSinh(ts);
					}
			}
			else
			{
				//table.setValueAt(maThiSinh,index,1);
				textFieldMaThiSinh.setText(table.getValueAt(index,0)+"");
				ts.setMaThiSinh(table.getValueAt(index,0)+"");
				indexTS=thiSinhModel.check(table.getValueAt(index,0)+"");
				thiSinhModel.update(ts, indexTS);
				this.printData(ts);
				thiSinhModel.setUpdateButton(false);
				
			}
		
		
	//	System.out.println(thiSinhModel.getDsThiSinh().size());
	
	}

	public void updateData() {
	
		DefaultTableModel modelTable = (DefaultTableModel) table.getModel();
		 index= table.getSelectedRow();
		
		textFieldMaThiSinh.setText(table.getValueAt(index, 0) +"");
		textFieldHoVaTen.setText(table.getValueAt(index, 1) +"");
		//Quê
		comboBoxSouth.setSelectedItem(table.getValueAt(index,2));
		textFieldNgaySinh.setText(table.getValueAt(index, 3) +"");
		
		String gioiTinh= table.getValueAt(index, 4) +"";
		
		if (gioiTinh.equals("Nam"))
		{
			radioButtonNam.setSelected(true);
		}
		else
		if (gioiTinh.equals("Nữ"))
		{
			radioButtonNu.setSelected(true);
		}
		
		textFieldMon1.setText(table.getValueAt(index, 5) +"");
		textFieldMon2.setText(table.getValueAt(index, 6) +"");
		textFieldMon3.setText(table.getValueAt(index, 7) +"");
		
	}
	
	public void setUpdateButton(boolean check)
	{
		this.thiSinhModel.setUpdateButton(check);
	}

	public void deleteData() 
	{
		this.updateData();
		int check=JOptionPane.showConfirmDialog(this, "Bạn muốn xóa thí sinh?", "Xóa thí sinh", JOptionPane.YES_NO_OPTION);
		
		if (check==JOptionPane.YES_OPTION)
		{
			DefaultTableModel modelTable = (DefaultTableModel) table.getModel();
			index= table.getSelectedRow();
			int indexTS= thiSinhModel.check(table.getValueAt(index,0)+"");
			thiSinhModel.delete(indexTS);
			modelTable.removeRow(index);
			this.clearData();
		}
		
	}
	public void clearTable()
	{
		DefaultTableModel modelTable = (DefaultTableModel) table.getModel();
		int tableSize=modelTable.getRowCount();
		
		while (tableSize-1>=0)
		{
			modelTable.removeRow(tableSize-1);
			tableSize--;
		}
	}
	public void timKiem() {
	
		//removeAll();
		
		String tenTinh= comboBoxNorth.getSelectedItem()+"";
		String maThiSinh= textFieldFilter.getText();
	//	System.out.println(tenTinh+"-----"+maThiSinh);
		this.clearTable();
		ArrayList<ThiSinh> dsThiSinh= thiSinhModel.getDsThiSinh();
		for (int i=0; i<dsThiSinh.size(); i++)
		{
			if ( (dsThiSinh.get(i).getQueQuan().getTenTinh().equals(tenTinh) || tenTinh.length()==0 )&&
				  (dsThiSinh.get(i).getMaThiSinh().contains(maThiSinh) || maThiSinh.length()==0) )
			{
				this.addThiSinh(dsThiSinh.get(i));
			}
		}
	}

	public void printAllData() {
	
		this.clearTable();
		ArrayList<ThiSinh> dsThiSinh= thiSinhModel.getDsThiSinh();
		//System.out.println(dsThiSinh.size());
		for (int i=0; i<dsThiSinh.size(); i++)
		{
			this.addThiSinh(dsThiSinh.get(i));
		}
	}

	public void showAboutMe() {
		//JOptionPane.showMessageDialog(this,"Chương trình quản lí thí sinh do Văn Tôm viết","About Me", JOptionPane.INFORMATION_MESSAGE);
		new AboutMeView();
	}

	public void thucHienExit() {
		
		int choose= JOptionPane.showConfirmDialog(this, "Hãy chắc chắn bạn đã lưu chương trình của mình!","Do you want to exit program?!" , JOptionPane.YES_NO_OPTION);
		if (choose==JOptionPane.YES_OPTION)
		{
			System.exit(0);
		}
	}
	
	public void writeToFile(File file) 
	{
		ArrayList<ThiSinh> dsThiSinh= thiSinhModel.getDsThiSinh();

		try {
			FileOutputStream fos= new FileOutputStream(file);
			ObjectOutputStream oos= new ObjectOutputStream(fos);

			for (int i=0; i<dsThiSinh.size(); i++)
			{
				oos.writeObject(dsThiSinh.get(i));
			}
			oos.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void saveFile(){
		
		String path= thiSinhModel.getFileName();
		JFileChooser fc= new JFileChooser();
		if (path!="")
		{
			File file= new File(path);
			this.writeToFile(file);
		}
		else
		{
			int returnVal= fc.showSaveDialog(this);
			
			if (returnVal== JFileChooser.APPROVE_OPTION)
			{
			//	File file=fc.getSelectedFile();
				path=fc.getSelectedFile()+"";
				this.writeToFile(new File(path));
			}
		}
		
		thiSinhModel.setFileName(path);
		labelFileName.setText("Tên File: "+path);
		
	}
	
	public void openFile()
	{
		if ( thiSinhModel.getFileName().length()>0)
		{
			new ThiSinhView();
			return;
		}
		JFileChooser fc= new JFileChooser();
		String path= new String();
		int returnVal= fc.showOpenDialog(this);
		
		if (returnVal==JFileChooser.APPROVE_OPTION)
		{
			File file = new File(fc.getSelectedFile().toString());
			path= file.toString();
			ArrayList<ThiSinh> dsThiSinh= new ArrayList<ThiSinh>();
				
				try {
					FileInputStream fis= new FileInputStream(file);
					ObjectInputStream ois= new ObjectInputStream(fis);
					ThiSinh ts=null;
					
					while ( (ts=(ThiSinh)ois.readObject()) != null)
					{
						dsThiSinh.add(ts);
					}
					ois.close();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				} 
			thiSinhModel.setDsThiSinh(dsThiSinh);
			
			for (int i=0; i<dsThiSinh.size(); i++)
				this.addThiSinh(dsThiSinh.get(i));
		}
		thiSinhModel.setFileName(path);
		labelFileName.setText("Tên File: "+path);
	}

	public void closeFile() {
		int choose = JOptionPane.showConfirmDialog(this,"Bạn có muốn lưu file","Close File!", JOptionPane.YES_NO_OPTION);
		
		if (choose== JOptionPane.YES_OPTION)
			this.saveFile();
		this.clearData();
		labelFileName.setText("Tên File: ");
		thiSinhModel.setDsThiSinh(new ArrayList<ThiSinh>());
		thiSinhModel.setFileName("");
		this.clearTable();
		
	}

	public void newFile() {
		if ( thiSinhModel.getFileName().length()>0)
			new ThiSinhView();		
	}
}
