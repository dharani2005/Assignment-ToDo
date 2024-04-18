package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TodoItemTaskDAOImpl implements TodoItemTaskDAO{
    private List<TodoItemTask> todoItemTaskList = new ArrayList<>();
    public TodoItemTaskDAOImpl() {
        super();
    }

    @Override
    public TodoItemTask persist(TodoItemTask todoItemTask) {
        int id = TodoItemTaskIdSequencer.nextId();
        todoItemTask.setId(id);
        if(todoItemTask==null) throw new IllegalArgumentException("Todoitemtask should not be null");
        for(TodoItemTask todoItemTask1:todoItemTaskList)
        {
            if (todoItemTask1.getId() == todoItemTask.getId())
            {
             if(todoItemTaskList.contains(todoItemTask1)) {
                 throw new IllegalArgumentException("Todoitemtask is already created");
             }
             todoItemTaskList.add(todoItemTask1);
                }
           return todoItemTask1;
        }
        return null;
    }

    @Override
    public TodoItemTask findById(int id) {
        for(TodoItemTask todoItemTask:todoItemTaskList)
        {
            if(todoItemTask.getId()==id)
            {
                return todoItemTask;
            }
        }
        throw new IllegalArgumentException("Todoitemtask with this id is not found");
    }

    @Override
    public Collection<TodoItemTask> findAll() {
        return new ArrayList<>(todoItemTaskList);
    }

    @Override
    public Collection<TodoItemTask> findByAssignedStatus(boolean status) {
        List<TodoItemTask> todoItemTaskList1=new ArrayList<>();
        for(TodoItemTask todoItemTask:todoItemTaskList)
        {
            if(todoItemTask.isAssigned()==status)
            {
                todoItemTaskList1.add(todoItemTask);
            }
        }
        return todoItemTaskList1;
    }

    @Override
    public Collection<TodoItemTask> findByPersonId(TodoItemTask personId) {
        List<TodoItemTask> todoItemTaskList1 = new ArrayList<>();
        for(TodoItemTask todoItemTask:todoItemTaskList){
            if(todoItemTask.getAssignee().getId()==personId.getId())
            {
                todoItemTaskList1.add(todoItemTask);
            }

        }

        return todoItemTaskList1;
    }

    @Override
    public void remove(int id) {
        for (TodoItemTask todoItemTask:todoItemTaskList)
        {
            if(todoItemTask.getId()==id)
            {
                todoItemTaskList.remove(todoItemTask);
            }
          throw new IllegalArgumentException("Todoitemtask with this id is not found to remove");
        }
    }
}
