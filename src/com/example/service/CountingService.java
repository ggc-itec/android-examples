package com.example.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class CountingService extends Service implements Runnable {

	public static final String TAG = "CountService";
	private boolean RUNNING = true;

	@Override
	public void onCreate() {
		super.onCreate();
		Thread thread = new Thread(this);
		thread.start();
		Log.i(TAG, "Current count: " + ServiceActivity.COUNT);

	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		RUNNING = false;
	}

	@Override
	public void run() {
		while (RUNNING) {
			ServiceActivity.COUNT++;
			Log.i(TAG, "Current count: " + ServiceActivity.COUNT);
			try {
				Thread.sleep(7000);
			} catch (InterruptedException e) {
				Log.e(TAG, e.toString());
			}
		}
	}

	@Override
	public IBinder onBind(Intent arg0) {
		return null;
	}

}
