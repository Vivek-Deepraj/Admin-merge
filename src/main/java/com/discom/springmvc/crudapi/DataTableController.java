package com.discom.springmvc.crudapi;

import com.discom.springmvc.dao.MultiActionDao;
import com.discom.springmvc.model.DataTableModel;
import com.discom.springmvc.pojo.*;
import com.discom.springmvc.service.ListService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DataTableController {

    @Autowired
    MultiActionDao multiActionDao;
    //@Autowired
    //private ApiService apiService;
    @Autowired
    ListService listService;

    @RequestMapping(value = "/get" + "Countrymaster" + "DataTableJson")
    public @ResponseBody
    String getDataTableJsonCountrymaster(@RequestParam("sSearch") String sSearch,
                                         @RequestParam("start") int start, @RequestParam("length") int length, @RequestParam("sList") String[] sList) throws JsonProcessingException {

        String cList[] = {"countrycode", "countryname"};// column name as in pojo not in database
        String gscList[] = {"countrycode", "countryname"};// column name as in pojo not in database
        DataTableModel dataModel = multiActionDao.executeDataTableObjectBuilder(Countrymaster.class, start, length, sSearch, sList, cList, gscList);
        return new ObjectMapper().writeValueAsString(dataModel);
    }

    @RequestMapping(value = "/get" + "Newscategory" + "DataTableJson")
    public @ResponseBody
    String getDataTableJsonNewscategory(@RequestParam("sSearch") String sSearch,
                                        @RequestParam("start") int start, @RequestParam("length") int length, @RequestParam("sList") String[] sList) throws JsonProcessingException {

        String cList[] = {"categoryname"};// column name as in pojo not in database
        String gscList[] = {"categoryname"};// column name as in pojo not in database
        DataTableModel dataModel = multiActionDao.executeDataTableObjectBuilder(Newscategory.class, start, length, sSearch, sList, cList, gscList);
        return new ObjectMapper().writeValueAsString(dataModel);
    }

    @RequestMapping(value = "/get" + "News" + "DataTableJson")
    public @ResponseBody
    String getDataTableJsonNews(@RequestParam("sSearch") String sSearch,
                                @RequestParam("start") int start, @RequestParam("length") int length, @RequestParam("sList") String[] sList) throws JsonProcessingException {

        String cList[] = {"categoryname"};// column name as in pojo not in database
        String gscList[] = {"categoryname"};// column name as in pojo not in database
        DataTableModel dataModel = multiActionDao.executeDataTableObjectBuilder(News.class, start, length, sSearch, sList, cList, gscList);
        return new ObjectMapper().writeValueAsString(dataModel);
    }

    @RequestMapping(value = "/get" + "Jobpostfields" + "DataTableJson")
    public @ResponseBody
    String getDataTableJsonJobpostfields(@RequestParam("sSearch") String sSearch,
                                         @RequestParam("start") int start, @RequestParam("length") int length, @RequestParam("sList") String[] sList) throws JsonProcessingException {

        String cList[] = {"labelName", "fieldName"};// column name as in pojo not in database
        String gscList[] = {"labelName", "fieldName"};// column name as in pojo not in database
        DataTableModel dataModel = multiActionDao.executeDataTableObjectBuilder(Jobpostfields.class, start, length, sSearch, sList, cList, gscList);
        return new ObjectMapper().writeValueAsString(dataModel);
    }

    @RequestMapping(value = "/get" + "Resumefields" + "DataTableJson")
    public @ResponseBody
    String getDataTableJsonResumefields(@RequestParam("sSearch") String sSearch,
                                        @RequestParam("start") int start, @RequestParam("length") int length, @RequestParam("sList") String[] sList) throws JsonProcessingException {

        String cList[] = {"labelName", "fieldName"};// column name as in pojo not in database
        String gscList[] = {"labelName", "fieldName"};// column name as in pojo not in database
        DataTableModel dataModel = multiActionDao.executeDataTableObjectBuilder(Resumefields.class, start, length, sSearch, sList, cList, gscList);
        return new ObjectMapper().writeValueAsString(dataModel);
    }

    @RequestMapping(value = "/get" + "Activitylog" + "DataTableJson")
    public @ResponseBody
    String getDataTableJsonActivitylog(@RequestParam("sSearch") String sSearch,
                                       @RequestParam("start") int start, @RequestParam("length") int length, @RequestParam("sList") String[] sList) throws JsonProcessingException {

        String cList[] = {"userid", "datetime", "operatingsystem"};// column name as in pojo not in database
        String gscList[] = {"userid", "datetime", "operatingsystem"};// column name as in pojo not in database
        DataTableModel dataModel = multiActionDao.executeDataTableObjectBuilder(Activitylog.class, start, length, sSearch, sList, cList, gscList);
        return new ObjectMapper().writeValueAsString(dataModel);
    }

    @RequestMapping(value = "/get" + "Templates" + "DataTableJson")
    public @ResponseBody
    String getDataTableJsonTemplates(@RequestParam("sSearch") String sSearch,
                                     @RequestParam("start") int start, @RequestParam("length") int length, @RequestParam("sList") String[] sList) throws JsonProcessingException {

        String cList[] = {"templatename", "templatecode", "templatetype"};// column name as in pojo not in database
        String gscList[] = {"templatename", "templatecode", "templatetype"};// column name as in pojo not in database
        DataTableModel dataModel = multiActionDao.executeDataTableObjectBuilder(Templates.class, start, length, sSearch, sList, cList, gscList);
        return new ObjectMapper().writeValueAsString(dataModel);
    }

    @RequestMapping(value = "/get" + "TemplateGroupsFields" + "DataTableJson")
    public @ResponseBody
    String getDataTableJsonTemplateGroupsFields(@RequestParam("sSearch") String sSearch,
                                                @RequestParam("start") int start, @RequestParam("length") int length, @RequestParam("sList") String[] sList) throws JsonProcessingException {

        String cList[] = {"fieldcode", "fieldlabel", "fielddisplaytype"};// column name as in pojo not in database
        String gscList[] = {"fieldcode", "fieldlabel", "fielddisplaytype"};// column name as in pojo not in database
        DataTableModel dataModel = multiActionDao.executeDataTableObjectBuilder(TemplateGroupsFields.class, start, length, sSearch, sList, cList, gscList);
        return new ObjectMapper().writeValueAsString(dataModel);
    }

    @RequestMapping(value = "/get" + "CompanyList" + "DataTableJson")
    public @ResponseBody
    String getDataTableJsonCompanyList(@RequestParam("sSearch") String sSearch,
                                       @RequestParam("start") int start, @RequestParam("length") int length, @RequestParam("sList") String[] sList) throws JsonProcessingException {
        System.out.println("in Companylist");
        String cList[] = {"companyName", "createdOn", "joiningDate"};// column name as in pojo not in database
        String gscList[] = {"companyName", "createdOn", "joiningDate"};// column name as in pojo not in database
        DataTableModel dataModel = multiActionDao.executeDataTableObjectBuilder(Companymaster.class, start, length, sSearch, sList, cList, gscList);
        return new ObjectMapper().writeValueAsString(dataModel);
    }

    @RequestMapping(value = "/get" + "CandidateWatchdogPlans" + "DataTableJson")
    public @ResponseBody
    String getDataTableJsonCandidateWatchdogPlans(@RequestParam("sSearch") String sSearch,
                                                  @RequestParam("start") int start, @RequestParam("length") int length, @RequestParam("sList") String[] sList) throws JsonProcessingException {

        String cList[] = {"planname"};// column name as in pojo not in database
        String gscList[] = {"planname"};// column name as in pojo not in database
        DataTableModel dataModel = multiActionDao.executeDataTableObjectBuilder(CandidateWatchdogPlans.class, start, length, sSearch, sList, cList, gscList);
        return new ObjectMapper().writeValueAsString(dataModel);
    }

    @RequestMapping(value = "/get" + "CandidateResumebroadcastPlans" + "DataTableJson")
    public @ResponseBody
    String getDataTableJsonCandidateResumebroadcastPlans(@RequestParam("sSearch") String sSearch,
                                                         @RequestParam("start") int start, @RequestParam("length") int length, @RequestParam("sList") String[] sList) throws JsonProcessingException {

        String cList[] = {"planname"};// column name as in pojo not in database
        String gscList[] = {"planname"};// column name as in pojo not in database
        DataTableModel dataModel = multiActionDao.executeDataTableObjectBuilder(CandidateResumebroadcastPlans.class, start, length, sSearch, sList, cList, gscList);
        return new ObjectMapper().writeValueAsString(dataModel);
    }

    @RequestMapping(value = "/get" + "CandidateQuickresumebroadcastPlans" + "DataTableJson")
    public @ResponseBody
    String getDataTableJsonCandidateQuickresumebroadcastPlans(@RequestParam("sSearch") String sSearch,
                                                              @RequestParam("start") int start, @RequestParam("length") int length, @RequestParam("sList") String[] sList) throws JsonProcessingException {

        String cList[] = {"planname"};// column name as in pojo not in database
        String gscList[] = {"planname"};// column name as in pojo not in database
        DataTableModel dataModel = multiActionDao.executeDataTableObjectBuilder(CandidateQuickresumebroadcastPlans.class, start, length, sSearch, sList, cList, gscList);
        return new ObjectMapper().writeValueAsString(dataModel);
    }

    @RequestMapping(value = "/get" + "CandidateEmailTemplates" + "DataTableJson")
    public @ResponseBody
    String getDataTableJsonCandidateEmailTemplates(@RequestParam("sSearch") String sSearch,
                                                   @RequestParam("start") int start, @RequestParam("length") int length, @RequestParam("sList") String[] sList) throws JsonProcessingException {

        String cList[] = {"title"};// column name as in pojo not in database
        String gscList[] = {"title"};// column name as in pojo not in database
        DataTableModel dataModel = multiActionDao.executeDataTableObjectBuilder(CandidateEmailTemplates.class, start, length, sSearch, sList, cList, gscList);
        return new ObjectMapper().writeValueAsString(dataModel);
    }

    @RequestMapping(value = "/get" + "CandidateSmsTemplates" + "DataTableJson")
    public @ResponseBody
    String getDataTableJsonCandidateSmsTemplates(@RequestParam("sSearch") String sSearch,
                                                 @RequestParam("start") int start, @RequestParam("length") int length, @RequestParam("sList") String[] sList) throws JsonProcessingException {

        String cList[] = {"title"};// column name as in pojo not in database
        String gscList[] = {"title"};// column name as in pojo not in database
        DataTableModel dataModel = multiActionDao.executeDataTableObjectBuilder(CandidateSmsTemplates.class, start, length, sSearch, sList, cList, gscList);
        return new ObjectMapper().writeValueAsString(dataModel);
    }

    @RequestMapping(value = "/get" + "CompanyEmailTemplates" + "DataTableJson")
    public @ResponseBody
    String getDataTableJsonCompanyEmailTemplates(@RequestParam("sSearch") String sSearch,
                                                 @RequestParam("start") int start, @RequestParam("length") int length, @RequestParam("sList") String[] sList) throws JsonProcessingException {

        String cList[] = {"title"};// column name as in pojo not in database
        String gscList[] = {"title"};// column name as in pojo not in database
        DataTableModel dataModel = multiActionDao.executeDataTableObjectBuilder(CompanyEmailTemplates.class, start, length, sSearch, sList, cList, gscList);
        return new ObjectMapper().writeValueAsString(dataModel);
    }

    @RequestMapping(value = "/get" + "CompanySmsTemplates" + "DataTableJson")
    public @ResponseBody
    String getDataTableJson(@RequestParam("sSearch") String sSearch,
                            @RequestParam("start") int start, @RequestParam("length") int length, @RequestParam("sList") String[] sList) throws JsonProcessingException {

        String cList[] = {"title"};// column name as in pojo not in database
        String gscList[] = {"title"};// column name as in pojo not in database
        DataTableModel dataModel = multiActionDao.executeDataTableObjectBuilder(CompanySmsTemplates.class, start, length, sSearch, sList, cList, gscList);
        return new ObjectMapper().writeValueAsString(dataModel);
    }

    @RequestMapping(value = "/get" + "Instituteregistrations" + "DataTableJsonn")
    public @ResponseBody
    String getDataTableJson(@RequestParam("sSearch") String sSearch,
                            @RequestParam("start") int start, @RequestParam("length") int length, @RequestParam("sList") String[] sList, @RequestParam("fList") String[] fList) throws Exception {

        String cList[] = {"ins_course_details", "country"};// column name as in pojo not in database
        DataTableModel dataModel = multiActionDao.executeDataTableObjectBuilderJSON("instituteregistrations", start, length, sSearch, sList, cList, fList);
        return new ObjectMapper().writeValueAsString(dataModel);
    }

    java.sql.Timestamp getTimeStampDate() {
        Date saveDate = new Date();
        java.sql.Timestamp timeStampDate = new Timestamp(saveDate.getTime());
        return timeStampDate;
    }


    @GetMapping("/testC")
    public String getTest() {
        final String AUTHORIZATION_HEADER = "Authorization";
        final String TOKEN_TYPE = "Bearer";
        OAuth2AuthenticationDetails details = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        RequestTemplate requestTemplate = new RequestTemplate();
        if (authentication != null && authentication.getDetails() instanceof OAuth2AuthenticationDetails) {
            details = (OAuth2AuthenticationDetails) authentication.getDetails();
            requestTemplate.header(AUTHORIZATION_HEADER, String.format("%s %s", TOKEN_TYPE, details.getTokenValue()));
        }

        //return apiService.testtR(String.format("%s %s", TOKEN_TYPE, details.getTokenValue()));
        return "tested";
        //return apiService.testtR();

    }

    @GetMapping("/testP")
    public String getTestP() {
        List<Portfoliomaster> list = listService.getAllPortfolio();
        return list.get(0).getPortfolioName();

    }
}