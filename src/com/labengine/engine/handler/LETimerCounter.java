package com.labengine.engine.handler;

import java.util.TimerTask;

import com.labengine.engine.LESettings;

public class LETimerCounter extends TimerTask {

	// //////////////////////////////////////////////////////////////
	// FIELDS
	// //////////////////////////////////////////////////////////////

	// //////////////////////////////////////////////////////////////
	// CONSTRUCTOR
	// //////////////////////////////////////////////////////////////

	// //////////////////////////////////////////////////////////////
	// GETTERS/SETTERS
	// //////////////////////////////////////////////////////////////

	// //////////////////////////////////////////////////////////////
	// METHODS
	// //////////////////////////////////////////////////////////////

	@Override
	public void run() {
		LESettings.timeCounter++;
	}

}
