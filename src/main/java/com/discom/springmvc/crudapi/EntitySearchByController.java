package com.discom.springmvc.crudapi;

import com.discom.springmvc.dao.MultiActionDao;
import com.discom.springmvc.model.CompanyJobAdsResponse;
import com.discom.springmvc.model.DataTableModel;
import com.discom.springmvc.pojo.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EntitySearchByController {

    @Autowired
    MultiActionDao multiActionDao;

    @RequestMapping(value = "/get" + "Countrymaster" + "PojoObjectJsonByCountryname")
    public @ResponseBody
    String getPojoObjectJsonByCountryname(@RequestParam("countryname") String countryname) throws JsonProcessingException {

        String cList[] = {"countryname"};// column name as in pojo not in database
        String vList[] = {countryname};// column values
        Object pojoObject = multiActionDao.executePojoObjectBuilder2(Countrymaster.class, cList, vList);
        return new ObjectMapper().writeValueAsString(pojoObject);
    }

    @RequestMapping(value = "/get" + "Countrymaster" + "PojoObjectJsonByCountrynameandcode")
    public @ResponseBody
    String getPojoObjectJsonByCountrynameandcode(@RequestParam("countryname") String countryname, @RequestParam("countrycode") String countrycode) throws JsonProcessingException {

        String cList[] = {"countryname", "countrycode"};// column name as in pojo not in database
        String vList[] = {countryname, countrycode};// column values
        Object pojoObject = multiActionDao.executePojoObjectBuilder2(Countrymaster.class, cList, vList);
        return new ObjectMapper().writeValueAsString(pojoObject);
    }

    @RequestMapping(value = "/get" + "Jobpostfields" + "PojoObjectJsonByLabelName")
    public @ResponseBody
    String getPojoObjectJsonByLabelName(@RequestParam("labelName") String labelName) throws JsonProcessingException {

        String cList[] = {"labelName"};// column name as in pojo not in database
        String vList[] = {labelName};// column values
        Object pojoObject = multiActionDao.executePojoObjectBuilder2(Jobpostfields.class, cList, vList);
        return new ObjectMapper().writeValueAsString(pojoObject);
    }

    @RequestMapping(value = "/get" + "Resumefields" + "PojoObjectJsonByLabelName")
    public @ResponseBody
    String getPojoObjectJsonByLabelNameRF(@RequestParam("labelName") String labelName) throws JsonProcessingException {

        String cList[] = {"labelName"};// column name as in pojo not in database
        String vList[] = {labelName};// column values
        Object pojoObject = multiActionDao.executePojoObjectBuilder2(Resumefields.class, cList, vList);
        return new ObjectMapper().writeValueAsString(pojoObject);
    }

    @RequestMapping(value = "/get" + "TemplateGroupsFields" + "PojoObjectJsonByfieldcode")
    public @ResponseBody
    String getPojoObjectJsonByfieldcode(@RequestParam("fieldcode") String fieldcode) throws JsonProcessingException {

        String cList[] = {"fieldcode"};// column name as in pojo not in database
        String vList[] = {fieldcode};// column values
        Object pojoObject = multiActionDao.executePojoObjectBuilder2(TemplateGroupsFields.class, cList, vList);
        return new ObjectMapper().writeValueAsString(pojoObject);
    }

    @RequestMapping(value = "/get" + "Templates" + "PojoObjectJsonBytemplatecodentype")
    public @ResponseBody
    String getPojoObjectJsonBytemplatecodentype(@RequestParam("templatecode") String templatecode, @RequestParam("templatetype") String templatetype) throws JsonProcessingException {

        System.out.println(templatecode + "       " + templatetype);
        String cList[] = {"templatecode", "templatetype"};// column name as in pojo not in database
        String vList[] = {templatecode, templatetype};// column values
        Object pojoObject = multiActionDao.executePojoObjectBuilder2(Templates.class, cList, vList);
        System.out.println(new ObjectMapper().writeValueAsString(pojoObject));
        return new ObjectMapper().writeValueAsString(pojoObject);
    }

    @RequestMapping(value = "/get" + "TemplateGroups" + "PojoObjectJsonBytemplatecodentypegroupname")
    public @ResponseBody
    String getPojoObjectJsonBytemplatecodentypegroupname(@RequestParam("templatecode") String templatecode, @RequestParam("templatetype") String templatetype,
                                                         @RequestParam("groupname") String groupname) throws JsonProcessingException {

        String cList[] = {"templatecode", "templatetype", "groupname"};// column name as in pojo not in database
        String vList[] = {templatecode, templatetype, groupname};// column values
        Object pojoObject = multiActionDao.executePojoObjectBuilder2(TemplateGroups.class, cList, vList);
        return new ObjectMapper().writeValueAsString(pojoObject);
    }

    @RequestMapping(value = "/get" + "TemplateGroupsFieldsChilds" + "PojoObjectJsonByfieldcodencode")
    public @ResponseBody
    String getPojoObjectJsonByfieldcodencode(@RequestParam("fieldcode") String fieldcode, @RequestParam("code") String code) throws JsonProcessingException {

        String cList[] = {"fieldcode", "code"};// column name as in pojo not in database
        String vList[] = {fieldcode, code};// column values
        Object pojoObject = multiActionDao.executePojoObjectBuilder2(TemplateGroupsFieldsChilds.class, cList, vList);
        return new ObjectMapper().writeValueAsString(pojoObject);
    }

    @RequestMapping(value = "/get" + "Instituteregistrations" + "PojoObjectJsonByt_codet_typenid")
    public @ResponseBody
    String getCompanyusersPojoObjectJsonByt_codet_typenid(@RequestParam("templatecode") String templatecode, @RequestParam("templatetype") String templatetype, @RequestParam("id") String id) throws JsonProcessingException, ParseException {

        String cList[] = {"templatecode", "templatetype", "id"};// column name as in pojo not in database
        String vList[] = {templatecode, templatetype, id};// column values
        Instituteregistrations pojoObject = (Instituteregistrations) multiActionDao.executePojoObjectBuilder2(Instituteregistrations.class, cList, vList);

        return new ObjectMapper().writeValueAsString(pojoObject);
    }

    //schduler
/*
	@RequestMapping(value = "/get" + "Resumedata" + "PojoObjectJsonByCountryname")
	public @ResponseBody String getPojoObjectJsonByCountryname(@RequestParam("countryname") String countryname)
			throws JsonProcessingException {

		String cList[] = { "countryname" };// column name as in pojo not in database
		String vList[] = { countryname };// column values
		Object pojoObject = multiActionDao.executePojoObjectBuilder2(Resumedata.class, cList, vList);
		return new ObjectMapper().writeValueAsString(pojoObject);
	}

	@RequestMapping(value = "/get" + "Resumedata" + "PojoObjectJsonByfieldcodencode")
	public @ResponseBody String getPojoObjectJsonByfieldcodencode(@RequestParam("fieldcode") String fieldcode,
																  @RequestParam("code") String code) throws JsonProcessingException {

		String cList[] = { "fieldcode", "code" };// column name as in pojo not in database
		String vList[] = { fieldcode, code };// column values
		Object pojoObject = multiActionDao.executePojoObjectBuilder2(Resumedata.class, cList, vList);
		return new ObjectMapper().writeValueAsString(pojoObject);
	}*/

    @RequestMapping(value = "/get" + "Companyprofiles" + "PojoObjectJsonByt_codet_typenuserid")
    public @ResponseBody
    String getCompanyprofilesPojoObjectJsonByt_codet_typenuserid(
            @RequestParam("templatecode") String templatecode, @RequestParam("templatetype") String templatetype,
            @RequestParam("userid") String userid) throws JsonProcessingException, ParseException {

        String cList[] = {"templatecode", "templatetype", "userid"};// column name as in pojo not in database
        String vList[] = {templatecode, templatetype, userid};// column values
        Companyprofiles pojoObject = (Companyprofiles) multiActionDao.executePojoObjectBuilder2(Companyprofiles.class,
                cList, vList);

        return new ObjectMapper().writeValueAsString(pojoObject);
    }

    @RequestMapping(value = "/get" + "Contactjobships" + "PojoObjectJsonByt_codet_typenuserid")
    public @ResponseBody
    String getContactjobshipsPojoObjectJsonByt_codet_typenuserid(
            @RequestParam("templatecode") String templatecode, @RequestParam("templatetype") String templatetype,
            @RequestParam("userid") String userid) throws JsonProcessingException, ParseException {

        String cList[] = {"templatecode", "templatetype", "userid"};// column name as in pojo not in database
        String vList[] = {templatecode, templatetype, userid};// column values
        Companyprofiles pojoObject = (Companyprofiles) multiActionDao.executePojoObjectBuilder2(Contactjobships.class,
                cList, vList);

        return new ObjectMapper().writeValueAsString(pojoObject);
    }

    @RequestMapping(value = "/get" + "Companyjobposts" + "PojoObjectJsonByt_codet_typenid")
    public @ResponseBody
    String getCompanyjobpostsPojoObjectJsonByt_codet_typenuserid(
            @RequestParam("templatecode") String templatecode, @RequestParam("templatetype") String templatetype,
            @RequestParam("id") String id) throws JsonProcessingException, ParseException {

        String cList[] = {"templatecode", "templatetype", "id"};// column name as in pojo not in database
        String vList[] = {templatecode, templatetype, id};// column values
        Map<String, Object> pojoObject = (Map<String, Object>) multiActionDao
                .executePojoObjectBuilder2(Companyjobposts.class, cList, vList);

        return new ObjectMapper().writeValueAsString(pojoObject);
    }

    @RequestMapping(value = "/get" + "Companyjobposts" + "ByIds")
    public @ResponseBody
    String getCompanyjobpostsByCompanyid(@RequestParam("ids") List<Integer> ids)
            throws JsonProcessingException, ParseException {
        DataTableModel responseObject = null;
        List<Companyjobposts> pojoObject = (List<Companyjobposts>) multiActionDao
                .getCompanyjobpostsByIds(Companyjobposts.class, ids);
        if (pojoObject != null) {
            responseObject = (DataTableModel) multiActionDao.getjobPostDetails(pojoObject);
        }
        return new ObjectMapper().writeValueAsString(responseObject);
    }

    @RequestMapping(value = "/get" + "Companyjobads" + "ByCompanyId")
    public @ResponseBody
    String getCompanyjobadsByCompanyIdAndTemplateId(@RequestParam("companyId") String companyId,
                                                    @RequestParam("templateId") String templateId)
            throws JsonProcessingException, ParseException {
        CompanyJobAds responseObject = (CompanyJobAds) multiActionDao.getCompanyJobAdsByCompanyId(CompanyJobAds.class, companyId, templateId);
        return new ObjectMapper().writeValueAsString(responseObject);
    }

    @RequestMapping(value = "/get" + "Companyjobads")
    public @ResponseBody
    String getCompanyjobads()
            throws JsonProcessingException, ParseException {
        List<CompanyJobAdsResponse> responseObject = (List<CompanyJobAdsResponse>) multiActionDao.getCompanyJobAds(CompanyJobAds.class);
        return new ObjectMapper().writeValueAsString(responseObject);
    }

    @RequestMapping(value = "/get" + "Companyjobads" + "ByFilter")
    public @ResponseBody
    String getCompanyjobadsByFilter(@RequestParam("jobpostIdList") List<Integer> jobpostIdList)
            throws JsonProcessingException, ParseException {
        List<CompanyJobAdsResponse> responseObject = (List<CompanyJobAdsResponse>) multiActionDao.getCompanyjobadsByFilter(CompanyJobAds.class, jobpostIdList);
        return new ObjectMapper().writeValueAsString(responseObject);
    }

    @RequestMapping(value = "/get" + "Companyjobads" + "ById")
    public @ResponseBody
    String getCompanyjobadsById(@RequestParam("id") Integer id)
            throws JsonProcessingException, ParseException {
        CompanyJobAdsResponse responseObject = (CompanyJobAdsResponse) multiActionDao.getCompanyjobadsById(CompanyJobAds.class, id.toString());
        return new ObjectMapper().writeValueAsString(responseObject);
    }


    @RequestMapping(value = "/get" + "CompanyjobadsAndJoBPost" + "Mapping")
    public @ResponseBody
    String getCompanyjobadsAndJoBPost()
            throws JsonProcessingException, ParseException {
        List<JobAdsAndJobPostMapping> responseObject = (List<JobAdsAndJobPostMapping>) multiActionDao.getCompanyjobadsAndJoBPost(JobAdsAndJobPostMapping.class);
        return new ObjectMapper().writeValueAsString(responseObject);
    }

    @RequestMapping(value = "/get" + "All" + "Companyjobposts")
    public @ResponseBody
    String getAllCompanyjobposts(@RequestParam("start") int start,
                                 @RequestParam("length") int length, @RequestParam("sCompanyName") String sCompanyName,
                                 @RequestParam("salaryfrom") String salaryfrom, @RequestParam("salaryto") String salaryto,
                                 @RequestParam("sList") String[] sList, @RequestParam("fList") String[] fList) throws JsonProcessingException, ParseException {

        String cList[] = {"jobPostkey", "jobPostvalue", "companyjobpostid", "flag"};// column name as in pojo not in database
        DataTableModel responseObject = (DataTableModel) multiActionDao.getjobPostDetailsFilter1(Companyjobposts.class, sCompanyName,
                salaryfrom, salaryto, start, length, sList, cList, fList);
        return new ObjectMapper().writeValueAsString(responseObject);
    }

    /*
     * @RequestMapping(value = "/get"+"Companyjobposts"+"ByCompanyId")
     * public @ResponseBody String
     * getCompanyjobpostsByCompanyid(@RequestParam("name") String
     * name,@RequestParam("address") String address,@RequestParam("contactPerson")
     * String contactPerson,@RequestParam("id") String id) throws
     * JsonProcessingException, ParseException {
     *
     * String cList[] = {"name","address","contactPerson","com_name"};// column name
     * as in pojo not in database String vList[] =
     * {name,address,contactPerson,id};// column values Companyjobposts pojoObject =
     * (Companyjobposts)
     * multiActionDao.executePojoObjectBuilder2(Companyjobposts.class,cList,vList);
     *
     * return new ObjectMapper().writeValueAsString(pojoObject); }
     */

    @RequestMapping(value = "/get" + "CompanyjobpostsDetails" + "PojoObjectJsonByt_codet_typenid")
    public @ResponseBody
    String getCompanyjobDetailspostsPojoObjectJsonByt_codet_typenuserid(
            @RequestParam("templatecode") String templatecode, @RequestParam("templatetype") String templatetype,
            @RequestParam("id") String id) throws JsonProcessingException, ParseException {

        String cList[] = {"templatecode", "templatetype", "companyjobpostid"};// column name as in pojo not in
        // database
        String vList[] = {templatecode, templatetype, id};// column values
        List<CompanyjobpostsDetails> pojoObject = (List<CompanyjobpostsDetails>) multiActionDao
                .executePojoObjectBuilder3(CompanyjobpostsDetails.class, cList, vList);

        return new ObjectMapper().writeValueAsString(pojoObject);
    }

    @RequestMapping(value = "/get" + "Companytemplatejobposts" + "PojoObjectJsonByt_codet_typenid")
    public @ResponseBody
    String getCompanytemplatejobpostsPojoObjectJsonByt_codet_typenuserid(
            @RequestParam("templatecode") String templatecode, @RequestParam("templatetype") String templatetype,
            @RequestParam("id") String id) throws JsonProcessingException, ParseException {

        String cList[] = {"templatecode", "templatetype", "id"};// column name as in pojo not in database
        String vList[] = {templatecode, templatetype, id};// column values
        Companytemplatejobposts pojoObject = (Companytemplatejobposts) multiActionDao
                .executePojoObjectBuilder2(Companytemplatejobposts.class, cList, vList);

        return new ObjectMapper().writeValueAsString(pojoObject);
    }

    @RequestMapping(value = "/get" + "Companyletter" + "PojoObjectJsonByt_codet_typenuserid")
    public @ResponseBody
    String getCompanyletterPojoObjectJsonByt_codet_typenuserid(
            @RequestParam("templatecode") String templatecode, @RequestParam("templatetype") String templatetype,
            @RequestParam("userid") String userid) throws JsonProcessingException, ParseException {

        String cList[] = {"templatecode", "templatetype", "userid"};// column name as in pojo not in database
        String vList[] = {templatecode, templatetype, userid};// column values
        Companyletter pojoObject = (Companyletter) multiActionDao.executePojoObjectBuilder2(Companyletter.class, cList,
                vList);

        return new ObjectMapper().writeValueAsString(pojoObject);
    }

    @RequestMapping(value = "/get" + "Companyusers" + "PojoObjectJsonByt_codet_typenuserid")
    public @ResponseBody
    String getCompanyusersPojoObjectJsonByt_codet_typenuserid(
            @RequestParam("templatecode") String templatecode, @RequestParam("templatetype") String templatetype,
            @RequestParam("userid") String userid) throws JsonProcessingException, ParseException {

        String cList[] = {"templatecode", "templatetype", "userid"};// column name as in pojo not in database
        String vList[] = {templatecode, templatetype, userid};// column values
        Companyletter pojoObject = (Companyletter) multiActionDao.executePojoObjectBuilder2(Companyusers.class, cList,
                vList);

        return new ObjectMapper().writeValueAsString(pojoObject);
    }

    /*
        @RequestMapping(value = "/get" + "Companyusers" + "PojoObjectJsonByt_codet_typenid")
        public @ResponseBody String getCompanyusersPojoObjectJsonByt_codet_typenid(
                @RequestParam("templatecode") String templatecode, @RequestParam("templatetype") String templatetype,
                @RequestParam("id") String id) throws JsonProcessingException, ParseException {

            String cList[] = { "templatecode", "templatetype", "id" };// column name as in pojo not in database
            String vList[] = { templatecode, templatetype, id };// column values
            Companyusers pojoObject = (Companyusers) multiActionDao.executePojoObjectBuilder2(Companyusers.class, cList,
                    vList);

            return new ObjectMapper().writeValueAsString(pojoObject);
        }
    */
    @RequestMapping(value = "/get" + "Greetingrequests" + "PojoObjectJsonByt_codet_typenuserid")
    public @ResponseBody
    String getGreetingrequestsPojoObjectJsonByt_codet_typenuserid(
            @RequestParam("templatecode") String templatecode, @RequestParam("templatetype") String templatetype,
            @RequestParam("userid") String userid) throws JsonProcessingException, ParseException {

        String cList[] = {"templatecode", "templatetype", "userid"};// column name as in pojo not in database
        String vList[] = {templatecode, templatetype, userid};// column values
        Greetingrequests pojoObject = (Greetingrequests) multiActionDao
                .executePojoObjectBuilder2(Greetingrequests.class, cList, vList);

        return new ObjectMapper().writeValueAsString(pojoObject);
    }

    @RequestMapping(value = "/get" + "Greetingrequests" + "PojoObjectJsonByt_codet_typenid")
    public @ResponseBody
    String getGreetingrequestsPojoObjectJsonByt_codet_typenid(
            @RequestParam("templatecode") String templatecode, @RequestParam("templatetype") String templatetype,
            @RequestParam("id") String id) throws JsonProcessingException, ParseException {

        String cList[] = {"templatecode", "templatetype", "id"};// column name as in pojo not in database
        String vList[] = {templatecode, templatetype, id};// column values
        Greetingrequests pojoObject = (Greetingrequests) multiActionDao
                .executePojoObjectBuilder2(Greetingrequests.class, cList, vList);

        return new ObjectMapper().writeValueAsString(pojoObject);
    }

    java.sql.Timestamp getTimeStampDate() {
        Date saveDate = new Date();
        java.sql.Timestamp timeStampDate = new Timestamp(saveDate.getTime());
        return timeStampDate;
    }
}