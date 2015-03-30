package com.labengine.tools.sprite;

import java.io.IOException;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.Log;

import com.labengine.engine.LEBasic;
import com.labengine.engine.LESettings;
import com.labengine.engine.camera.LECamera;
import com.labengine.tools.primitive.LEPoint;

/**
 * 
 * @author DukeYuri
 * @version 0.1
 * 
 */

public class LESimpleSprite extends LEPoint {

	// //////////////////////////////////////////////////////////////
	// FIELDS
	// //////////////////////////////////////////////////////////////

	Bitmap bmp;

	float rpx = 0, rpy = 0;

	int width = 0, height = 0;

	boolean centralAxis = true;

	Matrix matrix = new Matrix();

	boolean selected = false;

	LECamera cam;

	// //////////////////////////////////////////////////////////////
	// CONSTRUCTOR
	// //////////////////////////////////////////////////////////////

	public LESimpleSprite(float x, float y, Bitmap bmp) {
		super(x, y);
		this.bmp = bmp;
		this.type = LEBasic.TYPE_SIMPLESPRITE;
		AutoSize();
	}

	public LESimpleSprite(int x, int y, Bitmap bmp) {
		super(x, y);
		this.bmp = bmp;
		this.type = LEBasic.TYPE_SIMPLESPRITE;
		AutoSize();
	}

	public LESimpleSprite(String s) {
		super(0, 0);
		this.bmp = BitmapFactory.decodeFile(s);
		this.type = LEBasic.TYPE_SIMPLESPRITE;
		AutoSize();
	}

	public LESimpleSprite(String s, AssetManager am) {

		super(0, 0);
		try {
			this.bmp = BitmapFactory.decodeStream(am.open(s));
		} catch (IOException e) {
			bmp = null;
		}
		this.type = LEBasic.TYPE_SIMPLESPRITE;
		AutoSize();
		Log.d("LESimpleSprite", "SRITE " + s + " LOADED");
	}
	
	public LESimpleSprite(String s, AssetManager am, LECamera cam) {

		super(0, 0);
		try {
			this.bmp = BitmapFactory.decodeStream(am.open(s));
		} catch (IOException e) {
			bmp = null;
		}
		this.type = LEBasic.TYPE_SIMPLESPRITE;
		this.cam = cam;
		AutoSize();
		Log.d("LESimpleSprite", "SRITE " + s + " LOADED");
	}

	public LESimpleSprite(Resources Res, int ID) {
		super(0, 0);
		this.bmp = BitmapFactory.decodeResource(Res, ID);
		this.type = LEBasic.TYPE_SIMPLESPRITE;
	}

	// //////////////////////////////////////////////////////////////
	// GETTERS/SETTERS
	// //////////////////////////////////////////////////////////////

	public Matrix getMatrix() {
		return matrix;
	}

	public void setMatrix(Matrix matrix) {
		this.matrix = matrix;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	@Override
	public void setX(float x) {
		super.setX(x);
		refreshAll();
	}

	@Override
	public void setY(float y) {
		super.setY(y);
		refreshAll();
	}

	public void setXY(float x, float y) {
		super.setY(y);
		super.setX(x);
		refreshAll();
	}

	// //////////////////////////////////////////////////////////////
	// METHODS
	// //////////////////////////////////////////////////////////////

	private void AutoSize() {
		if (LESettings.AutoScale) {
			this.resize(LESettings.ScaleFactorX, LESettings.ScaleFactorY);
		}
		this.refreshAll();
	}

	public void resize(int newx, int newy) {
		Bitmap tmp = Bitmap.createScaledBitmap(bmp, newx, newy, true);
		bmp = tmp;
		this.refreshAll();
	}

	public void resize(float newx, float newy) {
		int nx;
		int ny;
		this.refreshAll();
		nx = (int) (this.width * newx);
		ny = (int) (this.height * newy);
		Bitmap tmp = Bitmap.createScaledBitmap(bmp, nx, ny, true);
		bmp = tmp;
		this.refreshAll();
	}

	public void refreshAll() {
		if (bmp != null) {
			this.width = bmp.getWidth();
			this.height = bmp.getHeight();
			matrix.setTranslate(this.x, this.y);
		}
	}

	@Override
	public boolean isSelected(float x, float y) {
		selected = false;
		if (x > this.x && x < (this.x + this.width) && y > this.y
				&& y < (this.y + this.height)) {
			selected = true;
		}
		return selected;
	}

	public boolean isSelected() {
		return selected;
	}

	@Override
	public void draw(Canvas c, Paint p) {
		//matrix = cam.getMatrix();
		c.drawBitmap(bmp, matrix, p);
	}
	
}