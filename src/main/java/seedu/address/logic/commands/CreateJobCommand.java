package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_JOBNAME;

import seedu.address.logic.CommandHistory;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

/**
 * Adds a person to the address book.
 */
public class CreateJobCommand extends Command {

    public static final String COMMAND_WORD = "createjob";
    public static final String COMMAND_ALIAS = "cj";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a new job. "
            + "Parameters: "
            + PREFIX_JOBNAME + "NAME "
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_JOBNAME + "Search Engineer "
            + "The alias \"cj\" can be used instead.\n"
            + "Example: " + COMMAND_ALIAS + " "
            + PREFIX_JOBNAME + "Search Engineer ";

    public static final String MESSAGE_SUCCESS = "New job added: %1$s";
    public static final String MESSAGE_DUPLICATE_PERSON = "This job already exists in the system";

    private final Job toAdd;

    /**
     * Creates an AddCommand to add the specified {@code Job}
     */
    public CreateJobCommand(Job job) {
        requireNonNull(job);
        toAdd = job;
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
                || (other instanceof CreateJobCommand // instanceof handles nulls
                && toAdd.equals(((CreateJobCommand) other).toAdd));
    }
}
