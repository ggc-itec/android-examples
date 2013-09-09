package com.example.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class IntentActivity extends Activity {

	public static final int REQUEST_CODE_OTHER_ACTIVITY = 1000;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_intent);
		
		Button startButton = (Button) findViewById(R.id.button_start_activity_intent);
		startButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(), IntentOtherActivity.class);
				startActivityForResult(intent, REQUEST_CODE_OTHER_ACTIVITY);
			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode == REQUEST_CODE_OTHER_ACTIVITY) {
			String info = data.getExtras().getString("section");
			Toast toast = Toast.makeText(getApplicationContext(), 
					"Request Code: " + requestCode + "\nResult Code: " + resultCode  + "\nData " + info, Toast.LENGTH_LONG);
			toast.show();
		}
		
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.intent, menu);
		return true;
	}

}
