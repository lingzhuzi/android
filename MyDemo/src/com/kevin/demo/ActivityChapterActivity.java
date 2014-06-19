package com.kevin.demo;

import com.kevin.demo.activity.IntentActivity;
import com.kevin.demo.activity.LifeCycleActivity;
import com.kevin.demo.activity.StartActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

public class ActivityChapterActivity extends AbsChapterActivity {
	private static final String TAG = "ActivityChapterActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public void onChapterItemClick(AdapterView<?> view, View arg1, int index, long arg3) {
		// TODO Auto-generated method stub
		Intent intent = new Intent();
		Class<?> clazz = null;
		switch (index) {
		case 0:
			clazz = LifeCycleActivity.class;
			break;
		case 1:
			clazz = StartActivity.class;
			break;
		case 2:
			clazz = IntentActivity.class;
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		case 7:
			break;

		}
		intent.setClass(ActivityChapterActivity.this, clazz);
		startActivity(intent);
	}


	@Override
	public int getChapterArrayId() {
		return R.array.activity_chapters;
	}

}
