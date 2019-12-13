package by.javatr.task03.service;

import by.javatr.task03.model.Text;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Aleh Yemelyanchyk on 12/12/2019.
 */
public class TextServiceTest {
    private Text text = new Text();
    private TextService textService = new TextService();
    private String strText =
            "Given the powers of emergence, large human giants would be forces to reckon with.";

    @Before
    public void setUpText() {
        text.setText(strText);
    }

    @Test
    public void readTextFromFileTest() {
        Text expected = new Text("Given the powers of emergence, large human giants would be forces to reckon with.\n");
        Text actual = new Text();
        textService.readTextFromFile(actual, "Text.txt");
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = NullPointerException.class)
    public void readTextFromFileNullArgumentTest() {
        textService.readTextFromFile(null, "Text.txt");
    }

    @Test
    public void replaceCharWithAnotherCharRegexTest() {
        Text expected = new Text("GiveU the poweUs of emerUence, largU humaU gianUs woulU be forcUs to reckUn with. ");
        Text actual = new Text("Given the powers of emergence, large human giants would be forces to reckon with.");
        textService.replaceCharWithAnotherCharNoRegex(actual, 4, 'U');
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void replaceCharWithAnotherCharRegexNullTest() {
        textService.replaceCharWithAnotherCharNoRegex(null, 4, 'U');
    }

    @Test
    public void replacePaWithPoRegexTest() {
        Text expected = new Text("Pony does poning crazy");
        Text actual = new Text("Pany does paning crazy");
        textService.replacePaWithPoRegex(actual);
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void replacePaWithPoRegexNullArgumentTest() {
        textService.replacePaWithPoRegex(null);
    }

    @Test
    public void replacePaWithPoNoRegexTest() {
        Text expected = new Text("Pony does poning crazy ");
        Text actual = new Text("Pany does paning crazy");
        textService.replacePaWithPoNoRegex(actual);
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void replacePaWithPoNoRegexNullArgumentTest() {
        textService.replacePaWithPoNoRegex(null);
    }

    @Test
    public void replaceWordWithSubstringRegexTest() {
        Text expected = new Text("Please, replace words: one, one and one.");
        Text actual = new Text("Please, replace words: four, five and nine.");
        textService.replaceWordWithSubstringRegex(actual, 4, "one");
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void replaceWordWithSubstringTextNullTest() {
        textService.replaceWordWithSubstringRegex(null, 4, "one");
    }

    @Test(expected = IllegalArgumentException.class)
    public void replaceWordWithSubstringRegexSubstringNullTest() {
        Text expected = new Text("Please, replace words: four, five and nine.");
        textService.replaceWordWithSubstringRegex(expected, 4, null);
    }

    @Test
    public void removeAllNonWhitespaceCharRegexTest() {
        Text expected = new Text("       ");
        Text actual = new Text("Please, remove all the characters, but whitespaces here");
        textService.removeAllNonWhitespaceCharRegex(actual);
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeAllNonWhitespaceCharRegexNullArgumentTest() {
        textService.removeAllNonWhitespaceCharRegex(null);
    }

    @Test
    public void removeAllNonWhitespaceCharNoRegexTest() {
        Text expected = new Text("        ");
        Text actual = new Text("Please, remove all the characters, but whitespaces here");
        textService.removeAllNonWhitespaceCharNoRegex(actual);
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeAllNonWhitespaceCharNoRegexNullArgumentTest() {
        textService.removeAllNonWhitespaceCharNoRegex(null);
    }

    @Test
    public void removeWordsRegexTest() {
        Text expected = new Text("Given the  of answer, large animal  will be  to  with.");
        Text actual = new Text("Given the powers of answer, large animal giants will be forces to reckon with.");
        textService.removeWordsRegex(actual, 6);
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeWordsRegexNullArgumentTest() {
        textService.removeWordsRegex(null, 0);
    }

    @Test
    public void removeWordsNoRegexTest() {
        Text expected = new Text("Given the of answer, large animal will be to with. ");
        Text actual = new Text("Given the powers of answer, large animal giants will be forces to reckon with.");
        textService.removeWordsNoRegex(actual, 6);
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeWordsNoRegexNullArgumentTest() {
        textService.removeWordsNoRegex(null, 0);
    }
}