package com.eminosoft.loksatha.util;

import android.util.Log;

public class DebugModeConfig {

	public static final boolean isInDebugMode = true;

	public static void loksattaDebug(String tag, String message) {
		if (isInDebugMode) {
			Log.v(tag, message);
		}
	}

}
