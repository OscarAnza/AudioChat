// Estas son las formas en que se deben de utilizar las clases Grabacion y Reproduccion
// Por defecto el formato de audio es .wav

// Main para grabar
public static void main(String[] args) {
    // El nombre del archivo se guarda con la fecha actual
    // Tambien se puede inicializar sin la ruta, por lo cual se genera sobre la carpeta del archivo
    /// El numero 1 hace referencia a un id, que es para distinguir los archivos de audio de un mismo dia, sino se sobreescriben
    Grabacion g = new Grabacion(1, "C:\\Users\\acer\\Desktop"); // Iniciar con la ruta

    try {
        g.init(); // Inica todos los procedimientos para grabar e inicia el hilo de grabado

        for (int i = 0; i < 10; i++) { // Este ciclo controla cuantos segundos se graban
            // Indicamos que estamos grabando; el hilo se detiene durante 1000 ms cada giro del ciclo
            // Por ejemplo si el ciclo da 10 giros, se grabaran 10 segundos
            g.grabar(); 
        }

        g.detenerGrabacion(); // Cerramos la captura de audio

    } catch (LineUnavailableException e) {
        e.printStackTrace();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}


// Main para reproducir
public static void main(String[] args) {
    // Solo iniciarlizar el objeto e ingresar la ruta del archivo y el nombre o solo el nombre
    Reproduccion r = new Reproduccion("C:\\Users\\acer\\Desktop", "[nombre del archivo de audio]");
    r.reproducir();
}