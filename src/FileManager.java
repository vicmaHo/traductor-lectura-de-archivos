import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.StringTokenizer;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class FileManager {
    
    private String path = "";

    public void chooseFile(){
        JFileChooser fileChooser = new JFileChooser();
        int seleccion = fileChooser.showOpenDialog(null);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            // Obtener el archivo seleccionado
            File file = fileChooser.getSelectedFile();

            // Realizar operaciones con el archivo seleccionado
            System.out.println("Archivo seleccionado: " + file.getAbsolutePath());
            path = file.getAbsolutePath();
        }
    }

    // Read a file and receive a word, and return the the translated word  
    public String readFileAndTranslateWord(String word){
        try {
            RandomAccessFile file = new RandomAccessFile(path, "rw");
            String line = "";
            boolean foundWord = false; 

            while ((line = file.readLine()) != null){
                StringTokenizer tokenizer = new StringTokenizer(line, ",");
                if (tokenizer.nextToken().equals(word)){
                    foundWord = true;
                    return tokenizer.nextToken();
                }
            }
            if (foundWord == false) return "word not found";

        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Please select a translations file first.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return word;
    }
}
