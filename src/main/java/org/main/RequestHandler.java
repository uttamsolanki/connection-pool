package org.main;

import org.blockingqueue.BlockingQueue;

public class RequestHandler implements Runnable{
    private  ConnectionPool pool;
    private int reqId;
    RequestHandler(ConnectionPool pool, Integer reqId)
    {
        this.pool = pool;
        this.reqId = reqId;
    }
    @Override
    public void run() {

        DBConnection connection = pool.getConnection();
        connection.ExecuteQuery();
        System.out.println("Request ID: "+ reqId);
        pool.releaseConnection(connection);
    }
}
