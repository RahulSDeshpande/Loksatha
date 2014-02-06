package com.eminosoft.loksatha.asynctask;

import java.util.ArrayList;

import org.json.JSONObject;

import com.android.volley.toolbox.JsonObjectRequest;
import com.eminosoft.loksatha.BO.FacebookPostBo;
import com.eminosoft.loksatha.callback.FBPostsLoadCompleteCallBack;
import com.eminosoft.loksatha.util.FacebookJObjParser;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;

public class FacebookPostsAsync extends
		AsyncTask<String, String, ArrayList<FacebookPostBo>> {

	private Context mContext;
	private Fragment mFragment;
	private JSONObject mjObject;

	public FacebookPostsAsync(Context mContext, Fragment fragment,
			JSONObject jObject) {
		this.mContext = mContext;
		this.mFragment = fragment;
		this.mjObject = jObject;

	}

	@Override
	protected void onPreExecute() {
		super.onPreExecute();
	}

	@Override
	protected ArrayList<FacebookPostBo> doInBackground(String... params) {

		ArrayList<FacebookPostBo> faceBookPostsLists = FacebookJObjParser
				.getFacebookPostsList(mjObject);
		return faceBookPostsLists;
	}

	@Override
	protected void onPostExecute(ArrayList<FacebookPostBo> result) {
		super.onPostExecute(result);
		try {
			FBPostsLoadCompleteCallBack callback = (FBPostsLoadCompleteCallBack) mFragment;
			callback.onFbPostsLoadComplete(result);
		} catch (ClassCastException exca) {
			exca.printStackTrace();

		}

	}

}
