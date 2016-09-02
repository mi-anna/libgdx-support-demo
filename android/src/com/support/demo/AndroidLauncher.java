package com.support.demo;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;

import android.os.Bundle;
import android.view.Gravity;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class AndroidLauncher extends AndroidApplication {
Button mButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		// initialize(new MyGdxGame(), config);
		
		final TestGameEvent testGameEvent = new TestGameEvent(getApplicationContext());
		final MainGame myGdxGame = new MainGame(testGameEvent);
		SurfaceView gameView = (SurfaceView) initializeForView(myGdxGame, config);

		addContentView(gameView, createLayoutParams());
		
		
		mButton = (Button) findViewById(R.id.btn);
		
		mButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				testGameEvent.onEvent2LibGdx("hello");
			}
		});
	}

	protected FrameLayout.LayoutParams createLayoutParams() {
		FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(
				android.view.ViewGroup.LayoutParams.MATCH_PARENT, 800);
		layoutParams.gravity = Gravity.CENTER;
		return layoutParams;
	}

}
