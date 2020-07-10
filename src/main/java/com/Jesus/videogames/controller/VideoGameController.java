package com.Jesus.videogames.controller;

import com.Jesus.videogames.dto.SuccessfulResponseDetail;
import com.Jesus.videogames.model.VideoGame;
import com.Jesus.videogames.service.VideoGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class VideoGameController {

    @Autowired
    private VideoGameService videoGameService;

    @RequestMapping(method = RequestMethod.GET, value = "/videogames")
    public ResponseEntity getAllVideoGames(){
        List<VideoGame> videoGames = videoGameService.getVideoGame();
        SuccessfulResponseDetail successfulResponseDetail = new SuccessfulResponseDetail(HttpStatus.OK.value(), "Videogame have been retrieved", videoGames);
        return new ResponseEntity(successfulResponseDetail, HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.GET, value = "/videogames/{id}")
    public ResponseEntity<Optional<VideoGame>>getVideoGameById(@PathVariable  Long id){
        Optional<VideoGame> videoGame = videoGameService.getVideoGameById(id);
        SuccessfulResponseDetail successfulResponseDetail = new SuccessfulResponseDetail(HttpStatus.OK.value(), "Successfully Retrieved ", videoGame);
        return new ResponseEntity(successfulResponseDetail, HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.POST, value = "/videogames")
    public ResponseEntity<?>addVideoGame(@Valid @RequestBody VideoGame videoGame){
        videoGameService.addVideoGame(videoGame);
        HttpHeaders httpHeaders = new HttpHeaders();
        URI newMovieUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/videogames")
                .buildAndExpand(videoGame.getId())
                .toUri();
        httpHeaders.setLocation(newMovieUri);
        return new ResponseEntity<>(videoGame, httpHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/videogames/{id}")
    public ResponseEntity<?> updateVideoGame(@Valid @RequestBody VideoGame videoGame, @PathVariable Long id){
        videoGameService.updateVideoGame(videoGame, id);
        SuccessfulResponseDetail successfulResponseDetail = new SuccessfulResponseDetail(HttpStatus.ACCEPTED.value(), "Videogame updated!", videoGame);
        return new ResponseEntity<>(successfulResponseDetail, HttpStatus.ACCEPTED);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/videogames/{id}")
    public ResponseEntity<?>deleteVideoGame(@PathVariable Long id){
        videoGameService.deleteVideoGame(id);
        SuccessfulResponseDetail successfulResponseDetail = new SuccessfulResponseDetail(HttpStatus.NO_CONTENT.value(), "Videogame deleted");
        return new ResponseEntity<>(successfulResponseDetail, HttpStatus.NO_CONTENT);
    }
}


