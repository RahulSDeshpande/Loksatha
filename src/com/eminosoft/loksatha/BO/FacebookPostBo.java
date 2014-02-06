package com.eminosoft.loksatha.BO;

import android.os.Parcel;
import android.os.Parcelable;

public class FacebookPostBo implements Parcelable {

	private String message;
	private String picture;

	public FacebookPostBo(Parcel in) {
		message = in.readString();
		picture = in.readString();
	}

	public FacebookPostBo() {
		// TODO Auto-generated constructor stub
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int flags) {
		parcel.writeString(message);
		parcel.writeString(picture);

	}

	public static final Parcelable.Creator<FacebookPostBo> CREATOR = new Parcelable.Creator<FacebookPostBo>() {

		public FacebookPostBo createFromParcel(Parcel in) {
			return new FacebookPostBo(in);
		}

		public FacebookPostBo[] newArray(int size) {
			return new FacebookPostBo[size];
		}
	};

}
