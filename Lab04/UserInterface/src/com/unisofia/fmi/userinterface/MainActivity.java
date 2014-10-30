package com.unisofia.fmi.userinterface;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends Activity {

	private ImageView mProfileImageView;
	private EditText mFirstNameEditText;
	private EditText mLastNameEditText;
	private EditText mEmailEditText;
	private EditText mPhoneEditText;
	private EditText mPasswordEditText;
	private EditText mPasswordAgainEditText;
	private Button mSubmitButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mProfileImageView = (ImageView) findViewById(R.id.imageview_profile);
		mFirstNameEditText = (EditText) findViewById(R.id.edittext_first_name);
		mLastNameEditText = (EditText) findViewById(R.id.edittext_last_name);
		mEmailEditText = (EditText) findViewById(R.id.edittext_email);
		mPhoneEditText = (EditText) findViewById(R.id.edittext_phone);
		mPasswordEditText = (EditText) findViewById(R.id.edittext_password);
		mPasswordAgainEditText = (EditText) findViewById(R.id.edittext_password_again);
		mSubmitButton = (Button) findViewById(R.id.button_submit);

		mSubmitButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (!isInputValid()) {
					mPasswordEditText
							.setError(getString(R.string.error_invalid_password));
				}
			}
		});
	}

	private boolean isInputValid() {
		String firstName = mFirstNameEditText.getText().toString();
		String lastName = mLastNameEditText.getText().toString();
		String email = mEmailEditText.getText().toString();
		String phone = mPhoneEditText.getText().toString();
		String password = mPasswordEditText.getText().toString();
		String passwordAgain = mPasswordAgainEditText.getText().toString();

		// TODO HOMEWORK: validate all data

		if (!password.equals(passwordAgain)) {
			return false;
		}

		StringBuilder name = new StringBuilder();
		name.append(firstName).append(" ").append(lastName);

		Intent detailsIntent = new Intent(this, DetailsActivity.class);
		detailsIntent.putExtra(Extras.EXTRA_NAME, name.toString());
		detailsIntent.putExtra(Extras.EXTRA_EMAIL, email);
		detailsIntent.putExtra(Extras.EXTRA_PHONE, phone);

		startActivity(detailsIntent);

		return true;
	}
}
