package com.badlogicgames.gdxskins.client.skins.elements.tabs;

import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogicgames.gdxskins.client.skins.info.SkinContainer;

/**
 * Created by Lyze on 01.06.2016.
 */
public abstract class Tab extends Table {
    protected SkinContainer skinContainer;

    public Tab(SkinContainer skinContainer) {
        super(skinContainer.skin);

        this.skinContainer = skinContainer;
    }

    public abstract String getName();

    @Override
    public String toString() {
        return getName();
    }
}
