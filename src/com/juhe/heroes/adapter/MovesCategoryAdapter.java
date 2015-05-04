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
import com.juhe.heroes.activity.ImageListActivity;
import com.juhe.heroes.entity.CardEntity;
import com.juhe.heroes.utils.Config.FileType;

/***
 * 招式
 * 
 * @author daiye
 * 
 */
public class MovesCategoryAdapter extends BaseAdapter {
	List<CardEntity> list;
	int version;
	private Context mContext;

	public MovesCategoryAdapter(Context context) {
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
				Intent intent = new Intent(mContext, ImageListActivity.class);
				if (1 == entity.getId()) {
					// 力属性
					intent.putExtra(ImageListActivity.EXTRA_TITLE, "力属性");
					if (1 == version) {
						// 基础版
						intent.putExtra(ImageListActivity.EXTRA_TYPE, FileType.MOVES_LI_S);
					}
					if (2 == version) {
						// 标准版
						intent.putExtra(ImageListActivity.EXTRA_TYPE, FileType.MOVES_LI);
					}
				}
				if (2 == entity.getId()) {
					// 技属性
					intent.putExtra(ImageListActivity.EXTRA_TITLE, "技属性");
					if (1 == version) {
						// 基础版
						intent.putExtra(ImageListActivity.EXTRA_TYPE, FileType.MOVES_JI_S);
					}
					if (2 == version) {
						// 标准版
						intent.putExtra(ImageListActivity.EXTRA_TYPE, FileType.MOVES_JI);
					}
				}
				if (3 == entity.getId()) {
					// 气属性
					intent.putExtra(ImageListActivity.EXTRA_TITLE, "气属性");
					if (1 == version) {
						// 基础版
						intent.putExtra(ImageListActivity.EXTRA_TYPE, FileType.MOVES_QI_S);
					}
					if (2 == version) {
						// 标准版
						intent.putExtra(ImageListActivity.EXTRA_TYPE, FileType.MOVES_QI);
					}
				}
				if (4 == entity.getId()) {
					// 速属性
					intent.putExtra(ImageListActivity.EXTRA_TITLE, "速属性");
					if (1 == version) {
						// 基础版
						intent.putExtra(ImageListActivity.EXTRA_TYPE, FileType.MOVES_SU_S);
					}
					if (2 == version) {
						// 标准版
						intent.putExtra(ImageListActivity.EXTRA_TYPE, FileType.MOVES_SU);
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
