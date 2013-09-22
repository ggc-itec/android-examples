package com.example.service;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.example.helloworld.R;

public class ServiceActivity extends Activity {

	private Button startButton;
	private Button stopButton;
	private TextView countTextView;
	private Intent service;
	
	public static int COUNT = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_service);
		
		startButton = (Button) findViewById(R.id.service_start_button);
		stopButton = (Button) findViewById(R.id.service_stop_button);
		countTextView = (TextView) findViewById(R.id.service_count_textview);
		
		countTextView.setText(String.valueOf(COUNT));
		
		startButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				service = new Intent(getBaseContext(),CountingService.class);
				startService(service);
				Log.i("PRESS","started service");

			}
		});
		
		stopButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				service = new Intent(getBaseContext(),CountingService.class);
				stopService(service);
				Log.i("PRESS","ending service");
			}
		});
		
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		countTextView.setText(String.valueOf(COUNT));
		Log.i("PRESS","refreshing textview");
	}
	

	
	
	
}
