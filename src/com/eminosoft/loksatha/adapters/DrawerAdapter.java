package com.eminosoft.loksatha.adapters;

import com.eminosoft.loksatha.activity.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DrawerAdapter extends BaseAdapter {

	Context mContext;
	String drawerItems[];
	int mSelectedPosition;

	public DrawerAdapter(Context context) {
		mContext = context;
		drawerItems = mContext.getResources().getStringArray(
				R.array.draweritems);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return drawerItems.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater drawerInflater = (LayoutInflater) mContext
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View itemView = drawerInflater.inflate(R.layout.item_drawar_list, null);
		TextView tv = (TextView) itemView.findViewById(R.id.itemTextView);
		LinearLayout leftIndicator = (LinearLayout) itemView
				.findViewById(R.id.leftIndicator);
		LinearLayout rightIndicator = (LinearLayout) itemView
				.findViewById(R.id.bottomIndicator);
		tv.setText(drawerItems[position]);
		if (position == mSelectedPosition) {
			tv.setTextColor(mContext.getResources().getColor(
					R.color.lokstaha_blue));
			leftIndicator.setVisibility(View.VISIBLE);
			rightIndicator.setVisibility(View.VISIBLE);
		} else {
			leftIndicator.setVisibility(View.INVISIBLE);
			rightIndicator.setVisibility(View.INVISIBLE);
		}

		return itemView;
	}

	public void setSelectedPosition(int position) {

		mSelectedPosition = position;

	}

}
