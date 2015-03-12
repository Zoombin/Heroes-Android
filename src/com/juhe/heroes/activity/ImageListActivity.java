package com.juhe.heroes.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.juhe.heroes.R;

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
		switch (id) {
		case R.id.btn_jian:
			ImageEntity entity1 = new ImageEntity();
			entity1.setName("屠龙刀");
			entity1.setImagepath("tulongdao.jpg");
			list.add(entity1);
			
			ImageEntity entity2 = new ImageEntity();
			entity2.setName("倚天剑");
			entity2.setImagepath("yitianjian.jpg");
			list.add(entity2);
			
			ImageEntity entity3 = new ImageEntity();
			entity3.setName("玄铁剑");
			entity3.setImagepath("xuantiejian.jpg");
			list.add(entity3);
			
			adatper.setData(list);
			break;
		case R.id.btn_shenfen:

			break;
		case R.id.btn_yao:

			break;
		case R.id.btn_zhiji:

			break;
		case R.id.btn_daxia:

			break;
		case R.id.btn_gongfa:

			break;
		case R.id.btn_luozhandaxia:

			break;
		case R.id.btn_zhaoshi:

			break;
		default:
			break;
		}
	}
}
