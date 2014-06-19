package com.kevin.demo.activity;

import com.kevin.demo.R;
import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class ResultActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction().add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {
		private EditText mEditText;
		private Button mBtnSure;

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_result, container, false);
			mEditText = (EditText) rootView.findViewById(R.id.edit_text);
			mBtnSure = (Button) rootView.findViewById(R.id.btn_sure);
			return rootView;
		}

		@Override
		public void onActivityCreated(Bundle savedInstanceState) {
			super.onActivityCreated(savedInstanceState);
			bindEvents();
		}

		private void bindEvents() {
			mBtnSure.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {
					sureAndBack();
				}
			});
		}

		private void sureAndBack() {
			String text = mEditText.getText().toString();
			Intent data = new Intent();
			data.putExtra("result", text);
			if (getActivity() == null) {
				return;
			}

			getActivity().setResult(RESULT_OK, data);
			getActivity().finish();
		}
	}

}
