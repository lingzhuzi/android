package com.kevin.demo.activity;

import com.kevin.demo.R;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

public class BlankActivity extends ActionBarActivity {

	private static final String TAG = "BlankActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_blank);
	}
}
