package com.unisofia.android.servicesexample.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.unisofia.android.servicesexample.R;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button startedServiceButton = (Button) findViewById(R.id.button_started);
		Button boundedServiceButton = (Button) findViewById(R.id.button_bounded);

		startedServiceButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, ToastActivity.class);
				startActivity(intent);
			}
		});

		boundedServiceButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, RandomActivity.class);
				startActivity(intent);
			}
		});
	}

}
