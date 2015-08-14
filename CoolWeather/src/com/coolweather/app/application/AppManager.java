package com.coolweather.app.application;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.Application;

public class AppManager extends Application {
	private List<Activity> activitys = new ArrayList<Activity>();
	/**
	 * Ӧ��ʵ��
	 */
	private static AppManager instance;

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		instance = this;
	}

	public static AppManager getInstance() {
		return instance;
	}

	/**
	 * �½�һ��activity
	 * 
	 * @param activity
	 */
	public void addActivity(Activity activity) {
		activitys.add(activity);
	}

	/**
	 * ����ָ����activity
	 */
	public void finishActivity(Activity activity) {
		if (activity != null) {
			activity.finish();
		}
	}

	/**
	 * Ӧ���˳���������Activity
	 */
	public void exit() {
		for (Activity activity : activitys) {
			if (activity != null) {
				activity.finish();
			}
		}
	}

}
