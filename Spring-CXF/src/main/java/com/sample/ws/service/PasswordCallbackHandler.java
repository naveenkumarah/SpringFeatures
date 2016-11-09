package com.sample.ws.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.wss4j.common.ext.WSPasswordCallback;

public class PasswordCallbackHandler implements CallbackHandler
{
	   private Map<String, String> passwords = new HashMap<String, String>();
	   protected final Log logger = LogFactory.getLog(getClass());
	   public PasswordCallbackHandler()
	   {
	      passwords.put("alice", "password");
	      passwords.put("bob", "password");
	   }
	 
	   public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException
	   {
	      for (int i = 0; i < callbacks.length; i++)
	      {
	         WSPasswordCallback pc = (WSPasswordCallback)callbacks[i];
	         
	         int usage = pc.getUsage();
	         logger.debug("identifier: " + pc.getIdentifier());
	         logger.debug("usage: " + pc.getUsage());

	         if (usage == WSPasswordCallback.USERNAME_TOKEN) {
	        	 String pass = passwords.get(pc.getIdentifier());
		         if (pass != null)
		         {
		            pc.setPassword(pass);
		            return;
		         }
	         }else if (usage == WSPasswordCallback.SIGNATURE) {
	        	 
	         }
	        	 
	         
	         
	      }
	   }
	 
	   public void setAliasPassword(String alias, String password)
	   {
	      passwords.put(alias, password);
	   }


}
