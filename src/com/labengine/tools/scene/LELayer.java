package com.labengine.tools.scene;

import java.util.LinkedList;

import android.graphics.Paint;

import com.labengine.engine.LEBasic;
import com.labengine.engine.camera.LECamera;
import com.labengine.tools.sprite.LESimpleSprite;

/**
 * @author DukeYuri
 * @version 0.1 The layer on which you can add objects {@link mBasic} Used in
 *          the class LEScene {@link mScene}
 */
public class LELayer {
	
	////////////////////////////////////////////////////////////////
	// FIELDS                                                     //
	////////////////////////////////////////////////////////////////
	
	public LinkedList<LEBasic> data = new LinkedList<LEBasic>();
	public static LinkedList<LECamera> cData = new LinkedList<LECamera>();

	int level;

	public Paint p;

	private boolean processing = false;
	
	////////////////////////////////////////////////////////////////
	// CONSTRUCTOR                                                //
	////////////////////////////////////////////////////////////////

	public LELayer(int lev) {
		processing = true;
		level = lev;
		p = new Paint();
		processing = false;
	}
	
	////////////////////////////////////////////////////////////////
	// GETTERS/SETTERS                                            //
	////////////////////////////////////////////////////////////////
	
	public int getSize() {
		return data.size();
	}

	public LEBasic get(int i) {
		return data.get(i);
	}
	
	////////////////////////////////////////////////////////////////
	// METHODS                                                    //
	////////////////////////////////////////////////////////////////

	public void add(LEBasic item) {
		processing = true;
		data.add(item);
		processing = false;
	}

	public void addCamera(LECamera cam) {
		processing = true;
		cData.add(cam);
		processing = false;
	}

	public void delete(int i) {
		processing = true;
		data.remove(i);
		processing = false;
	}

	public void clear() {
		processing = true;
		data.clear();
		processing = false;
	}

	public void update() {
		processing = true;
		for (LEBasic a : data) {
			if (a != null)
				a.update();
		}
		processing = false;
	}

	public void resize(float newx, float newy) {
		processing = true;
		for (LEBasic a : data) {
			if (a != null && a.type == LEBasic.TYPE_SIMPLESPRITE) {
				((LESimpleSprite) a).resize(newx, newy);
			}
		}
		processing = false;
	}

	/**
	 * selects the first object on the layer, which gets the point with
	 * coordinates (x, y)
	 *
	 * @param x
	 *           - the x-coordinate
	 * @param y
	 *           - the y-coordinate
	 */
	public LEBasic select(float x, float y) {
		LEBasic tmp = null;
		for (int i = 0; i < data.size(); i++) {
			if (data.get(i) != null && data.get(i).isSelected(x, y)) {
				tmp = data.get(i);
				break;
			}
		}
		return tmp;
	}

	public boolean isProcessing() {
		return processing;
	}
}