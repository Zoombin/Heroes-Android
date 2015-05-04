package com.juhe.heroes.activity;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.juhe.heroes.R;
import com.juhe.heroes.adapter.ImageCategoryAdapter;
import com.juhe.heroes.adapter.MagicCategoryAdapter;
import com.juhe.heroes.adapter.MovesCategoryAdapter;
import com.juhe.heroes.entity.CardEntity;
import com.juhe.heroes.utils.Config.FileType;
import com.juhe.heroes.utils.ReadAssets;

/***
 * 功法牌类型 ：
 * 
 * 内功，轻功，心法
 * 
 * 根据不同的版本
 * 
 * @author lsd
 * 
 */
public class MagicCategoryActivity extends Activity {

	public static final String EXTRA_TITLE = "EXTRA_TITLE";
	public static final String EXTRA_VERSION = "EXTRA_VERSION";
	private RelativeLayout rl_top;
	private TextView tv_title;
	private ImageView iv_pic;
	private ListView lv_image;
	private MagicCategoryAdapter adatper;

	int version;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cardlist);

		initView();
		initData();
	}

	void initView() {
		tv_title = (TextView) findViewById(R.id.tv_title);

		rl_top = (RelativeLayout) findViewById(R.id.rl_top);
		DisplayMetrics displayMetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		int width = displayMetrics.widthPixels;
		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(width, (int) (((float) width / 4) * 3));
		rl_top.setLayoutParams(layoutParams);

		iv_pic = (ImageView) findViewById(R.id.iv_pic);

		lv_image = (ListView) findViewById(R.id.lv_image);
		lv_image.setAdapter(adatper = new MagicCategoryAdapter(this));
	}

	void initData() {
		version = getIntent().getIntExtra(EXTRA_VERSION, 1);

		String title = getIntent().getStringExtra(EXTRA_TITLE);
		tv_title.setText(title);

		String imgs = ReadAssets.readAssetsData(MagicCategoryActivity.this, FileType.MAGIC_cate + ".txt");
		Type type = new TypeToken<ArrayList<CardEntity>>() {
		}.getType();
		List<CardEntity> list = new Gson().fromJson(imgs, type);

		adatper.setData(list);
		adatper.setVersion(version);
	}

}
