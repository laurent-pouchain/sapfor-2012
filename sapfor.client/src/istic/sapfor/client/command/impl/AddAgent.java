package istic.sapfor.client.command.impl;

import istic.sapfor.api.service.ServiceAgent;
import istic.sapfor.client.command.ICommand;
import istic.sapfor.client.command.ICommandContext;
import istic.sapfor.client.gui.IHMGStage;

public class AddAgent implements ICommand {
	 
		private ServiceAgent client;
		private IHMGStage ihmgstage ;
		private ICommandContext context;
	   
	    @Override
	    public Boolean execute(ICommandContext ctx) {
	       
return true;
	    }

	   
	    public ServiceAgent getClient() {
	        return client;
	    }

	    public void setClient(ServiceAgent client) {
	        this.client = client;
	    }

	  
	   
	   


	}

