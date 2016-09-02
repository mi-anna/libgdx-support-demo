package com.support.demo;

import com.libgdx.support.GameEventAdapter;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

public class TestGameEvent extends GameEventAdapter<MainGame> {
	Context context;

	public TestGameEvent(Context context) {
		this.context = context;
	}

	Handler mHandler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			Toast.makeText(context, (String)msg.obj, Toast.LENGTH_SHORT).show();
		};
	};

	@Override
	public void onEvent2Android(String msg) {
		System.out.println(msg);
		Message message = Message.obtain();
		message.obj = msg;
		message.what = 1;
		mHandler.sendMessage(message);
	}

	@Override
	public void onEvent2LibGdx(String msg) {
		getGameEngine().setScreen(getGameEngine().getOtherScreen());
	}

}
