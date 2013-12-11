/*******************************************************************************
 * Copyright (c) 2013 Markus Alexander Kuppe and others. All rights reserved. 
 * This program and the accompanying materials are made available under the terms 
 * of the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Markus Alexander Kuppe - initial API and implementation
 ******************************************************************************/
package org.eclipse.ecf.example.chat.web;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Dictionary;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.ecf.example.chat.model.ChatMessage;
import org.eclipse.ecf.example.chat.model.IChatMessage;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.remoteserviceadmin.RemoteConstants;

@SuppressWarnings("serial")
public class WebChatServlet extends HttpServlet {

	private final Dictionary<Object, Object> props;
	private final BundleContext bundleContext;
	
	private ServiceRegistration<IChatMessage> registerService;

	public WebChatServlet() {
		props = new Properties();
		props.put(RemoteConstants.SERVICE_EXPORTED_INTERFACES, "*");
		props.put(RemoteConstants.SERVICE_EXPORTED_CONFIGS, "ecf.generic.server");
		
		bundleContext = FrameworkUtil.getBundle(this.getClass()).getBundleContext();
	}
	
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	protected synchronized void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		// Get call parameters
		final String nick = req.getParameter("nick");
		final String msg = req.getParameter("msg");
		
		
		// De-register old and register new chat message
		if (registerService != null) {
			registerService.unregister();
		}
		
		registerService = bundleContext
				.registerService(IChatMessage.class, new ChatMessage(msg,
						nick), (Dictionary) props);
		
		
		// Response
		ServletOutputStream outs = resp.getOutputStream();
		outs.write(registerService.toString()
				.getBytes(Charset.forName("UTF-8")));
	}
}
