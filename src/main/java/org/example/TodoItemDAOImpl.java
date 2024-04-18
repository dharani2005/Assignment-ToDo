package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TodoItemDAOImpl implements TodoItemDAO{
    private List<TodoItem> todoItemList = new ArrayList<>();
    public TodoItemDAOImpl() {
        super();
    }

    @Override
    public TodoItem persist(TodoItem todoItem) {
        if(todoItem==null)throw new IllegalArgumentException("Todoitem cannot be null");
        for(TodoItem todoItem1:todoItemList)
        {
            if(todoItem1.getTitle().equals(todoItem.getTitle())){
                throw new IllegalArgumentException("Todoitem cannot be same title");
            }
        }
        int id = TodoItemIdSequencer.nextId();
        todoItem.setId(id);
        todoItemList.add(todoItem);
        return todoItem;
    }

    @Override
    public TodoItem findById(int id) {
        for(TodoItem todoItem:todoItemList)
        {
            if(todoItem.getId()==id){
                return todoItem;
            }
        }
        throw new IllegalArgumentException("TodoItem with this id is not found");
    }

    @Override
    public Collection<TodoItem> findAll() {
        return new ArrayList<>(todoItemList);
    }

    @Override
    public Collection<TodoItem> findAllByDoneStatus(boolean done) {
        List<TodoItem> todoItems = new ArrayList<>();
        for(TodoItem todoItem:todoItemList)
        {
            if(todoItem.isDone()==done){
                todoItems.add(todoItem);
            }
        }
        return todoItems;
    }

    @Override
    public Collection<TodoItem> findByTitleContains(String title) {
        List<TodoItem> todoItems = new ArrayList<>();
        for(TodoItem todoItem:todoItemList)
        {
            if(todoItem.getTitle()==title)
            {
                todoItems.add(todoItem);
            }
        }
        return todoItems;
    }

    @Override
    public Collection<TodoItem> findByPersonId(TodoItem personId) {
        List<TodoItem> todoItems = new ArrayList<>();
        for(TodoItem todoItem:todoItemList)
        {//TODO:
            if(todoItem.getCreator().getId()==personId.getId()){
                todoItems.add(todoItem);
            }
        }
        return todoItems;
    }

    @Override
    public Collection<TodoItem> findByDeadlineBefore(LocalDate date) {
        //TODO:
        if(date==null)throw new IllegalArgumentException("Date should not be null");
        List<TodoItem> todoItemListBeforeDeadline = new ArrayList<>();

        for(TodoItem todoItem : todoItemList)
        {
            if(date.isBefore(todoItem.getDeadLine()))
            {
                todoItemListBeforeDeadline.add(todoItem);
            }
        }
        return todoItemListBeforeDeadline;
    }

    @Override
    public Collection<TodoItem> findByDeadlineAfter(LocalDate date) {
        if(date==null)throw new IllegalArgumentException("Date should not be null");
        List<TodoItem> todoItemListAfterDeadline = new ArrayList<>();

        for(TodoItem todoItem : todoItemList)
        {
            if(date.isAfter(todoItem.getDeadLine()))
            {
                todoItemListAfterDeadline.add(todoItem);
            }
        }
        return todoItemListAfterDeadline;
    }

    @Override
    public void remove(int id) {
        for(TodoItem todoItem:todoItemList)
        {
            if(todoItem.getId()==id){
                todoItemList.remove(todoItem);
            }
            throw new IllegalArgumentException("Todoitem with this Id is not found to remove ");
        }
    }
}
