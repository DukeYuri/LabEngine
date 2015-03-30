package com.labengine.examples;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

import com.labengine.engine.LESettings;
import com.labengine.engine.LESurfaceView;
import com.labengine.engine.camera.LECamera;
import com.labengine.tools.scene.LEScene;
import com.labengine.tools.sprite.LESimpleSprite;
import com.labengine.ui.activity.LEBaseGameActivity;

/**
 * 
 * @author DukeYuri
 * @version 0.1
 * 
 */

public class HelloWorld extends LEBaseGameActivity implements OnTouchListener {

	private LEScene scene;
	private LESurfaceView sf;
	LESimpleSprite sprite;
	LECamera cam;
	

	@Override
	public void onLoadEngine() {
		LESettings.AutoScale = true;
		LESettings.setDefaultRes(480, 800);
		LESettings.Init(this, this.getWindowManager().getDefaultDisplay(), 60);
		LESettings.setSound(true);
		
		
		scene = new LEScene(0, 0, 2);
		sf = new LESurfaceView(this, scene);
		this.setContentView(sf);
		sf.setOnTouchListener(this);
	}

	@Override
	public void onLoadResource() {
		sprite = new LESimpleSprite("1.png", this.getAssets());
		
	}

	@Override
	public void onLoadScene() {
		scene.setCurLay(1);
		scene.addItem(sprite);
	}

	@Override
	public void onPauseEngine() {

	}

	@Override
	public void onResumeEngine() {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		/*Toast toast = Toast.makeText(this, sprite.getDx() + " ",
				Toast.LENGTH_SHORT);
		toast.show();*/
		if (event.getAction() == MotionEvent.ACTION_MOVE) {
			sprite.setXY(event.getX(), event.getY());
		}
		return true;
	}

}
