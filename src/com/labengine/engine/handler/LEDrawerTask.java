package com.labengine.engine.handler;

import java.util.TimerTask;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.SurfaceHolder;

import com.labengine.engine.LEBasic;
import com.labengine.engine.LESettings;
import com.labengine.tools.scene.LELayer;
import com.labengine.tools.scene.LEScene;

/**
 * 
 * @author DukeYuri
 * @version 0.1
 * 
 */

public class LEDrawerTask extends TimerTask {
	
	////////////////////////////////////////////////////////////////
	// FIELDS                                                     //
	////////////////////////////////////////////////////////////////

	SurfaceHolder holder;
	Paint mainPaint;
	LEScene scene;
	LELayer layer;
	Canvas canvas;
	int k;
	
	////////////////////////////////////////////////////////////////
	// CONSTRUCTOR                                                //
	////////////////////////////////////////////////////////////////

	public LEDrawerTask(SurfaceHolder h, LEScene s) {
		this.holder = h;
		mainPaint = new Paint();
		this.scene = s;
	}
	
	////////////////////////////////////////////////////////////////
	// GETTERS/SETTERS                                            //	
	////////////////////////////////////////////////////////////////
	
	////////////////////////////////////////////////////////////////
	// METHODS                                                    //
	////////////////////////////////////////////////////////////////
	
	@Override
	public void run() {

		try {
			canvas = null;
			canvas = holder.lockCanvas();
			canvas.drawRGB(0, 0, 0);
			for (int l = 0; l < scene.getLayCount(); l++) {
				layer = scene.getLayerByNum(l);
				if (layer != null) {
					mainPaint = layer.p;
					for (LEBasic tmp : layer.data) {
						tmp.draw(canvas, mainPaint);
					}

				}
			}
			scene.update();
			LESettings.newFrame();
		} catch (Exception e) {

		} finally {
			if (canvas != null) {
				holder.unlockCanvasAndPost(canvas);
			}
		}

	}
}