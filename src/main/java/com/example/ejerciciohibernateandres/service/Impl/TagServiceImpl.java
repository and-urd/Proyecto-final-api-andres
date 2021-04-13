package com.example.ejerciciohibernateandres.service.Impl;

import com.example.ejerciciohibernateandres.model.Tag;
import com.example.ejerciciohibernateandres.repository.TagRepository;
import com.example.ejerciciohibernateandres.service.TagService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TagServiceImpl implements TagService {


    private final TagRepository tagRepository;
    public TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public Tag createTag(Tag tag) {
        if(tag.getId()==null){
            return tagRepository.save(tag);
        }else{
            return null;
        }
    }

    @Override
    public List<Tag> createTags(List<Tag> tags) {
        List<Tag> result = null;

        if(tags !=null && !tags.isEmpty()){
            for(Tag tag: tags){
                if (tag.getId() != null)
                    return new ArrayList<>();
            }

            result = tagRepository.saveAll(tags);
        }
        return result;
    }

    @Override
    public Tag updateTag(Tag tag) {
        if(tag.getId() != null && tagRepository.existsById(tag.getId())){
            return tagRepository.save(tag);
        }else{
            return null;
        }
    }

    @Override
    public List<Tag> findAllTags() {
        return tagRepository.findAll();
    }

    @Override
    public Optional<Tag> findOne(Long id) {
        return tagRepository.findById(id);
    }

}
