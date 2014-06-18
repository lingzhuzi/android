package com.kevin.demo.activity;

import com.kevin.demo.R;

import android.support.v7.app.ActionBarActivity;
import android.text.AlteredCharSequence;
import android.util.Log;
import android.view.View;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

public class LifeCycleActivity extends ActionBarActivity {

	private static final String TAG = "LifeCycleActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_life_cycle);
		Log.d(TAG, "on create");
	}

	@Override
	protected void onStart() {
		super.onStart();
		Log.d(TAG, "on start");
	}

	@Override
	protected void onResume() {
		super.onResume();
		Log.d(TAG, "on resume");
	}

	@Override
	protected void onPause() {
		super.onPause();
		Log.d(TAG, "on pause");
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		Log.d(TAG, "on restart");
	}

	@Override
	protected void onStop() {
		super.onStop();
		Log.d(TAG, "on stop");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.d(TAG, "on destroy");
	}

	public void doPause(View view) {
		Intent intent = new Intent(this, BlankActivity.class); 
		startActivity(intent);
//		Intent i = new Intent(Intent.ACTION_MAIN);
//		i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//		i.addCategory(Intent.CATEGORY_HOME);
//		startActivity(i);
	}

	public void doStop(View view) {
		Intent intent = new Intent(this, Blank2Activity.class); 
		startActivity(intent);
	}
	
	public void doFinish(View view) {
		finish();
	}

}
