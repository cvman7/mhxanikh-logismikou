import static org.junit.Assert.*;

import org.junit.Test;

public class DatabaseConnectionTest {

	@Test
	public void test() {
		  DatabaseConnection a = new DatabaseConnection();
		  assertNotNull("result",a.dbConnector());		
		
	}

}
