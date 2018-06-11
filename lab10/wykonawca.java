

import jade.core.Agent;
import jade.core.AID;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPANames;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAAgentManagement.Property;
import jade.core.behaviours.CyclicBehaviour;

import jade.domain.AMSService;
import jade.domain.FIPAAgentManagement.*;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class wykonawca extends Agent 
{


  DFAgentDescription dfd;
  ServiceDescription sd;
  protected void setup() 
  {
	
  	//String serviceName = "SuperSerwis";
  	
  	
  	// Register the service
  	//System.out.println("Agent "+getLocalName()+" registering service \""+serviceName+"\" of type \"weather-forecast\"");
  	try {
  		dfd = new DFAgentDescription();
	    dfd.setName( getAID() ); 
	    sd  = new ServiceDescription();
	    sd.setType( "POTEGA" );
	    sd.setName( getLocalName() );
	    dfd.addServices(sd);
	         
	    DFService.register(this, dfd );  
	    
  	}
  	catch (FIPAException fe) {
  		fe.printStackTrace();
  	}
	
	MessageTemplate mt = MessageTemplate.MatchPerformative( ACLMessage.REQUEST);//szablon odbioru
	//zachowanie liczace potege
	addBehaviour( new CyclicBehaviour()
	{
		public void action() 
		{
			
			ACLMessage msg = blockingReceive(mt);
			//System.out.println("\t test");
			if(msg!=null)
			{
				System.out.println("Odebrano wiadomosc REQUEST: "+msg.getContent());
				Double number = Double.parseDouble(msg.getContent());
				
				if(number != null)
				{
					System.out.println("Wczytana liczba: " + (number));
					number=number*number;
					AID sender = msg.getSender();
				
					ACLMessage reply = msg.createReply();
					reply.setPerformative( ACLMessage.INFORM );
					reply.setContent(Double.toString(number));
					send(reply);
					
					doDelete();
					}
			}
			else
			{
				//System.out.println("\t test2");
				//block();
			}
		}
	});
  } 
  
  protected void takeDown()
	{
		try 
		{
			DFService.deregister(this); 
			System.out.println("Wykonawca sie usuwa");
		}
          catch (Exception e) {}
	}
}

