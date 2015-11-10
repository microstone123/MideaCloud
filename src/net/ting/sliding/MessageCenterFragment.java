package net.ting.sliding;

import xutil.library.view.annotation.ViewInject;
import xutil.library.view.annotation.event.OnClick;
import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MessageCenterFragment extends BaseFragment {

	@ViewInject(R.id.title_tv)
	protected TextView title_tv;

	@ViewInject(R.id.img1)
	protected ImageView img;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		layoutResourceId = R.layout.message_center;
	}

	@Override
	protected void getData() {
		title_tv.setText(titleName);
		imageLoader.displayImage("drawable://" + R.drawable.pleasewait, img, options);
	}

	@OnClick(R.id.bar_image)
	public void onBackMenu(View v) {
		((MainActivity) getActivity()).showMenu();
	}

	@Override
	protected void initView() {
		// TODO Auto-generated method stub

	}

}
