package seedu.address.logic.commands;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_GENDER;
import static seedu.address.logic.parser.CliSyntax.PREFIX_GRADE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_INTERVIEWSCORES;
import static seedu.address.logic.parser.CliSyntax.PREFIX_JOBNAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_JOBSAPPLY;
import static seedu.address.logic.parser.CliSyntax.PREFIX_KNOWNPROGLANG;
import static seedu.address.logic.parser.CliSyntax.PREFIX_MAJOR;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NRIC;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PASTJOB;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_RACE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_SCHOOL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.CommandHistory;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.AddressBook;
import seedu.address.model.Model;
import seedu.address.model.job.Job;
import seedu.address.model.person.Person;
import seedu.address.model.person.predicate.NameContainsKeywordsPredicate;
import seedu.address.testutil.EditPersonDescriptorBuilder;

/**
 * Contains helper methods for testing commands.
 */
public class CommandTestUtil {

    public static final String VALID_NAME_AMY = "Amy Bee";
    public static final String VALID_NAME_BOB = "Bob Choo";
    public static final String VALID_PHONE_AMY = "11111111";
    public static final String VALID_PHONE_BOB = "22222222";
    public static final String VALID_EMAIL_AMY = "amy@example.com";
    public static final String VALID_EMAIL_BOB = "bob@example.com";
    public static final String VALID_NRIC_AMY = "S9111111A";
    public static final String VALID_NRIC_BOB = "S9000000B";
    public static final String VALID_GENDER_AMY = "Female";
    public static final String VALID_GENDER_BOB = "Male";
    public static final String VALID_RACE_AMY = "Others";
    public static final String VALID_RACE_BOB = "Indian";
    public static final String VALID_ADDRESS_AMY = "Block 312, Amy Street 1";
    public static final String VALID_ADDRESS_BOB = "Block 123, Bobby Street 3";
    public static final String VALID_SCHOOL_AMY = "NUS";
    public static final String VALID_SCHOOL_BOB = "NTU";
    public static final String VALID_MAJOR_AMY = "Computer Science";
    public static final String VALID_MAJOR_BOB = "MATH";
    public static final String VALID_GRADE_AMY = "4.12";
    public static final String VALID_GRADE_BOB = "4.00";
    public static final String VALID_KNOWNPROGLANG_PYTHON = "Python";
    public static final String VALID_KNOWNPROGLANG_JAVA = "Java";
    public static final String VALID_PASTJOB_PROFESSSOR = "Professor";
    public static final String VALID_PASTJOB_SDE = "SDE";
    public static final String VALID_JOBSAPPLY_TRADER = "Trader";
    public static final String VALID_JOBSAPPLY_ENGINEER = "Engineer";
    public static final String VALID_INTERVIEWSCORES_AMY = "10,9,10,9,10";
    public static final String VALID_INTERVIEWSCORES_BOB = "10,10,10,9,9";
    public static final String VALID_TAG_HUSBAND = "husband";
    public static final String VALID_TAG_FRIEND = "friend";
    public static final String VALID_JOB_NAME_SE = "Search Engineer";
    public static final String VALID_JOB_NAME_TEACHER = "Teacher";

