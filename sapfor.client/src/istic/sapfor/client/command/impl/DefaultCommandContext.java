package istic.sapfor.client.command.impl;

import java.util.HashMap;
import java.util.Map;

import istic.sapfor.client.command.ICommandContext;
import istic.sapfor.client.command.ICommandContextKey;

public class DefaultCommandContext implements ICommandContext{

	private Map<ICommandContextKey,String> contextMap = new HashMap<ICommandContextKey,String>();
	
	@Override
	public String get(ICommandContextKey key) {
		return contextMap.get(key);
	}
	
	public void put(ICommandContextKey key,String val){
		contextMap.put(key, val);
	}

}
