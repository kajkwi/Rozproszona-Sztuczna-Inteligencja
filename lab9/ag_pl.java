import jade.core.Agent;
import jade.core.behaviours.*;

import jade.domain.AMSService;
import jade.domain.FIPAAgentManagement.*;

import jade.lang.acl.*;
import java.util.Random;

public class ag_pl extends Agent
{
	protected void setup()
	{
		addBehaviour(new CyclicBehaviour(this)
		{
			public void action()
			{
				MessageTemplate m = MessageTemplate.MatchLanguage("polski");
				ACLMessage msg = receive(m);
				if(msg != null)
				{
					System.out.println(msg.getContent());
				}
				else
					block();
			}
		});
		
	}
		
}