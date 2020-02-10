package com.yoandypv.aspectos.auditoria.web;

import com.yoandypv.aspectos.auditoria.entity.Person;
import com.yoandypv.aspectos.auditoria.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PersonResource {

    @Autowired
    private PersonService personService;

    @PostMapping("/api/persons")
    public ResponseEntity<Person> save(@RequestBody Person person) throws Exception {
        Person p = personService.save(person);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @GetMapping("/api/persons/{id}")
    public ResponseEntity<Void> get(@PathVariable("id") Long id) throws Exception {
        personService.findById(id);
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/api/persons/{id}")
    public ResponseEntity<Void> remove(@PathVariable("id") Long id) throws Exception {
        personService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
