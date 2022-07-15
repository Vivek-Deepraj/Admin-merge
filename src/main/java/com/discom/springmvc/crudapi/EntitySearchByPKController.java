package com.discom.springmvc.crudapi;

import com.discom.springmvc.dao.MultiActionDao;
import com.discom.springmvc.pojo.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EntitySearchByPKController {

    @Autowired
    MultiActionDao multiActionDao;

    @RequestMapping(value = "/get" + "Countrymaster" + "PojoObjectJson")
    public @ResponseBody
    String getPojoObjectJsonCountrymaster(@RequestParam("id") String id) throws JsonProcessingException {

        String cList[] = {"id"};// column name as in pojo not in database
        String vList[] = {id};// column values
        Object pojoObject = multiActionDao.executePojoObjectBuilder2(Countrymaster.class, cList, vList);
        return new ObjectMapper().writeValueAsString(pojoObject);
    }

    @RequestMapping(value = "/get" + "Newscategory" + "PojoObjectJson")
    public @ResponseBody
    String getPojoObjectJsonNewscategory(@RequestParam("id") String id) throws JsonProcessingException {

        String cList[] = {"id"};// column name as in pojo not in database
        String vList[] = {id};// column values
        Object pojoObject = multiActionDao.executePojoObjectBuilder2(Newscategory.class, cList, vList);
        return new ObjectMapper().writeValueAsString(pojoObject);
    }

    @RequestMapping(value = "/get" + "News" + "PojoObjectJson")
    public @ResponseBody
    String getPojoObjectJsonNews(@RequestParam("id") String id) throws JsonProcessingException {

        String cList[] = {"id"};// column name as in pojo not in database
        String vList[] = {id};// column values
        Object pojoObject = multiActionDao.executePojoObjectBuilder2(News.class, cList, vList);
        return new ObjectMapper().writeValueAsString(pojoObject);
    }

    @RequestMapping(value = "/get" + "Jobpostfields" + "PojoObjectJson")
    public @ResponseBody
    String getPojoObjectJsonJobpostfields(@RequestParam("id") String id) throws JsonProcessingException {

        String cList[] = {"id"};// column name as in pojo not in database
        String vList[] = {id};// column values
        Object pojoObject = multiActionDao.executePojoObjectBuilder2(Jobpostfields.class, cList, vList);
        return new ObjectMapper().writeValueAsString(pojoObject);
    }

    @RequestMapping(value = "/get" + "Resumefields" + "PojoObjectJson")
    public @ResponseBody
    String getPojoObjectJsonResumefields(@RequestParam("id") String id) throws JsonProcessingException {

        String cList[] = {"id"};// column name as in pojo not in database
        String vList[] = {id};// column values
        Object pojoObject = multiActionDao.executePojoObjectBuilder2(Resumefields.class, cList, vList);
        return new ObjectMapper().writeValueAsString(pojoObject);
    }

    @RequestMapping(value = "/get" + "TemplateGroupsFields" + "PojoObjectJson")
    public @ResponseBody
    String getPojoObjectJsonTemplateGroupsFields(@RequestParam("id") String id) throws JsonProcessingException {

        String cList[] = {"id"};// column name as in pojo not in database
        String vList[] = {id};// column values
        Object pojoObject = multiActionDao.executePojoObjectBuilder2(TemplateGroupsFields.class, cList, vList);
        return new ObjectMapper().writeValueAsString(pojoObject);
    }

    @RequestMapping(value = "/get" + "TemplateGroups" + "PojoObjectJson")
    public @ResponseBody
    String getPojoObjectJsonTemplateGroups(@RequestParam("id") String id) throws JsonProcessingException {

        String cList[] = {"id"};// column name as in pojo not in database
        String vList[] = {id};// column values
        Object pojoObject = multiActionDao.executePojoObjectBuilder2(TemplateGroups.class, cList, vList);
        return new ObjectMapper().writeValueAsString(pojoObject);
    }

    @RequestMapping(value = {"/getTreeDataNew"}, method = RequestMethod.GET)
    //@PreAuthorize(value="@securityService1.userHasPermissionForURL(authentication, '/getLocationData')")
    public @ResponseBody
    ResponseEntity getLocationDataNew() throws JsonProcessingException {
        System.out.println("inside get NEW tree data:");

        List<Careerguidlines> careerguidlinesList = (List<Careerguidlines>) multiActionDao.executeDataListObjectBuilder(Careerguidlines.class);
        //List<Careerguidlines> careerguidlinesList = searchDao.getCareerguidlinesData();
        JSONArray jsonArray = getTree(careerguidlinesList);
        ResponseEntity r = null;
        try {
            r = new ResponseEntity(jsonArray.toString(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("rrrr_____ " + r);
        return r;
    }

    public JSONArray getTree(List<Careerguidlines> categoriesList) {

        JSONArray jsonArray = new JSONArray();
        for (Careerguidlines cat : categoriesList) {
            if (cat.getParentId() == 0) {
                jsonArray.put(getJsonArrayyHashMap(categoriesList, cat));
            }
        }
        return jsonArray;
    }

    List<Careerguidlines> getCategories(List<Careerguidlines> clist, int id) {
        List<Careerguidlines> list = new ArrayList<Careerguidlines>();
        for (Careerguidlines cat : clist) {
            if (cat.getParentId() == id) {
                list.add(cat);
            }
        }
        return list;
    }

    HashMap getJsonArrayyHashMap(List<Careerguidlines> categoriesList, Careerguidlines cat) {
        JSONArray childArrDetails = new JSONArray();
        HashMap catDetailsJson = new HashMap();
        HashMap childdetails = new HashMap();
        List<Careerguidlines> list = getCategories(categoriesList, cat.getId());
        for (Careerguidlines catt : list) {
            childdetails = new HashMap();
            childdetails.put("text", catt.getName());
            childdetails.put("id", catt.getId());
            if (list.size() > 0)
                childdetails.put("children", getJsonArrayy(categoriesList, catt));
            childArrDetails.put(childdetails);
        }
        catDetailsJson.put("id", cat.getId());
        catDetailsJson.put("text", cat.getName());
        catDetailsJson.put("children", childArrDetails);
        System.out.println("catDetailsJson - " + catDetailsJson);
        return catDetailsJson;
    }

    JSONArray getJsonArrayy(List<Careerguidlines> categoriesList, Careerguidlines cat) {
        JSONArray childArrDetails = new JSONArray();
        HashMap childdetails = new HashMap();
        List<Careerguidlines> list = getCategories(categoriesList, cat.getId());
        for (Careerguidlines catt : list) {
            childdetails = new HashMap();
            childdetails.put("text", catt.getName());
            childdetails.put("id", catt.getId());
            if (list.size() > 0)
                childdetails.put("children", getJsonArrayy(categoriesList, catt));
            childArrDetails.put(childdetails);
        }
        return childArrDetails;
    }

    @RequestMapping(value = "/get" + "Careerguidlines" + "PojoObjectJson")
    public @ResponseBody
    String getPojoObjectJsonCareerguidlines(@RequestParam("id") String id) throws JsonProcessingException {

        String cList[] = {"id"};// column name as in pojo not in database
        String vList[] = {id};// column values
        Object pojoObject = multiActionDao.executePojoObjectBuilder2(Careerguidlines.class, cList, vList);
        System.out.println("DD--- " + new ObjectMapper().writeValueAsString(pojoObject));
        return new ObjectMapper().writeValueAsString(pojoObject);
    }

    @RequestMapping(value = "/get" + "CandidateWatchdogPlans" + "PojoObjectJson")
    public @ResponseBody
    String getPojoObjectJsonCandidateWatchdogPlans(@RequestParam("id") String id) throws JsonProcessingException {

        String cList[] = {"id"};// column name as in pojo not in database
        String vList[] = {id};// column values
        Object pojoObject = multiActionDao.executePojoObjectBuilder2(CandidateWatchdogPlans.class, cList, vList);
        System.out.println("CandidateWatchdogPlans " + new ObjectMapper().writeValueAsString(pojoObject));
        return new ObjectMapper().writeValueAsString(pojoObject);
    }

    @RequestMapping(value = "/get" + "CandidateResumebroadcastPlans" + "PojoObjectJson")
    public @ResponseBody
    String getPojoObjectJsonCandidateResumebroadcastPlans(@RequestParam("id") String id) throws JsonProcessingException {

        String cList[] = {"id"};// column name as in pojo not in database
        String vList[] = {id};// column values
        Object pojoObject = multiActionDao.executePojoObjectBuilder2(CandidateResumebroadcastPlans.class, cList, vList);
        System.out.println("CandidateResumebroadcastPlans " + new ObjectMapper().writeValueAsString(pojoObject));
        return new ObjectMapper().writeValueAsString(pojoObject);
    }

    @RequestMapping(value = "/get" + "CandidateQuickresumebroadcastPlans" + "PojoObjectJson")
    public @ResponseBody
    String getPojoObjectJsonCandidateQuickresumebroadcastPlans(@RequestParam("id") String id) throws JsonProcessingException {

        String cList[] = {"id"};// column name as in pojo not in database
        String vList[] = {id};// column values
        Object pojoObject = multiActionDao.executePojoObjectBuilder2(CandidateQuickresumebroadcastPlans.class, cList, vList);
        System.out.println("CandidateQuickresumebroadcastPlans " + new ObjectMapper().writeValueAsString(pojoObject));
        return new ObjectMapper().writeValueAsString(pojoObject);
    }

    @RequestMapping(value = "/get" + "CandidateEmailTemplates" + "PojoObjectJson")
    public @ResponseBody
    String getPojoObjectJsonCandidateEmailTemplates(@RequestParam("id") String id) throws JsonProcessingException {

        String cList[] = {"id"};// column name as in pojo not in database
        String vList[] = {id};// column values
        Object pojoObject = multiActionDao.executePojoObjectBuilder2(CandidateEmailTemplates.class, cList, vList);
        System.out.println("CandidateEmailTemplates " + new ObjectMapper().writeValueAsString(pojoObject));
        return new ObjectMapper().writeValueAsString(pojoObject);
    }

    @RequestMapping(value = "/get" + "CandidateSmsTemplates" + "PojoObjectJson")
    public @ResponseBody
    String getPojoObjectJsonCandidateSmsTemplates(@RequestParam("id") String id) throws JsonProcessingException {

        String cList[] = {"id"};// column name as in pojo not in database
        String vList[] = {id};// column values
        Object pojoObject = multiActionDao.executePojoObjectBuilder2(CandidateSmsTemplates.class, cList, vList);
        System.out.println("CandidateSmsTemplates " + new ObjectMapper().writeValueAsString(pojoObject));
        return new ObjectMapper().writeValueAsString(pojoObject);
    }

    @RequestMapping(value = "/get" + "CompanyEmailTemplates" + "PojoObjectJson")
    public @ResponseBody
    String getPojoObjectJsonCompanyEmailTemplates(@RequestParam("id") String id) throws JsonProcessingException {

        String cList[] = {"id"};// column name as in pojo not in database
        String vList[] = {id};// column values
        Object pojoObject = multiActionDao.executePojoObjectBuilder2(CompanyEmailTemplates.class, cList, vList);
        System.out.println("CompanyEmailTemplates " + new ObjectMapper().writeValueAsString(pojoObject));
        return new ObjectMapper().writeValueAsString(pojoObject);
    }

    @RequestMapping(value = "/get" + "CompanySmsTemplates" + "PojoObjectJson")
    public @ResponseBody
    String getPojoObjectJson(@RequestParam("id") String id) throws JsonProcessingException {

        String cList[] = {"id"};// column name as in pojo not in database
        String vList[] = {id};// column values
        Object pojoObject = multiActionDao.executePojoObjectBuilder2(CompanySmsTemplates.class, cList, vList);
        System.out.println("CompanySmsTemplates " + new ObjectMapper().writeValueAsString(pojoObject));
        return new ObjectMapper().writeValueAsString(pojoObject);
    }

    java.sql.Timestamp getTimeStampDate() {
        Date saveDate = new Date();
        java.sql.Timestamp timeStampDate = new Timestamp(saveDate.getTime());
        return timeStampDate;
    }

    //schedule

    @RequestMapping(value = "/get" + "Resumedata" + "PojoObjectJson")
    public @ResponseBody
    String getPojoObjectJsonTemplateGroupsFieldssch(@RequestParam("id") String id) throws JsonProcessingException {

        String cList[] = {"id"};// column name as in pojo not in database
        String vList[] = {id};// column values
        Object pojoObject = multiActionDao.executePojoObjectBuilder2(Resumedata.class, cList, vList);
        return new ObjectMapper().writeValueAsString(pojoObject);
    }

    @RequestMapping(value = "/get" + "Resumedataa" + "PojoObjectJson")
    public @ResponseBody
    String getPojoObjectJsonsch(@RequestParam("id") String id) throws JsonProcessingException {

        String cList[] = {"id"};// column name as in pojo not in database
        String vList[] = {id};// column values
        Object pojoObject = multiActionDao.executePojoObjectBuilder2(Resumedata.class, cList, vList);
        return new ObjectMapper().writeValueAsString(pojoObject);
    }
}