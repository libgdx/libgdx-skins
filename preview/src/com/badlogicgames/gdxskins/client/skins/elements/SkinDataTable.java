package com.badlogicgames.gdxskins.client.skins.elements;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogicgames.gdxskins.client.skins.info.SkinContainer;

/**
 * Created by Lyze on 01.06.2016.
 */
public class SkinDataTable extends Table {
    private SkinContainer skinContainer;

    public SkinDataTable(SkinContainer skinContainer) {
        super(skinContainer.skin);

        this.skinContainer = skinContainer;
        setDebug(true);
    }

    public void init() {
        Skin skin = skinContainer.skin;

        Table details = new Table();

        Label skinName = new Label(skinContainer.skinMeta.title, skin);
        Label skinDescription = new Label(skinContainer.skinMeta.description, skin);
        Label skinAuthor = new Label(skinContainer.skinMeta.author, skin);

        skinName.setColor(1f, 0, 0, 1f);
        skinDescription.setColor(1f, 0, 0, 1f);
        skinAuthor.setColor(1f, 0, 0, 1f);


        details.add(new Label("Name:", skin)).left();
        details.add(skinName).expandX();
        details.row();
        details.add(new Label("Description:", skin)).left();
        details.add(skinDescription).expandX();
        details.row();
        details.add(new Label("Author:", skin)).left();
        details.add(skinAuthor).expandX();
        details.row();

        add(details).fill().expand();
        setPosition(5, Gdx.graphics.getHeight() - 250);

        row();

        Label skinSelectLabel = new Label("Select Skin", skin);
        skinSelectLabel.setColor(1f, 0, 0, 1f);

        add(skinSelectLabel).left().padTop(50);
        row().padBottom(10);

        /*
        final SelectBox<SkinContainer> skinSelect = new SelectBox<SkinContainer>(skin);
        skinSelect.setItems(skins);
        skinSelect.setSelected(skinContainer);
        skinSelect.setWidth(200);
        skinSelect.addListener(new ChangeListener() {
            @Override
            public void changed (ChangeEvent event, Actor actor) {
                skinContainer = skinSelect.getSelected();
                createUI();
            }
        });
        skinDataWindow.add(skinSelect).left();
        */

        setWidth(350);
    }
}
