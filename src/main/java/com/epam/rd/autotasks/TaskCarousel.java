package com.epam.rd.autotasks;

import java.util.ArrayDeque;
import java.util.Queue;

public class TaskCarousel {

    int capacity;
    Queue<Task> carousalQue;

    public TaskCarousel(int capacity) {
        this.capacity = capacity;
        carousalQue = new ArrayDeque<>();
    }

    public boolean addTask(Task task) {
        if(task == null || task.isFinished() || (carousalQue.size() == capacity))
        {
            return false;
        }
        return carousalQue.offer(task);
    }

    public boolean execute() {
        if(carousalQue.isEmpty()) return false;
        Task currentTask = carousalQue.poll();
        currentTask.execute();
        if(!currentTask.isFinished())
        {
            carousalQue.offer(currentTask);
        }
        return true;
    }

    public boolean isFull() {
        return carousalQue.size() == capacity;
    }

    public boolean isEmpty() {
        return carousalQue.isEmpty();
    }

    public static void main(String[] args) {

    }

}
