package com.sample.ws.service;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.wss4j.common.ext.WSPasswordCallback;

public class PasswordCallbackHandlerTest implements CallbackHandler
{
	String userName="alice";
	String password="password";
	   protected final Log logger = LogFactory.getLog(getClass());
	   
	 
	   public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException
	   {
	      for (int i = 0; i < callbacks.length; i++)
	      {
	         WSPasswordCallback pc = (WSPasswordCallback)callbacks[i];
	         
	         int usage = pc.getUsage();
	         logger.debug("identifier: " + pc.getIdentifier());
	         logger.debug("usage: " + pc.getUsage());

	         if (usage == WSPasswordCallback.USERNAME_TOKEN) {
		        	 pc.setIdentifier(userName);
		            pc.setPassword(password);
		            return;
		         
	         }else if (usage == WSPasswordCallback.SIGNATURE) {
	        	 
	         }
	        	 
	         
	         
	      }
	   }


}
