package istic.sapfor.client.command.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import istic.sapfor.client.command.ICommandContext;
import istic.sapfor.client.command.ICommandContextKey;

public class DefaultCommandContext implements ICommandContext{

	private Map<ICommandContextKey,String> contextMap = new HashMap<ICommandContextKey,String>();
	private Map<ICommandContextKey,List<String>> contextMapList = new HashMap<ICommandContextKey,List<String>>();
	
	@Override
	public String get(ICommandContextKey key) {
		return contextMap.get(key);
	}
	@Override
	public List<String> getList(ICommandContextKey key) {
		return contextMapList.get(key); 
	}
	
	public void put(ICommandContextKey key,String val){
		contextMap.put(key, val);
	}
	public void put(ICommandContextKey key,List<String> val){
		contextMapList.put(key, val);
	}

	
}
