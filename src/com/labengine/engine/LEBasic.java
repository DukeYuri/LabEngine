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
	// FIELDS                                                     //
	////////////////////////////////////////////////////////////////

	/**
	 * Indicates the type of object class LEBasic
	 */
	public int type;

	/**
	 * Type point
	 */
	public static final int TYPE_POINT = 1;
	/**
	 * Type line
	 */
	public static final int TYPE_LINE = 2;
	/**
	 * Type polyline
	 */
	public static final int TYPE_POLYLINE = 3;
	/**
	 * Type rectangle
	 */
	public static final int TYPE_RECT = 4;
	/**
	 * Type circle
	 */
	public static final int TYPE_CIRCLE = 5;
	/**
	 * Type simple sprite
	 */
	public static final int TYPE_SIMPLESPRITE = 6;
	/**
	 * Type text
	 */
	public static final int TYPE_TEXT = 7;
	
	////////////////////////////////////////////////////////////////
	// CONSTRUCTOR                                                //
	////////////////////////////////////////////////////////////////
	
	////////////////////////////////////////////////////////////////
	// GETTERS/SETTERS                                            //
	////////////////////////////////////////////////////////////////
	
	////////////////////////////////////////////////////////////////
	// METHODS                                                    //
	////////////////////////////////////////////////////////////////

	public abstract void update();

	/**
	 * Checks if a point in any of the primitives
	 *
	 * @param f
	 *            - the x-coordinate
	 * @param g
	 *            - the y-coordinate
	 * @return returns true if it does and false if it is not
	 */
	public abstract boolean isSelected(float f, float g);

	/**
	 * Drawing method
	 * 
	 * @param c
	 *            - the canvas for drawing
	 * @param p
	 *            - the paint for drawing
	 */
	public abstract void draw(Canvas c, Paint p);
}
