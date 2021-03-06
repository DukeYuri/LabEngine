package com.labengine.examples.games;

import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;

import com.labengine.base.scene.LEScene;
import com.labengine.base.sprite.LESimpleSprite;
import com.labengine.engine.LESettings;
import com.labengine.tools.LEConstants;
import com.labengine.tools.debug.LEDebug;
import com.labengine.ui.activity.LEBaseGameActivity;

/**
 * 
 * @author DukeYuri
 * @version 0.1
 * 
 */

public class Menu extends LEBaseGameActivity {

	private LEScene scene;
	LESimpleSprite background, pong_btn, spb_btn, debug_btn;
	int w, h;

	@Override
	public void onLoadEngine() {
		LESettings.AutoScale = true;
		LESettings.setDefaultWH(480, 800);
		LESettings.Init(30);
		LESettings.setSound(false);
		LESettings.setFullScreen(true);
		LESettings.setOrientation(true, LEConstants.LANDSCAPE);
	}

	@Override
	public LEScene onLoadResource() {
		w = LESettings.CurrentScreenWidth;
		h = LESettings.CurrentScreenHeight;
		scene = new LEScene(0, 0, 1);
		background = new LESimpleSprite("menu-back.png");
		pong_btn = new LESimpleSprite("pong_btn.png");
		spb_btn = new LESimpleSprite("spb_btn.png");
		debug_btn = new LESimpleSprite("debug_btn.png");
		return scene;
	}

	@Override
	public void onLoadScene() {
		scene.setSpriteBackground(background);
		pong_btn.setCenterXY(w / 2, h / 2 + spb_btn.getHeight() / 2);
		scene.addItem(pong_btn);
		spb_btn.setCenterXY(w / 2, h / 2 - pong_btn.getHeight() / 2);
		scene.addItem(spb_btn);
		debug_btn.setX(w - debug_btn.getWidth());
		scene.addItem(debug_btn);
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// LEDebug.makeDebugToast("HELLO");
		if (event.getAction() == MotionEvent.ACTION_MOVE) {

		}

		if (event.getAction() == MotionEvent.ACTION_UP) {
			if (pong_btn.isSelected(event.getX(), event.getY())) {
				startActivity(new Intent(Menu.this, Pong.class));
			}
			if (spb_btn.isSelected(event.getX(), event.getY())) {
				startActivity(new Intent(Menu.this, SpaceBattle.class));
			}
			if (debug_btn.isSelected(event.getX(), event.getY())) {
				if (!LEDebug.debugMode) {
					LEDebug.setDebugMode(true);
				} else {
					LEDebug.setDebugMode(false);
					scene.update();
				}
			}
		}
		return true;
	}

}
