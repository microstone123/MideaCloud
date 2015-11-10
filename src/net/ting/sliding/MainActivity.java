package net.ting.sliding;

import slidingmenu.lib.SlidingMenu;
import slidingmenu.lib.app.SlidingFragmentActivity;
import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

public class MainActivity extends SlidingFragmentActivity implements OnConnectChangeListenting {

	private Fragment mContent;
	public SlidingMenu slidingMenu;
	protected FrameLayout framelayout;

	@SuppressLint("NewApi")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		/**
		 * 设置为横屏
		 */
		if (getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
			setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		}
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		initSlidingMenu(savedInstanceState);
		ReplaceFragmentMethod(R.id.framelayout_err_connet, new ErrorConnetFragment());
		ConnectionChangeReceiver.setOnConnectChangeListenting(this);

	}

	/**
	 * 加载初始进入Fragment的方法
	 */
	protected void ReplaceFragmentMethod(int viewId, Fragment fragment) {
		FragmentTransaction tration = getSupportFragmentManager().beginTransaction();
		tration.replace(viewId, fragment);
		tration.commitAllowingStateLoss();
	}

	@Override
	public void onResume() {
		super.onResume();
		if (!NetworkUtil.isNetworkAvailable(this)) {
			OnConnectChange(false);
		} else {
			OnConnectChange(true);
		}
	}

	/**
	 * 初始化滑动菜单
	 */
	private void initSlidingMenu(Bundle savedInstanceState) {
		// 如果保存的状态不为空则得到ColorFragment，否则实例化ColorFragment
		if (savedInstanceState != null)
			mContent = getSupportFragmentManager().getFragment(savedInstanceState, "mContent");
		if (mContent == null)
			mContent = new IceControlFragment();

		// 设置主视图界面
		setContentView(R.layout.content_frame);
		framelayout = (FrameLayout) findViewById(R.id.framelayout_err_connet);
		getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, mContent).commit();

		// 设置滑动菜单视图界面
		setBehindContentView(R.layout.menu_frame);
		getSupportFragmentManager().beginTransaction().replace(R.id.menu_frame, new SlideMenu()).commit();

		// 设置滑动菜单的属性值
		slidingMenu = getSlidingMenu();
		slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		slidingMenu.setShadowWidthRes(R.dimen.shadow_width);
		slidingMenu.setShadowDrawable(R.drawable.shadow);
		slidingMenu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		slidingMenu.setFadeDegree(0.35f);
		slidingMenu.setBehindWidth(getResources().getInteger(R.integer.behind_width));
		slidingMenu.showMenu();

	}

	/**
	 * 切换Fragment，也是切换视图的内容
	 */
	public void switchContent(Fragment fragment) {
		mContent = fragment;
		getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, fragment).commit();
		slidingMenu.showContent();
	}

	/**
	 * 保存Fragment的状态
	 */
	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		getSupportFragmentManager().putFragment(outState, "mContent", mContent);
	}

	@Override
	public void OnConnectChange(boolean isConnect) {
		if (!isConnect) {
			framelayout.setVisibility(View.VISIBLE);
		} else {
			framelayout.setVisibility(View.GONE);
		}
	}
}