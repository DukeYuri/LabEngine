package com.labengine.tools;

public class LEThread extends Thread {
	
	// //////////////////////////////////////////////////////////////
	// FIELDS
	// //////////////////////////////////////////////////////////////

	// //////////////////////////////////////////////////////////////
	// CONSTRUCTOR
	// //////////////////////////////////////////////////////////////
	
	public LEThread() {
		this.start();
	}

	// //////////////////////////////////////////////////////////////
	// GETTERS/SETTERS
	// //////////////////////////////////////////////////////////////

	// //////////////////////////////////////////////////////////////
	// METHODS
	// //////////////////////////////////////////////////////////////
	
	public void Init() {
		
	}
	
	@Override
	public void run() {
			Init();
	}

}
