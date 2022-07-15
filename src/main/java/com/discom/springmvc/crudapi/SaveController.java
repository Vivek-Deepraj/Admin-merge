package com.discom.springmvc.crudapi;

import com.discom.springmvc.dao.MultiActionDao;
import com.discom.springmvc.model.CompanyJobAdsDto;
import com.discom.springmvc.model.User;
import com.discom.springmvc.model.UserProfile;
import com.discom.springmvc.pojo.*;
import com.discom.springmvc.service.UserProfileService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/api")
public class SaveController {

    @Autowired
    MultiActionDao multiActionDao;
    @Autowired
    UserProfileService userProfileService;

    @PostMapping("save" + "Countrymaster")
    public boolean save(@RequestBody Countrymaster entity) throws IOException {

        return multiActionDao.executePojoSaveObjectBuilder(entity);
    }

    @PostMapping("save" + "Jobpostfields")
    public boolean save(@RequestBody Jobpostfields entity) throws IOException {

        return multiActionDao.executePojoSaveObjectBuilder(entity);
    }

    @PostMapping("save" + "Resumefields")
    public boolean save(@RequestBody Resumefields entity) throws IOException {

        return multiActionDao.executePojoSaveObjectBuilder(entity);
    }

    @PostMapping("save" + "Templates")
    public boolean save(@RequestBody Templates entity) throws IOException {

        entity.setCreatedon(getTimeStampDate());
        entity.setUpdatedon(getTimeStampDate());
        return multiActionDao.executePojoSaveObjectBuilder(entity);
    }

    @PostMapping("save" + "TemplateGroups")
    public boolean save(@RequestBody TemplateGroups entity) throws IOException {

        entity.setCreatedon(getTimeStampDate());
        entity.setUpdatedon(getTimeStampDate());
        return multiActionDao.executePojoSaveObjectBuilder(entity);
    }

    @PostMapping("save" + "TemplateGroupsFields")
    public boolean save(@RequestBody TemplateGroupsFields entity) throws IOException {

        entity.setCreatedon(getTimeStampDate());
        entity.setUpdatedon(getTimeStampDate());
        return multiActionDao.executePojoSaveObjectBuilder(entity);
    }

    @PostMapping("save" + "TemplateGroupsFieldsChilds")
    public boolean save(@RequestBody TemplateGroupsFieldsChilds entity) throws IOException {

        entity.setCreatedon(getTimeStampDate());
        entity.setUpdatedon(getTimeStampDate());
        return multiActionDao.executePojoSaveObjectBuilder(entity);
    }

    @PostMapping("save" + "TemplateGroupsFieldsChildsByLabel")
    public boolean save(@RequestParam("label") String label, @RequestParam("createdBy") String createdBy) throws IOException {
        TemplateGroupsFieldsChilds entity = new TemplateGroupsFieldsChilds();
        entity.setCreatedon(getTimeStampDate());
        entity.setCode(label);
        entity.setLabel(label);
        entity.setCreatedby(createdBy);
        return multiActionDao.executePojoSaveObjectBuilder(entity);
    }

    @PostMapping("save" + "TemplateGroupsFieldsValidators")
    public boolean save(@RequestBody TemplateGroupsFieldsValidators entity) throws IOException {

        entity.setCreatedon(getTimeStampDate());
        entity.setUpdatedon(getTimeStampDate());
        return multiActionDao.executePojoSaveObjectBuilder(entity);
    }

    @PostMapping("save" + "CandidateWatchdogPlans")
    public boolean save(@RequestBody CandidateWatchdogPlans entity) throws IOException {

        entity.setCreatedon(getTimeStampDate());
        entity.setUpdatedon(getTimeStampDate());
        return multiActionDao.executePojoSaveObjectBuilder(entity);
    }

