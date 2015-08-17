package com.coolweather.app.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.coolweather.app.BuildConfig;
import com.coolweather.app.R;
import com.coolweather.app.util.ScreenUtil;

public class SearchDevicesView extends RelativeLayout {

	public static final String TAG = "SearchDevicesView";
	public static final boolean D = BuildConfig.DEBUG;

	@SuppressWarnings("unused")
	private long TIME_DIFF = 1500;

	int[] lineColor = new int[] { 0x7B, 0x7B, 0x7B };
	int[] innerCircle0 = new int[] { 0xb9, 0xff, 0xFF };
	int[] innerCircle1 = new int[] { 0xdf, 0xff, 0xFF };
	int[] innerCircle2 = new int[] { 0xec, 0xff, 0xFF };

	int[] argColor = new int[] { 0xF3, 0xf3, 0xfa };

	private float offsetArgs = 0;
	private boolean isSearching = false;
	private Bitmap bitmap;
	private Bitmap bitmap1;
	private Bitmap bitmap2;

	public boolean isSearching() {
		return isSearching;
	}

	public void setSearching(boolean isSearching) {
		this.isSearching = isSearching;
		offsetArgs = 0;
		invalidate();
	}

	public SearchDevicesView(Context context) {
		super(context);
		initBitmap();
	}

	public SearchDevicesView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initBitmap();
	}

	public SearchDevicesView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initBitmap();
	}

	private void initBitmap() {
		if (bitmap == null) {
			bitmap = Bitmap.createBitmap(BitmapFactory.decodeResource(
					getContext().getResources(), R.drawable.gplus_search_bg));
			bitmap = getResizedBitmap(bitmap,
					ScreenUtil.getScaleWidth(getContext(), 0.8f),
					ScreenUtil.getScaleWidth(getContext(), 0.8f));
		}
		if (bitmap1 == null) {
			bitmap1 = Bitmap.createBitmap(BitmapFactory.decodeResource(
					getContext().getResources(), R.drawable.locus_round_click));
		}
		if (bitmap2 == null) {
			bitmap2 = Bitmap.createBitmap(BitmapFactory.decodeResource(
					getContext().getResources(), R.drawable.gplus_search_args));
			bitmap2 = getResizedBitmap(bitmap2,
					ScreenUtil.getScaleWidth(getContext(), 0.5f),
					ScreenUtil.getScaleWidth(getContext(), 0.5f));
		}
	}

	@SuppressLint("DrawAllocation")
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		canvas.drawBitmap(bitmap, getWidth() / 2 - bitmap.getWidth() / 2,
				getHeight() / 2 - bitmap.getHeight() / 2, null);

		if (isSearching) {

			Rect rMoon = new Rect(getWidth() / 2 - bitmap2.getWidth(),
					getHeight() / 2, getWidth() / 2, getHeight() / 2
							+ bitmap2.getHeight());
			canvas.rotate(offsetArgs, getWidth() / 2, getHeight() / 2);
			canvas.drawBitmap(bitmap2, null, rMoon, null);
			offsetArgs = offsetArgs + 3;
		} else {

			canvas.drawBitmap(bitmap2, getWidth() / 2 - bitmap2.getWidth(),
					getHeight() / 2, null);
		}

		canvas.drawBitmap(bitmap1, getWidth() / 2 - bitmap1.getWidth() / 2,
				getHeight() / 2 - bitmap1.getHeight() / 2, null);

		if (isSearching)
			invalidate();
	}

	public Bitmap getResizedBitmap(Bitmap bm, int newHeight, int newWidth) {
		int width = bm.getWidth();
		int height = bm.getHeight();
		float scaleWidth = ((float) newWidth) / width;
		float scaleHeight = ((float) newHeight) / height;
		Matrix matrix = new Matrix();
		matrix.postScale(scaleWidth, scaleHeight);
		Bitmap resizedBitmap = Bitmap.createBitmap(bm, 0, 0, width, height,
				matrix, false);
		return resizedBitmap;
	}
}