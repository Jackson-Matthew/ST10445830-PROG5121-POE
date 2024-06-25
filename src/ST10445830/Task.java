package ST10445830;

import javax.swing.*;

/*
  @author Matthew Jackson 
  Student number: ST10445830
 */
//Start of Program
public class Task {

    //the main menu that contantly loops, controlls how tasks are made aswell as allows the application to quit
    public static void menu1() {

        JOptionPane.showMessageDialog(null, "Welcome to EasyKanBan !");

        int menu = -1;

        //switch menu that takes input of user and runs one of the 3 options
        while (menu != 100) {
            String input = JOptionPane.showInputDialog(null, "Menu Selection: "
                    + "\n1) Create A Task."
                    + "\n2) Show Report."
                    + "\n3) Exit.");

            // Parse input to integer
            menu = Integer.parseInt(input);

            switch (menu) {
                case 1:
                    createTask();
                    JOptionPane.showMessageDialog(null, "Total combined hours of all Tasks: \n"
                            + totalHours + " Hours");
                    break;
                case 2:
                    ShowReport();
                    break;
                case 3:
                    System.exit(0);
                default:
                    break;
            }
        }
    }

    //all variables are defined here as public static so that they can be acessed
    public static String selectedItem;
    public static String DeveloperDetails;
    public static int taskCounter = -1;
    public static String TaskName;
    public static String TaskDescription;
    public static String taskID;
    public static String TaskDuration;
    public static int totalHours;

    // sepeate arrays are created for each input
    public static final String[] developers = new String[100];
    public static final String[] names = new String[100];
    public static final String[] IDs = new String[100];
    public static final int[] taskDurations = new int[100];
    public static final String[] status = new String[100];

