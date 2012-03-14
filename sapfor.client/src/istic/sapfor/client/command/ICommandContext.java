package istic.sapfor.client.command;

import java.util.List;

public interface ICommandContext {

	public String get(ICommandContextKey key);
	public List<String> getList(ICommandContextKey key);
}
