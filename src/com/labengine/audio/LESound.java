package com.labengine.audio;

import android.media.MediaPlayer;

import com.labengine.engine.LESettings;
import com.labengine.ui.activity.LEBaseGameActivity;

/**
 * 
 * @author DukeYuri
 * @version 0.1
 * 
 */

public class LESound {

	////////////////////////////////////////////////////////////////
	// FIELDS 													  
	////////////////////////////////////////////////////////////////

	private MediaPlayer track;
	private boolean playable;
	private String name;
	
	////////////////////////////////////////////////////////////////
	// CONSTRUCTOR                                                
	////////////////////////////////////////////////////////////////

	public LESound(int resid, String name, boolean looped) {
		this.playable = true;
		this.track = MediaPlayer.create(LEBaseGameActivity.context, resid);
		this.track.setLooping(looped);
		this.name = name;
	}
	
	////////////////////////////////////////////////////////////////
	// GETTERS/SETTERS                                            
	////////////////////////////////////////////////////////////////

	public void setPlayable(boolean playable) {
		this.playable = playable;
	}

	public String getName() {
		return name;
	}
	
	////////////////////////////////////////////////////////////////
	// METHODS                                                    
	////////////////////////////////////////////////////////////////
	
	public void start() {
		if (LESettings.isSound()) {
			if (!track.isPlaying())
				track.start();
		} else
			this.stop();
	}

	public void forceStart() {
		if (LESettings.isSound()) {
			if (track.isPlaying()) {
				track.pause();
				track.seekTo(0);
				track.start();
			} else {
				track.start();
			}
		}
	}

	public void stop() {
		if (track.isPlaying())
			track.pause();
	}

	public void rewind() {
		this.stop();
		track.seekTo(0);
		this.start();
	}

	public boolean isPlayable() {
		return playable;
	}
}
