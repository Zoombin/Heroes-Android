package com.juhe.heroes.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import com.juhe.heroes.R;

public class BgMusicService extends Service {
	MediaPlayer player;

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		player = MediaPlayer.create(this, R.raw.bgmusic);
		player.setLooping(true);
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		if (!player.isPlaying()) {
			player.start();
		}
		return START_STICKY;
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		if (player.isPlaying()) {
			player.stop();
		}
		player.release();
		super.onDestroy();
	}

}
