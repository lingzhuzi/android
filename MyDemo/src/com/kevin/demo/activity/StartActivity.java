package com.kevin.demo.activity;

import com.kevin.demo.R;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class StartActivity extends ActionBarActivity {

	private PlaceholderFragment mFrag;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start);

		if (savedInstanceState == null) {
			mFrag = new PlaceholderFragment();
			getSupportFragmentManager().beginTransaction().add(R.id.container, mFrag).commit();
		} else {
			mFrag = (PlaceholderFragment) getSupportFragmentManager().findFragmentById(R.id.container);
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
		super.onActivityResult(requestCode, resultCode, intent);
		mFrag.setResult(requestCode, resultCode, intent);
		Toast.makeText(this, "onActivityResult", Toast.LENGTH_LONG).show();
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		private View view;
		private TextView mTextResult;
		private Button mBtnStart;
		private Button mBtnStartForResult;
		private int requestCode = 1;

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
			view = inflater.inflate(R.layout.fragment_start, container, false);
			return view;
		}

		@Override
		public void onActivityCreated(Bundle savedInstanceState) {
			super.onActivityCreated(savedInstanceState);
			mTextResult = (TextView) view.findViewById(R.id.result_text);
			mBtnStart = (Button) view.findViewById(R.id.btn_start);
			mBtnStartForResult = (Button) view.findViewById(R.id.btn_start_for_result);
			mBtnStart.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {
					if (getActivity() == null) {
						return;
					}

					Intent intent = new Intent(getActivity(), ResultActivity.class);
					getActivity().startActivity(intent);
				}
			});

			mBtnStartForResult.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {
					if (getActivity() == null) {
						return;
					}

					Intent intent = new Intent(getActivity(), ResultActivity.class);
					getActivity().startActivityForResult(intent, requestCode);
				}
			});
		}

		public void setResult(int requestCode, int resultCode, Intent intent) {
			if (requestCode == this.requestCode && resultCode == Activity.RESULT_OK) {
				String result = intent.getStringExtra("result");
				mTextResult.setText("result is :" + result);
			} else {
				mTextResult.setText("no result.");
			}
		}
	}

}
