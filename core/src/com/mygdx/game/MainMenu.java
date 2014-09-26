package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

import java.util.ArrayList;

/**
 * Created by IVO on 15.07.2014.
 * main menu
 */

public class MainMenu extends Menu {
    public int ID = 0;
    //float ICONSIZE;
    float PLAYSIZE;
    //float JOYSIZE;
    //float JOYBASESIZE;
    //final int READYGAMESCOUNT = 1;
    public int curMenu = 0;
    Texture backGround;
    Texture play, options, credits;
    //ArrayList<Texture> icons;
    //Rectangle iconsRect, leftJoyRect;
    //float crossX, crossY;
    //float crossSpeedX=0, crossSpeedY=0;
    //JoyStick mainMenuJoy;
    int halfScreenHeight = Gdx.graphics.getHeight() / 2;
    int halfScreenWidth = Gdx.graphics.getWidth() / 2;
    Button playButton, optionsButton, creditsButton;

    public MainMenu(int id) {
        super(id);
        ID = 0;
        //ICONSIZE = Gdx.graphics.getHeight()/12.5f;
        PLAYSIZE = Gdx.graphics.getHeight()/2.5f;
        //JOYSIZE = Gdx.graphics.getHeight()/6.25f;
        //JOYBASESIZE = Gdx.graphics.getHeight()/2.5f;
        //icons = new ArrayList<Texture>();
        //iconsRect = new Rectangle(halfScreenWidth + halfScreenHeight/6, Gdx.graphics.getHeight()/7,
               //halfScreenWidth *0.74f, Gdx.graphics.getHeight()*0.74f);
        //leftJoyRect = new Rectangle(halfScreenWidth+Gdx.graphics.getWidth() / 5f, halfScreenHeight -JOYBASESIZE/2, JOYBASESIZE, JOYBASESIZE);
        //crossX = iconsRect.getX() + iconsRect.getWidth()/2;
        //crossY = iconsRect.getY() + iconsRect.getHeight()/2;
    }

    public void invalidate() {
        super.invalidate();
        //mainMenuJoy.checkTouch();

        //crossSpeedX = (float)mainMenuJoy.joyOffsetX()/20;
        //crossSpeedY = (float)mainMenuJoy.joyOffsetY()/20;

        //moveCross();
        if (playButton.checkTouch()) {
            nextMenu = 1;
        }
        if (optionsButton.checkTouch()) {
            nextMenu = 2;
        }
        if (creditsButton.checkTouch()) {
            nextMenu = 3;
        }
    }

    @Override
    public void draw(SpriteBatch batch, ShapeRenderer renderer) {
        //Gdx.gl.glClearColor(0.5f, 0.5f, 0.5f, 1);
        //Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //invalidate();

        batch.begin();

        /*for (int i = 0; i < icons.size(); ++i) {
            float x = iconsRect.y+iconsRect.height-ICONSIZE-(ICONSIZE+13)*(i/6);
            float y = iconsRect.x + (ICONSIZE+13)*(i%6);
            batch.draw(icons.get(i), x, y, ICONSIZE, ICONSIZE);
        }*/

        //batch.draw(cross, crossX-JOYSIZE/2, crossY-JOYSIZE/2, JOYSIZE, JOYSIZE);
        batch.draw(backGround, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.end();
        playButton.draw(batch);
        optionsButton.draw(batch);
        creditsButton.draw(batch);
        //mainMenuJoy.draw(batch, renderer);
        super.draw(batch, renderer);
    }

    @Override
    public void load(AssetManager assets) {
        super.load(assets);
        assets.load("bg.png", Texture.class);
        assets.load("options.png", Texture.class);
        assets.load("credits.png", Texture.class);
        //assets.load("joybase.png", Texture.class);
        //assets.load("joy.png", Texture.class);
        //assets.load("cross.png", Texture.class);
        //assets.load("play.png", Texture.class);
        /*for (int i=0; i<READYGAMESCOUNT; ++i) {
            String path = "icons/"+(i+1)+".png";
            assets.load(path, Texture.class);
        }*/
    }

    @Override
    public void initialiseResources() {
        if (!initialised) {
            super.initialiseResources();
            backGround = (assets.get("bg.png"));
            //joyBase = (assets.get("joybase.png"));//new Texture(Gdx.files.internal("joybase.png"));
            //joy = (assets.get("joy.png"));//new Texture(Gdx.files.internal("joy.png"));
            play = (assets.get("play.png"));
            credits = (assets.get("credits.png"));
            options = (assets.get("options.png"));
           /* cross = (assets.get("cross.png"));
            for (int i=0; i<READYGAMESCOUNT; ++i) {
                String path = "icons/"+(i+1)+".png";
                icons.add(assets.get(path, Texture.class)/*new Texture(Gdx.files.internal(path)));
            }*/
            //mainMenuJoy = new JoyStick(leftJoyRect, joyBase, joy, Color.BLACK, Gdx.graphics.getWidth()/20f);
            playButton = new Button(new Rectangle(Gdx.graphics.getWidth()/3-PLAYSIZE/2, Gdx.graphics.getHeight()/2 - PLAYSIZE/2, PLAYSIZE, PLAYSIZE), play);
            optionsButton = new Button(new Rectangle(Gdx.graphics.getWidth()*2/3-PLAYSIZE/3, Gdx.graphics.getHeight()/2 - PLAYSIZE/3 + PLAYSIZE/3, PLAYSIZE/1.5f, PLAYSIZE/1.5f), options);
            creditsButton = new Button(new Rectangle(Gdx.graphics.getWidth()*2/3-PLAYSIZE/3, Gdx.graphics.getHeight()/2 - PLAYSIZE/3 - PLAYSIZE/3, PLAYSIZE/1.5f, PLAYSIZE/1.5f), credits);
            initialised = true;
        }
    }

   /* private void moveCross() {
        crossX += crossSpeedX;
        crossY += crossSpeedY;
        if (crossX < iconsRect.getX()) crossX = iconsRect.getX();
        if (crossY < iconsRect.getY()) crossY = iconsRect.getY();
        if (crossX > iconsRect.getX()+iconsRect.getWidth()) crossX = (iconsRect.getX()+iconsRect.getWidth());
        if (crossY > iconsRect.getY()+iconsRect.getHeight()) crossY = (iconsRect.getY()+iconsRect.getHeight());
    }*/
}
//soon new changes
//absolutely fucking stupid byaka changes
//brand new changes
//omg, this are also new changes