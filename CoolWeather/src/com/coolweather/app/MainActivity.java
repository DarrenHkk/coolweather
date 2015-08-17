package com.coolweather.app;

import com.coolweather.app.activity.BaseActivity;
import com.coolweather.app.util.HttpCallBackListener;
import com.coolweather.app.util.HttpUtil;
import com.coolweather.app.view.DialogCarema;
import com.coolweather.app.view.DialogCarema.MyListener;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends BaseActivity {
	Button btn_carema;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btn_carema = (Button) findViewById(R.id.btn_carema);

		btn_carema.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Dialog dialog = new DialogCarema(MainActivity.this,
						new MyListener() {
							@Override
							public void onClick(Dialog dialog, View v) {
								// TODO Auto-generated method stub
								switch (v.getId()) {
								case R.id.tv_gallery:
									dialog.dismiss();
									showMsg("点击了相册");
									break;
								case R.id.tv_photo:
									dialog.dismiss();
									showMsg("点击了拍照");
									break;
								default:
									break;
								}
							}
						});
				dialog.show();

			}
		});
		HttpUtil.sendHttpRequest("www.baidu.com", new HttpCallBackListener() {

			@Override
			public void onFinish(String response) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onError(Exception e) {
				// TODO Auto-generated method stub

			}
		});
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
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
