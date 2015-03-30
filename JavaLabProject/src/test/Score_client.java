package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Score_client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String hostName = args[0];
		int portNumber = Integer.parseInt(args[1]);

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
			System.exit(1);
		}
		finally {

		}
		
		
		
	}

}