    @PostMapping("save" + "CandidateResumebroadcastPlans")
    public boolean save(@RequestBody CandidateResumebroadcastPlans entity) throws IOException {

        entity.setCreatedon(getTimeStampDate());
        entity.setUpdatedon(getTimeStampDate());
        return multiActionDao.executePojoSaveObjectBuilder(entity);
    }

    @PostMapping("save" + "CandidateQuickresumebroadcastPlans")
    public boolean save(@RequestBody CandidateQuickresumebroadcastPlans entity) throws IOException {

        entity.setCreatedon(getTimeStampDate());
        entity.setUpdatedon(getTimeStampDate());
        return multiActionDao.executePojoSaveObjectBuilder(entity);
    }

    @PostMapping("save" + "CandidateEmailTemplates")
    public boolean save(@RequestBody CandidateEmailTemplates entity) throws IOException {

        entity.setCreatedon(getTimeStampDate());
        entity.setUpdatedon(getTimeStampDate());
        return multiActionDao.executePojoSaveObjectBuilder(entity);
    }

    @PostMapping("save" + "CandidateSmsTemplates")
    public boolean save(@RequestBody CandidateSmsTemplates entity) throws IOException {

        entity.setCreatedon(getTimeStampDate());
        entity.setUpdatedon(getTimeStampDate());
        return multiActionDao.executePojoSaveObjectBuilder(entity);
    }

    @PostMapping("save" + "CompanyEmailTemplates")
    public boolean save(@RequestBody CompanyEmailTemplates entity) throws IOException {

        entity.setCreatedon(getTimeStampDate());
        entity.setUpdatedon(getTimeStampDate());
        return multiActionDao.executePojoSaveObjectBuilder(entity);
    }

    @PostMapping("save" + "CompanySmsTemplates")
    public boolean save(@RequestBody CompanySmsTemplates entity) throws IOException {

        entity.setCreatedon(getTimeStampDate());
        entity.setUpdatedon(getTimeStampDate());
        return multiActionDao.executePojoSaveObjectBuilder(entity);
    }

    @PostMapping("save" + "Instituteregistrations")
    public boolean save(@RequestBody Instituteregistrations entity) throws IOException {

        entity.setCreatedon(getTimeStampDate());
        entity.setUpdatedon(getTimeStampDate());
        return multiActionDao.executePojoSaveObjectBuilder(entity);
    }

    @PostMapping("save" + "Newscategory")
    public boolean save(@RequestBody Newscategory entity) throws IOException {

        entity.setCreatedon(getTimeStampDate());
        entity.setUpdatedon(getTimeStampDate());
        return multiActionDao.executePojoSaveObjectBuilder(entity);
    }

    @PostMapping("save" + "News")
    public boolean save(@RequestBody News entity) throws IOException {

        entity.setCreatedon(getTimeStampDate());
        entity.setUpdatedon(getTimeStampDate());
        return multiActionDao.executePojoSaveObjectBuilder(entity);
    }

    //scheduler

    java.sql.Timestamp getTimeStampDate() {
        Date saveDate = new Date();
        java.sql.Timestamp timeStampDate = new Timestamp(saveDate.getTime());
        return timeStampDate;
    }

    @PostMapping("save" + "EmailMaster")
    public boolean save(@RequestBody EmailMaster entity) throws IOException {

        // entity.setCreatedon(getTimeStampDate());
        // entity.setUpdatedon(getTimeStampDate());
        return multiActionDao.executePojoSaveObjectBuilder(entity);
    }

    @PostMapping("save" + "Resumedata")
    public boolean save(@RequestBody Resumedata entity) throws IOException {

        // entity.setCreatedon(getTimeStampDate());
        // entity.setUpdatedon(getTimeStampDate());
        return multiActionDao.executePojoSaveObjectBuilder(entity);
    }

    @PostMapping("save" + "Companyprofiles")
    public boolean save(@RequestBody Companyprofiles entity) throws IOException {
        entity.setCreatedon(getTimeStampDate());
        entity.setUpdatedon(getTimeStampDate());
        return multiActionDao.executePojoSaveObjectBuilder(entity);
    }

