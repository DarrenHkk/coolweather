package com.coolweather.app.activity;

import android.app.Activity;
import android.os.Bundle;

import com.coolweather.app.application.AppManager;

public class BaseActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		AppManager.getInstance().addActivity(this);
	}

}
