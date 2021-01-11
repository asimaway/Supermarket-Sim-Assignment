package com.asim;

import com.asim.shopper.ShopperArrivalTime;

import java.util.Timer;
import java.util.TimerTask;

public class Main {

    public static void main(String[] args) {
	// write your code here

     TimerTask shopperArrivalTime = new ShopperArrivalTime();
     Products products = new Products();
     products.ReadProductsFromCVSFile();


     /*TimeSlice timeSlice = new TimeSlice();//same // TimerTask timeSlice = new TimeSlice();
        ServiceTime serviceTime = new ServiceTime();*/

//..Run timers as Daemon(in background == true)..//
     Timer timer1 = new Timer(true); //True == allow background processing

       /* Timer timer2 = new Timer(true); //If False keeps running the Timers
         Timer timer3 = new Timer(true);*/

//Start simulation with Task, delays and interval of simulation
     System.out.println("Start Sending Shoppers to SuperMarket");

     timer1.scheduleAtFixedRate(shopperArrivalTime, 0 , 1000); //100 == 1ms 1000 == 1 sec

       /*timer2.scheduleAtFixedRate(interArrivalTime , 1000 , 1);
          timer3.scheduleAtFixedRate(serviceTime, 1000 , 3000);*/

   //Halt Main Class

     try{
         Thread.sleep(100000);
     } catch (InterruptedException e) {
         e.printStackTrace();
     }

     //Stop simulation
        timer1.cancel();
       /* timer2.cancel();
        timer3.cancel();*/

        System.out.println("\nSimulation Stopped");



    }
}

//Testing Random Products
     /*
     Products products1 = new Products();
      for(int i = 0; i < 10; i++) {

            System.out.printf("Test Random Basket:");
            for (String product : products1.getRandomProducts()) {
                System.out.printf(product + " ,");
            }

            System.out.println("");

        }*/