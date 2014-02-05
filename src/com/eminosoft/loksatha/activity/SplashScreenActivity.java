package com.eminosoft.loksatha.activity;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;

public class SplashScreenActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash_screen);
		Handler handler = new Handler();
		handler.postDelayed(new Runnable() {

			@Override
			public void run() {

				Intent in = new Intent(SplashScreenActivity.this,
						MainActivity.class);
				startActivity(in);
				finish();

			}
		}, 1000);
	}

}
