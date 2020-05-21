

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import javax.sound.midi.Instrument;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;
//import JavaFXEventsLecture2.animationEtc.MultipleBounceBall.Ball;
import javafx.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.geometry.Insets;
import javafx.scene.Camera;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/*
 * TODO:
 * add some things to listen for all keys
 * then tell you what interval/chord is played
 * 
 * also, do some visualizations
 * then redesign some stuff
 * and add shift that adds preview octave up.
 * then add scale stacks, queues, etc.
 */


public class Javatron extends Application {
	ArrayList<Note> activeNotes = new ArrayList<>();
	int octave = 0;
	int octaveDrawOffset = 0;
	int noteHeight = 5;
	int noteWidth = 40;
	int indexMultiplier = 20;
	int notePrintingOffset = 26;
	int notePrintingOffset2 = 4;
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	public void start(Stage primaryStage) {
		Synthesizer midiSynth = null;
		try {
			midiSynth = MidiSystem.getSynthesizer();
		} catch (MidiUnavailableException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
        try {
			midiSynth.open();
		} catch (MidiUnavailableException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Instrument[] instr = midiSynth.getDefaultSoundbank().getInstruments();
        midiSynth.loadInstrument(instr[0]);
        System.out.println(instr[0].getName());
        MidiChannel[] mChannels = midiSynth.getChannels();
		
        
        
        GridPane g = new GridPane();
        GridPane g2 = new GridPane();
        GridPane g3 = new GridPane();
        
		String[] notes = new String[]{"C", "D", "E", "F", "G", "A", "B"};
		HashMap<String, Integer> keySet = new HashMap<String, Integer>();
		int k = 0;
		for (String s : notes) {
			keySet.put(s, k);
			k++;
		}
		
	
        
        
        Button cKey = new Button("C");
		cKey.setOnMousePressed(e -> {
			 mChannels[0].noteOn(60 + 12*octave, 100);
		});
		
		cKey.setOnMouseReleased(e -> {
			mChannels[0].noteOff(60+ 12*octave, 100);
		});
		Button cSharpKey = new Button("C#");
		cSharpKey.setOnMousePressed(e -> {
			 mChannels[0].noteOn(61+ 12*octave, 100);
		});
		
		cSharpKey.setOnMouseReleased(e -> {
			mChannels[0].noteOff(61+ 12*octave, 100);
		});
		Button dKey = new Button("D");
		dKey.setOnMousePressed(e -> {
			 mChannels[0].noteOn(62 +12*octave, 100);
		});
		dKey.setOnMouseReleased(e -> {
			mChannels[0].noteOff(62 + 12*octave,100);
		});
		Button dSharpKey = new Button("D#");
		dSharpKey.setOnMousePressed(e -> {
			 mChannels[0].noteOn(63 + 12*octave, 100);
		});
		dSharpKey.setOnMouseReleased(e -> {
			mChannels[0].noteOff(63 + 12*octave, 100);
		});
		Button eKey = new Button("E");
		eKey.setOnMousePressed(f -> {
			mChannels[0].noteOn(64 + 12*octave, 100);
		});
		eKey.setOnMouseReleased(f -> {
			mChannels[0].noteOff(64 + 12*octave,100);
		});
		Button fKey = new Button("F");
		fKey.setOnMousePressed(h -> {
			 mChannels[0].noteOn(65 + 12*octave, 100);
		});
		fKey.setOnMouseReleased(h -> {
			mChannels[0].noteOff(65 + 12*octave,100);
		});
		Button fSharpKey = new Button("F#");
		fSharpKey.setOnMousePressed(e -> {
			 mChannels[0].noteOn(66 + 12*octave, 100);
		});
		fSharpKey.setOnMouseReleased(e -> {
			mChannels[0].noteOff(66 + 12*octave, 100);
		});
		Button gKey = new Button("G");
		gKey.setOnMousePressed(i -> {
			mChannels[0].noteOn(67 + 12*octave, 100);
		});
		gKey.setOnMouseReleased(i -> {
			mChannels[0].noteOff(67 + 12*octave, 100);
		});
		Button gSharpKey = new Button("G#");
		gSharpKey.setOnMousePressed(i -> {
			mChannels[0].noteOn(68 + 12*octave, 100);
		});
		gSharpKey.setOnMouseReleased(i -> {
			mChannels[0].noteOff(68 + 12*octave, 100);
		});
		Button aKey = new Button("A");
		aKey.setOnMousePressed(i -> {
			mChannels[0].noteOn(69 + 12*octave, 100);
		});
		aKey.setOnMouseReleased(i -> {
			mChannels[0].noteOff(69 + 12*octave, 100);
		});
        Button aSharpKey = new Button("A#");
        aSharpKey.setOnMousePressed(i -> {
			mChannels[0].noteOn(70 + 12*octave, 100);
		});
		aSharpKey.setOnMouseReleased(i -> {
			mChannels[0].noteOff(70 + 12*octave, 100);
		});
		Button bKey = new Button("B");
		bKey.setOnMousePressed(i -> {
			mChannels[0].noteOn(71 + 12*octave, 100);
		});
		bKey.setOnMouseReleased(i -> {
			mChannels[0].noteOff(71 + 12*octave, 100);
		});
		Button cKey2 = new Button("C");
		cKey2.setOnMousePressed(e -> {
			 mChannels[0].noteOn(60 + 12*octave, 100);
		});
		
		cKey2.setOnMouseReleased(e -> {
			mChannels[0].noteOff(60+ 12*octave, 100);
		});
		Button cSharpKey2 = new Button("C#");
		cSharpKey2.setOnMousePressed(e -> {
			 mChannels[0].noteOn(61+ 12*octave, 100);
		});
		
		cSharpKey2.setOnMouseReleased(e -> {
			mChannels[0].noteOff(61+ 12*octave, 100);
		});
		Button dKey2 = new Button("D");
		dKey2.setOnMousePressed(e -> {
			 mChannels[0].noteOn(62 +12*octave, 100);
		});
		dKey2.setOnMouseReleased(e -> {
			mChannels[0].noteOff(62 + 12*octave,100);
		});
		Button dSharpKey2 = new Button("D#");
		dSharpKey2.setOnMousePressed(e -> {
			 mChannels[0].noteOn(63 + 12*octave, 100);
		});
		dSharpKey2.setOnMouseReleased(e -> {
			mChannels[0].noteOff(63 + 12*octave, 100);
		});
		Button eKey2 = new Button("E");
		eKey2.setOnMousePressed(f -> {
			mChannels[0].noteOn(64 + 12*octave, 100);
		});
		eKey2.setOnMouseReleased(f -> {
			mChannels[0].noteOff(64 + 12*octave,100);
		});
		Button fKey2 = new Button("F");
		fKey2.setOnMousePressed(h -> {
			 mChannels[0].noteOn(65 + 12*octave, 100);
		});
		fKey2.setOnMouseReleased(h -> {
			mChannels[0].noteOff(65 + 12*octave,100);
		});
		Button fSharpKey2 = new Button("F#");
		fSharpKey2.setOnMousePressed(e -> {
			 mChannels[0].noteOn(66 + 12*octave, 100);
		});
		fSharpKey2.setOnMouseReleased(e -> {
			mChannels[0].noteOff(66 + 12*octave, 100);
		});
		Button gKey2 = new Button("G");
		gKey2.setOnMousePressed(i -> {
			mChannels[0].noteOn(67 + 12*octave, 100);
		});
		gKey2.setOnMouseReleased(i -> {
			mChannels[0].noteOff(67 + 12*octave, 100);
		});
		Button gSharpKey2 = new Button("G#");
		gSharpKey2.setOnMousePressed(i -> {
			mChannels[0].noteOn(68 + 12*octave, 100);
		});
		gSharpKey2.setOnMouseReleased(i -> {
			mChannels[0].noteOff(68 + 12*octave, 100);
		});
		Button aKey2 = new Button("A");
		aKey2.setOnMousePressed(i -> {
			mChannels[0].noteOn(69 + 12*octave, 100);
		});
		aKey2.setOnMouseReleased(i -> {
			mChannels[0].noteOff(69 + 12*octave, 100);
		});
        Button aSharpKey2 = new Button("A#");
        aSharpKey2.setOnMousePressed(i -> {
			mChannels[0].noteOn(70 + 12*octave, 100);
		});
		aSharpKey2.setOnMouseReleased(i -> {
			mChannels[0].noteOff(70 + 12*octave, 100);
		});
		Button bKey2 = new Button("B");
		bKey2.setOnMousePressed(i -> {
			mChannels[0].noteOn(71 + 12*octave, 100);
		});
		bKey2.setOnMouseReleased(i -> {
			mChannels[0].noteOff(71 + 12*octave, 100);
		});
		
		int scaleSize= 2;
		double keyWidth = 20*scaleSize;
		double keyHeight = 30*scaleSize;
		cKey.setMinWidth(keyWidth);
		cKey.setMinHeight(keyHeight);
		cKey.setMaxWidth(keyWidth);
		cKey.setMaxHeight(keyHeight);
		dKey.setMinWidth(keyWidth);
		dKey.setMinHeight(keyHeight);
		dKey.setMaxWidth(keyWidth);
		dKey.setMaxHeight(keyHeight);
		cSharpKey.setMinWidth(keyWidth);
		cSharpKey.setMinHeight(keyHeight);
		cSharpKey.setMaxWidth(keyWidth);
		cSharpKey.setMaxHeight(keyHeight);
		dSharpKey.setMinWidth(keyWidth);
		dSharpKey.setMinHeight(keyHeight);
		dSharpKey.setMaxWidth(keyWidth);
		dSharpKey.setMaxHeight(keyHeight);
		eKey.setMinWidth(keyWidth);
		eKey.setMinHeight(keyHeight);
		eKey.setMaxWidth(keyWidth);
		eKey.setMaxHeight(keyHeight);
		fKey.setMinWidth(keyWidth);
		fKey.setMinHeight(keyHeight);
		fKey.setMaxWidth(keyWidth);
		fKey.setMaxHeight(keyHeight);
		fSharpKey.setMinWidth(keyWidth);
		fSharpKey.setMinHeight(keyHeight);
		fSharpKey.setMaxWidth(keyWidth);
		fSharpKey.setMaxHeight(keyHeight);
		gKey.setMinWidth(keyWidth);
		gKey.setMinHeight(keyHeight);
		gKey.setMaxWidth(keyWidth);
		gKey.setMaxHeight(keyHeight);
		gSharpKey.setMinWidth(keyWidth);
		gSharpKey.setMinHeight(keyHeight);
		gSharpKey.setMaxWidth(keyWidth);
		gSharpKey.setMaxHeight(keyHeight);
		aKey.setMinWidth(keyWidth);
		aKey.setMinHeight(keyHeight);
		aKey.setMaxWidth(keyWidth);
		aKey.setMaxHeight(keyHeight);
		aSharpKey.setMinWidth(keyWidth);
		aSharpKey.setMinHeight(keyHeight);
		aSharpKey.setMaxWidth(keyWidth);
		aSharpKey.setMaxHeight(keyHeight);
		bKey.setMinWidth(keyWidth);
		bKey.setMinHeight(keyHeight);
		bKey.setMaxWidth(keyWidth);
		bKey.setMaxHeight(keyHeight);
		cKey2.setMinWidth(keyWidth);
		cKey2.setMinHeight(keyHeight);
		cKey2.setMaxWidth(keyWidth);
		cKey2.setMaxHeight(keyHeight);
		dKey2.setMinWidth(keyWidth);
		dKey2.setMinHeight(keyHeight);
		dKey2.setMaxWidth(keyWidth);
		dKey2.setMaxHeight(keyHeight);
		cSharpKey2.setMinWidth(keyWidth);
		cSharpKey2.setMinHeight(keyHeight);
		cSharpKey2.setMaxWidth(keyWidth);
		cSharpKey2.setMaxHeight(keyHeight);
		dSharpKey2.setMinWidth(keyWidth);
		dSharpKey2.setMinHeight(keyHeight);
		dSharpKey2.setMaxWidth(keyWidth);
		dSharpKey2.setMaxHeight(keyHeight);
		eKey2.setMinWidth(keyWidth);
		eKey2.setMinHeight(keyHeight);
		eKey2.setMaxWidth(keyWidth);
		eKey2.setMaxHeight(keyHeight);
		fKey2.setMinWidth(keyWidth);
		fKey2.setMinHeight(keyHeight);
		fKey2.setMaxWidth(keyWidth);
		fKey2.setMaxHeight(keyHeight);
		fSharpKey2.setMinWidth(keyWidth);
		fSharpKey2.setMinHeight(keyHeight);
		fSharpKey2.setMaxWidth(keyWidth);
		fSharpKey2.setMaxHeight(keyHeight);
		gKey2.setMinWidth(keyWidth);
		gKey2.setMinHeight(keyHeight);
		gKey2.setMaxWidth(keyWidth);
		gKey2.setMaxHeight(keyHeight);
		gSharpKey2.setMinWidth(keyWidth);
		gSharpKey2.setMinHeight(keyHeight);
		gSharpKey2.setMaxWidth(keyWidth);
		gSharpKey2.setMaxHeight(keyHeight);
		aKey2.setMinWidth(keyWidth);
		aKey2.setMinHeight(keyHeight);
		aKey2.setMaxWidth(keyWidth);
		aKey2.setMaxHeight(keyHeight);
		aSharpKey2.setMinWidth(keyWidth);
		aSharpKey2.setMinHeight(keyHeight);
		aSharpKey2.setMaxWidth(keyWidth);
		aSharpKey2.setMaxHeight(keyHeight);
		bKey2.setMinWidth(keyWidth);
		bKey2.setMinHeight(keyHeight);
		bKey2.setMaxWidth(keyWidth);
		bKey2.setMaxHeight(keyHeight);
		int start = 0;
		g.add(cKey, 0, 0);
		g.add(dKey, 1, 0);
		g.add(eKey, 2, 0);
		g.add(fKey,  3,  0);
		g.add(gKey, 4,  0);
		g.add(aKey,  5,  0);
		g.add(bKey,  6,  0);
		g2.add(new Label("       "), 0, 0);
		g2.add(cSharpKey, start + 1, 0);
		g2.add(dSharpKey, start + 2, 0);
		g2.add(new Label("               "), 3, 0);
		g2.add(fSharpKey, start + 4, 0);
		g2.add(gSharpKey, start + 5, 0);
		g2.add(aSharpKey, start + 6, 0);
		
		Label octaveLabel = new Label("Javatron");
		g3.add(octaveLabel, 0, 1);
		octaveLabel.setStyle("-fx-text-fill: #64d2ff;\n"
				+ "-fx-font-size: 18px;\n"
				+ "-fx-font-family: \"Arial Black\";\n"
				// + "-fx-text-fill: #084ff;\n"
				+ "-fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.6) , 6, 0.0 , 0 , 2 );");
		//#61a2b1, #2A5058
		// #61a2b1, #ff9500
		// #5AC8FA, #ff9500
		
		g3.setStyle("-fx-background-color: #ff2d55;\n" + 
				"-fx-font-size: 16pt;\n" + 
				"-fx-text-fill: white;\n" +
				"-fx-font-family: \"Arial Black\";\n" +
				"-fx-font-weight: bold;\n" + "-fx-background-color: linear-gradient(#ff9f10, #ff9500);\n"+
				"-fx-effect: dropshadow(three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );");
		
		
		cKey.setStyle("-fx-background-color: #f2f2f7;-fx-border-color: #e5e5ea");
		dKey.setStyle("-fx-background-color: #f2f2f7;-fx-border-color: #e5e5ea");
		eKey.setStyle("-fx-background-color: #f2f2f7;-fx-border-color: #e5e5ea");
		fKey.setStyle("-fx-background-color: #f2f2f7;-fx-border-color: #e5e5ea");
		gKey.setStyle("-fx-background-color: #f2f2f7;-fx-border-color: #e5e5ea");
		aKey.setStyle("-fx-background-color: #f2f2f7;-fx-border-color: #e5e5ea");
		bKey.setStyle("-fx-background-color: #f2f2f7;-fx-border-color: #e5e5ea");
		cSharpKey.setStyle("-fx-background-color: #2c2c2e;-fx-border-color: #2c2c2e");
		dSharpKey.setStyle("-fx-background-color: #2c2c2e;-fx-border-color: #2c2c2e");
		fSharpKey.setStyle("-fx-background-color: #2c2c2e;-fx-border-color: #2c2c2e");
		gSharpKey.setStyle("-fx-background-color: #2c2c2e;-fx-border-color: #2c2c2e");
		aSharpKey.setStyle("-fx-background-color: #2c2c2e;-fx-border-color: #2c2c2e");
		
		cKey2.setStyle("-fx-background-color: #f2f2f7;-fx-border-color: #e5e5ea");
		dKey2.setStyle("-fx-background-color: #f2f2f7;-fx-border-color: #e5e5ea");
		eKey2.setStyle("-fx-background-color: #f2f2f7;-fx-border-color: #e5e5ea");
		fKey2.setStyle("-fx-background-color: #f2f2f7;-fx-border-color: #e5e5ea");
		gKey2.setStyle("-fx-background-color: #f2f2f7;-fx-border-color: #e5e5ea");
		aKey2.setStyle("-fx-background-color: #f2f2f7;-fx-border-color: #e5e5ea");
		bKey2.setStyle("-fx-background-color: #f2f2f7;-fx-border-color: #e5e5ea");
		cSharpKey2.setStyle("-fx-background-color: #2c2c2e;-fx-border-color: #2c2c2e");
		dSharpKey2.setStyle("-fx-background-color: #2c2c2e;-fx-border-color: #2c2c2e");
		fSharpKey2.setStyle("-fx-background-color: #2c2c2e;-fx-border-color: #2c2c2e");
		gSharpKey2.setStyle("-fx-background-color: #2c2c2e;-fx-border-color: #2c2c2e");
		aSharpKey2.setStyle("-fx-background-color: #2c2c2e;-fx-border-color: #2c2c2e");

		double hgap = 2;
		double vgap = 5;
		g.setHgap(hgap);
		g.setVgap(vgap);
		g.setPadding(new Insets(2, 0, 2, 0)); 
		g2.setHgap(hgap);
		g2.setVgap(vgap);
		g2.setPadding(new Insets(2, 0, 2, 0));
		g2.setStyle("-fx-border-color: #2c2c2e");
		g.setStyle("-fx-border-color: #e5e5ea;");
		g.setStyle("-fx-background-color: #2c2c2e");
		g2.setStyle("-fx-background-color: #2c2c2e");
		g.setStyle("-fx-background-color: #ff2d55");
		g2.setStyle("-fx-background-color: #ff2d55");
		VBox v = new VBox();
		v.getChildren().add(g3);
		v.getChildren().add(g2);
		v.getChildren().add(g);
		Scene scene = new Scene(v, 100, 100);
		BorderPane window = new BorderPane();
		window.setBottom(v);
		
		/*
		 * attempting the pane
		 * help
		 * pls
		 */
		
		
		KeyController keyController = new KeyController();
		ArrayList<KeyCode> liveNotes = new ArrayList<>();
		ArrayList<Note> myNotes = new ArrayList<>();
		//Canvas canvas = new Canvas();
		MultipleNotePane p = new MultipleNotePane();
		v.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.SHIFT) {
				octave = 1;
				// octaveLabel.setText("1");
				g.add(cKey2, 7, 0);
				g.add(dKey2, 8, 0);
				g.add(eKey2, 9, 0);
				g.add(fKey2, 10, 0);
				g.add(gKey2, 11, 0);
				g.add(aKey2, 12, 0);
				g.add(bKey2, 13, 0);
				g2.add(new Label("               "), 7, 0);
				g2.add(cSharpKey2, 8, 0);
				g2.add(dSharpKey2, 9, 0);
				g2.add(new Label("               "), 10, 0);
				g2.add(fSharpKey2, 11, 0);
				g2.add(gSharpKey2, 12, 0);
				g2.add(aSharpKey2, 13, 0);
				octaveDrawOffset = 148*2;
				
			}

			//for (Note n : myNotes) {
			//	if (n.getCode() == e.getCode()) {
			//		break;
			//	}
			//}
			if (liveNotes.contains(e.getCode())) {
				//Color color = new Color(Math.random(), Math.random(), Math.random(), 0.5);
				//Note n = new Note(, 20, 20, color);
				//Note n = new Note(0, 20, 20, color);
				//p.add(n);
			}
			else {
			if (e.getCode() == KeyCode.Q && keyController.isOpen("C")) {
				mChannels[0].noteOn(60 + 12*octave, 100);
				
				keyController.set("C", false);
				//.getChildren().add(new Label("he"));
				Color color = new Color(Math.random(), Math.random(), Math.random(), 0.5);
				Note n = new Note(0, noteWidth, noteHeight, color);
				activeNotes.add(n);
				n.setCode(e.getCode());
				n.setX(indexMultiplier*n.getKeyboardIndex() + octaveDrawOffset);
				myNotes.add(n);
				p.add(n);
			}
			if (e.getCode() == KeyCode.DIGIT2 && keyController.isOpen("cSharp")) {
				keyController.set("cSharp", false);
				mChannels[0].noteOn(61 + 12*octave, 100);
				Color color = new Color(Math.random(), Math.random(), Math.random(), 0.5);
				Note n = new Note(1, noteWidth, noteHeight, color);
				n.setCode(e.getCode());
				n.setX(indexMultiplier*n.getKeyboardIndex() + octaveDrawOffset);
				myNotes.add(n);
				p.add(n);
			}
			if (e.getCode() == KeyCode.W && keyController.isOpen("D")) {
				keyController.set("D", false);
				mChannels[0].noteOn(62 + 12*octave, 100);
				Color color = new Color(Math.random(), Math.random(), Math.random(), 0.5);
				Note n = new Note(2, noteWidth, noteHeight, color);
				n.setCode(e.getCode());
				n.setX(indexMultiplier*n.getKeyboardIndex() + octaveDrawOffset);
				myNotes.add(n);
				p.add(n);
			}
			if (e.getCode() == KeyCode.DIGIT3 && keyController.isOpen("dSharp")) {
				keyController.set("dSharp", false);
				mChannels[0].noteOn(63 + 12*octave, 100);
				Color color = new Color(Math.random(), Math.random(), Math.random(), 0.5);
				Note n = new Note(3, noteWidth, noteHeight, color);
				n.setCode(e.getCode());
				n.setX(indexMultiplier*n.getKeyboardIndex() + octaveDrawOffset);
				myNotes.add(n);
				p.add(n);
			}
			if (e.getCode() == KeyCode.E && keyController.isOpen("E")) {
				keyController.set("E", false);
				mChannels[0].noteOn(64  + 12*octave, 100);
				Color color = new Color(Math.random(), Math.random(), Math.random(), 0.5);
				Note n = new Note(4, noteWidth, noteHeight, color);
				n.setCode(e.getCode());
				n.setX(indexMultiplier*n.getKeyboardIndex() + octaveDrawOffset);
				myNotes.add(n);
				p.add(n);
			}
			if (e.getCode() == KeyCode.R && keyController.isOpen("F")) {
				keyController.set("F", false);
				mChannels[0].noteOn(65 + 12*octave, 100);
				Color color = new Color(Math.random(), Math.random(), Math.random(), 0.5);
				Note n = new Note(5, noteWidth, noteHeight, color);
				n.setCode(e.getCode());
				n.setX(indexMultiplier*n.getKeyboardIndex() + notePrintingOffset + octaveDrawOffset);
				myNotes.add(n);
				p.add(n);
			}
			if (e.getCode() == KeyCode.DIGIT5 && keyController.isOpen("fSharp")) {
				keyController.set("fSharp", false);
				mChannels[0].noteOn(66 + 12*octave, 100);
				Color color = new Color(Math.random(), Math.random(), Math.random(), 0.5);
				Note n = new Note(6, noteWidth, noteHeight, color);
				n.setCode(e.getCode());
				n.setX(indexMultiplier*n.getKeyboardIndex() + notePrintingOffset + octaveDrawOffset);
				myNotes.add(n);
				p.add(n);
			}
			if (e.getCode() == KeyCode.T && keyController.isOpen("G")) {
				keyController.set("G", false);
				mChannels[0].noteOn(67 + 12*octave, 100);
				Color color = new Color(Math.random(), Math.random(), Math.random(), 0.5);
				Note n = new Note(7, noteWidth, noteHeight, color);
				n.setCode(e.getCode());
				n.setX(indexMultiplier*n.getKeyboardIndex() + notePrintingOffset + octaveDrawOffset);
				myNotes.add(n);
				p.add(n);
			}
			if (e.getCode() == KeyCode.DIGIT6 && keyController.isOpen("gSharp")) {
				keyController.set("gSharp", false);
				mChannels[0].noteOn(68 + 12*octave, 100);
				Color color = new Color(Math.random(), Math.random(), Math.random(), 0.5);
				Note n = new Note(8, noteWidth, noteHeight, color);
				n.setCode(e.getCode());
				n.setX(indexMultiplier*n.getKeyboardIndex() + notePrintingOffset + octaveDrawOffset);
				myNotes.add(n);
				p.add(n);
			}
			if (e.getCode() == KeyCode.Y && keyController.isOpen("A")) {
				keyController.set("A", false);
				mChannels[0].noteOn(69 + 12*octave, 100);
				Color color = new Color(Math.random(), Math.random(), Math.random(), 0.5);
				Note n = new Note(9, noteWidth, noteHeight, color);
				n.setCode(e.getCode());
				n.setX(indexMultiplier*n.getKeyboardIndex() + notePrintingOffset + octaveDrawOffset);
				myNotes.add(n);
				p.add(n);
			}
			if (e.getCode() == KeyCode.DIGIT7 && keyController.isOpen("aSharp")) {
				keyController.set("aSharp", false);
				mChannels[0].noteOn(70 + 12*octave, 100);
				Color color = new Color(Math.random(), Math.random(), Math.random(), 0.5);
				Note n = new Note(10, noteWidth, noteHeight, color);
				n.setCode(e.getCode());
				n.setX(indexMultiplier*n.getKeyboardIndex() + notePrintingOffset + notePrintingOffset2 + octaveDrawOffset);
				myNotes.add(n);
				p.add(n);
			}
			if (e.getCode() == KeyCode.U && keyController.isOpen("B")) {
				keyController.set("B", false);
				mChannels[0].noteOn(71 + 12*octave, 100);
				Color color = new Color(Math.random(), Math.random(), Math.random(), 0.5);
				Note n = new Note(11, noteWidth, noteHeight, color);
				n.setCode(e.getCode());
				n.setX(indexMultiplier*n.getKeyboardIndex() + notePrintingOffset + notePrintingOffset2 + octaveDrawOffset);
				myNotes.add(n);
				p.add(n);
			}
			}
			liveNotes.add(e.getCode());
			 //mChannels[0].noteOn(60, 100);
		});
		
