package com.eminosoft.loksatha.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.eminosoft.loksath.BaseActionBarDrawer;
import com.eminosoft.loksatha.adapters.MainPagerAdapter;
import com.eminosoft.loksatha.util.DepthPageTransformer;

public class MainActivity extends BaseActionBarDrawer implements
		OnItemClickListener {
	ViewPager pager;

	// String pageTitles[];

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		pager = (ViewPager) findViewById(R.id.pager);

		getActionBar().setSubtitle("Loksatta");

		pager.setAdapter(new MainPagerAdapter(getSupportFragmentManager()));
		pager.setPageTransformer(true, new DepthPageTransformer());
		drawerList.setOnItemClickListener(this);

		pager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int page) {
				chaneActionBartitle(page);
				setFocusToSelectedDrawerItem(page);

			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {

			}
		});

	}

	public void chaneActionBartitle(int pos) {

		getActionBar().setTitle(pageTitles[pos]);

	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		drawerLayout.closeDrawers();
		pager.setCurrentItem(arg2);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

}
