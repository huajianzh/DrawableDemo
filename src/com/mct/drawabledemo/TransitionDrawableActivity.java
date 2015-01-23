package com.mct.drawabledemo;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class TransitionDrawableActivity extends Activity implements
		OnClickListener {
	private Drawable[] drawables;

	private TransitionDrawable tranDrawable1;

	private TransitionDrawable tranDrawable2;
	private int index;

	private ImageView iv2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_transitiondrawable);
		ImageView iv1 = (ImageView) findViewById(R.id.m_image);
		tranDrawable1 = (TransitionDrawable) iv1.getDrawable();
		iv1.setTag(false);
		iv1.setOnClickListener(this);

		drawables = new Drawable[] {
				getResources().getDrawable(R.drawable.pic1),
				getResources().getDrawable(R.drawable.pic3),
				getResources().getDrawable(R.drawable.pic4) };

		iv2 = (ImageView) findViewById(R.id.m_image2);
		iv2.setOnClickListener(this);
		showNextImage();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.m_image:
			boolean r = (Boolean) v.getTag();
			if (!r) {
				// 在一秒的时间内由第一张到第二张的切换
				tranDrawable1.startTransition(1000);
				v.setTag(true);
			} else {
				// 用一秒时间从第二张回到第一张的切换
				tranDrawable1.reverseTransition(1000);
				v.setTag(false);
			}
			break;
		case R.id.m_image2:
			showNextImage();
			break;
		}

	}

	private void showNextImage() {
		tranDrawable2 = new TransitionDrawable(new Drawable[] {
				drawables[index % drawables.length],
				drawables[(index + 1) % drawables.length] });
		iv2.setImageDrawable(tranDrawable2);
		tranDrawable2.startTransition(1000);
		index++;
	}

}
