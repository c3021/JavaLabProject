package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;

import base.Post;

public class BlogClient {

	public static final String IP = "127.0.0.1";
	public static final int PORT = 3021;
	
	public static final void main(String[] args) {
		Socket socket = null;
		OutputStream os = null;
		PrintWriter prWriter = null;
		InputStreamReader inStreamR = null;
		BufferedReader bReader = null;
		
		try {
			socket = new Socket(IP, PORT);
			prWriter = new PrintWriter(socket.getOutputStream());
			//prWriter = new PrintWriter(os = socket.getOutputStream());
			bReader = new BufferedReader(inStreamR = new InputStreamReader(socket.getInputStream()));
			if (sendPost(prWriter))
				System.out.println("Sent Successfully!");
			else 
				System.out.println("Nothing is sent!");
			
		} catch (UnknownHostException e) {
			System.err.println(e.getMessage());
			System.out.println();
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println(e.getMessage());
			System.out.println();
			e.printStackTrace();
		} finally {
			if (os != null) { //Close the stream
				try {
					os.close();
				} catch (IOException e) {
					System.err.println(e.getMessage());
					System.out.println();
					e.printStackTrace();
				}
			}
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
			if (socket != null) { //Close the socket
				try {
					socket.close();
				} catch (IOException e) {
					System.err.println(e.getMessage());
					System.out.println();
					e.printStackTrace();
				}
			}
		}
		
		
	}
	
	private static boolean sendPost(PrintWriter prWriter) {
		String post;
		BufferedReader br = null;
		InputStreamReader inSR = null;
		try {
			System.out.print("Send post: ");
			br = new BufferedReader(inSR = new InputStreamReader(System.in));
			post = br.readLine();
			Post p = new Post(new Date(), post);
			prWriter.println(p.toString()); // send post to Server
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} finally {
			if (br != null) { //close the BufferedReader
				try {
					br.close();
				} catch (IOException e) {
					System.err.println(e.getMessage());
					System.out.println();
					e.printStackTrace();
				}
			}
			if (inSR != null) { //close the InputStreamReader
				try {
					inSR.close();
				} catch (IOException e) {
					System.err.println(e.getMessage());
					System.out.println();
					e.printStackTrace();
				}
			}
		}
		return true;
		
	}
}
