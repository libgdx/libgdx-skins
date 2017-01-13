package com.badlogicgames.gdxskins.client.skins.elements.tabs;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.SplitPane;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.TextTooltip;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;
import com.badlogic.gdx.scenes.scene2d.ui.Tree;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.utils.Array;
import com.badlogicgames.gdxskins.client.skins.info.SkinContainer;

/**
 * @author Tom-Ski
 */
public class PreviewGui extends Tab {
    public PreviewGui (SkinContainer skinContainer) {
        super(skinContainer);

        initiate();
    }

    @Override
    public void initiate () {
        Skin skin = skinContainer.skin;

        Window textWindow = new Window("Text Widgets", skin);
        Label imALabel = new Label("Im a label", skin);
        Label imALabelWithTooltip = new Label("Im a label with tooltip", skin);

        imALabelWithTooltip.addListener(new TextTooltip("This is a tooltip! This is a tooltip! This is a tooltip! This is a tooltip! This is a tooltip! This is a tooltip!", skin));

        TextField imATextField = new TextField("Im a TextField, edit me!", skin);
        TextField imATextFieldDisabled = new TextField("Im a TextField disabled", skin);
        imATextFieldDisabled.setDisabled(true);

        TextArea imATextArea = new TextArea("Im a TextArea, plz dont click me\r\nI will probably crash\r\nturtles everywhere", skin);

        textWindow.defaults().pad(5);

        textWindow.add(imALabel);
        textWindow.row();
        textWindow.add(imALabelWithTooltip);
        textWindow.row();
        textWindow.add(imATextField).fillX().expandX();
        textWindow.row();
        textWindow.add(imATextFieldDisabled).fillX().expandX();
        textWindow.row();
        textWindow.add(imATextArea).expand().fill();

        textWindow.setSize(300, 300);

        textWindow.setPosition(10, Gdx.graphics.getHeight() - 310);
        addActor(textWindow);

        Window buttonWindow = new Window("Button Widgets", skin);
        buttonWindow.defaults().pad(5);
        if(skin.has("default", TextButton.TextButtonStyle.class)) {
            TextButton imATextButton = new TextButton("Im a TextButton", skin);
            TextButton imATextButtonDisabled = new TextButton("Im a TextButton disabled", skin);
            imATextButtonDisabled.setDisabled(true);
            buttonWindow.add(imATextButton).left();
            buttonWindow.row();
            buttonWindow.add(imATextButtonDisabled).left();
            buttonWindow.row();
        }
        else{
            Label noDefaultTextButtonStyle = new Label("no default TextButtonStyle in skin",skin);
            buttonWindow.add(noDefaultTextButtonStyle).left();
            buttonWindow.row();
        }
        if(skin.has("default", CheckBox.CheckBoxStyle.class)) {
            CheckBox checkBox = new CheckBox("Im a CheckBox", skin);
            CheckBox checkBoxDisabled = new CheckBox("Im a CheckBox disabled", skin);
            checkBoxDisabled.setDisabled(true);

            buttonWindow.add(checkBox).left();
            buttonWindow.row();
            buttonWindow.add(checkBoxDisabled).left();
            buttonWindow.row();
        }

        buttonWindow.setSize(300, 300);
        buttonWindow.setPosition(320, Gdx.graphics.getHeight() - 310);
        addActor(buttonWindow);
        if(skin.has("default", Slider.SliderStyle.class)) {
            Window sliderWindow = new Window("Slider", skin);
            sliderWindow.defaults().pad(5);
            Slider slider = new Slider(0, 100, 0.1f, false, skin);
            ProgressBar progressBar = new ProgressBar(0, 100f, 0.1f, false, skin) {
                float track;

                @Override
                public void act (float delta) {
                    super.act(delta);
                    track += delta;
                    track %= 10f;
                    setValue(track / 10f * 100f);
                }
            };
            progressBar.setAnimateInterpolation(Interpolation.fade);
            progressBar.setVisualInterpolation(Interpolation.fade);

            Label sliderlabel = new Label("Slider", skin);
            Label prgoressbarlabel = new Label("ProgressBar", skin);

            sliderWindow.add(sliderlabel).left();
            sliderWindow.row();
            sliderWindow.add(slider);
            sliderWindow.row();
            sliderWindow.add(prgoressbarlabel).left();
            sliderWindow.row();
            sliderWindow.add(progressBar);

            sliderWindow.setSize(180, 200);
            sliderWindow.setPosition(630, Gdx.graphics.getHeight() - 250);
            addActor(sliderWindow);
        }


        if(skin.has("default", Tree.TreeStyle.class)) {
            Tree tree = new Tree(skin);
            Tree.Node node = new Tree.Node(new Label("Tree element 1", skin));
            node.add(new Tree.Node(new Label("Tree element 2", skin)));
            node.add(new Tree.Node(new Label("Tree element 3", skin)));
            Tree.Node node2 = new Tree.Node(new Label("Tree element 4", skin));
            node2.add(new Tree.Node(new Label("Tree element 5", skin)));
            node2.add(new Tree.Node(new Label("Tree element 6", skin)));

            node.add(node2);
            node.add(new Tree.Node(new Label("Tree element 7", skin)));
            tree.add(node);

            Window treeWindow = new Window("Tree window", skin);
            treeWindow.add(tree).fill().expand();
            treeWindow.setSize(180, 300);
            treeWindow.setPosition(830, Gdx.graphics.getHeight() - 310);

            addActor(treeWindow);
        }

        Window listWindow = new Window("List Window", skin);
        List<String> list = new List<String>(skin);
        Array<String> stringArray = new Array<String>();
        for (int i = 0; i < 50; i++) {
            stringArray.add("Banana");
        }
        list.setItems(stringArray);
        listWindow.add(list).left().expand().fill();

        Window listInSrollPaneWindow = new Window("ScrollPaned List", skin);
        List<String> list2 = new List<String>(skin);
        list2.setItems(stringArray);
        if(skin.has("default", ScrollPane.ScrollPaneStyle.class)) {
            ScrollPane scrollPane = new ScrollPane(list2, skin);
            listInSrollPaneWindow.add(scrollPane).fill().expand();
        }

        Window listInSplitPaneWindow = new Window("SplitPaned List", skin);
        List<String> list3 = new List<String>(skin);
        list3.setItems(stringArray);
        List<String> list4 = new List<String>(skin);
        list4.setItems(stringArray);
        if(skin.has("default", SplitPane.SplitPaneStyle.class)) {
            SplitPane splitPane = new SplitPane(list3, list4, true, skin);
            listInSplitPaneWindow.add(splitPane).fill().expand();
        }
        listWindow.setPosition(10, 10);
        listInSrollPaneWindow.setPosition(200, 10);
        listInSplitPaneWindow.setPosition(400, 10);

        listWindow.setHeight(300);
        listInSrollPaneWindow.setHeight(300);
        listInSplitPaneWindow.setHeight(300);

        addActor(listWindow);
        addActor(listInSrollPaneWindow);
        addActor(listInSplitPaneWindow);


        Window touchpadWindow = new Window("Touchpad Window", skin);
        touchpadWindow.setSize(300, 300);
        touchpadWindow.setPosition(600, 10);
        Actor touchpad;
        if(skin.has("default", Touchpad.TouchpadStyle.class)) {
            touchpad = new Touchpad(5f, skin);
        }
        else{
            touchpad = new Label("no Default Style for Touchpad Element",skin);

        }
        touchpadWindow.add(touchpad).fill().expand();
        addActor(touchpadWindow);
    }

    @Override
    public String getName () {
        return "Preview Gui";
    }
}
