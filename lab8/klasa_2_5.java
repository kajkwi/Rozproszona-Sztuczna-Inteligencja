import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.ParallelBehaviour;

public class klasa_2_5 extends Agent{
	
	protected void setup()
	{
		System.out.println("Start");
		
		ParallelBehaviour par = new ParallelBehaviour();
		par.addSubBehaviour(new CyclicBehaviour(this)
				{
					public void action()
					{
						System.out.println("Cyclic 1");
					}
				});
		
		par.addSubBehaviour(new CyclicBehaviour(this)
		{
			public void action()
			{
				System.out.println("Cyclic 2");
			}
		});
		addBehaviour(par);
		
	}
	
	/*
	protected void takeDown()
	{
		System.out.println("Usuniety");
	}
	*/
	
}