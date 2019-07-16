package com.example.only_lomok_for_reactive_web.Entity;


import lombok.Data;

import java.time.LocalDateTime;


@Data
public class Table_ToDo{


    private String id;
    private String description;
    private LocalDateTime created;
    private LocalDateTime modified;
    private boolean competed;


    public Table_ToDo() {

    }


    public Table_ToDo(String description) {
        this();
        this.description=description;
    }

    public Table_ToDo(String description, boolean competed) {
        this();
        this.competed=competed;
    }
}
