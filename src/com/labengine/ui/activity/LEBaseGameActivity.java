package com.labengine.ui.activity;

import android.app.Activity;
import android.os.Bundle;

/**
 * 
 * @author DukeYuri
 * @version 0.1
 * 
 */

public abstract class LEBaseGameActivity extends Activity{
	
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
	// METHODS                                                    //
	////////////////////////////////////////////////////////////////
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		onLoadEngine();
		onLoadResource();
	}
	
	@Override
	public void onStart() {
		super.onStart();
		onLoadScene();
	}
	
	@Override
	public void onPause() {
		super.onPause();
		onPauseEngine();
	}
	
	public abstract void onLoadEngine();
	public abstract void onLoadResource();
	public abstract void onLoadScene();
	public abstract void onPauseEngine();
}
