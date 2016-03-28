package com.juhe.heroes.adapter;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.juhe.heroes.R;
import com.juhe.heroes.activity.ImageCategoryActivity;
import com.juhe.heroes.activity.ImageListActivity;
import com.juhe.heroes.activity.MagicCategoryActivity;
import com.juhe.heroes.activity.MovesCategoryActivity;
import com.juhe.heroes.entity.CardEntity;
import com.juhe.heroes.utils.Config.FileType;

/***
 * 
 * @author daiye
 * 
 */
public class ImageCategoryAdapter extends BaseAdapter {
	List<CardEntity> list;
	int version;
	private Context mContext;

	public ImageCategoryAdapter(Context context) {
		this.mContext = context;
	}

	public void setData(List<CardEntity> list) {
		this.list = list;
		this.notifyDataSetChanged();
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public int getCount() {
		return list == null ? 0 : list.size();
	}

	@Override
	public Object getItem(int position) {
		return list == null ? null : list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return list == null ? 0 : position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		final CardEntity entity = list.get(position);

		final Tag tag;
		if (convertView == null) {
			tag = new Tag();
			convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_image_list_item, null);
			tag.layout_item = (LinearLayout) convertView.findViewById(R.id.layout_item);
			tag.text_name = (TextView) convertView.findViewById(R.id.text_name);

			convertView.setTag(tag);
		} else {
			tag = (Tag) convertView.getTag();
		}

		tag.text_name.setText(entity.getName());
		tag.layout_item.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				if (1 == entity.getId()) {
					intent.setClass(mContext, ImageListActivity.class);
					// 身份牌
					intent.putExtra(ImageListActivity.EXTRA_TITLE, "身份牌");
					if (1 == version) {
						// 基础版
						intent.putExtra(ImageListActivity.EXTRA_TYPE, FileType.IDENTITY_S);
					}
					if (2 == version) {
						// 标准版
						intent.putExtra(ImageListActivity.EXTRA_TYPE, FileType.IDENTITY);
					}
				}
				if (2 == entity.getId()) {
					// 招式牌(下面还要区分 什么技能)
					intent.setClass(mContext, MovesCategoryActivity.class);
					intent.putExtra(MovesCategoryActivity.EXTRA_TITLE, "招式牌");
					intent.putExtra(MovesCategoryActivity.EXTRA_VERSION, version);
				}
				if (3 == entity.getId()) {
					intent.setClass(mContext, MagicCategoryActivity.class);
					// 功法牌(下面还要区分 什么功法)
					intent.putExtra(MovesCategoryActivity.EXTRA_TITLE, "功法牌");
					intent.putExtra(MovesCategoryActivity.EXTRA_VERSION, version);
				}
				if (4 == entity.getId()) {
					intent.setClass(mContext, ImageListActivity.class);
					// 智计牌
					intent.putExtra(ImageListActivity.EXTRA_TITLE, "智计牌");
					if (1 == version) {
						// 基础版
						intent.putExtra(ImageListActivity.EXTRA_TYPE, FileType.CLEVER_S);
					}
					if (2 == version) {
						// 标准版
						intent.putExtra(ImageListActivity.EXTRA_TYPE, FileType.CLEVER);
					}
				}
				if (5 == entity.getId()) {
					intent.setClass(mContext, ImageListActivity.class);
					// 药牌
					intent.putExtra(ImageListActivity.EXTRA_TITLE, "药牌");
					if (1 == version) {
						// 基础版
						intent.putExtra(ImageListActivity.EXTRA_TYPE, FileType.DRUG_S);
					}
					if (2 == version) {
						// 标准版
						intent.putExtra(ImageListActivity.EXTRA_TYPE, FileType.DRUG);
					}
				}
				mContext.startActivity(intent);
			}
		});
		return convertView;
	}

	class Tag {
		LinearLayout layout_item;
		TextView text_name;
	}

}
