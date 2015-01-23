package com.mct.drawabledemo;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {
	private String[] names = { "StateListDrawable", "ClipDrawable",
			"LayerDrawable", "LevelListDrawable", "Transition&InsetDrawable",
			"ScaleAndRotate", "GradienAndShape", "BitmapDrawable" };
	private Class<?>[] clas = { StateListDrawableActivity.class,
			ClipDrawableActivity.class, LayerDrawableActivity.class,
			LevelDrawableActivity.class, TransitionDrawableActivity.class,
			ScaleAndRotateActivity.class, GradienAndShapeActivity.class,
			BitmapActivity.class };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, names);
		setListAdapter(adapter);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		Intent intent = new Intent(this, clas[position]);
		startActivity(intent);
	}

}
