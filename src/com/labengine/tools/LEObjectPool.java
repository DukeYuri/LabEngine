package com.labengine.tools;

import java.util.ArrayList;

import android.util.Log;

/**
 * 
 * @author DukeYuri
 * @version 0.1
 * 
 */

public class LEObjectPool<E> {

	// //////////////////////////////////////////////////////////////
	// FIELDS
	// //////////////////////////////////////////////////////////////

	public ArrayList<E> pool;

	private E obj;

	// //////////////////////////////////////////////////////////////
	// CONSTRUCTOR
	// //////////////////////////////////////////////////////////////

	public LEObjectPool() {
		pool = new ArrayList<E>();
	}

	// //////////////////////////////////////////////////////////////
	// GETTERS/SETTERS
	// //////////////////////////////////////////////////////////////

	public E getItemFromPool(int index) {
		if (!isEmpty()) {
			E item = pool.get(index);
			//this.removeItemFromPool(index);
			return item;
		} else {
			Log.w("LEObjectPool", "Pool is empty! New " + obj.getClass() +" object will be create");
			E item = onCreateItemIfEmpty();
			return item;
		}
	}
	
	public int getSizeOfPool() {
		return pool.size();
	}

	// //////////////////////////////////////////////////////////////
	// METHODS
	// //////////////////////////////////////////////////////////////

	public void addItemToPool(E object) {
		pool.add(object);
	}

	public void removeItemFromPool(int index) {
		pool.remove(index);
	}

	public boolean isEmpty() {
		return pool.isEmpty();
	}
	
	public E onCreateItemIfEmpty() {
		return obj;
	}

}
