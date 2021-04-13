package com.example.ejerciciohibernateandres.controller;

import com.example.ejerciciohibernateandres.dao.TagDAO;
import com.example.ejerciciohibernateandres.model.Tag;
import com.example.ejerciciohibernateandres.model.TagColor;
import com.example.ejerciciohibernateandres.service.TagService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TagController {

    private final TagService tagService;
    private final TagDAO tagDAO;
    public TagController(TagService tagService, TagDAO tagDAO) {
        this.tagService = tagService;
        this.tagDAO = tagDAO;
    }

    // Crear un tag
    @PostMapping("/tag")
    public ResponseEntity<Tag> createTag(@RequestBody Tag tag){

        Tag resultTag = tagService.createTag(tag);

        if(resultTag == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else{
            return ResponseEntity.ok().body(resultTag);
        }
    }

    // Crear lista de tags
    @PostMapping("/tag/list")
    public ResponseEntity<List<Tag>> createListTags(@RequestBody List<Tag> tags){
        List<Tag> tagsList = tagService.createTags(tags);

        if(tagsList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else{
            return ResponseEntity.ok().body(tagsList);
        }
    }

    // Actualiza tag
    @PutMapping("/tag")
    public ResponseEntity<Tag> updateTag(@RequestBody Tag tag){
        Tag tagResult = tagService.updateTag(tag);
        if(tagService == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else{
            return ResponseEntity.ok().body(tagResult);
        }

    }

    // Recupera todas las tag
    @GetMapping("/tags")
    public  ResponseEntity<List<Tag>> findAllTags(){

        List<Tag> tagList = tagService.findAllTags();
        if(tagList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return ResponseEntity.ok().body(tagList);
        }
    }

    // Recupera una tag
    @GetMapping("/tag/{id}")
    public ResponseEntity<Optional<Tag>> findOne(@PathVariable Long id){
        Optional<Tag> tagResult = tagService.findOne(id);

        if(tagResult.isPresent()){
            return ResponseEntity.ok().body(tagResult);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Recupera list tag por color
    @GetMapping("/tag/color/{color}")
    public ResponseEntity<List<Tag>> findByTagColor(@PathVariable TagColor color){

        List<Tag> tagList = tagDAO.findByColorTag(color);

        if(tagList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return ResponseEntity.ok().body(tagList);
        }
    }
}
