package com.badlogicgames.gdxskins.client;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.SplitPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.TextTooltip;
import com.badlogic.gdx.scenes.scene2d.ui.Tooltip;
import com.badlogic.gdx.scenes.scene2d.ui.TooltipManager;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;
import com.badlogic.gdx.scenes.scene2d.ui.Tree;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import javafx.scene.input.TouchPoint;

public class SkinTest extends ApplicationAdapter {

	Array<SkinContainer> skins = new Array<SkinContainer>();
	Stage stage;

	@Override
	public void create () {
		Gdx.app.setLogLevel(Application.LOG_INFO);

		String masterListString = Gdx.files.internal("masterlist").readString();
		String[] masterSplit = masterListString.split("\r\n");

		Json json = new Json();
		for (int i = 0; i < masterSplit.length; i++) {
			String skinString = masterSplit[i];
			String skinjson = Gdx.files.internal(skinString + "/info.json").readString();
			SkinMeta meta = json.fromJson(SkinMeta.class, skinjson);
			Skin skin = new Skin(Gdx.files.internal(skinString + "/assets/" + meta.filename));
			skins.add(new SkinContainer(meta, skin));
		}

		stage = new Stage();
		Gdx.input.setInputProcessor(stage);

		createTestUI(skins.first());
	}

	private void createTestUI (SkinContainer skinContainer) {
		stage.clear();

		Skin skin = skinContainer.skin;

		Table details = new Table();

		Label skinName = new Label(skinContainer.skinMeta.title, skin);
		Label skinDescription = new Label(skinContainer.skinMeta.description, skin);
		Label skinAuthor = new Label(skinContainer.skinMeta.author, skin);

		skinName.setColor(1f, 0, 0, 1f);
		skinDescription.setColor(1f, 0, 0, 1f);
		skinAuthor.setColor(1f, 0, 0, 1f);


		details.add(new Label("Name:", skin)).left();
		details.add(skinName).expandX();
		details.row();
		details.add(new Label("Description:", skin)).left();
		details.add(skinDescription).expandX();
		details.row();
		details.add(new Label("Author:", skin)).left();
		details.add(skinAuthor).expandX();
		details.row();


		Window skinDataWindow = new Window("Skin Details", skin);
		skinDataWindow.add(details).fill().expand();
		skinDataWindow.setPosition(5, Gdx.graphics.getHeight() - 250);

		skinDataWindow.row();

		Label skinSelectLabel = new Label("Select Skin", skin);
		skinSelectLabel.setColor(1f, 0, 0, 1f);

		skinDataWindow.add(skinSelectLabel).left().padTop(50);
		skinDataWindow.row().padBottom(10);

		final SelectBox<SkinContainer> skinSelect = new SelectBox<SkinContainer>(skin);
		skinSelect.setItems(skins);
		skinSelect.setSelected(skinContainer);
		skinSelect.setWidth(200);
		skinSelect.addListener(new ChangeListener() {
			@Override
			public void changed (ChangeEvent event, Actor actor) {
				createTestUI(skinSelect.getSelected());
			}
		});
		skinDataWindow.add(skinSelect).left();

		skinDataWindow.pack();
		skinDataWindow.setWidth(350);
		stage.addActor(skinDataWindow);

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
		stage.addActor(textWindow);

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
		stage.addActor(buttonWindow);

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
		stage.addActor(sliderWindow);


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

		stage.addActor(listWindow);
		stage.addActor(listInSrollPaneWindow);
		stage.addActor(listInSplitPaneWindow);

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

		stage.addActor(treeWindow);

		Window touchpadWindow = new Window("Touchpad Window", skin);
		Touchpad touchpad = new Touchpad(5f, skin);
		touchpadWindow.setSize(300, 300);
		touchpadWindow.setPosition(830, 0);
		touchpadWindow.add(touchpad).fill().expand();
		stage.addActor(touchpadWindow);

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		stage.act();
		stage.draw();
	}

	@Override
	public void dispose () {
		stage.dispose();
		for (SkinContainer skinContainer : skins) {
			skinContainer.dispose();
		}
	}

	class SkinContainer {

		SkinMeta skinMeta;
		Skin skin;

		public SkinContainer (SkinMeta meta, Skin skin) {
			this.skinMeta = meta;
			this.skin = skin;
		}

		void dispose () {
			skin.dispose();
		}

		@Override
		public String toString () {
			return skinMeta.title;
		}
	}


}
