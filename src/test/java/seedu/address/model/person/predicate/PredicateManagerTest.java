package seedu.address.model.person.predicate;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;;
import java.util.HashSet;

import org.junit.Test;

import seedu.address.logic.commands.SearchCommand;
import seedu.address.testutil.PersonBuilder;

public class PredicateManagerTest {

    @Test
    public void test_returnsTrue() {
        // always return true
        PredicateManager predicate = new PredicateManager();
        assertTrue(predicate.test(new PersonBuilder().build()));
    }

    /**
     * Parses {@code userInput} into a {@code NameContainsKeywordsPredicate}.
     */
    private SearchCommand.PredicatePersonDescriptor preparePredicatePersonDescriptor(String userInput) {
        SearchCommand.PredicatePersonDescriptor descriptor = new SearchCommand.PredicatePersonDescriptor();
        descriptor.setName(new HashSet<>(Arrays.asList(userInput.split("\\s+"))));
        return descriptor;
    }
}
