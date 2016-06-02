package com.badlogicgames.gdxskins.client.skins;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Array;
import com.badlogicgames.gdxskins.client.skins.elements.tabs.ChangeSkinTab;
import com.badlogicgames.gdxskins.client.skins.elements.tabs.Tab;
import com.badlogicgames.gdxskins.client.skins.info.SkinContainer;

/**
 * @author lyze237
 */
public class SkinPreviewer extends Table {

    private SkinContainer skinContainer;
    private Array<Tab> tabsArray;
    private List<Tab> tabs;

    private ChangeSkinTab changeSkinTab;

    private ScrollPane scroller;

    public SkinPreviewer(SkinContainer skinContainer, SkinChangerListener skinChangerListener) {
        this.skinContainer = skinContainer;

        setFillParent (true);

        tabsArray = new Array<Tab> ();
        tabs = new List<Tab> (skinContainer.skin);
        tabs.setItems (tabsArray);
        tabs.addListener (new ChangeListener () {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                changeTab (tabs.getSelected ());
            }
        });

        scroller = new ScrollPane (tabs);

        changeSkinTab = new ChangeSkinTab (skinContainer, skinChangerListener);
    }

    public void initiate() {
        tabs.setSelectedIndex (0);
        changeTab (tabs.getSelected ());
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw (batch, parentAlpha);
    }

    @Override
    public void act(float delta) {
        super.act (delta);
    }

    public void addTab(Tab tab) {
        tabsArray.add (tab);
        tabs.setItems (tabsArray);
    }

    public void changeTab(Tab tab) {
        clearChildren ();

        Table table = new Table ();

        Window descriptionWindow = new Window ("Description", skinContainer.skin);
        descriptionWindow.add (changeSkinTab);
        descriptionWindow.setMovable (false);
        descriptionWindow.setHeight (changeSkinTab.getHeight () + 10);

        table.add (descriptionWindow).fillX ();

        table.row ();


        Window scrollerWindow = new Window ("Previews", skinContainer.skin);
        scrollerWindow.setMovable (false);
        scrollerWindow.add (scroller).expand ().fill ();

        table.add (scrollerWindow).fill ().expand ();

        add (table).width (250).fill ();
        add (tab).expand ().fill ();
    }

    public void changeSkin(SkinContainer selected) {
        for (Tab tab : tabsArray) {
            tab.changeSkin (selected);
        }
    }
}
