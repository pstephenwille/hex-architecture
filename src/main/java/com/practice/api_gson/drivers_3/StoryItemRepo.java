package com.practice.api_gson.drivers_3;

import com.practice.api_gson.entities_0.StoryItemEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface StoryItemRepo extends CrudRepository<StoryItemEntity, Integer> {
    Page<StoryItemEntity> findAll(Pageable pageable);

    StoryItemEntity findByTitle(String story_id);

    StoryItemEntity findByStoryId(int story_id);

}
