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

public class GameScreen extends ScreenAdapter {
	MainGame mainGame;

	Image image;

	Stage stage;

	public GameScreen(MainGame mainGame) {
		this.mainGame = mainGame;
		stage = new Stage(new StretchViewport(mainGame.worldWidth, mainGame.worldHeight));
	}

	@Override
	public void show() {
		super.show();
		
		// image = new Image(new Texture(Gdx.files.internal("fish.png")));
		image = new Image(mainGame.getAssetManager().get("fish.png", Texture.class));
		image.addListener(new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				mainGame.setScreen(mainGame.getStartScreen());
				return true;
			}
		});

		stage.addActor(image);
		Gdx.input.setInputProcessor(stage);

		mainGame.getEvent().onEvent2Android("hi bad body from libgdx");
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		super.render(delta);

		stage.act();
		stage.draw();
	}

	@Override
	public void dispose() {
		super.dispose();
		if (image != null) {
			image.clear();
		}
		if (stage != null) {
			stage.dispose();
		}
	}
}
