package com.example.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadCastReceiver extends BroadcastReceiver {
	public MyBroadCastReceiver() {
	}

	@Override
	public void onReceive(Context context, Intent intent) {

		if(intent.getAction().equals(Intent.ACTION_POWER_CONNECTED))
		{
			Toast.makeText(context, "AC Power source connecteds", Toast.LENGTH_LONG).show();
			Intent receiver = new Intent(context,ReceiverActivity.class);
            receiver.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			context.startActivity(receiver);

		} 
		else if(intent.getAction().equals(Intent.ACTION_POWER_DISCONNECTED))
		{
			Toast.makeText(context, "Power source disconnected", Toast.LENGTH_LONG).show();
			Intent receiver = new Intent(context,ReceiverActivity.class);
			receiver.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			context.startActivity(receiver);
		}
	}
}
