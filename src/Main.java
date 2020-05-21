

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application {
	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage primaryStage) {
		showMainScene(primaryStage);
		Sequencer defaultSequencer = startSequencer();
		playMidiNotes(defaultSequencer, 5);
	}
	
	public Sequencer startSequencer() {
		Sequencer sequencer = null;
		try {
			sequencer = MidiSystem.getSequencer();
		} catch (MidiUnavailableException e1) {
			e1.printStackTrace();
		}
		try {
			sequencer.open();
		} catch (MidiUnavailableException e1) {
			e1.printStackTrace();
		} 
		return sequencer;
	}
	
	
	
	public void showMainScene(Stage primaryStage) {
		BorderPane pane = new BorderPane();
		pane.setTop(addConsoleView());
		pane.setBottom(showPiano());
		
		Scene mainScene = new Scene(pane, 500, 500);
		primaryStage.setScene(mainScene);
		primaryStage.show();
	}
	
	
	
	
	
	public Pane showPiano() {
		Pane wrapperPane = new Pane();
		
		Canvas canvas = new Canvas();
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.setFill(Color.BLACK);
		gc.fillRect(75, 75, 100, 100);
		Image img = new Image("music.png");
		gc.drawImage(img, 0, 0);
		gc.fillRoundRect(15, 15, 50, 50, 45, 45);
		
	    canvas.widthProperty().bind(wrapperPane.widthProperty());
	    canvas.heightProperty().bind(wrapperPane.heightProperty());
	   
	    //redraw when resized
	   //canvas.widthProperty().addListener(event -> draw(canvas));
	   //canvas.heightProperty().addListener(event -> draw(canvas));
	   //draw(canvas);
	    
	    GridPane g = new GridPane();
	    Button aBtn = new Button("A");
	    Button bBtn = new Button("B");
	    Button cBtn = new Button("C");
	    Button dBtn = new Button("D");
	    Button eBtn = new Button("E");
	    g.add(aBtn, 0, 0);
	    g.add(bBtn, 1, 0);
	    g.add(cBtn, 2, 0);
	    g.add(dBtn, 3, 0);
	    g.add(eBtn, 4, 0);
	    aBtn.setOnKeyPressed(e -> {
	    	KeyCode keyCode = e.getCode();
	    	if (keyCode == KeyCode.A) {
	    		aBtn.fire();
	    		System.out.println("A");
	    		
	    	}
	    	if (keyCode == KeyCode.B) {
	    		bBtn.fire();
	    		System.out.println("B");
	    	}
	    	if (keyCode == KeyCode.C) {
	    		cBtn.fire();
	    		System.out.println("C");
	    	}
	    	if (keyCode == KeyCode.D) {
	    		dBtn.fire();
	    		System.out.println("D");
	    	}
	    	if (keyCode == KeyCode.E) {
	    		eBtn.fire();
	    		System.out.println("E");
	    	}
	    });
		
		wrapperPane.getChildren().add(g);
		return wrapperPane;
	}
	
	
	
	public HBox addConsoleView() {
		HBox strip = new HBox();
		GridPane g = new GridPane();
		
		Label text = new Label("120");
		text.setStyle("-fx-background-color: \n" + 
				"        #090a0c,\n" + 
				"        linear-gradient(#38424b 0%, #1f2429 20%, #191d22 100%),\n" + 
				"        linear-gradient(#20262b, #191d22),\n" + 
				"        radial-gradient(center 50% 0%, radius 100%, rgba(114,131,148,0.9), rgba(255,255,255,0));\n" + 
				"    -fx-background-radius: 5,4,3,5;\n" + 
				"    -fx-background-insets: 0,1,2,0;\n" + 
				"    -fx-text-fill: #30D158;\n" + 
				"    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );\n" + 
				"    -fx-font-family: \"DIN Alternate\";\n" + 
				// "    -fx-text-fill: linear-gradient(white, #30D158);\n" + 
				" 	 -fx-text-fill: linear-gradient(#30D158, #34C759);\n" +
				"    -fx-font-size: 36px;\n" + 
				"    -fx-padding: 10 20 10 20;");
		strip.getChildren().add(text);
		g.add(text, 0, 0);
		
		Label text2 = new Label("4/4");
		text2.setStyle("-fx-background-color: \n" + 
				"        #090a0c,\n" + 
				"        linear-gradient(#38424b 0%, #1f2429 20%, #191d22 100%),\n" + 
				"        linear-gradient(#20262b, #191d22),\n" + 
				"        radial-gradient(center 50% 0%, radius 100%, rgba(114,131,148,0.9), rgba(255,255,255,0));\n" + 
				"    -fx-background-radius: 5,4,3,5;\n" + 
				"    -fx-background-insets: 0,1,2,0;\n" + 
				"    -fx-text-fill: #30D158;\n" + 
				"    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );\n" + 
				"    -fx-font-family: \"DIN Alternate\";\n" + 
				// "    -fx-text-fill: linear-gradient(white, #30D158);\n" + 
				" 	 -fx-text-fill: linear-gradient(#30D158, #34C759);\n" +
				"    -fx-font-size: 36px;\n" + 
				"    -fx-padding: 10 20 10 20;");
		strip.getChildren().add(text2);
		g.add(text2, 1, 0);
		
		//Label text3 = new Label("4/4\nCmaj");
		Label text3 = new Label("Cmaj");
		text3.setStyle("-fx-background-color: \n" + 
				"        #090a0c,\n" + 
				"        linear-gradient(#38424b 0%, #1f2429 20%, #191d22 100%),\n" + 
				"        linear-gradient(#20262b, #191d22),\n" + 
				"        radial-gradient(center 50% 0%, radius 100%, rgba(114,131,148,0.9), rgba(255,255,255,0));\n" + 
				"    -fx-background-radius: 5,4,3,5;\n" + 
				"    -fx-background-insets: 0,1,2,0;\n" + 
				"    -fx-text-fill: #30D158;\n" + 
				"    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );\n" + 
				"    -fx-font-family: \"DIN Alternate\";\n" + 
				// "    -fx-text-fill: linear-gradient(white, #30D158);\n" + 
				" 	 -fx-text-fill: linear-gradient(#30D158, #34C759);\n" +
				"    -fx-font-size: 36px;\n" + 
				"    -fx-padding: 10 20 10 20;");
		strip.getChildren().add(text3);
		g.add(text3, 2, 0);
		
		
		Label txt = new Label();
		txt.setStyle("-fx-background-color: \n" + 
				"        #090a0c,\n" + 
				"        linear-gradient(#38424b 0%, #1f2429 20%, #191d22 100%),\n" + 
				"        linear-gradient(#20262b, #191d22),\n" + 
				"        radial-gradient(center 50% 0%, radius 100%, rgba(114,131,148,0.9), rgba(255,255,255,0));\n" + 
				"    -fx-background-radius: 5,4,3,5;\n" + 
				"    -fx-background-insets: 0,1,2,0;\n" + 
				"    -fx-text-fill: #30D158;\n" + 
				"    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );\n" + 
				"    -fx-font-family: \"DIN Alternate\";\n" + 
				// "    -fx-text-fill: linear-gradient(white, #30D158);\n" + 
				" 	 -fx-text-fill: linear-gradient(#30D158, #34C759);\n" +
				"    -fx-font-size: 12px;\n" + 
				"    -fx-padding: 10 20 10 20;");
		// txt.setMaxWidth(text.getWidth());
		
		txt.maxWidthProperty().bind(text.widthProperty());
		txt.setText("bpm");
		g.add(txt,  0,  1);
		
		Label txt2 = new Label();
		txt2.setStyle("-fx-background-color: \n" + 
				"        #090a0c,\n" + 
				"        linear-gradient(#38424b 0%, #1f2429 20%, #191d22 100%),\n" + 
				"        linear-gradient(#20262b, #191d22),\n" + 
				"        radial-gradient(center 50% 0%, radius 100%, rgba(114,131,148,0.9), rgba(255,255,255,0));\n" + 
				"    -fx-background-radius: 5,4,3,5;\n" + 
				"    -fx-background-insets: 0,1,2,0;\n" + 
				"    -fx-text-fill: #30D158;\n" + 
				"    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );\n" + 
				"    -fx-font-family: \"DIN Alternate\";\n" + 
				// "    -fx-text-fill: linear-gradient(white, #30D158);\n" + 
				" 	 -fx-text-fill: linear-gradient(#30D158, #34C759);\n" +
				"    -fx-font-size: 12px;\n" + 
				"    -fx-padding: 10 20 10 20;");
		// txt.setMaxWidth(text.getWidth());
		txt2.maxWidthProperty().bind(text2.widthProperty());
		txt2.setText("time sig.");
		g.add(txt2,  1,  1);
		
		Label txt3 = new Label();
		txt3.setStyle("-fx-background-color: \n" + 
				"        #090a0c,\n" + 
				"        linear-gradient(#38424b 0%, #1f2429 20%, #191d22 100%),\n" + 
				"        linear-gradient(#20262b, #191d22),\n" + 
				"        radial-gradient(center 50% 0%, radius 100%, rgba(114,131,148,0.9), rgba(255,255,255,0));\n" + 
				"    -fx-background-radius: 5,4,3,5;\n" + 
				"    -fx-background-insets: 0,1,2,0;\n" + 
				"    -fx-text-fill: #30D158;\n" + 
				"    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );\n" + 
				"    -fx-font-family: \"DIN Alternate\";\n" + 
				// "    -fx-text-fill: linear-gradient(white, #30D158);\n" + 
				" 	 -fx-text-fill: linear-gradient(#30D158, #34C759);\n" +
				"    -fx-font-size: 12px;\n" + 
				"    -fx-padding: 10 20 10 20;");
		// txt.setMaxWidth(text.getWidth());
		txt3.maxWidthProperty().bind(text3.widthProperty());
		txt3.setText("key");
		g.add(txt3,  2,  1);
		
		
		strip.getChildren().add(g);
		System.out.println(javafx.scene.text.Font.getFamilies());
		return strip;
		
	}
	
	
	/*
	 * make a null sequencer, 
	 * try to set it to System MIDI, 
	 * try to open System MIDI Sequencer
	 */
	
	public void playMidiNotes(Sequencer sequencer, int numOfNotes) {
        Sequence sequence = null;
        try {
			sequence = new Sequence(Sequence.PPQ, 4);
		} catch (InvalidMidiDataException e1) {
			e1.printStackTrace();
		}
        Track track = sequence.createTrack();
        for (int i = 5; i < (4 * numOfNotes) + 5; i += 4) 
        { 
            track.add(makeEvent(144, 1, i+50, 100, i)); 
            track.add(makeEvent(128, 1, i+50, 100, i + 2)); 
        }
        try {
			sequencer.setSequence(sequence);
		} catch (InvalidMidiDataException e) {
			e.printStackTrace();
		} 
        sequencer.setTempoInBPM(120);
        sequencer.start();
        sequencer.stop();
        sequencer.close();
	}
	
	public MidiEvent makeEvent(int command, int channel, 
            int note, int velocity, int tick) 
	{ 
		MidiEvent event = null; 
		try { 
			ShortMessage a = new ShortMessage(); 
			a.setMessage(command, channel, note, velocity); 
			event = new MidiEvent(a, tick); 
			} 
		catch (Exception ex) { 
			ex.printStackTrace(); 
			} 
		return event; 
		}
	}