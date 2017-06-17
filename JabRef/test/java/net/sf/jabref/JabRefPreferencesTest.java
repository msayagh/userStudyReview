package net.sf.jabref;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class JabRefPreferencesTest {

    private JabRefPreferences prefs;


    @Before
    public void setUp() {
        prefs = JabRefPreferences.getInstance();
    }

    @Test
    public void testPreferencesImport() throws IOException {
        // the primary sort field has been changed to "editor" in this case
        File importFile = new File("src/test/resources/net/sf/jabref/customPreferences.xml");

        prefs.importPreferences(importFile.getAbsolutePath());

        String expected = "editor";
        String actual = JabRefPreferences.getInstance().getSavePriSort();
        
        //clean up preferences to default state
        JabRefPreferences.getInstance().setSavePriSort("author");

        assertEquals(expected, actual);
    }

}
