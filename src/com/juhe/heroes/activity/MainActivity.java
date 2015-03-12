package com.juhe.heroes.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.juhe.heroes.R;

public class MainActivity extends Activity implements OnClickListener {

	private Button btn_jian;
	private Button btn_shenfen;
	private Button btn_yao;
	private Button btn_zhiji;
	private Button btn_daxia;
	private Button btn_gongfa;
	private Button btn_luozhandaxia;
	private Button btn_zhaoshi;
	private Button btn_wanfa;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btn_jian = (Button) findViewById(R.id.btn_jian);
		btn_jian.setOnClickListener(this);
		btn_shenfen = (Button) findViewById(R.id.btn_shenfen);
		btn_shenfen.setOnClickListener(this);
		btn_yao = (Button) findViewById(R.id.btn_yao);
		btn_yao.setOnClickListener(this);
		btn_zhiji = (Button) findViewById(R.id.btn_zhiji);
		btn_zhiji.setOnClickListener(this);
		btn_daxia = (Button) findViewById(R.id.btn_daxia);
		btn_daxia.setOnClickListener(this);
		btn_gongfa = (Button) findViewById(R.id.btn_gongfa);
		btn_gongfa.setOnClickListener(this);
		btn_luozhandaxia = (Button) findViewById(R.id.btn_luozhandaxia);
		btn_luozhandaxia.setOnClickListener(this);
		btn_zhaoshi = (Button) findViewById(R.id.btn_zhaoshi);
		btn_zhaoshi.setOnClickListener(this);
		btn_wanfa = (Button) findViewById(R.id.btn_wanfa);
		btn_wanfa.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Button b = (Button) v;
		Intent intent = new Intent(MainActivity.this, ImageListActivity.class);
		intent.putExtra(ImageListActivity.EXTRA_TITLE, b.getText().toString());
		switch (v.getId()) {
		case R.id.btn_jian:
		case R.id.btn_shenfen:
		case R.id.btn_yao:
		case R.id.btn_zhiji:
		case R.id.btn_daxia:
		case R.id.btn_gongfa:
		case R.id.btn_luozhandaxia:
		case R.id.btn_zhaoshi:
			intent.putExtra(ImageListActivity.EXTRA_TYPE, v.getId());
			break;
		case R.id.btn_wanfa:
			
			return;
		default:
			break;
		}
		startActivity(intent);
	}
}
