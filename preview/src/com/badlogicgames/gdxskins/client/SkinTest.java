package com.badlogicgames.gdxskins.client;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.badlogicgames.gdxskins.client.skins.SkinChangerListener;
import com.badlogicgames.gdxskins.client.skins.SkinPreviewer;
import com.badlogicgames.gdxskins.client.skins.elements.tabs.PreviewGui;
import com.badlogicgames.gdxskins.client.skins.elements.tabs.rpg.RpgGuiTab;
import com.badlogicgames.gdxskins.client.skins.info.SkinContainer;
import com.badlogicgames.gdxskins.client.skins.info.SkinMeta;
import com.google.gwt.user.client.Window;

/**
 * @author Tom-Ski
 */
public class SkinTest extends ApplicationAdapter {

    public static Array<SkinContainer> skins = new Array<SkinContainer> ();
    private SkinPreviewer skinPreviewer;
    private Stage stage;

    @Override
    public void create() {
        Gdx.app.setLogLevel (Application.LOG_INFO);

        String masterListString = Gdx.files.internal ("masterlist").readString ();
        String[] masterSplit = masterListString.split ("\r\n");

        Json json = new Json ();
        for (int i = 0; i < masterSplit.length; i++) {
            String skinString = masterSplit[i];
            String skinjson = Gdx.files.internal (skinString + "/info.json").readString ();
            SkinMeta meta = json.fromJson (SkinMeta.class, skinjson);
            Skin skin = new Skin (Gdx.files.internal (skinString + "/assets/" + meta.filename));
            skins.add (new SkinContainer (meta, skin));
        }

        stage = new Stage ();

        String debug = Window.Location.getParameter ("debug");
        if (debug != null && debug.equalsIgnoreCase ("true")) {
            stage.setDebugAll (true);
        }
        Gdx.input.setInputProcessor (stage);

        SkinContainer initialSkin = skins.first ();

        SkinChangerListener changerListener = new SkinChangerListener ();
        skinPreviewer = new SkinPreviewer (initialSkin, changerListener);
        changerListener.setPreviewer (skinPreviewer);
        skinPreviewer.addTab (new RpgGuiTab (initialSkin));
        skinPreviewer.addTab (new PreviewGui (initialSkin));
        skinPreviewer.initiate ();

        stage.addActor (skinPreviewer);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor (0, 0, 0, 1f);
        Gdx.gl.glClear (GL20.GL_COLOR_BUFFER_BIT);

        stage.act ();
        stage.draw ();
    }

    @Override
    public void dispose() {
        stage.dispose ();
        for (SkinContainer skinContainer : skins) {
            skinContainer.dispose ();
        }
    }
}
