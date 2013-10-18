package com.rsv.webimageview.example;

import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

/**
 * A list of images, but with the same url
 * 
 * An url should only be fetched for only once
 */
public class ImageListSameUrl extends Activity {

	private static Random random = new Random();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.imglist);

		setUp();
	}

	private void setUp() {

		String baseUrl = "http://www.kidsmathgamesonline.com/images/pictures/numbers600/number%d.jpg";
		
		String imgUrl = String.format(baseUrl + "?t=" + getRandomInt(1, 100), 1 % 10);

		String[] urls = new String[20];

		for (int i = 0; i < urls.length; i++) {
			urls[i] = imgUrl;
		}

		ListView listView = (ListView) findViewById(R.id.listView);

		ItemAdapter adapter = new ItemAdapter(this, R.layout.imgitem, urls);

		listView.setAdapter(adapter);

	}

	private static int getRandomInt(int min, int max) {
		return random.nextInt(max - min) + min;

	}
}
