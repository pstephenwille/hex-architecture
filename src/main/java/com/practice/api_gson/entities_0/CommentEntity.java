package com.practice.api_gson.entities_0;

import jakarta.persistence.*;

@Entity
@Table(name = "comments")
public class CommentEntity {
    @Id
    @GeneratedValue
    int id;
    String by;
    @Column(columnDefinition = "TEXT")
    String text;
    int[] kids;
    int parent;
}
