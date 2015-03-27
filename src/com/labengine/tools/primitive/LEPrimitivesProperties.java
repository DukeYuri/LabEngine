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

public class LEPrimitivesProperties extends LEBasic{
	
	////////////////////////////////////////////////////////////////
	// FIELDS                                                     //
	////////////////////////////////////////////////////////////////	
	
	private Paint p;
	private int color;
	
	////////////////////////////////////////////////////////////////
	// CONSTRUCTOR                                                //
	////////////////////////////////////////////////////////////////
	
	////////////////////////////////////////////////////////////////
	// GETTERS/SETTERS                                            //
	////////////////////////////////////////////////////////////////
	
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
	
	////////////////////////////////////////////////////////////////
	// METHODS                                                    //
	////////////////////////////////////////////////////////////////

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
