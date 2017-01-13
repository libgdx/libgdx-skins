package com.badlogicgames.gdxskins.client.skins.elements.tabs.rpg;

import com.badlogic.gdx.scenes.scene2d.ui.*;

/**
 * @author lyze237
 */
public class SpellWindow extends Window {
    public SpellWindow (Skin skin) {
        super("Spells", skin);

        defaults().pad(2);
        if(skin.has("default", TextButton.TextButtonStyle.class)) {
            for (int i = 0; i < 10; i++) {
                Button spell = new TextButton("S" + i, skin);
                spell.addListener(new TextTooltip("This is a tooltip!\nThis spell is really important!\nSerious stats about this spell!\nThis is a tooltip!", skin));
                add(spell).width(52).height(52);
            }
        }
        else{
            Label noDefaultTextButtonStyle = new Label("no default TextButtonStyle in skin",skin);
            add(noDefaultTextButtonStyle).width(520).height(52);
        }

        pack();
        setKeepWithinStage(true);
        setMovable(false);
    }
}
