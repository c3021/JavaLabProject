package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ThreadHandler implements Runnable {
	
	private final Socket client;
	private final int count;
	
	public ThreadHandler (Socket s, int count) {
		client = s;
		this.count = count;
	}
	
	public void run() {
		InputStreamReader inStreamR= null;
		PrintWriter prWriter = null;
		BufferedReader bReader = null;

		try {
			bReader = new BufferedReader(inStreamR = new InputStreamReader(client.getInputStream()));
			prWriter = new PrintWriter(client.getOutputStream());
			String line = "";
			while ((line = bReader.readLine()) != null) {
				switch (line) {
				case "visitor":
					prWriter.println("You're the " + count + " visitor today.");
					prWriter.flush();
					break;
				case "quit":
					line = null;
					break;
				default:
					prWriter.println("echo: " + line);
					prWriter.flush();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (prWriter != null) { //Close the writer
				prWriter.close();
			}
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
			if (client != null) { //Close the socket
				try {
					client.close();
				} catch (IOException e) {
					System.err.println(e.getMessage());
					System.out.println();
					e.printStackTrace();
				}
			}
		}
		
	}

}
