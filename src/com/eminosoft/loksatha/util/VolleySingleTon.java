package com.eminosoft.loksatha.util;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

public class VolleySingleTon {

	private static VolleySingleTon mInstance = null;
	private RequestQueue mRequestQueue;
	private ImageLoader mImageLoader;

	private VolleySingleTon(Context context) {

		mRequestQueue = Volley.newRequestQueue(context);
		mImageLoader = new ImageLoader(mRequestQueue, new BitmapLruCache(
				BitmapLruCache.getDefaultLruCacheSize()));

	}

	public static VolleySingleTon getInstance(Context context) {
		if (mInstance == null) {
			mInstance = new VolleySingleTon(context);
		}
		return mInstance;
	}

	public RequestQueue getRequestQueue() {
		return this.mRequestQueue;
	}

	public ImageLoader getImageLoader() {
		return this.mImageLoader;
	}
}
