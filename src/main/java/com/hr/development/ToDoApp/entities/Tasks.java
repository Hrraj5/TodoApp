package com.hr.development.ToDoApp.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "task_details")
@Getter
@Setter
public class Tasks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Integer taskId;
    @Column(name = "task_name")
    private String taskName;
    @Column(name = "task_description", length = 1024)
    private String taskDescription;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id")
    private User user;
}
