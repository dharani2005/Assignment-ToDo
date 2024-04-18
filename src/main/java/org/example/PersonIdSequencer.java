package org.example;

public class PersonIdSequencer {
    private static int currentId = 100;

    public static int getCurrentId() {
        return currentId;
    }

    public static void setCurrentId(int currentId) {
        PersonIdSequencer.currentId = currentId;
    }

    public static int nextId(){
        return ++currentId;
    }

}
