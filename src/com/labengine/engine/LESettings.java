package com.labengine.engine;

import java.util.Timer;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.os.Vibrator;
import android.util.DisplayMetrics;
import android.view.Display;

import com.labengine.engine.handler.LETimerCounter;
 
/**
 * 
 * @author DukeYuri
 * @version 0.1
 * 
 */

public class LESettings {
 
	////////////////////////////////////////////////////////////////
	// FIELDS                                                     //
	////////////////////////////////////////////////////////////////

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
	
	public static int DefaultXRes = 480;
	
	public static int DefaultYRes = 800;
	
	public static int CurrentXRes;
	
	public static int CurrentYRes;
	
	public static float ScaleFactorX = 1;
	
	public static float ScaleFactorY = 1;
	
	public static int targetFrameRate = 25;
	
	public static int frameInterval = 1000 / targetFrameRate;
	
	public static int frameCounter = 0;
	
	public static int realFrameRate = 0;
	
	private static boolean Sound = true;
	
	private static boolean Vibro = true;
	
	public static boolean showFrameRate = false;
	
	public static SharedPreferences settings;
	
	private static int DefaultVibrationTime = 30;

	private static Context cont;

	private static Vibrator vibrator;
	
	public static int timeCounter = 0;
	
	////////////////////////////////////////////////////////////////
	// CONSTRUCTOR                                                //
	////////////////////////////////////////////////////////////////
	
	////////////////////////////////////////////////////////////////
	// GETTERS/SETTERS                                            //
	////////////////////////////////////////////////////////////////
	
	public static void setDisplaySize(int w, int h) {
		LESettings.CurrentXRes = w;
		LESettings.CurrentYRes = h;
		LESettings.ScaleFactorX = LESettings.CurrentXRes
				/ (float) LESettings.DefaultXRes;
		LESettings.ScaleFactorY = LESettings.CurrentYRes
				/ (float) LESettings.DefaultYRes;
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
	
	public static void setDefaultRes(int x, int y) {
		LESettings.DefaultXRes = x;
		LESettings.DefaultYRes = y;
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
	
	////////////////////////////////////////////////////////////////
	// METHODS                                                    //
	////////////////////////////////////////////////////////////////
	
	/**
	 * Engine initialization
	 * Must be called before will be used any other function class library LabEngine
	 * @param c - context
	 * @param D - display
	 * @param TargetFrameRate 
	 */
	public static void Init(Context c, Display D, int TargetFrameRate) {
		cont = c;
		settings = cont.getSharedPreferences("mEngine", 0);
		DisplayMetrics metrics = new DisplayMetrics();
    	D.getMetrics(metrics);
		LESettings.CurrentXRes = metrics.widthPixels;
		LESettings.CurrentYRes = metrics.heightPixels;
		LESettings.ScaleFactorX = LESettings.CurrentXRes
				/ (float) LESettings.DefaultXRes;
		LESettings.ScaleFactorY = LESettings.CurrentYRes
				/ (float) LESettings.DefaultYRes;
		if (LESettings.ScaleFactorX != 1 || LESettings.ScaleFactorY != 1) {
			LESettings.AutoScale = true;
		}
		vibrator = (Vibrator) cont.getSystemService(Context.VIBRATOR_SERVICE);
		Sound = settings.getBoolean("sound", Sound);
		Vibro = settings.getBoolean("vibro", Vibro);
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

	public static void vibrate(int time) {
		if (LESettings.Vibro)
			vibrator.vibrate(time);
	}

	public static void vibrate() {
		if (LESettings.Vibro)
			vibrator.vibrate(DefaultVibrationTime);
	}

	public static void stratTimer() {
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