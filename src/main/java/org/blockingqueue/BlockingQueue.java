package org.blockingqueue;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue<T> {
    private int capaciy;
    private Queue<T> queue;
    public BlockingQueue(int capaciy){
        this.capaciy = capaciy;
        this.queue = new LinkedList<>();
    }

    public synchronized void add(T item)
    {
        try {
            while (queue.size()==this.capaciy)
            {
                wait();
            }
            queue.add(item);
            notifyAll();
        }catch (Exception e)
        {
           e.printStackTrace();
        }
    }

    public synchronized T remove()
    {
         try {
                while (this.queue.size()==0)
                {
                    wait();
                }

               T item =this.queue.poll();
                notifyAll();
                return item;

         }catch (Exception e)
         {
             e.printStackTrace();
         }

        return null;
    }
}
