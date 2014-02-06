package com.eminosoft.loksatha.util;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import com.eminosoft.loksatha.BO.FacebookPostBo;

public class FacebookJObjParser {
	public static ArrayList<FacebookPostBo> getFacebookPostsList(JSONObject json) {

		ArrayList<FacebookPostBo> facebookPostsList = new ArrayList<FacebookPostBo>();
		try {
			JSONArray jObj = (JSONArray) json.getJSONArray("data");

			for (int i = 0; i < jObj.length(); i++) {

				JSONObject artical = jObj.getJSONObject(i);
				FacebookPostBo facebookpost = new FacebookPostBo();

				// check book is exist or not
				if (artical.has("message")) {
					String message = artical.getString("message");
					facebookpost.setMessage(message);
				}

				if (artical.has("picture")) {

					String picture = artical.getString("picture");

					facebookpost.setPicture(picture);
				} else {
					facebookpost
							.setPicture("http://www.loksatta.org/cms/images/logo.jpg");
				}

				// facebookpost.setMessage(message);

				facebookPostsList.add(facebookpost);

			}

		} catch (JSONException e) {
			Log.e("log_tag", "Error parsing data " + e.toString());
		}
		return facebookPostsList;

	}

}
