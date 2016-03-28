package com.juhe.heroes;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;

/**
 * 应用入口
 * 
 * @author daiye
 * 
 */
public class HeroesApplication extends Application {

	private static Context context;
	public static HeroesApplication self;
	
	public static HeroesApplication getInstance() {
		return self;
	}
	
	public static Context getContext() {
		return context;
	}

	private void initImageLoader() {
		DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
				.cacheInMemory(true).bitmapConfig(Bitmap.Config.RGB_565)
				// 图片压缩质量
				.cacheOnDisc(true)
				.imageScaleType(ImageScaleType.EXACTLY_STRETCHED).build();

		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
				getApplicationContext())
				.defaultDisplayImageOptions(defaultOptions)
				.discCacheFileCount(10000).threadPoolSize(5).build();

		ImageLoader.getInstance().init(config);
	}

	@Override
	public void onCreate() {
		super.onCreate();
		context = getApplicationContext();
		self = this;

		initImageLoader();
	}
}

