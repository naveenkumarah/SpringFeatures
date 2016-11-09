package com.sample.threads;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class WaitNotifyAllDemo
{
 private static final Logger logger = LoggerFactory.getLogger(WaitNotifyAllDemo.class);

   public static void main (String [] args)
   {
      Object lock = new Object ();
      MyThread mt1 = new MyThread (lock);
      mt1.setName ("A");
      MyThread mt2 = new MyThread (lock);
      mt2.setName ("B");
      MyThread mt3 = new MyThread (lock);
      mt3.setName ("C");
      mt1.start ();
      mt2.start ();
      mt3.start ();
      logger.info("main thread sleeping");
      try
      {
         Thread.sleep (3000);
      }
      catch (InterruptedException e)
      {
      }
      logger.info("main thread awake");
      synchronized (lock)
      {
         lock.notifyAll ();
      }
   }
}
class MyThread extends Thread
{
   private Object o;
   MyThread (Object o)
   {
      this.o = o;
   }
   public void run ()
   {
      synchronized (o)
      {
         try
         {
             System.out.println (getName () + " before wait");
             o.wait ();
             System.out.println (getName () + " after wait");
         }
         catch (InterruptedException e)
         {
         }
      }
   }
}
