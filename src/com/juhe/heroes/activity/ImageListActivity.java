package com.juhe.heroes.activity;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint.Style;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
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
public class ImageListActivity extends Activity {
	public static final String EXTRA_TITLE = "EXTRA_TITLE";
	public static final String EXTRA_TYPE = "EXTRA_TYPE";
	private TextView tv_title;
	private ListView lv_image;
	private ImageListAdapter adatper;

	String title;
	String extra_type;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_imagelist);

		initView();
		initData();
	}

	void initView() {
		tv_title = (TextView) findViewById(R.id.tv_title);
		title = getIntent().getStringExtra(EXTRA_TITLE);
		tv_title.setText(title);

		lv_image = (ListView) findViewById(R.id.lv_image);
		lv_image.setAdapter(adatper = new ImageListAdapter(this));
		lv_image.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(ImageListActivity.this, ImageViewPageActivity.class);
				intent.putExtra(ImageViewPageActivity.EXTRA_TITLE, title);
				intent.putExtra(ImageViewPageActivity.EXTRA_TYPE, extra_type);
				intent.putExtra(ImageViewPageActivity.EXTRA_OFFSET, position);
				startActivity(intent);
			}
		});
	}

	void initData() {
		extra_type = getIntent().getStringExtra(EXTRA_TYPE);
		String imgs = ReadAssets.readAssetsData(ImageListActivity.this, extra_type + ".txt");
		Type type = new TypeToken<ArrayList<ImageEntity>>() {
		}.getType();
		List<ImageEntity> list = new Gson().fromJson(imgs, type);

		adatper.setData(list);
	}

}
