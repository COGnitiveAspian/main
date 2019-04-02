package seedu.address.model.job;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.UniquePersonList;

/**
 * Represents a Person in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Job {

    private static final int NUMBER_OF_LISTS = 4;
    private static final String[] LIST_NAMES = {"All Applicants", "KIV", "Interview", "Shortlist"};
    // Identity fields
    private final JobName name;

    // Data fields
    private ArrayList<UniquePersonList> personsHash = new ArrayList<> (NUMBER_OF_LISTS);
    private ArrayList<ArrayList<Person>> personsList = new ArrayList<>(NUMBER_OF_LISTS);


    /**
     * Every field must be present and not null.
     */
    public Job(JobName name) {
        requireAllNonNull(name);

        this.name = name;
        for (int i = 0; i < 4; i++) {
            personsHash.add(new UniquePersonList());
            personsList.add(new ArrayList<>());
        }
    }

    public JobName getName() {
        return name;
    }

    /**
     * Adds all persons on displayed filter list to first list of job.
     * Only adds if not already in job.
     */
    public void addFilteredList() {

    }

    /**
     * Adds a person to a job.
     * Goes to the first list
     */
    public boolean add(Person person) {
        if (personsHash.get(0).contains(person)) {
            return false;
        }
        personsHash.get(0).add(person);
        personsList.get(0).add(person);

        return true;
    }

    /**
     * Moves a person from one list to another
     */
    public int move(Person target, Integer source, Integer dest) {

        if (!(personsHash.get(source).contains(target))) {
            return 0;
        }

        if (personsHash.get(dest).contains(target)) {
            return 1;
        }

        personsHash.get(dest).add(target);
        personsList.get(dest).add(target);
        return 2;
    }

    /**
     * Returns an immutable  people set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public final UniquePersonList getPeople(int listNumber) {
        return personsHash.get(listNumber);
    }

    public final ArrayList<Name> getPeopleNames(List<Person> peopleList) {
        ArrayList<Name> names = new ArrayList<> (peopleList.size());
        for (int i = 0; i < peopleList.size(); i++) {
            names.add(peopleList.get(i).getName());
        }
        return names;
    }

    /**
     * Returns an ArrayList of Person that can be edited but does not change the list in job directly
     */
    public final ArrayList<Person> getList(int listNumber) {
        return personsList.get(listNumber);
    }

    /**
     * Replaces a list of persons in Job
     */
    public final boolean replaceList(int listNumber, ArrayList<Person> personList) {
        if (listNumber > 3) {
            return false;
        }
        personsList.set(listNumber, personList);

        return true;
    }

    /**
     * Returns true if both jobs have the same name.
     * This defines a weaker notion of equality between two jobs.
     */
    public boolean isSameJob(Job otherJob) {
        requireNonNull(otherJob);
        if (otherJob == this) {
            return true;
        }

        return ((otherJob.getName()).equals(this.getName()));
    }

    /**
     * Returns true if both jobs have the same identity and data fields.
     * This defines a stronger notion of equality between two jobs.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Job)) {
            return false;
        }

        Job otherJob = (Job) other;
        return otherJob.getName().equals(getName());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getName());
        return builder.toString();
    }

}
