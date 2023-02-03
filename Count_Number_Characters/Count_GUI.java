/*Implement this program using a graphical user interface and update the character counter every time a key is pressed. */

package Count_Number_Characters;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Count_GUI extends Count_characters {
    public static void main(String[] args) {
        // text area for input string with browse button to select file to read from txt
        // file and count characters
        JFrame frame = new JFrame("Count Characters");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(new GridLayout(0, 2));

        JLabel inputLabel = new JLabel("Input String:");
        panel.add(inputLabel);
        JTextArea inputArea = new JTextArea();
        panel.add(inputArea);

        JButton browseButton = new JButton("Browse");
        panel.add(browseButton);

        browseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
                FileNameExtensionFilter filter = new FileNameExtensionFilter("*.txt", "txt");
                fileChooser.addChoosableFileFilter(filter);
                int result = fileChooser.showOpenDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    try {
                        Scanner sc = new Scanner(selectedFile);
                        while (sc.hasNextLine()) {
                            String line = sc.nextLine();
                            inputArea.append(line);

                        }

                    } catch (FileNotFoundException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });

        JLabel outputLabel = new JLabel("Output String:");
        panel.add(outputLabel);
        JTextArea outputArea = new JTextArea();
        panel.add(outputArea);

        // count button to count characters, words, sentences, and paragraphs
        JButton countButton = new JButton("Count");
        panel.add(countButton);

        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputArea.getText();
                int characters = countCharacters(input);
                int words = countWords(input);
                int sentences = countSentences(input);
                int paragraphs = countParagraphs(input);
                outputArea.setText("Characters: " + characters + " Words: " + words + " Sentences: " + sentences
                        + " Paragraphs: " + paragraphs);

            }
        });

    }

    protected static int countCharacters(String input) {
        return input.length();
    }

    protected static int countWords(String input) {
        String[] words = input.split("\\s+");
        return words.length;
    }

    protected static int countSentences(String input) {
        String[] sentences = input.split("[!?.:]+");
        return sentences.length;
    }

    protected static int countParagraphs(String input) {
        String[] paragraphs = input.split("\\r?\\n\\r?\\n");
        return paragraphs.length;
    }

}