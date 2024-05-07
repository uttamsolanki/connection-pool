package org.main;


import org.blockingqueue.BlockingQueue;

public class Main {
    public static void main(String[] args) {

        ConnectionPool pool = new ConnectionPool(10);
        for(int i=1;i<100;i++)
        {
            new Thread(new RequestHandler(pool,i)).start();
        }
    }
}