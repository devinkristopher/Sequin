

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

public class NoteTest extends Application {
	public static void main (String[] args) {
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
		String[] notes = new String[]{"C", "D", "E", "F", "G", "A", "B"};
		HashMap<String, Integer> keySet = new HashMap<String, Integer>();
		int k = 0;
		for (String s : notes) {
			keySet.put(s, k);
			k++;
		}
	
        
        
        Button cKey = new Button("C");
		cKey.setOnMousePressed(e -> {
			 mChannels[0].noteOn(60, 100);
		});
		
		cKey.setOnMouseReleased(e -> {
			mChannels[0].noteOff(60, 100);
		});
		Button cSharpKey = new Button("C#");
		cSharpKey.setOnMousePressed(e -> {
			 mChannels[0].noteOn(61, 100);
		});
		
		cSharpKey.setOnMouseReleased(e -> {
			mChannels[0].noteOff(61, 100);
		});
		Button dKey = new Button("D");
		dKey.setOnMousePressed(e -> {
			 mChannels[0].noteOn(62, 100);
		});
		dKey.setOnMouseReleased(e -> {
			mChannels[0].noteOff(62,100);
		});
		Button dSharpKey = new Button("D#");
		dSharpKey.setOnMousePressed(e -> {
			 mChannels[0].noteOn(63, 100);
		});
		dSharpKey.setOnMouseReleased(e -> {
			mChannels[0].noteOff(63, 100);
		});
		Button eKey = new Button("E");
		eKey.setOnMousePressed(f -> {
			mChannels[0].noteOn(64, 100);
		});
		eKey.setOnMouseReleased(f -> {
			mChannels[0].noteOff(64,100);
		});
		Button fKey = new Button("F");
		fKey.setOnMousePressed(h -> {
			 mChannels[0].noteOn(65, 100);
		});
		fKey.setOnMouseReleased(h -> {
			mChannels[0].noteOff(65,100);
		});
		Button fSharpKey = new Button("F#");
		fSharpKey.setOnMousePressed(e -> {
			 mChannels[0].noteOn(66, 100);
		});
		fSharpKey.setOnMouseReleased(e -> {
			mChannels[0].noteOff(66, 100);
		});
		Button gKey = new Button("G");
		gKey.setOnMousePressed(i -> {
			mChannels[0].noteOn(67, 100);
		});
		gKey.setOnMouseReleased(i -> {
			mChannels[0].noteOff(67, 100);
		});
		Button gSharpKey = new Button("G#");
		gSharpKey.setOnMousePressed(i -> {
			mChannels[0].noteOn(68, 100);
		});
		gSharpKey.setOnMouseReleased(i -> {
			mChannels[0].noteOff(68, 100);
		});
		Button aKey = new Button("A");
		aKey.setOnMousePressed(i -> {
			mChannels[0].noteOn(69, 100);
		});
		aKey.setOnMouseReleased(i -> {
			mChannels[0].noteOff(69, 100);
		});
        Button aSharpKey = new Button("A#");
        aSharpKey.setOnMousePressed(i -> {
			mChannels[0].noteOn(70, 100);
		});
		aSharpKey.setOnMouseReleased(i -> {
			mChannels[0].noteOff(70, 100);
		});
		Button bKey = new Button("B");
		bKey.setOnMousePressed(i -> {
			mChannels[0].noteOn(71, 100);
		});
		bKey.setOnMouseReleased(i -> {
			mChannels[0].noteOff(71, 100);
		});
		
		double keyWidth = 20;
		double keyHeight = 30;
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
		
		int start = 0;
		g.add(cKey, 0, 0);
		g.add(dKey, 1, 0);
		g.add(eKey, 2, 0);
		g.add(fKey,  3,  0);
		g.add(gKey, 4,  0);
		g.add(aKey,  5,  0);
		g.add(bKey,  6,  0);
		g2.add(new Label("   "), 0, 0);
		g2.add(cSharpKey, start + 1, 0);
		g2.add(dSharpKey, start + 2, 0);
		g2.add(new Label("       "), 3, 0);
		g2.add(fSharpKey, start + 4, 0);
		g2.add(gSharpKey, start + 5, 0);
		g2.add(aSharpKey, start + 6,  0);
		
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
		int notePrintingOffset = 16;
		int notePrintingOffset2 = 4;
		ArrayList<KeyCode> liveNotes = new ArrayList<>();
		ArrayList<Note> myNotes = new ArrayList<>();
		//Canvas canvas = new Canvas();
		MultipleNotePane p = new MultipleNotePane();
		v.setOnKeyPressed(e -> {
			if (liveNotes.contains(e.getCode())) {
				//Color color = new Color(Math.random(), Math.random(), Math.random(), 0.5);
				//Note n = new Note(, 20, 20, color);
				//Note n = new Note(0, 20, 20, color);
				//p.add(n);
			}
			else {
			if (e.getCode() == KeyCode.Q) {
				mChannels[0].noteOn(60, 100);
				//.getChildren().add(new Label("he"));
				Color color = new Color(Math.random(), Math.random(), Math.random(), 0.5);
				Note n = new Note(0, 20, 20, color);
				n.setX(10*n.getKeyboardIndex());
				myNotes.add(n);
				p.add(n);
			}
			if (e.getCode() == KeyCode.DIGIT2) {
				mChannels[0].noteOn(61, 100);
				Color color = new Color(Math.random(), Math.random(), Math.random(), 0.5);
				Note n = new Note(1, 20, 20, color);
				n.setX(10*n.getKeyboardIndex());
				myNotes.add(n);
				p.add(n);
			}
			if (e.getCode() == KeyCode.W) {
				mChannels[0].noteOn(62, 100);
				Color color = new Color(Math.random(), Math.random(), Math.random(), 0.5);
				Note n = new Note(2, 20, 20, color);
				n.setX(10*n.getKeyboardIndex());
				myNotes.add(n);
				p.add(n);
			}
			if (e.getCode() == KeyCode.DIGIT3) {
				mChannels[0].noteOn(63, 100);
				Color color = new Color(Math.random(), Math.random(), Math.random(), 0.5);
				Note n = new Note(3, 20, 20, color);
				n.setX(10*n.getKeyboardIndex());
				myNotes.add(n);
				p.add(n);
			}
			if (e.getCode() == KeyCode.E) {
				mChannels[0].noteOn(64, 100);
				Color color = new Color(Math.random(), Math.random(), Math.random(), 0.5);
				Note n = new Note(4, 20, 20, color);
				n.setX(10*n.getKeyboardIndex());
				myNotes.add(n);
				p.add(n);
			}
			if (e.getCode() == KeyCode.R) {
				mChannels[0].noteOn(65, 100);
				Color color = new Color(Math.random(), Math.random(), Math.random(), 0.5);
				Note n = new Note(5, 20, 20, color);
				n.setX(10*n.getKeyboardIndex() + notePrintingOffset);
				myNotes.add(n);
				p.add(n);
			}
			if (e.getCode() == KeyCode.DIGIT5) {
				mChannels[0].noteOn(66, 100);
				Color color = new Color(Math.random(), Math.random(), Math.random(), 0.5);
				Note n = new Note(6, 20, 20, color);
				n.setX(10*n.getKeyboardIndex() + notePrintingOffset);
				myNotes.add(n);
				p.add(n);
			}
			if (e.getCode() == KeyCode.T) {
				mChannels[0].noteOn(67, 100);
				Color color = new Color(Math.random(), Math.random(), Math.random(), 0.5);
				Note n = new Note(7, 20, 20, color);
				n.setX(10*n.getKeyboardIndex() + notePrintingOffset);
				myNotes.add(n);
				p.add(n);
			}
			if (e.getCode() == KeyCode.DIGIT6) {
				mChannels[0].noteOn(68, 100);
				Color color = new Color(Math.random(), Math.random(), Math.random(), 0.5);
				Note n = new Note(8, 20, 20, color);
				n.setX(10*n.getKeyboardIndex() + notePrintingOffset);
				myNotes.add(n);
				p.add(n);
			}
			if (e.getCode() == KeyCode.Y) {
				mChannels[0].noteOn(69, 100);
				Color color = new Color(Math.random(), Math.random(), Math.random(), 0.5);
				Note n = new Note(9, 20, 20, color);
				n.setX(10*n.getKeyboardIndex() + notePrintingOffset);
				myNotes.add(n);
				p.add(n);
			}
			if (e.getCode() == KeyCode.DIGIT7) {
				mChannels[0].noteOn(70, 100);
				Color color = new Color(Math.random(), Math.random(), Math.random(), 0.5);
				Note n = new Note(10, 20, 20, color);
				n.setX(10*n.getKeyboardIndex() + notePrintingOffset + notePrintingOffset2);
				myNotes.add(n);
				p.add(n);
			}
			if (e.getCode() == KeyCode.U) {
				mChannels[0].noteOn(71, 100);
				Color color = new Color(Math.random(), Math.random(), Math.random(), 0.5);
				Note n = new Note(11, 20, 20, color);
				n.setX(10*n.getKeyboardIndex() + notePrintingOffset + notePrintingOffset2);
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
			if (e.getCode() == KeyCode.Q) {
				mChannels[0].noteOff(60, 100);
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
				mChannels[0].noteOff(61, 100);
				
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
				mChannels[0].noteOff(62, 100);
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
				mChannels[0].noteOff(63, 100);
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
				mChannels[0].noteOff(64, 100);
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
				mChannels[0].noteOff(65, 100);
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
				mChannels[0].noteOff(66, 100);
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
				mChannels[0].noteOff(67, 100);
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
				mChannels[0].noteOff(68, 100);
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
				mChannels[0].noteOff(69, 100);
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
				mChannels[0].noteOff(70, 100);
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
				mChannels[0].noteOff(71, 100);
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
		window.setCenter(p);
		Scene freePlayScene = new Scene(window, 300, 500);
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
			getChildren().add(n);
			n.setY(400);
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
		      }
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
		
		Note(int keyboardIndex, double x, double y, Color color) {
			super (x, y);
			setFill(color);
			this.c = color;
			this.keyboardIndex = keyboardIndex;
		}
		
		public void markForDeletion() {
			shouldDelete = true;
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
	
	
}