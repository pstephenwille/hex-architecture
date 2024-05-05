package com.practice.api_gson.entities_0;

import jakarta.persistence.*;

@Entity
@Table(name = "stories")
public class    StoryItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "story_id")
    public int storyId;
    String by;
    public int[] kids;
    String title;
    String type;

    @PrePersist
    private void setStoryId() {
        this.storyId = this.id;
    }
}
