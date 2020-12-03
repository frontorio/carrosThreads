package control;
import java.util.Random;

public class CarroThread extends Thread {
	
	String nomeCarro;
	public CarroThread (String nomeCarro) {
		this.nomeCarro = nomeCarro;
	}
	
	public void run() {
		int progresso = 0;
		Random numRandom = new Random();
		String and = "";
		int limite = 5;
		boolean pit = false;
		//O carro anda um numero aleatória, entre 0 e 4, até chegar em 25
		while (progresso < 25) {
			
			//if para garantir que não irá passar de 25
			if (progresso > 20) {
				limite = 25-progresso;
			}
			//Define o numero de passos que o carro irá andar
			int novoPasso = numRandom.nextInt(limite)+1;//O '+1' é para garantir que não ficará parado
			//\/****Apenas parte gráfica****\/
			for (int i = 0; i < novoPasso; i++) {
				and +="=";
			}
			progresso+=novoPasso;
			int dif = 25 - progresso;
			String linha = "";
			for (int i = 0; i < dif; i++) {
				linha+="-";
			}
			//\****Apenas parte gráfica****/\
			
			Thread.currentThread();
			Thread.yield(); 
			
			System.out.println("[CORRIDA]O "+nomeCarro+" (andou "+novoPasso+" passos): "+and+linha+"|");
			
			if (progresso > 10 & pit == false) {
				try {
					//System.out.println("O "+nomeCarro+" está entrando para o pit stop.");
					pit = pitStop(nomeCarro);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		System.out.println(">>>[LINHA DE CHEGADA]"+nomeCarro+" finalizou a corrida.");
	}
	public static synchronized boolean pitStop(String nome) throws InterruptedException {
		System.out.println(">>>[PIT STOP]O "+nome+"  está entrando para o pit stop.");
		Random numRandom = new Random();
		float tempPit = numRandom.nextFloat();
		Thread.sleep((long)tempPit);
		System.out.println(">>>[PIT STOP]O "+nome+" ficou "+tempPit+"s no pit stop.");
		return true;
	}
    
}