package istic.sapfor.client.command;

import java.util.List;
import java.util.Map;

public interface ICommandContext {

	
	public String get(ICommandContextKey key);
	public List<String> getList(ICommandContextKey key);
	public Map<Long, String> getMap(ICommandContextKey key);
	public long getIdAgent();
	public void setIdAgent(long id);
}
