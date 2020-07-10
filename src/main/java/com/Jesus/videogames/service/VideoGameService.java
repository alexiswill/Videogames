package com.Jesus.videogames.service;


import com.Jesus.videogames.model.VideoGame;
import com.Jesus.videogames.repo.VideoGameRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VideoGameService {

    @Autowired
    private VideoGameRepo videoGameRepo;



    public List<VideoGame> getVideoGame(){
        List<VideoGame> videoGames = new ArrayList<>();
        videoGameRepo.findAll().forEach(videoGames::add);
        return videoGames;

    }

    public Optional<VideoGame> getVideoGameById(Long id){
        return videoGameRepo.findById(id);
    }

    public void addVideoGame(VideoGame videoGame){
        videoGameRepo.save(videoGame);
    }

    public void updateVideoGame(VideoGame videoGame, Long id){
        for (VideoGame vG: videoGameRepo.findAll()){
            if (vG.getId().equals(id)){
                videoGameRepo.save(vG);
            }
        }
    }

    public void deleteVideoGame(Long id){
        videoGameRepo.deleteById(id);
    }


}
