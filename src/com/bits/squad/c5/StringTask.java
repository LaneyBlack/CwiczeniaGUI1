package com.bits.squad.c5;

public class StringTask implements Runnable {
    TaskState taskState;

    enum TaskState {
        CREATED,
        RUNNING,
        ABORTED,
        READY
    }

    private String text;
    private int times;

    public StringTask(String text, int times) {
        this.taskState = TaskState.CREATED;
        this.text = text;
        this.times = times;
    }

    @Override
    public void run() {
        taskState = TaskState.RUNNING;
        String concat = text;
        while (!isDone() && times > 0) {
            text += concat;
            times--;
        }
        if (times <= 0)
            taskState = TaskState.READY;
    }

    public String getResult() {
        return text;
    }

    public TaskState getState() {
        return taskState;
    }

    public void start() {
        Thread thread = new Thread(this::run);
        thread.start();
    }

    public boolean isDone() {
        return taskState == TaskState.READY || taskState == TaskState.ABORTED;
    }

    public void abort() {
        taskState = TaskState.ABORTED;
    }
}