    public static final String NAME_DESC_AMY = " " + PREFIX_NAME + VALID_NAME_AMY;
    public static final String NAME_DESC_BOB = " " + PREFIX_NAME + VALID_NAME_BOB;
    public static final String PHONE_DESC_AMY = " " + PREFIX_PHONE + VALID_PHONE_AMY;
    public static final String PHONE_DESC_BOB = " " + PREFIX_PHONE + VALID_PHONE_BOB;
    public static final String EMAIL_DESC_AMY = " " + PREFIX_EMAIL + VALID_EMAIL_AMY;
    public static final String EMAIL_DESC_BOB = " " + PREFIX_EMAIL + VALID_EMAIL_BOB;
    public static final String NRIC_DESC_AMY = " " + PREFIX_NRIC + VALID_NRIC_AMY;
    public static final String NRIC_DESC_BOB = " " + PREFIX_NRIC + VALID_NRIC_BOB;
    public static final String GENDER_DESC_AMY = " " + PREFIX_GENDER + VALID_GENDER_AMY;
    public static final String GENDER_DESC_BOB = " " + PREFIX_GENDER + VALID_GENDER_BOB;
    public static final String RACE_DESC_AMY = " " + PREFIX_RACE + VALID_RACE_AMY;
    public static final String RACE_DESC_BOB = " " + PREFIX_RACE + VALID_RACE_BOB;
    public static final String ADDRESS_DESC_AMY = " " + PREFIX_ADDRESS + VALID_ADDRESS_AMY;
    public static final String ADDRESS_DESC_BOB = " " + PREFIX_ADDRESS + VALID_ADDRESS_BOB;
    public static final String SCHOOL_DESC_AMY = " " + PREFIX_SCHOOL + VALID_SCHOOL_AMY;
    public static final String SCHOOL_DESC_BOB = " " + PREFIX_SCHOOL + VALID_SCHOOL_BOB;
    public static final String KNOWNPROGLANG_DESC_PYTHON = " " + PREFIX_KNOWNPROGLANG + VALID_KNOWNPROGLANG_PYTHON;
    public static final String KNOWNPROGLANG_DESC_JAVA = " " + PREFIX_KNOWNPROGLANG + VALID_KNOWNPROGLANG_JAVA;
    public static final String PASTJOB_DESC_PROFESSOR = " " + PREFIX_PASTJOB + VALID_PASTJOB_PROFESSSOR;
    public static final String PASTJOB_DESC_SDE = " " + PREFIX_PASTJOB + VALID_PASTJOB_SDE;
    public static final String MAJOR_DESC_AMY = " " + PREFIX_MAJOR + VALID_MAJOR_AMY;
    public static final String MAJOR_DESC_BOB = " " + PREFIX_MAJOR + VALID_MAJOR_BOB;
    public static final String GRADE_DESC_AMY = " " + PREFIX_GRADE + VALID_GRADE_AMY;
    public static final String GRADE_DESC_BOB = " " + PREFIX_GRADE + VALID_GRADE_BOB;
    public static final String JOBSAPPLY_DESC_TRADER = " " + PREFIX_JOBSAPPLY + VALID_JOBSAPPLY_TRADER;
    public static final String JOBSAPPLY_DESC_ENGINEER = " " + PREFIX_JOBSAPPLY + VALID_JOBSAPPLY_ENGINEER;
    public static final String INTERVIEWSCORES_DESC_AMY = " " + PREFIX_INTERVIEWSCORES + VALID_INTERVIEWSCORES_AMY;
    public static final String INTERVIEWSCORES_DESC_BOB = " " + PREFIX_INTERVIEWSCORES + VALID_INTERVIEWSCORES_BOB;
    public static final String TAG_DESC_FRIEND = " " + PREFIX_TAG + VALID_TAG_FRIEND;
    public static final String TAG_DESC_HUSBAND = " " + PREFIX_TAG + VALID_TAG_HUSBAND;
    public static final String JOBNAME_SE = " " + PREFIX_JOBNAME + VALID_JOB_NAME_SE;
    public static final String JOBNAME_TEACHER = " " + PREFIX_JOBNAME + VALID_JOB_NAME_TEACHER;

