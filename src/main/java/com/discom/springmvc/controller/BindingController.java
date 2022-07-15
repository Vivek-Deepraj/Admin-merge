package com.discom.springmvc.controller;

import com.discom.springmvc.dao.MultiActionDao;
import com.discom.springmvc.dao.SearchDao;
import com.discom.springmvc.pojo.Constantslistsdetails;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BindingController {

    @Autowired
    MultiActionDao multiActionDao;
    @Autowired
    SearchDao searchDao;

    //Test/Perform all Actions on Studenttestentity entity
    //save update delete actions on pojo object

    //datalist/count of pojo object
    @RequestMapping(value = "/getGeneralEntityDataTypesJson")
    public @ResponseBody
    String getStudenttestentityDataListJson() throws JsonProcessingException {

        List<Constantslistsdetails> dataListObject = searchDao.findMasterDataTypes();
        List<String> types = new ArrayList<String>();
        for (Constantslistsdetails cld : dataListObject) {
            types.add(cld.getType());
        }
        return new ObjectMapper().writeValueAsString(types);
    }

    @RequestMapping(value = "/getGeneralEntityDataListsJson")
    public @ResponseBody
    String getGeneralEntityDataListsJson(@RequestParam("type") String type) throws JsonProcessingException {

        String cList[] = {"type"};// column name as in pojo not in database
        String vList[] = {type};// column values
        List<?> dataListObject = multiActionDao.executeDataListObjectBuilder(Constantslistsdetails.class, cList, vList);
        return new ObjectMapper().writeValueAsString(dataListObject);
    }

    java.sql.Timestamp getTimeStampDate() {
        Date saveDate = new Date();
        java.sql.Timestamp timeStampDate = new Timestamp(saveDate.getTime());
        return timeStampDate;
    }
}