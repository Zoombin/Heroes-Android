package com.juhe.heroes.adapter;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.juhe.heroes.activity.ImageListActivity;
import com.juhe.heroes.entity.HeroEntity;
import com.juhe.heroes.widget.autoscrollviewpager.RecyclingPagerAdapter;
import com.juhe.heroes.widget.viewpage.CirclePageIndicator;
import com.nostra13.universalimageloader.core.ImageLoader;

public class HeroAdapter extends RecyclingPagerAdapter {

	private Context context;
	List<HeroEntity> infos;
	private int size;
	private boolean isInfiniteLoop;

	public HeroAdapter(Context context, List<HeroEntity> infos) {
		this.context = context;
		this.infos = infos;
		this.size = getSize(infos);
		isInfiniteLoop = true;
	}

	@Override
	public int getCount() {
		// Infinite loop
		return isInfiniteLoop ? getSize(infos) * CirclePageIndicator.fornum
				: getSize(infos);
	}

	public <V> int getSize(List<V> sourceList) {
		return sourceList == null ? 0 : sourceList.size();
	}

	/**
	 * get really position
	 * 
	 * @param position
	 * @return
	 */
	private int getPosition(int position) {
		return isInfiniteLoop ? position % size : position;
	}

	@Override
	public View getView(int position, View view, ViewGroup container) {
		final HeroEntity entity = infos.get(getPosition(position));

		ViewHolder holder;
		if (view == null) {
			holder = new ViewHolder();
			view = holder.imageView = new ImageView(context);
			holder.imageView.setScaleType(ImageView.ScaleType.FIT_XY);
			view.setTag(holder);
		} else {
			holder = (ViewHolder) view.getTag();
		}

		ImageLoader.getInstance().displayImage(entity.getImagepath(),
				holder.imageView);
		holder.imageView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(context, ImageListActivity.class);
				intent.putExtra(ImageListActivity.EXTRA_TITLE, "英雄列表");
				intent.putExtra(ImageListActivity.EXTRA_TYPE, entity.getId());
				context.startActivity(intent);
			}
		});

		return view;
	}

	private static class ViewHolder {
		ImageView imageView;
	}
}
