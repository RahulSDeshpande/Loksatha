package com.eminosoft.loksath;

import com.eminosoft.loksatha.activity.R;
import com.eminosoft.loksatha.adapters.DrawerAdapter;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

public class BaseActionBarDrawer extends FragmentActivity {

	public ActionBarDrawerToggle drawerToggle;
	public DrawerLayout drawerLayout;
	public ListView drawerList;
	public int mSelectedPage = 0;
	public String pageTitles[];

	public interface DrawerItemSelectListener {
		/**
		 * 
		 * @param view
		 *            selected view
		 * @param position
		 *            position of the view in the list
		 */
		void onDrawerItemSelected(View view, int position);

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);
		pageTitles = getResources().getStringArray(R.array.draweritems);
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		setDrawer();
	}

	private void setDrawer() {
		drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		drawerLayout.setDrawerShadow(R.drawable.drawer_shadow,
				GravityCompat.START);

		drawerList = (ListView) findViewById(R.id.left_drawer);
		drawerList.setAdapter(new DrawerAdapter(this));

		drawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
				R.drawable.ic_drawer, R.string.drawer_open,
				R.string.drawer_close) {
			public void onDrawerClosed(View view) {
				getActionBar().setTitle(pageTitles[mSelectedPage]);
				getActionBar().setSubtitle(
						getResources().getString(R.string.app_name));
			}

			public void onDrawerOpened(View drawerView) {
				getActionBar().setTitle(
						getResources().getString(R.string.app_name));
			}
		};
		drawerLayout.setDrawerListener(drawerToggle);
		// drawerList.setOnItemClickListener(this);
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		drawerToggle.syncState();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (drawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * Set focus to selected drawer item.
	 * 
	 * @param position
	 *            selected drawer item position
	 */
	public void setFocusToSelectedDrawerItem(int position) {
		mSelectedPage = position;
		DrawerAdapter drawerAdapter = (DrawerAdapter) drawerList.getAdapter();
		if (drawerAdapter != null) {
			drawerAdapter.setSelectedPosition(position);
			drawerAdapter.notifyDataSetChanged();
		}
	}

}
