package com.labengine.audio;

import java.util.ArrayList;

/**
 * 
 * @author DukeYuri
 * @version 0.1
 * 
 */

public class LESoundPlayer {
	
	////////////////////////////////////////////////////////////////
	// FIELDS                                                     //
	////////////////////////////////////////////////////////////////

	private static ArrayList<LESound> tracks = new ArrayList<LESound>();
	
	////////////////////////////////////////////////////////////////
	// CONSTRUCTOR                                                //
	////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////
	// GETTERS/SETTERS                                            //
	////////////////////////////////////////////////////////////////
	
	public static LESound getTrackByName(String name) {
		LESound t = null;
		for (LESound a : tracks) {
			if (a.getName() == name) {
				t = a;
				break;
			}
		}
		return t;
	}
	
	////////////////////////////////////////////////////////////////
	// METHODS                                                    //
	////////////////////////////////////////////////////////////////
	
	public static void addTrack(int resid, String name,
			boolean looped) {
		LESound track = new LESound(resid, name, looped);
		tracks.add(track);
	}

	public static void playAll() {
		for (LESound a : tracks) {
			if (a.isPlayable()) {
				a.start();
			}
		}
	}

	public static void stopAll() {
		for (LESound a : tracks) {
			a.stop();
		}
	}
}
