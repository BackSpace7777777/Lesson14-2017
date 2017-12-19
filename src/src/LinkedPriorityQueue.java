package src;

import java.util.ArrayList;

public class LinkedPriorityQueue implements PriorityQueue{
    private int size;
    private ArrayList list[];
    public LinkedPriorityQueue(int s)
    {
        size=s;
        list=new ArrayList[size];
        for(int i=0;i<size;i++)list[i]=new ArrayList();
    }
    @Override
    public void enqueue(Object obj, int priority) {
        list[priority].add(obj);
    }

    @Override
    public Object peekFront() {
        for(int i=0;i<size;i++)
        {
            if(list[i].size()>0)
            {
                return list[i].get(0);
            }
        }
        throw new IllegalStateException("Queue is empty");
    }

    @Override
    public Object dequeue() {
        for(int i=0;i<size;i++)
        {
            if(list[i].size()>0)
            {
                return list[i].remove(0);
            }
        }
        throw new IllegalStateException("Queue is empty");
    }

    @Override
    public void enqueue(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int size() {
        return size;
    }
    public boolean hasData()
    {
        for(int i=0;i<size;i++)if(list[i].size()>0)return true;
        return false;
    }
}