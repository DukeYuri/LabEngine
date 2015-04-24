package com.labengine.engine.camera;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;

import com.labengine.base.LEBase;
import com.labengine.engine.LEBasic;

/**
 * 
 * @author DukeYuri
 * @version 0.2
 * 
 */

public class LECamera extends LEBasic {

	// //////////////////////////////////////////////////////////////
	// FIELDS
	// //////////////////////////////////////////////////////////////

	public static final int STYLE_FREELY = 0;
	public static final int STYLE_HORIZONTAL = 1;
	public static final int STYLE_VERTICAL = 2;

	public Paint p = new Paint();

	private Bitmap bmp;

	private int w, h;

	private float sx, sy;

	private float pPX, pPY;

	private float scaleX, scaleY;

	private float rotation = 0, sin, cos;

	private float zoom = 0;

	Bitmap.Config conf = Bitmap.Config.ARGB_8888;

	public Canvas c;

	private Matrix matrix = new Matrix();

	// //////////////////////////////////////////////////////////////
	// CONSTRUCTOR
	// //////////////////////////////////////////////////////////////

	public LECamera(float sx, float sy, final int width, final int height) {
		this.w = width;
		this.h = height;
		this.sx = sx;
		this.sy = sy;
		bmp = Bitmap.createBitmap(w, h, conf);
		c = new Canvas(bmp);
		refreshAll();
	}

	// //////////////////////////////////////////////////////////////
	// GETTERS/SETTERS
	// //////////////////////////////////////////////////////////////

	public Matrix getMatrix() {
		return matrix;
	}

	public void setCameraRotation(float rotation) {
		this.rotation = rotation;
	}

	public float getCameraRotation() {
		return rotation;
	}

	public void setPivotPointX(float pPX) {
		this.pPX = pPX;
	}

	public float getPivotPointX() {
		return pPX;
	}

	public void setPivotPointY(float pPY) {
		this.pPY = pPY;
	}

	public float getPivotPointY() {
		return pPY;
	}

	public void setCameraPositionX(float sx) {
		this.sx = sx;
	}

	public float getCameraPositionX() {
		return sx;
	}

	public void setCameraPositionY(float sy) {
		this.sy = sy;
	}

	public float getCameraPositionY() {
		return sy;
	}

	public void setCameraPositionXY(float sx, float sy) {
		this.sx = sx;
		this.sy = sy;
	}

	public void setCameraZoom(float zoom) {
		this.zoom = zoom;
	}

	public float getCameraZoom() {
		return zoom;
	}

	public void setCameraScaleX(float scaleX) {
		this.scaleX = scaleX;
	}

	public void setCameraScaleY(float scaleY) {
		this.scaleY = scaleY;
	}

	public float getCameraScaleX() {
		return scaleX;
	}

	public float getCameraScaleY() {
		return scaleY;
	}

	// //////////////////////////////////////////////////////////////
	// METHODS
	// //////////////////////////////////////////////////////////////

	public void refreshAll() {
		sin = (float) Math.sin(-rotation);
		cos = (float) Math.cos(-rotation);
		sx = (cos - sin);

	}

	public void follow(LEBase o) {

	}

	public void follow(LEBase o, int STYLE) {

	}

	public void focusOn(int x, int y) {

	}

	public class scroll {

	}

	public void destroy() {

	}

	@Override
	public void update() {
		refreshAll();
		matrix.setScale(sx, sy);
		matrix.setRotate(rotation);
		matrix.setTranslate(pPX, pPY);		
	}

	@Override
	public boolean isSelected(float x, float y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void draw(Canvas c, Paint p) {
		c.drawBitmap(bmp, matrix, p);
	}

}
