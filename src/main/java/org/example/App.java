package org.example;

import java.time.LocalDate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Person p1 = new Person(4,"john","lithvik","dharani@gmail.com");
        Person p2= new Person(5,"mehrdad","javan","mehrdadjavan@gmail.com");
        System.out.println(p1.toString());
        LocalDate test = LocalDate.of(2024, 3, 22);
        TodoItem item = new TodoItem(5,"changing tire","mechanic person should change the tire",test,p1);
        System.out.println(item.toString());
        TodoItemTask itemtask=new TodoItemTask(6,item,p2);
        System.out.println(itemtask.toString());
    }
}
