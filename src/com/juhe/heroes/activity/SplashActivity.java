package com.juhe.heroes.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import com.juhe.heroes.R;
import com.juhe.heroes.utils.Config;

/**
 * 欢迎页面
 * 
 * @author daiye
 * 
 */
public class SplashActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		createShortcut();

		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				if (SplashActivity.this.isFinishing()) {
					return;
				}

				startActivity(new Intent(getApplication(), MainActivity.class));
				createShortcut();
				finish();
			}
		}, 2000);// 2秒后跳转到首页
	}

	/**
	 * 创建桌面快捷方式
	 */
	private void createShortcut() {
		if (Config.isFirst()) {
			Intent shortcut = new Intent(
					"com.android.launcher.action.INSTALL_SHORTCUT");
			// 快捷方式的名称
			shortcut.putExtra(Intent.EXTRA_SHORTCUT_NAME,
					getString(R.string.app_name));
			// 不允许重复创建
			shortcut.putExtra("duplicate", false);
			// 指定快捷方式的启动对象
			Intent shortcutIntent = new Intent(Intent.ACTION_MAIN);
			shortcutIntent.setClassName(this.getPackageName(), this.getClass()
					.getName());
			shortcutIntent.addCategory(Intent.CATEGORY_LAUNCHER);
			shortcut.putExtra(Intent.EXTRA_SHORTCUT_INTENT, shortcutIntent);
			// 快捷方式的图标
			ShortcutIconResource iconRes = Intent.ShortcutIconResource.fromContext(
					this, R.drawable.app_icon);
			shortcut.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, iconRes);
			// 发出广播
			sendBroadcast(shortcut);
			// 将第一次启动的标识设置为false
			Config.setFirst(false);
		}
	}
}
