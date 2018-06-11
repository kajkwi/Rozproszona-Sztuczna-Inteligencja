import jade.core.*;
import jade.core.behaviours.*;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.proto.AchieveREInitiator;
import jade.util.leap.Iterator;
import jade.util.leap.List;
import jade.wrapper.ContainerController;
import jade.domain.*;
import jade.domain.JADEAgentManagement.*;
import jade.domain.mobility.MobileAgentDescription;
import jade.domain.mobility.MobilityOntology;
import jade.domain.mobility.MoveAction;
import jade.content.ContentElement;
import jade.content.lang.Codec.CodecException;
import jade.content.onto.OntologyException;
import jade.content.onto.UngroundedException;
import jade.content.onto.basic.*;
import java.util.Random;

public class z5 extends Agent {
  Random random;
  int nr ;
  public void setup() {
	  
	random = new Random();
    nr = 0;


    //sprawdzanie containerow
    addBehaviour(new TickerBehaviour(this, 5000) {//5 sekund zamiast 20
      protected void onTick()
	  {
		
		getContentManager().registerLanguage(new jade.content.lang.sl.SLCodec(0));
		getContentManager().registerOntology(JADEManagementOntology.getInstance());
		//pytanie o containery
		QueryPlatformLocationsAction query = new QueryPlatformLocationsAction();
		Action action = new Action(getAID(),query);
		
		try
		{
			nr++;
			ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
			msg.addReceiver(getAMS());
			msg.setLanguage(FIPANames.ContentLanguage.FIPA_SL0);
			msg.setOntology(JADEManagementOntology.getInstance().getName());
			getContentManager().fillContent(msg, action);
			send(msg);
		}
        catch(CodecException e)
		{
			e.printStackTrace();
		}
		catch(OntologyException e)
		{
			e.printStackTrace();
		}
		
		
		//odbieranie 
		try
		{
			ACLMessage rec = blockingReceive(MessageTemplate.MatchSender(getAMS()));
			ContentElement content = getContentManager().extractContent(rec);
			Result res = (Result) content;
			List listOfPlatforms = (List) res.getValue();
		
			Iterator iter = listOfPlatforms.iterator();
			
			//int rand = (int)Math.round(random.nextDouble()*listOfPlatforms.size()); //losowanie nr
			int rand = random.nextInt((int)listOfPlatforms.size()) +1;
			int x=0;
			System.out.println("Znalezione containery po raz "+nr+":");
			while(iter.hasNext())
			{
				x++;
				ContainerID next = (ContainerID) iter.next();
				System.out.println("	" + next.getName());	

				if(x == rand)
				{
					doMove(next);
					System.out.println("	^tutaj agent sie przenosi");
				}
				
			}
		}
		catch(UngroundedException e)
		{
			e.printStackTrace();
		}
		catch(CodecException e)
		{
			e.printStackTrace();
		}
		catch(OntologyException e)
		{
			e.printStackTrace();
		}
      }
    });
  }
  
}
