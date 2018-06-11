import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.OneShotBehaviour;

public class klasa_7 extends Agent
{

  protected void setup()
  {
  	System.out.println("Startuje!");
  	
	addBehaviour(new Behaviour2(this));
	addBehaviour(new Behaviour1(this));

	//System.out.println("Zaraz sie usune!");
  	//doDelete();
  } 
}

class Behaviour2 extends OneShotBehaviour
{
    public Behaviour2(Agent a)
    {
        super(a);
	
    }

    public void action()
    {
        
	System.out.println("Pierwsze");
    }

}

class Behaviour3 extends OneShotBehaviour
{
    public Behaviour3(Agent a)
    {
        super(a);
	
    }

    public void action()
    {
        
	System.out.println("Drugie");
    }

}

class Behaviour1 extends Behaviour
{
	
	private int krok = 0;
	Agent tmp;

	public Behaviour1(Agent a)
	{
		super(a);
		tmp = a;
	}

	public void action() 
	{
		
		switch (krok) 
		{
		 	case 0:
				tmp.addBehaviour(new Behaviour3(tmp));
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