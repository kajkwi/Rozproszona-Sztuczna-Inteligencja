import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

public class klasa_2 extends Agent{

    protected void setup()
    {
        System.out.println("Startuje!");
        addBehaviour(new BehaviourOneShot(this));

        
        //System.out.println("Zaraz sie usune!");
        //doDelete();

    }

}
class BehaviourOneShot extends OneShotBehaviour
{
    public BehaviourOneShot(Agent a)
    {
        super(a);
	
    }

    public void action()
    {
        System.out.println( "Wykonuje!" );
    }


}