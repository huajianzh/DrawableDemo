package com.mct.drawabledemo;

import android.app.Activity;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.widget.Button;

public class StateListDrawableActivity extends Activity {
	private Button btn2;

	private StateListDrawable stateDrawable;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_statelist);
		btn2 = (Button) findViewById(R.id.m_btn2);

		stateDrawable = new StateListDrawable();

		// 添加状态（第一个参数表示状态数组，第二个参数表示这些状态显示的drawable资源）
		// 按下状态
		stateDrawable.addState(new int[] { android.R.attr.state_pressed,
				android.R.attr.state_enabled },
				getResources().getDrawable(R.drawable.tag_orange));
		// 选中状态
		stateDrawable.addState(new int[] { android.R.attr.state_selected,
				android.R.attr.state_enabled },
				getResources().getDrawable(R.drawable.tag_red));
		// 正常状态
		stateDrawable.addState(new int[] { android.R.attr.state_enabled },
				getResources().getDrawable(R.drawable.tag_violet));
		stateDrawable.addState(new int[] {},
				getResources().getDrawable(R.drawable.tag_violet));
		btn2.setBackgroundDrawable(stateDrawable);

	}

}
