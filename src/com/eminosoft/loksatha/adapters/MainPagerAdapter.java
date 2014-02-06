package com.eminosoft.loksatha.adapters;

import com.eminosoft.loksatha.fragment.AboutFragment;
import com.eminosoft.loksatha.fragment.DonateFragment;
import com.eminosoft.loksatha.fragment.FacebookSectionFragment;
import com.eminosoft.loksatha.fragment.GalleryFragment;
import com.eminosoft.loksatha.fragment.LeadersFragment;
import com.eminosoft.loksatha.fragment.NewsHomeTabsFragment;
import com.eminosoft.loksatha.fragment.VolunteerFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MainPagerAdapter extends FragmentPagerAdapter {

	public MainPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int arg0) {
		switch (arg0) {
		case 0:

			return new FacebookSectionFragment();

		case 1:

			return new LeadersFragment();

		case 2:

			return new DonateFragment();

		case 3:

			return new VolunteerFragment();
		case 4:

			return new AboutFragment();
		case 5:

			return new GalleryFragment();

		default:
			break;
		}

		return null;
	}

	@Override
	public int getCount() {
		return 6;
	}

}
