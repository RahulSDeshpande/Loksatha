package com.eminosoft.loksatha.callback;

import java.util.ArrayList;

import com.eminosoft.loksatha.BO.FacebookPostBo;

public interface FBPostsLoadCompleteCallBack {

	public void onFbPostsLoadComplete(ArrayList<FacebookPostBo> fbPostsList);

}
