package com.badlogicgames.gdxskins.client.skins.elements.tabs.rpg;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;

/**
 * @author lyze237
 */
public class InventoryWindow extends Window {
    public InventoryWindow (Skin skin) {
        super("Inventory", skin);

        defaults().pad(3);
        if(skin.has("default", TextButton.TextButtonStyle.class)) {
            for (int y = 0; y < 5; y++) {
                for (int x = 0; x < 10; x++) {
                    TextButton tb = new TextButton(y + "_" + x, skin);
                    add(tb).width(40).height(40);
                }
                row();
            }
        }
        else{
            Label noDefaultTextButtonStyle = new Label("Skin has no TextButtonStyle",skin);
            add(noDefaultTextButtonStyle).width(400).height(200);
        }

        pack();
        setKeepWithinStage(true);
    }
}
