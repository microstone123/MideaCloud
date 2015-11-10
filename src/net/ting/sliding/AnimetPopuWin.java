package net.ting.sliding;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.PopupWindow;

public class AnimetPopuWin extends PopupWindow {
	private View mMenuView;
	private AnimentPopuAdapter adapter;
	private ListView animet_list;
	private final static int POPU_ITEM_WIDTH = 200;
	private Context mContext;

	@SuppressWarnings("deprecation")
	@SuppressLint({ "InflateParams", "NewApi" })
	public AnimetPopuWin(Context context) {
		super(context);
		this.mContext = context;
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mMenuView = inflater.inflate(R.layout.animet_popu, null);
		animet_list = (ListView) mMenuView.findViewById(R.id.animet_list);
		this.setBackgroundDrawable(new BitmapDrawable());
		this.setOutsideTouchable(true);
		setAnimationStyle(R.style.AnimetPopuWinStyle);
		adapter = new AnimentPopuAdapter(context);
		animet_list.setAdapter(adapter);
		this.setContentView(mMenuView);
		this.setWidth(POPU_ITEM_WIDTH);
		this.setHeight(LayoutParams.WRAP_CONTENT);
		this.setFocusable(true);
		
		animet_list.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> adapterview, View view, int i, long l) {
				dismiss();
			}
		});
	}
}
