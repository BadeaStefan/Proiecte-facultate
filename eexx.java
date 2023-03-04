package ex;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.beans.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.jdbc.DatabaseMetaData;

import javax.swing.JToolBar;
import java.awt.Color;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class eexx extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	public int z;

	public void SetRezolv(int x)
	{
		this.z=x;
	}
	public int GetRezolv()
	{
		return z;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					eexx frame = new eexx();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public eexx() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 639, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);


		Icon icon =new ImageIcon("C:\\Users\\stefi\\eclipse-workspace\\JDBC_Maven\\src\\main\\java\\MoveFirst.png");
		Icon icon1 =new ImageIcon("C:\\Users\\stefi\\eclipse-workspace\\JDBC_Maven\\src\\main\\java\\MovePrevious.png");
		Icon icon2 =new ImageIcon("C:\\Users\\stefi\\eclipse-workspace\\JDBC_Maven\\src\\main\\java\\MoveNext.png");
		Icon icon3 =new ImageIcon("C:\\Users\\stefi\\eclipse-workspace\\JDBC_Maven\\src\\main\\java\\MoveLast.png");
		Icon icon4 =new ImageIcon("C:\\Users\\stefi\\eclipse-workspace\\JDBC_Maven\\src\\main\\java\\Add.png");
		Icon icon5 =new ImageIcon("C:\\Users\\stefi\\eclipse-workspace\\JDBC_Maven\\src\\main\\java\\Edit.png");
		Icon icon6 =new ImageIcon("C:\\Users\\stefi\\eclipse-workspace\\JDBC_Maven\\src\\main\\java\\Delete.png");
		Icon icon7 =new ImageIcon("C:\\Users\\stefi\\eclipse-workspace\\JDBC_Maven\\src\\main\\java\\find.png");
		Icon icon8 =new ImageIcon("C:\\Users\\stefi\\eclipse-workspace\\JDBC_Maven\\src\\main\\java\\save.png");
		Icon icon9 =new ImageIcon("C:\\Users\\stefi\\eclipse-workspace\\JDBC_Maven\\src\\main\\java\\undo.png");

		JToolBar toolBar = new JToolBar();
		toolBar.setForeground(new Color(255, 255, 255));
		toolBar.setBounds(10, 11, 454, 47);
		contentPane.add(toolBar);

		JButton btnNewButton = new JButton(icon);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String url = "jdbc:mysql://localhost:3306/test";
				String sql="select * from persoane";
				try
				{
					Connection connection= DriverManager.getConnection(url, "root", "root");
					java.sql.Statement statement = connection.createStatement();
					ResultSet rs=statement.executeQuery(sql);
					rs.first();

					int id=rs.getInt(1);
					String nume=rs.getString(2);
					int varsta=rs.getInt(3);
					textField_1.setText(""+ id);
					textField_2.setText(nume);
					textField_3.setText(""+varsta);
					int a=rs.getRow();
					SetRezolv(a);

					connection.close();
					statement.close();
					rs.close();
				}catch (SQLException e2) {
					System.out.println(sql);
					e2.printStackTrace();
				}

			}
		});
		toolBar.add(btnNewButton);

		JButton btnNewButton_1 = new JButton(icon1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String url = "jdbc:mysql://localhost:3306/test";
				String sql="select * from persoane";

				try
				{
					Connection connection= DriverManager.getConnection(url, "root", "root");
					java.sql.Statement statement = connection.createStatement();
					ResultSet rs=statement.executeQuery(sql);
					int a=GetRezolv();
					rs.absolute(a-1);
					SetRezolv(a-1);

					int id=rs.getInt(1);
					String nume=rs.getString(2);
					int varsta=rs.getInt(3);
					textField_1.setText(""+ id);
					textField_2.setText(nume);
					textField_3.setText(""+varsta);

					connection.close();
					statement.close();
					rs.close();

				}catch (SQLException e2) {
					System.out.println(sql);
					e2.printStackTrace();
				}

			}
		});
		toolBar.add(btnNewButton_1);

		textField = new JTextField();
		toolBar.add(textField);
		textField.setColumns(10);
		trece();
		
		JButton btnNewButton_2 = new JButton(icon2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String url = "jdbc:mysql://localhost:3306/test";
				String sql="select * from persoane";

				try
				{
					Connection connection= DriverManager.getConnection(url, "root", "root");
					java.sql.Statement statement = connection.createStatement();
					ResultSet rs=statement.executeQuery(sql);

					int a=GetRezolv();
					rs.absolute(a+1);
					SetRezolv(a+1);
					int id=rs.getInt(1);
					String nume=rs.getString(2);
					int varsta=rs.getInt(3);
					textField_1.setText(""+ id);
					textField_2.setText(nume);
					textField_3.setText(""+varsta);


					connection.close();
					statement.close();
					rs.close();

				}catch (SQLException e2) {
					System.out.println(sql);
					e2.printStackTrace();
				}



			}
		});
		toolBar.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton(icon3);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String url = "jdbc:mysql://localhost:3306/test";
				String sql="select * from persoane";

				try
				{
					Connection connection= DriverManager.getConnection(url, "root", "root");
					java.sql.Statement statement = connection.createStatement();
					ResultSet rs=statement.executeQuery(sql);
					rs.last();

					int id=rs.getInt(1);
					String nume=rs.getString(2);
					int varsta=rs.getInt(3);
					textField_1.setText(""+ id);
					textField_2.setText(nume);
					textField_3.setText(""+varsta);
					int a=rs.getRow();
					SetRezolv(a);
					connection.close();
					statement.close();
					rs.close();
				}catch (SQLException e2) {
					System.out.println(sql);
					e2.printStackTrace();
				}
			}
		});
		toolBar.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton(icon4);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String url = "jdbc:mysql://localhost:3306/test";
				String sql="insert into persoane values (?,?,?)";
				try {
					Connection connection= DriverManager.getConnection(url, "root", "root");
					PreparedStatement ps=connection.prepareStatement(sql);
					int id=Integer.parseInt(textField_1.getText());
					String nume=textField_2.getText();
					int varsta=Integer.parseInt(textField_3.getText());
					ps.setInt(1, id);
					ps.setString(2, nume);
					ps.setInt(3, varsta);

					int nr_randuri=ps.executeUpdate();
					System.out.print(nr_randuri);

				}catch (SQLException e2) {
					System.out.println(sql);
					e2.printStackTrace();
				}
			}
		});
		toolBar.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton(icon5);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String url = "jdbc:mysql://localhost:3306/test";
				String sql= "update persoane set nume=?, varsta=? where id=?";

				try
				{
					Connection connection= DriverManager.getConnection(url, "root", "root");
					PreparedStatement ps=connection.prepareStatement(sql);
					int id=Integer.parseInt(textField_1.getText());
					String nume=textField_2.getText();
					int varsta=Integer.parseInt(textField_3.getText());
					ps.setInt(3, id);
					ps.setString(1, nume);
					ps.setInt(2, varsta);

					int nr_randuri=ps.executeUpdate();
					System.out.print(nr_randuri);
				}
				catch (SQLException e2) 
				{
					System.out.println(sql);
					e2.printStackTrace();
				}
			}
		});
		toolBar.add(btnNewButton_5);

		JButton btnNewButton_6 = new JButton(icon6);
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String url = "jdbc:mysql://localhost:3306/test";
				String sql = "delete from persoane where id=?";
				try
				{
					Connection connection= DriverManager.getConnection(url, "root", "root");
					PreparedStatement ps=connection.prepareStatement(sql);
					int id=Integer.parseInt(textField_1.getText());
					ps.setInt(1, id);

					int nr_randuri=ps.executeUpdate();
					System.out.print(nr_randuri);

				}catch (SQLException e2) {
					System.out.println(sql);
					e2.printStackTrace();
				}
			}
		});
		toolBar.add(btnNewButton_6);

		JButton btnNewButton_7 = new JButton(icon7);
		toolBar.add(btnNewButton_7);

		JButton btnNewButton_8 = new JButton(icon8);
		toolBar.add(btnNewButton_8);

		textField_1 = new JTextField();
		textField_1.setBounds(121, 80, 122, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(121, 111, 122, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(121, 141, 122, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		JLabel lblNewLabel = new JLabel("id");
		lblNewLabel.setBounds(65, 83, 46, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("nume");
		lblNewLabel_1.setBounds(65, 114, 46, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("varsta");
		lblNewLabel_2.setBounds(65, 144, 46, 14);
		contentPane.add(lblNewLabel_2);
	}

	public void trece()
	{


		String url = "jdbc:mysql://localhost:3306/test";
		String sql="select * from persoane";

		try
		{
			Connection connection= DriverManager.getConnection(url, "root", "root");
			java.sql.Statement statement = connection.createStatement();
			ResultSet rs=statement.executeQuery(sql);
			int k=0;
			while(rs.next())
			{
				k++;
			}

			textField.setText(1+"/"+k);
		}catch (SQLException e2) {
			System.out.println(sql);
			e2.printStackTrace();
		}
	}
	

}
