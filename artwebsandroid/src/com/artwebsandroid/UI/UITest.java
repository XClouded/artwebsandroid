package com.artwebsandroid.UI;

import com.artwebsandroid.ArtwebsandroidActivity;
import com.artwebsandroid.demo.TransmitExample;
import com.artwebsandroid.object.BinList;
import com.artwebsandroid.object.BinMap;
import com.artwebsandroid.socket.ClientTCP;
import com.artwebsandroid.utils.HttpDownloader;

import android.test.AndroidTestCase;
import android.util.Log;

public class UITest extends AndroidTestCase {	
	
	public void testList()
	{		
		UIFactory factory=new UIFactory();
		factory.setTransmit(new TransmitExample("test/"));
		factory.setMainActity(new ArtwebsandroidActivity());
		factory.parseData("LHBSystem_1/index.php?mod=examplexml&act=glist&source=1");
		BinMap para=factory.getMap();
		Log.i("List",para.getItem().toString());
		Log.i("List",((BinList)(para.getValue("rows"))).getItem().toString());	
	}
	
	public void testInfo()
	{
		
		UIFactory factory=new UIFactory();
		factory.setTransmit(new TransmitExample("test/"));
		factory.setMainActity(new ArtwebsandroidActivity());
		factory.parseData("/LHBSystem_1/index.php?mod=examplexml&act=info&id=3");
		BinMap para=factory.getMap();
		Log.i("Info",para.getItem().toString());
		Log.i("Info",((BinList)(para.getValue("rows"))).getItem().toString());	
	}
	
	public void testForm()
	{
		UIFactory factory=new UIFactory();
		factory.setTransmit(new TransmitExample("test/"));
		factory.setMainActity(new ArtwebsandroidActivity());
		factory.parseData("LHBSystem_1/index.php?mod=examplexml&act=ui&session=session20120318162222983415");
		BinMap para=factory.getMap();
		Log.i("Form",para.getItem().toString());
		Log.i("Form",((BinList)(para.getValue("rows"))).getItem().toString());	
	}
}
