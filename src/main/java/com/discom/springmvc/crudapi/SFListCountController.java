package com.discom.springmvc.crudapi;

import com.discom.springmvc.dao.MultiActionDao;
import com.discom.springmvc.pojo.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Date;

@RestController
@RequestMapping("/api")
public class SFListCountController {

    @Autowired
    MultiActionDao multiActionDao;

    @RequestMapping(value = "/getSF" + "Countrymaster" + "DataListCountJson")
    public @ResponseBody
    String getSFDataListCountJsonCountrymaster(@RequestParam("countycode") String countycode,
                                               @RequestParam("countryname") String countryname) throws JsonProcessingException {

        String cList[] = {"countycode", "countryname"};// column name as in pojo not in database
        String vList[] = {countycode, countryname};// column values
        int dataListCount = multiActionDao.executeDataListCountObjectBuilder(Countrymaster.class, cList, vList);
        return new ObjectMapper().writeValueAsString(dataListCount);
    }

    @RequestMapping(value = "/getSF" + "Jobpostfields" + "DataListCountJson")
    public @ResponseBody
    String getSFDataListCountJsonJobpostfields(@RequestParam("labelName") String labelName,
                                               @RequestParam("fieldName") String fieldName) throws JsonProcessingException {

        String cList[] = {"labelName", "fieldName"};// column name as in pojo not in database
        String vList[] = {labelName, fieldName};// column values
        int dataListCount = multiActionDao.executeDataListCountObjectBuilder(Jobpostfields.class, cList, vList);
        return new ObjectMapper().writeValueAsString(dataListCount);
    }

    @RequestMapping(value = "/getSF" + "Resumefields" + "DataListCountJson")
    public @ResponseBody
    String getSFDataListCountJson(@RequestParam("labelName") String labelName,
                                  @RequestParam("fieldName") String fieldName) throws JsonProcessingException {

        String cList[] = {"labelName", "fieldName"};// column name as in pojo not in database
        String vList[] = {labelName, fieldName};// column values
        int dataListCount = multiActionDao.executeDataListCountObjectBuilder(Resumefields.class, cList, vList);
        return new ObjectMapper().writeValueAsString(dataListCount);
    }

    java.sql.Timestamp getTimeStampDate() {
        Date saveDate = new Date();
        java.sql.Timestamp timeStampDate = new Timestamp(saveDate.getTime());
        return timeStampDate;
    }

    //scheduler


    @RequestMapping(value = "/getSF" + "EmailMaster" + "DataListCountJson")
    public @ResponseBody
    String getSFDataListCountJsonEmailMastersch(@RequestParam("labelName") String labelName,
                                                @RequestParam("fieldName") String fieldName) throws JsonProcessingException {

        String cList[] = {"labelName", "fieldName"};// column name as in pojo not in database
        String vList[] = {labelName, fieldName};// column values
        int dataListCount = multiActionDao.executeDataListCountObjectBuilder(EmailMaster.class, cList, vList);
        return new ObjectMapper().writeValueAsString(dataListCount);
    }

    @RequestMapping(value = "/getSF" + "Resumedata" + "DataListCountJson")
    public @ResponseBody
    String getSFDataListCountJsonsch(@RequestParam("labelName") String labelName,
                                     @RequestParam("fieldName") String fieldName) throws JsonProcessingException {

        String cList[] = {"labelName", "fieldName"};// column name as in pojo not in database
        String vList[] = {labelName, fieldName};// column values
        int dataListCount = multiActionDao.executeDataListCountObjectBuilder(Resumedata.class, cList, vList);
        return new ObjectMapper().writeValueAsString(dataListCount);
    }
}