package net.ting.sliding;

import xutil.library.view.annotation.ViewInject;
import xutil.library.view.annotation.event.OnClick;
import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class SettingFragment extends BaseFragment {

	@ViewInject(R.id.title_tv)
	protected TextView title_tv;
	
	@ViewInject(R.id.setting_bottom_list)
	private ListView bottomList;
	
	@ViewInject(R.id.bar_image)
	protected ImageView bar_image;
	private SettingBottomAdaper settingBottomAdaper;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		layoutResourceId = R.layout.setting;
	}

	@Override
	protected void getData() {
		title_tv.setText(titleName);
		settingBottomAdaper = new SettingBottomAdaper(mActivity);
		bottomList.setAdapter(settingBottomAdaper);
	}

	@OnClick(R.id.bar_image)
	public void onBackMenu(View v) {
		((MainActivity) getActivity()).showMenu();
	}

	@Override
	protected void initView() {

	}

}
