package com.example.intent_extras;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.example.helloworld.R;

public class UserDataEntryActivity extends Activity {

	private EditText nameEditText;
	private EditText ageEditText;
	private Button enterButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_data_entry);
		nameEditText = (EditText) findViewById(R.id.edittext_username);
		ageEditText = (EditText) findViewById(R.id.edittext_user_age);
		enterButton = (Button) findViewById(R.id.button_enter);
		enterButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getBaseContext(),UserDataShowActivity.class);
				intent.putExtra("name", nameEditText.getText().toString());
				intent.putExtra("age",Integer.parseInt(ageEditText.getText().toString()));
				startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.user_data_entry, menu);
		return true;
	}

}
