
import jade.core.behaviours.CyclicBehaviour;
import jade.core.Agent;

public class klasa_3 extends Agent
{

  protected void setup()
  {
  	System.out.println("Startuje!");
  	addBehaviour(new CyclicBehaviour()
	 {
		public void action()
		{
			System.out.println("Repeat!");
		}
	});

	//System.out.println("Zaraz sie usune!");
  	//doDelete();
  } 
}

