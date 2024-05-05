package com.practice.api_gson.controllers_2;

//@Data
public record CommentDto(int id,
                         String by,
                         String text,
                         int[] kids,
                         String parent,
                         String type) {
};
