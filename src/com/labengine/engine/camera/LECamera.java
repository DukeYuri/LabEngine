package com.labengine.engine.camera;

import android.graphics.Matrix;
import android.util.DisplayMetrics;
import android.view.Display;

import com.labengine.engine.LEEntity;
import com.labengine.tools.scene.LELayer;
import com.labengine.tools.sprite.LESimpleSprite;

/**
 * 
 * @author DukeYuri
 * @version 0.2
 * 
 */

public class LECamera {

	// //////////////////////////////////////////////////////////////
	// FIELDS
	// //////////////////////////////////////////////////////////////

	public static final int STYLE_FREELY = 0;
	public static final int STYLE_HORIZONTAL = 1;
	public static final int STYLE_VERTICAL = 2;

	private Matrix matrix;
	
	private float viewPortCenterX, viewPortCenterY;
	
	private float viewPortScaleX, viewPortScaleY;
	
	private float pivotPointX, pivotPointY;
	
	private int textureX, textureY;
	
	private int textureScaleX, textureScaleY;
	
	private float cameraRotation = 0;
	
	private float textureRotation = 0;
	
	private float totalRotation = 0;
	
	private int cameraX, cameraY;
	
	private float totalScaleX, totalScaleY;
	
	private float newTextureX, newTextureY;
	
	private float dx, dy;
	
	private float sinRot, cosRot;
	
	private int cameraZoom;
	
	public static int zoomStyle;

	// //////////////////////////////////////////////////////////////
	// CONSTRUCTOR
	// //////////////////////////////////////////////////////////////

	public LECamera(float x, float y, float width, float height, LESimpleSprite o, Display d) {
		matrix = new Matrix();
		DisplayMetrics metricsB = new DisplayMetrics();
		d.getMetrics(metricsB);
		this.pivotPointX = o.getX();
		this.pivotPointY = o.getY();
		viewPortCenterX = x + width/2;
		viewPortCenterY = y + height/2;
		viewPortScaleX = width / metricsB.widthPixels;
		viewPortScaleY =  height / metricsB.heightPixels;
		update();
	}

	// //////////////////////////////////////////////////////////////
	// GETTERS/SETTERS
	// //////////////////////////////////////////////////////////////

	public void setBounds(int lowerX, int lowerY, int upperX, int upperY) {

	}

	public void setCameraRotation(float rot) {
		this.cameraRotation = rot;
	}

	public Matrix getMatrix() {
		return matrix;
	}

	public void setMatrixParam() {

	}

	// //////////////////////////////////////////////////////////////
	// METHODS
	// //////////////////////////////////////////////////////////////

	public void update() {
		sinRot = (float) Math.sin(-cameraRotation);
		cosRot = (float) Math.cos(-cameraRotation);
		dx = textureX - cameraX;
		dy = textureY - cameraY;

		newTextureX = (dx * cosRot - sinRot * dy) * cameraZoom * viewPortScaleX
				+ viewPortCenterX;
		newTextureY = (dx * sinRot + cosRot * dy) * cameraZoom * viewPortScaleY
				+ viewPortCenterY;

		totalRotation = textureRotation - cameraRotation;
		totalScaleX = textureScaleX * cameraZoom * viewPortScaleX;
		totalScaleY = textureScaleY * cameraZoom * viewPortScaleY;

		pivotPointX *= totalScaleX;
		pivotPointY *= totalScaleY;

		matrix.setScale(totalScaleX, totalScaleY);
		matrix.setTranslate(pivotPointX, pivotPointY);
		matrix.setRotate(totalRotation);
		matrix.setTranslate(newTextureX, newTextureY);
	}

	public void follow(LEEntity o) {
		this.pivotPointX = o.getX();
		this.pivotPointY = o.getY();
		update();
	}

	public void follow(LEEntity o, int STYLE) {

	}

	public void focusOn(int x, int y) {
		this.cameraX = x;
		this.cameraY = y;
		update();
	}

	public class scroll {

	}

	public void destroy() {
		LELayer.cData.remove();
	}

}
