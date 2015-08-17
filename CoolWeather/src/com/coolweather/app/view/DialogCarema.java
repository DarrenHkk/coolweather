package com.coolweather.app.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;

import com.coolweather.app.R;
import com.coolweather.app.util.ScreenUtil;

public class DialogCarema extends Dialog implements
		android.view.View.OnClickListener {
	private SearchDevicesView mSearchDevicesView;
	private Context mContext;
	MyListener listener;

	public interface MyListener {
		public void onClick(Dialog dialog, View view);
	}

	public DialogCarema(Context context, MyListener listener) {
		super(context, R.style.myDialogTheme);
		this.mContext = context;
		this.listener = listener;
		// TODO Auto-generated constructor stub
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		mSearchDevicesView = new SearchDevicesView(mContext);
		mSearchDevicesView.setWillNotDraw(false);
		LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT);
		mSearchDevicesView.setLayoutParams(params);
		setContentView(mSearchDevicesView);
		Window window = getWindow();
		android.view.WindowManager.LayoutParams winParams = window
				.getAttributes();
		winParams.width = ScreenUtil.getScaleWidth(mContext, 0.7f);
		winParams.height = ScreenUtil.getScaleHeight(mContext, 0.2f);
		winParams.gravity = Gravity.CENTER;
		window.setAttributes(winParams);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialog_carema);
		TextView tv_gallery = (TextView) findViewById(R.id.tv_gallery);
		TextView tv_phone = (TextView) findViewById(R.id.tv_photo);
		tv_gallery.setOnClickListener(this);
		tv_phone.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		listener.onClick(this, v);

	}

}
