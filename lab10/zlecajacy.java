
import java.util.Random;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.FSMBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.TickerBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.SearchConstraints;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class zlecajacy extends Agent
{
	    zlecajacy myAgent;
		//Random generator;
		//Integer num;
		
	protected void setup() 
	{
		myAgent = this;
		Random generator = new Random();
		int num;
	
		num = (int)(Math.round(generator.nextDouble()*100));
		System.out.println("Wylosowano liczbe: "+num);
				
		addBehaviour(new TickerBehaviour(this, 2000)
		{
		    protected void onTick() 
			{
				System.out.println("Szukam serwisu POTEGA");
		    	  
		        DFAgentDescription dfd = new DFAgentDescription();
		        ServiceDescription sd = new ServiceDescription();
		        sd.setType("POTEGA");
		        dfd.addServices(sd);
				  
		        SearchConstraints ALL = new SearchConstraints();
		        //ALL.setMaxResults(new Long(10));
				
				try
		        {
		            DFAgentDescription[] result = DFService.search(myAgent, dfd, ALL);
		            System.out.println("Znaleziono: "+result.length);
		            if(result.length>0) 
					{
						System.out.println("Wysylanie liczby");
						ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
						msg.addReceiver(result[0].getName());
						msg.setContent(Integer.toString(num));
						send(msg);
						
						ACLMessage msg2 = blockingReceive(MessageTemplate.MatchPerformative(ACLMessage.INFORM));
						if(msg2!=null)
						{
							System.out.println("Odebrano wiadomosc z wynikiem: "+msg2.getContent());						
							myAgent.doDelete();
						}
						else 
						{
							block();
						}
					}
				}
		        catch (FIPAException fe) { System.out.println("Blad u zlecajacego"); }
			}
		 });
	}
	
	
	protected void takeDown() 
	{
		System.out.println("Zlecajacy sie usuwa");
	}
}