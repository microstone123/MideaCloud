package net.ting.sliding;

import android.app.Activity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

public class IceControlFragment extends BaseFragment {

	@ViewInject(R.id.title_tv)
	protected TextView title_tv;

	@ViewInject(R.id.bar_image)
	protected ImageView bar_image;

	@ViewInject(R.id.fruandvegetable_image)
	protected CheckBox fruandvegetable_image;

	@ViewInject(R.id.heterotherm_image)
	protected CheckBox heterotherm_image;

	@ViewInject(R.id.icebig_image)
	protected CheckBox icebig_image;

	@ViewInject(R.id.freshness_image)
	protected CheckBox freshness_image;

	@ViewInject(R.id.softfrozen_image)
	protected CheckBox softfrozen_image;

	@ViewInject(R.id.cold_cb)
	protected CheckBox cold_cb;

	@ViewInject(R.id.quick_cb)
	protected CheckBox quick_cb;

	@ViewInject(R.id.capacity_cb)
	protected CheckBox capacity_cb;

	@ViewInject(R.id.holiday_cb)
	protected CheckBox holiday_cb;

	@ViewInject(R.id.fruandvegetable_tv)
	protected TextView fruandvegetable_tv;

	@ViewInject(R.id.heterotherm_tv)
	protected TextView heterotherm_tv;

	@ViewInject(R.id.icebig_tv)
	protected TextView icebig_tv;

	@ViewInject(R.id.freshness_tv)
	protected TextView freshness_tv;

	@ViewInject(R.id.softfrozen_tv)
	protected TextView softfrozen_tv;

	@ViewInject(R.id.cold_cb_name)
	protected TextView cold_cb_name;

	@ViewInject(R.id.quick_cb_name)
	protected TextView quick_cb_name;

	@ViewInject(R.id.capacity_cb_name)
	protected TextView capacity_cb_name;

	@ViewInject(R.id.holiday_cb_name)
	protected TextView holiday_cb_name;

	@ViewInject(R.id.cold_cb_open)
	protected TextView cold_cb_open;

	@ViewInject(R.id.quick_cb_open)
	protected TextView quick_cb_open;

	@ViewInject(R.id.capacity_cb_open)
	protected TextView capacity_cb_open;

	@ViewInject(R.id.holiday_cb_open)
	protected TextView holiday_cb_open;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		layoutResourceId = R.layout.ice_control;
	}

	@Override
	protected void getData() {
		title_tv.setText(titleName);
	}

	@OnClick(R.id.bar_image)
	public void onBackMenu(View v) {
		((MainActivity) getActivity()).showMenu();
	}

	@OnClick(R.id.fruandvegetable_layout)
	public void onFruandvegetable(View v) {
		if (fruandvegetable_image.isChecked()) {
			fruandvegetable_image.setChecked(false);
			fruandvegetable_tv.setSelected(false);
		} else {
			fruandvegetable_image.setChecked(true);
			fruandvegetable_tv.setSelected(true);
		}
	}

	@OnClick(R.id.heterotherm_layout)
	public void onHeterotherm(View v) {
		if (heterotherm_image.isChecked()) {
			heterotherm_image.setChecked(false);
			heterotherm_tv.setSelected(false);
		} else {
			heterotherm_image.setChecked(true);
			heterotherm_tv.setSelected(true);
		}
	}

	@OnClick(R.id.icebig_layout)
	public void onIcebig(View v) {
		if (icebig_image.isChecked()) {
			icebig_image.setChecked(false);
			icebig_tv.setSelected(false);
		} else {
			icebig_image.setChecked(true);
			icebig_tv.setSelected(true);
		}
	}

	@OnClick(R.id.freshness_layout)
	public void onFreshness(View v) {
		if (freshness_image.isChecked()) {
			freshness_image.setChecked(false);
			freshness_tv.setSelected(false);
		} else {
			freshness_image.setChecked(true);
			freshness_tv.setSelected(true);
		}
	}

	@OnClick(R.id.capacity_layout)
	public void onCapacityLayout(View v) {
		if (capacity_cb.isChecked()) {
			capacity_cb.setChecked(false);
			capacity_cb_name.setSelected(false);
			capacity_cb_open.setSelected(false);
		} else {
			capacity_cb.setChecked(true);
			capacity_cb_name.setSelected(true);
			capacity_cb_open.setSelected(true);
		}
	}
	
	@OnClick(R.id.quick_layout)
	public void onQuickLayout(View v) {
		if (quick_cb.isChecked()) {
			quick_cb.setChecked(false);
			quick_cb_name.setSelected(false);
			quick_cb_open.setSelected(false);
		} else {
			quick_cb.setChecked(true);
			quick_cb_name.setSelected(true);
			quick_cb_open.setSelected(true);
		}
	}
	
	@OnClick(R.id.capacity_layout)
	public void oncapacityLayout(View v) {
		if (capacity_cb.isChecked()) {
			capacity_cb.setChecked(false);
			capacity_cb_name.setSelected(false);
			capacity_cb_open.setSelected(false);
		} else {
			capacity_cb.setChecked(true);
			capacity_cb_name.setSelected(true);
			capacity_cb_open.setSelected(true);
		}
	}
	
	@OnClick(R.id.holiday_layout)
	public void onholidayLayout(View v) {
		if (holiday_cb.isChecked()) {
			holiday_cb.setChecked(false);
			holiday_cb_name.setSelected(false);
			holiday_cb_open.setSelected(false);
		} else {
			holiday_cb.setChecked(true);
			holiday_cb_name.setSelected(true);
			holiday_cb_open.setSelected(true);
		}
	}
	
	@OnClick(R.id.cold_layout)
	public void onColdLayout(View v) {
		if (cold_cb.isChecked()) {
			cold_cb.setChecked(false);
			cold_cb_name.setSelected(false);
			cold_cb_open.setSelected(false);
		} else {
			cold_cb.setChecked(true);
			cold_cb_name.setSelected(true);
			cold_cb_open.setSelected(true);
		}
	}
	
	@OnClick(R.id.softfrozen_layout)
	public void onSoftfrozen(View v) {
		if (softfrozen_image.isChecked()) {
			softfrozen_image.setChecked(false);
			softfrozen_tv.setSelected(false);
		} else {
			softfrozen_image.setChecked(true);
			softfrozen_tv.setSelected(true);
		}
	}

	@Override
	protected void initView() {
		// TODO Auto-generated method stub

	}

}
