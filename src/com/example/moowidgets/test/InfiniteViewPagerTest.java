package com.example.moowidgets.test;

import org.moo.widgets.InfinitePagerAdapter;
import org.moo.widgets.InfiniteViewPager;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class InfiniteViewPagerTest extends Activity
{
	private InfiniteViewPager _pager;
	private MyInfinitePagerAdapter _adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.infinite_view_pager);
		
		_pager = (InfiniteViewPager)findViewById(R.id.infinite_view_pager);
		_adapter = new MyInfinitePagerAdapter(this);
		
		_pager.setAdapter(_adapter);
	}

	@Override
	protected void onPause()
	{
		// TODO Auto-generated method stub
		super.onPause();
	}

	@Override
	protected void onResume()
	{
		// TODO Auto-generated method stub
		super.onResume();
	}
	
	private class MyInfinitePagerAdapter extends InfinitePagerAdapter
	{
		private LayoutInflater _inflater;
		
		public MyInfinitePagerAdapter(Context context)
		{
			_inflater = LayoutInflater.from(context);
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position)
		{			
			View view = _inflater.inflate(R.layout.infinite_view_pager_item, container, false);
			TextView positionText = (TextView)view.findViewById(R.id.position);
			positionText.setText(String.valueOf(position));

			container.addView(view, 0);
			return view;
		}
		
		@Override
		public void destroyItem(ViewGroup container, int position, Object object)
		{
			container.removeView((View)object);
		}

		@Override
		public boolean isViewFromObject(View view, Object object)
		{
			return view == object;
		}
	}
}
