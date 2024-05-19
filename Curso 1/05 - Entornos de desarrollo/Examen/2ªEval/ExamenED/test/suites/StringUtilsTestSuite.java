package suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Roldán Sanchis Martínez
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ed.StringUtilsNotNullTest.class,ed.StringUtilsNullTest.class})
public class StringUtilsTestSuite {
    
}
