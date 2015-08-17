package com.coolweather.app.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.Context;
import android.os.Bundle;
import android.view.WindowManager;

/**
 * @author: Devin on: 14-2-10.
 */
public class ScreenUtil {
	private static double EARTH_RADIUS = 6378137.0;

	private static double rad(double d) {
		return d * Math.PI / 180.0;
	}

	public static double getDistance(double lat1, double lng1, double lat2,
			double lng2) {
		double radLat1 = rad(lat1);
		double radLat2 = rad(lat2);
		double a = radLat1 - radLat2;
		double b = rad(lng1) - rad(lng2);
		double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)
				+ Math.cos(radLat1) * Math.cos(radLat2)
				* Math.pow(Math.sin(b / 2), 2)));
		s = s * EARTH_RADIUS;
		s = Math.round(s * 10000) / 10000;
		return s;
	}

	public static String getDate(String format) {
		SimpleDateFormat formatBuilder = new SimpleDateFormat(format);
		return formatBuilder.format(new Date());
	}

	public static String getDate() {
		return getDate("MMddhhmmss");
	}

	/**
	 * 鑾峰彇灞忓箷灏哄
	 *
	 * @param context
	 * @return
	 */
	public static int[] getScreenSize(Context context) {
		WindowManager wm = (WindowManager) context
				.getSystemService(Context.WINDOW_SERVICE);
		int width = wm.getDefaultDisplay().getWidth();
		int height = wm.getDefaultDisplay().getHeight();
		int[] sizes = { width, height };

		return sizes;
	}

	public static int getScreenWidth(Context context) {
		int[] sizes = getScreenSize(context);
		return sizes[0];
	}

	public static int getScreenHeight(Context context) {
		int[] sizes = getScreenSize(context);
		return sizes[1];
	}

	public static int getRealWidth(Context mContext, int scale) {
		return (int) ((1f / scale) * ScreenUtil.getScreenWidth(mContext));
	}

	public static int getRealHeight(Context mContext, int scale) {
		return (int) ((1f / scale) * ScreenUtil.getScreenHeight(mContext));
	}

	public static int getScaleWidth(Context mContext, float scale) {
		return (int) (scale * ScreenUtil.getScreenWidth(mContext));
	}

	public static int getScaleHeight(Context mContext, float scale) {
		return (int) (scale * ScreenUtil.getScreenHeight(mContext));
	}

	/**
	 * 鏍规嵁鎵嬫満鐨勫垎杈ㄧ巼浠�px(鍍忕礌) 鐨勫崟浣�杞垚涓�dp
	 */
	public static int px2dip(Context context, float pxValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (pxValue / scale + 0.5f);
	}

	// 鎵撳嵃鎵�湁鐨�intent extra 鏁版嵁
	public static String printBundle(Bundle bundle) {
		StringBuilder sb = new StringBuilder();
		for (String key : bundle.keySet()) {
			sb.append("\nkey:" + key + ", value:" + bundle.getString(key));
		}
		return sb.toString();
	}

}
