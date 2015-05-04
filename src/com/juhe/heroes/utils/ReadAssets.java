package com.juhe.heroes.utils;

import java.io.IOException;
import java.io.InputStream;

import android.content.Context;

public class ReadAssets {
	public static String readAssetsData(Context c, String s) {
		StringBuffer sb = null;
		InputStream is = null;
		try {
			is = c.getAssets().open("file/" + s);
			byte[] buff = new byte[1024];
			sb = new StringBuffer();
			int len = 0;
			while ((len = is.read(buff)) != -1) {
				sb.append(new String(buff, 0, len, "utf-8"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			is = null;
		}
		return sb.toString();
	}
}
