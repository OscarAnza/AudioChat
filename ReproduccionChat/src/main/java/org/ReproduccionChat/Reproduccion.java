package org.ReproduccionChat;

import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Reproduccion {
	private String ruta;
	private String nombreArchivo;

	public Reproduccion(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public Reproduccion(String ruta, String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
		this.ruta = ruta;
	}

	public void reproducir() {
		try {
			// Se obtiene un Clip de sonido
			Clip sonido = AudioSystem.getClip();

			// Se carga con un fichero wav
			if (ruta == null)
				sonido.open(AudioSystem.getAudioInputStream(new File(nombreArchivo)));
			else
				sonido.open(AudioSystem.getAudioInputStream(new File(ruta + "\\" + nombreArchivo + ".wav")));

			// Comienza la reproducción
			sonido.start();
			System.out.print(""); // Pór alguna extraña razon esto es necesario
			// Pósiblemente solo sea para "despertar o activar" el thread

			// Espera mientras se esté reproduciendo.
			while (sonido.isActive()) {
				Thread.sleep(1000);
			}

			// Se cierra el clip.
			sonido.close();
		} catch (Exception e) {
			System.out.println("\n" + e);
		}
	}
}
