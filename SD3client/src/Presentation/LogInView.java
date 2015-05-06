package Presentation;
 


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
//import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import BusinessLogic.User;
import Connection.Client;





public class LogInView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	public static int ID;
	

	

	/**
	 * Create the frame.
	 */
	public  LogInView() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 431, 256);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 248, 255));
		contentPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(144, 48, 121, 20);
		contentPane.add(textField);
		textField.setColumns(10);
	
		
		passwordField = new JPasswordField();
		passwordField.setBounds(144, 85, 121, 20);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Log in");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					User user=new User(0,textField.getText(),String.valueOf(passwordField),null);
					if(textField.getText().equals("")|| String.valueOf(passwordField).equals("")){
						 JOptionPane.showMessageDialog(null, "Empty Fields");
						}else{
							Client.connect();		
							Client.sendRequest("Login");
							Client.passObjectToServer(user);
							Object obj=Client.receiveUserObjectFromServer();
							user=(User)obj;
							String responseFromServer = Client.receiveRequest();
							System.out.println("Mesaju de la login: " + responseFromServer);
							
					if(user.getRole().equals("admin"))
					{
						AdminView av=new AdminView();
						setVisible(false);
					}
					if(user.getRole().equals("secretary"))
					{
						SecretaryView sv=new SecretaryView();
						sv.setVisible(true);
						setVisible(false);
					}
					if(user.getRole().equals("doctor"))
					{
						DoctorView dv=new DoctorView();
						dv.setVisible(true);
						setVisible(false);
					}
					}
						
					
				} catch (UnknownHostException e) {
					System.err.println("Host unknown. Cannot establish connection");
				} catch (IOException e) {
					System.err.println("Cannot establish connection. Server may not be up."
							+ e.getMessage());
				}
			
				
				
			}
		});
		
		btnNewButton.setBounds(109, 127, 134, 26);
		contentPane.add(btnNewButton);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(76, 48, 99, 20);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(76, 88, 95, 14);
		contentPane.add(lblPassword);
	
		
		
		
		JButton btnContinue = new JButton("Continue");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
	    String name = textField.getText();
	    String pass = passwordField.getText();
	    
	    if (name.isEmpty() && pass.isEmpty())
			  JOptionPane.showMessageDialog(null, "Nu ati introdus datele pentru autentificare!", "Eroare!", JOptionPane.WARNING_MESSAGE);
	    else
	    {
	    if (name.isEmpty() || pass.isEmpty())
			JOptionPane.showMessageDialog(null, "Nu s-au completat toate campurile!", "Eroare!", JOptionPane.WARNING_MESSAGE);

	    }
    
	    
		
	   
	    	
	    	

	   /* 	if(name.equals(u.getName()) && pass.equals(u.getPassword()) && u.getType().contentEquals("admin"))
	    	{

	    		//view.setVisible(true);
	    	}
	    	else
	    	{

	    		if(name.equals(u.getName()) && pass.equals(u.getPassword()))

	    			//cview.setVisible(true);
	    	
	    		else
	    				{
	    		 if(!(name.equals(u.getName()) && pass.equals(u.getPassword())))
						JOptionPane.showMessageDialog(null, "Numele de utilizator sau parola au fost introduse gresit!", "Eroare!", JOptionPane.WARNING_MESSAGE);
	    		
	    		
	    				}
	    		
	    	}
	    		
	    	

		_*/
			}});
	
		
	
		
	}
}