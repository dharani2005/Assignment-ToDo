package org.example;


import java.time.LocalDate;

public class TodoItem {
    private int id;
    private String title;
    private String taskDescription;
    private LocalDate deadLine;
    private boolean done;
    private Person creator;

    public TodoItem(int id, String title, String taskDescription, LocalDate deadLine, Person creator) {
        this.id=id;
        setTitle(title);
        setTaskDescription(taskDescription);
        setDeadLine(deadLine);
        setCreator(creator);
        setDone();
    }
   /* public TodoItem(int id, String title, String taskDescription, LocalDate deadLine) {
        this.id=id;
        setTitle(title);
        setTaskDescription(taskDescription);
        setDeadLine(deadLine);
        this.done=false;
    }*/


    public int getId() {

        return id;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {
        if(title==null)
            throw new IllegalArgumentException("title should not be empty");
        this.title = title;
    }

    public String getTaskDescription() {

        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {

        this.taskDescription = taskDescription;
    }

    public LocalDate getDeadLine() {

        return deadLine;
    }

    public void setDeadLine(LocalDate deadLine) {
        if(deadLine == null)
            throw new IllegalArgumentException("deadLine should not be null");
        this.deadLine = deadLine;
    }

    public void setDone() {
        this.done = !isOverdue();
    }

    public boolean isDone(){
return this.done;
    }

    public Person getCreator() {

        return creator;
    }

    public void setCreator(Person creator) {

        this.creator = creator;
    }
    public boolean isOverdue(){
        LocalDate current = LocalDate.now();
        return current.isAfter(deadLine);
    }
    public String getSummary() {
        String summary = "id:" + id + " title:" + title + " taskDescription:" + taskDescription;

        if (deadLine!= null) {
            summary += " deadLine:" + deadLine.toString();
        } else {
            summary += " deadLine:" + LocalDate.now();
        }

        summary += " done:" + isDone();

        if (creator != null) {
            summary += " creator:" + creator.getFirstName() + " " + creator.getLastName();
        } else {
            summary += " creator:Unknown";
        }

        return summary;
    }
}

