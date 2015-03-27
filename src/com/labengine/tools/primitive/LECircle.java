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

public class LECircle extends LEBasic {
	
	////////////////////////////////////////////////////////////////
	// FIELDS                                                     //
	////////////////////////////////////////////////////////////////	

	LEPoint center;
	
	float radius;
	
	float arcStop;

	float arcStart;
	
	////////////////////////////////////////////////////////////////
	// CONSTRUCTOR                                                //
	////////////////////////////////////////////////////////////////

	LECircle(LEPoint p, float radius) {
		this.center = p;
		this.radius = radius;
		this.type = LEBasic.TYPE_CIRCLE;
	}

	LECircle(LEPoint p, int radius, int arcLen, int arcStart) {
		this.center = p;
		this.radius = radius;
		this.arcStop = arcLen;
		this.arcStart = arcStart;
		this.type = LEBasic.TYPE_CIRCLE;
	}

	LECircle(int x, int y, int radius) {
		this.center = new LEPoint(x, y);
		this.radius = radius;
		this.type = LEBasic.TYPE_CIRCLE;
	}

	LECircle(float x, float y, float radius) {
		this.center = new LEPoint(x, y);
		this.radius = radius;
		this.type = LEBasic.TYPE_CIRCLE;
	}
	
	////////////////////////////////////////////////////////////////
	// GETTERS/SETTERS                                            //
	////////////////////////////////////////////////////////////////
	
	////////////////////////////////////////////////////////////////
	// METHODS                                                    //
	////////////////////////////////////////////////////////////////

	@Override
	public void update() {
		center.update();
	}

	@Override
	public boolean isSelected(float x, float y) {
		if ((x - center.x) * (x - center.x) + (y - center.y) * (y - center.y) < radius
				* radius)
			return true;
		else
			return false;
	}

	@Override
	public void draw(Canvas c, Paint p) {
		c.drawCircle(center.x, center.y, radius, p);		
	}

}