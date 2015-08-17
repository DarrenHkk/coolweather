package com.coolweather.app.view;

import com.coolweather.app.R;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MyEditTextView extends LinearLayout {
	Context mContext;
	int textColor;
	boolean focuable;
	String textString;
	View view;

	public MyEditTextView(Context context) {
		super(context);
		this.mContext = context;
	}

	public MyEditTextView(Context context, AttributeSet attrs) {
		super(context);
		this.mContext = context;
		init(attrs);
		initFindByView();
	}

	private void initFindByView() {
		// TODO Auto-generated method stub
		view = inflate(mContext, R.layout.my_edittext, null);
		TextView tv_text = (TextView) view.findViewById(R.id.tv_text);
		tv_text.setTextColor(textColor);
		tv_text.setText(textString);
		EditText et_text = (EditText) view.findViewById(R.id.et_text);
		et_text.setFocusable(focuable);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);

	}
	

	private void init(AttributeSet attrs) {
		// TODO Auto-generated method stub
		TypedArray ta = mContext.obtainStyledAttributes(attrs,
				R.styleable.editText);
		focuable = ta.getBoolean(R.styleable.editText_focusable, false);
		textColor = ta.getColor(R.styleable.editText_textColor, 0);
		textString = ta.getString(R.styleable.editText_textString);
		ta.recycle();

	}

}
