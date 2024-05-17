package ST10445830;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import java.util.regex.Pattern;
import javax.swing.*;

/*
  Author: Matthew Jackson 
  Student number: ST10445830
 */

public class Login {

    // These variables are public static outside of the methods so that they can be accessed independently
    public static String username1;
    public static String password1;
    public static String loginUsername;
    public static String loginPassword;
    public static String name;
    public static String surname;

    public static void name_surname() {
        JTextField field1 = new JTextField();
        JTextField field2 = new JTextField();

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(new JLabel("Enter Name"));
        panel.add(field1);

        panel.add(new JLabel("Enter Surname"));
        panel.add(field2);

        JOptionPane.showConfirmDialog(null, panel, "Enter details", JOptionPane.OK_CANCEL_OPTION);

        name = field1.getText();
        surname = field2.getText();
    }

    public static void checkUserName() {
        boolean validusername;

        do {
            username1 = JOptionPane.showInputDialog(null,
                    "Create a Username that:\n" +
                    "> Contains no more than 5 characters\n" +
                    "> Has 1 underscore",
                    "Username Creation", JOptionPane.QUESTION_MESSAGE);

            if (username1 != null && username1.length() <= 5 && username1.contains("_")) {
                JOptionPane.showMessageDialog(null, "Username successfully captured");
                validusername = false;
            } else {
                JOptionPane.showMessageDialog(null,
                        "Username is not correctly formatted, please ensure that your username contains:\n" +
                        "> No more than 5 characters\n" +
                        "> Has 1 underscore",
                        "Invalid username", JOptionPane.ERROR_MESSAGE);
                validusername = true;
            }

        } while (validusername);

    } // end of username loop

    public static void checkPasswordComplexity() {
        boolean validpassword;

        do {
            password1 = JOptionPane.showInputDialog(null,
                    "Create a Password that has:\n" +
                    "> At least 8 characters\n" +
                    "> Contains a capital letter\n" +
                    "> Contains a number\n" +
                    "> Contains a special character",
                    "Password Creation", JOptionPane.QUESTION_MESSAGE);

            if (password1 != null && password1.length() >= 8
                    && Pattern.compile("[A-Z]").matcher(password1).find()
                    && Pattern.compile("[0-9]").matcher(password1).find()
                    && Pattern.compile("[!@#$%^&*?_.<>/]").matcher(password1).find()) {
                JOptionPane.showMessageDialog(null, "Password successfully captured");
                validpassword = false;
            } else {
                JOptionPane.showMessageDialog(null,
                        "Password is not correctly formatted, please ensure that your password contains:\n" +
                        "> At least 8 characters\n" +
                        "> A capital letter\n" +
                        "> A number\n" +
                        "> A special character",
                        "Invalid password", JOptionPane.ERROR_MESSAGE);
                validpassword = true;
            }

        } while (validpassword);

    } // end of password loop

    public static void loginUser() {
        boolean correctlogin;

        do {
            JTextField field1 = new JTextField();
            JTextField field2 = new JTextField();

            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

            panel.add(new JLabel("Enter Username"));
            panel.add(field1);

            panel.add(new JLabel("Enter Password"));
            panel.add(field2);

            JOptionPane.showConfirmDialog(null, panel, "Login", JOptionPane.OK_CANCEL_OPTION);

            loginUsername = field1.getText();
            loginPassword = field2.getText();

            if (loginUsername.equals(username1) && loginPassword.equals(password1)) {
                JOptionPane.showMessageDialog(null, "Login Successful\nWelcome " + name + " " + surname + 
                        ", it is great to see you again!", 
                        "Login", JOptionPane.INFORMATION_MESSAGE);
                correctlogin = false;
            } else {
                JOptionPane.showMessageDialog(null,
                        "Login Failed\n> Incorrect Username or Password\nPlease try again",
                        "Invalid Credentials", JOptionPane.ERROR_MESSAGE);
                correctlogin = true;
            }

        } while (correctlogin); // end of login loop
    }

    public static boolean isValidPassword(String password) {
        return password.length() >= 8
                && Pattern.compile("[A-Z]").matcher(password).find()
                && Pattern.compile("[0-9]").matcher(password).find()
                && Pattern.compile("[!@#$%^&*?_.<>/]").matcher(password).find();
    }

    public static boolean isValidUsername(String username) {
        return username.length() <= 5 && username.contains("_");
    }
}
// end of program
