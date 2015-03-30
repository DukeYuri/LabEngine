package com.labengine.tools.primitive;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.labengine.engine.LEBasic;
import com.labengine.engine.LEEntity;

/**
 * 
 * @author DukeYuri
 * @version 0.1
 * 
 */

public class LERect extends LEEntity {
	
	////////////////////////////////////////////////////////////////
	// FIELDS                                                     //
	////////////////////////////////////////////////////////////////

	LEPoint TopLeft, BottRight, TopRight, BottLeft;

	LELine[] Lines = new LELine[4];
	
	////////////////////////////////////////////////////////////////
	// CONSTRUCTOR                                                //
	////////////////////////////////////////////////////////////////
	
	public LERect(LEPoint p1, LEPoint p2) {
		this.TopLeft = p1;
		this.BottRight = p2;
		refreshLines();
		this.type = LEBasic.TYPE_RECT;
	}

	public LERect(int x1, int y1, int x2, int y2) {
		this.TopLeft = new LEPoint(x1, y1);
		this.BottRight = new LEPoint(x1, y1);
		refreshLines();
		this.type = LEBasic.TYPE_RECT;
	}

	public LERect(float x1, float y1, float x2, float y2) {
		this.TopLeft = new LEPoint(x1, y1);
		this.BottRight = new LEPoint(x1, y1);
		refreshLines();
		this.type = LEBasic.TYPE_RECT;
	}
	
	////////////////////////////////////////////////////////////////
	// GETTERS/SETTERS                                            //
	////////////////////////////////////////////////////////////////
	
	public LELine[] getLines() {
		return Lines;
	}
	
	////////////////////////////////////////////////////////////////
	// METHODS                                                    //
	////////////////////////////////////////////////////////////////

	public void refreshLines() {
		this.TopRight = new LEPoint(this.BottRight.x, this.TopLeft.y);
		this.BottLeft = new LEPoint(this.TopLeft.x, this.BottRight.y);
		this.Lines[0] = new LELine(this.TopLeft, this.TopRight);
		this.Lines[1] = new LELine(this.TopRight, this.BottRight);
		this.Lines[2] = new LELine(this.BottRight, this.BottLeft);
		this.Lines[3] = new LELine(this.BottLeft, this.TopLeft);
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		TopLeft.update();
		BottRight.update();
		TopRight.update();
		BottLeft.update();
		this.refreshLines();
	}

	@Override
	public boolean isSelected(float x, float y) {
		if (x > TopLeft.x && x < TopRight.x && y > TopLeft.y && y < BottRight.y)
			return false;
		else
			return true;
	}

	@Override
	public void draw(Canvas c, Paint p) {
		for (LELine l : Lines)
		{
			l.draw(c, p);
		}
		
	}

}