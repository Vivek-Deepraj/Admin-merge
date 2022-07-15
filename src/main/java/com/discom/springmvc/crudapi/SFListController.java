package com.discom.springmvc.crudapi;

import com.discom.springmvc.dao.MultiActionDao;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SFListController {

    @Autowired
    MultiActionDao multiActionDao;

    @RequestMapping(value = "/getSF" + "Countrymaster" + "DataListJson")
    public @ResponseBody
    String getSFDataListJsonCountrymaster(@RequestParam("countycode") String countycode,
                                          @RequestParam("countryname") String countryname) throws JsonProcessingException {

        String cList[] = {"countycode", "countryname"};// column name as in pojo not in database
        String vList[] = {countycode, countryname};// column values
        List<?> dataListObject = multiActionDao.executeDataListObjectBuilder(Countrymaster.class, cList, vList);
        return new ObjectMapper().writeValueAsString(dataListObject);
    }

    @RequestMapping(value = "/getSF" + "Jobpostfields" + "DataListJson")
    public @ResponseBody
    String getSFDataListJsonJobpostfields(@RequestParam("labelName") String labelName,
                                          @RequestParam("fieldName") String fieldName) throws JsonProcessingException {

        String cList[] = {"labelName", "fieldName"};// column name as in pojo not in database
        String vList[] = {labelName, fieldName};// column values
        List<?> dataListObject = multiActionDao.executeDataListObjectBuilder(Jobpostfields.class, cList, vList);
        return new ObjectMapper().writeValueAsString(dataListObject);
    }

    @RequestMapping(value = "/getSF" + "Resumefields" + "DataListJson")
    public @ResponseBody
    String getSFDataListJsonResumefields(@RequestParam("labelName") String labelName,
                                         @RequestParam("fieldName") String fieldName) throws JsonProcessingException {

        String cList[] = {"labelName", "fieldName"};// column name as in pojo not in database
        String vList[] = {labelName, fieldName};// column values
        List<?> dataListObject = multiActionDao.executeDataListObjectBuilder(Resumefields.class, cList, vList);
        return new ObjectMapper().writeValueAsString(dataListObject);
    }

    @RequestMapping(value = "/getSF" + "TemplateGroupsFieldsChilds" + "DataListJson")
    public @ResponseBody
    String getSFDataListJsonTemplateGroupsFieldsChilds(@RequestParam("fieldcode") String fieldcode) throws JsonProcessingException {

        String cList[] = {"fieldcode"};// column name as in pojo not in database
        String vList[] = {fieldcode};// column values
        List<?> dataListObject = multiActionDao.executeDataListObjectBuilder(TemplateGroupsFieldsChilds.class, cList, vList);
        return new ObjectMapper().writeValueAsString(dataListObject);
    }

    @RequestMapping(value = "/getSF" + "TemplateGroupsFieldsValidators" + "DataListJson")
    public @ResponseBody
    String getSFDataListJsonTemplateGroupsFieldsValidators(@RequestParam("fieldcode") String fieldcode) throws JsonProcessingException {

        String cList[] = {"fieldcode"};// column name as in pojo not in database
        String vList[] = {fieldcode};// column values
        List<?> dataListObject = multiActionDao.executeDataListObjectBuilder(TemplateGroupsFieldsValidators.class, cList, vList);
        return new ObjectMapper().writeValueAsString(dataListObject);
    }

    @RequestMapping(value = "/getSF" + "TemplateGroupsFieldsValidators2" + "DataListJson")
    public @ResponseBody
    String getSFDataListJsonTemplateGroupsFieldsValidators2(@RequestParam("fieldcode") String fieldcode) throws JsonProcessingException {

        List<TemplateGroupsFieldsValidators> allValidators = new ArrayList<TemplateGroupsFieldsValidators>();
        String val[] = {"required", "min", "max", "minLength", "maxLength", "email", "pattern"};

        String cList[] = {"fieldcode"};// column name as in pojo not in database
        String vList[] = {fieldcode};// column values
        List<TemplateGroupsFieldsValidators> dataListObject = (List<TemplateGroupsFieldsValidators>) multiActionDao.executeDataListObjectBuilder(TemplateGroupsFieldsValidators.class, cList, vList);
        for (TemplateGroupsFieldsValidators vl : dataListObject) {
            vl.setSelected(true);
            if (vl.getName().equals("required") || vl.getName().equals("email")) {
                vl.setValue("");
            } else if (vl.getName().equals("pattern")) {
                vl.setValue(vl.getValidator().replace("Validators." + vl.getName(), "").replace("(", "").replace(")", "").replaceAll("'", ""));
            } else {
                vl.setValue(vl.getValidator().replace("Validators." + vl.getName(), "").replace("(", "").replace(")", ""));
            }
            allValidators.add(vl);
            if (Arrays.asList(val).contains(vl.getName())) {
                List<String> list = new ArrayList<String>(Arrays.asList(val));
                list.remove(vl.getName());
                val = list.toArray(new String[0]);
            }
        }

        for (String s : val) {
            TemplateGroupsFieldsValidators vald = new TemplateGroupsFieldsValidators();
            vald.setFieldcode(fieldcode);
            vald.setName(s);
            if (s.equals("required") || s.equals("email")) {
                vald.setValidator("Validators." + s);
            } else if (s.equals("pattern")) {
                vald.setValidator("Validators." + s + "('')");
            } else {
                vald.setValidator("Validators." + s + "()");
            }
            vald.setMessage("");
            vald.setSelected(false);
            vald.setValue("");
            allValidators.add(vald);
        }
//		for(String s:val)
//		{
//			for(TemplateGroupsFieldsValidators vl:dataListObject)
//			{
//				if(vl.getName().equals(s))
//				{
//					vl.setSelected(true);
//					if(s.equals("required") || s.equals("email"))
//					{
//						vl.setValue("");
//					}
//					else if(s.equals("pattern"))
//					{
//						vl.setValue(vl.getValidator().replace("Validators."+s, "").replace("(", "").replace(")", "").replaceAll("'", ""));
//					}
//					else
//					{
//						vl.setValue(vl.getValidator().replace("Validators."+s, "").replace("(", "").replace(")", ""));
//					}
//					allValidators.add(vl);
//				}
//				else
//				{
//					TemplateGroupsFieldsValidators vald = new TemplateGroupsFieldsValidators();
//					vald.setFieldcode(fieldcode);
//					vald.setName(s);
//					if(s.equals("required") || s.equals("email"))
//					{
//						vald.setValidator("Validators."+s);
//					}
//					else if(s.equals("pattern"))
//					{
//						vald.setValidator("Validators."+s+"('')");
//					}
//					else
//					{
//						vald.setValidator("Validators."+s+"()");
//					}
//					vald.setMessage("");
//					vald.setValue("");
//					vald.setSelected(false);
//					allValidators.add(vald);
//				}				
//			}
//		}		
//		if(allValidators.size()==0)
//		{
//			for(String s:val)
//			{
//				TemplateGroupsFieldsValidators vald = new TemplateGroupsFieldsValidators();
//				vald.setFieldcode(fieldcode);
//				vald.setName(s);
//				if(s.equals("required") || s.equals("email"))
//				{
//					vald.setValidator("Validators."+s);
//				}
//				else if(s.equals("pattern"))
//				{
//					vald.setValidator("Validators."+s+"('')");
//				}
//				else
//				{
//					vald.setValidator("Validators."+s+"()");
//				}
//				vald.setMessage("");
//				vald.setSelected(false);
//				vald.setValue("");
//				allValidators.add(vald);
//			}
//		}
        return new ObjectMapper().writeValueAsString(allValidators);
    }

    @RequestMapping(value = "/get" + "RankBy" + "DepartmentId")
    public @ResponseBody
    String getRankByDepartmentId(@RequestParam("departmentId") String departmentId) throws JsonProcessingException {

        List<?> dataListObject = multiActionDao.getRankByDepartmentId(DepartmentRankMapping.class, Integer.parseInt(departmentId));
        return new ObjectMapper().writeValueAsString(dataListObject);
    }


    @RequestMapping(value = "/getSF" + "TemplateGroups" + "DataListJson")
    public @ResponseBody
    String getSFDataListJson(@RequestParam("templatecode") String templatecode, @RequestParam("templatetype") String templatetype) throws JsonProcessingException {

        String cList[] = {"templatecode", "templatetype"};// column name as in pojo not in database
        String vList[] = {templatecode + "", templatetype};// column values
        List<?> dataListObject = multiActionDao.executeDataListObjectBuilder(TemplateGroups.class, cList, vList);
        return new ObjectMapper().writeValueAsString(dataListObject);
    }

    @RequestMapping(value = "/getSF" + "TemplateGroups" + "DataListJson2")
    public @ResponseBody
    String getSFDataListJson2(@RequestParam("templatecode") String templatecode, @RequestParam("templatetype") String templatetype) throws JsonProcessingException, ParseException {

        String ccList[] = {"templatecode", "templatetype"};// column name as in pojo not in database
        String vvList[] = {templatecode, templatetype};// column values
        List<TemplateGroups> dataListObjectFull = new ArrayList<TemplateGroups>();
        List<TemplateGroups> dataListObject = (List<TemplateGroups>) multiActionDao.executeDataListObjectBuilder(TemplateGroups.class, ccList, vvList);
        for (TemplateGroups tg : dataListObject) {
            String alreadySelectedFields[] = tg.getFields().split(",");
            List<TemplateGroupsFields> templateGroupsFields = new ArrayList<TemplateGroupsFields>();
            for (String field : alreadySelectedFields) {
                String cList[] = {"fieldcode"};// column name as in pojo not in database
                String vList[] = {field};// column values
                TemplateGroupsFields pojoObject = (TemplateGroupsFields) multiActionDao.executePojoObjectBuilder2(TemplateGroupsFields.class, cList, vList);

                List<TemplateGroupsFieldsChilds> dataListObject1 = (List<TemplateGroupsFieldsChilds>) multiActionDao.executeDataListObjectBuilder(TemplateGroupsFieldsChilds.class, cList, vList);

                List<TemplateGroupsFieldsValidators> dataListObject2 = (List<TemplateGroupsFieldsValidators>) multiActionDao.executeDataListObjectBuilder(TemplateGroupsFieldsValidators.class, cList, vList);

                pojoObject.setTemplateGroupsFieldsChilds(dataListObject1);
                pojoObject.setTemplateGroupsFieldsValidators(dataListObject2);
                templateGroupsFields.add(pojoObject);
            }
            tg.setTemplateGroupsFields(templateGroupsFields);
            dataListObjectFull.add(tg);
        }
//		
//		JSONParser parser = new JSONParser();
//	      JSONArray jArr = (JSONArray) parser.parse(new ObjectMapper().writeValueAsString(dataListObject));   
//	      for (int i = 0; i < jArr.size(); ++i) {
//	    	  System.out.println("JSONARR "+jArr.get(i).toString());
//	    	  
//	         JSONObject jObj = (JSONObject) parser.parse(jArr.get(i).toString());
//	       //  for(int j = 0; j < columnskeys.length; j++) {
//	        	// row.createCell(j).setCellValue(jObj.get(columnskeys[j])+"");
//	       //  }
//	      }
        System.out.println(new ObjectMapper().writeValueAsString(dataListObjectFull));
        return new ObjectMapper().writeValueAsString(dataListObjectFull);
    }

    @RequestMapping(value = "/getSF" + "TemplateGroups" + "DataListJson3")
    public @ResponseBody
    String getSFDataListJson3(@RequestParam("templatecode") String templatecode, @RequestParam("templatetype") String templatetype) throws JsonProcessingException, ParseException {

        String ccList[] = {"templatecode", "templatetype"};// column name as in pojo not in database
        String vvList[] = {templatecode, templatetype};// column values
        List<TemplateGroups> dataListObjectFull = new ArrayList<TemplateGroups>();
        List<TemplateGroups> dataListObject = (List<TemplateGroups>) multiActionDao.executeDataListObjectBuilder(TemplateGroups.class, ccList, vvList);
        for (TemplateGroups tg : dataListObject) {
            String alreadySelectedFields[] = tg.getFields().split(",");
            List<TemplateGroupsFields> templateGroupsFields = new ArrayList<TemplateGroupsFields>();
            for (String field : alreadySelectedFields) {
                String cList[] = {"fieldcode"};// column name as in pojo not in database
                String vList[] = {field};// column values
                TemplateGroupsFields pojoObject = (TemplateGroupsFields) multiActionDao.executePojoObjectBuilder2(TemplateGroupsFields.class, cList, vList);

                List<TemplateGroupsFieldsChilds> dataListObject1 = (List<TemplateGroupsFieldsChilds>) multiActionDao.executeDataListObjectBuilder(TemplateGroupsFieldsChilds.class, cList, vList);

                List<TemplateGroupsFieldsValidators> dataListObject2 = (List<TemplateGroupsFieldsValidators>) multiActionDao.executeDataListObjectBuilder(TemplateGroupsFieldsValidators.class, cList, vList);

                pojoObject.setTemplateGroupsFieldsChilds(dataListObject1);
                pojoObject.setTemplateGroupsFieldsValidators(dataListObject2);
                templateGroupsFields.add(pojoObject);
            }
            tg.setTemplateGroupsFields(templateGroupsFields);
            dataListObjectFull.add(tg);
        }
        return new ObjectMapper().writeValueAsString(dataListObjectFull);
    }

    @RequestMapping(value = "/get" + "SFFTemplateGroupsFields" + "DataListJson")
    public @ResponseBody
    String getSFfDataListJson(@RequestParam("sList") String[] sList, @RequestParam("filterBy") String filterBy) throws JsonProcessingException {

        System.out.println(sList + " >>> " + filterBy);
        List<?> dataListObject = multiActionDao.executeDataListObjectBuilder(TemplateGroupsFields.class, filterBy, false, sList);
        return new ObjectMapper().writeValueAsString(dataListObject);
    }

    java.sql.Timestamp getTimeStampDate() {
        Date saveDate = new Date();
        java.sql.Timestamp timeStampDate = new Timestamp(saveDate.getTime());
        return timeStampDate;
    }

    //scheduler


    @RequestMapping(value = "/getSF" + "EmailMaster" + "DataListJson")
    public @ResponseBody
    String getSFDataListJsonsch(@RequestParam("templatecode") String templatecode, @RequestParam("templatetype") String templatetype) throws JsonProcessingException {

        String cList[] = {"templatecode", "templatetype"};// column name as in pojo not in database
        String vList[] = {templatecode, templatetype};// column values
        List<?> dataListObject = multiActionDao.executeDataListObjectBuilder(EmailMaster.class, cList, vList);
        return new ObjectMapper().writeValueAsString(dataListObject);
    }

    @RequestMapping(value = "/getSF" + "Resumedata" + "DataListJson")
    public @ResponseBody
    String getSFDataListJson(@RequestParam("sList") String[] sList, @RequestParam("filterBy") String filterBy) throws JsonProcessingException {

        System.out.println(sList + " >>> " + filterBy);
        List<?> dataListObject = multiActionDao.executeDataListObjectBuilder(Resumedata.class, filterBy, false, sList);
        return new ObjectMapper().writeValueAsString(dataListObject);
    }
}