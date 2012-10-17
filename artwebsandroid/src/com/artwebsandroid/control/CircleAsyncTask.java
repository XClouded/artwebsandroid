package com.artwebsandroid.control;

import com.artwebsandroid.object.BinMap;
import com.artwebsandroid.utils.AndroidUtils;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ProgressBar;

public abstract class CircleAsyncTask extends BaseAsyncTask {
	private ProgressDialog progressDialog=null;
	
	
	public ProgressDialog getProgressDialog() {
		return progressDialog;
	}
		
	public CircleAsyncTask(Context context)
	{
		this(context, "���ڼ���");
	}
	public CircleAsyncTask(Context context,String message)
	{
		this.context=context;
		progressDialog=new ProgressDialog(this.context);
		progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		progressDialog.setMessage(message);	
		progressDialog.setCancelable(false);//���ɱ����ؼ�ȡ���Ի���
	}
	
	public void start()
	{
		this.hide();
		this.task.execute();
	}

	@Override
	public void show() {
		this.progressDialog.show();
		
	}

	@Override
	public void hide() {
		this.progressDialog.dismiss();
	}
	
	
}
