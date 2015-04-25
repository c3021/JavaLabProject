package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class BlogServer {
	
	public static final int PORT = 3021;
	
	public static final void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket client = null;
		InputStreamReader inStreamR= null;
		BufferedReader bReader = null;
		
		try {
			serverSocket = new ServerSocket(PORT);
			client = serverSocket.accept();
			bReader = new BufferedReader(inStreamR = new InputStreamReader(client.getInputStream()));
			String line = "";
			while ((line = bReader.readLine()) != null) {
				System.out.println("Server: " + line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (inStreamR != null) { //Close the stream
				try {
					inStreamR.close();
				} catch (IOException e) {
					System.err.println(e.getMessage());
					System.out.println();
					e.printStackTrace();
				}
			}
			if (bReader != null) { //Close the reader
				try {
					bReader.close();
				} catch (IOException e) {
					System.err.println(e.getMessage());
					System.out.println();
					e.printStackTrace();
				}
			}
			if (serverSocket != null) { //Close the socket
				try {
					serverSocket.close();
				} catch (IOException e) {
					System.err.println(e.getMessage());
					System.out.println();
					e.printStackTrace();
				}
			}
		}
	}
}
