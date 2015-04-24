package com.labengine.examples.action;

import android.view.MotionEvent;
import android.view.View;

import com.labengine.base.scene.LEScene;
import com.labengine.base.sprite.LESimpleSprite;
import com.labengine.engine.LESettings;
import com.labengine.ui.activity.LEBaseGameActivity;

public class MovingBall extends LEBaseGameActivity {

	private LEScene scene;
	LESimpleSprite circle;
	LESimpleSprite background, logo;
	int w, h, dx, dy;

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
		logo = new LESimpleSprite("sum-logo.png");
		circle = new LESimpleSprite("ball_exam.png");
		background = new LESimpleSprite("menu-back.png");
		
		return scene;
	}

	@Override
	public void onLoadScene() {
		scene.setSpriteBackground(background);
		logo.setX(w - logo.getWidth());
		scene.addItem(logo);
		circle.setDx((float)Math.random()*15);
		circle.setDy((float)Math.random()*15);
		scene.addItem(circle);
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {

		return false;
	}
	

}
