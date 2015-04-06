package com.juhe.heroes.activity;

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
import android.widget.TextView;

import com.juhe.heroes.R;
import com.juhe.heroes.adapter.HeroAdapter;
import com.juhe.heroes.entity.HeroEntity;
import com.juhe.heroes.utils.Config;
import com.juhe.heroes.widget.viewpage.CirclePageIndicator;

public class MainActivity extends Activity implements OnClickListener {

	private ViewPager viewpager_hero;
	private CirclePageIndicator mIndicator;
	private Button btn_jian;
	private Button btn_shenfen;
	private Button btn_yao;
	private Button btn_zhiji;
	private Button btn_gongfa;
	private Button btn_luozhandaxia;
	private Button btn_zhaoshi;
	private Button btn_wanfa;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		viewpager_hero = (ViewPager) findViewById(R.id.viewpager_hero);
		mIndicator = (CirclePageIndicator) findViewById(R.id.home_page_indicator);
		mIndicator.setFillColor(
				Style.FILL,
				getResources().getColor(
						R.color.default_circle_indicator_fill_color));
		mIndicator.setStrokeColor(
				Style.FILL,
				getResources().getColor(
						R.color.default_circle_indicator_stroke_color));

		List<HeroEntity> herolist = new ArrayList<HeroEntity>();
		HeroEntity entity1 = new HeroEntity();
		entity1.setId(0);
		entity1.setName("力量英雄");
		entity1.setImagepath(Config.IMG_PATH + "hero_power.jpg");
		herolist.add(entity1);

		HeroEntity entity2 = new HeroEntity();
		entity2.setId(1);
		entity2.setName("敏捷英雄");
		entity2.setImagepath(Config.IMG_PATH + "hero_minjie.jpg");
		herolist.add(entity2);

		HeroEntity entity3 = new HeroEntity();
		entity3.setId(1);
		entity3.setName("智力英雄");
		entity3.setImagepath(Config.IMG_PATH + "hero_zhihui.jpg");
		herolist.add(entity3);

		DisplayMetrics displayMetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		int width = displayMetrics.widthPixels;

		RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
				width, (int) (((float) width / 720) * 1088));
		viewpager_hero.setLayoutParams(layoutParams);

		viewpager_hero.setAdapter(new HeroAdapter(this, herolist));
		mIndicator.setViewPager(viewpager_hero, herolist.size()
				* CirclePageIndicator.fornum / 2);

//		btn_jian = (Button) findViewById(R.id.btn_jian);
//		btn_jian.setOnClickListener(this);
//		btn_shenfen = (Button) findViewById(R.id.btn_shenfen);
//		btn_shenfen.setOnClickListener(this);
//		btn_yao = (Button) findViewById(R.id.btn_yao);
//		btn_yao.setOnClickListener(this);
//		btn_zhiji = (Button) findViewById(R.id.btn_zhiji);
//		btn_zhiji.setOnClickListener(this);
//		btn_gongfa = (Button) findViewById(R.id.btn_gongfa);
//		btn_gongfa.setOnClickListener(this);
//		btn_luozhandaxia = (Button) findViewById(R.id.btn_luozhandaxia);
//		btn_luozhandaxia.setOnClickListener(this);
//		btn_zhaoshi = (Button) findViewById(R.id.btn_zhaoshi);
//		btn_zhaoshi.setOnClickListener(this);
//		btn_wanfa = (Button) findViewById(R.id.btn_wanfa);
//		btn_wanfa.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Button b = (Button) v;
		Intent intent = new Intent(MainActivity.this, ImageListActivity.class);
		intent.putExtra(ImageListActivity.EXTRA_TITLE, b.getText().toString());
		switch (v.getId()) {
//		case R.id.btn_jian:
//		case R.id.btn_shenfen:
//		case R.id.btn_yao:
//		case R.id.btn_zhiji:
//		case R.id.btn_gongfa:
//		case R.id.btn_luozhandaxia:
//		case R.id.btn_zhaoshi:
//			intent.putExtra(ImageListActivity.EXTRA_TYPE, v.getId());
//			break;
//		case R.id.btn_wanfa:
//
//			return;
		default:
			break;
		}
		startActivity(intent);
	}
}
