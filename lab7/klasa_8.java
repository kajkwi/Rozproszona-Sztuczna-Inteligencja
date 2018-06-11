import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;

public class klasa_8 extends Agent
{

  protected void setup()
  {
  	System.out.println("Startuje!");
  	
	addBehaviour(new Beh1(this));
	
	Beh2 beh = new Beh2(this);
	addBehaviour(beh);


	addBehaviour(new TickerBehaviour(this,50000)
	{
		protected void onTick()
		{
			System.out.println("Usuwam zachowanie!");
			removeBehaviour(beh);
		}
	});
		
	addBehaviour(new TickerBehaviour(this,100000)
	{
		protected void onTick()
		{
			System.out.println("Usuwam agenta!");
			doDelete();
		}
		});
  } 
}


class Beh1 extends TickerBehaviour
{
	public Beh1(Agent a)
	{
		super(a, 2000);
	}

	protected void onTick()
	{
		System.out.println("Maly tick");
	}
}

class Beh2 extends TickerBehaviour
{
	public Beh2(Agent a)
	{
		super(a, 5000);
	}

	protected void onTick()
	{
		System.out.println("Duzy tick");
	}
}