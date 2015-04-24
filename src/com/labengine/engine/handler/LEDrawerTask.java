package com.labengine.engine.handler;

import java.util.TimerTask;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.SurfaceHolder;

import com.labengine.base.scene.LELayer;
import com.labengine.base.scene.LEScene;
import com.labengine.engine.LEBasic;
import com.labengine.engine.LESettings;

/**
 * 
 * @author DukeYuri
 * @version 0.1
 * 
 */

public class LEDrawerTask extends TimerTask {

	// //////////////////////////////////////////////////////////////
	// FIELDS
	// //////////////////////////////////////////////////////////////

	SurfaceHolder holder;
	Paint mainPaint;
	LEScene scene;
	LELayer layer;
	Canvas canvas;
	int k;

	// //////////////////////////////////////////////////////////////
	// CONSTRUCTOR
	// //////////////////////////////////////////////////////////////

	public LEDrawerTask(SurfaceHolder h, LEScene s) {
		this.holder = h;
		mainPaint = new Paint();
		this.scene = s;
	}

	// //////////////////////////////////////////////////////////////
	// GETTERS/SETTERS
	// //////////////////////////////////////////////////////////////

	// //////////////////////////////////////////////////////////////
	// METHODS
	// //////////////////////////////////////////////////////////////

	@Override
	public void run() {

		try {
			canvas = null;
			canvas = holder.lockCanvas();
			canvas.drawRGB(0, 0, 0);
			for (int i = 0; i < scene.getLayCount(); i++) {
				layer = scene.getLayerByNum(i);
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