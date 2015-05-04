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

		tv_rule = (TextView) findViewById(R.id.tv_rule);
		//String gamerule = ReadAssets.readAssetsData(GameRuleActivity.this, "rule.txt");
		tv_rule.setText(R.string.rule);
		
		//iv_rule = (ImageView) findViewById(R.id.iv_rule);
		//ImageLoader.getInstance().displayImage(Config.IMG_PATH + "rule_cut.png", iv_rule);
		
		//webview = (WebView) findViewById(R.id.webview);
		//WebSettings settings = webview.getSettings();
		// webView自适应大小
		//settings.setUseWideViewPort(true);
		///settings.setLoadWithOverviewMode(true);
		//settings.setLayoutAlgorithm(LayoutAlgorithm.SINGLE_COLUMN);
		
		// 设置可以支持缩放 
		///settings.setSupportZoom(true); 
		//settings.setBuiltInZoomControls(true);
		
		
		//final String mimeType = "text/html";
		//final String encoding = "utf-8";
		//final String data =  ReadAssets.readAssetsData(GameRuleActivity.this, "rule.html");
		//final String html = "<p><img src=\"file:///android_asset/rule_cut.png\"/></p>";
		//webview.loadDataWithBaseURL("fake://not/needed", html,mimeType, encoding, "");
		//webview.loadData(data, mimeType, encoding);
	}
}
