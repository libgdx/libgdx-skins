package com.badlogicgames.gdxskins.client.skins.elements.tabs.rpg;

import com.badlogic.gdx.scenes.scene2d.ui.*;

/**
 * Created by Lyze on 01.06.2016.
 */
public class NotificationWindow extends Window {
    public NotificationWindow(Skin skin) {
        super ("Notifications", skin);

        defaults ().pad (2);

        for (int i = 0; i < 4; i++) {
            Button notification = new TextButton ("N" + i, skin);
            notification.addListener (new TextTooltip ("This is a tooltip!\nThis notification is really important!\nSeriously, read it!", skin));
            add (notification).width (32).height (32);
        }

        pack ();
        setKeepWithinStage (true);
        setMovable (false);
    }
}
