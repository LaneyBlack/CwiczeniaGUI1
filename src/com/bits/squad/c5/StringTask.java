package com.bits.squad.c5;

public class StringTask implements Runnable{
    TaskState taskState;
    enum TaskState{
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
        while (!isDone()||times>0) {
            text += text;
            times--;
        }
        taskState = TaskState.READY;
    }

    public String getResult(){
        return text;
    }

    public TaskState getState() {
        return taskState;
    }

    public void start(){
        taskState = TaskState.RUNNING;
        run();
    }

    public boolean isDone(){
        return taskState == TaskState.READY || taskState == TaskState.ABORTED;
    }

    public void abort(){
        taskState = TaskState.ABORTED;
    }
}
