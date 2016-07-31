package pack01;

import java.util.ArrayList;

/**
 *
 * @author sergey
 */
public class TaskList {

    private ArrayList<Task> taskList = new ArrayList<Task>();

    /**
     *
     * @param name
     */
    public void createTask(String name) {
        Task task = new Task(name);
        taskList.add(task);
    }

    /**
     *
     * @param name
     * @return
     */
    public boolean isTaskExist(String name) {
        for (Task t : taskList) {
            if (t.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param name
     * @return
     */
    public boolean startTask(String name) {
        for (Task t : taskList) {
            if (t.getName().equals(name)) {
                if (!t.isActive()) {
                    t.startTask();
                    return true;
                }
            }
        }
        return false;
    }

    /**
     *
     * @param name
     * @return
     */
    public boolean stopTask(String name) {
        for (Task t : taskList) {
            if (t.getName().equals(name)) {
                if (t.isActive()) {
                    t.stopTask();
                    return true;
                }
            }
        }
        return false;
    }

    /**
     *
     * @param name
     */
    public void toggleTask(String name) {
        for (Task t : taskList) {
            if (t.getName().equals(name)) {
                if (t.isActive()) {
                    t.stopTask();
                } else {
                    t.startTask();
                }
            }
        }
    }

    /**
     *
     */
    public void refreshTaskTime() {
        for (Task t : taskList) {
            t.calcSpentTime();
        }
    }

    /**
     *
     */
    public void saveTaskList() {
    }

    /**
     *
     */
    public void restoreTaskList() {
    }

    /**
     *
     * @return
     */
    public ArrayList<Task> getTaskList() {
        return taskList;
    }
}
