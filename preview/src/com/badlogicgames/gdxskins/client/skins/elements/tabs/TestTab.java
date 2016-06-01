package com.badlogicgames.gdxskins.client.skins.elements.tabs;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogicgames.gdxskins.client.skins.info.SkinContainer;

/**
 * Created by Lyze on 01.06.2016.
 */
public class TestTab extends Tab {
    public TestTab(SkinContainer skinContainer) {
        super(skinContainer);

    }

    @Override
    public void initiate() {
        add(new Label("Test", skinContainer.skin));
    }

    @Override
    public String getName() {
        return "Test Tab";
    }
}
