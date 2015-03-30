package com.labengine.engine;

import java.util.Timer;

import android.content.Context;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.labengine.engine.handler.LEDrawerTask;
import com.labengine.tools.scene.LEScene;

/**
 * 
 * @author DukeYuri
 * @version 0.1
 * 
 */

public class LESurfaceView extends SurfaceView implements
		SurfaceHolder.Callback {
	
	////////////////////////////////////////////////////////////////
	// FIELDS                                                     //
    ////////////////////////////////////////////////////////////////
	
	LEScene scene;

	LEDrawerTask drawer;

	Canvas canv;

	Timer t = new Timer();

	////////////////////////////////////////////////////////////////
	// CONSTRUCTOR                                                //
	////////////////////////////////////////////////////////////////

	public LESurfaceView(Context context, LEScene s) {
		super(context);
		scene = s;
		// drawer = new LEDrawerTask(this.getHolder(), this.scene);
		this.getHolder().addCallback(this);
	}
	
	////////////////////////////////////////////////////////////////
	// GETTERS/SETTERS                                            //
	////////////////////////////////////////////////////////////////

	public void setScene(LEScene scene) {
		this.scene = scene;
	}

	public LEScene getScene() {
		return scene;
	}
	
	////////////////////////////////////////////////////////////////
	// METHODS                                                    //
	////////////////////////////////////////////////////////////////
	
	@Override
	public void surfaceChanged(SurfaceHolder arg0, int arg1, int w, int h) {
		// t.schedule(drawer, 0, LESettings.frameInterval);
		scene.setWH(w, h);
		LESettings.setDisplaySize(w, h);

	}

	@Override
	public void surfaceCreated(SurfaceHolder arg0) {
		drawer = new LEDrawerTask(this.getHolder(), this.scene);
		t.scheduleAtFixedRate(drawer, 0, LESettings.frameInterval);
		canv = this.getHolder().lockCanvas();
		scene.setWH(canv.getWidth(), canv.getHeight());
		this.getHolder().unlockCanvasAndPost(canv);
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder arg0) {
		drawer.cancel();
		t.purge();
		scene.clearAll();
	}

	public void stopDrawing() {
		this.scene.drawing = false;
	}

	public void startDrawing() {
		this.scene.drawing = true;
	}

}