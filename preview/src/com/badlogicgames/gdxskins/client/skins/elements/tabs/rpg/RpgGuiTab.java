package com.badlogicgames.gdxskins.client.skins.elements.tabs.rpg;

import com.badlogic.gdx.Gdx;
import com.badlogicgames.gdxskins.client.skins.elements.tabs.Tab;
import com.badlogicgames.gdxskins.client.skins.info.SkinContainer;

/**
 * @author lyze237
 */
public class RpgGuiTab extends Tab {
    public RpgGuiTab (SkinContainer skinContainer) {
        super(skinContainer);

        initiate();
    }

    @Override
    public void initiate () {
        SpellWindow spellWindow = new SpellWindow(skinContainer.skin);
        spellWindow.setPosition((Gdx.graphics.getWidth() - 250) / 2 - spellWindow.getWidth() + 250, 10);
        addActor(spellWindow);

        NotificationWindow notificationWindow = new NotificationWindow(skinContainer.skin);
        notificationWindow.setPosition(10, Gdx.graphics.getHeight() - notificationWindow.getHeight() - 10);
        addActor(notificationWindow);

        InventoryWindow inventory = new InventoryWindow(skinContainer.skin);
        inventory.setPosition(200, 200);
        addActor(inventory);

        AvatarWindow avatarWindow = new AvatarWindow(skinContainer.skin);
        avatarWindow.setPosition(10, Gdx.graphics.getHeight() - notificationWindow.getHeight() - 30 - avatarWindow.getHeight());
        addActor(avatarWindow);

        FriendslistWindow friendslistWindow = new FriendslistWindow(skinContainer.skin);
        friendslistWindow.setPosition((Gdx.graphics.getWidth() - 250) - friendslistWindow.getWidth() - 10, 150);
        addActor(friendslistWindow);
    }

    @Override
    public String getName () {
        return "Rpg Gui";
    }
}
