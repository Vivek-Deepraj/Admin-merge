package com.discom.springmvc.controller;

import com.discom.springmvc.dao.SearchDao;
import com.discom.springmvc.pojo.Constantslistsdetails;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api")
public class GlobalRestApiController {

    @Autowired
    SearchDao searchDao;

    //pass type like 'Gender', 'Marital Status', 'Services', 'Paid Services', 'Advertise Type', 'Resume' to bind data
    @GetMapping(value = {"/getMasterData_type"})
    public String getMasterDataService(@RequestParam(value = "type") String type) throws JsonProcessingException {
        List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
        List<Constantslistsdetails> details = searchDao.findMasterDataByType(type);
        for (Constantslistsdetails detail : details) {
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("code", detail.getCode());
            map.put("label", detail.getLabel());
            list.add(map);
        }
        if (list.size() == 0) {
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("code", "");
            map.put("label", "Data Not Found!");
            list.add(map);
        }
        return new ObjectMapper().writeValueAsString(list);
    }

    //pass type like 'Gender', 'Marital Status' and code like gen_male, gen_female, ms_married to bind data
    @GetMapping(value = {"/getMasterData_type_code"})
    public String getMasterDataService(@RequestParam(value = "type") String type, @RequestParam(value = "code") String code) throws JsonProcessingException {
        List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
        Constantslistsdetails detail = searchDao.findMasterDataByType(type, code);
        if (detail != null) {
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("code", detail.getCode());
            map.put("label", detail.getLabel());
            list.add(map);
        }
        if (list.size() == 0) {
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("code", "");
            map.put("label", "Data Not Found!");
            list.add(map);
        }
        return new ObjectMapper().writeValueAsString(list);
    }
}
