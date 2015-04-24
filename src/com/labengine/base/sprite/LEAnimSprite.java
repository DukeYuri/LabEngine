package com.labengine.base.sprite;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * 
 * @author DukeYuri
 * @version 0.1
 * 
 */

public class LEAnimSprite extends LESimpleSprite {

	// //////////////////////////////////////////////////////////////
	// FIELDS 
	// //////////////////////////////////////////////////////////////

	protected int fWidth;

	protected int fHeight;

	protected boolean animated;

	protected int frameCount;

	protected Bitmap[] bmpList;

	protected int[] frameLen;

	protected int curFrame;

	protected int curFrameCounter;

	// //////////////////////////////////////////////////////////////
	// CONSTRUCTOR 
	// //////////////////////////////////////////////////////////////

	public LEAnimSprite(String s, int FrameCount) {
		super(s);
		this.frameCount = FrameCount;
		this.fHeight = this.height;
		this.fWidth = this.width / this.frameCount;
		this.MakeFrames();
	}

	// //////////////////////////////////////////////////////////////
	// GETTERS/SETTERS 
	// //////////////////////////////////////////////////////////////

	@Override
	public int getWidth() {
		return fWidth;
	}

	@Override
	public int getHeight() {
		return fHeight;
	}

	public int getFrameCount() {
		return frameCount;
	}

	public int getCurFrame() {
		return curFrame;
	}

	public void setCurFrame(int curFrame) {
		this.curFrame = curFrame;
	}

	public void setFrameLen(int[] frameLen) {
		if (this.frameLen.length >= this.frameCount)
			this.frameLen = frameLen;
	}

	public void setAnimated(boolean animated) {
		this.animated = animated;
	}

	// //////////////////////////////////////////////////////////////
	// METHODS 
	// //////////////////////////////////////////////////////////////

	public void MakeFrames() {
		curFrame = 0;
		bmpList = new Bitmap[this.frameCount];
		frameLen = new int[this.frameCount];
		for (int i = 0; i < this.frameCount; i++) {
			bmpList[i] = Bitmap.createBitmap(bmp, i * this.fWidth, 0,
					this.fWidth, this.fHeight);
			frameLen[i] = 1;
		}
	}

	@Override
	public void draw(Canvas c, Paint p) {
		if (show) {
			if (curFrameCounter >= frameLen[curFrame]) {
				curFrameCounter = 1;
				if (curFrame == frameCount - 1) {
					curFrame = 0;
				} else {
					curFrame++;
				}
			}
			c.drawBitmap(bmpList[this.curFrame], this.x, this.y, p);
			if (this.animated) {
				curFrameCounter++;
			}
		}
	}

	public void draw(Canvas c, Paint p, int dx, int dy) {
		if (show) {
			if (curFrameCounter >= frameLen[curFrame]) {
				curFrameCounter = 1;
				if (curFrame == frameCount - 1) {
					curFrame = 0;
				} else {
					curFrame++;
				}
			}
			c.drawBitmap(bmpList[this.curFrame], this.x + dx, this.y + dy, p);
			if (this.animated) {
				curFrameCounter++;
			}
		}
	}

	@Override
	public boolean isSelected(float x, float y) {
		selected = false;
		if (x > this.x && x < (this.x + this.fWidth) && y > this.y
				&& y < (this.y + this.fHeight)) {
			selected = true;
		}
		return selected;
	}

	public boolean isAnimated() {
		return animated;
	}

}
