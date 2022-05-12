package UDPTimeClassi;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class gestoreUDPClient {
	
	int port = 2000; 
	InetAddress serverAddress;
	DatagramSocket dSocket;
	DatagramPacket outPacket;
	DatagramPacket inPacket;
	byte[] buffer= new byte[256];
	String message="RICHIESTA DATA E ORA";
	String response;
	
	public void scrivi() {
		try {
			serverAddress = InetAddress.getLocalHost();
			System.out.println("Indirizzo del server trovato!");
			dSocket = new DatagramSocket();
			outPacket = new DatagramPacket(message.getBytes(), message.length(), serverAddress, port); //messaggio che invio
			dSocket.send(outPacket);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public String leggi() {
	
		try {
			inPacket = new DatagramPacket(buffer, buffer.length);
			dSocket.receive(inPacket);
			response = new String(inPacket.getData(), 0, inPacket.getLength());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}
	
	public void chiudi() {
		dSocket.close();
	}
	
	

}
