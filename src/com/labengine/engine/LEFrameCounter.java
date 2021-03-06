package com.labengine.engine;

import java.util.TimerTask;

/**
 * 
 * @author DukeYuri
 * @version 0.1
 * 
 */

public class LEFrameCounter extends TimerTask {
	
	////////////////////////////////////////////////////////////////
	// FIELDS                                                     //
	////////////////////////////////////////////////////////////////
	
	////////////////////////////////////////////////////////////////
	// CONSTRUCTOR                                                //
	////////////////////////////////////////////////////////////////
	
	////////////////////////////////////////////////////////////////
	// GETTERS/SETTERS                                            //
	////////////////////////////////////////////////////////////////
	
	////////////////////////////////////////////////////////////////
	// METHODS FROM SuperClass/Interfaces                         // 
	////////////////////////////////////////////////////////////////
	
	@Override
	public void run() {
		LESettings.realFrameRate = LESettings.frameCounter;
		LESettings.frameCounter = 0;
	}
	
	////////////////////////////////////////////////////////////////
	// METHODS                                                    //
	////////////////////////////////////////////////////////////////

}
