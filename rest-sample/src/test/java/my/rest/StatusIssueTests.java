package my.rest;

/**
 * Created by Tirex on 21.04.2016.
 */

    import org.testng.annotations.Test;

import java.io.IOException;


    public class StatusIssueTests extends TestBase {

        @Test
        public void testIssueStatus () throws IOException {

            skipIfNotFixed(8);
            System.out.println("Issue was fixed - enjoy the test :)");
            logger.info("Issue was fixed - enjoy the test");

        }

    }

