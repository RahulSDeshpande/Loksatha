package com.eminosoft.loksatha.fragment;

import com.eminosoft.loksatha.activity.R;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class NewsHomeTabsFragment extends Fragment implements TabListener {

	private ActionBar actionBar;
	private LinearLayout mTabContiner;

	// @Override
	// public void onCreate(Bundle savedInstanceState) {
	// super.onCreate(savedInstanceState);
	// if (savedInstanceState == null) {
	// getActivity().getActionBar().setNavigationMode(
	// ActionBar.NAVIGATION_MODE_TABS);
	// }
	// }

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		actionBar = getActivity().getActionBar();
		String[] tabnames = getResources().getStringArray(
				R.array.newsfeed_tab_array);
		View view = inflater.inflate(R.layout.fragment_news_feed_tabs,
				container, false);
		mTabContiner = (LinearLayout) view.findViewById(R.id.fragmentContainer);

		// if (savedInstanceState == null) {
		// for (int i = 0; i < tabnames.length; i++) {
		// actionBar.addTab(actionBar.newTab().setText(tabnames[i])
		// .setTabListener(this));
		//
		// }
		// }

		return view;
	}

	@Override
	public void onTabReselected(Tab tab, android.app.FragmentTransaction ft) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTabSelected(Tab tab, android.app.FragmentTransaction ft) {
		// if (tab.getPosition() == 0) {
		Fragment fragment = new FacebookSectionFragment();
		// Bundle args = new Bundle();
		// args.putInt(DummySectionFragment.ARG_SECTION_NUMBER,
		// tab.getPosition() + 1);
		// fragment.setArguments(args);
		getActivity().getSupportFragmentManager().beginTransaction()
				.replace(R.id.fragmentContainer, fragment).commit();
		// }

	}

	@Override
	public void onTabUnselected(Tab tab, android.app.FragmentTransaction ft) {
		// TODO Auto-generated method stub

	}

	// @Override
	// public void onTabReselected(Tab tab, FragmentTransaction ft) {
	// // if (tab.getPosition() == 0) {
	// Fragment fragment = new FacebookSectionFragment();
	// // Bundle args = new Bundle();
	// // args.putInt(DummySectionFragment.ARG_SECTION_NUMBER,
	// // tab.getPosition() + 1);
	// // fragment.setArguments(args);
	// getActivity().getSupportFragmentManager().beginTransaction()
	// .replace(R.id.fragmentContainer, fragment).commit();
	// // }
	//
	// }
	//
	// @Override
	// public void onTabSelected(Tab tab, FragmentTransaction ft) {
	//
	// }
	//
	// @Override
	// public void onTabUnselected(Tab tab, FragmentTransaction ft) {
	//
	// }

}
