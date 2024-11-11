package seedu.duke.flashutils.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.duke.flashutils.commands.*;
import seedu.duke.flashutils.types.FlashBook;
import seedu.duke.flashutils.types.FlashCardSet;

import static org.junit.jupiter.api.Assertions.*;

public class ParserTest {

    private FlashBook flashBook;

    @BeforeEach
    public void setUp() {
        flashBook = FlashBook.getInstance();
        FlashCardSet sampleSet = new FlashCardSet("SampleModule");
    }

    @Test
    public void testParseAddCommand() {
        String input = "add --m SampleModule --q What is Java? --a A programming language.";
        Command command = Parser.parseCommand(input);
        assertInstanceOf(AddCommand.class, command);

        AddCommand addCommand = (AddCommand) command;
        assertEquals("SampleModule", addCommand.getTargetSet().getModuleName());
        assertEquals("What is Java?", addCommand.getCardToAdd().getQuestion());
        assertEquals("A programming language.", addCommand.getCardToAdd().getAnswer());
    }

    @Test
    public void testParseViewCommand() {
        String input = "view --m SampleModule";
        Command command = Parser.parseCommand(input);
        assertInstanceOf(ViewCommand.class, command);

        ViewCommand viewCommand = (ViewCommand) command;
        assertEquals("SampleModule", viewCommand.getTargetSet().getModuleName());
    }

    @Test
    public void testParseFlashbangCommand() {
        String input = "flashbang --m SampleModule ";
        Command command = Parser.parseCommand(input);
        assertInstanceOf(FlashbangCommand.class, command);

        FlashbangCommand flashbangCommand = (FlashbangCommand) command;
        assertEquals("SampleModule", flashbangCommand.getTargetSet().getModuleName());
    }

    @Test
    public void testParseQuitCommand() {
        String input = "quit";
        Command command = Parser.parseCommand(input);
        assertInstanceOf(QuitCommand.class, command);
    }

    @Test
    public void testParseInvalidCommand() {
        String input = "invalid --m SampleModule";
        Command command = Parser.parseCommand(input);
        assertInstanceOf(InvalidCommand.class, command);
    }

    @Test
    public void testParseSearchCommand() {
        String input = "search --m SampleModule --s SearchTerm";
        Command command = Parser.parseCommand(input);
        assertInstanceOf(SearchCommand.class, command);

    }
}
