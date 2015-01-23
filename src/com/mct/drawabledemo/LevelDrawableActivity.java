package com.mct.drawabledemo;

import android.app.Activity;
import android.graphics.drawable.LevelListDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class LevelDrawableActivity extends Activity {
	private ImageView iv;
	private ImageView iv2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_leveldrawable);
		iv = (ImageView) findViewById(R.id.m_image);
		// LevelListDrawable drawable = (LevelListDrawable) iv.getDrawable();
		// drawable.setLevel(2);
		iv.setImageLevel(2);

		iv2 = (ImageView) findViewById(R.id.m_image2);
		// 创建等级资源
		final LevelListDrawable drawable = new LevelListDrawable();
		// 添加资源（low,high,drawable）
		drawable.addLevel(0, 1, getResources().getDrawable(R.drawable.pic3));
		drawable.addLevel(1, 2, getResources().getDrawable(R.drawable.pic4));
		drawable.setLevel(1);
		iv2.setImageDrawable(drawable);
		iv2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				drawable.setLevel(drawable.getLevel() == 2 ? 1 : 2);
			}
		});
	}

}
