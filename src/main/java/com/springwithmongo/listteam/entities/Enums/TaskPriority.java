package com.springwithmongo.listteam.entities.Enums;

public enum TaskPriority {
    URGENT(1),
    MODERATE(2),
    LOW(3);

    private int code;

    private TaskPriority (int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    public static TaskPriority valueOf(int code){
        for(TaskPriority taskPriority : TaskPriority.values()){
            if (taskPriority.getCode() == code){
                return taskPriority;
            }
        }
        throw new IllegalArgumentException("Illegal TaskPriority Code Used");
    }
}
