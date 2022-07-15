package com.discom.springmvc.crudapi;

import com.discom.springmvc.dao.MultiActionDao;
import com.discom.springmvc.pojo.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ListController {

    @Autowired
    MultiActionDao multiActionDao;

    @RequestMapping(value = "/get" + "Countrymaster" + "DataListJson")
    public @ResponseBody
    String getDataListJsonCountrymaster() throws JsonProcessingException {

        List<?> dataListObject = multiActionDao.executeDataListObjectBuilder(Countrymaster.class);
        return new ObjectMapper().writeValueAsString(dataListObject);
    }

    @RequestMapping(value = "/get" + "Newscategory" + "DataListJson")
    public @ResponseBody
    String getDataListJsonNewscategory() throws JsonProcessingException {

        List<?> dataListObject = multiActionDao.executeDataListObjectBuilder(Newscategory.class);
        return new ObjectMapper().writeValueAsString(dataListObject);
    }

    @RequestMapping(value = "/get" + "Jobpostfields" + "DataListJson")
    public @ResponseBody
    String getDataListJsonJobpostfields() throws JsonProcessingException {

        List<?> dataListObject = multiActionDao.executeDataListObjectBuilder(Jobpostfields.class);
        return new ObjectMapper().writeValueAsString(dataListObject);
    }

    @RequestMapping(value = "/get" + "Resumefields" + "DataListJson")
    public @ResponseBody
    String getDataListJsonResumefields() throws JsonProcessingException {

        List<?> dataListObject = multiActionDao.executeDataListObjectBuilder(Resumefields.class);
        return new ObjectMapper().writeValueAsString(dataListObject);
    }

    @RequestMapping(value = "/get" + "TemplateGroupsFields" + "DataListJson")
    public @ResponseBody
    String getDataListJsonTemplateGroupsFields() throws JsonProcessingException {

        List<?> dataListObject = multiActionDao.executeDataListObjectBuilder(TemplateGroupsFields.class);
        return new ObjectMapper().writeValueAsString(dataListObject);
    }

    @RequestMapping(value = "/get" + "TemplateGroupsFieldsChilds" + "DataListJson")
    public @ResponseBody
    String getDataListJsonTemplateGroupsFieldsChilds() throws JsonProcessingException {

        List<?> dataListObject = multiActionDao.executeDataListObjectBuilder(TemplateGroupsFieldsChilds.class);
        return new ObjectMapper().writeValueAsString(dataListObject);
    }

    @RequestMapping(value = "/get" + "Candidatefaqs" + "DataListJson")
    public @ResponseBody
    String getDataListJson() throws JsonProcessingException {

        List<?> dataListObject = multiActionDao.executeDataListObjectBuilder(Candidatefaqs.class);
        return new ObjectMapper().writeValueAsString(dataListObject);
    }


    @RequestMapping(value = "/get" + "LastTemplateGroupsFieldsChilds")
    public @ResponseBody
    TemplateGroupsFieldsChilds getLastTemplateGroupField() throws JsonProcessingException {
        TemplateGroupsFieldsChilds response = new TemplateGroupsFieldsChilds();
        response = multiActionDao.getTemplateGroupsFieldsChilds();
        return response;
    }


    java.sql.Timestamp getTimeStampDate() {
        Date saveDate = new Date();
        java.sql.Timestamp timeStampDate = new Timestamp(saveDate.getTime());
        return timeStampDate;
    }

    //scheduler

    @RequestMapping(value = "/get" + "EmailMaster" + "DataListJson")
    public @ResponseBody
    String getDataListJsonEmailMaster() throws JsonProcessingException {

        List<?> dataListObject = multiActionDao.executeDataListObjectBuilder(EmailMaster.class);
        return new ObjectMapper().writeValueAsString(dataListObject);
    }
/*
	@RequestMapping(value = "/get"+"Resumedata"+"DataListJson")
	public @ResponseBody String getDataListJson() throws JsonProcessingException {


		return new ObjectMapper().writeValueAsString("test");
	}*/
}