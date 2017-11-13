package com.example.demo.service;

import com.example.demo.dao.ModelCurdResposity;
import com.example.demo.domain.Person;
import com.example.demo.enums.ResultEnum;
import com.example.demo.exception.PersonException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    ModelCurdResposity curdResposity;

    public void getAddress(Integer id) throws Exception{
        Person per = curdResposity.findOne(id);
        if (per.getAddress().equals("shenzhen")) {
            throw new PersonException(ResultEnum.DIY);
        }
        if (per.getAddress().equals("shanghai")) {
            throw new PersonException(ResultEnum.DIY);
        }
    }

}
