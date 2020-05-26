
public class Buffer {
	
	private int itens = 0;
	private int capacidadeTotal = 10;

	public synchronized void inserir(int id, int valor)
	{
		while (itens >= capacidadeTotal)
		{
			try 
			{
				System.out.println("--------------------------------------------");
				System.out.println(">> (Erro ao Inserir - Buffer cheio) - Produtor" + id +" aguardando...");
				System.out.println("--------------------------------------------");
				wait(); //bloqueia a execução da thread temporariamente, ou seja, coloca a trhead em modo de espera
			}
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
		
		itens++;
		
		System.out.println("Produtor " + id +" inserindo " + itens + "...");
		System.out.println("------");
		
		notifyAll(); //Notifica que está disponivel a todas as outras threads a que tem prioridade mais alta ganha acesso ao objeto
	}

	public synchronized void consumir(int id) 
	{
		while (itens <= 0)
		{
			try 
			{	
				System.out.println("--------------------------------------------");
				System.out.println(">> (Erro ao retirar - Buffer vazio) - Consumidor " + id +" aguardando... ");
				System.out.println("--------------------------------------------");
				wait();
			}
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
		
		
		System.out.println("Consumidor " + id + " consumindo " + itens + "...");
		System.out.println("------");
		
		itens--;
		
		notifyAll();
	}

	
}
