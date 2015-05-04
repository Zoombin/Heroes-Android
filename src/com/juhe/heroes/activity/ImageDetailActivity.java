package com.juhe.heroes.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.juhe.heroes.R;
import com.juhe.heroes.utils.Config;
import com.nostra13.universalimageloader.core.ImageLoader;

/***
 * 图片详情
 * 
 * @author lsd
 *
 */
public class ImageDetailActivity extends Activity {

	private ImageView iv_image;
	public static final String EXTRA_IMAGE = "EXTRA_IMAGE";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_imagedetail);

		String imagename = getIntent().getStringExtra(EXTRA_IMAGE);
		iv_image = (ImageView) findViewById(R.id.iv_image);
		ImageLoader.getInstance().displayImage(Config.IMG_PATH + imagename, iv_image);
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		ImageLoader.getInstance().clearDiscCache();
		ImageLoader.getInstance().clearMemoryCache();
		super.onDestroy();
	}
}
