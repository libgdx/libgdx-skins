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
        Table details = new Table();

        Label skinName = new Label(skinContainer.skinMeta.title, skinContainer.skin);
        Label skinDescription = new Label(skinContainer.skinMeta.description, skinContainer.skin);
        Label skinAuthor = new Label(skinContainer.skinMeta.author, skinContainer.skin);

        skinName.setColor(1f, 0, 0, 1f);
        skinDescription.setColor(1f, 0, 0, 1f);
        skinAuthor.setColor(1f, 0, 0, 1f);


        details.add(new Label("Name:", skinContainer.skin)).left();
        details.add(skinName).expandX();
        details.row();
        details.add(new Label("Description:", skinContainer.skin)).left();
        details.add(skinDescription).expandX();
        details.row();
        details.add(new Label("Author:", skinContainer.skin)).left();
        details.add(skinAuthor).expandX();
        details.row();

        add(details);

        row();

        Label skinSelectLabel = new Label("Select Skin", skinContainer.skin);
        skinSelectLabel.setColor(1f, 0, 0, 1f);

        add(skinSelectLabel).left().padTop(50);

        SelectBox<SkinContainer> skinSelect = new SelectBox<SkinContainer>(skinContainer.skin);
        skinSelect.setItems(SkinTest.skins);
        skinSelect.setSelected(skinContainer);
        skinSelect.setWidth(200);
        skinSelect.addListener(skinChangerListener);
        add(skinSelect);
    }

    @Override
    public String getName() {
        return "Change Skin";
    }
}
