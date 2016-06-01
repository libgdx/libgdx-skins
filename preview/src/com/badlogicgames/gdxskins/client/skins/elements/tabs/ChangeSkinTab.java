package com.badlogicgames.gdxskins.client.skins.elements.tabs;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogicgames.gdxskins.client.skins.info.SkinContainer;

/**
 * Created by Lyze on 01.06.2016.
 */
public class ChangeSkinTab extends Tab {
    public ChangeSkinTab(SkinContainer skinContainer) {
        super(skinContainer);

        add(new Label("Hi", skinContainer.skin));
    }

    @Override
    public String getName() {
        return "Change Skin";
    }
}
