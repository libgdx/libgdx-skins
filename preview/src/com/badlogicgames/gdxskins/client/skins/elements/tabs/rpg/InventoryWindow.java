package com.badlogicgames.gdxskins.client.skins.elements.tabs.rpg;

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

        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 10; x++) {
                add(new TextButton(y + "_" + x, skin)).width(40).height(40);
            }
            row();
        }

        pack();
        setKeepWithinStage(true);
    }
}
