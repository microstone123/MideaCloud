package net.ting.sliding;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ScrollView;

import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

public class SlideMenu extends BaseFragment {

	private SlideMenuAdaper adaper;

	@ViewInject(R.id.setting_bottom_list)
	protected BaseListView setting_bottom_list;

	@ViewInject(R.id.slide_scroll)
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
				BaseFragment.titleName = adaper.getItem(arg2);
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

	protected void initView() {
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

	@OnClick(R.id.user_img)
	public void onUserImg(View v) {
		BaseFragment.titleName = getActivity().getResources().getString(R.string.usercentor_str);
		switchFragment(new UserDetailFragment());
	}

	@OnClick(R.id.login_out)
	public void onLoginOut(View v) {
//		BaseFragment.titleName = "设置";
//		switchFragment(new SettingFragment());
	}

	@OnClick(R.id.login_setting)
	public void onLoginSetting(View v) {
		BaseFragment.titleName = getActivity().getResources().getString(R.string.seting_str);
		switchFragment(new SettingFragment());
	}
}
