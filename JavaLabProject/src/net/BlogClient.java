package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
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
//		OutputStream os = null; // no need
//		InputStream is = null; // no need
		PrintWriter prWriter = null;
		InputStreamReader inStreamR = null;
		BufferedReader bReader = null;
	//public InputStream getInputStream() Closing the returned InputStream will close the associated socket.
	//public OutputStream getOutputStream() Closing the returned OutputStream will close the associated socket.
	//Closing this socket will also close the socket's InputStream and OutputStream.
		try {
			socket = new Socket(IP, PORT);
			
			// #1
			prWriter = new PrintWriter(socket.getOutputStream());
			// #2
			//prWriter = new PrintWriter(os = socket.getOutputStream(),true);
			// #3
			//prWriter = new PrintWriter(os = socket.getOutputStream());
			
			//bReader = new BufferedReader(inStreamR = new InputStreamReader(is = socket.getInputStream()));
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
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
//			if (os != null) { //Close the stream
//				try {
//					os.close();
//				} catch (IOException e) {
//					System.err.println(e.getMessage());
//					System.out.println();
//					e.printStackTrace();
//				}
//			}
//			if (is != null) { //Close the stream
//				try {
//					is.close();
//				} catch (IOException e) {
//					System.err.println(e.getMessage());
//					System.out.println();
//					e.printStackTrace();
//				}
//			}
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
			//while ((post = br.readLine()) != null) {
			post = br.readLine();
				//if (post.equals("end")) break;
				Post p = new Post(new Date(), post); // create new Post
				prWriter.println(p.toString()); // send post to Server
			//}
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
