package com.juhe.heroes.activity;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.juhe.heroes.R;
import com.juhe.heroes.utils.Config;
import com.juhe.heroes.utils.ReadAssets;
import com.nostra13.universalimageloader.core.ImageLoader;

/***
 * 游戏规则
 * 
 * @author lsd
 *
 */
public class GameRuleActivity extends Activity {

	private TextView tv_rule;
	private ImageView iv_rule;
	private WebView webview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gamerule);

		//tv_rule = (TextView) findViewById(R.id.tv_rule);
		//tv_rule.setText(R.string.rule);
		
		webview = (WebView) findViewById(R.id.webview);
		WebSettings settings = webview.getSettings();
		 //webView自适应大小
		//settings.setUseWideViewPort(true);
		//settings.setLoadWithOverviewMode(true);

		// 设置可以支持缩放 
		settings.setSupportZoom(true);
		settings.setBuiltInZoomControls(true);
		webview.loadUrl("file:///android_asset/data/rule.htm");
		
		
	}
}
