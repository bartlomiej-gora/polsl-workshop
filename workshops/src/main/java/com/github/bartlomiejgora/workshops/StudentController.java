package com.github.bartlomiejgora.workshops;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
public class StudentController {

    @GetMapping("students")
    public List<String> get(){
        var list = new LinkedList<String>();
        list.add("Bartek");
        list.add("Natalia");
        return list;
    }
}
