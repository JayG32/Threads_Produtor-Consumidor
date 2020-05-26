
public class Consumidor extends Thread{
	private int idConsumidor;
	private Buffer buffer;
	
	public Consumidor(int idConsumidor, Buffer buffer) 
	{
		this.idConsumidor = idConsumidor;
		this.buffer = buffer;
	}

	@Override
	public void run() 
	{
		for (int i = 1; i <= 20; i++) 
		{
			buffer.consumir(idConsumidor);
			try 
			{
				sleep((int)(Math.random() * 10000));
			}
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			
		}
	}
}