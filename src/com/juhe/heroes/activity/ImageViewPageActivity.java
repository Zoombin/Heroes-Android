package com.juhe.heroes.activity;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.graphics.Paint.Style;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.juhe.heroes.R;
import com.juhe.heroes.adapter.ImageListAdapter;
import com.juhe.heroes.adapter.ImagePageAdapter;
import com.juhe.heroes.entity.ImageEntity;
import com.juhe.heroes.utils.ReadAssets;
import com.juhe.heroes.widget.viewpage.CirclePageIndicator;

/***
 * 图片列表
 * 
 * @author lsd
 * 
 */
public class ImageViewPageActivity extends Activity {
	public static final String EXTRA_TITLE = "EXTRA_TITLE";
	public static final String EXTRA_TYPE = "EXTRA_TYPE";
	public static final String EXTRA_OFFSET = "EXTRA_OFFSET";
	private TextView tv_title;

	private ViewPager imgs_viewpager;
	private CirclePageIndicator imgs_page_indicator;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image_viewpage);

		initView();
		initData();
	}

	void initView() {
		tv_title = (TextView) findViewById(R.id.tv_title);
		String title = getIntent().getStringExtra(EXTRA_TITLE);
		tv_title.setText(title);

		imgs_viewpager = (ViewPager) findViewById(R.id.imgs_viewpager);
		imgs_page_indicator = (CirclePageIndicator) findViewById(R.id.imgs_page_indicator);
		imgs_page_indicator.setFillColor(Style.FILL, getResources().getColor(R.color.default_circle_indicator_fill_color));
		imgs_page_indicator.setStrokeColor(Style.FILL, getResources().getColor(R.color.default_circle_indicator_stroke_color));
	}

	void initData() {
		String extra_type = getIntent().getStringExtra(EXTRA_TYPE);
		String imgs = ReadAssets.readAssetsData(ImageViewPageActivity.this, extra_type + ".txt");
		Type type = new TypeToken<ArrayList<ImageEntity>>() {
		}.getType();
		List<ImageEntity> list = new Gson().fromJson(imgs, type);

		imgs_viewpager.setAdapter(new ImagePageAdapter(this, list));
		imgs_page_indicator.setViewPager(imgs_viewpager, 0);
		
		int offset = getIntent().getIntExtra(EXTRA_OFFSET, 0);
		imgs_viewpager.setCurrentItem(offset);
	}

}
