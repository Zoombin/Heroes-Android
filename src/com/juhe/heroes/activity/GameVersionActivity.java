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
import com.juhe.heroes.adapter.GameVersionAdapter;
import com.juhe.heroes.entity.VersionEntity;
import com.juhe.heroes.utils.Config.FileType;
import com.juhe.heroes.utils.ReadAssets;

/***
 * 游戏卡牌版本
 * 
 * @author lsd
 * 
 */
public class GameVersionActivity extends Activity {

	private RelativeLayout rl_top;
	private TextView tv_title;
	private ImageView iv_pic;
	private ListView lv_image;
	private GameVersionAdapter adatper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cardversion);

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
		lv_image.setAdapter(adatper = new GameVersionAdapter(this));
	}

	void initData() {
		tv_title.setText("游戏卡牌");

		String imgs = ReadAssets.readAssetsData(GameVersionActivity.this, FileType.VERSION + ".txt");
		Type type = new TypeToken<ArrayList<VersionEntity>>() {
		}.getType();
		List<VersionEntity> list = new Gson().fromJson(imgs, type);

		adatper.setData(list);
	}

}