    @PostMapping("save" + "Contactjobships")
    public boolean save(@RequestBody Contactjobships entity) throws IOException {
        entity.setCreatedon(getTimeStampDate());
        entity.setUpdatedon(getTimeStampDate());
        return multiActionDao.executePojoSaveObjectBuilder(entity);
    }

    @PostMapping("save" + "Companyjobads")
    public Object save(@RequestBody CompanyJobAdsDto companyJobAds) throws IOException, ParseException {
        CompanyJobAds updatedEntity = multiActionDao.getCompanyJobAds(CompanyJobAds.class, companyJobAds.getCompanyId().toString(),
                companyJobAds.getJobAdsTemplateId().toString());
        if (!ObjectUtils.isEmpty(updatedEntity)) {
            updatedEntity.setCompanyId(companyJobAds.getCompanyId());
            updatedEntity.setJobAdsTemplate(companyJobAds.getJobAdsTemplate());
            updatedEntity.setCreatedon(getTimeStampDate());
            updatedEntity.setUpdatedon(getTimeStampDate());
            updatedEntity.setCreatedby(companyJobAds.getCreatedby());
            updatedEntity.setIsactive(true);
            updatedEntity.setJobAdsTemplateId(companyJobAds.getJobAdsTemplateId());
            updatedEntity.setUpdatedby(companyJobAds.getCreatedby());
            multiActionDao.executePojoUpdateObject(updatedEntity);
            CompanyJobAds updateJobAds = multiActionDao.getCompanyJobAdsById(CompanyJobAds.class, updatedEntity.getId().toString());
            List<Companyjobposts> jobpostList = multiActionDao.getjobpostIdByCompanyId(Companyjobposts.class, updateJobAds.getCompanyId().toString());
            for (Companyjobposts jobpost : jobpostList) {
                JobAdsAndJobPostMapping jobadsJobpostMapping = new JobAdsAndJobPostMapping();
                jobadsJobpostMapping.setJobadsId(updateJobAds.getId());
                jobadsJobpostMapping.setJobpostId(jobpost.getId());
                multiActionDao.executePojoSaveObjectBuilder(jobadsJobpostMapping);
            }
            return updateJobAds;
        } else {
            CompanyJobAds savedEntity = new CompanyJobAds();
            savedEntity.setCompanyId(companyJobAds.getCompanyId());
            savedEntity.setJobAdsTemplate(companyJobAds.getJobAdsTemplate());
            savedEntity.setCreatedon(getTimeStampDate());
            savedEntity.setUpdatedon(getTimeStampDate());
            savedEntity.setCreatedby(companyJobAds.getCreatedby());
            savedEntity.setIsactive(true);
            savedEntity.setJobAdsTemplateId(companyJobAds.getJobAdsTemplateId());
            savedEntity.setUpdatedby(companyJobAds.getCreatedby());
            Integer id = multiActionDao.executePojoSaveObject(savedEntity);
            CompanyJobAds saveJobAds = multiActionDao.getCompanyJobAdsById(CompanyJobAds.class, id.toString());
            List<Companyjobposts> jobpostList = multiActionDao.getjobpostIdByCompanyId(Companyjobposts.class, saveJobAds.getCompanyId().toString());
            for (Companyjobposts jobpost : jobpostList) {
                JobAdsAndJobPostMapping jobadsJobpostMapping = new JobAdsAndJobPostMapping();
                jobadsJobpostMapping.setJobadsId(saveJobAds.getId());
                jobadsJobpostMapping.setJobpostId(jobpost.getId());
                multiActionDao.executePojoSaveObjectBuilder(jobadsJobpostMapping);
            }
            return saveJobAds;
        }
    }

