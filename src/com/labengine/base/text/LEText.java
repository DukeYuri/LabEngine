package com.labengine.base.text;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.labengine.base.primitive.LEPoint;
import com.labengine.engine.LEBasic;

/**
 * 
 * @author DukeYuri
 * @version 0.1
 * 
 */

public class LEText extends LEPoint {
	
	////////////////////////////////////////////////////////////////
	// FIELDS                                                     
	////////////////////////////////////////////////////////////////

	private String textString;
	private int fontColor;
	private int fontSize;
	public Paint p = new Paint();
	
	////////////////////////////////////////////////////////////////
	// CONSTRUCTOR                                                
	////////////////////////////////////////////////////////////////

	public LEText(String text, float x, float y) {
		super(x, y);
		textString = text;
		this.type = LEBasic.TYPE_TEXT;
	}
	
	////////////////////////////////////////////////////////////////
	// GETTERS/SETTERS                                            
	////////////////////////////////////////////////////////////////

	public String getTextString() {
		return textString;
	}

	public void setTextString(String textString) {
		this.textString = textString;
	}

	public int getFontColor() {
		return fontColor;
	}

	public void setFontColor(int fontColor) {
		
	}

	public int getFontSize() {
		return fontSize;
	}

	public void setFontSize(int fontSize) {
		p.setTextSize(fontSize);
		this.fontSize = fontSize;
	}


	public void setFontShadow(int fontShadow) {
	
	}

	
	////////////////////////////////////////////////////////////////
	// METHODS                                                    
	////////////////////////////////////////////////////////////////
	
	@Override
	public boolean isSelected(float f, float g) {
		return false; 
	}

	@Override
	public void draw(Canvas c, Paint p) {
			p = this.p;
			c.drawText(this.textString, this.x, this.y, p);
		
	}

}