    public static final String INVALID_NAME_DESC = " " + PREFIX_NAME + "James&"; // '&' not allowed in names
    public static final String INVALID_PHONE_DESC = " " + PREFIX_PHONE + "911a"; // 'a' not allowed in phones
    public static final String INVALID_EMAIL_DESC = " " + PREFIX_EMAIL + "bob!yahoo"; // missing '@' symbol
    public static final String INVALID_NRIC_DESC = " " + PREFIX_NRIC + "9213113A"; // missing 'S' character
    public static final String INVALID_GENDER_DESC = " " + PREFIX_GENDER; // empty string not allowed for gender
    public static final String INVALID_RACE_DESC = " " + PREFIX_RACE; // empty string not allowed for race
    public static final String INVALID_ADDRESS_DESC = " " + PREFIX_ADDRESS; // empty string not allowed for addresses
    public static final String INVALID_SCHOOL_DESC = " " + PREFIX_SCHOOL; // empty string not allowed for school
    public static final String INVALID_PASTJOB_DESC = " " + PREFIX_PASTJOB; // empty string not allowed for past job
    public static final String INVALID_MAJOR_DESC = " " + PREFIX_MAJOR + "^^"; //symbols not allowed
    public static final String INVALID_GRADE_DESC = " " + PREFIX_GRADE + "4.2"; // 1 decimal place not allowed
    public static final String INVALID_KNOWNPROGLANG_DESC = " " + PREFIX_KNOWNPROGLANG + "  "; //blank not allowed
    public static final String INVALID_JOBSAPPLY_DESC = " " + PREFIX_JOBSAPPLY + " "; //blank not allowed
    public static final String INVALID_INTERVIEWSCORES_DESC = " " + PREFIX_INTERVIEWSCORES + " ";
    // empty string not allowed for interview scores
    public static final String INVALID_TAG_DESC = " " + PREFIX_TAG + "hubby*"; // '*' not allowed in tags
    public static final String INVALID_JOBNAME = " " + PREFIX_JOBNAME + "$#@#@$*"; // only letters allowed

    public static final String PREAMBLE_WHITESPACE = "\t  \r  \n";
    public static final String PREAMBLE_NON_EMPTY = "NonEmptyPreamble";

    public static final EditCommand.EditPersonDescriptor DESC_AMY;
    public static final EditCommand.EditPersonDescriptor DESC_BOB;

    static {
        DESC_AMY = new EditPersonDescriptorBuilder().withName(VALID_NAME_AMY)
                .withPhone(VALID_PHONE_AMY).withEmail(VALID_EMAIL_AMY).withNric(VALID_NRIC_AMY)
                .withGender(VALID_GENDER_AMY).withRace(VALID_RACE_AMY).withAddress(VALID_ADDRESS_AMY)
                .withSchool(VALID_SCHOOL_AMY).withMajor(VALID_MAJOR_AMY).withGrade(VALID_GRADE_AMY)
                .withPastJobs(VALID_PASTJOB_PROFESSSOR).withKnownProgLang(VALID_KNOWNPROGLANG_PYTHON)
                .withJobsApply(VALID_JOBSAPPLY_TRADER).withInterviewScores(VALID_INTERVIEWSCORES_AMY)
                .withTags(VALID_TAG_FRIEND).build();
        DESC_BOB = new EditPersonDescriptorBuilder().withName(VALID_NAME_BOB).withPhone(VALID_PHONE_BOB)
                .withEmail(VALID_EMAIL_BOB).withNric(VALID_NRIC_BOB).withGender(VALID_GENDER_BOB)
                .withRace(VALID_RACE_BOB).withAddress(VALID_ADDRESS_BOB).withSchool(VALID_SCHOOL_BOB)
                .withMajor(VALID_MAJOR_BOB).withGrade(VALID_GRADE_BOB)
                .withPastJobs(VALID_PASTJOB_SDE).withKnownProgLang(VALID_KNOWNPROGLANG_JAVA)
                .withJobsApply(VALID_JOBSAPPLY_ENGINEER).withInterviewScores(VALID_INTERVIEWSCORES_BOB)
                .withTags(VALID_TAG_HUSBAND, VALID_TAG_FRIEND).build();

    }

