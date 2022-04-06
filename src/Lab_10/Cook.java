package Lab_10;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * Name: Aditya Verma
 * Date: April 5, 2022
 * Description: Lab 09 "The Multithreaded Cook" Submission for CS321.
 */
public class Cook extends Thread {

    Semaphore[] semaphores; //array of all semaphores used
    String taskName; //variable storing the task name
    Random random = new Random(); //random object to select sleep time

    //Constructor
    public Cook(Semaphore[] semaphores, String taskName) {
        super(taskName);
        this.taskName = taskName;
        this.semaphores = semaphores;
    }

    public void run() {

        //Task 1
        if (this.getName().equals("Task1")) {

            try {
                semaphores[0].acquire(); //locking task1 for task4
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Cut Onions"); //printing out task

            try {
                Thread.sleep(random.nextInt(2000, 12000)); //sleep for 2-11 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Task 1 is complete!"); //task complete
            semaphores[0].release(); //signalling task1 completion for task4
        }
        //Task 2
        else if (this.getName().equals("Task2")) {

            try {
                semaphores[0].acquire(); //locking task2 for task4
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Mince Meat."); //print out task

            try {
                Thread.sleep(random.nextInt(2000, 12000)); //sleep for 2-11 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Task 2 is complete!"); //task complete
            semaphores[0].release(); //signalling task2 completion for task4

        }
        //Task 3
        else if (this.getName().equals("Task3")) {

            try {
                semaphores[1].acquire(); //locking task3 for task6
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Slice Aubergines."); //print out task

            try {
                Thread.sleep(random.nextInt(2000, 12000)); //sleep for 2-11 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Task 3 is complete!"); //task complete
            semaphores[1].release(); //signalling task3 completion for task6
        }
        //Task 4
        else if (this.getName().equals("Task4")) {

            try {
                semaphores[0].acquire(); //waiting until task1 and task2 finish
                semaphores[1].acquire(); //locking task4 for task6
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Make sauce."); //print out task

            try {
                Thread.sleep(random.nextInt(2000, 12000)); //sleep for 2-11 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Task 4 is complete!"); //task complete
            semaphores[1].release(); //signalling task4 completion to task6
            semaphores[0].release(); //releasing permit for task4
        }
        //Task 5
        else if (this.getName().equals("Task5")) {
            try {
                semaphores[2].acquire(); //locking task 5 for task 7
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Finished Bechamel."); //print out task

            try {
                Thread.sleep(random.nextInt(2000, 12000)); //sleep for 2-11 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Task 5 is complete!"); //task complete
            semaphores[2].release(); //signalling task5 completion to task 7

        }
        //Task 6
        else if (this.getName().equals("Task6")) {
            try {
                semaphores[1].acquire(); //waiting until task3 and task4 finish
                semaphores[2].acquire(); //locking task 6 for task7
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Layout the Layers."); //print out task

            try {
                Thread.sleep(random.nextInt(2000, 12000)); //sleep for 2-11 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Task 6 is complete!"); //task complete
            semaphores[2].release(); //signalling task6 completion to task7
            semaphores[1].release(); //releasing task 6 permit
        }
        //Task 7
        else if (this.getName().equals("Task7")) {
            try {
                semaphores[2].acquire(); //waiting until task5 and task6 finish
                semaphores[3].acquire(); //locks task 7 for task 9
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Put Bechamel and Cheese"); //print out task

            try {
                Thread.sleep(random.nextInt(2000, 12000)); //sleep for 2-11 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Task 7 is complete!"); //task complete
            semaphores[3].release(); //singalling task7 completion to task9
            semaphores[2].release(); //releasing permit for task7

        }
        //Task 8
        else if (this.getName().equals("Task8")) {
            try {
                semaphores[3].acquire(); //locks task 8 for task 9

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Turn on Oven"); //print out task

            try {
                Thread.sleep(random.nextInt(2000, 12000)); //sleep for 2-11 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Task 8 is complete!"); //task complete
            semaphores[3].release(); //singalling task8 completion to task9

        }
        //Task 9
        else if (this.getName().equals("Task9")) {
            try {
                semaphores[3].acquire(); //waits until task7 and task8 finish
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Cook"); //print out task

            try {
                Thread.sleep(random.nextInt(2000, 12000)); //sleep for 2-11 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Task 9 is complete!"); //task complete
            semaphores[3].release(); //releasing task9 permit

        }
    }
}
