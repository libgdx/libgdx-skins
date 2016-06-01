package com.badlogicgames.gdxskins.client.skins.elements.tabs.rpg;

import com.badlogic.gdx.scenes.scene2d.ui.*;

/**
 * Created by Lyze on 01.06.2016.
 */
public class SpellWindow extends Window {
    public SpellWindow(Skin skin) {
        super("Spells", skin);

        defaults().pad(2);

        for (int i = 0; i < 10; i++) {
            Button spell = new TextButton("S" + i, skin);
            spell.addListener(new TextTooltip("This is a tooltip!\nThis spell is really important!\nSerious stats about this spell!\nThis is a tooltip!", skin));
            add(spell).width(52).height(52);
        }

        pack();
        setKeepWithinStage(true);
        setMovable(false);
    }
}
