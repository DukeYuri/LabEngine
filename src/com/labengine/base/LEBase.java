package com.labengine.base;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.labengine.engine.LEBasic;
import com.labengine.input.touch.TouchCatch;

/**
 * 
 * @author DukeYuri
 * @version 0.1
 * 
 */

public class LEBase extends LEBasic {

	// //////////////////////////////////////////////////////////////
	// FIELDS
	// //////////////////////////////////////////////////////////////

	private Paint p;

	private int color;

	public float x, y;

	private float axX = 1, axY = 1;

	private float dx = 0, dy = 0;

	private int width = 0, height = 0;

	public boolean show = true;

	// //////////////////////////////////////////////////////////////
	// CONSTRUCTOR
	// //////////////////////////////////////////////////////////////

	// //////////////////////////////////////////////////////////////
	// GETTERS/SETTERS
	// //////////////////////////////////////////////////////////////

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		if (this.p == null) {
			this.p = new Paint();
		}
		p.setColor(color);
	}

	public void setARGB(int a, int r, int g, int b) {
		if (this.p == null) {
			this.p = new Paint();
		}
		p.setARGB(a, r, g, b);
	}

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

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	// //////////////////////////////////////////////////////////////
	// METHODS
	// //////////////////////////////////////////////////////////////

	public boolean onTouched(TouchCatch touch, float pX, float pY) {
		return false;
	}

	public void show(boolean show) {
		this.show = show;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isSelected(float f, float g) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void draw(Canvas c, Paint p) {
		// TODO Auto-generated method stub

	}

}
