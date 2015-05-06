package Connection;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.table.DefaultTableModel;


import BusinessLogic.User;

public class Client {

	public static final int PORT=9990;
	public static final String HOSTNAME="localhost";
	static Socket socket=null;

	public static void connect() throws UnknownHostException, IOException {
		System.out.println("Attempting to connect to " + HOSTNAME + ":" + PORT);
		socket = new Socket(HOSTNAME, PORT);
		System.out.println("Connection Established");
	}

	public static void passObjectToServer(Object o ){
		try {
			ObjectOutputStream  oos= new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject(o); 
			System.out.println("Obiectul a fost trimis catre server" + o.toString());
		} catch (IOException e) { 
			e.printStackTrace();
		}
	}
	
	
	public static Object receiveUserObjectFromServer(){
		Object obj=new Object(); 
		try {
			ObjectInputStream  ois= new ObjectInputStream(socket.getInputStream());
			obj=ois.readObject(); 
			System.out.println(ois);
	 		User u=(User)obj;
			System.out.println("Obiectul a fost primit de catre client" +u.getId());
		} catch (IOException e) { 
			e.printStackTrace();
		} catch (ClassNotFoundException e) { 
			e.printStackTrace();
		}
		return obj;
	}

	
	public static void sendRequest(String request ){
		try {
			ObjectOutputStream  oos= new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject(request); 
			System.out.println("Ordinul a fost trimis la server" + request.toString());
		} catch (IOException e) { 
			e.printStackTrace();
		}
	}
	
	public static String receiveRequest(){
		String request = null;
		 
		try {
			ObjectInputStream  ois= new ObjectInputStream(socket.getInputStream());
			request=(String)ois.readObject();  
			System.out.println("Ordinul:" + request.toString()  +  " a fost primit de catre client");
		  
			return request;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return request;
		
	}

	
	public static void passDefaultTableModelToServer(DefaultTableModel o ){
		try {
			ObjectOutputStream  oos= new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject(o); 
			//System.out.println("Tabela a fost trimisa catre server"); 
		} catch (IOException e) {
		 
			e.printStackTrace();
		}
	}
	



	public static Object receiveDefaultTableModelFromServer(){
		Object obj=new Object();
		try {
			ObjectInputStream  ois= new ObjectInputStream(socket.getInputStream());
			obj=ois.readObject(); 
			System.out.println(ois); 
		//	DefaultTableModel u=(DefaultTableModel)obj;
		  
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			 
			e.printStackTrace();
		}
		return obj;
	}


	}