		v.setOnKeyReleased(e -> {
			//liveNotes.remove(e.getCode());
			liveNotes.clear();
			
			if (e.getCode() == KeyCode.SHIFT) {
				octave = 0;
				octaveDrawOffset = 0;
				g.getChildren().remove(cKey2);
				g.getChildren().remove(dKey2);
				g.getChildren().remove(eKey2);
				g.getChildren().remove(fKey2);
				g.getChildren().remove(gKey2);
				g.getChildren().remove(aKey2);
				g.getChildren().remove(bKey2);
				g2.getChildren().remove(cSharpKey2);
				g2.getChildren().remove(dSharpKey2);
				g2.getChildren().remove(fSharpKey2);
				g2.getChildren().remove(gSharpKey2);
				g2.getChildren().remove(aSharpKey2);
			}
			if (e.getCode() == KeyCode.Q) {
				keyController.set("C", true);
				mChannels[0].noteOff(60, 100);
				mChannels[0].noteOff(72, 100);
				for (Note n : myNotes) {
					if (n.getKeyboardIndex() == 0) {
						n.markForDeletion();
					}
				}
				// Color color = new Color(Math.random(), Math.random(), Math.random(), 0.5);
				// Note n = new Note(0, 20, 20, color);
				// n.setX(10*n.getKeyboardIndex());
				// p.add(n);
				//for (Note n : myNotes) {
					//if (n.getKeyboardIndex() == 0) {
						//n.markForDeletion();
					//}
				//}
			}
			if (e.getCode() == KeyCode.DIGIT2) {
				keyController.set("cSharp", true);
				mChannels[0].noteOff(61, 100);
				mChannels[0].noteOff(73, 100);
				for (Note n : myNotes) {
					if (n.getKeyboardIndex() == 1) {
						n.markForDeletion();
					}
				}
				//Color color = new Color(Math.random(), Math.random(), Math.random(), 0.5);
				//Note n = new Note(1, 20, 20, color);
				//n.setX(10*n.getKeyboardIndex());
				//p.add(n);
			}
			if (e.getCode() == KeyCode.W) {
				keyController.set("D", true);
				mChannels[0].noteOff(62, 100);
				mChannels[0].noteOff(74, 100);
				for (Note n : myNotes) {
					if (n.getKeyboardIndex() == 2) {
						n.markForDeletion();
					}
				}
				//Color color = new Color(Math.random(), Math.random(), Math.random(), 0.5);
				//Note n = new Note(2, 20, 20, color);
				//n.setX(10*n.getKeyboardIndex());
				//p.add(n);
			}
			if (e.getCode() == KeyCode.DIGIT3) {
				keyController.set("dSharp", true);
				mChannels[0].noteOff(63, 100);
				mChannels[0].noteOff(75, 100);
				for (Note n : myNotes) {
					if (n.getKeyboardIndex() == 3) {
						n.markForDeletion();
					}
				}
				//Color color = new Color(Math.random(), Math.random(), Math.random(), 0.5);
				//Note n = new Note(3, 20, 20, color);
				//n.setX(10*n.getKeyboardIndex());
				//p.add(n);
			}
			if (e.getCode() == KeyCode.E) {
				keyController.set("E", true);
				mChannels[0].noteOff(64, 100);
				mChannels[0].noteOff(76, 100);
				for (Note n : myNotes) {
					if (n.getKeyboardIndex() == 4) {
						n.markForDeletion();
					}
				}
				//Color color = new Color(Math.random(), Math.random(), Math.random(), 0.5);
				//Note n = new Note(4, 20, 20, color);
				//n.setX(10*n.getKeyboardIndex());
				//p.add(n);
			}
			if (e.getCode() == KeyCode.R) {
				keyController.set("F", true);
				mChannels[0].noteOff(65, 100);
				mChannels[0].noteOff(77, 100);
				for (Note n : myNotes) {
					if (n.getKeyboardIndex() == 5) {
						n.markForDeletion();
					}
				}
				//Color color = new Color(Math.random(), Math.random(), Math.random(), 0.5);
				//Note n = new Note(5, 20, 20, color);
				//n.setX(10*n.getKeyboardIndex());
				//p.add(n);
			}
			if (e.getCode() == KeyCode.DIGIT5) {
				keyController.set("fSharp", true);
				mChannels[0].noteOff(66, 100);
				mChannels[0].noteOff(78, 100);
				for (Note n : myNotes) {
					if (n.getKeyboardIndex() == 6) {
						n.markForDeletion();
					}
				}
				//Color color = new Color(Math.random(), Math.random(), Math.random(), 0.5);
				//Note n = new Note(6, 20, 20, color);
				//n.setX(10*n.getKeyboardIndex());
				//p.add(n);
			}
			if (e.getCode() == KeyCode.T) {
				keyController.set("G", true);
				mChannels[0].noteOff(67, 100);

				mChannels[0].noteOff(79, 100);
				for (Note n : myNotes) {
					if (n.getKeyboardIndex() == 7) {
						n.markForDeletion();
					}
				}
				//Color color = new Color(Math.random(), Math.random(), Math.random(), 0.5);
				//Note n = new Note(7, 20, 20, color);
				//n.setX(10*n.getKeyboardIndex());
				//p.add(n);
			}
			if (e.getCode() == KeyCode.DIGIT6) {
				keyController.set("gSharp", true);
				mChannels[0].noteOff(68, 100);

				mChannels[0].noteOff(80, 100);
				for (Note n : myNotes) {
					if (n.getKeyboardIndex() == 8) {
						n.markForDeletion();
					}
				}
				//Color color = new Color(Math.random(), Math.random(), Math.random(), 0.5);
				//Note n = new Note(8, 20, 20, color);
				//n.setX(10*n.getKeyboardIndex());
				//p.add(n);
			}
			if (e.getCode() == KeyCode.Y) {
				keyController.set("A", true);
				mChannels[0].noteOff(69, 100);
				mChannels[0].noteOff(81, 100);
				for (Note n : myNotes) {
					if (n.getKeyboardIndex() == 9) {
						n.markForDeletion();
					}
				}
				//Color color = new Color(Math.random(), Math.random(), Math.random(), 0.5);
				//Note n = new Note(9, 20, 20, color);
				//n.setX(10*n.getKeyboardIndex());
				//p.add(n);
			}
			if (e.getCode() == KeyCode.DIGIT7) {
				keyController.set("aSharp", true);
				mChannels[0].noteOff(70, 100);
				mChannels[0].noteOff(82, 100);
				for (Note n : myNotes) {
					if (n.getKeyboardIndex() == 10) {
						n.markForDeletion();
					}
				}
				//Color color = new Color(Math.random(), Math.random(), Math.random(), 0.5);
				//Note n = new Note(10, 20, 20, color);
				//n.setX(10*n.getKeyboardIndex());
				//p.add(n);
			}
			if (e.getCode() == KeyCode.U) {
				keyController.set("B", true);
				mChannels[0].noteOff(71, 100);
				mChannels[0].noteOff(83, 100);
				for (Note n : myNotes) {
					if (n.getKeyboardIndex() == 11) {
						n.markForDeletion();
					}
				}
				//Color color = new Color(Math.random(), Math.random(), Math.random(), 0.5);
				//Note n = new Note(11, 20, 20, color);
				//n.setX(10*n.getKeyboardIndex());
				//p.add(n);
			}
			//liveNotes.clear();
		});
		
		
		
		
		//setGlobalEventHandler(p, cKey);
		p.setStyle("-fx-background-color: #48484a;");
		window.setCenter(p);
		Scene freePlayScene = new Scene(window, 586, 495);
		// primaryStage.setScene(scene);
		primaryStage.setScene(freePlayScene);
		primaryStage.show();
	}
	
	
	public void setGlobalEventHandler(Node root, Button b) {
	    root.addEventHandler(KeyEvent.KEY_PRESSED, ev -> {
	        if (ev.getCode() == KeyCode.C) {
	           b.fire();
	           ev.consume(); 
	        }
	    });
	}
	
	
	private class MultipleNotePane extends Pane {
		private Timeline animation;
		
		public MultipleNotePane() {
			animation = new Timeline(
					new KeyFrame(Duration.millis(50), e ->moveNote()));
			animation.setCycleCount(Timeline.INDEFINITE);
			animation.play();
		}
		
		public void add(Note n) {
			Color color = new Color(Math.random(), Math.random(), Math.random(), 0.5);
			//n.setX(20);
			n.setColor(color);
			n.setStyle("-fx-background-color: #000000");
			getChildren().add(n);
			n.setY(335);
		}
		
		public void subtract() {
		      if (getChildren().size() > 0) {
		        getChildren().remove(getChildren().size() - 1); 
		      }
		}
		
		public void play() {
			animation.play();
			}
		
		public void pause() {
		      animation.pause();
		    }
		
		protected void moveNote() {
		      for (Node node: this.getChildren()) {
		      Note note = (Note)node;
		      if (note.isMarked() == true) {
			      note.setY(note.getY()-1);
			      note.setOpacity(note.getOpacity()*(.9999));
			      // note.setTimer(note.getTimer()-1);
		      }
		      /*
		       * this throws error but should 
		       * theoretically clean up memory
		       */
		      //if (note.getTimer() == 0) {
		    	//  this.getChildren().remove(note);
		      //}
		      else {
		    	  note.setHeight(note.getHeight()+1);
		    	  note.setY(note.getY()-1);
		      }
			        //note.setHeight(note.getHeight() +1);
		       
		        //note.setOpacity(note.getOpacity()*.8);
		        // Check boundaries
		        //if (note.getX() < note.getWidth() || 
		        //    note.getX() > getWidth() - note.getWidth()) {
		        //  note.dx *= -1; // Change ball move direction
		        //}
		        //if (note.getY() < note.getHeight() || 
		        //    note.getY() > getHeight() - note.getWidth()) {
		        //  note.dy *= -1; // Change ball move direction
		        //}

		        // Adjust ball position
		        //note.setX(note.dx + note.getX());
		        //note.setY(note.dy + note.getY());
		      }
		    }
		
		public DoubleProperty rateProperty() {
			return animation.rateProperty();
		}
		
		
	}
	
	class Note extends Rectangle {
		private double dx = 1, dy = 1;
		private boolean shouldDelete = false;
		private double x;
		private double y;
		private int number;
		private int keyboardIndex;
		private Color c;
		private KeyCode keyCode;
		private int timer = 100;
		
		Note(int keyboardIndex, double x, double y, Color color) {
			super (x, y);
			setFill(color);
			this.c = color;
			this.keyboardIndex = keyboardIndex;
		}
		
		public void setTimer(int timer) {
			this.timer = timer;
		}
		
		public int getTimer() {
			return timer;
		}
		
		public void markForDeletion() {
			shouldDelete = true;
		}
		
		public void setCode(KeyCode keyCode) {
			this.keyCode = keyCode;
		}
		
		public KeyCode getCode() {
			return keyCode;
		}
		
		public void setColor(Color c) {
			this.c = c;
		}
		
		public Color getColor() {
			return c;
		}
		
		public boolean isMarked() {
			return shouldDelete;
		}
		
		public void setNoteNumber(int number) {
			this.number = number;
		}
		
		public void setKeyboardIndex(int keyboardIndex) {
			this.keyboardIndex = keyboardIndex;
		}
		
		public int getKeyboardIndex() {
			return keyboardIndex;
		}
		
		public int getNoteNumber() {
			return number;
		}
		
	}
	
	class MusicalStack extends Stack {
		Stack stack;
		
		
		MusicalStack(List<Note> notes) {
		stack = new Stack();
		for (Note n : notes) {
			stack.add(n);
		}
		
		
		}
		
	}
	
	class KeyController {
		private boolean c = true;
		private boolean cSharp = true;
		private boolean d = true;
		private boolean dSharp = true;
		private boolean e = true;
		private boolean f = true;
		private boolean fSharp = true;
		private boolean g = true;
		private boolean gSharp = true;
		private boolean a = true;
		private boolean aSharp = true;
		private boolean b = true;
		KeyController() {
		
		}
		public void set(String note, boolean b) {
			if (note.equalsIgnoreCase("C")) {
				this.c = b;
			}
			if (note.equalsIgnoreCase("cSharp")) {
				this.cSharp = b;
			}
			if (note.equalsIgnoreCase("D")) {
				this.d = b;
			}
			if (note.equalsIgnoreCase("dSharp")) {
				this.dSharp = b;
			}
			if (note.equalsIgnoreCase("E")) {
				this.e = b;
			}
			if (note.equalsIgnoreCase("F")) {
				this.f = b;
			}
			if (note.equalsIgnoreCase("fSharp")) {
				this.fSharp = b;
			}
			if (note.equalsIgnoreCase("G")) {
				this.g = b;
			}
			if (note.equalsIgnoreCase("gSharp")) {
				this.gSharp = b;
			}
			if (note.equalsIgnoreCase("A")) {
				this.a = b;
			}
			if (note.equalsIgnoreCase("aSharp")) {
				this.aSharp = b;
			}
			if (note.equalsIgnoreCase("B")) {
				this.b = b;
			}
		}
		
		
		
		
		
		
		
		
		public boolean isOpen(String note) {
			if (note.equalsIgnoreCase("C")) {
				return c;
			}
			if (note.equalsIgnoreCase("cSharp")) {
				return cSharp;
			}
			if (note.equalsIgnoreCase("D")) {
				return d;
			}
			if (note.equalsIgnoreCase("dSharp")) {
				return dSharp;
			}
			if (note.equalsIgnoreCase("E")) {
				return e;
			}
			if (note.equalsIgnoreCase("F")) {
				return f;
			}
			if (note.equalsIgnoreCase("fSharp")) {
				return fSharp;
			}
			if (note.equalsIgnoreCase("G")) {
				return g;
			}
			if (note.equalsIgnoreCase("gSharp")) {
				return gSharp;
			}
			if (note.equalsIgnoreCase("A")) {
				return a;
			}
			if (note.equalsIgnoreCase("aSharp")) {
				return aSharp;
			}
			if (note.equalsIgnoreCase("B")) {
				return b;
			}
			else {
				return true;
			}
		}
	}
	
}