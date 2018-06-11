import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.ParallelBehaviour;
import jade.core.Agent;

public class klasa_2_3 extends Agent
{
	protected void setup() 
	{
		
		ParallelBehaviour beh = new ParallelBehaviour(ParallelBehaviour.WHEN_ALL);
		beh.addSubBehaviour( new OneShotBehaviour()
		{
			public void action() 
			{
				System.out.println( "Pierwszy krok" );
			}
		});

		beh.addSubBehaviour( new OneShotBehaviour()
		{
			public void action()
			{
				System.out.println( "Drugi krok" );
			}
		});
		
		beh.addSubBehaviour( new OneShotBehaviour()
		{
			public void action() 
			{
				System.out.println( "Trzeci krok" );
				//
			}
		});
		addBehaviour( beh );
		//removeBehaviour(beh);
	}
}