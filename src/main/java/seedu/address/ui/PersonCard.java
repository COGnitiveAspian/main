package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.person.Person;

/**
 * An UI component that displays information of a {@code Person}.
 */
public class PersonCard extends UiPart<Region> {

    private static final String FXML = "PersonListCard.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on AddressBook level 4</a>
     */

    public final Person person;

    @FXML
    private HBox cardPane;
    @FXML
    private Label name;
    @FXML
    private Label id;
    @FXML
    private Label phone;
    @FXML
    private Label nric;
    @FXML
    private Label gender;
    @FXML
    private Label race;
    @FXML
    private Label address;
    @FXML
    private Label email;
    @FXML
    private Label school;
    @FXML
    private Label major;
    @FXML
    private Label grade;
    @FXML
    private FlowPane pastjobs;
    @FXML
    private FlowPane jobsApply;
    @FXML
    private Label interviewScores;
    @FXML
    private FlowPane tags;

    public PersonCard(Person person, int displayedIndex) {
        super(FXML);
        this.person = person;
        id.setText(displayedIndex + ". ");
        name.setText(person.getName().fullName);
        phone.setText(person.getPhone().value);
        nric.setText(person.getNric().value);
        gender.setText(person.getGender().value);
        race.setText(person.getRace().value);
        address.setText(person.getAddress().value);
        email.setText(person.getEmail().value);
        school.setText(person.getSchool().value);
        major.setText(person.getMajor().value);
        grade.setText(person.getGrade().value);
        interviewScores.setText(person.getInterviewScores().value);
        person.getPastJobs().forEach(pastjob -> pastjobs.getChildren().add(new Label(pastjob.value)));
        person.getJobsApply().forEach(jobApply -> jobsApply.getChildren().add(new Label(jobApply.value)));
        person.getTags().forEach(tag -> tags.getChildren().add(new Label(tag.tagName)));
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof PersonCard)) {
            return false;
        }

        // state check
        PersonCard card = (PersonCard) other;
        return id.getText().equals(card.id.getText())
                && person.equals(card.person);
    }
}
