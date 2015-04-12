package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;


public class Score_client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String hostName = args[0];
		int portNumber = Integer.parseInt(args[1]);
		try {
			System.out.println((InetAddress.getByName("yahoo.com")).toString());
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Socket cSocket;
		try {
			cSocket = new Socket("yahoo.com", 80);
			System.out.println(cSocket.toString() + cSocket.isConnected());
		    PrintWriter out = new PrintWriter(cSocket.getOutputStream(), true);
		    BufferedReader in = new BufferedReader(new InputStreamReader(cSocket.getInputStream()));
		    System.out.println("xxxxxxxx");
		    out.println("X");
		    String temp = "";
		    while ((temp = in.readLine()) != null) {
		    	System.out.println("Server: " + temp);
		    	}
		    
		    cSocket.close();
		}
		catch (UnknownHostException e) {
			System.err.println("Don't know about host " + hostName);
			e.printStackTrace();
		}
		catch (IOException e) {
			System.err.println("Couldn't get I/O for the connection to " + hostName);
			e.printStackTrace();
			System.exit(1);
		}
		finally {
			//cSocket.close();
		}
		
		/*
		try (
		    Socket echoSocket = new Socket(hostName, portNumber);
		    PrintWriter out =
		        new PrintWriter(echoSocket.getOutputStream(), true);
		    BufferedReader in =
		        new BufferedReader(
		            new InputStreamReader(echoSocket.getInputStream()));
		    BufferedReader stdIn =
		        new BufferedReader(
		            new InputStreamReader(System.in));
		){
		String userInput;
		while ((userInput = stdIn.readLine()) != null) {
		    out.println(userInput);
		    System.out.println("echo: " + in.readLine());
		    }
		echoSocket.close();
		out.close();
		in.close();
		stdIn.close();
		}
		catch (UnknownHostException e) {
			System.err.println("Don't know about host " + hostName);
		}
		catch (IOException e) {
			System.err.println("Couldn't get I/O for the connection to " + hostName);
			e.printStackTrace();
			System.exit(1);
		}
		finally {

		}
		*/
		
		
	}

}
