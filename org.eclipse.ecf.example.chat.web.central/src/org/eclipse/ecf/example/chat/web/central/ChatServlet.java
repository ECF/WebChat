/*******************************************************************************
 * Copyright (c) 2013 Markus Alexander Kuppe and others. All rights reserved. 
 * This program and the accompanying materials are made available under the terms 
 * of the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Markus Alexander Kuppe - initial API and implementation
 ******************************************************************************/
package org.eclipse.ecf.example.chat.web.central;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.ecf.example.chat.model.ChatMessage;
import org.eclipse.ecf.example.chat.model.IChatServer;

@SuppressWarnings("serial")
public class ChatServlet extends HttpServlet {

	private volatile IChatServer chatServer;

	public void setChatServer(IChatServer cs) {
		System.out.println("Bound IChatServer");
		this.chatServer = cs;
	}
	
	public void unsetChatServer(IChatServer cs) {
		System.out.println("Unbound IChatServer");
		this.chatServer = null;
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		final IChatServer cs = this.chatServer;
		
		if (cs != null) {
			
			final String nick = req.getParameter("nick");
			final String msg = req.getParameter("msg");
			
			if (nick != null && msg != null) {
				cs.post(new ChatMessage(msg, nick));
				
				resp.setStatus(HttpServletResponse.SC_OK);
				return;
		
			} else {
				// Bad client request (no parameters provided) 
				resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			}
			
		// No ChatService, thus cannot work
		} else {
			resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
	}
}
