package org.GrabacionChat;

import java.io.File;
import java.util.Calendar;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;

public class Grabacion {
	AudioFileFormat.Type formatoArchivo = AudioFileFormat.Type.WAVE;
	AudioFormat formatoAudio = new AudioFormat(8000.0F, 16, 1, true, false);
	TargetDataLine tD;
	File f;
	Calendar c = Calendar.getInstance();
	boolean grabando = true;

	public Grabacion(int id, String rutaDeGuardado) {
		String dia = Integer.toString(c.get(Calendar.DATE));
		String mes = Integer.toString(c.get(Calendar.MONTH));
		String annio = Integer.toString(c.get(Calendar.YEAR));

		f = new File(rutaDeGuardado + "\\" + "(" + id + ")-" + dia + "-" + mes + "-" + annio + ".wav");
	}

	public void init() throws LineUnavailableException {
		DataLine.Info dLI = new DataLine.Info(TargetDataLine.class, formatoAudio);
		tD = (TargetDataLine) AudioSystem.getLine(dLI);
		new CaptureThread().start();
	}

	public void grabar() throws InterruptedException {
		Thread.sleep(1000);
	}

	public void detenerGrabacion() {
		tD.close();
	}

	class CaptureThread extends Thread {
		public void run() {
			try {
				tD.open(formatoAudio);
				tD.start();
				AudioSystem.write(new AudioInputStream(tD), formatoArchivo, f);
			} catch (Exception e) {
			}
		}
	}
}
