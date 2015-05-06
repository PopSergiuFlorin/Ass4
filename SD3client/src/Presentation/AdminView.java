package Presentation;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import BusinessLogic.User;
import Connection.Client;

public class AdminView extends JFrame {

	private JPanel panel;
	private Object[][] databaseResults;
	private Object[]  columns= {};
	private DefaultTableModel dTableModel=new DefaultTableModel(databaseResults, columns);
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private static JTable table;
	//private DefaultTableModel dtm;
	//private UserCRUD a;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminView frame = new AdminView();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void FillData(){ 
		 try{ 
			 Client.connect();
			 DefaultTableModel dtm = null ;	 
			 Client.sendRequest("Read");
			 	Client.passDefaultTableModelToServer(dtm);
			 	Object obj=Client.receiveDefaultTableModelFromServer();
			 	dtm=(DefaultTableModel)obj;
			 	table.setModel(dtm);
		   	 	String request = Client.receiveRequest();
		   
		   	 System.out.println("Mesajul din FillDAta" +  request.toString());
		   
		 }catch(Exception e){ e.printStackTrace();}	
		}
	
	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public AdminView() throws UnknownHostException, IOException {
		setTitle("Admin");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 639, 371);

		panel = new JPanel();
		setContentPane(panel);
		panel.setLayout(null);

		panel.setBounds(0, 0, 626, 379);
		table = new JTable(dTableModel);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(241, 11, 327, 236);
		panel.add(scrollPane);
		scrollPane.setViewportView(table);
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(102, 36, 86, 20);
		panel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(102, 67, 86, 20);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(102, 98, 86, 20);
		panel.add(textField_2);
		
		JButton button = new JButton("Update");
		button.setBounds(142, 138, 74, 23);
		panel.add(button);
		
		JButton button_1 = new JButton("Delete");
		button_1.setBounds(74, 172, 114, 23);
		panel.add(button_1);
		
		JLabel label = new JLabel("Username:");
		label.setBounds(22, 39, 106, 14);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Password:");
		label_1.setBounds(22, 70, 86, 14);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Role:");
		label_2.setBounds(22, 101, 70, 14);
		panel.add(label_2);
		
		JButton button_2 = new JButton("Insert");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String username=textField.getText().toString();
					String password=textField_1.getText().toString();
					String role=textField_2.getText().toString();
					
					if(username.equals("") || role.equals("") || password.equals(""))
					{
						JOptionPane.showMessageDialog(panel, "Empty fields!");
					}
					else if(!role.equals("admin") && !role.equals("secretary") && !role.equals("doctor"))  {
						JOptionPane.showMessageDialog(panel, "Role must be admin,secretary or doctor");
					}
					else{
						User user=new User(username,password,role);
						Client.connect();
						Client.sendRequest("Add");
						Client.passObjectToServer(user);
						String response=Client.receiveRequest();
						System.out.println("Am primit:"+response);
						FillData();
					}
					
					
				}catch(Exception e)
				{
					JOptionPane.showMessageDialog(panel, "Error");
				}
				
			}
		});
		button_2.setBounds(39, 138, 89, 23);
		panel.add(button_2);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(39, 266, 130, 30);
		panel.add(btnLogout);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				LogInView gg = new LogInView();
				gg.setVisible(true);
				
			}
		});
		
		//FillData();
		FillData();	
	
	}
}
