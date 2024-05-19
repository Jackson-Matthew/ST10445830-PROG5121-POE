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

        String[] options = {"1) Create Task", "2) Show report", "3) quit"};
        int menu = -1;

        while (menu != 2) {
            menu = JOptionPane.showOptionDialog(null, "Welcome to easy KanBan", "Main Menu ", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (menu) {
                case 0:
                    createTask();
                    
                    JOptionPane.showMessageDialog(null, "Total combined hours of all Tasks: \n"
               + totalHours + " Hours");
                    break;
                case 1:
                    ShowReport();
                    break;
                case 2:
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

    public static final int[] taskDurations = new int[20];

    public static void createTask() {

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
                        taskDurations[i] = Integer.parseInt(taskduration.getText());

                        Task.printTaskDetails(selectedItem, DeveloperDetails, TaskName, TaskDescription, taskID, TaskDuration);
                    }
                } else {
                    taskCounter--; //will fix the task if it is cancelled
                    i--;
                    break;
                }
            }
        }

        Task.returnTotalHours(taskDurations);

    }

    public static boolean checkTaskDescription(String description) {

        if (description.length() <= 50) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Description too long, please enter no more than 50 characters",
                    "Invalid description", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

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

    public static void ShowReport() {

        JOptionPane.showMessageDialog(null, "Coming Soon");
    }
}
//End of Program


