import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.SequentialBehaviour;
import jade.core.Agent;

public class klasa_2_4 extends Agent
{
	protected void setup() 
	{
		
		SequentialBehaviour beh = new SequentialBehaviour();
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