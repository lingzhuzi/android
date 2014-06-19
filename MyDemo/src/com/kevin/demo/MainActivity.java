package com.kevin.demo;

import java.net.URLEncoder;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

public class MainActivity extends AbsChapterActivity {
	private static final String TAG = "MainActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			// TODO add setting page
			return true;
		} else if(id == R.id.action_github) {
			Uri uriUrl = Uri.parse("https://github.com/lingzhuzi/my-android-apps/tree/master/MyDemo");
			Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl); 
			startActivity(launchBrowser);
			return true;
		} else if(id == R.id.action_contact) {
			final Intent email = new Intent(android.content.Intent.ACTION_SENDTO);
			String uriText = "mailto:qdyuyh@126.com" +
					"?subject=" + URLEncoder.encode("my-android-apps/myDemo Feedback"); 
			email.setData(Uri.parse(uriText));
			try {
				startActivity(email);
			} catch (Exception e) {
				Toast.makeText(this, R.string.no_email, Toast.LENGTH_SHORT).show();
			}
			return true;
		} else if(id == R.id.action_about) {
			// TODO add about page
			return true;
		} 
		return super.onOptionsItemSelected(item);
	}

	@Override
	public int getChapterArrayId() {
		return R.array.big_chapters;
	}

	@Override
	public void onChapterItemClick(AdapterView<?> view, View arg1, int index, long arg3) {
		Intent intent = new Intent();
		Class<?> clazz = null;
		switch (index) {
		case 0:
			clazz = ActivityChapterActivity.class;
			break;
		case 1:
			clazz = ViewChapterActivity.class;
			break;
		case 2:
			clazz = ServiceChapterActivity.class;
			break;
		case 3:
			clazz = DataStorageChapterActivity.class;
			break;
		case 4:
			clazz = ContentProviderChapterActivity.class;
			break;
		case 5:
			clazz = BroadcastReceiverChapterActivity.class;
			break;
		}
		intent.setClass(MainActivity.this, clazz);
		startActivity(intent);
	}

}
