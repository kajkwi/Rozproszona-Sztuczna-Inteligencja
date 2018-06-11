import jade.core.Agent;
import jade.core.behaviours.*;

import jade.domain.AMSService;
import jade.domain.FIPAAgentManagement.*;

import jade.lang.acl.*;
import java.util.Random;
import jade.core.AID;

public class ag_wys_odb extends Agent
{
	protected void setup()
	{
		System.out.println("Agent wys odb START");
		addBehaviour(new Beh1());
		addBehaviour(new Beh2());
		
	}
	
	private class Beh1 extends OneShotBehaviour
	{
		public void action()
		{
			//Random generator = new Random();
			int i = (int)(Math.random()*2);
	
			
			if (i==0)
			{
				
				ACLMessage msg = new ACLMessage( ACLMessage.CFP );
				msg.setContent( "Info dla Ali" );
				msg.addReceiver(new AID("Ala",false) );
				send(msg);
			}
			else
			{
				ACLMessage msg = new ACLMessage( ACLMessage.REQUEST );
				msg.setContent( "Info dla Ali" );
				msg.addReceiver(new AID("Ala",false) );
				send(msg);
			}
		}
	}
	
	private class Beh2 extends CyclicBehaviour
	{
		public void action()
		{

			ACLMessage msg = receive();
			if (msg != null)
			{
				System.out.println(msg.getContent());
				if(msg.getPerformative() == ACLMessage.INFORM)
				{
					System.out.println("Usuwam!");
					this.myAgent.doDelete();
				}
				else
				{
					this.myAgent.addBehaviour(new Beh1());
				}
				
				
			}
			//block();
			
		}
	}
		
}