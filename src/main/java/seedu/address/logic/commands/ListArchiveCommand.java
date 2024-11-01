package seedu.address.logic.commands;

import static seedu.address.model.ModelManager.isArchivedList;
import static java.util.Objects.requireNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_PERSONS;

import seedu.address.model.Model;
import seedu.address.ui.MainWindow;

public class ListArchiveCommand extends Command {
    public static final String COMMAND_WORD = "archive-list";
    public static final String MESSAGE_SUCCESS = "Listed all archived persons";

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        isArchivedList = true;
        model.setArchivedListMode(true);
        model.updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
