package com.badlogicgames.gdxskins.client.skins.info;

import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogicgames.gdxskins.client.skins.elements.SkinDataTable;

/**
 * Created by Lyze on 01.06.2016.
 */
public class SkinElementPreview extends Table {

    private SkinContainer skinContainer;

    public SkinElementPreview(SkinContainer skinContainer) {
        this.skinContainer = skinContainer;

        setDebug(true);
        setFillParent(true);
    }

    public void createUI() {
        Skin skin = skinContainer.skin;

        SkinDataTable skinDataTable = new SkinDataTable(skinContainer);
        skinDataTable.init();
        add(skinDataTable);

        /*
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

        textWindow.setPosition(400, Gdx.graphics.getHeight() - 310);
        add(textWindow);

        Window buttonWindow = new Window("Button Widgets", skin);
        buttonWindow.defaults().pad(5);
        TextButton imATextButton = new TextButton("Im a TextButton", skin);
        TextButton imATextButtonDisabled = new TextButton("Im a TextButton disabled", skin);
        imATextButtonDisabled.setDisabled(true);

        CheckBox checkBox = new CheckBox("Im a CheckBox", skin);
        CheckBox checkBoxDisabled = new CheckBox("Im a CheckBox disabled", skin);
        checkBoxDisabled.setDisabled(true);

        buttonWindow.add(imATextButton).left();
        buttonWindow.row();
        buttonWindow.add(imATextButtonDisabled).left();
        buttonWindow.row();
        buttonWindow.add(checkBox).left();
        buttonWindow.row();
        buttonWindow.add(checkBoxDisabled).left();
        buttonWindow.row();

        buttonWindow.setSize(300, 300);
        buttonWindow.setPosition(710, Gdx.graphics.getHeight() - 310);
        add(buttonWindow);

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
                setValue(track/10f * 100f);
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

        sliderWindow.setSize(200, 200);
        sliderWindow.setPosition(1050, Gdx.graphics.getHeight() - 250);
        add(sliderWindow);


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
        ScrollPane scrollPane = new ScrollPane(list2, skin);
        listInSrollPaneWindow.add(scrollPane).fill().expand();

        Window listInSplitPaneWindow = new Window("SplitPaned List", skin);
        List<String> list3 = new List<String>(skin);
        list3.setItems(stringArray);
        List<String> list4 = new List<String>(skin);
        list4.setItems(stringArray);
        SplitPane splitPane = new SplitPane(list3, list4, true, skin);
        listInSplitPaneWindow.add(splitPane).fill().expand();

        listWindow.setPosition(0, 0);
        listInSrollPaneWindow.setPosition(200, 0);
        listInSplitPaneWindow.setPosition(400, 0);

        listWindow.setHeight(300);
        listInSrollPaneWindow.setHeight(300);
        listInSplitPaneWindow.setHeight(300);

        add(listWindow);
        add(listInSrollPaneWindow);
        add(listInSplitPaneWindow);

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
        treeWindow.setSize(200, 300);
        treeWindow.setPosition(600, 0);

        add(treeWindow);

        Window touchpadWindow = new Window("Touchpad Window", skin);
        Touchpad touchpad = new Touchpad(5f, skin);
        touchpadWindow.setSize(300, 300);
        touchpadWindow.setPosition(830, 0);
        touchpadWindow.add(touchpad).fill().expand();
        add(touchpadWindow);
        */
    }
}
