package com.mct.drawabledemo;

import android.app.Activity;
import android.graphics.drawable.RotateDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class ScaleAndRotateActivity extends Activity implements OnClickListener {
	private ScaleDrawable scaleDrawable;
	private RotateDrawable rotateDrawable;
	private SeekBar mSeek;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_scale);
		ImageView iv1 = (ImageView) findViewById(R.id.m_image);
		mSeek = (SeekBar) findViewById(R.id.m_seek);
		mSeek.setMax(100);
		scaleDrawable = (ScaleDrawable) iv1.getDrawable();

		scaleDrawable.setLevel(1);

		// (图片源，对齐方式，宽方向伸缩比例float,高方向伸缩比例)
		// ScaleDrawable d = new ScaleDrawable(drawable, gravity, scaleWidth,
		// scaleHeight);

		ImageView iv2 = (ImageView) findViewById(R.id.m_image2);
		rotateDrawable = (RotateDrawable) iv2.getDrawable();

		// RotateDrawable d = new RotateDrawable();
		// d.setDrawable(drawable)
		// d.setPivotX(pivotX)
		// d.setPivotY(pivotY)
		// d.setFromDegrees(fromDegrees)

		mSeek.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub
				scaleDrawable.setLevel(progress * 100);
				rotateDrawable.setLevel(progress * 100);

			}
		});
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		}
	}

}
