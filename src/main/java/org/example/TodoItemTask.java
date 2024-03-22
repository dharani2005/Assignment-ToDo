package org.example;

public class TodoItemTask {
    private int id;
    private boolean assigned;
    private TodoItem todoItem;
    private Person assignee;

    public TodoItemTask(int id, TodoItem todoItem, Person assignee) {
        this.id = id;
        this.todoItem = todoItem;
        this.assignee = assignee;
    }
    public TodoItemTask(int id, TodoItem todoItem) {
        this.id = id;
        this.todoItem = todoItem;
    }

    public int getId() {
        return id;
    }
    public boolean isAssigned()
    {
    return assignee!=null;
    }


    public TodoItem getTodoItem() {
        return todoItem;
    }

    public void setTodoItem(TodoItem todoItem) {
        if(todoItem == null)
            throw new IllegalArgumentException("Todo item can not be null");

        this.todoItem = todoItem;
    }

    public Person getAssignee() {
        return assignee;
    }

    public void setAssignee(Person assignee) {
        this.assignee = assignee;
    }

    public String getSummary() {
        String summary;
        if (isAssigned()) {
            summary = "id:" + id + ", assigned:true";
        } else {
            summary = "id:" + id + ", assigned:false";
        }

        if (todoItem != null) {
            if (todoItem.isDone()&&isAssigned()) {
                summary += ", todoitem: done";
            } else {
                summary += ", todoitem: not done";
            }
        } else {
            summary += ", todoitem: null";
        }

        if (assignee != null) {
            String firstName = assignee.getFirstName();
            String lastName = assignee.getLastName();
            if (firstName != null) {
                summary += ", assignee:" + firstName;
            } else {
                summary += ", assignee: null";
            }
            if (lastName != null) {
                summary += " " + lastName;
            } else {
                summary += " null";
            }
        } else {
            summary += ", assignee: null";
        }

        return summary;
    }



}
