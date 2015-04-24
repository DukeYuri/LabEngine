package com.labengine.base.primitive;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.labengine.base.LEBase;
import com.labengine.engine.LEBasic;
 
/**
 * 
 * @author DukeYuri
 * @version 0.1
 * 
 */

public class LEPolyLine extends LEBase {
	
	////////////////////////////////////////////////////////////////
	// FIELDS                                                     //
	////////////////////////////////////////////////////////////////
 
    private LEPoint[] Points;
    
    private int size = 0;
 
    private LELine[] Lines;
    
	////////////////////////////////////////////////////////////////
	// CONSTRUCTOR                                                //
	////////////////////////////////////////////////////////////////    
 
    public LEPolyLine(int size, LEPoint[] data) {
        Points = data;
        this.size = size;
        this.refreshLines();
        this.type = LEBasic.TYPE_POLYLINE;
    }
 
    public LEPolyLine(LEPoint[] data) {
        Points = data;
        this.size = data.length;
        this.refreshLines();
        this.type = LEBasic.TYPE_POLYLINE;
    }
 
    public LEPolyLine(int[] dataXY) {
        this.size = dataXY.length / 2;
        Points = new LEPoint[this.size];
        for (int i = 0; i < this.size; i++) {
            Points[i] = new LEPoint(dataXY[i * 2], dataXY[i * 2 + 1]);
        }
        this.refreshLines();
        this.type = LEBasic.TYPE_POLYLINE;
    }
    
	////////////////////////////////////////////////////////////////
	// GETTERS/SETTERS                                            //
	////////////////////////////////////////////////////////////////

    public LEPoint[] getPoints() {
        return Points;
    }

    public int getSize() {
        return size;
    }
 
    
 
    public LELine[] getLines() {
        return Lines;
    }
    
	////////////////////////////////////////////////////////////////
	// METHODS                                                    //
	////////////////////////////////////////////////////////////////
    
    public void refreshLines() {
        Lines = new LELine[this.size - 1];
        for (int i = 0; i < this.size - 1; i++) {
            Lines[i] = new LELine(Points[i], Points[i + 1]);
        }
    }
 
    @Override
    public void update() {
        for (LEPoint a : Points) {
            a.update();
        }
        this.refreshLines();
    }
 
    @Override
    public boolean isSelected(float x, float y) {
        // TODO Auto-generated method stub
        return false;
    }
 
    @Override
    public void draw(Canvas c, Paint p) {
        for (LELine l :Lines)
        {
            l.draw(c, p);
        }
 
    }
}