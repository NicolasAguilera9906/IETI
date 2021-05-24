package eci.ieti.controller;


import eci.ieti.data.model.Todo;
import eci.ieti.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;

@RequestMapping("api")
@RestController
public class RESTController {

    @Autowired
    FileService fileService;

    @CrossOrigin("*")
    @RequestMapping("/files/{filename}")
    public ResponseEntity<Object> getFileByName(@PathVariable String filename) {
        GridFsResource file = null;
        try {
            file = fileService.getFileByName(filename);
            return ResponseEntity.ok()
                    .contentType(MediaType.valueOf(file.getContentType()))
                    .body(new InputStreamResource(file.getInputStream()));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin("*")
    @PostMapping("/files")
    public ResponseEntity<Object> handleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes){
        try {
            fileService.handleFileUpload(file);
        } catch (IOException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity("http://localhost:8080/api/files/"+file.getOriginalFilename(),HttpStatus.CREATED);
    }

    @CrossOrigin("*")
    @PostMapping("/todo")
    public Todo createTodo(@RequestBody Todo todo) {
        //TODO implement method
        return null;
    }

    @CrossOrigin("*")
    @GetMapping("/todo")
    public List<Todo> getTodoList() {
        //TODO implement method
        return null;
    }

}
