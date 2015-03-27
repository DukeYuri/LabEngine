package com.labengine.tools.scene;

import android.util.DisplayMetrics;
import android.view.Display;

import com.labengine.engine.LEBasic;
import com.labengine.engine.camera.LECamera;
import com.labengine.tools.sprite.LESimpleSprite;

/**
 * 
 * @author DukeYuri
 * @version 0.1
 * 
 */

public class LEScene {
	
	////////////////////////////////////////////////////////////////
	// FIELDS                                                     //
	////////////////////////////////////////////////////////////////
 
    LELayer[] layers;
 
    private int curLay;
 
    public static final int ORIENTATION_VERT=0;
    public static final int ORIENTATION_HOR=1;
 
    private int orient;
    
    private int layCount;
 
    public int TopLay;
 
    public int BotLay = 0;
 
    public int width, height;
    
    public boolean drawing = true;
    
	////////////////////////////////////////////////////////////////
	// CONSTRUCTOR                                                //
	////////////////////////////////////////////////////////////////    
 
    public LEScene(int width, int height, int layerCount) {
        this.width = width;
        this.height = height;
        if (this.width>this.height){orient=LEScene.ORIENTATION_HOR;}
        else
        {orient = LEScene.ORIENTATION_VERT;}
        layers = new LELayer[layerCount];
        curLay = 0;
        TopLay = layerCount - 1;
        for (int i = BotLay; i < layerCount; i++) {
            layers[i] = new LELayer(i);
        }
        layCount = layerCount;
    }
    
    public LEScene(Display d, int layerCount) {
    	DisplayMetrics metrics = new DisplayMetrics();
    	d.getMetrics(metrics);
    	this.width = metrics.widthPixels;
        this.height = metrics.heightPixels;
        if (this.width>this.height){orient=LEScene.ORIENTATION_HOR;}
        else
        {orient = LEScene.ORIENTATION_VERT;}
        layers = new LELayer[layerCount];
        curLay = 0;
        TopLay = layerCount - 1;
        for (int i = BotLay; i < layerCount; i++) {
            layers[i] = new LELayer(i);
        }
        layCount = layerCount;
    }
    
	////////////////////////////////////////////////////////////////
	// GETTERS/SETTERS                                            //
	////////////////////////////////////////////////////////////////
 
    public void setWH(int w, int h) {
        this.width = w;
        this.height = h;
    }
 
    public void setCurLay(int i) {
        if (i <= TopLay)
            curLay = i;
        else
            curLay = TopLay;
    }
    
    public int getCurlayNum() {
        return this.curLay;
    }
 
    public LELayer getCurLay() {
        return layers[this.curLay];
    }
    
    public int getLayCount() {
        return layCount;
    }
    
    public LELayer getLayerByNum(int num)
    {
        if (num<this.layCount) {
            return layers[num];
        }
        return null;
    }
 
    public int getOrient() {
        return orient;
    }
 
    public int getWidth() {
        return width;
    }
 
    public int getHeight() {
        return height;
    }
    
    public void setBackground(LESimpleSprite background, Display d) {
    	this.setCurLay(0);
    	this.addItem(background);
    	DisplayMetrics metrics = new DisplayMetrics();
    	d.getMetrics(metrics);
    	background.resize(metrics.widthPixels, metrics.heightPixels);
    }
 
	////////////////////////////////////////////////////////////////
	// METHODS                                                    //
	////////////////////////////////////////////////////////////////
    
    public void addItem(LEBasic item) {
        layers[curLay].add(item);
    }
   
    public void addCamera(LECamera cam) {
    	layers[curLay].addCamera(cam);
    }
 
    public void clear() {
        this.layers[this.curLay].clear();
    }
 
    public void delete(int i) {
        this.layers[this.curLay].delete(i);
    }
 
    public void resize(float newx, float newy)
    {
        for (LELayer a: layers) {
            a.resize(newx, newy);
        }
    }
 
    public LEBasic selectSprite(float f, float g) {
        LEBasic sel = null;
        sel = this.layers[curLay].select(f, g);
        return sel;
    }
 
    public void update() {
        for (LELayer l : layers) {
            l.update();
        }
    }
    
    public void clearAll() {
		for (LELayer l : layers) {
			l.clear();
		}
	}
}