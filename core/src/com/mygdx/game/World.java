package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

/**
 * Created by user on 06.08.2014.
 */
public class World {

    ArrayList<ArrayList<Room>> rooms;
    String folderPath;
    ArrayList<Pixmap> maps;
    boolean initialised = false;
    FileHandle worldDir;
    int curRoomX = 0, curRoomY = 0;
    ArrayList<Integer> crds;

    public World(String folderPath, ArrayList<Integer> crds) {
        rooms = new ArrayList<ArrayList<Room>>();
        for (int i=0; i<64; ++i) {
            rooms.add(new ArrayList<Room>());
        }
        this.folderPath = folderPath;
        maps = new ArrayList<Pixmap>();
        this.crds = crds;
    }

    public void load(AssetManager assets) {
        worldDir = Gdx.files.internal(folderPath);
        for (FileHandle entry: worldDir.list()) {
            assets.load(entry.path(), Pixmap.class);
        }
    }

    public void initialise(AssetManager assets) {
        for (FileHandle entry: worldDir.list()) {
            maps.add(assets.get(entry.path(), Pixmap.class));
        }
        for (int i=0; i<maps.size(); ++i) {
            rooms.get(crds.get(i)).add(crds.get(i+1), new Room(maps.get(i)));
        }
        initialised = true;
    }

    public void draw(SpriteBatch batch, float zoom) {
        rooms.get(curRoomX).get(curRoomY).draw(batch, zoom);
    }

}
