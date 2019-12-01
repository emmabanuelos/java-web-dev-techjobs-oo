package org.launchcode.techjobs_oo.Tests;
import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import java.util.Objects;

import static org.junit.Assert.*;

public class JobTest {

    JobTest testObjectOne;
    JobTest testObjectTwo;

    Job testObjectFull;


    @Before
    public void Job() {
        testObjectOne = new JobTest();
        testObjectTwo = new JobTest();
        testObjectFull = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }

    @Test
    public void testSettingJobID() {
        int testObjectOneByAddingOne = testObjectOne.getId() + 1;
        assertEquals(testObjectOneByAddingOne, testObjectTwo.getId());
    }

    private int getId() {
        return 0;
    }

    public void testJobConstructorSetsAllFields {
    assertTrue(testObjectFull instanceof Job);
    assertEquals("Product Tester", testObjectFull.getName());
    assertEquals("ACME", testObjectFull.getEmployer().getValue());
    assertEquals("Desert", testObjectFull.getLocation().getValue());
    assertEquals("Quality Control", testObjectFull.getPositionType().getValue());
    assertEquals("Persistence", testObjectFull.getCoreCompentecy().getValue());
    }

    @Test
    public void testJobForEquality() {
        Job sameJobOne = testObjectFull;

        Job sameJobTwo = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        int sameJobOneId = sameJobOne.getId();
        int sameJobTwoId = sameJobTwo.getId();

        assertEquals(false, sameJobOneId == sameJobTwoId);

    }

    @Test
    public void testJobForBlankLineBeforeAndAfterObject() {
        Job testBlankLines = testObjectFull;

        String testBlankLinesString = testBlankLines.toString();
        int indexOfLastChar = testBlankLinesString.length();
        int indexOfSecondToLastChar = testBlankLinesString.length() - 1;
        String lastTwoCharacters = testBlankLinesString.substring(indexOfSecondToLastChar, indexOfLastChar);

        assertEquals("\n", testBlankLinesString.substring(0, 1));
        assertEquals("\n", lastTwoCharacters);
    }

    @Test
    public void testJobForContainsAllLabels() {
        String testContainsLabel = testObjectFull.toString();

        assertTrue(testContainsLabel.contains("ID: " + testObjectFull.getId() + "\n"));
        assertTrue(testContainsLabel.contains("Name: " + testObjectFull.getName() + "\n"));
        assertTrue(testContainsLabel.contains("Employer: " + testObjectFull.getEmployer() + "\n"));
        assertTrue(testContainsLabel.contains("Location: " + testObjectFull.getLocation() + "\n"));
        assertTrue(testContainsLabel.contains("Position Type: " + testObjectFull.getPositionType() + "\n"));
        assertTrue(testContainsLabel.contains("Core Competency: " + testObjectFull.getCoreCompetency() + "\n"));
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

