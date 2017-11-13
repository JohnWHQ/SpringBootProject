package com.example.demo.controller;


import com.example.demo.dao.ModelCurdResposity;
import com.example.demo.domain.Person;
import com.example.demo.domain.Result;
import com.example.demo.service.PersonService;
import com.example.demo.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ModelController {

    @Autowired
    ModelCurdResposity curdResposity;

    @Autowired
    PersonService personService;


    /**
     * 首页根目录匹配 /
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String indexPage(){
        return "hello word";
    }

    /**
     * 匹配测试函数
     * @return
     */
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public String indexPage1(){
        return "test";
    }

    /**
     * 匹配带参测试函数
     * @param id
     * @return
     */
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String function(@RequestParam ("id") String id){
        return "hello word" + id + " index";
    }



    /**
     * jpa select 操作查询表中所有数据
     * @return List
     */
    @RequestMapping(value = "/select", method = RequestMethod.GET)
    public List<Person> selectAllPerson(){
        return curdResposity.findAll();
    }


    /**
     * jpa insert 操作插入表中一条记录(通过参数插)
     * @param name
     * @param address
     * @return person info
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Person insertAddPerson(@RequestParam("Name") String name,
                                  @RequestParam("Address") String address){
        Person p = new Person();
        p.setName(name);
        p.setAddress(address);
        return curdResposity.save(p);

    }
    /**
     *  jpa insert 操作插入表中一条记录(通过实体插)
     * @param person
     * @return person info
     */
    @RequestMapping(value = "/update1", method = RequestMethod.POST)
    public Person insertAddPerson1(Person person){
        Person p = new Person();
        p.setName(person.getName());
        p.setAddress(person.getAddress());
        return curdResposity.save(p);

    }

    /**
     * 通过id查一条记录
     * @param id
     * @return person info by id search
     */
    @RequestMapping(value = "/select/{Id}", method = RequestMethod.GET)
    public Person selectById(@PathVariable("Id") Integer id){
        return curdResposity.findOne(id);
    }


    /**
     * jpa update 操作通过id更新
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
     * jpa delete 操作通过id删
     * @param id
     */
    @RequestMapping(value = "/delete/{Id}", method = RequestMethod.DELETE)
    public void  deleteById(@PathVariable("Id") Integer id){
        curdResposity.delete(id);
    }



    /**
     * jpa select 操作通过重写jpa接口实现by任何字段查值
     * @param name
     * @return
     */
    @RequestMapping(value = "/selectByName/{Name}", method = RequestMethod.GET)
    public List<Person> selectByName(@PathVariable("Name") String name){
        return curdResposity.findByName(name);
    }


    /**
     * 统一返回模板
     * @param person
     * @return
     */
    @RequestMapping(value = "/update2", method = RequestMethod.POST)
    public Result<Person> updateAddPerson2(Person person){

        if (person.getName() == null || person.getName() == "") {
            return ResultUtil.fail(0, "name empty");
        }

        Person p = new Person();
        p.setName(person.getName());
        p.setAddress(person.getAddress());

        return ResultUtil.success(curdResposity.save(p));

    }

    /**
     * service 层调用模板
     * @param id
     * @throws Exception
     */
    @RequestMapping(value = "/test1/{id}", method = RequestMethod.GET)
    public void getId(@PathVariable("id") Integer id) throws Exception{
        personService.getAddress(id);
    }

}
