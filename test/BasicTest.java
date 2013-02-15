import org.junit.*;
import java.util.*;
import play.test.*;
import models.*;

public class BasicTest extends UnitTest {

	@Before
	public void setup() {
		Fixtures.deleteDatabase();
		Fixtures.loadModels("data.yml");
	}

    @Test
    public void createAndRetrieveStructure() {
        // retreive saved structure
        Structure primera = Structure.find("byName", "primera estructura").first();

        // test
        assertNotNull(primera);
        assertEquals("primera estructura", primera.name);
    }
}
