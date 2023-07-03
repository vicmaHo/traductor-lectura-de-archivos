import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
public class App extends JFrame implements ActionListener {
    FileManager fileManager = new FileManager();
    Container container;
    FlowLayout flowLayout;
    JTextField textSpanish, textEnglish;
    JButton buttonTranslate, chooseTranslationsFile;

    public App(){
        setTitle("Translate");
        container = getContentPane();
        flowLayout = new FlowLayout();
        container.setLayout(flowLayout);

        textSpanish = new JTextField(10);
        container.add(textSpanish);
        textSpanish.setEditable(false);

        textEnglish = new JTextField(10);
        container.add(textEnglish);
        textEnglish.setEditable(false);

        buttonTranslate = new JButton("Translate");
        container.add(buttonTranslate);
        buttonTranslate.addActionListener(this);

        chooseTranslationsFile = new JButton("Choose Translations");
        container.add(chooseTranslationsFile);
        chooseTranslationsFile.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 200);
        setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        App app = new App();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Selecciono el arhcivo de traducciones
        if (e.getSource() == chooseTranslationsFile){
            fileManager.chooseFile();
            textSpanish.setEditable(true);
        }
        if(e.getSource() == buttonTranslate){
            String spanishWord = textSpanish.getText();
            textEnglish.setText(fileManager.readFileAndTranslateWord(spanishWord));
        }
    }
}
