package cn.artwebs.androiddemo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;


public class MainActivity extends Activity {
	private LinearLayout mainLayout;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mainLayout=(LinearLayout)getLayoutInflater().inflate(R.layout.activity_main, null);
		this.setContentView(mainLayout);
		addButton("摄像头测试",CameraActivity.class);
		addButton("二维码测试",QRCodeActivity.class);
		addButton("刮刮卡",ScratchSardViewActivity.class);
		addButton("单选控件",SingleChoiceActivity.class);
	}

	private void addButton(String name,final Class obj)
	{
		Button btn=new Button(this);
		btn.setText(name);
		btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this,obj));
			}
		});
		mainLayout.addView(btn);
	}
}
