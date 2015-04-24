package com.labengine.engine;

import java.util.Timer;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.os.Vibrator;
import android.util.DisplayMetrics;

import com.labengine.engine.handler.LETimerCounter;
import com.labengine.tools.LEConstants;
import com.labengine.ui.activity.LEBaseGameActivity;

/**
 * 
 * @author DukeYuri
 * @version 0.1
 * 
 */

public class LESettings {

	// //////////////////////////////////////////////////////////////
	// FIELDS
	// //////////////////////////////////////////////////////////////

	public static final int ORIENTATION_PORTRAIT = LEConstants.PORTRAIT;

	public static final int ORIENTATION_LANDSCAPE = LEConstants.LANDSCAPE;

	public static int orient;

	private static Timer frameTimer;

	private static Timer timeTimer;

	private static LEFrameCounter tmp = new LEFrameCounter();

	private static LETimerCounter tcou = new LETimerCounter();

	private static boolean showTimer = false;

	private static Paint timerPaint;

	public static int timerposX = 30;

	public static int timerposY = 30;

	public static boolean AutoScale = false;

	public static boolean FullScreen = false;

	public static boolean FixedAspect = false;

	public static int DefaultWidth = 480;

	public static int DefaultHeight = 800;

	public static int CurrentScreenWidth;

	public static int CurrentScreenHeight;

	public static float ScaleFactorX = 1;

	public static float ScaleFactorY = 1;

	public static int targetFrameRate = 25;

	public static int frameInterval = 1000 / targetFrameRate;

	public static int frameCounter = 0;

	public static int realFrameRate = 0;

	private static boolean Sound = true;

	private static boolean Vibro = true;

	public static boolean Orientation = false;

	public static boolean showFrameRate = false;

	public static SharedPreferences settings;

	private static int DefaultVibrationTime = 30;

	private static Vibrator vibrator;

	public static int timeCounter = 0;

	// //////////////////////////////////////////////////////////////
	// CONSTRUCTOR
	// //////////////////////////////////////////////////////////////

	/*
	 * public LESettings(boolean fullscreen, int orientation, boolean autoscale,
	 * int targetframerate) { LESettings.setFullScreen(fullscreen);
	 * LESettings.setOrientation(true); LESettings.AutoScale = autoscale;
	 * LESettings.ORIENTATION = orientation; LESettings.Init(targetframerate); }
	 */

	// //////////////////////////////////////////////////////////////
	// GETTERS/SETTERS
	// //////////////////////////////////////////////////////////////

	public static void setDisplaySize(int w, int h) {
		LESettings.CurrentScreenWidth = w;
		LESettings.CurrentScreenHeight = h;
		if (isPortraitOrientation()) {
			LESettings.ScaleFactorX = LESettings.CurrentScreenWidth
					/ (float) LESettings.DefaultWidth;
			LESettings.ScaleFactorY = LESettings.CurrentScreenHeight
					/ (float) LESettings.DefaultHeight;
		} else {
			LESettings.ScaleFactorX = LESettings.CurrentScreenWidth
					/ (float) LESettings.DefaultHeight;
			LESettings.ScaleFactorY = LESettings.CurrentScreenHeight
					/ (float) LESettings.DefaultWidth;
		}
		if (LESettings.ScaleFactorX != 1 || LESettings.ScaleFactorY != 1) {
			LESettings.AutoScale = true;
		}
	}

	public static void setTargetFrameRate(int fr) {
		LESettings.targetFrameRate = fr;
		frameInterval = 1000 / targetFrameRate;
		if (frameTimer == null)
			frameTimer = new Timer();
		tmp.cancel();
		LEFrameCounter tmp = new LEFrameCounter();
		frameTimer.scheduleAtFixedRate(tmp, 0, 1000);
	}

	public static void setDefaultWH(int x, int y) {
		LESettings.DefaultWidth = x;
		LESettings.DefaultHeight = y;
	}

	public static int getFrameRate() {
		return LESettings.realFrameRate;
	}

	public static void setSound(boolean sound) {
		Sound = sound;
		SharedPreferences.Editor editor = LESettings.settings.edit();
		editor.putBoolean("sound", Sound);
		editor.commit();
	}

