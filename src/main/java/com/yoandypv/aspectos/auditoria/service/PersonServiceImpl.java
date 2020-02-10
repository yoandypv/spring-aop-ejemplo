package com.yoandypv.aspectos.auditoria.service;

import com.yoandypv.aspectos.auditoria.aop.annotation.GrabExecutionTime;
import com.yoandypv.aspectos.auditoria.aop.annotation.Watcher;
import com.yoandypv.aspectos.auditoria.entity.Person;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Watcher(action = "create")
    @Override
    public Person save(Person person) {
        return person;
    }

    @Override
    public Person findById(Long id) throws Exception {
      if (id < 0)
          throw new Exception("El id debe ser superior a 0");
      return new Person();

    }

    @GrabExecutionTime
    @Override
    public void deleteById(Long id) {
        try {
            Thread.sleep(1500);
            System.out.println("Eliminado el usuario con Id " + id);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
