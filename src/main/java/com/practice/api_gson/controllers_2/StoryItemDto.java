package com.practice.api_gson.controllers_2;

import lombok.Data;

@Data
public class StoryItemDto {
    int id;
    String by;
    int[] kids;
    String title;
    String type;
}
