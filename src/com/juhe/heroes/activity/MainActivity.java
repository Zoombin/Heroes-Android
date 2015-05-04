package com.juhe.heroes.activity;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint.Style;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.juhe.heroes.R;
import com.juhe.heroes.adapter.HeroAdapter;
import com.juhe.heroes.entity.HeroEntity;
import com.juhe.heroes.service.BgMusicService;
import com.juhe.heroes.utils.Config.FileType;
import com.juhe.heroes.utils.ReadAssets;
import com.juhe.heroes.widget.viewpage.CirclePageIndicator;

public class MainActivity extends Activity implements OnClickListener {

	private ViewPager viewpager_hero;
	private CirclePageIndicator mIndicator;
	private Button btn_card;
	private Button btn_rule;
	private Button btn_weapon;
	private Button btn_expand;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initView();
		initData();
		startService();
	}

	void initView() {
		btn_card = (Button) findViewById(R.id.btn_card);
		btn_card.setOnClickListener(this);
		btn_rule = (Button) findViewById(R.id.btn_rule);
		btn_rule.setOnClickListener(this);
		btn_weapon = (Button) findViewById(R.id.btn_weapon);
		btn_weapon.setOnClickListener(this);
		btn_expand = (Button) findViewById(R.id.btn_expand);
		btn_expand.setOnClickListener(this);

		viewpager_hero = (ViewPager) findViewById(R.id.viewpager_hero);
		mIndicator = (CirclePageIndicator) findViewById(R.id.home_page_indicator);
		mIndicator.setFillColor(Style.FILL, getResources().getColor(R.color.default_circle_indicator_fill_color));
		mIndicator.setStrokeColor(Style.FILL, getResources().getColor(R.color.default_circle_indicator_stroke_color));

		DisplayMetrics displayMetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		int width = displayMetrics.widthPixels;
		RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(width, (int) (((float) width / 4) * 3));
		viewpager_hero.setLayoutParams(layoutParams);
	}

	void initData() {
		String heroType = ReadAssets.readAssetsData(MainActivity.this, FileType.HERO_cate + ".txt");
		Type type = new TypeToken<ArrayList<HeroEntity>>() {
		}.getType();
		List<HeroEntity> heroTypes = new Gson().fromJson(heroType, type);

		viewpager_hero.setAdapter(new HeroAdapter(this, heroTypes));
		mIndicator.setViewPager(viewpager_hero, heroTypes.size() * CirclePageIndicator.fornum / 2);
	}

	void startService() {
		Intent intent = new Intent();
		intent.setClass(this, BgMusicService.class);
		startService(intent);
	}

	void stopService() {
		Intent intent = new Intent();
		intent.setClass(this, BgMusicService.class);
		stopService(intent);
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		stopService();
		super.onDestroy();
	}

	@Override
	public void onClick(View v) {
		Intent intent = new Intent();
		switch (v.getId()) {
		case R.id.btn_card:
			intent.setClass(MainActivity.this, GameVersionActivity.class);
			startActivity(intent);
			break;
		case R.id.btn_rule:
			intent.setClass(MainActivity.this, GameRuleActivity.class);
			startActivity(intent);
			break;
		case R.id.btn_weapon:
			intent.setClass(MainActivity.this, ImageListActivity.class);
			intent.putExtra(ImageListActivity.EXTRA_TITLE, "武器列表");
			intent.putExtra(ImageListActivity.EXTRA_TYPE, FileType.WEAPON);
			startActivity(intent);
			break;
		case R.id.btn_expand:
			intent.setClass(MainActivity.this, ImageListActivity.class);
			intent.putExtra(ImageListActivity.EXTRA_TITLE, "扩展包");
			intent.putExtra(ImageListActivity.EXTRA_TYPE, FileType.SHERO);
			startActivity(intent);
			break;
		default:
			break;
		}
	}

}
