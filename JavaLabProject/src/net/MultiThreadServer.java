package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadServer {
	
	public static final int PORT = 3021;

	public static final void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket client = null;
		int count = 0;
		
		try {
			serverSocket = new ServerSocket(PORT);
			while (true) {
				client = serverSocket.accept();
				count++;
				Thread t = new Thread(new ThreadHandler(client, count));
				t.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
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
