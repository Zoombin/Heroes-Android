package com.juhe.heroes.utils;

import android.content.SharedPreferences;

import com.juhe.heroes.HeroesApplication;

/**
 * SharedPreferences配置信息
 * @author daiye
 *
 */
public class Config {

	public static final String IMG_PATH = "assets://";
	
	// 用户信息
	private static String USER_INFO = "USER_INFO";
	
	// 第一次启动
	private static String FIRST_START = "FIRST_START";
	
	// 教程查看 
	private static String TUTORIAL_START = "TUTORIAL_START";
	
	public static SharedPreferences UserInfoPreferences = HeroesApplication.getInstance()
			.getSharedPreferences(USER_INFO, 0);

	public static boolean isFirst() {
		return UserInfoPreferences.getBoolean(FIRST_START, true);
	}

	public static void setFirst(boolean isFirst) {
		UserInfoPreferences.edit().putBoolean(FIRST_START, isFirst).commit();
	}
	
	/**
	 * 清空数据
	 */
	public static void cleanData() {
		UserInfoPreferences.edit().clear();
	}
}
