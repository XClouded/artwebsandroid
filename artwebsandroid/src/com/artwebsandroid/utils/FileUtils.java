package com.artwebsandroid.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;

public class FileUtils {
	private String SDPATH;

	public String getSDPATH() {
		return SDPATH;
	}
	public FileUtils() {
		//�õ���ǰ�ⲿ�洢�豸��Ŀ¼
		// /SDCARD
		if (android.os.Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED))
			SDPATH = Environment.getExternalStorageDirectory() + "/";
		else
			SDPATH="/";
			
	}
	
	public FileUtils(String root)
	{
		if (android.os.Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED))
			SDPATH = Environment.getExternalStorageDirectory() + "/";
		else
			SDPATH=root+"/";
		
	}
	/**
	 * ��SD���ϴ����ļ�
	 * 
	 * @throws IOException
	 */
	public File creatSDFile(String fileName) throws IOException {
		File file = new File(SDPATH + fileName);
		file.createNewFile();
		return file;
	}
	
	public void deleteSDFile(String fileName)
	{
		File file = new File(SDPATH + fileName);
		file.delete();
	}
	
	/**
	 * ��SD���ϴ���Ŀ¼
	 * 
	 * @param dirName
	 */
	public File creatSDDir(String dirName) {
		File dir = new File(SDPATH + dirName);
		dir.mkdirs();
		return dir;
	}

	/**
	 * �ж�SD���ϵ��ļ����Ƿ����
	 */
	public boolean isFileExist(String fileName){
		File file = new File(SDPATH + fileName);
		return file.exists();
	}
	
	/**
	 * ��һ��InputStream���������д�뵽SD����
	 */
	public File write2SDFromInput(String path,String fileName,InputStream input){
		File file = null;
		OutputStream output = null;
		try{
			creatSDDir(path);			
			file = creatSDFile(path + fileName);
			output = new FileOutputStream(file);
			byte buffer [] = new byte[4 * 1024];			
			int count=0;
			while((count=input.read(buffer))!=-1)
			{
				output.write(buffer, 0, count);
			}
			output.flush();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				output.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		return file;
	}
	
	/**
	 * ��һ��InputStream���������д�뵽SD����
	 */
	public File write2SDFromInput(String path,String fileName,InputStream input,Handler handler){
		File file = null;
		OutputStream output = null;
		try{
			creatSDDir(path);			
			file = creatSDFile(path + fileName);
			output = new FileOutputStream(file);
			byte buffer [] = new byte[1024];			
			int count=0;
			while((count=input.read(buffer))!=-1)
			{
				output.write(buffer, 0, count);
				handler.sendEmptyMessage(1);
			}
			handler.sendEmptyMessage(2);
			output.flush();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				output.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		return file;
	}
	
	public void installApk(Activity activity,String filename)
	{
		File file=new File(filename);
		Intent intent=new Intent();
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		intent.setAction(Intent.ACTION_VIEW);
		String type="application/vnd.android.package-archive";
		intent.setDataAndType(Uri.fromFile(file), type);
		activity.startActivity(intent);
//		file.delete();
	}

}