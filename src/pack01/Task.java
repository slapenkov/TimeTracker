package pack01;

import java.io.Serializable;

/**
 * Class for object "Task"
 *
 * @author sergey
 */
public class Task implements Serializable {

    private String name; //task name
    private boolean isActive;
    private long startTime; //in ms
    private long stopTime; //in ms
    private long spentTime; //in ms
    private int donePercents; //in percents

    /**
     * Constructor
     *
     * @param name The task name
     */
    public Task(String name) {
        this.name = name;
    }

    /**
     * Calculate the time used (if task active)
     *
     * @return
     */
    public long calcSpentTime() {
        if (isActive) {
            this.spentTime += System.currentTimeMillis() - startTime;
            startTime = System.currentTimeMillis();
        }
        return this.spentTime;
    }

    /**
     * Start the task and store it's start time in ms from 1.01.1970
     */
    public void startTask() {
        this.startTime = System.currentTimeMillis();
        this.isActive = true;
    }

    /**
     * Stop the task, calculate and store it's spent and stop time in ms
     */
    public void stopTask() {
        this.spentTime += System.currentTimeMillis()-startTime;
        startTime = System.currentTimeMillis();
        this.isActive = false;
    }

    /**
     * Get task name
     *
     * @return The task name
     */
    public String getName() {
        return name;
    }

    /**
     * Get state of task. True - task is active.
     *
     * @return The task state
     */
    public boolean isActive() {
        return isActive;
    }

    /**
     * Get start time
     *
     * @return The start time in ms from 1.01.1970
     */
    public long getStartTime() {
        return startTime;
    }

    /**
     * Get stop time
     *
     * @return The stop time in ms from 1.01.1970
     */
    public long getStopTime() {
        return stopTime;
    }

    /**
     * Get spent time
     *
     * @return The spent time in ms
     */
    public long getSpentTime() {
        return spentTime;
    }

    /**
     * Get done percentage
     *
     * @return The done percents
     */
    public int getDonePercents() {
        return donePercents;
    }

    /**
     * Rename task
     *
     * @param name The new task name
     */
    public void rename(String name) {
        this.name = name;
    }

    /**
     * Set done percentage
     *
     * @param donePercents New percentage
     */
    public void setDonePercents(int donePercents) {
        this.donePercents = donePercents;
    }

    /**
     * Print task parameters and calculate spent time
     */
    public void printTaskParams() {
        System.out.println("Task " + name + " is " + isActive + " at " + startTime
                + " till " + stopTime + ", total elapsed time is " + this.calcSpentTime());
    }
}
