package istic.sapfor.client.command.impl;

import istic.sapfor.client.command.ICommandContext;

public abstract class ContextAbstract {
	protected ICommandContext context = null;

	public void setContext(ICommandContext context) {
		this.context = context;
	}
}
