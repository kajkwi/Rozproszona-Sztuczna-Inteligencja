
//package examples.hello;

import jade.core.Agent;

public class z9 extends Agent
{

  protected void setup()
  {
	Object[] obj = getArguments();
	int ilosc = Integer.parseInt(obj[0].toString());
	System.out.println("Argument: "+ilosc);
	for(int i=0;i<ilosc;i++)
	System.out.println("Hello! I am "+getLocalName());
  	
  } 
}

