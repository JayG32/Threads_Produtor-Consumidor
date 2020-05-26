
public class Principal extends Thread {
	public static void main(String[] args) {
		Buffer buffer = new Buffer();
		
		Produtor p1 = new Produtor(1, buffer);
		
		Consumidor c1 = new Consumidor(1, buffer);
//		Consumidor c2 = new Consumidor(2, buffer);
		
		
		
		p1.start();
		c1.start();
//		c2.start();
		
	
	             
	}
}
