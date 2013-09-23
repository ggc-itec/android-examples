package com.example.broadcastreceiver;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;

import com.example.helloworld.R;

public class ReceiverActivity extends Activity {

	private MyBroadCastReceiver receiver;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_receiver);

		receiver = new MyBroadCastReceiver();
		IntentFilter filter1 = new IntentFilter(Intent.ACTION_POWER_CONNECTED);
		IntentFilter filter2 = new IntentFilter(Intent.ACTION_POWER_DISCONNECTED);
		//registerReceiver(receiver, filter1);
		//registerReceiver(receiver, filter2);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.receiver, menu);
		return true;
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		//unregisterReceiver(receiver);
	}

}
