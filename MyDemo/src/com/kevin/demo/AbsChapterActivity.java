package com.kevin.demo;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public abstract class AbsChapterActivity extends ActionBarActivity {

	private static final String TAG = "AbsChapterActivity";
	private ListView mListView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chapter);
		findViews();
		setAdapter();
		bindEvents();
	}

	private void findViews() {
		mListView = (ListView) findViewById(R.id.chapter_list);
	}

	private void setAdapter() {
		String[] chapters = getResources().getStringArray(getChapterArrayId());
		ArrayAdapter<String> chapterAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, chapters);
		mListView.setAdapter(chapterAdapter);
	}

	public abstract int getChapterArrayId();
	public abstract void onChapterItemClick(AdapterView<?> view, View arg1, int index, long arg3);

	private void bindEvents() {
		mListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> view, View arg1, int index, long arg3) {
				Log.d(TAG, "item " + index + " of list clicked.");
				String text = (String) view.getItemAtPosition(index);
				Log.d(TAG, "item is : " + text);
				onChapterItemClick(view, arg1, index, arg3);
			}
		});
	}

}
