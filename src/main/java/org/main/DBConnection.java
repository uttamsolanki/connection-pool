package org.main;

import java.util.concurrent.ThreadLocalRandom;

public class DBConnection {
    public void ExecuteQuery()
    {
        try {
            // Assume: 1000-5000 ms Time taken by query to execute
            int randomMillisec = ThreadLocalRandom.current().nextInt(1000, 5001);
            Thread.sleep(randomMillisec);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
