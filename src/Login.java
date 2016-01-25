import java.awt.EventQueue;

import javax.swing.JFrame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.Window.Type;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTextArea;
import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;
import javax.swing.JScrollPane;
public class Login {

	private JFrame frame;
	
	String kodikos1;
	int neoupoloipo;
	String name;
	String admin="spyros";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection conn=null;
	private JPasswordField passwordField;
	private JLabel label;
	private JTextField nameField;
	private JLabel lblTestPassword;
	private JPanel welcomePanel;
	private JLabel lblHello;
	private JTextField welcomeNameField;
	private JLabel label1;
	private JButton íåïðñïéïíbutton;
	private JButton áðïèåìábutton;
	private JButton åðåîáðïèbutton;
	private JButton áíáæçôçóçbutton;
	private JButton óôáôéóôéêábutton;
	private JLabel label3;
	private JLabel label4;
	private JTextField productNameField;
	private JTextField productCodeField;
	private JButton btnHome;
	private JPanel apothemaPanel;
	private JLabel label5;
	private JLabel label6;
	private JTextField nameProduct1Field;
	private JButton button1;
	private JTextField ypoloipotextField;
	private JPanel epeksApothPanel;
	private JLabel label7;
	private JLabel label8;
	private JTextField nameProducttextField;
	private JLabel label9;
	private JTextField posotitatextField;
	private JButton agoraButton;
	private JButton polisiButton;
	private JButton btnHome2;
	private JButton btnChangeUser;
	private JButton btnClear;
	private JPanel anazitisiPanel;
	private JTable table;
	private JScrollPane scrollPane;
	private JTextField textField;
	private JButton btnNewButton;
	private JPanel statistikaPanel;
	private JLabel label10;
	private JLabel label11;
	private JLabel label12;
	private JTextField textField1;
	private JTextField textField2;
	private JButton button2;
	private JButton button3;
	private JLabel label13;
	private JTextField textField3;
	private JTable table1;
	private JButton button4;
	private JLabel label14;
	private JTextField textField4;
	
	
	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
		conn=DatabaseConnection.dbConnector();
		
	}
	

	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 775, 484);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel testPswPanel = new JPanel();
		frame.getContentPane().add(testPswPanel, "name_24358263190261");
		testPswPanel.setLayout(null);
		
		welcomePanel = new JPanel();
		frame.getContentPane().add(welcomePanel, "name_24380525048378");
		welcomePanel.setLayout(null);
		
		JPanel newProductPanel = new JPanel();
		frame.getContentPane().add(newProductPanel, "name_398782775177401");
		newProductPanel.setLayout(null);
		
		apothemaPanel = new JPanel();
		frame.getContentPane().add(apothemaPanel, "name_407359434982639");
		apothemaPanel.setLayout(null);
		
		epeksApothPanel = new JPanel();
		frame.getContentPane().add(epeksApothPanel, "name_424128302753196");
		epeksApothPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u0394\u03A9\u03A3\u0395 \u039A\u03A9\u0394\u0399\u039A\u039F:");
		lblNewLabel.setBounds(177, 123, 122, 22);
		testPswPanel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		passwordField = new JPasswordField();
		passwordField.setBounds(311, 125, 116, 22);
		testPswPanel.add(passwordField);
		
		label = new JLabel("\u0394\u03A9\u03A3\u0395 \u039F\u039D\u039F\u039C\u0391 \u03A7\u03A1\u0397\u03A3\u03A4\u0397:");
		label.setBounds(109, 88, 190, 22);
		testPswPanel.add(label);
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		nameField = new JTextField();
		nameField.setBounds(311, 90, 116, 22);
		testPswPanel.add(nameField);
		nameField.setColumns(10);
		
		JButton button = new JButton("\u03A3\u03CD\u03BD\u03B4\u03B5\u03C3\u03B7...");
		button.setBounds(223, 187, 146, 51);
		testPswPanel.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try{
					String query="select * from psw where name=? and password=?";
					PreparedStatement pst=conn.prepareStatement(query);
					pst.setString(1,nameField.getText());
					pst.setString(2,passwordField.getText());
					
					ResultSet rs=pst.executeQuery();
					int count=0;
					while(rs.next()){
						count++;
					}
					if(count==1){
						name=nameField.getText();
						welcomePanel.setVisible(true);
						testPswPanel.setVisible(false);
						welcomeNameField.setText(name);
						nameField.setText("");
						passwordField.setText("");
					}
					if(count>1){
						JOptionPane.showMessageDialog(null,"Duplicate Username and Password");
						nameField.setText("");
						passwordField.setText("");
					}
					else if(count<1){
						JOptionPane.showMessageDialog(null,"Username and password is not correct Try Again...");
						nameField.setText("");
						passwordField.setText("");
					}
				}catch(Exception e){
					
				}
				
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		lblTestPassword = new JLabel("TEST PASSWORD");
		lblTestPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTestPassword.setBounds(211, 13, 174, 51);
		testPswPanel.add(lblTestPassword);
		
		
		
		lblHello = new JLabel("HELLO");
		lblHello.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHello.setBounds(317, 13, 56, 16);
		welcomePanel.add(lblHello);
		
		welcomeNameField = new JTextField();
		welcomeNameField.setEditable(false);
		welcomeNameField.setBackground(SystemColor.menu);
		welcomeNameField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		welcomeNameField.setBounds(372, 10, 116, 22);
		welcomePanel.add(welcomeNameField);
		welcomeNameField.setColumns(10);
		
		label1 = new JLabel("\u0395\u03A0\u0399\u039B\u0395\u039E\u03A4\u0395 \u039B\u0395\u0399\u03A4\u039F\u03A5\u03A1\u0393\u0399\u0391:");
		label1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label1.setBounds(300, 68, 192, 16);
		welcomePanel.add(label1);
		
		íåïðñïéïíbutton = new JButton("\u039A\u0391\u03A4\u0391\u03A7\u03A9\u03A1\u0397\u03A3\u0397 \u039D\u0395\u039F\u03A5 \u03A0\u03A1\u039F\u0399\u039F\u039D\u03A4\u039F\u03A3");
		íåïðñïéïíbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
				if(name.equals(admin)){	
				welcomePanel.setVisible(false);
				testPswPanel.setVisible(false);
				newProductPanel.setVisible(true);
				}else{
					JOptionPane.showMessageDialog(null,"Only Administrator can use this operation");
				}
					}catch(Exception k){
					
				}
				
			}
		});
		íåïðñïéïíbutton.setBounds(224, 111, 370, 47);
		welcomePanel.add(íåïðñïéïíbutton);
		
		áðïèåìábutton = new JButton("\u0391\u03A0\u039F\u0398\u0395\u039C\u0391 \u0391\u03A0\u039F\u0398\u0397\u039A\u0397\u03A3");
		áðïèåìábutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				welcomePanel.setVisible(false);
				testPswPanel.setVisible(false);
				newProductPanel.setVisible(false);
				apothemaPanel.setVisible(true);
			}
		});
		áðïèåìábutton.setBounds(224, 182, 370, 47);
		welcomePanel.add(áðïèåìábutton);
		
		åðåîáðïèbutton = new JButton("\u0395\u03A0\u0395\u039E\u0395\u03A1\u0393\u0391\u03A3\u0399\u0391 \u0391\u03A0\u039F\u0398\u0395\u039C\u0391\u03A4\u039F\u03A3");
		åðåîáðïèbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				welcomePanel.setVisible(false);
				testPswPanel.setVisible(false);
				newProductPanel.setVisible(false);
				apothemaPanel.setVisible(false);
				epeksApothPanel.setVisible(true);
				
			}
		});
		åðåîáðïèbutton.setBounds(224, 242, 370, 47);
		welcomePanel.add(åðåîáðïèbutton);
		
		áíáæçôçóçbutton = new JButton("\u0391\u039D\u0391\u0396\u0397\u03A4\u0397\u03A3\u0397 \u03A0\u03A1\u039F\u0399\u039F\u039D\u03A4\u039F\u03A3");
		áíáæçôçóçbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					welcomePanel.setVisible(false);
					anazitisiPanel.setVisible(true);
					String query="select * from products";
					PreparedStatement pst=conn.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					while(rs.next()){
						String kodikos=rs.getString("kodikos");
						String perigrafi=rs.getString("perigrafi");
						int upoloipo=rs.getInt("upoloipo");
						//textField.setText(String.valueOf(upoloipo));
						//txtBfd.setText(kodikos+"			"+perigrafi+"			"+String.valueOf(upoloipo)+"\n");
						//textArea.setText(kodikos+"			"+perigrafi+"			"+String.valueOf(upoloipo)+"\n");
						//System.out.println(kodikos+"			"+perigrafi+"			"+String.valueOf(upoloipo)+"\n");
						
					}
					
				}catch(Exception p){
					
				}
			}
		});
		áíáæçôçóçbutton.setBounds(224, 318, 370, 47);
		welcomePanel.add(áíáæçôçóçbutton);
		
		óôáôéóôéêábutton = new JButton("\u03A3\u03A4\u0391\u03A4\u0399\u03A3\u03A4\u0399\u039A\u0391 \u03A3\u03A4\u039F\u0399\u03A7\u0395\u0399\u0391");
		óôáôéóôéêábutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(name.equals(admin)){
				testPswPanel.setVisible(false);
				newProductPanel.setVisible(false);
				apothemaPanel.setVisible(false);
				epeksApothPanel.setVisible(false);
				anazitisiPanel.setVisible(false);
				welcomePanel.setVisible(false);
				statistikaPanel.setVisible(true);
				}else{
					JOptionPane.showMessageDialog(null,"Only Administrator can use this operation");
				}
			}
		});
		óôáôéóôéêábutton.setBounds(224, 389, 370, 47);
		welcomePanel.add(óôáôéóôéêábutton);
		
		btnChangeUser = new JButton("CHANGE USER");
		btnChangeUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				welcomePanel.setVisible(false);
				testPswPanel.setVisible(true);
			}
		});
		btnChangeUser.setBounds(28, 388, 130, 49);
		welcomePanel.add(btnChangeUser);
		
		
		
		JLabel label2 = new JLabel("\u0394\u0397\u039C\u0399\u039F\u03A5\u03A1\u0393\u0399\u0391 \u039D\u0395\u039F\u03A5 \u03A0\u03A1\u039F\u0399\u039F\u039D\u03A4\u039F\u03A3");
		label2.setFont(new Font("Tahoma", Font.BOLD, 18));
		label2.setBounds(209, 62, 313, 37);
		newProductPanel.add(label2);
		
		label3 = new JLabel("\u03A0\u0395\u03A1\u0399\u0393\u03A1\u0391\u03A6\u0397 \u03A0\u03A1\u039F\u0399\u039F\u039D\u03A4\u039F\u03A3:");
		label3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label3.setBounds(77, 142, 212, 29);
		newProductPanel.add(label3);
		
		label4 = new JLabel("\u039A\u03A9\u0394\u0399\u039A\u039F\u03A3 \u03A0\u03A1\u039F\u0399\u039F\u039D\u03A4\u039F\u03A3:");
		label4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label4.setBounds(77, 184, 212, 37);
		newProductPanel.add(label4);
		
		productNameField = new JTextField();
		productNameField.setBounds(301, 147, 262, 22);
		newProductPanel.add(productNameField);
		productNameField.setColumns(10);
		
		productCodeField = new JTextField();
		productCodeField.setBounds(301, 193, 262, 22);
		newProductPanel.add(productCodeField);
		productCodeField.setColumns(10);
		
		JButton btnNewProductButton = new JButton("\u039A\u0391\u03A4\u0391\u03A7\u03A9\u03A1\u0397\u03A3\u0397");
		btnNewProductButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String query="insert into products (kodikos,perigrafi) values(?,?)";
					PreparedStatement pst=conn.prepareStatement(query);
					pst.setString(1,productCodeField.getText());
					pst.setString(2,productNameField.getText());
					
					
					if(productCodeField.getText().equals("")&&(productNameField.getText().equals(""))){
						JOptionPane.showMessageDialog(null,"Please fill both of fields");
					}else if(productCodeField.getText().equals("")){
						JOptionPane.showMessageDialog(null,"Please fill the code field");
					}else if(productNameField.getText().equals("")){
						JOptionPane.showMessageDialog(null,"Please fill the perigrafi field");
					}else{
				
						pst.executeUpdate();
				
						JOptionPane.showMessageDialog(null,"You Create a new product succesfully");
						productNameField.setText("");
						productCodeField.setText("");
					}
					
					
					
				}catch(Exception k){
					JOptionPane.showMessageDialog(null,"Fail,the code is already in use...try something else!");
					productCodeField.setText("");
				}
				
			}
		});
		btnNewProductButton.setBounds(299, 304, 154, 58);
		newProductPanel.add(btnNewProductButton);
		
		btnHome = new JButton("HOME");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				testPswPanel.setVisible(false);
				newProductPanel.setVisible(false);
				welcomePanel.setVisible(true);
			}
		});
		btnHome.setBounds(576, 364, 97, 25);
		newProductPanel.add(btnHome);
		
		
		
		label5 = new JLabel("\u0391\u03A0\u039F\u0398\u0395\u039C\u0391 \u0391\u03A0\u039F\u0398\u0397\u039A\u0397\u03A3");
		label5.setFont(new Font("Tahoma", Font.BOLD, 18));
		label5.setBounds(290, 33, 240, 44);
		apothemaPanel.add(label5);
		
		label6 = new JLabel("\u0394\u03A9\u03A3\u0395 \u039F\u039D\u039F\u039C\u0391 \u03A0\u03A1\u039F\u0399\u039F\u039D\u03A4\u039F\u03A3:");
		label6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label6.setBounds(32, 121, 226, 21);
		apothemaPanel.add(label6);
		
		nameProduct1Field = new JTextField();
		nameProduct1Field.setBounds(270, 122, 215, 22);
		apothemaPanel.add(nameProduct1Field);
		nameProduct1Field.setColumns(10);
		
		button1 = new JButton("\u039F\u039A");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				String query="select * from products where perigrafi=?";
				PreparedStatement pst=conn.prepareStatement(query);
				pst.setString(1,nameProduct1Field.getText());
				ResultSet rs=pst.executeQuery();
				
				if(rs.next()){
					
					int upoloipo=rs.getInt("upoloipo");
					ypoloipotextField.setText(String.valueOf(upoloipo));
					
				}
				
			}catch(Exception p){
				
			}
			}
		});
		button1.setBounds(546, 121, 97, 25);
		apothemaPanel.add(button1);
		
		JButton btnHome1 = new JButton("HOME");
		btnHome1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				testPswPanel.setVisible(false);
				newProductPanel.setVisible(false);
				apothemaPanel.setVisible(false);
				epeksApothPanel.setVisible(false);
				welcomePanel.setVisible(true);
				nameProduct1Field.setText("");
				ypoloipotextField.setText("");
			}
		});
		btnHome1.setBounds(546, 374, 97, 25);
		apothemaPanel.add(btnHome1);
		
		ypoloipotextField = new JTextField();
		ypoloipotextField.setEditable(false);
		ypoloipotextField.setBounds(293, 231, 116, 22);
		apothemaPanel.add(ypoloipotextField);
		ypoloipotextField.setColumns(10);
		
		btnClear = new JButton("CLEAR");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nameProduct1Field.setText("");
				ypoloipotextField.setText("");
			}
		});
		btnClear.setBounds(546, 182, 97, 25);
		apothemaPanel.add(btnClear);
		
		
		
		label7 = new JLabel("\u0395\u03A0\u0395\u039E\u0395\u03A1\u0393\u0391\u03A3\u0399\u0391 \u0391\u03A0\u039F\u0398\u0395\u039C\u0391\u03A4\u039F\u03A3 \u0391\u03A0\u039F\u0398\u0397\u039A\u0397\u03A3");
		label7.setFont(new Font("Tahoma", Font.BOLD, 18));
		label7.setBounds(200, 44, 423, 31);
		epeksApothPanel.add(label7);
		
		label8 = new JLabel("\u0394\u03A9\u03A3\u0395 \u039F\u039D\u039F\u039C\u0391 \u0395\u0399\u0394\u039F\u03A5\u03A3:");
		label8.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label8.setBounds(186, 129, 196, 31);
		epeksApothPanel.add(label8);
		
		nameProducttextField = new JTextField();
		nameProducttextField.setBounds(394, 135, 169, 22);
		epeksApothPanel.add(nameProducttextField);
		nameProducttextField.setColumns(10);
		
		label9 = new JLabel("\u0394\u03A9\u03A3\u0395 \u03A0\u039F\u03A3\u039F\u03A4\u0397\u03A4\u0391 \u0395\u0399\u0394\u039F\u03A5\u03A3:");
		label9.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label9.setBounds(164, 189, 216, 22);
		epeksApothPanel.add(label9);
		
		posotitatextField = new JTextField();
		posotitatextField.setBounds(394, 189, 169, 22);
		epeksApothPanel.add(posotitatextField);
		posotitatextField.setColumns(10);
		
		agoraButton = new JButton("\u0391\u0393\u039F\u03A1\u0391");
		agoraButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					String query="select * from products where perigrafi=?";
					PreparedStatement pst=conn.prepareStatement(query);
					pst.setString(1,nameProducttextField.getText());
					ResultSet rs=pst.executeQuery();
					
					if(rs.next()){
						
						int palioupoloipo=rs.getInt("upoloipo");
						//System.out.println(palioupoloipo);
						String upoloipo2=posotitatextField.getText();
						int upoloipo22=Integer.valueOf(upoloipo2);
						neoupoloipo=palioupoloipo+upoloipo22;
						
						kodikos1=rs.getString("kodikos");
						
						}	
				}catch(Exception p){
						}
				
				try{
					String query2="update products set upoloipo=? where perigrafi=?";
					PreparedStatement pst2=conn.prepareStatement(query2);
					pst2.setInt(1,neoupoloipo);
					pst2.setString(2,nameProducttextField.getText());
					
					pst2.executeUpdate();
					
					JOptionPane.showMessageDialog(null,"To upoloipo enimerothike");
					//NameProducttextField.setText("");
					//PosotitatextField.setText("");
					
				}catch(Exception p){
					
				
				}
				
				try{
					String query4="insert into agora(kodikos,imerominia,posotita) values(?,?,?)";
					PreparedStatement pst4=conn.prepareStatement(query4);
					pst4.setString(1,kodikos1);
					pst4.setString(2,textField4.getText());
					pst4.setString(3,posotitatextField.getText());
					
					pst4.executeUpdate();
					
					JOptionPane.showMessageDialog(null,"O piakas agora animerothike");
					nameProducttextField.setText("");
					posotitatextField.setText("");
					textField4.setText("");
				}catch(Exception p){
					
				
				}
			}
		});
		agoraButton.setBounds(332, 306, 133, 51);
		epeksApothPanel.add(agoraButton);
		
		polisiButton = new JButton("\u03A0\u03A9\u039B\u0397\u03A3\u0397");
		polisiButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					String query="select * from products where perigrafi=?";
					PreparedStatement pst=conn.prepareStatement(query);
					pst.setString(1,nameProducttextField.getText());
					ResultSet rs=pst.executeQuery();
					
					if(rs.next()){
						
						int palioupoloipo=rs.getInt("upoloipo");
						//System.out.println(palioupoloipo);
						String upoloipo2=posotitatextField.getText();
						int upoloipo22=Integer.valueOf(upoloipo2);
						neoupoloipo=palioupoloipo-upoloipo22;
						kodikos1=rs.getString("kodikos");
						}	
				}catch(Exception p){
						}
				if(neoupoloipo>=0){
				try{
					String query2="update products set upoloipo=? where perigrafi=?";
					PreparedStatement pst2=conn.prepareStatement(query2);
					pst2.setInt(1,neoupoloipo);
					pst2.setString(2,nameProducttextField.getText());
				
					pst2.executeUpdate();	
					JOptionPane.showMessageDialog(null,"To upoloipo enimerothike");
					//NameProducttextField.setText("");
					//PosotitatextField.setText("");
					
				}catch(Exception p){
					
				}
				
				}else{
					JOptionPane.showMessageDialog(null,"To upoloipo den eparkei");
					nameProducttextField.setText("");
					posotitatextField.setText("");
				}

				try{
					String query4="insert into polisi(kodikos,imerominia,posotita) values(?,?,?)";
					PreparedStatement pst4=conn.prepareStatement(query4);
					pst4.setString(1,kodikos1);
					pst4.setString(2,textField4.getText());
					pst4.setString(3,posotitatextField.getText());
					
					pst4.executeUpdate();
					
					JOptionPane.showMessageDialog(null,"O pinakas polisi animerothike");
					nameProducttextField.setText("");
					posotitatextField.setText("");
					textField4.setText("");
				}catch(Exception p){
					
				
				}
			}
			
		});
		polisiButton.setBounds(332, 370, 133, 51);
		epeksApothPanel.add(polisiButton);
		
		btnHome2 = new JButton("HOME");
		btnHome2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent k) {
				testPswPanel.setVisible(false);
				newProductPanel.setVisible(false);
				apothemaPanel.setVisible(false);
				epeksApothPanel.setVisible(false);
				welcomePanel.setVisible(true);
			}
		});
		btnHome2.setBounds(593, 383, 97, 25);
		epeksApothPanel.add(btnHome2);
		
		label14 = new JLabel("\u0394\u03A9\u03A3\u0395 \u0397\u039C\u0395\u03A1\u039F\u039C\u0397\u039D\u0399\u0391:");
		label14.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label14.setBounds(200, 236, 180, 16);
		epeksApothPanel.add(label14);
		
		textField4 = new JTextField();
		textField4.setBounds(394, 235, 169, 22);
		epeksApothPanel.add(textField4);
		textField4.setColumns(10);
		
		anazitisiPanel = new JPanel();
		frame.getContentPane().add(anazitisiPanel, "name_434407911173624");
		anazitisiPanel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(52, 29, 667, 238);
		anazitisiPanel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setEnabled(false);
		
		textField = new JTextField();
		textField.setBounds(67, 308, 116, 22);
		anazitisiPanel.add(textField);
		textField.setColumns(10);
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
				String query="select * from products where perigrafi LIKE ?";
				PreparedStatement pst=conn.prepareStatement(query);
				pst.setString(1,textField.getText()+"%");
				ResultSet rs=pst.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
				}catch(Exception f){
					
				}
				
			}
		});
		btnSearch.setBounds(228, 307, 97, 25);
		anazitisiPanel.add(btnSearch);
		
		btnNewButton = new JButton("HOME");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				testPswPanel.setVisible(false);
				newProductPanel.setVisible(false);
				apothemaPanel.setVisible(false);
				epeksApothPanel.setVisible(false);
				anazitisiPanel.setVisible(false);
				welcomePanel.setVisible(true);
				textField.setText("");
			}
		});
		btnNewButton.setBounds(551, 343, 116, 46);
		anazitisiPanel.add(btnNewButton);
		
		statistikaPanel = new JPanel();
		frame.getContentPane().add(statistikaPanel, "name_477005631993592");
		statistikaPanel.setLayout(null);
		
		label10 = new JLabel("\u03A3\u03A4\u0391\u03A4\u0399\u03A3\u03A4\u0399\u039A\u0391 \u03A3\u03A4\u039F\u0399\u03A7\u0395\u0399\u0391");
		label10.setFont(new Font("Tahoma", Font.BOLD, 18));
		label10.setBounds(274, 24, 204, 38);
		statistikaPanel.add(label10);
		
		label11 = new JLabel("\u0391\u03A0\u039F:");
		label11.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label11.setBounds(40, 81, 42, 16);
		statistikaPanel.add(label11);
		
		label12 = new JLabel("\u0395\u03A9\u03A3:");
		label12.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label12.setBounds(40, 122, 42, 16);
		statistikaPanel.add(label12);
		
		textField1 = new JTextField();
		textField1.setBounds(83, 80, 116, 22);
		statistikaPanel.add(textField1);
		textField1.setColumns(10);
		
		textField2 = new JTextField();
		textField2.setBounds(83, 121, 116, 22);
		statistikaPanel.add(textField2);
		textField2.setColumns(10);
		
		button2 = new JButton("\u0391\u0393\u039F\u03A1\u0395\u03A3");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField1.getText().equals("")&&textField2.getText().equals("")&&!textField3.getText().equals("")){
					try{
					String query="select perigrafi,imerominia,posotita from products join agora on products.kodikos=agora.kodikos where perigrafi=?";
					PreparedStatement pst=conn.prepareStatement(query);
					pst.setString(1,textField3.getText());
					ResultSet rs=pst.executeQuery();
					table1.setModel(DbUtils.resultSetToTableModel(rs));
					
					}catch(Exception f){
						
					}
				}else if(textField1.getText().equals("")&&!textField2.getText().equals("")&&!textField3.getText().equals("")){
					try{
						String query="select perigrafi,imerominia,posotita from products join agora on products.kodikos=agora.kodikos where perigrafi=? && imerominia<?";
						PreparedStatement pst=conn.prepareStatement(query);
						pst.setString(1,textField3.getText());
						pst.setString(2,textField2.getText());
						ResultSet rs=pst.executeQuery();
						table1.setModel(DbUtils.resultSetToTableModel(rs));
						
						}catch(Exception f){
							
						}
					
				}else if(textField2.getText().equals("")&&!textField1.getText().equals("")&&!textField3.getText().equals("")){
					try{
						String query="select perigrafi,imerominia,posotita from products join agora on products.kodikos=agora.kodikos where perigrafi=? && imerominia>?";
						PreparedStatement pst=conn.prepareStatement(query);
						pst.setString(1,textField3.getText());
						pst.setString(2,textField1.getText());
						ResultSet rs=pst.executeQuery();
						table1.setModel(DbUtils.resultSetToTableModel(rs));
						
						}catch(Exception f){
							
						}
				}else if(!textField1.getText().equals("")&&!textField2.getText().equals("")&&!textField3.getText().equals("")){
					try{
						String query="select perigrafi,imerominia,posotita from products join agora on products.kodikos=agora.kodikos where perigrafi=? && imerominia>? && imerominia<?";
						PreparedStatement pst=conn.prepareStatement(query);
						pst.setString(1,textField3.getText());
						pst.setString(2,textField1.getText());
						pst.setString(3,textField2.getText());
						//System.out.println("edw eimaste");
						ResultSet rs=pst.executeQuery();
						
						table1.setModel(DbUtils.resultSetToTableModel(rs));
						
						}catch(Exception f){
							
						}
				}
			}
		});
		button2.setBounds(254, 79, 97, 25);
		statistikaPanel.add(button2);
		
		button3 = new JButton("\u03A0\u03A9\u039B\u0397\u03A3\u0395\u0399\u03A3");
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField1.getText().equals("")&&textField2.getText().equals("")&&!textField3.getText().equals("")){
					try{
						String query="select perigrafi,imerominia,posotita from products join polisi on products.kodikos=polisi.kodikos where perigrafi=?";
						PreparedStatement pst=conn.prepareStatement(query);
						pst.setString(1,textField3.getText());
						ResultSet rs=pst.executeQuery();
						table1.setModel(DbUtils.resultSetToTableModel(rs));
						
						}catch(Exception f){
							
						}
				}else if(textField1.getText().equals("")&&!textField2.getText().equals("")&&!textField3.getText().equals("")){
					try{
						String query="select perigrafi,imerominia,posotita from products join polisi on products.kodikos=polisi.kodikos where perigrafi=? && imerominia<?";
						PreparedStatement pst=conn.prepareStatement(query);
						pst.setString(1,textField3.getText());
						pst.setString(2,textField2.getText());
						ResultSet rs=pst.executeQuery();
						table1.setModel(DbUtils.resultSetToTableModel(rs));
						
						}catch(Exception f){
							
						}
					
				}else if(textField2.getText().equals("")&&!textField1.getText().equals("")&&!textField3.getText().equals("")){
					try{
						String query="select perigrafi,imerominia,posotita from products join polisi on products.kodikos=polisi.kodikos where perigrafi=? && imerominia>?";
						PreparedStatement pst=conn.prepareStatement(query);
						pst.setString(1,textField3.getText());
						pst.setString(2,textField1.getText());
						ResultSet rs=pst.executeQuery();
						table1.setModel(DbUtils.resultSetToTableModel(rs));
						
						}catch(Exception f){
							
						}	
					}else if(!textField1.getText().equals("")&&!textField2.getText().equals("")&&!textField3.getText().equals("")){
						try{
							String query="select perigrafi,imerominia,posotita from products join polisi on products.kodikos=polisi.kodikos where perigrafi=? && imerominia>? && imerominia<?";
							PreparedStatement pst=conn.prepareStatement(query);
							pst.setString(1,textField3.getText());
							pst.setString(2,textField1.getText());
							pst.setString(3,textField2.getText());
							//System.out.println("edw eimaste");
							ResultSet rs=pst.executeQuery();
							
							table1.setModel(DbUtils.resultSetToTableModel(rs));
							
							}catch(Exception f){
								
							}
					}
				}
		});
		button3.setBounds(254, 122, 97, 25);
		statistikaPanel.add(button3);
		
		label13 = new JLabel("\u0394\u03A9\u03A3\u0395 \u039F\u039D\u039F\u039C\u0391 \u03A0\u03A1\u039F\u0399\u039F\u039D\u03A4\u039F\u03A3:");
		label13.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label13.setBounds(375, 77, 245, 25);
		statistikaPanel.add(label13);
		
		textField3 = new JTextField();
		textField3.setBounds(616, 80, 116, 22);
		statistikaPanel.add(textField3);
		textField3.setColumns(10);
		
		table1 = new JTable();
		table1.setBounds(62, 174, 671, 217);
		statistikaPanel.add(table1);
		
		button4 = new JButton("\u0397\u039F\u039C\u0395");
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				testPswPanel.setVisible(false);
				newProductPanel.setVisible(false);
				apothemaPanel.setVisible(false);
				epeksApothPanel.setVisible(false);
				anazitisiPanel.setVisible(false);
				statistikaPanel.setVisible(false);
				welcomePanel.setVisible(true);
				textField1.setText("");
				textField2.setText("");
				textField3.setText("");
			}
		});
		button4.setBounds(630, 411, 97, 25);
		statistikaPanel.add(button4);
	}
}
