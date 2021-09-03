package com.nguyentai.notesapp.controller;

import com.nguyentai.notesapp.entity.Note;
import com.nguyentai.notesapp.repository.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class NotesController {

    @Autowired
    NotesRepository notesRepository;

    @GetMapping("/notes")
    public ResponseEntity<List<Note>> readNotes () {
        return new ResponseEntity<>(notesRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/notes")
    public ResponseEntity<Note> addNote(@RequestBody Note note) {
        return new ResponseEntity<>(notesRepository.save(note), HttpStatus.CREATED);
    }
}
