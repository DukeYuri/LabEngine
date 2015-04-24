package com.labengine.physics;


public class LECollision {

	// //////////////////////////////////////////////////////////////
	// FIELDS
	// //////////////////////////////////////////////////////////////
	
	private LERectBody pB1, pB2;
	
	public float cX, cY;

	// //////////////////////////////////////////////////////////////
	// CONSTRUCTOR
	// //////////////////////////////////////////////////////////////
	
	public LECollision(LERectBody pB1, LERectBody pB2) {
		this.pB1 = pB1;
		this.pB2 = pB2;
	}

	// //////////////////////////////////////////////////////////////
	// GETTERS/SETTERS
	// //////////////////////////////////////////////////////////////
	
	public float getCenterX() {
		return pB1.getCenterX();
	}
	
	public float getCenterY() {
		return pB1.getCenterY();
	}
	
	public float getHalfExtentsW() {
		return pB1.getHalfExtentsW();
	}
	
	public float getHalfExtentsH() {
		return pB1.getHalfExtentsH();
	}

	// //////////////////////////////////////////////////////////////
	// METHODS
	// //////////////////////////////////////////////////////////////
	
	public boolean collisonDetection() {
		cX = Math.abs(pB1.getCenterX() - pB2.getCenterX()) - (pB1.getHalfExtentsW() + pB2.getHalfExtentsW());
		cY = Math.abs(pB1.getCenterY() - pB2.getCenterY()) - (pB1.getHalfExtentsH() + pB2.getHalfExtentsH());
		return cX < 0 && cY < 0;
	}

}
