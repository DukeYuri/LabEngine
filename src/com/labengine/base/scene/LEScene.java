package com.labengine.base.scene;

import com.labengine.base.sprite.LESimpleSprite;
import com.labengine.engine.LEBasic;
import com.labengine.engine.LESettings;
import com.labengine.engine.camera.LECamera;
import com.labengine.input.touch.TouchCatch;

/**
 * 
 * @author DukeYuri
 * @version 0.1
 * 
 */

public class LEScene {

	// //////////////////////////////////////////////////////////////
	// FIELDS
	// //////////////////////////////////////////////////////////////

	LELayer[] layers;

	private int curLay;

	private int orient;

	private int layCount;

	public int TopLay;

	public int BotLay = 0;

	public int width, height;

	public boolean drawing = true;

	// //////////////////////////////////////////////////////////////
	// CONSTRUCTOR
	// //////////////////////////////////////////////////////////////

	public LEScene(int width, int height, int layerCount) {
		this.width = width;
		this.height = height;
		layerCount++;
		layers = new LELayer[layerCount];
		curLay = 1;
		TopLay = layerCount - 2;
		for (int i = BotLay; i < layerCount; i++) {
			layers[i] = new LELayer(i);
		}
		layCount = layerCount;
	}

	// //////////////////////////////////////////////////////////////
	// GETTERS/SETTERS
	// //////////////////////////////////////////////////////////////

	public void setWH(int w, int h) {
		this.width = w;
		this.height = h;
	}

	public void setCurLay(int i) {
		if (i <= TopLay) {
			curLay = i;
		} else {
			curLay = TopLay;
		}
		/*
		 * if (i == 0) { Log.e("LEScene", "Wrong layer!"); curLay = 1; }
		 */
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

	public LELayer getLayerByNum(int num) {
		if (num < this.layCount) {
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

	public void setSpriteBackground(LESimpleSprite background) {
		this.setCurLay(0);
		background.resize(LESettings.CurrentScreenWidth,
				LESettings.CurrentScreenHeight);
		this.addItem(background);
	}

	// //////////////////////////////////////////////////////////////
	// METHODS
	// //////////////////////////////////////////////////////////////

	public boolean onTouchedScene(TouchCatch touch, float pX, float pY) {
		return false;
	}

	public void addItem(LEBasic item) {
		layers[curLay].add(item);
	}

	public void addCamera(LECamera cam) {
		// layers[curLay].addCamera(cam);
	}

	public void clear() {
		this.layers[this.curLay].clear();
	}

	public void delete(int i) {
		this.layers[this.curLay].delete(i);
	}

	public void show() {

	}

	public void resize(float newx, float newy) {
		for (LELayer a : layers) {
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