package com.badlogicgames.gdxskins.client.skins.info;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;

/**
 * @author lyze237
 */
public class SkinContainer {
    public SkinMeta skinMeta;
    public Skin skin;

    public SkinContainer (SkinMeta meta, Skin skin) {
        this.skinMeta = meta;
        this.skin = skin;
    }

    public void dispose () {
        skin.dispose();
    }

    @Override
    public String toString () {
        return skinMeta.title;
    }
}
