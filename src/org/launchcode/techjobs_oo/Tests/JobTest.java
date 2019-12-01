package org.launchcode.techjobs_oo.Tests;
import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import java.util.Objects;

import static org.junit.Assert.*;

public class JobTest {

    Job testClass1;
    Job testClass2;

    Job testClassFull;

    @Before
    public void Job() {
        testClass1 = new Job();
        testClass2 = new Job();

        testClassFull = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
    }

    @Test
    public void testSettingJobId() {
        int testClassOneIdPlusOne = testClass1.getId() + 1;
        assertEquals(testClassOneIdPlusOne, testClass2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        assertTrue(testClassFull instanceof Job);
        assertEquals("Product tester", testClassFull.getName());
        assertEquals("ACME", testClassFull.getEmployer().getValue());
        assertEquals("Desert", testClassFull.getLocation().getValue());
        assertEquals("Quality control", testClassFull.getPositionType().getValue());
        assertEquals("Persistence", testClassFull.getCoreCompetency().getValue());
    }

    @Test
    public void testJobForEquality() {
        Job sameJobOne = testClassFull;

        Job sameJobTwo = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        int sameJobOneId = sameJobOne.getId();
        int sameJobTwoId = sameJobTwo.getId();

        assertEquals(false, sameJobOneId == sameJobTwoId);

    }

    @Test
    public void testJobForBlankLineBeforeAndAfterObject() {
        Job testBlankLines = testClassFull;

        String testBlankLinesString = testBlankLines.toString();
        int indexOfLastChar = testBlankLinesString.length();
        int indexOfSecondToLastChar = testBlankLinesString.length() - 1;
        String lastTwoCharacters = testBlankLinesString.substring(indexOfSecondToLastChar, indexOfLastChar);

        assertEquals("\n", testBlankLinesString.substring(0, 1));
        assertEquals("\n", lastTwoCharacters);
    }

    @Test
    public void testJobForContainsAllLabels() {
        String testContainsLabel = testClassFull.toString();

        assertTrue(testContainsLabel.contains("ID: " + testClassFull.getId() + "\n"));
        assertTrue(testContainsLabel.contains("Name: " + testClassFull.getName() + "\n"));
        assertTrue(testContainsLabel.contains("Employer: " + testClassFull.getEmployer() + "\n"));
        assertTrue(testContainsLabel.contains("Location: " + testClassFull.getLocation() + "\n"));
        assertTrue(testContainsLabel.contains("Position Type: " + testClassFull.getPositionType() + "\n"));
        assertTrue(testContainsLabel.contains("Core Competency: " + testClassFull.getCoreCompetency() + "\n"));
    }

    @Test
    public void testJobForEmptyField() {
        Job emptyTestClass = new Job("", new Employer(""),
                new Location(""), new PositionType(""),
                new CoreCompetency(""));


        String emptyTestClassString = emptyTestClass.toString();

        assertTrue(emptyTestClassString.contains("Name: Data not available"));
        assertTrue(emptyTestClassString.contains("Employer: Data not available"));
        assertTrue(emptyTestClassString.contains("Location: Data not available"));
        assertTrue(emptyTestClassString.contains("Position Type: Data not available"));
        assertTrue(emptyTestClassString.contains("Core Competency: Data not available"));
    }

}