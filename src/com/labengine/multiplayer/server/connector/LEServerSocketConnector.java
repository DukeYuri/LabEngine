package com.labengine.multiplayer.server.connector;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import android.util.Log;

/**
 * 
 * @author DukeYuri
 * @version 0.1
 * 
 */

public class LEServerSocketConnector extends Thread {

	// //////////////////////////////////////////////////////////////
	// FIELDS
	// //////////////////////////////////////////////////////////////

	private int port;

	protected BufferedReader dataInputStream;
	protected PrintWriter dataOutputStream;

	ServerSocket server;
	Socket s;

	// //////////////////////////////////////////////////////////////
	// CONSTRUCTOR
	// //////////////////////////////////////////////////////////////

	public LEServerSocketConnector(int port, String ip) throws Exception {
		this.port = port;
		server = new ServerSocket(this.port);
	}

	// //////////////////////////////////////////////////////////////
	// GETTERS/SETTERS
	// //////////////////////////////////////////////////////////////
	

	// //////////////////////////////////////////////////////////////
	// METHODS
	// //////////////////////////////////////////////////////////////

	@Override
	public void run() {
		try {
			s = server.accept();
			dataInputStream = new BufferedReader(new InputStreamReader(
					s.getInputStream()));
			while(dataInputStream.readLine() != null) {
				//String mess = dataInputStream.readLine();
			}
		} catch (Exception e) {
			Log.e("LEServerSocketConnector", e.toString());
		}
	}

}
