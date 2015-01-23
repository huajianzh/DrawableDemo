package com.mct.drawabledemo;

import android.app.Activity;
import android.graphics.drawable.ClipDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class ClipDrawableActivity extends Activity implements OnClickListener {
	private ImageView iv1;
	private ClipDrawable clipDrawable;
	private ClipDrawable clip2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_clipdrawable);
		iv1 = (ImageView) findViewById(R.id.m_image);
		clipDrawable = (ClipDrawable) iv1.getDrawable();
		findViewById(R.id.m_btn1).setOnClickListener(this);
		findViewById(R.id.m_btn2).setOnClickListener(this);

		//创建ClipDrawable对象
		clip2 = new ClipDrawable(getResources().getDrawable(
				R.drawable.shopping_image2), Gravity.CENTER,
				ClipDrawable.VERTICAL);
	}

	private void update(final ClipDrawable drawable) {
		new Thread() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				while (drawable.getLevel() < 10000) {
					Message msg = mHandler.obtainMessage(1, drawable);
					msg.sendToTarget();
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		}.start();
	}

	private Handler mHandler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			super.handleMessage(msg);
			switch (msg.what) {
			case 1:
				ClipDrawable drawable = (ClipDrawable) msg.obj;
				drawable.setLevel(drawable.getLevel() + 200);
				break;
			}
		}

	};

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.m_btn1:
			iv1.setImageDrawable(clipDrawable);
			// 设置等级（0到10000）
			clipDrawable.setLevel(0);
			update(clipDrawable);
			break;
		case R.id.m_btn2:
			iv1.setImageDrawable(clip2);
			clip2.setLevel(0);
			update(clip2);
			break;
		}
	}

}
