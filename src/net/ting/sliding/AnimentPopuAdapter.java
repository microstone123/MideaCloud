package net.ting.sliding;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class AnimentPopuAdapter extends BaseAdapter {

	private String[] list;
	protected LayoutInflater inflater;

	public AnimentPopuAdapter(Context mContext) {
		inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.list = mContext.getResources().getStringArray(R.array.animet_list);
	}

	@Override
	public int getCount() {
		return list.length;
	}

	@Override
	public Object getItem(int position) {
		return list[position];
	}

	public String getItemMode(int position) {
		return list[position];
	}

	public String getData(int position) {
		return list[position];
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@SuppressLint("InflateParams")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.animet_popu_item, null);
			holder.animet_mode = (TextView) convertView.findViewById(R.id.animet_mode);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.animet_mode.setText(list[position]);
		return convertView;
	}

	protected class ViewHolder {
		public TextView animet_mode;
	}
}
