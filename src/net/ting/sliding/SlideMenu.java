package net.ting.sliding;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ScrollView;

public class SlideMenu extends BaseFragment {

	private SlideMenuAdaper adaper;
	protected BaseListView setting_bottom_list;
	protected ScrollView slide_scroll;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		layoutResourceId = R.layout.slidemenu;
	}

	@Override
	protected void getData() {
		slide_scroll.smoothScrollTo(0, 0);
		setting_bottom_list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				switch (arg2) {
				case 0:
					switchFragment(new IceControlFragment());
					break;
				case 1:
					switchFragment(new GoodsRecommendFragment());
					break;
				case 2:
					switchFragment(new FeedBackAreaFragment());
					break;
				case 3:
					switchFragment(new MessageCenterFragment());
					break;

				default:
					break;
				}
			}
		});
	}

	@Override
	protected void initView() {
		setting_bottom_list = (BaseListView) mHoseView.findViewById(R.id.setting_bottom_list);
		slide_scroll = (ScrollView) mHoseView.findViewById(R.id.slide_scroll);
		adaper = new SlideMenuAdaper(getActivity());
		setting_bottom_list.setAdapter(adaper);
	}

	private void switchFragment(Fragment fragment) {
		if (getActivity() == null)
			return;
		if (getActivity() instanceof MainActivity) {
			MainActivity fca = (MainActivity) getActivity();
			fca.switchContent(fragment);
		}
	}

}
