package pack01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author sergey
 */
public class TimeTrackerManager {

    public static void printTaskList(TaskList tl) {
        String active;
        for (Task t : tl.getTaskList()) {
            if (t.isActive()) {
                active = "active";
            } else {
                active = "inactive";
            }
            System.out.println("Task <" + t.getName() + "> is " + active
                    + ". Total work time is " + t.getSpentTime() + " ms.");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        //greeting string
        System.out.println("Time tracker v0.1");

        TaskList list = new TaskList(); //create list

        list.restoreTaskList(); //rsetore saved task list

        //command proccessor
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String cmd;
        //dummy read
 //       cmd = input.readLine();

        do {
            printTaskList(list);
            System.out.println("Enter task name to create/start/stop (type <exit> for terminate):");
            cmd = input.readLine();
            if (cmd.equals("") || (cmd.equals("exit"))) {
                list.refreshTaskTime();
            } else {
                if (list.isTaskExist(cmd)) {
                    //start/stop task
                    list.toggleTask(cmd);
                } else {
                    list.createTask(cmd);
                }
            }
        } while (!cmd.equals("exit"));

        list.saveTaskList();

        System.out.println("Program terminated");
    }
}
