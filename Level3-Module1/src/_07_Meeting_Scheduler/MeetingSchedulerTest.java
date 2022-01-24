package _07_Meeting_Scheduler;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*
 * Put all your code in the meeting scheduler and make the tests below pass!
 */
class MeetingSchedulerTest {
    Schedule boss;
    Schedule worker;
    Schedule client;
    Schedule ceo;
    
    @BeforeEach
    void setUp() throws Exception {
        boss = new Schedule();
        worker = new Schedule();
        client = new Schedule();
        ceo = new Schedule();
        
        // Boss's availability schedule
        boss.addAvailability("Monday", 13);
        boss.addAvailability("Monday", 14);
        boss.addAvailability("Monday", 15);
        boss.addAvailability("Wednesday", 10);
        boss.addAvailability("Wednesday", 11);
        boss.addAvailability("Thursday", 9);
        
        // Worker's availability schedule
        worker.addAvailability("Monday", 14);
        worker.addAvailability("Tuesday", 15);
        worker.addAvailability("Tuesday", 16);
        worker.addAvailability("Wednesday", 11);
        worker.addAvailability("Thursday", 16);
        worker.addAvailability("Thursday", 17);
        worker.addAvailability("Friday", 8);
        
        // Client's availability schedule
        client.addAvailability("Friday", 8);
        client.addAvailability("Saturday", 12);
        client.addAvailability("Sunday", 12);
        
        // CEO's availability schedule
        ceo.addAvailability("Monday", 14);
        ceo.addAvailability("Monday", 15);
        ceo.addAvailability("Thursday", 9);
        ceo.addAvailability("Friday", 8);
        ceo.addAvailability("Friday", 2);
    }

    @Test
    void BossAndWorker() {
        Schedule s = MeetingScheduler.getMutualAvailability(boss, worker);
        HashMap<String, ArrayList<Integer>> availability = s.getSchedule();
        
        System.out.println("\nBoss and Worker");
        s.printSchedule();
        
        assertTrue(availability.get("Monday").size() == 1);
        assertTrue(availability.get("Monday").contains(14));
        
        assertTrue(availability.get("Wednesday").size() == 1);
        assertTrue(availability.get("Wednesday").contains(11));
    }

    @Test
    void WorkerandClient() {
        Schedule s = MeetingScheduler.getMutualAvailability(worker, client);
        HashMap<String, ArrayList<Integer>> availability = s.getSchedule();
        
        System.out.println("\nWorker and Client");
        s.printSchedule();
        
        assertTrue(availability.get("Friday").size() == 1);
        assertTrue(availability.get("Friday").contains(8));
    }
    
    @Test
    void clientAndCeo() {
        Schedule s = MeetingScheduler.getMutualAvailability(client, ceo);
        HashMap<String, ArrayList<Integer>> availability = s.getSchedule();
        
        System.out.println("\nClient and CEO");
        s.printSchedule();
        
        assertTrue(availability.get("Friday").size() == 1);
        assertTrue(availability.get("Friday").contains(8));
    }
    
    @Test
    void BossAndCeo() {
        Schedule s = MeetingScheduler.getMutualAvailability(boss, ceo);
        HashMap<String, ArrayList<Integer>> availability = s.getSchedule();
        
        System.out.println("\nBoss and CEO");
        s.printSchedule();
        
        assertTrue(availability.get("Monday").size() == 2);
        assertTrue(availability.get("Monday").contains(14));
        assertTrue(availability.get("Monday").contains(15));
        
        assertTrue(availability.get("Thursday").size() == 1);
        assertTrue(availability.get("Thursday").contains(9));
    }
}
