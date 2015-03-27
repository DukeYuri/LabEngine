package com.labengine.tools.primitive;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.labengine.engine.LEBasic;

/**
 * 
 * @author DukeYuri
 * @version 0.1
 * 
 */

public class LEPoint extends LEBasic {
	
	////////////////////////////////////////////////////////////////
	// FIELDS                                                     //
	////////////////////////////////////////////////////////////////

	public float x, y; 

	float axX = 1, axY = 1; 
	
	float dx = 0, dy = 0;
	
	////////////////////////////////////////////////////////////////
	// CONSTRUCTOR                                                //
	////////////////////////////////////////////////////////////////

	public LEPoint(int x, int y) { 
		this.x = x; //
		this.y = y;
		this.type = LEBasic.TYPE_POINT;
	}

	public LEPoint(float x, float y) {
		this.x = x;
		this.y = y;
		this.type = LEBasic.TYPE_POINT;
	}
	
	////////////////////////////////////////////////////////////////
	// GETTERS/SETTERS                                            //
	////////////////////////////////////////////////////////////////

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getAxX() {
		return axX;
	}

	public void setAxX(float axX) {
		this.axX = axX;
	}

	public float getAxY() {
		return axY;
	}

	public void setAxY(float axY) {
		this.axY = axY;
	}

	public float getDx() {
		return dx;
	}

	public void setDx(float dx) {
		this.dx = dx;
	}

	public float getDy() {
		return dy;
	}

	public void setDy(float dy) {
		this.dy = dy;
	}
	
	////////////////////////////////////////////////////////////////
	// METHODS                                                    //
	////////////////////////////////////////////////////////////////

	@Override
	public void update() {
		this.x = this.dx + this.x;
		this.y = this.dy + this.y;
		this.dx = this.dx * this.axX;
		this.dy = this.dy * this.axY;
	}
	
	@Override
	public boolean isSelected(float x, float y) {
		if (this.x == x && this.y == y)
			return true;
		else
			return false;
	}

	@Override
	public void draw(Canvas c, Paint p) {
		c.drawPoint(x, y, p);

	}

}