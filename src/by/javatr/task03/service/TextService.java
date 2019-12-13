package by.javatr.task03.service;

import by.javatr.reader.FileService;
import by.javatr.scanner.DataScanner;
import by.javatr.task03.model.Text;
import by.javatr.task03.service.validation.TextServiceValidationUtils;

import java.io.FileNotFoundException;

/**
 * @author Aleh Yemelyanchyk on 12/9/2019.
 */
public class TextService {
    private FileService fileService = new FileService();
    private DataScanner dataScanner = new DataScanner();

    public void readTextFromFile(Text text, String fileName) {
        try {
            text.setText(fileService.readTextFromFile(fileName));
        } catch (FileNotFoundException e) {
            text.setText("");
        }
    }

    public void readTextFromConsole(Text text) {
        text.setText(dataScanner.readString());
    }

    public Text replaceCharWithAnotherCharNoRegex(Text text, int position, char replacement) throws IllegalArgumentException {
        if (!TextServiceValidationUtils.isTextNull(text)) {
            throw new IllegalArgumentException("Text can not be null");
        }
        String stringText = text.getText();
        String[] words = stringText.split(" ");
        for (int i = 0; i < words.length; i++) {
            int lengthMinus = (finishWithPunctuation(words[i].charAt(words[i].length() - 1))) ? 1 : 0;
            if (words[i].length() > 0 && (words[i].length() - lengthMinus) > position) {
                words[i] = replaceChar(words[i], position, replacement);
            }
        }
        text.setText(stringFromWords(words));
        return text;
    }

    public Text replacePaWithPoRegex(Text text) throws IllegalArgumentException {
        if (!TextServiceValidationUtils.isTextNull(text)) {
            throw new IllegalArgumentException("Text can not be null");
        }
        String stringText = text.getText();
        stringText = stringText.replaceAll("(?<=[Pp])a", "o");
        text.setText(stringText);
        return text;
    }

    public Text replacePaWithPoNoRegex(Text text) throws IllegalArgumentException {
        if (!TextServiceValidationUtils.isTextNull(text)) {
            throw new IllegalArgumentException("Text can not be null");
        }
        String stringText = text.getText();
        String[] words = stringText.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0) {
                words[i] = replaceChar(words[i]);
            }
        }
        text.setText(stringFromWords(words));
        return text;
    }

    public Text replaceWordWithSubstringRegex(Text text, int wordLength, String substring) {
        if (!TextServiceValidationUtils.isTextNull(text)) {
            throw new IllegalArgumentException("Text can not be null");
        } else if (!TextServiceValidationUtils.isSubstringNull(substring)) {
            throw new IllegalArgumentException("Substring can not be null");
        }
        String stringText = text.getText();
        stringText = stringText.replaceAll("\\b[\\w]{" + wordLength + "}\\b", substring);
        text.setText(stringText);
        return text;
    }

    public Text removeAllNonWhitespaceCharRegex(Text text) {
        if (!TextServiceValidationUtils.isTextNull(text)) {
            throw new IllegalArgumentException("Text can not be null");
        }
        String stringText = text.getText();
        stringText = stringText.replaceAll("[^\\s]", "");
        text.setText(stringText);
        return text;
    }

    public Text removeAllNonWhitespaceCharNoRegex(Text text) {
        if (!TextServiceValidationUtils.isTextNull(text)) {
            throw new IllegalArgumentException("Text can not be null");
        }
        String stringText = text.getText();
        String[] words = stringText.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0) {
                words[i] = words[i].replace((words[i]), "");
            }
        }
        text.setText(stringFromWords(words));
        return text;
    }

    public Text removeWordsRegex(Text text, int wordLength) {
        if (!TextServiceValidationUtils.isTextNull(text)) {
            throw new IllegalArgumentException("Text can not be null");
        }
        String stringText = text.getText();
        stringText = stringText.replaceAll("\\b[^aeiouAEIOU][\\w]{" + (wordLength - 1) + "}\\b", "");
        text.setText(stringText);
        return text;
    }

    public Text removeWordsNoRegex(Text text, int wordLength) {
        if (!TextServiceValidationUtils.isTextNull(text)) {
            throw new IllegalArgumentException("Text can not be null");
        }
        String stringText = text.getText();
        String[] words = stringText.split(" ");
        text.setText(stringFromWordsByLength(words, wordLength));
        return text;
    }

    private String stringFromWordsByLength(String[] words, int length) {
        StringBuilder newString = new StringBuilder();
        for (String word : words) {
            if (word.length() == length && !isVowel(word.charAt(0))) {
                continue;
            }
            newString.append(word);
            newString.append(" ");
        }
        return newString.toString();
    }

    private boolean finishWithPunctuation(char ch) {
        return ".,:;!?".indexOf(ch) != -1;
    }

    private boolean isVowel(char ch) {
        return "aeiouAEIOU".indexOf(ch) != -1;
    }

    private String stringFromWords(String[] words) {
        StringBuilder newString = new StringBuilder();
        for (String word : words) {
            newString.append(word);
            newString.append(" ");
        }
        return newString.toString();
    }

    private String replaceChar(String word) {
        char[] chars = word.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == 'a' && (chars[i - 1] == 'p' || chars[i - 1] == 'P')) {
                chars[i] = 'o';
            }
        }
        return buildNewString(chars);
    }

    private String replaceChar(String word, int position, char replacement) {
        char[] chars = word.toCharArray();
        chars[position] = replacement;
        return buildNewString(chars);
    }

    private String buildNewString(char[] chars) {
        StringBuilder newString = new StringBuilder();
        for (char letter : chars) {
            newString.append(letter);
        }
        return newString.toString();
    }
}
