package com.artwebsandroid.utils;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.widget.TextView;

public class AndroidUtils {
	public static void setEditTextReadOnly(TextView view){  
	      view.setTextColor(Color.GRAY);   //����ֻ��ʱ��������ɫ  
	      if (view instanceof android.widget.EditText){  
	          view.setCursorVisible(false);      //����������еĹ�겻�ɼ�  
	          view.setFocusable(false);           //�޽���  
	          view.setFocusableInTouchMode(false);     //����ʱҲ�ò�������  
	      }  
	}  
	
	public static void commDialog(Context context,String title,String message)
	{
		new AlertDialog.Builder(context)
		.setTitle(title)
        .setMessage(message)   
        .setPositiveButton("ȷ��",  
                new DialogInterface.OnClickListener() {  
                    public void onClick(DialogInterface dialog,  
                            int whichButton) {  
                    }  
                }).show();
	}
	
	

}
