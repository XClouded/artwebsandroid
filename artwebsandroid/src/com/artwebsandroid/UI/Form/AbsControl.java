package com.artwebsandroid.UI.Form;

import java.util.ArrayList;

import com.artwebsandroid.UI.IUIFactory;
import com.artwebsandroid.object.BinMap;
import com.artwebsandroid.transmit.ITransmit;

import android.app.Activity;
import android.view.View.OnClickListener;
import android.widget.TableLayout;
import android.widget.TableRow;

public abstract class AbsControl {	
	protected TableLayout layout;
	protected Activity activity;
	protected BinMap para;
	protected TableRow tbrow;
	protected ITransmit transmit;
	protected String strName="";
	protected String strValue="";
	protected String strText="";
	protected ArrayList<AbsControl> ctlList=new ArrayList<AbsControl>();
	protected OnClickListener selfOnClickListener;
	protected IUIFactory uiFactory;
	
	
	public String getStrName() {
		return strName;
	}

	public String getStrValue() {
		return strValue;
	}	
	
	
	public String getStrText() {
		return strText;
	}

	
	
	public ArrayList<AbsControl> getCtlList() {
		return ctlList;
	}

	public void setCtlList(ArrayList<AbsControl> ctlList) {
		this.ctlList = ctlList;
	}
	
	

	public void setSelfOnClickListener(OnClickListener selfOnClickListener) {
		this.selfOnClickListener = selfOnClickListener;
	}

	public AbsControl(TableLayout layout,Activity activity,BinMap para)
	{
		this.layout=layout;
		this.activity=activity;
		this.para=para;
		this.tbrow=new TableRow(activity);
		this.strName=this.para.getValue("NAME").toString();
	}
	
	public void setTransmit(ITransmit transmit)
	{
		this.transmit=transmit;
	}
	
	public void setUiFactory(IUIFactory uiFactory) {
		this.uiFactory = uiFactory;
	}

	public abstract void create();
	
	public void display()
	{
		ctlList.add(this);
		this.layout.addView(this.tbrow);
	}
}