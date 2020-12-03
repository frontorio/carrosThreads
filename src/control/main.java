package control;


public class main {
	
	public static void main (String[] args) throws InterruptedException {
		CarroThread carro1 = new CarroThread("Carro 1");
		CarroThread carro2 = new CarroThread("Carro 2");
		CarroThread carro3 = new CarroThread("Carro 3");
		CarroThread carro4 = new CarroThread("Carro 4");
		CarroThread carro5 = new CarroThread("Carro 5");
		
		
		carro1.start();
		carro2.start();
		carro3.start();
		carro4.start();
		carro5.start();
		carro1.join();
		carro2.join();
		carro3.join();
		carro4.join();
		carro5.join();
		
		
		System.out.println("\n\nCorrida finalizada!");
	}
	
}