    @PostMapping("save" + "Companyjobposts")
    public boolean save(@RequestBody JobPost entity) throws IOException, ParseException {
        entity.setCreatedon(getTimeStampDate());
        entity.setUpdatedon(getTimeStampDate());
        entity.setIsactive(true);

        //Parent table data insertion
        ObjectMapper oMapper = new ObjectMapper();
        Map<String, Object> mainObj = oMapper.convertValue(entity, Map.class);
        Object obj = mainObj.get("data");

        Map<String, Object> dataJobPosts = oMapper.convertValue(obj, Map.class);
        dataJobPosts.remove("jobDetails");

        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = inputFormat.parse(dataJobPosts.get("job_post_start_date").toString());
        String startDate = outputFormat.format(date);

        Date endDate = inputFormat.parse(dataJobPosts.get("job_post_end_date").toString());
        String formattedEndDate = outputFormat.format(endDate);

        mainObj.put("com_name", dataJobPosts.get("com_name"));
        mainObj.put("job_post_start_date", startDate);
        mainObj.put("job_post_end_date", formattedEndDate);
        mainObj.remove("data");
        Companyjobposts anotherBean = oMapper.convertValue(mainObj, Companyjobposts.class);
        Integer jobPostId = multiActionDao.executePojoSaveObject(anotherBean);

        //Child table record insertion
        if (jobPostId != 0) {
            Map<String, Object> childObj = oMapper.convertValue(entity, Map.class);
            Object childJobPostObj = childObj.get("data");

            Map<String, Object> dataObject = oMapper.convertValue(childJobPostObj, Map.class);
            //dataObject.put("companyjobpostid", jobPostId);
            dataObject.remove("com_name");
            dataObject.remove("job_post_start_date");
            dataObject.remove("job_post_end_date");

            Object JobPostDetails = dataObject.get("jobDetails");
            int flag = 0;
            List<Map<String, Object>> jobObj = oMapper.convertValue(JobPostDetails, new TypeReference<List<Map<String, Object>>>() {
            });
            for (Map<String, Object> jobPostMap : jobObj) {
                Set set = jobPostMap.entrySet();
                for (Object objSet : set) {
                    Map.Entry<String, Object> m = (Map.Entry<String, Object>) objSet;
                    CompanyjobpostsDetails comJobPost = new CompanyjobpostsDetails();
                    comJobPost.setCompanyjobpostid(jobPostId);
                    comJobPost.setTemplatecode(entity.getTemplatecode());
                    comJobPost.setTemplatetype(entity.getTemplatetype());
                    comJobPost.setCreatedby(entity.getCreatedby());
                    comJobPost.setUpdatedby(entity.getUpdatedby());
                    comJobPost.setJobPostkey(m.getKey());
                    comJobPost.setFlag(flag);
                    comJobPost.setJobPostvalue(m.getValue().toString());
                    comJobPost.setUserid(entity.getUserid());
                    comJobPost.setId(entity.getId());
                    comJobPost.setCreatedon(getTimeStampDate());
                    comJobPost.setUpdatedon(getTimeStampDate());
                    comJobPost.setIsactive(true);
                    multiActionDao.executePojoSaveObjectBuilder(comJobPost);
                }
                flag = flag + 1;
            }
            return true;
        }
        return false;

    }

    @PostMapping("save" + "CompanyjobpostsDetails")
    public boolean save(@RequestBody CompanyjobpostsDetails entity) throws IOException {

        entity.setCreatedon(getTimeStampDate());
        entity.setUpdatedon(getTimeStampDate());
        multiActionDao.executePojoSaveObjectBuilder(entity);
        return multiActionDao.executePojoSaveObjectBuilder(entity);
    }

    @PostMapping("save" + "Companytemplatejobposts")
    public boolean save(@RequestBody Companytemplatejobposts entity) throws IOException {

        entity.setCreatedon(getTimeStampDate());
        entity.setUpdatedon(getTimeStampDate());
        // for (int j = 0; j < 1000000; j++) {
        // multiActionDao.executePojoSaveObjectBuilder(entity);
        // }
        return multiActionDao.executePojoSaveObjectBuilder(entity);
    }

