package net.ting.sliding;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

public class BaseListView extends ListView {
	public BaseListView(Context context) {
		super(context, null);
	}

	public BaseListView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
		super.onMeasure(widthMeasureSpec, expandSpec);
	}
}
