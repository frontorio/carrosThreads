package control;


public class main {
	
	public static void main (String[] args) throws InterruptedException {
		CarroThread carro1 = new CarroThread("** Carro 1");
		CarroThread carro2 = new CarroThread("++ Carro 2");
		
		carro1.start();
		carro2.start();
		carro1.join();
		carro2.join();
		
		System.out.println("\n\nCorrida finalizada!");
	}
	
}