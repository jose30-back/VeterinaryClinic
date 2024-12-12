package dev.group4.veterinaryClinic.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import dev.group4.veterinaryClinic.Models.Tutor;
import dev.group4.veterinaryClinic.Services.TutorService;

import java.util.List;

@RestController
@RequestMapping(path="${api-endpoint}/tutores")
public class TutorController {
    @Autowired
    private TutorService tutorService;

    @GetMapping
    public ResponseEntity<List<Tutor>> getAllTutores() {
        return new ResponseEntity<>(tutorService.getAllTutores(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tutor> getTutorById(@PathVariable Long id) {
        return new ResponseEntity<>(tutorService.getTutorById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Tutor> createTutor(@RequestBody Tutor tutor) {
        return new ResponseEntity<>(tutorService.createTutor(tutor), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tutor> updateTutor(@PathVariable Long id, @RequestBody Tutor tutor) {
        return new ResponseEntity<>(tutorService.updateTutor(id, tutor), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTutor(@PathVariable Long id) {
        tutorService.deleteTutor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

