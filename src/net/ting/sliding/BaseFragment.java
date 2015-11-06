package net.ting.sliding;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment extends Fragment {
	protected Activity mActivity;
	protected Object tag;
	protected View mHoseView;
	protected int layoutResourceId;
	
	protected abstract void getData();

	protected abstract void initView();

	protected void ReplaceFragmentMethod(int viewId, Fragment fragment) {
		FragmentTransaction tration = getChildFragmentManager().beginTransaction();
		tration.replace(viewId, fragment);
		tration.commitAllowingStateLoss();
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		if (mHoseView == null) {
			mHoseView = inflater.inflate(layoutResourceId, null);
			initView();
			getData();
		}
		// 缓存的mHoseView需要判断是否已经被加过parent，
		// 如果有parent需要从parent删除，要不然会发生这个mHoseView已经有parent的错误。
		ViewGroup parent = (ViewGroup) mHoseView.getParent();
		if (parent != null) {
			parent.removeView(mHoseView);
		}
		return mHoseView;
	}

	public static class SimpleBaseFragment extends BaseFragment {

		@Override
		protected void initView() {
		}

		@Override
		protected void getData() {
			// TODO Auto-generated method stub
			
		}

	}

}