    public static void createTask() {

        //asks the user how many tasks they want to make 
        String newTask = JOptionPane.showInputDialog(null, "Enter how many tasks \nyou would like to create");
        int numTask = Integer.parseInt(newTask);

        for (int i = 0; i < numTask; i++) {

            taskCounter++;

            String list[] = {"To Do", "Doing", "Done"};
            JComboBox<String> cb = new JComboBox<>(list);
            JTextField devdetails = new JTextField();
            JTextField taskname = new JTextField();
            JTextField description = new JTextField();
            JTextField taskduration = new JTextField();

            JPanel panel = new JPanel();

            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

            panel.add(new JLabel("Select A task Status"));
            panel.add(cb);

            panel.add(new JLabel("Developer details"));
            panel.add(devdetails);

            panel.add(new JLabel("Task Name"));
            panel.add(taskname);

            panel.add(new JLabel("Enter a description of your task (max 50 characters)"));
            panel.add(description);

            panel.add(new JLabel("Task Duration (In hours)"));
            panel.add(taskduration);

            boolean validDescription = false;
            while (!validDescription) {
                int result = JOptionPane.showConfirmDialog(null, panel, "Enter task " + (i + 1)
                        + ":", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (result == JOptionPane.OK_OPTION) {

                    selectedItem = (String) cb.getSelectedItem();
                    DeveloperDetails = devdetails.getText();
                    TaskName = taskname.getText();
                    TaskDescription = description.getText();
                    TaskDuration = taskduration.getText();

                    validDescription = checkTaskDescription(TaskDescription);
                    if (validDescription) {
                        taskID = createTaskID(taskCounter, TaskName, DeveloperDetails);

                        /*arrays are populated in the correct order, this ensures that values are input 
                          when the user creates a task
                        */
                        
                        developers[i] = DeveloperDetails;
                        names[i] = TaskName;
                        IDs[i] = taskID;
                        taskDurations[i] = Integer.parseInt(taskduration.getText());
                        status[i] = selectedItem;

                        //task details are called and then the printTask details method displays them
                        Task.printTaskDetails(selectedItem, DeveloperDetails, TaskName, TaskDescription, taskID, TaskDuration);

                    } else {
                        JOptionPane.showMessageDialog(null, "Description too long, please enter no more than 50 characters",
                                "Invalid description", JOptionPane.ERROR_MESSAGE);
                    }

                } else {
                    taskCounter--; //will fix the task if it is cancelled
                    i--;
                    break;
                }
            }
        }

        //total hours over all tasks are diplayed
        Task.returnTotalHours(taskDurations);

    }

    //this method checks the lenght of the description  
    public static boolean checkTaskDescription(String description) {

        return description.length() <= 50;
    }

    //creates the TaskID by taking info from developer details, task name and task number  
    public static String createTaskID(int taskNumber, String taskName, String devDetails) {

        String firstName = devDetails.split(" ")[0];

        String first2 = taskName.length() > 1 ? taskName.substring(0, 2) : taskName;

        String last3 = firstName.length() > 3 ? firstName.substring(firstName.length() - 3) : firstName;

        taskID = (first2 + ":" + taskNumber + ":" + last3).toUpperCase();

        return taskID;
    }

    public static String printTaskDetails(String selectedItem, String developerDetails, String taskName,
        String description, String taskId, String taskDuration) {
        
        StringBuilder TaskBuilder = new StringBuilder();

        TaskBuilder.append("Task Status: ")
                .append(selectedItem).append("\n")
                .append("Developer details: ").append(developerDetails).append("\n")
                .append("Task Number: ").append(taskCounter).append("\n")
                .append("Task Name: ").append(taskName).append("\n")
                .append("Task Description: ").append(description).append("\n")
                .append("Task ID: ").append(taskId).append("\n")
                .append("Task Duration: ").append(taskDuration).append("\n");

        String TaskDetails = TaskBuilder.toString();

        JOptionPane.showMessageDialog(null, TaskDetails);

        return TaskDetails;
    }

    public static int returnTotalHours(int[] taskDurations) {

        totalHours = 0;
        for (int duration : taskDurations) {
            totalHours += duration;
        }

        return totalHours;
    }

    /* Main show report method that has all the options a user can choose from a numeric menu
       these options include the ability to search for specific tasks that have been created aswell
       as display all tasks,delete tasks, show tasks with specific status of done
     */
    public static void ShowReport() {

        int menu = -1;

        while (menu != 100) {

            // Get user input
            String input = JOptionPane.showInputDialog(null, "Menu Selection:"
                    + "\n1) Display tasks with Status 'Done'."
                    + "\n2) Display task with Longest duration."
                    + "\n3) Search for any task."
                    + "\n4) Search for all tasks assigned to a developer."
                    + "\n5) Delete a Task "
                    + "\n6) Display report of all tasks");

            // Check if the user clicked cancel or closed the dialog
            if (input == null) {
                break; // Exit the loop if the dialog was closed or cancelled
            }

            // Parse input to integer
            menu = Integer.parseInt(input);

            switch (menu) {
                case 1: // Calls the Done method
                    Done();
                    break;
                case 2: // calls the longest duration method
                    LongestDuration();
                    break;
                case 3: // call the search task method
                    SearchTask(); 
                    break;
                case 4: // call the DeveloperTask method
                    DeveloperTask();
                    break;
                case 5: // calls the delete task method
                    DeleteTask();
                    break;
                case 6: // calls the all tasks method
                    AllTasks();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid selection. Please choose a number between 0 and 5.");
                    break;
            }
        }
    }
    /* the switch bellow manages all the fucntions that appear in the show report method each case 
       within the switch calls a differnet method that acts differently, this includes displaying 
       various functions such as deleteing a task, searching for the longest duratons 
    
       If cancel is selected the loop is ended and the program returns to the original main menu
    */

    public static void Done() { //displays developer, task names and durations of all tasks that have done status

        StringBuilder TaskBuilder = new StringBuilder();
        TaskBuilder.append("Tasks with Status Done:\n\n");

        for (int i = 0; i <= taskCounter; i++) {
            if ("Done".equals(status[i])) {
                TaskBuilder.append("Developer: ").append(developers[i])
                        .append("\nTask Name: ").append(names[i])
                        .append("\nTask Duration: ").append(taskDurations[i]).append(" hours\n\n");
            }
        }
        String TaskDetails = TaskBuilder.toString();
        JOptionPane.showMessageDialog(null, TaskDetails);
    }

    public static String getLongestDuration() { //gets the Longest duration amoung all the data
        if (taskCounter == -1) {
            JOptionPane.showMessageDialog(null, "No tasks available.");

        }

        int longestDurationIndex = 0;
        int longestDuration = taskDurations[0];

        for (int i = 1; i <= taskCounter; i++) {
            if (taskDurations[i] > longestDuration) {
                longestDuration = taskDurations[i];
                longestDurationIndex = i;
            }
        }

        StringBuilder TaskBuilder = new StringBuilder();
        TaskBuilder.append("Task with the Longest Duration: \n")
                .append("Developer details: ").append(developers[longestDurationIndex]).append("\n")
                .append("Task Duration: ").append(longestDuration).append(" hours\n");

        String TaskDetails = TaskBuilder.toString();

        return TaskDetails;
    }

    public static void LongestDuration() { // displays the longest duration method in JOptionPane
        
        String Longest = getLongestDuration();
        JOptionPane.showMessageDialog(null, Longest);
    }

    public static String getSearchTask(String searchText) { // searches for a task using a task name 
        if (searchText != null && !searchText.isEmpty()) {
            StringBuilder TaskBuilder = new StringBuilder();

            for (int i = 0; i <= taskCounter; i++) {
                if (names[i] != null && names[i].contains(searchText)) {
                    TaskBuilder.append("Task Name: ").append(names[i]).append("\n")
                            .append("Developer details: ").append(developers[i]).append("\n")
                            .append("Task Status: ").append(status[i]).append("\n\n");

                }
            }
            String result = TaskBuilder.toString().trim();
            return result.isEmpty() ? "No tasks found." : result;   //returns empty if there is no task found
        }
        return "No tasks found.";
    }

    public static void SearchTask() { // displays the search task method in JOptionPane  
        String Name = JOptionPane.showInputDialog(null, "Enter a task name to search for tasks");
        String searchTasks = getSearchTask(Name);
        JOptionPane.showMessageDialog(null, searchTasks);
    }

    public static String getDeveloperTasks(String developer) { //searchign for a developer and displaying the task name and status   
        if (developer != null && !developer.isEmpty()) {
            StringBuilder taskBuilder = new StringBuilder();

            for (int i = 0; i <= taskCounter; i++) {
                if (developers[i] != null && developers[i].contains(developer)) {
                    taskBuilder.append("Task Name: ").append(names[i]).append("\n")
                            .append("Task Status: ").append(status[i]).append("\n\n");
                }
            }

            String result = taskBuilder.toString().trim();
            return result.isEmpty() ? "No tasks found for the developer." : result;
        }
        return "No tasks found for the developer.";
    }

    public static void DeveloperTask() { //displays the developer in the form of JOptionPane
        String developer = JOptionPane.showInputDialog(null, "Enter the developer name to search for tasks");
        String developerTasks = getDeveloperTasks(developer);
        JOptionPane.showMessageDialog(null, developerTasks);
    }

    public static String getDeleteTask(String delete) { //deletes a specificed task from the array
        if (delete != null && !delete.isEmpty()) {
            boolean found = false;
            int indexToDelete = -1;

            for (int i = 0; i <= taskCounter; i++) {
                if ((names[i] != null && names[i].equals(delete))) {
                    indexToDelete = i;
                    found = true;
                    break;
                }
            }
            /* 
               In order to delete a few specific elements from an array the method must be able to locate where they are.
               A task name is entered and then passed through a loop that will identify what elements are assocated with
               that specific task name, these elements are then shifted within the array to enusre they cannot be located
            */
            
            
            if (found && indexToDelete != -1) {
                for (int i = indexToDelete; i < taskCounter; i++) {
                    developers[i] = developers[i + 1];
                    names[i] = names[i + 1];
                    IDs[i] = IDs[i + 1];
                    taskDurations[i] = taskDurations[i + 1];
                    status[i] = status[i + 1];
                }
            /*
               so that the elements don't clash with eachother when they are shifted the task counter variable is passed through
               each element and made null so that in cannot be recognised and does not mess up the position of elements that
               might be in the same place   
            */
                developers[taskCounter] = null;
                names[taskCounter] = null;
                IDs[taskCounter] = null;
                taskDurations[taskCounter] = 0;
                status[taskCounter] = null;

                taskCounter--;
                return "task deleted";
            }
        }
        return "Task not found";
    }

    public static void DeleteTask() {  // displays the delete task in JOptionPane for user to input task name to delete
         
        String nameinput = JOptionPane.showInputDialog(null, "Enter A task name to delete that task");
        String output = getDeleteTask(nameinput);
        JOptionPane.showMessageDialog(null, output);
    }

    public static String getAllTasks(String All) { //passes all elements in the arrays and displays them in string builder                                                  
                                                   
        StringBuilder TaskBuilder = new StringBuilder();

        for (int i = 0; i <= taskCounter; i++) {
            TaskBuilder.append("Task Name: ").append(names[i])
                    .append("\nDeveloper: ").append(developers[i])
                    .append("\nTask Status: ").append(status[i])
                    .append("\nTask Duration: ").append(taskDurations[i])
                    .append(" hours\n\n");
        }
        return TaskBuilder.toString();

    }

    public static void AllTasks() { //displays all tasks created in JOptionPane form
        String alltasks = getAllTasks("");
        JOptionPane.showMessageDialog(null, alltasks);
    }

}
//End of Program
