package suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import tests.SistemaSeuBarriga.AccountTests;
import tests.SistemaSeuBarriga.LoginTests;
import tests.SistemaSeuBarriga.MovementTest;

@RunWith(Suite.class)
@SuiteClasses({ 
	LoginTests.class, 
	AccountTests.class, 
	MovementTest.class,

})
public class SuiteTeste {

}