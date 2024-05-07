package org.main;

import org.blockingqueue.BlockingQueue;



public class ConnectionPool {

    private int capacity;
    private BlockingQueue<DBConnection> queue;
    ConnectionPool(int capacity)
    {
        this.capacity = capacity;
        this.queue = new BlockingQueue<>(capacity);
        this.iniPool();
    }

    private void iniPool()
    {
        for(int i=0;i<capacity;i++)
        {
            queue.add(new DBConnection());
        }
    }

    public DBConnection getConnection()
    {
        return queue.remove();
    }

    public void releaseConnection(DBConnection connection)
    {
        if(connection!=null)
        {
            queue.add(connection);
        }

    }

}
