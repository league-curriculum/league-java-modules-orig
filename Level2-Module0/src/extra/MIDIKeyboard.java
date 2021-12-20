package extra;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MIDIKeyboard implements KeyListener{
	Synthesizer synth;
	public MidiChannel[] channels;
	JLabel noteLabel = new JLabel();
	int piano = 0;
	int drums = 9;
	String[] notes = { "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B" };
	ArrayList<Integer> keyboardRowQtoP = new ArrayList<Integer>(Arrays.asList(81,87,69,82,84,89,85,73,79,80,91,93));
	ArrayList<Integer> keyboardRowAtoL = new ArrayList<Integer>(Arrays.asList(65,83,68,70,71,72,74,75,76,59,222));
	ArrayList<Integer> keyboardRowZtoM = new ArrayList<Integer>(Arrays.asList(90,88,67,86,66,78,77,44,46,47));
	int lastKey = 0;

	public static void main(String[] args) {
		MIDIKeyboard keyboard = new MIDIKeyboard();
		keyboard.start();
	}

	private void start() {
		initialize();
		noteLabel.setFont(new Font("Arial", Font.BOLD, 40));
		noteLabel.setHorizontalAlignment(JLabel.CENTER);
		JFrame frame = new JFrame();
		// 1. Set the default close operation of your JFrame to JFrame.EXIT_ON_CLOSE

		// 2. Add a key listener to your JFrame

		// 3. Set your frame to be visible

		frame.add(noteLabel);
		frame.setPreferredSize(new Dimension(500,500));
		frame.pack();
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if(keyCode == lastKey) return;
		lastKey = keyCode;
		System.out.println(keyCode);
		
		// 4. if keyboardRowQtoP contains keyCode...

			// 5. call playNote() with keyCode, keyboardRowQtoP, and piano as the arguments


		// 9. if keyboardRowAtoL contains keyCode...

			// 10. call playNote() with keyCode, keyboardRowAtoL, and piano as the arguments


		// 13. if keyboardRowZtoM contains keyCode...

			// 14. call playNote() with keyCode, keyboardRowZtoM, and drums as the arguments


	}

	@Override
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		lastKey = 0;
		
		// 6. if keyboardRowQtoP contains keyCode...

			// 7. call stopNote() with keyCode, keyboardRowQtoP, and piano as the arguments

		// 8. Run your program. Does it play notes when you press a key between Q and P on your keyboard?
		// 11. if keyboardRowAtoL contains keyCode...

			// 12. call stopNote() with keyCode, keyboardRowAtoL, and piano as the arguments

		
		// 15. if keyboardRowZtoM contains keyCode...

			// 16. call stopNote() with keyCode, keyboardRowZtoM, and drums as the arguments

		
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
	}
	

	public void playNote(int keyCode, ArrayList<Integer> row, int instrument) {
		final int note;
		if(row == keyboardRowAtoL) {
			note = 49+row.indexOf(keyCode);
		}
		else {
			note = 60+row.indexOf(keyCode);
		}
		if(row != keyboardRowZtoM) noteLabel.setText(getNoteName(note));
		new Thread(new Runnable() {
			public void run() {
				channels[instrument].noteOn(note, 120);
			}
		}).start();
	}
	
	public void stopNote(int keyCode, ArrayList<Integer> row, int instrument) {
		final int note;
		if(row == keyboardRowAtoL) {
			note = 49+row.indexOf(keyCode);
		}
		else {
			note = 60+row.indexOf(keyCode);
		}
		channels[instrument].noteOff(note);
	}

	private String getNoteName(int noteNumber) {
		String name = notes[((noteNumber-12) % notes.length)];
		return name;
	}
	
	void initialize() {
		try {
			synth = MidiSystem.getSynthesizer();
			synth.open();
			channels = synth.getChannels();
		} catch (MidiUnavailableException e) {
			e.printStackTrace();
		}
	}
}
