import jade.core.Agent;
import jade.core.behaviours.Behaviour;

public class klasa_4 extends Agent
{

  protected void setup()
  {
  	System.out.println("Startuje!");
  	
	addBehaviour(new Behaviour123());

	//System.out.println("Zaraz sie usune!");
  	//doDelete();
  } 
}


class Behaviour123 extends Behaviour
{
	private int krok = 0;
	public void action() 
	{
		switch (krok) 
		{
		 	case 0:
		 		System.out.println("Krok 1");
		 		krok++;
		 		break;
		 	case 1:
		 		System.out.println("Krok 2");
		 		krok++;
		 		break;
		 	case 2:
		 		System.out.println("Krok 3");
		 		krok++;
		 		break;
	 	}
	}
	 
	 
	public boolean done()
	{
		 return krok == 3;
	}
}