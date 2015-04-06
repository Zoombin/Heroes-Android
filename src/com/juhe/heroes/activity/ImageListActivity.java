package com.juhe.heroes.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.juhe.heroes.R;
import com.juhe.heroes.adapter.ImageAdapter;
import com.juhe.heroes.entity.ImageEntity;

public class ImageListActivity extends Activity {

	public static final String EXTRA_TITLE = "EXTRA_TITLE";
	public static final String EXTRA_TYPE = "EXTRA_TYPE";
	private TextView tv_title;
	private ListView lv_image;
	private ImageAdapter adatper;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_imagelist);
		
		String title = getIntent().getStringExtra(EXTRA_TITLE);
		int id = getIntent().getIntExtra(EXTRA_TYPE, 0);
		tv_title = (TextView) findViewById(R.id.tv_title);
		tv_title.setText(title);
		
		lv_image = (ListView) findViewById(R.id.lv_image);
		adatper = new ImageAdapter(this);
		lv_image.setAdapter(adatper);
		
		List<ImageEntity> list = new ArrayList<ImageEntity>();
		ImageEntity entity1;
		ImageEntity entity2;
		ImageEntity entity3;
		ImageEntity entity4;
		ImageEntity entity5;
		ImageEntity entity6;
		ImageEntity entity7;
		ImageEntity entity8;
		ImageEntity entity9;
		ImageEntity entity10;
		ImageEntity entity11;
		ImageEntity entity12;
		ImageEntity entity13;
		switch (id) {
		case 0:
			entity1 = new ImageEntity();
			entity1.setName("鳌拜");
			entity1.setImagepath("hero_aobai.jpg");
			list.add(entity1);
			
			entity2 = new ImageEntity();
			entity2.setName("成昆");
			entity2.setImagepath("hero_chengkun.jpg");
			list.add(entity2);
			
			entity3 = new ImageEntity();
			entity3.setName("陈近南");
			entity3.setImagepath("hero_chenjinnan.jpg");
			list.add(entity3);
			
			adatper.setData(list);
			break;
		case 1:
			entity1 = new ImageEntity();
			entity1.setName("丁春秋");
			entity1.setImagepath("hero_dingchunqiu.jpg");
			list.add(entity1);
			
			entity2 = new ImageEntity();
			entity2.setName("东方不败");
			entity2.setImagepath("hero_dongfangbubai.jpg");
			list.add(entity2);
			                                                                                  
			entity3 = new ImageEntity();
			entity3.setName("段誉");
			entity3.setImagepath("hero_duanyu.jpg");
			list.add(entity3);
			
			adatper.setData(list);
			break;
		case 2:
			entity1 = new ImageEntity();
			entity1.setName("方证大师");
			entity1.setImagepath("hero_fangzhengdashi.jpg");
			list.add(entity1);
			
			entity2 = new ImageEntity();
			entity2.setName("冯锡范");
			entity2.setImagepath("hero_fengxifan.jpg");
			list.add(entity2);
			
			entity3 = new ImageEntity();
			entity3.setName("郭靖");
			entity3.setImagepath("hero_guojing.jpg");
			list.add(entity3);
			
			adatper.setData(list);
			break;
//		case R.id.btn_jian:
//			entity1 = new ImageEntity();
//			entity1.setName("屠龙刀");
//			entity1.setImagepath("sword_tulong.jpg");
//			list.add(entity1);
//			
//			entity2 = new ImageEntity();
//			entity2.setName("倚天剑");
//			entity2.setImagepath("sword_yitian.jpg");
//			list.add(entity2);
//			
//			entity3 = new ImageEntity();
//			entity3.setName("玄铁剑");
//			entity3.setImagepath("sword_xuantie.jpg");
//			list.add(entity3);
//			
//			adatper.setData(list);
//			break;
//		case R.id.btn_shenfen:
//
//			break;
//		case R.id.btn_yao:
//
//			break;
//		case R.id.btn_zhiji:
//
//			break;
//
//		case R.id.btn_gongfa:
//
//			break;
//		case R.id.btn_luozhandaxia:
//
//			break;
//		case R.id.btn_zhaoshi:
//
//			break;
		default:
			break;
		}
	}
}
