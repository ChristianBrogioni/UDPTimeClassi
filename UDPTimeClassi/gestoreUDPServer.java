package UDPTimeClassi;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Date;

public class gestoreUDPServer {
	
	DatagramSocket dSocket;
	byte[] buffer= new byte[256];
	DatagramPacket inPacket;
	DatagramPacket outPacket;
	String messageIn, messageOut;
	Date d;
	InetAddress clientAddress;
	int clientPort;
	
	public gestoreUDPServer(int porta){
		try {
			dSocket = new DatagramSocket(porta);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String leggi() {
		
		try {
			inPacket = new DatagramPacket(buffer, buffer.length);
			dSocket.receive(inPacket);
			clientAddress = inPacket.getAddress();
			clientPort = inPacket.getPort();
			messageIn = new String(inPacket.getData(), 0, inPacket.getLength());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return messageIn;
	}
	
	public void scrivi() {

		try {
			d = new Date();
			messageOut = d.toString();
			outPacket = new DatagramPacket(messageOut.getBytes(), messageOut.length(), clientAddress, clientPort);
			dSocket.send(outPacket);
			System.out.println("Risposta inviata!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
