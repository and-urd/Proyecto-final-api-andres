//package com.example.ejerciciohibernateandres.service.Impl;
//
//import com.example.ejerciciohibernateandres.model.Tag;
//import com.example.ejerciciohibernateandres.model.Task;
//import com.example.ejerciciohibernateandres.repository.TaskRepository;
//import com.example.ejerciciohibernateandres.service.TagService;
//import com.example.ejerciciohibernateandres.service.TaskService;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class TaskServiceImpl implements TaskService {
//
//    private final TaskRepository taskRepository;
//    private final TagService tagService;
//    public TaskServiceImpl(TaskRepository taskRepository, TagService tagService) {
//        this.taskRepository = taskRepository;
//        this.tagService = tagService;
//    }
//
//    @Override
//    public Task createTask(Task task) {
//        Task taskNueva = null;
//        if (task.getId() == null) {
//                task.setTags(tagService.createTags(task.getTags()));
//                return taskRepository.save(task);
//        }else{
//            return null;
//        }
//    }
//
//    @Override
//    public Task updateTask(Task task) {
//        Task taskActualizada = null;
//        if (task.getId() != null && taskRepository.existsById(task.getId())) {
//                for (Tag tag: task.getTags()) {
//                    if(tag.getId()!=null){
//                        tagService.updateTag(tag);
//                    }else{
//                        tagService.createTag(tag);
//                    }
//                }
//                 return taskActualizada = taskRepository.save(task);
//        }else{
//            return null;
//        }
//    }
//
//    @Override
//    public List<Task> findAllTasks() {
//        return taskRepository.findAll();
//    }
//
//    @Override
//    public Optional<Task> findOneTask(Long id) {
//        return taskRepository.findById(id);
//    }
//}
