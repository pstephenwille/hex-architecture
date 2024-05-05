package com.practice.api_gson.drivers_3;

import com.practice.api_gson.controllers_2.StoryItemDto;
import com.practice.api_gson.entities_0.CommentEntity;
import com.practice.api_gson.entities_0.StoryItemEntity;

import java.util.List;
import java.util.Optional;

public interface AppRepository {
    Iterable<StoryItemEntity> saveAllStories(List<StoryItemEntity> stories);

    StoryItemEntity getStoryByTitle(String title);

    Iterable<StoryItemEntity> getAllTopStories(int page, int size);

    Optional<StoryItemEntity> getStoryById(int storyId);

    Iterable<StoryItemEntity> saveAllStoryItems(List<StoryItemDto> allStoryItems);

    Iterable<CommentEntity> saveAllComments(List<CommentEntity> comments);
}
