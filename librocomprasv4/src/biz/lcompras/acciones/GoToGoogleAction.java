package biz.lcompras.acciones;

import org.openxava.actions.*;
import org.openxava.controller.*;
import org.openxava.util.*;

public class GoToGoogleAction implements IForwardAction {

	@Override
	public void execute() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setErrors(Messages errors) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Messages getErrors() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMessages(Messages messages) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Messages getMessages() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setEnvironment(Environment environment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getForwardURI() {
		// TODO Auto-generated method stub
		return "http://www.google.com";
	}

	@Override
	public boolean inNewWindow() {
		// TODO Auto-generated method stub
		return false;
	}

}
