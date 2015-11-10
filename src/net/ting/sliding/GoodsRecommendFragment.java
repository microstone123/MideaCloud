package net.ting.sliding;

import java.util.List;

import net.ting.sliding.CommonData.XmlFile;
import xutil.library.view.annotation.ViewInject;
import xutil.library.view.annotation.event.OnClick;
import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class GoodsRecommendFragment extends BaseFragment implements BaseSwipeRefreshLayout.OnRefreshListener,
		BaseSwipeRefreshLayout.OnLoadListener {
	@ViewInject(R.id.title_tv)
	protected TextView title_tv;
	private AnimetPopuWin popuWin;

	@ViewInject(R.id.bar_image)
	protected ImageView bar_image;

	@ViewInject(R.id.swipe_container)
	private BaseSwipeRefreshLayout swipeLayout;

	@ViewInject(R.id.listview)
	private ListView listview;

	private List<GoodsInfo> list;
	private static final int SLEEP_TIME = 3 * 1000;

	private GoodsRecommendAdapter adapter;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		layoutResourceId = R.layout.goods_recommend;
		list = CommonData.getGoodsInfo(mActivity, XmlFile.INCIDENT_GOODS_INFO);
		adapter = new GoodsRecommendAdapter(mActivity, list);
		popuWin = new AnimetPopuWin(mActivity);

	}

	@Override
	protected void getData() {
		title_tv.setText(titleName);
		listview.setAdapter(adapter);

	}

	@OnClick(R.id.popop_image)
	public void onPopopImage(View v) {
		popuWin.showAsDropDown(mHoseView.findViewById(R.id.v_image));
	}

	@OnClick(R.id.bar_image)
	public void onBackMenu(View v) {
		((MainActivity) getActivity()).showMenu();
	}

	@Override
	protected void initView() {
		swipeLayout.setOnRefreshListener(this);
		swipeLayout.setOnLoadListener(this);
		initBaseSwipeRefreshLayout(swipeLayout);
	}

	@Override
	public void onLoad() {
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				swipeLayout.setRefreshing(false);
				swipeLayout.setLoading(false);
			}
		}, SLEEP_TIME);
	}

	@Override
	public void onRefresh() {
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				swipeLayout.setRefreshing(false);
				swipeLayout.setLoading(false);
			}
		}, 1000);
	}

}
