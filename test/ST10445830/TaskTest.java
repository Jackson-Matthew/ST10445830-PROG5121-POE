package ST10445830;

import org.junit.Test;
import static org.junit.Assert.*;

public class TaskTest {

    @Test //checks if the description is less than 50 characters
    public void testCheckTaskDescription1() {

        boolean Expected = true;
        boolean Actual = Task.checkTaskDescription("this is a description");
        assertEquals(Expected, Actual);
        System.out.println("Task Succesfully captured");
    }

    @Test //checks if the description is more than 50 characters
    public void testCheckTaskDescription2() {

        boolean Expected = false;
        boolean Actual = Task.checkTaskDescription("this is a description that has way too many characters and will not work");
        assertEquals(Expected, Actual);
        System.out.println("Please enter a task description of less than 50 characters");
    }

    @Test //tests the generation of various differnt taskIDs based on differnt user info
    public void testCreateTaskID() {

        Object[][] TestArray = {{"CR:0:IKE", 0, "Create login", "Mike Smith"},
        {"CR:1:ARD", 1, "Create Password check", "Howard Mcoy"},
        {"CR:2:THA", 2, "Create TaskID", "Martha Davies"},
        {"CR:3:ND", 3, "Create menu", "ND"}};

        for (Object[] TaskIDs : TestArray) {

            String Expected = (String) TaskIDs[0];
            int taskNumber = (int) TaskIDs[1];
            String TaskName = (String) TaskIDs[2];
            String Devdetails = (String) TaskIDs[3];

            String Actual = Task.createTaskID(taskNumber, TaskName, Devdetails);
            assertEquals(Expected, Actual);
            System.out.println(Actual);

        }

        String Expected = "AD:1:BYN";
        String Actual = Task.createTaskID(1, "Add Task Feature", "Robyn Harrison");
        assertEquals(Expected, Actual);
        System.out.println(Expected);

    }

    @Test //tests different ammount of values put in by users,as indicated by the array
    public void testReturnTotalHours() {
        
        
        int[] taskDurations = {10, 12, 55, 11, 1};
        int Expected = 89;
        int Actual = Task.returnTotalHours(taskDurations);

        assertEquals(Expected, Actual);
        System.out.println(Actual);

    }
/*
    @Test //tests the creation of 2 tasks throughout the program
    public void testCreateTasks() {

        // First task stuffs
        String taskName1 = "Login Feature";
        String taskDescription1 = "Create Login to authenticate users";
        String developerDetails1 = "Robyn Harrison";
        int taskDuration1 = 8;

        Task.taskCounter++;
        String taskID1 = Task.createTaskID(Task.taskCounter, taskName1, developerDetails1);

        assertTrue(Task.checkTaskDescription(taskDescription1));
        Task.taskDurations[0] = taskDuration1;

        String Expected1 = "Task Status: To Do\n"
                + "Developer details: Robyn Harrison\n"
                + "Task Number: 0\n"
                + "Task Name: Login Feature\n"
                + "Task Description: Create Login to authenticate users\n"
                + "Task ID: LO:0:BYN\n" + "Task Duration: 8\n";

        String Actual1 = Task.printTaskDetails("To Do", developerDetails1, taskName1, taskDescription1, taskID1, String.valueOf(taskDuration1));

        // Second task stuffs
        String taskName2 = "Add Task Feature";
        String taskDescription2 = "Create Add Task feature to add task  users";
        String developerDetails2 = "Mike Smith";
        int taskDuration2 = 10;

        Task.taskCounter++;
        String taskID2 = Task.createTaskID(Task.taskCounter, taskName2, developerDetails2);

        assertTrue(Task.checkTaskDescription(taskDescription2));
        Task.taskDurations[1] = taskDuration2;

        String Expected2 = "Task Status: Doing\n"
                + "Developer details: Mike Smith\n"
                + "Task Number: 1\n"
                + "Task Name: Add Task Feature\n"
                + "Task Description: Create Add Task feature to add task  users\n"
                + "Task ID: AD:1:IKE\n"
                + "Task Duration: 10\n";

        String Actual2 = Task.printTaskDetails("Doing", developerDetails2, taskName2, taskDescription2, taskID2, String.valueOf(taskDuration2));

        // Assert both task details
        assertEquals(Expected1, Actual1);
        assertEquals(Expected2, Actual2);
    }
    */
}
