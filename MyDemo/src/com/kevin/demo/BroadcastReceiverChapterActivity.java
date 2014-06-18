package com.kevin.demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

public class BroadcastReceiverChapterActivity extends AbsChapterActivity {
	private static final String TAG = "BroadcastReceiverChapterActivity";

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
			clazz = BroadcastReceiverChapterActivity.class;
			break;
		case 1:
			break;
		case 2:
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
		intent.setClass(BroadcastReceiverChapterActivity.this, clazz);
		BroadcastReceiverChapterActivity.this.startActivity(intent);
	}


	@Override
	public int getChapterArrayId() {
		return R.array.broad_cast_receiver_chapters;
	}

}
