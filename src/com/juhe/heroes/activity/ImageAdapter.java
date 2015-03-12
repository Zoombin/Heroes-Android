package com.juhe.heroes.activity;

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


/***
 * 
 * @author daiye
 * 
 */
public class ImageAdapter extends BaseAdapter {
	List<ImageEntity> list;

	private Context mContext;

	public ImageAdapter(Context context) {
		this.mContext = context;
	}

	public void setData(List<ImageEntity> list) {
		this.list = list;
		this.notifyDataSetChanged();
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
		final ImageEntity entity = list.get(position);
		
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
				Intent intent = new Intent(mContext, ImageDetailActivity.class);
				intent.putExtra(ImageDetailActivity.EXTRA_IMAGE, entity.getImagepath());
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
