package com.springwithmongo.listteam.entities.Enums;

public enum TaskStatus {
    CREATED(1),
    FINISHED(2),
    WAITING(3),
    INPROGRESS(4),
    CANCELED(5);

    private int code;

    private TaskStatus(int code){
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static TaskStatus valueOf(int code){
        for (TaskStatus value : TaskStatus.values()){
            if (value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Illegal TaskStatus Code Used");
    }

}
