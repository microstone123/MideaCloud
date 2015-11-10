package net.ting.sliding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;

import android.util.Log;
import android.util.Xml;

public class XmlUtils {

	public static List<GoodsInfo> parseGoodsInfo(InputStream is) throws Exception {
		List<GoodsInfo> xmlInfos = null;
		GoodsInfo xmlInfo = null;

		// String str = convertStreamToString(is);
		//
		// Log.e("String", "String " + str + "");

		XmlPullParser parser = Xml.newPullParser(); // 由android.util.Xml创建一个XmlPullParser实例
		parser.setInput(is, "UTF-8"); // 设置输入流 并指明编码方式
		int eventType = parser.getEventType();
		while (eventType != XmlPullParser.END_DOCUMENT) {
			switch (eventType) {
			case XmlPullParser.START_DOCUMENT:
				xmlInfos = new ArrayList<GoodsInfo>();
				break;
			case XmlPullParser.START_TAG:
				if (parser.getName().equals("info")) {
					xmlInfo = new GoodsInfo();
				}
				if (parser.getName().equals("name")) {
					eventType = parser.next();
					xmlInfo.setName(parser.getText());
					eventType = parser.next();
				} else if (parser.getName().equals("placeArea")) {
					eventType = parser.next();
					xmlInfo.setPlaceArea(parser.getText());
				} else if (parser.getName().equals("price")) {
					eventType = parser.next();
					xmlInfo.setPrice(parser.getText());
				} else if (parser.getName().equals("imgUrl")) {
					eventType = parser.next();
					xmlInfo.setImgUrl(parser.getText());
				}
				break;
			case XmlPullParser.END_TAG:
				if (parser.getName().equals("info")) {
					xmlInfos.add(xmlInfo);
					xmlInfo = null;
				}
				break;
			}
			eventType = parser.next();
		}
		return xmlInfos;
	}

	public static String convertStreamToString(InputStream is) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();

		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return sb.toString();
	}
}
