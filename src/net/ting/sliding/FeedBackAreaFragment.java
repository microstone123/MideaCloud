package net.ting.sliding;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class FeedBackAreaFragment extends BaseFragment {

	protected TextView title_tv;

	protected ImageView img;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		layoutResourceId = R.layout.feedback_area;
	}

	@Override
	protected void getData() {
		title_tv.setText(BaseFragment.titleName);
		imageLoader.displayImage("drawable://" + R.drawable.pleasewait, img, options);
	}

	public void onBackMenu(View v) {
		((MainActivity) getActivity()).showMenu();
	}

	@Override
	protected void initView() {
		title_tv = (TextView)mHoseView.findViewById(R.id.title_tv);
	}

}
