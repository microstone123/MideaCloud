package net.ting.sliding;

import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

public class GoodsRecommendAdapter extends BaseAdapter {

	private List<GoodsInfo> list;
	protected LayoutInflater inflater;
	protected ImageLoader imageLoader = ImageLoader.getInstance();
	protected DisplayImageOptions options;
	private Context mContext;

	public GoodsRecommendAdapter(Context mContext, List<GoodsInfo> list) {
		inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.list = list;
		this.mContext = mContext;
		imageLoader.init(ImageLoaderConfiguration.createDefault(mContext));
		options = getOptions(0);
	}

	@SuppressWarnings("deprecation")
	protected DisplayImageOptions getOptions(int cornerRadiusPixels) {
		return new DisplayImageOptions.Builder().showImageOnLoading(R.drawable.defaut_img)
				.showImageForEmptyUri(R.drawable.defaut_img).showImageOnFail(R.drawable.defaut_img).cacheInMemory(true)
				.cacheOnDisc(true).considerExifParams(true).displayer(new RoundedBitmapDisplayer(cornerRadiusPixels))
				.build();
	}

	@Override
	public int getCount() {
		return list.size();
	}

	public void addList(List<GoodsInfo> infoList) {
		list.addAll(infoList);
		notifyDataSetChanged();
	}

	public void addGoodsInfo(GoodsInfo GoodsInfoModel) {
		this.list.add(GoodsInfoModel);
		notifyDataSetChanged();
	}

	public void setData(List<GoodsInfo> list) {
		this.list = list;
		notifyDataSetChanged();
	}

	@Override
	public Object getItem(int position) {
		return list.get(position);
	}

	public GoodsInfo getData(int position) {
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	public List<GoodsInfo> getList() {
		return list;
	}

	@SuppressLint("InflateParams")
	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.goods_recommend_item, null);
			holder.goods_img = (ImageView) convertView.findViewById(R.id.goods_img);
			holder.goods_name = (TextView) convertView.findViewById(R.id.goods_name);
			holder.goods_price = (TextView) convertView.findViewById(R.id.goods_price);
			holder.goods_area = (TextView) convertView.findViewById(R.id.goods_area);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		GoodsInfo info = list.get(position);
		Integer str = null;
		// Log.e("str", str);
		switch (position) {
		case 0:
			str = R.drawable.d;
			break;
		case 1:
			str = R.drawable.i;
			break;
		case 2:
			str = R.drawable.a;
			break;
		case 3:
			str = R.drawable.b;
			break;
		case 4:
			str = R.drawable.c;
			break;

		default:
			break;
		}
		imageLoader.displayImage("drawable://" + str, holder.goods_img, options);
		// imageLoader.displayImage(info.getImgUrl(), holder.goods_img,
		// options);
		holder.goods_name.setText(info.getName());
		holder.goods_price.setText("￥" + info.getPrice());
		holder.goods_area.setText(info.getPlaceArea());
		return convertView;
	}

	protected class ViewHolder {
		public ImageView goods_img;
		public TextView goods_name, goods_price, goods_area;
	}
}