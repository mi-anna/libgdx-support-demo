package com.support.demo.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.support.demo.MainGame;

public class StartScreen extends ScreenAdapter {
	MainGame mainGame;
	Stage stage;

	Image imageBtn;

	public StartScreen(MainGame mainGame) {
		this.mainGame = mainGame;
	}

	@Override
	public void show() {
		super.show();
		stage = new Stage(new StretchViewport(mainGame.worldWidth, mainGame.worldHeight));

//		Texture texture = new Texture(Gdx.files.internal("badlogic.jpg"));
		Texture texture = mainGame.getAssetManager().get("badlogic.jpg", Texture.class);
		imageBtn = new Image(texture);
		imageBtn.addListener(new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				mainGame.setScreen(mainGame.getGameScreen());
				return true;
			}
		});

		stage.addActor(imageBtn);

		Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		stage.act();
		stage.draw();
	}

	@Override
	public void dispose() {
		if (imageBtn != null) {
			imageBtn.clear();
		}
		if (stage != null) {
			stage.dispose();
		}

	}

}
