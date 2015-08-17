package com.coolweather.app.activity;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ActionBar.LayoutParams;
import android.app.Fragment;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.coolweather.app.R;
import com.coolweather.app.application.AppManager;

public class BaseActivity extends FragmentActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		AppManager.getInstance().addActivity(this);
	}

	/*
	 * ��ʾToast
	 */
	public void showMsg(String text) {
		Toast toast = Toast.makeText(this, text, Toast.LENGTH_SHORT);
		toast.show();
	}

	/*
	 * �Զ���ActionBar�Ĳ���
	 */
	public void setActionBar(int layoutId) {
		// TODO Auto-generated method stub
		ActionBar actionBar = (ActionBar) getActionBar();
		View actionbarLayout = LayoutInflater.from(this)
				.inflate(layoutId, null);// �����Զ��岼��
		actionBar.setDisplayShowCustomEnabled(true);
		actionBar.setCustomView(actionbarLayout, new LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));// �����Զ��岼�ֵĸ߶ȺͿ��
		actionBar.setDisplayShowTitleEnabled(false);// ���ر���
		actionBar.setDisplayShowHomeEnabled(false);// ����Logo
		TypedArray actionbarSizeTypedArray = AppManager.getInstance()
				.obtainStyledAttributes(
						new int[] { android.R.attr.actionBarSize });
		float h;
		h = actionbarSizeTypedArray.getDimension(0, 0);

	}

}
