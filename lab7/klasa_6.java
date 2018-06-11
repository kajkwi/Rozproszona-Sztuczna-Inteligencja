import jade.core.Agent;
import java.util.Scanner;
import jade.core.behaviours.SimpleBehaviour;

public class klasa_6 extends Agent
{

  protected void setup()
  {
  	System.out.println("Startuje!");
  	
	addBehaviour(new Behaviour123());
	//System.out.println("Zaraz sie usune!");
  	//doDelete();
  } 
}

class Behaviour123 extends SimpleBehaviour
{

	boolean koniec = false;

	public void action()
	{
		System.out.println("Zachowanie - start!");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Podaj liczbe: ");
		int liczba = scanner.nextInt();
		if(liczba < 0)
		{
			System.out.println("Delete!");
			koniec  = true;
		}
	}
		
	
	public boolean done()
	{
		if(koniec)
			System.out.println("Zachowanie - stop!");
		return koniec;
	}
}