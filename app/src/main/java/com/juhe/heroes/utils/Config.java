package com.juhe.heroes.utils;

import android.content.SharedPreferences;

import com.juhe.heroes.HeroesApplication;

/**
 * SharedPreferences配置信息
 * 
 * @author daiye
 * 
 */
public class Config {
	public static class FileType {
		public static final String HERO_cate = "hero_cate";
		public static final String HERO_liliang = "hero_liliang";
		public static final String HERO_jiqiao = "hero_jiqiao";
		public static final String HERO_zhenqi = "hero_zhenqi";
		public static final String HERO_sudu = "hero_sudu";
		public static final String VERSION = "version";
		public static final String WEAPON = "weapon";
		public static final String SHERO = "shero";
		public static final String IMAGE_cate = "image_cate";
		public static final String IDENTITY_S = "identity_s";
		public static final String IDENTITY = "identity";
		public static final String MOVES_S = "moves_s";
		public static final String MOVES = "moves";
		public static final String MAGIC_S = "magic_s";
		public static final String MAGIC = "magic";
		public static final String CLEVER_S = "clever_s";
		public static final String CLEVER = "clever";
		public static final String DRUG_S = "drug_s";
		public static final String DRUG = "drug";
		public static final String MOVES_cate = "moves_cate";
		public static final String MOVES_LI_S = "moves_li_s";
		public static final String MOVES_LI = "moves_li";
		public static final String MOVES_JI_S = "moves_ji_s";
		public static final String MOVES_JI = "moves_ji";
		public static final String MOVES_QI_S = "moves_qi_s";
		public static final String MOVES_QI = "moves_qi";
		public static final String MOVES_SU_S = "moves_su_s";
		public static final String MOVES_SU = "moves_su";
		public static final String MAGIC_cate = "magic_cate";
		public static final String MAGIC_NEIGONG_S = "magic_neigong_s";
		public static final String MAGIC_NEIGONG = "magic_neigong";
		public static final String MAGIC_QINGGONG_S = "magic_qinggong_s";
		public static final String MAGIC_QINGGONG = "magic_qinggong";
		public static final String MAGIC_XINFA_S = "magic_xinfa_s";
		public static final String MAGIC_XINFA = "magic_xinfa";
	}

	public static final String IMG_PATH = "assets://";

	// 用户信息
	private static String USER_INFO = "USER_INFO";

	// 第一次启动
	private static String FIRST_START = "FIRST_START";

	// 教程查看
	private static String TUTORIAL_START = "TUTORIAL_START";

	public static SharedPreferences UserInfoPreferences = HeroesApplication.getInstance().getSharedPreferences(USER_INFO, 0);

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
