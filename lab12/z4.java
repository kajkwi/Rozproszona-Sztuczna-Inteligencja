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

public class z4 extends Agent {

  public void setup() {

    getContentManager().registerLanguage(new jade.content.lang.sl.SLCodec(0));
    getContentManager().registerOntology(JADEManagementOntology.getInstance());


	/*
	jade.core.Runtime runtime = jade.core.Runtime.instance();
	Profile profile = new ProfileImpl();
	profile.setParameter(Profile.CONTAINER_NAME,"TestContainer1");
	System.out.println("<ContainerAgent> Created container TestContainer1");
	profile.setParameter(Profile.MAIN_HOST,"localhost");
	ContainerController container = runtime.createAgentContainer(profile);

	profile.setParameter(Profile.CONTAINER_NAME,"TestContainer2");
	System.out.println("<ContainerAgent> Created container TestContainer2");
	ContainerController cotainer2 = runtime.createAgentContainer(profile);
	*/
	

    //sprawdzanie containerow
    addBehaviour(new TickerBehaviour(this, 5000) {//5 sekund zamiast 20
      protected void onTick()
	  {
		//pytanie o containery
		QueryPlatformLocationsAction query = new QueryPlatformLocationsAction();
		Action action = new Action(getAID(),query);
		
		try
		{
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
		
			System.out.println("Znalezione containery: ");
			while(iter.hasNext())
			{

				ContainerID next = (ContainerID) iter.next();
				System.out.println("	" + next.getName());	

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
