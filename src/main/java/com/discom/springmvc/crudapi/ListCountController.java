package com.discom.springmvc.crudapi;

import com.discom.springmvc.dao.MultiActionDao;
import com.discom.springmvc.pojo.Countrymaster;
import com.discom.springmvc.pojo.Jobpostfields;
import com.discom.springmvc.pojo.Resumefields;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Date;

@RestController
@RequestMapping("/api")
public class ListCountController {

    @Autowired
    MultiActionDao multiActionDao;

    @RequestMapping(value = "/get" + "Countrymaster" + "DataListCountJson")
    public @ResponseBody
    String getDataListCountJsonCountrymaster() throws JsonProcessingException {

        int dataListCount = multiActionDao.executeDataListCountObjectBuilder(Countrymaster.class);
        return new ObjectMapper().writeValueAsString(dataListCount);
    }

    @RequestMapping(value = "/get" + "Jobpostfields" + "DataListCountJson")
    public @ResponseBody
    String getDataListCountJsonJobpostfields() throws JsonProcessingException {

        int dataListCount = multiActionDao.executeDataListCountObjectBuilder(Jobpostfields.class);
        return new ObjectMapper().writeValueAsString(dataListCount);
    }

    @RequestMapping(value = "/get" + "Resumefields" + "DataListCountJson")
    public @ResponseBody
    String getDataListCountJson() throws JsonProcessingException {

        int dataListCount = multiActionDao.executeDataListCountObjectBuilder(Resumefields.class);
        return new ObjectMapper().writeValueAsString(dataListCount);
    }

    java.sql.Timestamp getTimeStampDate() {
        Date saveDate = new Date();
        java.sql.Timestamp timeStampDate = new Timestamp(saveDate.getTime());
        return timeStampDate;
    }
    //scheduler


}