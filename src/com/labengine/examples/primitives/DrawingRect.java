package com.labengine.examples.primitives;

import android.view.MotionEvent;
import android.view.View;

import com.labengine.base.primitive.LERect;
import com.labengine.base.scene.LEScene;
import com.labengine.base.sprite.LESimpleSprite;
import com.labengine.engine.LESettings;
import com.labengine.ui.activity.LEBaseGameActivity;

public class DrawingRect extends LEBaseGameActivity {

	private LEScene scene;
	LERect[] rects;
	LESimpleSprite background, logo;
	int w, h;

	@Override
	public void onLoadEngine() {
		LESettings.AutoScale = true;
		LESettings.setDefaultWH(480, 800);
		LESettings.Init(30);
		LESettings.setSound(false);
		LESettings.setFullScreen(true);
	}

	@Override
	public LEScene onLoadResource() {
		w = LESettings.CurrentScreenWidth;
		h = LESettings.CurrentScreenHeight;
		scene = new LEScene(0, 0, 1);
		rects = new LERect[50];
		logo = new LESimpleSprite("sum-logo.png");
		for (int i = 0; i < 50; i++) {
			rects[i] = new LERect((float) Math.random() * w,
					(float) Math.random() * h, (float) Math.random() * w,
					(float) Math.random() * h);
		}
		background = new LESimpleSprite("menu-back.png");
		return scene;
	}

	@Override
	public void onLoadScene() {
		scene.setSpriteBackground(background);
		for (int i = 0; i < 50; i++) {
			scene.addItem(rects[i]);
		}
		logo.setX(w - logo.getWidth());
		scene.addItem(logo);
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		return false;
	}

}
