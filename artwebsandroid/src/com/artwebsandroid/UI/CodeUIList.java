package com.artwebsandroid.UI;


import android.app.Activity;
import android.view.View;
import android.widget.ListView;

public class CodeUIList extends CodeUI {
	protected ListAdapter adapter=null;
	
	public void setAdapter(ListAdapter adapter)
	{
		this.adapter=adapter;
	}
	
	@Override
	public View drawnView(final Activity activity,Integer parentid,Integer id) {
//		adapter=new ListAdapter(this.para,activity);	
//		ListView listView=(ListView)activity.findViewById(id);
		ListView listView=new ListView(activity);
		if(adapter==null)this.setAdapter(new ListAdapter(this.para,activity));
		listView.setAdapter(adapter);		
		listView.setOnItemClickListener(this.onItemClickListener);
		return listView;
	}
	

}