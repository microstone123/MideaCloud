package net.ting.sliding;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * @ClassName: ConnectionChangeReceiver
 * @Description: TODO(网络连接广播)
 * @author linhs
 * @date 2014-2-18 下午2:55:34
 */
public class ConnectionChangeReceiver extends BroadcastReceiver {

	public static OnConnectChangeListenting onConnectChangeListenting;

	@Override
	public void onReceive(Context context, Intent intent) {
		ConnectivityManager connectivityManager = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo activeNetInfo = connectivityManager.getActiveNetworkInfo();
		if (activeNetInfo != null) {
			onConnectChangeListenting.OnConnectChange(true);
			// msg.what = ConstantUtils.SUCC_NETWORK; // 发送网络连接消息 1001
		} else {
			onConnectChangeListenting.OnConnectChange(false);
			// msg.what = ConstantUtils.ERROR_NETWORK; // 发送网络断开消息 1002
		}
	}

	public static void setOnConnectChangeListenting(OnConnectChangeListenting onConnectChangeListenting) {
		ConnectionChangeReceiver.onConnectChangeListenting = onConnectChangeListenting;
	}
}