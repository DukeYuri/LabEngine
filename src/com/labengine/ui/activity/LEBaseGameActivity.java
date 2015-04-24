package com.labengine.ui.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.Display;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;

import com.labengine.base.scene.LEScene;
import com.labengine.engine.LESettings;
import com.labengine.engine.LESurfaceView;
import com.labengine.tools.LEConstants;

/**
 * 
 * @author DukeYuri
 * @version 0.1
 * 
 */

public abstract class LEBaseGameActivity extends Activity implements
		OnTouchListener {

	// //////////////////////////////////////////////////////////////
	// FIELDS
	// //////////////////////////////////////////////////////////////
	
	public static final int ORIENTATION_PORTRAIT = LEConstants.PORTRAIT;

	public static final int ORIENTATION_LANDSCAPE = LEConstants.LANDSCAPE;

	protected LESurfaceView sf;

	public static AssetManager assetManager;
	
	public static Display display;

	public static Context context;

	
	// //////////////////////////////////////////////////////////////
	// CONSTRUCTOR
	// //////////////////////////////////////////////////////////////

	// //////////////////////////////////////////////////////////////
	// GETTERS/SETTERS
	// //////////////////////////////////////////////////////////////

	public void onSetContentView(LEScene scene) {
		sf = new LESurfaceView(this, scene);
		this.setContentView(sf);
	}
	
	public void setOrientation(int orientation) {
		setRequestedOrientation(orientation);
	}

	// //////////////////////////////////////////////////////////////
	// METHODS
	// //////////////////////////////////////////////////////////////

	@SuppressLint("ClickableViewAccessibility")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		display = this.getWindowManager().getDefaultDisplay();
		context = this;
		onLoadEngine();
		if (LESettings.FullScreen) {
			requestWindowFeature(Window.FEATURE_NO_TITLE);
			getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
					WindowManager.LayoutParams.FLAG_FULLSCREEN);
		}
		assetManager = this.getAssets();
		onLoadResource();
		this.onSetContentView(onLoadResource());
		sf.setOnTouchListener(this);
	}

	@Override
	public void onStart() {
		super.onStart();
		onLoadScene();
		if (LESettings.Orientation && LESettings.orient == ORIENTATION_PORTRAIT) {
			setOrientation(ORIENTATION_PORTRAIT);
		} else {
			setOrientation(ORIENTATION_LANDSCAPE);
		}
	}

	public abstract void onLoadEngine();

	public abstract LEScene onLoadResource();

	public abstract void onLoadScene();
}
