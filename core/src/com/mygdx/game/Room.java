package com.mygdx.game;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

/**
 * Created by user on 06.08.2014.
 */
public class Room {

    ArrayList<ArrayList<Integer>> blocks;

    public Room(Pixmap map) {
        blocks = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < map.getWidth(); ++i) {
            blocks.add(new ArrayList<Integer>());
            for (int t=0; t<map.getHeight(); ++t) {
                blocks.get(i).add(new Integer(map.getPixel(i, t)));
            }
        }
    }

    public void draw(SpriteBatch batch, float zoom) {

    }

}
