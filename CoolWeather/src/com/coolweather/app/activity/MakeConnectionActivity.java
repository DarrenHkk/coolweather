package com.coolweather.app.activity;

import java.util.ArrayList;
import java.util.List;

import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

import com.coolweather.app.R;
import com.coolweather.app.fragment.WaitOrderReceiverFragment;
import com.coolweather.app.fragment.WaitClaimGoodsFragment;
import com.coolweather.app.fragment.SendNowFragment;
import com.coolweather.app.fragment.YetArrivedFragment;

public class MakeConnectionActivity extends BaseActivity {
	private ViewPager viewPager;// ҳ������
	private View view;// ����ͼƬ
	private TextView tv_tab1, tv_tab2, tv_tab3, tv_tab4;// ѡ������
	private List<Fragment> fragments;// Tabҳ���б�
	private int offset = 0;// ����ͼƬƫ����
	private int currIndex = 0;// ��ǰҳ�����
	private int bmpW;// ����ͼƬ���
	private int selectedColor, unSelectedColor;
	/** ҳ������ **/
	private static final int pageSize = 4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		// ����ActionBar�Ĳ���
		setActionBar(R.layout.actionbar_style);
		setContentView(R.layout.activity_make_connection);
		initView();
	}

	private void initView() {
		selectedColor = getResources()
				.getColor(R.color.tab_title_pressed_color);
		unSelectedColor = getResources().getColor(
				R.color.tab_title_normal_color);

		InitImageView();
		InitTextView();
		InitViewPager();
	}

	/**
	 * ��ʼ��Viewpagerҳ
	 */
	private void InitViewPager() {
		viewPager = (ViewPager) findViewById(R.id.vPager);
		fragments = new ArrayList<Fragment>();
		fragments.add(new WaitOrderReceiverFragment());
		fragments.add(new WaitClaimGoodsFragment());
		fragments.add(new SendNowFragment());
		fragments.add(new YetArrivedFragment());
		viewPager.setAdapter(new myPagerAdapter(getSupportFragmentManager(),
				fragments));
		viewPager.setCurrentItem(0);
		viewPager.setOnPageChangeListener(new MyOnPageChangeListener());
	}

	/**
	 * ��ʼ��ͷ��
	 * 
	 */
	private void InitTextView() {
		tv_tab1 = (TextView) findViewById(R.id.tab_1);
		tv_tab2 = (TextView) findViewById(R.id.tab_2);
		tv_tab3 = (TextView) findViewById(R.id.tab_3);
		tv_tab4 = (TextView) findViewById(R.id.tab_4);

		tv_tab1.setTextColor(selectedColor);
		tv_tab2.setTextColor(unSelectedColor);
		tv_tab3.setTextColor(unSelectedColor);
		tv_tab4.setTextColor(unSelectedColor);

		tv_tab1.setText("���ӵ�");
		tv_tab2.setText("��ȡ��");
		tv_tab3.setText("������");
		tv_tab4.setText("���ʹ�");

		tv_tab1.setOnClickListener(new MyOnClickListener(0));
		tv_tab2.setOnClickListener(new MyOnClickListener(1));
		tv_tab3.setOnClickListener(new MyOnClickListener(2));
		tv_tab4.setOnClickListener(new MyOnClickListener(3));
	}

	/**
	 * ��ʼ���������������ҳ������ʱ������ĺ���Ҳ������Ч������������Ҫ����һЩ����
	 */

	private void InitImageView() {
		view = (View) findViewById(R.id.cursor);

		/*
		 * bmpW = BitmapFactory.decodeResource(getResources(),
		 * R.drawable.tab_selected_bg).getWidth();// ��ȡͼƬ���
		 */
		// bmpW = view.getMeasuredWidth();
		// showMsg(bmpW + "");
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		int screenW = dm.widthPixels;// ��ȡ�ֱ��ʿ��
		bmpW = screenW / 8;
		showMsg(bmpW+"");
		offset = (screenW / pageSize-bmpW) / 2;// ����ƫ����--(��Ļ���/ҳ������-viewʵ�ʿ��)/2
													// = ƫ����
		Matrix matrix = new Matrix();
		matrix.postTranslate(offset, 0);
		// view.setImageMatrix(matrix);// ���ö�����ʼλ��
	}

	/**
	 * ͷ��������
	 */
	private class MyOnClickListener implements OnClickListener {
		private int index = 0;

		public MyOnClickListener(int i) {
			index = i;
		}

		public void onClick(View v) {

			switch (index) {
			case 0:
				tv_tab1.setTextColor(selectedColor);
				tv_tab2.setTextColor(unSelectedColor);
				tv_tab3.setTextColor(unSelectedColor);
				tv_tab4.setTextColor(unSelectedColor);
				break;
			case 1:
				tv_tab2.setTextColor(selectedColor);
				tv_tab1.setTextColor(unSelectedColor);
				tv_tab3.setTextColor(unSelectedColor);
				tv_tab4.setTextColor(unSelectedColor);
				break;
			case 2:
				tv_tab3.setTextColor(selectedColor);
				tv_tab1.setTextColor(unSelectedColor);
				tv_tab2.setTextColor(unSelectedColor);
				tv_tab4.setTextColor(unSelectedColor);
				break;
			case 3:
				tv_tab4.setTextColor(selectedColor);
				tv_tab1.setTextColor(unSelectedColor);
				tv_tab2.setTextColor(unSelectedColor);
				tv_tab3.setTextColor(unSelectedColor);
				break;
			}
			viewPager.setCurrentItem(index);
		}

	}

	/**
	 * Ϊѡ��󶨼�����
	 */
	public class MyOnPageChangeListener implements OnPageChangeListener {

		int one = offset * 2 + bmpW;// ҳ��1 -> ҳ��2 ƫ����
		int two = one * 2;// ҳ��1 -> ҳ��3 ƫ����

		public void onPageScrollStateChanged(int index) {
		}

		public void onPageScrolled(int arg0, float arg1, int arg2) {
		}

		public void onPageSelected(int index) {
			Animation animation = new TranslateAnimation(one * currIndex, one
					* index, 0, 0);// ��Ȼ����Ƚϼ�ֻ࣬��һ�д��롣
			currIndex = index;
			animation.setFillAfter(true);// True:ͼƬͣ�ڶ�������λ��
			animation.setDuration(300);
			view.startAnimation(animation);

			switch (index) {
			case 0:
				tv_tab1.setTextColor(selectedColor);
				tv_tab2.setTextColor(unSelectedColor);
				tv_tab3.setTextColor(unSelectedColor);
				tv_tab4.setTextColor(unSelectedColor);
				break;
			case 1:
				tv_tab2.setTextColor(selectedColor);
				tv_tab1.setTextColor(unSelectedColor);
				tv_tab3.setTextColor(unSelectedColor);
				tv_tab4.setTextColor(unSelectedColor);
				break;
			case 2:
				tv_tab3.setTextColor(selectedColor);
				tv_tab1.setTextColor(unSelectedColor);
				tv_tab2.setTextColor(unSelectedColor);
				tv_tab4.setTextColor(unSelectedColor);
				break;
			case 3:
				tv_tab4.setTextColor(selectedColor);
				tv_tab1.setTextColor(unSelectedColor);
				tv_tab2.setTextColor(unSelectedColor);
				tv_tab3.setTextColor(unSelectedColor);
			}
		}
	}

	/**
	 * ����������
	 */
	class myPagerAdapter extends FragmentPagerAdapter {
		private List<Fragment> fragmentList;

		public myPagerAdapter(FragmentManager fm, List<Fragment> fragmentList) {
			super(fm);
			this.fragmentList = fragmentList;
		}

		/**
		 * �õ�ÿ��ҳ��
		 */
		@Override
		public Fragment getItem(int arg0) {
			return (fragmentList == null || fragmentList.size() == 0) ? null
					: fragmentList.get(arg0);
		}

		/**
		 * ÿ��ҳ���title
		 */
		@Override
		public CharSequence getPageTitle(int position) {
			return null;
		}

		/**
		 * ҳ����ܸ���
		 */
		@Override
		public int getCount() {
			return fragmentList == null ? 0 : fragmentList.size();
		}
	}
}