    @PostMapping("save" + "Companyletter")
    public boolean save(@RequestBody Companyletter entity) throws IOException {

        entity.setCreatedon(getTimeStampDate());
        entity.setUpdatedon(getTimeStampDate());
        return multiActionDao.executePojoSaveObjectBuilder(entity);
    }

    @PostMapping("save" + "Companyusers")
    public boolean save(@RequestBody Companyusers entity) throws IOException {

        entity.setCreatedon(getTimeStampDate());
        entity.setUpdatedon(getTimeStampDate());
        return multiActionDao.executePojoSaveObjectBuilder(entity);
    }

    @PostMapping("save" + "Greetingrequests")
    public boolean save(@RequestBody Greetingrequests entity) throws IOException {

        entity.setCreatedon(getTimeStampDate());
        entity.setUpdatedon(getTimeStampDate());
        return multiActionDao.executePojoSaveObjectBuilder(entity);
    }

    String getCureentDate() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }

/*
    @PostMapping("/saveUser")
    public boolean saveUser(@RequestBody User entity) throws IOException {

        //entity.setPassword(new BCryptPasswordEncoder().encode(entity.getPassword()));
        entity.setJoiningDate(getCureentDate());
        entity.setInvalidPassCount(0);
        entity.setIsActive(true);
        entity.setIsResetPassword(false);

        //File file = new File(httpServletRequest.getRealPath("/") + "/static/sssss.jpg");
        //byte[] bImage = Files.readAllBytes(file.toPath());
        //entity.setProfilepicture(bImage);
        //String extension = FilenameUtils.getExtension(file.getName());
        //entity.setExtension(extension);
        UserProfile upr = new UserProfile();
        List<UserProfile> prof = userProfileService.findAll();
        for (UserProfile u : prof) {
            System.out.println(u);
            //check add User
            if (u.getType().toString().equals(entity.getClient()))
                upr = u;


        }
        Set<UserProfile> userProfiles = new HashSet<UserProfile>();
        userProfiles.add(upr);
        entity.setUserProfiles(userProfiles);
        boolean saved = multiActionDao.executePojoSaveObjectBuilder(entity);
        return saved;
    }
*/
    @PostMapping("saveProduct")
    public boolean save(@RequestBody ProductMaster entity) throws IOException {
        entity.setFromDate(getTimeStampDate());
        entity.setToDate(getTimeStampDate());
        //entity.setUpdatedon(getTimeStampDate());
        return multiActionDao.saveProductList(entity);
    }

    @PostMapping("saveProductBanner")
    public boolean saveProductBanner(@RequestBody ProductBanner entity) throws IOException {
        entity.setFromDate(getTimeStampDate());
        entity.setToDate(getTimeStampDate());
        return multiActionDao.saveProductBanner(entity);
    }

    @PostMapping("saveProductFeaturedUser")
    public boolean saveProductFeaturedUser(@RequestBody ProductFeaturedUser entity) throws IOException {
        entity.setFromDate(getTimeStampDate());
        entity.setToDate(getTimeStampDate());
        entity.setCreatedon(getTimeStampDate());
        return multiActionDao.saveProductFetauredUser(entity);
    }

    @PostMapping("saveProductMixedServices")
    public boolean saveProductMixedServices(@RequestBody ProductMixedServices entity) throws IOException {
        entity.setFromDate(getTimeStampDate());
        entity.setToDate(getTimeStampDate());
        return multiActionDao.saveProductMixedService(entity);
    }

    @PostMapping("saveProductAccessList")
    public boolean saveProductAccessList(@RequestBody ProductAccessList entity) throws IOException {
        entity.setFromDate(getTimeStampDate());
        entity.setToDate(getTimeStampDate());
        return multiActionDao.saveProductAccessList(entity);
    }

}