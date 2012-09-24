package com.artwebsandroid.utils;


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
	
	

}
