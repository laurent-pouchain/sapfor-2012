package istic.sapfor.client.command.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import istic.sapfor.client.command.ICommandContext;
import istic.sapfor.client.command.ICommandContextKey;

public class DefaultCommandContext implements ICommandContext{

	private Map<ICommandContextKey,String> contextMap = new HashMap<ICommandContextKey,String>();
	private Map<ICommandContextKey,List<String>> contextMapList = new HashMap<ICommandContextKey,List<String>>();
	private Map<ICommandContextKey,Map<Long, String>> contextMapHash = new HashMap<ICommandContextKey,Map<Long, String>>();
	private long idAgent;
	@Override
	public String get(ICommandContextKey key) {
		return contextMap.get(key);
	}
	@Override
	public List<String> getList(ICommandContextKey key) {
		return contextMapList.get(key); 
	}
	
	public Map<Long, String> get(Object key) {
		return contextMapHash.get(key);
	}
	public Map<Long, String> put(ICommandContextKey key, Map<Long, String> value) {
		return contextMapHash.put(key, value);
	}
	public void put(ICommandContextKey key,String val){
		contextMap.put(key, val);
	}
	public void put(ICommandContextKey key,List<String> val){
		contextMapList.put(key, val);
	}
	@Override
	public long getIdAgent() {
		return idAgent;
	}
	@Override
	public void setIdAgent(long id) {
		idAgent=id;
		
	}

	//shared context
	
}
