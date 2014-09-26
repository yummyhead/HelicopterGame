package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
    float j = 0, i = 0;
    Sound gypsy;

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
        gypsy = Gdx.audio.newSound(Gdx.files.internal("1.mp3"));
        gypsy.loop(0.2f, 1.1f, 1);

	}

	@Override
	public void render () {

        Gdx.gl.glClearColor((float)Math.random(), (float)Math.random(), (float)Math.random(), 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.setColor((float)Math.random(), (float)Math.random(), (float)Math.random(), (float)Math.random());
        batch.begin();
        batch.draw(img, i, j, img.getWidth() * (float) Math.random(), img.getHeight() * (float) Math.random());
        batch.end();
        i += Math.random()*5-2;
        j += Math.random()*5-2;
        if (i>Gdx.graphics.getWidth()){
            i = -img.getWidth();
        }
        if (j>Gdx.graphics.getWidth()){
            j = -img.getHeight();
        }

	}
}
