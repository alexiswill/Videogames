package com.Jesus.videogames.repo;

import com.Jesus.videogames.model.VideoGame;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoGameRepo extends CrudRepository<VideoGame, Long> {

}
