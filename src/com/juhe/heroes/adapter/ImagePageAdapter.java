package com.juhe.heroes.adapter;

import java.util.List;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.juhe.heroes.entity.ImageEntity;
import com.juhe.heroes.utils.Config;
import com.nostra13.universalimageloader.core.ImageLoader;

public class ImagePageAdapter extends PagerAdapter {

	private Context context;
	List<ImageEntity> infos;

	public ImagePageAdapter(Context context, List<ImageEntity> infos) {
		this.context = context;
		this.infos = infos;
	}

	@Override
	public final Object instantiateItem(ViewGroup container, int position) {
		View view = null;
		view = getView(position, view, container);
		container.addView(view);
		return view;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return infos.size();
	}

	@Override
	public final void destroyItem(ViewGroup container, int position, Object object) {
		View view = (View) object;
		container.removeView(view);
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
		// TODO Auto-generated method stub
		return view == object;
	}

	public View getView(int position, View view, ViewGroup container) {
		final ImageEntity entity = infos.get(position);

		ViewHolder holder;
		if (view == null) {
			holder = new ViewHolder();
			view = holder.imageView = new ImageView(context);
			holder.imageView.setScaleType(ImageView.ScaleType.FIT_XY);
			view.setTag(holder);
		} else {
			holder = (ViewHolder) view.getTag();
		}

		ImageLoader.getInstance().displayImage(Config.IMG_PATH + entity.getImagepath(), holder.imageView);
		return view;
	}

	private static class ViewHolder {
		ImageView imageView;
	}
}
