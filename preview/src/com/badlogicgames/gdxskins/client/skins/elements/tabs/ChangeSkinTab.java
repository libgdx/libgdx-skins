package com.badlogicgames.gdxskins.client.skins.elements.tabs;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogicgames.gdxskins.client.SkinTest;
import com.badlogicgames.gdxskins.client.skins.SkinChangerListener;
import com.badlogicgames.gdxskins.client.skins.info.SkinContainer;

/**
 * Created by Lyze on 01.06.2016.
 */
public class ChangeSkinTab extends Tab {
    private SkinChangerListener skinChangerListener;

    public ChangeSkinTab(SkinContainer skinContainer, SkinChangerListener skinChangerListener) {
        super(skinContainer);
        this.skinChangerListener = skinChangerListener;

        initiate();
    }

    @Override
    public void initiate() {
        Label skinName = new Label(skinContainer.skinMeta.title, skinContainer.skin);
        Label skinDescription = new Label(skinContainer.skinMeta.description, skinContainer.skin);
        Label skinAuthor = new Label(skinContainer.skinMeta.author, skinContainer.skin);

        skinName.setColor(1f, 0, 0, 1f);
        skinDescription.setColor(1f, 0, 0, 1f);
        skinAuthor.setColor(1f, 0, 0, 1f);


        add(new Label("Name:", skinContainer.skin)).left();
        add(skinName);
        row();
        add(new Label("Description:", skinContainer.skin)).left();
        add(skinDescription);
        row();
        add(new Label("Author:", skinContainer.skin)).left();
        add(skinAuthor);
        row();

        Label skinSelectLabel = new Label("Select Skin", skinContainer.skin);
        skinSelectLabel.setColor(1f, 0, 0, 1f);

        add(skinSelectLabel).left();

        SelectBox<SkinContainer> skinSelect = new SelectBox<SkinContainer>(skinContainer.skin);
        skinSelect.setItems(SkinTest.skins);
        skinSelect.setSelected(skinContainer);
        skinSelect.addListener(skinChangerListener);
        add(skinSelect);
    }

    @Override
    public String getName() {
        return "Change Skin";
    }
}
