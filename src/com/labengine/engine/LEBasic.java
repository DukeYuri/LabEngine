package com.labengine.engine;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 *
 * @author DukeYuri
 * @version 0.1 The base class of the engine. Specifies the type
 * 
 */

public abstract class LEBasic {
	
	////////////////////////////////////////////////////////////////
	// FIELDS                                                     
	////////////////////////////////////////////////////////////////

	public int type;
	
	public static final int TYPE_POINT = 1;
	
	public static final int TYPE_LINE = 2;

	public static final int TYPE_POLYLINE = 3;
	
	public static final int TYPE_RECT = 4;
	
	public static final int TYPE_CIRCLE = 5;
	
	public static final int TYPE_SIMPLESPRITE = 6;
	
	public static final int TYPE_TEXT = 7;
	
	////////////////////////////////////////////////////////////////
	// CONSTRUCTOR                                                
	////////////////////////////////////////////////////////////////
	
	////////////////////////////////////////////////////////////////
	// GETTERS/SETTERS                                            
	////////////////////////////////////////////////////////////////
	
	////////////////////////////////////////////////////////////////
	// METHODS                                                    
	////////////////////////////////////////////////////////////////

	public abstract void update();

	public abstract boolean isSelected(float x, float y);

	public abstract void draw(Canvas c, Paint p);
	
}
