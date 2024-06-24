package ST10445830;

import org.junit.Test;
import static org.junit.Assert.*;

public class TaskTest {

    /* part 2 UNIT Tests below
    *
    * 4 unit tests are used below to test the conditions in part 2
     */
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

    /*part 3 UNIT Tests below
    *
    * 6 unit tests are created to test the functionality of the task class specifically 
    * focusing on the given methods in the Show Report section
     */
    
    @Test //populates the developers array so that it contains the expected test data
    public void testPopulatedArrays() {

        Task.developers[0] = "Mike Smith";
        Task.developers[1] = "Edward Harrison";
        Task.developers[2] = "Samantha Paulson";
        Task.developers[3] = "Glenda Oberholzer";

        assertEquals("Mike Smith", Task.developers[0]);
        assertEquals("Edward Harrison", Task.developers[1]);
        assertEquals("Samantha Paulson", Task.developers[2]);
        assertEquals("Glenda Oberholzer", Task.developers[3]);

        System.out.println(Task.developers[0]);
        System.out.println(Task.developers[1]);
        System.out.println(Task.developers[2]);
        System.out.println(Task.developers[3]);

    }

    @Test //tests the capabilty of the LongestDuration method by determining what test data has the longest duration
    public void testLongestDuration() { //needs to be refractored so no gui for workflow

        Task.taskCounter = 3;

        Task.taskDurations[0] = 5;
        Task.taskDurations[1] = 8;
        Task.taskDurations[2] = 2;
        Task.taskDurations[3] = 11;
        Task.developers[0] = "Mike Smith";
        Task.developers[1] = "Edward Harrison";
        Task.developers[2] = "Samantha Paulson";
        Task.developers[3] = "Glenda Oberholzer";

        String Expected = "Task with the Longest Duration: \n"
                + "Developer details: Glenda Oberholzer\n"
                + "Task Duration: 11 hours\n";
        String Actual = Task.LongestDuration();

        assertEquals(Expected,Actual);
        System.out.println(Actual);
    }

    @Test
    public void testgetSearchTask() {
      Task.taskCounter = 0;
        
      Task.developers[0]= "Mike Smith";
      Task.names[0]= "Create Login";
      Task.status[0] = "Done";
     
        String Expected = "Task Name: Create Login\nDeveloper details: Mike Smith\nTask Status: Done";
                
        String Actual = Task.getSearchTask("Create Login");
        
        assertEquals(Expected,Actual);
        System.out.println(Actual);
    
    }

    @Test
    public void testgetDeveloperTask() {
      Task.taskCounter = 0;
      
      Task.names[0]= "Create Reports";
      Task.status[0] = "Done";
      Task.developers[0]= "Samantha Paulson";
      
      String Expected = "Task Name: Create Reports\nTask Status: Done";
        
      String Actual = Task.getDeveloperTasks("Samantha Paulson");
                
        assertEquals(Expected,Actual);
        System.out.println(Actual);     

    }

    @Test
    public void testgetDeleteTask() {

        Task.taskCounter = 1;
        Task.names[0] = "Create Reports";
        Task.developers[0] = "Samantha Paulson";
        Task.status[0] ="Done";
        Task.names[1] = "Create Add Features";
        Task.developers[1] = "Edward Harrison";
        Task.status[1] ="Doing";
        
        String delete = Task.getDeleteTask("Create Reports");
        
        assertEquals("task deleted", delete);
        assertEquals(0, Task.taskCounter);
        assertEquals("Create Add Features", Task.names[0]);
        assertEquals("Edward Harrison", Task.developers[0]);
        assertEquals("Doing", Task.status[0]);

        // Verify the task is not found
        delete = Task.getDeleteTask("Create Reports");
        assertEquals("Task not found", delete);
        System.out.println("Entry"+ delete + "successfully deleted");
        
    }

    @Test
    public void testAllTasks() {

    }

}
