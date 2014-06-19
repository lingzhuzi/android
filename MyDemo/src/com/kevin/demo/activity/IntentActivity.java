package com.kevin.demo.activity;

import com.kevin.demo.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class IntentActivity extends Activity {
	
	private EditText mTextGet;
	private EditText mTextSend;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_intent);
		mTextGet = (EditText)findViewById(R.id.text_get);
		mTextSend = (EditText)findViewById(R.id.text_send);
		mTextGet.setKeyListener(null);
		Intent intent = getIntent();
		mTextGet.setText(intent.getStringExtra("name"));
	}
	
	public void send(View view){
		Intent intent = new Intent(this, IntentActivity.class);
		intent.putExtra("name", mTextSend.getText().toString());
		startActivity(intent);
	}
}
