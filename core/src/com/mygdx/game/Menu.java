package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by user on 16.07.2014.
 */
public class Menu {

    public int nextMenu;
    public boolean allowPause = false;
    public int ID = 0;
    public boolean initialised = false;
    public boolean paused = false, optionsOpen = false;
    Button pauseButton, resumeButton, exitButton, optionsButton;
    Texture pause, resume, exit, options;
    AssetManager assets;

    public Menu(int id) {
        nextMenu = id;
    }

    public void load(AssetManager assets) {
        this.assets = assets;
        if (!assets.isLoaded("pause.png", Texture.class)) {
            assets.load("pause.png", Texture.class);
        }
        if (!assets.isLoaded("play.png", Texture.class)) {
            assets.load("play.png", Texture.class);
        }
        if (!assets.isLoaded("p.png", Texture.class)) {
            assets.load("p.png", Texture.class);
        }
    }

    public void initialiseResources() {
        pause = assets.get("pause.png", Texture.class);
        resume = assets.get("play.png", Texture.class);
        exit = assets.get("pause.png", Texture.class);
        options = assets.get("pause.png", Texture.class);
        float BUTTONSIZE = Gdx.graphics.getWidth() / 4.17f;
        pauseButton = new Button(new Rectangle( Gdx.graphics.getWidth() - BUTTONSIZE/3,
                Gdx.graphics.getHeight() - BUTTONSIZE/3, BUTTONSIZE/3, BUTTONSIZE/3), pause);
        resumeButton = new Button(new Rectangle( Gdx.graphics.getWidth()/2 - BUTTONSIZE/2,
                (Gdx.graphics.getHeight()*4)/5 - BUTTONSIZE/2, BUTTONSIZE, BUTTONSIZE), resume);
        exitButton = new Button(new Rectangle( Gdx.graphics.getWidth()/2 - BUTTONSIZE/2,
                (Gdx.graphics.getHeight()*3)/5 - BUTTONSIZE/2, BUTTONSIZE, BUTTONSIZE), pause);
        optionsButton = new Button(new Rectangle( Gdx.graphics.getWidth()/2 - BUTTONSIZE/2,
                (Gdx.graphics.getHeight()*2)/5 - BUTTONSIZE/2, BUTTONSIZE, BUTTONSIZE), pause);
    }

    public void invalidate() {
        //System.out.println("inv");
        if (allowPause && pauseButton.checkTouch()) paused = true;
    }

    public void draw(SpriteBatch batch, ShapeRenderer renderer) {
        //System.out.println(paused);
        if (!paused) {
            invalidate();
            if (allowPause) pauseButton.draw(batch);
        } else {
            batch.setColor(1,1,1,0.5f);
            batch.begin();
            batch.draw(assets.get("p.png", Texture.class), 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
            batch.end();
            batch.setColor(1,1,1,1);
            if (resumeButton.checkTouch()|| pauseButton.checkTouch()) paused = false;
            if (exitButton.checkTouch()) nextMenu = 0;
            if (optionsButton.checkTouch()) optionsOpen = true;
            System.out.println(nextMenu);
            pauseButton.draw(batch);
            resumeButton.draw(batch);
            exitButton.draw(batch);
            optionsButton.draw(batch);
        }
        //batch.end();
    }
}
