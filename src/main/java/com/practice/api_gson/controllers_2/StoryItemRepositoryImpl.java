package com.practice.api_gson.controllers_2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.practice.api_gson.drivers_3.AppRepository;
import com.practice.api_gson.drivers_3.StoryItemRepo;
import com.practice.api_gson.entities_0.CommentEntity;
import com.practice.api_gson.entities_0.StoryItemEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class StoryItemRepositoryImpl implements AppRepository {

    private final StoryItemRepo storyItemRepo;

    @Autowired
    public StoryItemRepositoryImpl(StoryItemRepo storyItemRepo) {
        this.storyItemRepo = storyItemRepo;
    }

    @Override
    public StoryItemEntity getStoryByTitle(String title) {
        return null;
    }

    public Iterable<StoryItemEntity> getAllTopStories(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<StoryItemEntity> items = storyItemRepo.findAll(pageable);

        return items;
    }

    public Optional<StoryItemEntity> getStoryById(int storyId) {
        return storyItemRepo.findById(storyId);
    }


    @Override
    public Iterable<StoryItemEntity> saveAllStoryItems(List<StoryItemDto> allStoryItems) {
        Gson gson = new Gson();
        var allStoryEntities = allStoryItems.stream()
                .map(gson::toJson)
                .map(item -> new GsonBuilder().create().fromJson(item, StoryItemEntity.class))
                .toList();

        return storyItemRepo.saveAll(allStoryEntities);
    }

    @Override
    public Iterable<StoryItemEntity> saveAllStories(List<StoryItemEntity> stories) {
        return null;
    }

    @Override
    public Iterable<CommentEntity> saveAllComments(List<CommentEntity> comments) {
        return null;
    }
}
