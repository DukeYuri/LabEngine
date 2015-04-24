package com.labengine.base.sprite;

import java.io.IOException;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.Log;

import com.labengine.base.primitive.LEPoint;
import com.labengine.engine.LEBasic;
import com.labengine.engine.LESettings;
import com.labengine.engine.camera.LECamera;
import com.labengine.input.touch.TouchCatch;
import com.labengine.physics.LERectBody;
import com.labengine.tools.debug.LEDebug;
import com.labengine.ui.activity.LEBaseGameActivity;

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

	protected Bitmap bmp;

	protected float rpx = 0, rpy = 0;

	protected int width = 0, height = 0;

	protected Matrix matrix = new Matrix();

	protected boolean selected = false;

	protected LECamera cam;

	protected Paint p = new Paint();

	public LERectBody pb;

	public LEPoint p1, p2;

	// //////////////////////////////////////////////////////////////
	// CONSTRUCTOR
	// //////////////////////////////////////////////////////////////

	public LESimpleSprite(float x, float y, Bitmap bmp) {
		super(x, y);
		this.bmp = bmp;
		this.type = LEBasic.TYPE_SIMPLESPRITE;
		AutoSize();
	}

	public LESimpleSprite(String s, int a) {
		super(0, 0);
		this.bmp = BitmapFactory.decodeFile(s);
		this.type = LEBasic.TYPE_SIMPLESPRITE;
		AutoSize();
	}

	public LESimpleSprite(String s) {
		super(0, 0);
		try {
			this.bmp = BitmapFactory.decodeStream(LEBaseGameActivity.assetManager.open(s));
		} catch (IOException e) {
			bmp = null;
		}
		this.type = LEBasic.TYPE_SIMPLESPRITE;
		p1 = new LEPoint(this.x, this.y);
		p2 = new LEPoint(super.getX() + getWidth(), super.getY() + getHeight());
		pb = new LERectBody(p1, p2);
		AutoSize();
		Log.d("LESimpleSprite", "SRITE " + s + " LOADED");
	}

	public LESimpleSprite(String s, LECamera cam) {
		super(0, 0);
		try {
			this.bmp = BitmapFactory.decodeStream(LEBaseGameActivity.assetManager.open(s));
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
	
	public void setCenterX(float x) {
		super.setX(x - width / 2);
		refreshAll();
	}

	public void setCenterY(float y) {
		super.setY(y - height / 2);
		refreshAll();
	}

	public void setCenterXY(float x, float y) {
		super.setY(y - height / 2);
		super.setX(x - width / 2);
		refreshAll();
	}
	
	public void setRightXY(float x, float y) {
		super.setY(-y);
		super.setX(-x);
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
			refreshBody();
		}
	}

	private void refreshBody() {
		p1.setX(this.x);
		p1.setY(this.y);
		p2.setX(this.x + this.getWidth());
		p2.setY(this.y + this.getHeight());
		pb.update();
	}

	@Override
	public boolean onTouched(TouchCatch touch, float pX, float pY) {
		return false;
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
		if (show) {
			refreshAll();
			c.drawBitmap(bmp, matrix, p);
		}
		if(LEDebug.debugMode) {
			pb.draw(c, p);
		}
	}

}