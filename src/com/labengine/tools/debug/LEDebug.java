package com.labengine.tools.debug;

import android.content.Context;
import android.widget.Toast;

import com.labengine.ui.activity.LEBaseGameActivity;

public class LEDebug {

	// //////////////////////////////////////////////////////////////
	// FIELDS
	// //////////////////////////////////////////////////////////////
	
	public static boolean debugMode = false;

	// //////////////////////////////////////////////////////////////
	// CONSTRUCTOR
	// //////////////////////////////////////////////////////////////

	// //////////////////////////////////////////////////////////////
	// GETTERS/SETTERS
	// //////////////////////////////////////////////////////////////
	
	public static void setDebugMode(boolean debugMode) {
		LEDebug.debugMode = debugMode;
	}

	// //////////////////////////////////////////////////////////////
	// METHODS
	// //////////////////////////////////////////////////////////////

	public static void makeDebugToast(String txt) {
		Toast toast = Toast.makeText(LEBaseGameActivity.context, txt, Toast.LENGTH_SHORT);
		toast.show();
	}
	
	public static void makeDebugToast(String txt, Context c) {
		Toast toast = Toast.makeText(c, txt, Toast.LENGTH_SHORT);
		toast.show();
	}

	
}
