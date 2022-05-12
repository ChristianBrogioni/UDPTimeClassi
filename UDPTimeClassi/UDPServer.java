package UDPTimeClassi;

public class UDPServer {
	
	public static void main(String[] args) {
		
		gestoreUDPServer server= new gestoreUDPServer(2000);
		System.out.println("Apertura porta in corso!");

		
		while(true) {
			System.out.println("Server in ascolto sulla porta 2000" + "!\n");
			String str= server.leggi();
			System.out.println(str);
			server.scrivi();
		}
		
	}

}
