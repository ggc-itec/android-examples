package com.example.intent_extras;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.example.helloworld.R;

public class UserDataShowActivity extends Activity {

	private TextView textviewUsername;
	private TextView textviewUserAge;
	private Button buttonFinish;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_data_show);
		textviewUsername = (TextView) findViewById(R.id.textview_show_username);
		textviewUserAge = (TextView) findViewById(R.id.textview_show_user_age);
		buttonFinish = (Button) findViewById(R.id.button_finish);
		buttonFinish.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		
		processIntent();
		
	}

	private void processIntent() {
		 Intent receivedIntent = getIntent();
		 String name = receivedIntent.getStringExtra("name");
		 int age = receivedIntent.getIntExtra("age", 18);
		 textviewUsername.setText(name);
		 textviewUserAge.setText(Integer.toString(age));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.user_data_show, menu);
		return true;
	}

}
