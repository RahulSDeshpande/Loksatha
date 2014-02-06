package com.eminosoft.loksatha.adapters;

import java.util.ArrayList;
import java.util.List;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.eminosoft.loksatha.BO.FacebookPostBo;
import com.eminosoft.loksatha.activity.R;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class FacebooksPostsListAdapter extends BaseAdapter {
	private Context context;
	private int layoutResourceId;
	private List<FacebookPostBo> data = new ArrayList<FacebookPostBo>();
	private ImageLoader mLoader;

	public FacebooksPostsListAdapter(Context context, int layoutResourceId,
			List<FacebookPostBo> newsArryList, ImageLoader loader) {
		this.layoutResourceId = layoutResourceId;
		this.context = context;
		this.data = newsArryList;
		this.mLoader = loader;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View row = convertView;
		ViewHolder holder = null;

		if (row == null) {
			LayoutInflater inflater = ((Activity) context).getLayoutInflater();
			row = inflater.inflate(layoutResourceId, parent, false);
			holder = new ViewHolder();
			holder.image = (NetworkImageView) row
					.findViewById(R.id.imageThumbNail);
			holder.tvTitle = (TextView) row.findViewById(R.id.textPostTitle);

			row.setTag(holder);
		} else {
			holder = (ViewHolder) row.getTag();
		}

		holder.image.setImageUrl(data.get(position).getPicture(), mLoader);
		holder.tvTitle.setText(data.get(position).getMessage());

		return row;
	}

	static class ViewHolder {
		NetworkImageView image;
		TextView tvTitle;
	}

	@Override
	public int getCount() {
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		return position;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}
}