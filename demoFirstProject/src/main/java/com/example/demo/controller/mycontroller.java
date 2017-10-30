package com.example.demo.controller;


import com.example.demo.dao.CurdResposity;
import com.example.demo.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class mycontroller {
    @Autowired
    CurdResposity curdResposity;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String indexPage(){
        return "hello word";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String function(@RequestParam ("id") String id){
        return "hello word" + id + " aaa";
    }

    /**
     * select
     * @return
     */
    @RequestMapping(value = "/select", method = RequestMethod.GET)
    public List<Person> selectAllPerson(){
        return curdResposity.findAll();
    }

    /**
     * insert into one persion info
     * @param name
     * @param address
     * @return person info
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Person updateAddPerson(@RequestParam("Name") String name,
                                  @RequestParam("Address") String address){
        Person p = new Person();
        p.setName(name);
        p.setAddress(address);
        return curdResposity.save(p);

    }
    /**
     * insert into one persion info by class
     * @param person
     * @return person info
     */
    @RequestMapping(value = "/update1", method = RequestMethod.POST)
    public Person updateAddPerson1(Person person){
        Person p = new Person();
        p.setName(person.getName());
        p.setAddress(person.getAddress());
        return curdResposity.save(p);

    }

    /**
     * search person info by id
     * @param id
     * @return person info by id search
     */
    @RequestMapping(value = "/select/{Id}", method = RequestMethod.GET)
    public Person selectById(@PathVariable("Id") Integer id){
        return curdResposity.findOne(id);
    }

    /**
     * modify by id
     * @param id
     * @param name
     * @param address
     * @return person modify value
     */
    @RequestMapping(value = "/modify/{Id}", method = RequestMethod.PUT)
    public Person updateById(@PathVariable("Id") Integer id,
                             @RequestParam("Name") String name,
                             @RequestParam("Address") String address){

        Person p = new Person();
        p.setId(id);
        p.setName(name);
        p.setAddress(address);

        return curdResposity.save(p);
    }

    /**
     * delete by id
     * @param id
     */
    @RequestMapping(value = "/delete/{Id}", method = RequestMethod.DELETE)
    public void  deleteById(@PathVariable("Id") Integer id){
        curdResposity.delete(id);
    }

    /**
     * select by name
     * @param name
     * @return
     */
    @RequestMapping(value = "/selectByName/{Name}", method = RequestMethod.GET)
    public List<Person> selectByName(@PathVariable("Name") String name){
        return curdResposity.findByName(name);
    }

}
