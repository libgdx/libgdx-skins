package com.badlogicgames.gdxskins.client.skins.elements.tabs.rpg;

import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.utils.Array;

/**
 * Created by Lyze on 01.06.2016.
 */
public class FriendslistWindow extends Window {
    public FriendslistWindow(Skin skin) {
        super("Friendslist", skin);


        Array<String> namesArray = new Array<String>();
        for (int i = 0; i < 50; i++) {
            String name = " Banana_" + i;
            if (i % 3 == 0) {
                name = "[O] " + name;
            } else {
                name = "[X] " + name;
            }
            namesArray.add(name);
        }

        List<String> names = new List<String>(skin);
        names.setItems(namesArray);
        ScrollPane scroller = new ScrollPane(names, skin);

        add(scroller).height(500).width(200);

        pack();
        setKeepWithinStage(true);
    }
}
