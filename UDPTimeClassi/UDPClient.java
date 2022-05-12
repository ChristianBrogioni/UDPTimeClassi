package UDPTimeClassi;

public class UDPClient {
	
	public static void main(String[] args) {
		
		gestoreUDPClient client= new gestoreUDPClient();
		System.out.println("Comunicazione avviata");
		client.scrivi();
		String str= client.leggi();
		System.out.println("Data e ora del server: " + str);
		client.chiudi();
		System.out.println("Comunicazione interrotta");
		
	}

}
