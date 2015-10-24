package com.example.commondialog;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.commondialog.CommonDialog.DialogNegativeListener;
import com.example.commondialog.CommonDialog.DialogPositiveListener;

public class MainActivity extends Activity implements OnClickListener {

	private Button btn1;
	private Button btn2;
	private Button btn3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btn1 = (Button) findViewById(R.id.btn1);
		btn1.setOnClickListener(this);
		btn2 = (Button) findViewById(R.id.btn2);
		btn2.setOnClickListener(this);
		btn3 = (Button) findViewById(R.id.btn3);
		btn3.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn1:
			CommonDialog dialog1 = new CommonDialog(this);
			dialog1.setPositiveListener(new DialogPositiveListener() {
				@Override
				public void onClick() {
					ToastUtils.show(MainActivity.this, "确定");
				}
			});
			dialog1.initDialog("您确定要删除收藏？").show();
			break;
		case R.id.btn2:
			CommonDialog dialog2 = new CommonDialog(this);
			dialog2.setPositiveListener(new DialogPositiveListener() {
				@Override
				public void onClick() {
					ToastUtils.show(MainActivity.this, "确定");
				}
			});
			dialog2.setNegativeListener(new DialogNegativeListener() {
				@Override
				public void onClick() {
					ToastUtils.show(MainActivity.this, "取消");
				}
			});
			dialog2.initDialog("您确定要取消该收藏？").show();
			break;
		case R.id.btn3:
			CommonDialog dialog3 = new CommonDialog(this);
			dialog3.setPositiveListener(new DialogPositiveListener() {
				@Override
				public void onClick() {
					ToastUtils.show(MainActivity.this, "再看看");
				}
			});
			dialog3.setNegativeListener(new DialogNegativeListener() {
				@Override
				public void onClick() {
					ToastUtils.show(MainActivity.this, "退出");
				}
			});
			dialog3.initDialog("您确定现在退出app吗？", "退出", "再看看").show();
			break;
		default:
			break;
		}

	}

}
