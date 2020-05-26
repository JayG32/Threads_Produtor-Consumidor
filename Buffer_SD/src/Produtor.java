
public class Produtor extends Thread{
	private int idProdutor;
	private Buffer buffer;
	
	public Produtor(int idProdutor, Buffer buffer) 
	{
		this.idProdutor = idProdutor;
		this.buffer = buffer;
	}

	@Override
	public void run() 
	{
		for (int i = 1; i <= 20; i++)
		{
			buffer.inserir(idProdutor, i);	
			try 
			{
				sleep((int)(Math.random() * 1000));
			}
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	
}
