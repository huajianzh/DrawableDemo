package com.mct.drawabledemo;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.widget.ImageView;

public class LayerDrawableActivity extends Activity {

	private LayerDrawable layer;

	private ImageView iv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_layerdrawable);
		iv = (ImageView) findViewById(R.id.m_image);
		Drawable[] layers = { getResources().getDrawable(R.drawable.pic3),
				getResources().getDrawable(R.drawable.pic1),
				getResources().getDrawable(R.drawable.pic4) };
		//创建图层
		layer = new LayerDrawable(layers);
		//设置图层边距(第一个参数表示图层的下标，后面表示左、上、右、下的边距)
		layer.setLayerInset(0, 80, 80, 0, 0);
		layer.setLayerInset(1, 40, 40, 40, 40);
		layer.setLayerInset(2, 0, 0, 80, 80);

		// 根绝层id获取Drawable
		// layer.findDrawableByLayerId(id)

		iv.setImageDrawable(layer);
	}
}
