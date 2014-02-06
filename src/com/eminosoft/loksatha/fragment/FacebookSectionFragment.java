package com.eminosoft.loksatha.fragment;

import java.util.ArrayList;

import org.json.JSONObject;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.eminosoft.loksatha.BO.FacebookPostBo;
import com.eminosoft.loksatha.activity.R;
import com.eminosoft.loksatha.adapters.FacebooksPostsListAdapter;
import com.eminosoft.loksatha.asynctask.FacebookPostsAsync;
import com.eminosoft.loksatha.callback.FBPostsLoadCompleteCallBack;
import com.eminosoft.loksatha.util.Constants;
import com.eminosoft.loksatha.util.DebugModeConfig;
import com.eminosoft.loksatha.util.VolleySingleTon;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class FacebookSectionFragment extends Fragment implements
		FBPostsLoadCompleteCallBack {

	private RequestQueue mRequestQuee;
	private ImageLoader mimageLoader;
	private String TAG = getClass().getSimpleName();
	private ListView mlistView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		mRequestQuee = VolleySingleTon.getInstance(getActivity())
				.getRequestQueue();
		mimageLoader = VolleySingleTon.getInstance(getActivity())
				.getImageLoader();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment_facebook, container,
				false);
		mlistView = (ListView) view.findViewById(R.id.fb_posts_list);
		setHasOptionsMenu(true);
		getFacebookAccessToken();
		return view;
	}

	public void getFacebookAccessToken() {

		StringRequest accessTokenRequest = new StringRequest(
				Request.Method.GET, Constants.S_URL_FACEBOOK_ACCESS_TOKEN,
				new Response.Listener<String>() {

					@Override
					public void onResponse(String response) {

						DebugModeConfig.loksattaDebug(TAG, response);

						String accestoken[] = response.split("=");

						DebugModeConfig.loksattaDebug(TAG + " Access token",
								response);

						loadFaceBookPagePosts(accestoken[1]);

					}
				}, new Response.ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError error) {

					}
				});

		mRequestQuee.add(accessTokenRequest);

	}

	protected void loadFaceBookPagePosts(String accestoke) {

		String url = Constants.S_URL_FACEBOOK_POSTS + accestoke
				+ Constants.append_Facebook_posts;
		JsonObjectRequest fPostsRequest = new JsonObjectRequest(
				Request.Method.GET, url, null,
				new Response.Listener<JSONObject>() {

					@Override
					public void onResponse(JSONObject response) {
						DebugModeConfig.loksattaDebug(TAG + " Facebook posts",
								response.toString());

						FacebookPostsAsync async = new FacebookPostsAsync(
								getActivity(), FacebookSectionFragment.this,
								response);
						async.execute();

					}
				}, new Response.ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError error) {

					}
				});

		mRequestQuee.add(fPostsRequest);

	}

	@Override
	public void onFbPostsLoadComplete(ArrayList<FacebookPostBo> fbPostsList) {
		FacebooksPostsListAdapter adapter = new FacebooksPostsListAdapter(
				getActivity(), R.layout.item_facebook_post, fbPostsList,
				mimageLoader);
		mlistView.setAdapter(adapter);

	}
}
