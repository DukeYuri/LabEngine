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

public class LELine extends LEBasic {
	
	////////////////////////////////////////////////////////////////
	// FIELDS                                                     //
	////////////////////////////////////////////////////////////////

	private LEPoint p1, p2; 
	
	////////////////////////////////////////////////////////////////
	// CONSTRUCTOR                                                //
	////////////////////////////////////////////////////////////////

	public LELine(int x1, int y1, int x2, int y2) {
		p1 = new LEPoint(x1, y1);
		p2 = new LEPoint(x2, y2);
		this.type = LEBasic.TYPE_LINE;
	}

	public LELine(float x1, float y1, float x2, float y2) {
		p1 = new LEPoint(x1, y1);
		p2 = new LEPoint(x2, y2);
		this.type = LEBasic.TYPE_LINE;
	}

	public LELine(LEPoint p1, LEPoint p2) {
		this.p1 = p1;
		this.p2 = p2;
		this.type = LEBasic.TYPE_LINE;
	}
	
	////////////////////////////////////////////////////////////////
	// GETTERS/SETTERS                                            //
	////////////////////////////////////////////////////////////////

	public LEPoint getP1() {
		return p1;
	}

	public void setP1(LEPoint p1) {
		this.p1 = p1;
	}

	public LEPoint getP2() {
		return p2;
	}

	public void setP2(LEPoint p2) {
		this.p2 = p2;
	}
	
	////////////////////////////////////////////////////////////////
	// METHODS                                                    //
	////////////////////////////////////////////////////////////////

	@Override
	public void update() {
		p1.update();
		p2.update();
	}

	@Override
	public boolean isSelected(float x, float y) {
		return false;
	}

	@Override
	public void draw(Canvas c, Paint p) {
		c.drawLine(p1.x, p1.y, p2.x, p2.y, p);

	}

}