    /**
     * Executes the given {@code command}, confirms that <br>
     * - the returned {@link CommandResult} matches {@code expectedCommandResult} <br>
     * - the {@code actualModel} matches {@code expectedModel} <br>
     * - the {@code actualCommandHistory} remains unchanged.
     */
    public static void assertCommandSuccess(Command command, Model actualModel, CommandHistory actualCommandHistory,
                                            CommandResult expectedCommandResult, Model expectedModel) {
        CommandHistory expectedCommandHistory = new CommandHistory(actualCommandHistory);
        try {
            CommandResult result = command.execute(actualModel, actualCommandHistory);
            assertEquals(expectedCommandResult, result);
            assertEquals(expectedModel, actualModel);
            assertEquals(expectedCommandHistory, actualCommandHistory);
        } catch (CommandException ce) {
            throw new AssertionError("Execution of command should not fail.", ce);
        }
    }

    /**
     * Convenience wrapper to {@link #assertCommandSuccess(Command, Model, CommandHistory, CommandResult, Model)}
     * that takes a string {@code expectedMessage}.
     */
    public static void assertCommandSuccess(Command command, Model actualModel, CommandHistory actualCommandHistory,
                                            String expectedMessage, Model expectedModel) {
        CommandResult expectedCommandResult = new CommandResult(expectedMessage);
        assertCommandSuccess(command, actualModel, actualCommandHistory, expectedCommandResult, expectedModel);
    }

    /**
     * Executes the given {@code command}, confirms that <br>
     * - a {@code CommandException} is thrown <br>
     * - the CommandException message matches {@code expectedMessage} <br>
     * - the address book, filtered person list and selected person in {@code actualModel} remain unchanged <br>
     * - {@code actualCommandHistory} remains unchanged.
     */
    public static void assertCommandFailure(Command command, Model actualModel, CommandHistory actualCommandHistory,
                                            String expectedMessage) {
        // we are unable to defensively copy the model for comparison later, so we can
        // only do so by copying its components.
        AddressBook expectedAddressBook = new AddressBook(actualModel.getAddressBook());
        List<Person> expectedFilteredList = new ArrayList<>(actualModel.getFilteredPersonList());
        Person expectedSelectedPerson = actualModel.getSelectedPerson();

        CommandHistory expectedCommandHistory = new CommandHistory(actualCommandHistory);

        try {
            command.execute(actualModel, actualCommandHistory);
            throw new AssertionError("The expected CommandException was not thrown.");
        } catch (CommandException e) {
            assertEquals(expectedMessage, e.getMessage());
            assertEquals(expectedAddressBook, actualModel.getAddressBook());
            assertEquals(expectedFilteredList, actualModel.getFilteredPersonList());
            assertEquals(expectedSelectedPerson, actualModel.getSelectedPerson());
            assertEquals(expectedCommandHistory, actualCommandHistory);
        }
    }

    /**
     * Updates {@code model}'s filtered list to show only the person at the given {@code targetIndex} in the
     * {@code model}'s address book.
     */
    public static void showPersonAtIndex(Model model, Index targetIndex) {
        assertTrue(targetIndex.getZeroBased() < model.getFilteredPersonList().size());

        Person person = model.getFilteredPersonList().get(targetIndex.getZeroBased());
        final String[] splitName = person.getName().fullName.split("\\s+");
        model.updateBaseFilteredPersonList(new NameContainsKeywordsPredicate(Arrays.asList(splitName[0])));

        assertEquals(1, model.getFilteredPersonList().size());
    }

    /**
     * Deletes the first person in {@code model}'s filtered list from {@code model}'s address book.
     */
    public static void deleteFirstPerson(Model model) {
        Person firstPerson = model.getFilteredPersonList().get(0);
        model.deletePerson(firstPerson);
        model.commitAddressBook();
    }

    /**
     * Deletes the first job in {@code model}'s filtered list from {@code model}'s address book.
     */
    public static void deleteFirstJob(Model model) {
        Job firstJob = model.getFilteredJobList().get(0);
        model.deleteJob(firstJob);

    }

}
