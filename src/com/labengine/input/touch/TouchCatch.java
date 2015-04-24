package com.labengine.input.touch;

import android.view.MotionEvent;

/**
 * 
 * @author DukeYuri
 * @version 0.1
 * 
 */

public class TouchCatch {
	
	////////////////////////////////////////////////////////////////
	// FIELDS                                                     //
	////////////////////////////////////////////////////////////////
	
	public static final int ACTION_CANCEL = MotionEvent.ACTION_CANCEL;
	public static final int ACTION_DOWN = MotionEvent.ACTION_DOWN;
	public static final int ACTION_MOVE = MotionEvent.ACTION_MOVE;
	public static final int ACTION_OUTSIDE = MotionEvent.ACTION_OUTSIDE;
	public static final int ACTION_UP = MotionEvent.ACTION_UP;
	
	protected int curAction;

	// //////////////////////////////////////////////////////////////
	// CONSTRUCTOR
	// //////////////////////////////////////////////////////////////

	// //////////////////////////////////////////////////////////////
	// GETTERS/SETTERS
	// //////////////////////////////////////////////////////////////
	
	public int getAction() {
		return this.curAction;
	}

	// //////////////////////////////////////////////////////////////
	// METHODS
	// //////////////////////////////////////////////////////////////
	
	public boolean isActionCancel() {
		return this.curAction == ACTION_CANCEL;
	}
	
	public boolean isActionDown() {
		return this.curAction == ACTION_DOWN;
	}
	
	public boolean isActionMove() {
		return this.curAction == ACTION_MOVE;
	}
	
	public boolean isActionOutside() {
		return this.curAction == ACTION_OUTSIDE;
	}
	
	public boolean isActionUp() {
		return this.curAction == ACTION_UP;
	}
}
