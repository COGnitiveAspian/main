package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_GENDER;
import static seedu.address.logic.parser.CliSyntax.PREFIX_GRADE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_INTERVIEWSCORES;
import static seedu.address.logic.parser.CliSyntax.PREFIX_JOBSAPPLY;
import static seedu.address.logic.parser.CliSyntax.PREFIX_MAJOR;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NRIC;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_RACE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_SCHOOL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;

import seedu.address.logic.CommandHistory;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.Person;

/**
 * Adds a person to the address book.
 */
public class AddCommand extends Command {

    public static final String COMMAND_WORD = "add";
    public static final String COMMAND_ALIAS = "a";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a person to the address book. "
            + "Parameters: "
            + PREFIX_NAME + "NAME "
            + PREFIX_PHONE + "PHONE "
            + PREFIX_EMAIL + "EMAIL "
            + PREFIX_NRIC + "NRIC "
            + PREFIX_GENDER + "GENDER "
            + PREFIX_RACE + "RACE "
            + PREFIX_ADDRESS + "ADDRESS "
            + PREFIX_SCHOOL + "SCHOOL "
            + PREFIX_MAJOR + "MAJOR "
            + PREFIX_GRADE + "GRADE "
            + PREFIX_JOBSAPPLY + "JOBSAPPLY "
            + PREFIX_INTERVIEWSCORES + "INTERVIEWSCORES "
            + "[" + PREFIX_TAG + "TAG]...\n"
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_NAME + "John Doe "
            + PREFIX_PHONE + "98765432 "
            + PREFIX_EMAIL + "johnd@example.com "
            + PREFIX_NRIC + "S9671597H "
            + PREFIX_GENDER + "Male "
            + PREFIX_RACE + "Indian "
            + PREFIX_ADDRESS + "311, Clementi Ave 2, #02-25 "
            + PREFIX_SCHOOL + "NUS "
            + PREFIX_MAJOR + "Computer Science "
            + PREFIX_GRADE + "4.76 "
            + PREFIX_JOBSAPPLY + "Software Engineer "
            + PREFIX_INTERVIEWSCORES + "1,2,3,4,5 "
            + PREFIX_TAG + "friends "
            + PREFIX_TAG + "owesMoney\n"
            + "The alias \"a\" can be used instead.\n"
            + "Example: " + COMMAND_ALIAS + " "
            + PREFIX_NAME + "John Doe "
            + PREFIX_PHONE + "98765432 "
            + PREFIX_EMAIL + "johnd@example.com "
            + PREFIX_NRIC + "S9671597H "
            + PREFIX_GENDER + "Male "
            + PREFIX_RACE + "Indian "
            + PREFIX_ADDRESS + "311, Clementi Ave 2, #02-25 "
            + PREFIX_SCHOOL + "NUS "
            + PREFIX_MAJOR + "Computer Science "
            + PREFIX_GRADE + "4.76 "
            + PREFIX_JOBSAPPLY + "Software Engineer "
            + PREFIX_INTERVIEWSCORES + "1,2,3,4,5 "
            + PREFIX_TAG + "friends "
            + PREFIX_TAG + "owesMoney\n";

    public static final String MESSAGE_SUCCESS = "New person added: %1$s";
    public static final String MESSAGE_DUPLICATE_PERSON = "This person already exists in the address book";

    private final Person toAdd;

    /**
     * Creates an AddCommand to add the specified {@code Person}
     */
    public AddCommand(Person person) {
        requireNonNull(person);
        toAdd = person;
    }

    @Override
    public CommandResult execute(Model model, CommandHistory history) throws CommandException {
        requireNonNull(model);

        if (model.hasPerson(toAdd)) {
            throw new CommandException(MESSAGE_DUPLICATE_PERSON);
        }

        model.addPerson(toAdd);
        model.commitAddressBook();
        return new CommandResult(String.format(MESSAGE_SUCCESS, toAdd));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AddCommand // instanceof handles nulls
                && toAdd.equals(((AddCommand) other).toAdd));
    }
}
