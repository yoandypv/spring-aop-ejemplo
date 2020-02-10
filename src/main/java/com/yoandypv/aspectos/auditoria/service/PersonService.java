package com.yoandypv.aspectos.auditoria.service;

import com.yoandypv.aspectos.auditoria.entity.Person;

import java.util.List;

public interface PersonService {
    Person save(Person person) throws Exception;
    Person findById(Long id) throws Exception;
    void deleteById(Long id);
}
