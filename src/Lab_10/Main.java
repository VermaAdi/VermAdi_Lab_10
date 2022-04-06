package Lab_10;

import java.util.concurrent.Semaphore;

/**
 * Name: Aditya Verma
 * Date: April 5, 2022
 * Description: Lab 09 "The Multithreaded Cook" Submission for CS321.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {

        //creating the 4 needed semaphores
        Semaphore task4 = new Semaphore(2);
        Semaphore task6 = new Semaphore(2);
        Semaphore task7 = new Semaphore(2);
        Semaphore task9 = new Semaphore(2);

        //semaphore array
        Semaphore[] semaphores = new Semaphore[4];

        semaphores[0] = task4;
        semaphores[1] = task6;
        semaphores[2] = task7;
        semaphores[3] = task9;

        //Task Threads
        Cook Task1 = new Cook(semaphores, "Task1");
        Cook Task2 = new Cook(semaphores, "Task2");
        Cook Task3 = new Cook(semaphores, "Task3");
        Cook Task4 = new Cook(semaphores, "Task4");
        Cook Task5 = new Cook(semaphores, "Task5");
        Cook Task6 = new Cook(semaphores, "Task6");
        Cook Task7 = new Cook(semaphores, "Task7");
        Cook Task8 = new Cook(semaphores, "Task8");
        Cook Task9 = new Cook(semaphores, "Task9");

        //Running the threads
        Task1.start();
        Task2.start();
        Task3.start();
        Task4.start();
        Task5.start();
        Task6.start();
        Task7.start();
        Task8.start();
        Task9.start();

        //waiting for the threads to finish
        Task1.join();
        Task2.join();
        Task3.join();
        Task4.join();
        Task5.join();
        Task6.join();
        Task7.join();
        Task8.join();
        Task9.join();

    }
}
