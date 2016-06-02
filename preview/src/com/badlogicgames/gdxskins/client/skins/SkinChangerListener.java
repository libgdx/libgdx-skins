package com.badlogicgames.gdxskins.client.skins;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogicgames.gdxskins.client.skins.info.SkinContainer;

/**
 * @author lyze237
 */
public class SkinChangerListener extends ChangeListener {

    private SkinPreviewer previewer;

    public void setPreviewer (SkinPreviewer previewer) {
        this.previewer = previewer;
    }

    @Override
    public void changed (ChangeEvent event, Actor actor) {
        SelectBox<SkinContainer> selectbox = (SelectBox<SkinContainer>) actor;
        previewer.changeSkin(selectbox.getSelected());
    }
}
