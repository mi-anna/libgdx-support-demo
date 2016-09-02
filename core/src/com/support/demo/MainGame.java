package com.support.demo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.libgdx.support.GameEngine;
import com.libgdx.support.GameEvent;
import com.support.demo.screen.GameScreen;
import com.support.demo.screen.OtherScreen;
import com.support.demo.screen.StartScreen;

public class MainGame extends GameEngine {
	public MainGame() {
	}

	public MainGame(GameEvent event) {
		super(event);
	}

	public float worldWidth = 480f;
	public float worldHeight = 320f;

	StartScreen startScreen;
	GameScreen gameScreen;
	OtherScreen otherScreen;

	AssetManager asset;

	@Override
	public void create() {
		asset = new AssetManager();
		asset.load("badlogic.jpg", Texture.class);
		asset.load("fish.png", Texture.class);
		asset.load("hi.jpg", Texture.class);

		asset.finishLoading();

		startScreen = new StartScreen(this);
		gameScreen = new GameScreen(this);
		otherScreen = new OtherScreen(this);

		setScreen(startScreen);
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		super.render();
	}

	public StartScreen getStartScreen() {
		return startScreen;
	}

	public GameScreen getGameScreen() {
		return gameScreen;
	}

	public OtherScreen getOtherScreen() {
		return otherScreen;
	}

	public AssetManager getAssetManager() {
		return asset;
	}

}
