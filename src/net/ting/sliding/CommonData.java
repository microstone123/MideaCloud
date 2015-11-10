package net.ting.sliding;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;

public class CommonData {
	public enum XmlFile {
		INCIDENT_AREA("incident_area.xml"), INCIDENT_GOODS_INFO("goods_info.xml");

		private String path;

		private XmlFile(String path) {
			this.setPath(path);
		}

		public String getPath() {
			return path;
		}

		public void setPath(String path) {
			this.path = path;
		}
	}

	public static List<GoodsInfo> getGoodsInfo(Context context, XmlFile xmlFile) {
		List<GoodsInfo> xmlInfos = new ArrayList<GoodsInfo>(0);
		try {
			InputStream in = context.getResources().getAssets().open(xmlFile.getPath());
			xmlInfos = XmlUtils.parseGoodsInfo(in);
		} catch (Exception e) {
			// do nothing
		}
		return xmlInfos;
	}
}