	public static void setVibro(boolean vibro) {
		Vibro = vibro;
		SharedPreferences.Editor editor = LESettings.settings.edit();
		editor.putBoolean("vibro", Vibro);
		editor.commit();
	}

	public static void setFullScreen(boolean fullScreen) {
		FullScreen = fullScreen;
		SharedPreferences.Editor editor = LESettings.settings.edit();
		editor.putBoolean("fullScreen", FullScreen);
		editor.commit();
	}

	public static void setOrientation(boolean permission, int orientation) {
		Orientation = permission;
		SharedPreferences.Editor editor = LESettings.settings.edit();
		editor.putBoolean("orientation", Orientation);
		editor.commit();
		if (Orientation) {
			orient = orientation;
		}
	}

	public static void setDefaultVibrationTime(int defaultVibrationTime) {
		DefaultVibrationTime = defaultVibrationTime;
	}

	public static void setTimerpos(int timerposX, int timerposY) {
		LESettings.timerposX = timerposX;
		LESettings.timerposY = timerposY;
	}

	public static int getTimeCounter() {
		return timeCounter;
	}

	public static void setTimeCounter(int timeCounter) {
		LESettings.timeCounter = timeCounter;
	}

	public static void setTimerPaint(Paint timerPaint) {
		LESettings.timerPaint = timerPaint;
	}

	public static Paint getTimerPaint() {
		return timerPaint;
	}

	public static void setShowTimer(boolean showTimer) {
		LESettings.showTimer = showTimer;
	}

	// //////////////////////////////////////////////////////////////
	// METHODS //
	// //////////////////////////////////////////////////////////////

	public static void Init(int TargetFrameRate) {
		settings = LEBaseGameActivity.context.getSharedPreferences("LabEngine",
				0);
		DisplayMetrics metrics = new DisplayMetrics();
		LEBaseGameActivity.display.getMetrics(metrics);
		LESettings.CurrentScreenWidth = metrics.widthPixels;
		LESettings.CurrentScreenHeight = metrics.heightPixels;
		if (isPortraitOrientation()) {
			LESettings.ScaleFactorX = LESettings.CurrentScreenWidth
					/ (float) LESettings.DefaultWidth;
			LESettings.ScaleFactorY = LESettings.CurrentScreenHeight
					/ (float) LESettings.DefaultHeight;
		} else {
			LESettings.ScaleFactorX = LESettings.CurrentScreenWidth
					/ (float) LESettings.DefaultHeight;
			LESettings.ScaleFactorY = LESettings.CurrentScreenHeight
					/ (float) LESettings.DefaultWidth;
		}
		if (LESettings.ScaleFactorX != 1 || LESettings.ScaleFactorY != 1) {
			LESettings.AutoScale = true;
		}
		vibrator = (Vibrator) LEBaseGameActivity.context
				.getSystemService(Context.VIBRATOR_SERVICE);
		Sound = settings.getBoolean("sound", Sound);
		Vibro = settings.getBoolean("vibro", Vibro);
		FullScreen = settings.getBoolean("fullScreen", FullScreen);
		Orientation = settings.getBoolean("orientation", Orientation);
		timeTimer = new Timer();
		timerPaint = new Paint();
	}

	public static void newFrame() {
		LESettings.frameCounter++;
	}

	public static boolean isSound() {
		return Sound;
	}

	public static boolean isVibro() {
		return Vibro;
	}

	public static boolean isFullScreen() {
		return FullScreen;
	}

	public static boolean isPortraitOrientation() {
		return LESettings.CurrentScreenWidth <= LESettings.CurrentScreenHeight;
	}

	public static boolean isLandscapeOrientation() {
		return !(LESettings.CurrentScreenWidth <= LESettings.CurrentScreenHeight);
	}

	public static void vibrate(int time) {
		if (LESettings.Vibro)
			vibrator.vibrate(time);
	}

	public static void vibrate() {
		if (LESettings.Vibro)
			vibrator.vibrate(DefaultVibrationTime);
	}

	public static void startTimer() {
		timeCounter = 0;
		LESettings.tcou = new LETimerCounter();
		timeTimer.scheduleAtFixedRate(LESettings.tcou, 0, 1000);
	}

	public static void stopTimer() {
		tcou.cancel();
	}

	public static boolean isShowTimer() {
		return showTimer;
	}
}