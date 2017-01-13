package com.badlogicgames.gdxskins.client.skins.elements.tabs.rpg;

import com.badlogic.gdx.scenes.scene2d.ui.*;


/**
 * @author lyze237
 */
public class AvatarWindow extends Window {
    public AvatarWindow (Skin skin) {
        super("<Name>", skin);

        defaults().pad(2);

        if(skin.has("default", TextButton.TextButtonStyle.class)) {
            add(new TextButton("Avatar", skin)).width(64).height(64);
        }
        else{
            add(new Label("no default skin for TextButton", skin)).width(64).height(64);
        }

        Table status = new Table(skin);

        status.add(new Label("Health", skin));
        if(skin.has("default", ProgressBar.ProgressBarStyle.class)) {
            ProgressBar health = new ProgressBar(0, 100, 1, false, skin);
            health.setValue(75);
            status.add(health).width(100);
        }
        else{
            add(new Label("no default skin for ProgressBar", skin)).width(100).height(64);
        }
        status.row();

        status.add(new Label("Mana", skin));
        if(skin.has("default", ProgressBar.ProgressBarStyle.class)) {
            ProgressBar mana = new ProgressBar(0, 100, 1, false, skin);
            mana.setValue(24);
            status.add(mana).width(100);
        }
        else{
            add(new Label("no default skin for ProgressBar", skin)).width(100).height(64);
        }
        add(status);

        pack();
        setKeepWithinStage(true);
    }
}
