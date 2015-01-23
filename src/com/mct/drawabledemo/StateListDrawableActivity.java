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

		// ���״̬����һ��������ʾ״̬���飬�ڶ���������ʾ��Щ״̬��ʾ��drawable��Դ��
		// ����״̬
		stateDrawable.addState(new int[] { android.R.attr.state_pressed,
				android.R.attr.state_enabled },
				getResources().getDrawable(R.drawable.tag_orange));
		// ѡ��״̬
		stateDrawable.addState(new int[] { android.R.attr.state_selected,
				android.R.attr.state_enabled },
				getResources().getDrawable(R.drawable.tag_red));
		// ����״̬
		stateDrawable.addState(new int[] { android.R.attr.state_enabled },
				getResources().getDrawable(R.drawable.tag_violet));
		stateDrawable.addState(new int[] {},
				getResources().getDrawable(R.drawable.tag_violet));
		btn2.setBackgroundDrawable(stateDrawable);

	}

}
