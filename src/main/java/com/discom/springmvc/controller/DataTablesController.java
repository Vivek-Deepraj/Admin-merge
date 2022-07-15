package com.discom.springmvc.controller;

import com.discom.springmvc.dao.SearchDao;
import com.discom.springmvc.model.DataTableModel;
import com.discom.springmvc.model.DataTablesTO;
import com.discom.springmvc.model.User;
import com.discom.springmvc.pojo.Constantslistsdetails;
import com.discom.springmvc.pojo.Ranksetting;
import com.discom.springmvc.service.ListService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DataTablesController {

    @Autowired
    ListService listService;
    @Autowired
    SearchDao searchDao;

    @RequestMapping(value = "/example")
    public @ResponseBody
    String exampleList(@RequestParam int iDisplayStart,
                       @RequestParam int iDisplayLength, @RequestParam int sEcho,
                       @RequestParam int iColumns, @RequestParam String sSearch,
                       @RequestParam int iSortCol_0, @RequestParam boolean bSortable_0,
                       @RequestParam int iSortingCols, @RequestParam("datat") String datat) {

        DataTablesTO<User> dt = new DataTablesTO<User>();
        List<User> accts = listService.getAllAdminList(iDisplayStart, iDisplayLength, sSearch);
        for (int i = 0; i < accts.size(); i++) {
            if (accts.get(i).isStatus() == true)
                accts.get(i).setStatus1("Active");
            else
                accts.get(i).setStatus1("Inactive");
        }
        int count = listService.getAllAdminListCount(sSearch);
        dt.setAaData(accts);
        dt.setiTotalDisplayRecords(count);
        dt.setiTotalRecords(count);
        dt.setsEcho(sEcho);
        return toJson(dt);
    }

    @RequestMapping(value = "/generalentitylisttt")
    public @ResponseBody
    String adminList(@RequestParam int iDisplayStart,
                     @RequestParam int iDisplayLength, @RequestParam int sEcho,
                     @RequestParam String sSearch) {

        DataTablesTO<Constantslistsdetails> dt = new DataTablesTO<Constantslistsdetails>();
        List<Constantslistsdetails> accts = listService.getAllConstantslistsdetailsList(iDisplayStart, iDisplayLength, sSearch);
        int count = listService.getAllConstantslistsdetailsListCount(sSearch);
        dt.setAaData(accts);
        dt.setiTotalDisplayRecords(count);
        dt.setiTotalRecords(count);
        dt.setsEcho(sEcho);
        return toJson(dt);
    }

    @RequestMapping(value = "/generalentitylistdata")
    public @ResponseBody
    String generalentitylistdata(@RequestParam("sSearch") String sSearch,
                                 @RequestParam("start") int start, @RequestParam("length") int length,
                                 @RequestParam("sList") String[] sList) throws JsonProcessingException {

        DataTableModel dataModel = searchDao.getConstantslistsdetailsDT(start, length, sSearch, sList);
        return new ObjectMapper().writeValueAsString(dataModel);
    }

//	@RequestMapping(value = "/getConstantslistsdetailsDataTableJson")
//	public @ResponseBody String getConstantslistsdetailsDataTableJson(@RequestParam("sSearch") String sSearch,
//			@RequestParam("start") int start, @RequestParam("length") int length, 
//			@RequestParam("sList") String[] sList) throws JsonProcessingException {
//			
//		String cList[] = {"type","code","label"};// column name as in pojo not in database
//		String gscList[] = {"type","code","label"};// column name as in pojo not in database
//		DataTableModel dataModel = searchDao.executeDataTableObjectBuilder(Constantslistsdetails.class, start, length, sSearch, sList, cList, gscList);
//		System.out.print(new ObjectMapper().writeValueAsString(dataModel));
//		
//		return new ObjectMapper().writeValueAsString(dataModel);
//	}

    @RequestMapping(value = "/getConstantslistsdetailsDataTableJson")
    public @ResponseBody
    String getConstantslistsdetailsDataTableJson(@RequestParam("sSearch") String sSearch,
                                                 @RequestParam("start") int start, @RequestParam("length") int length,
                                                 @RequestParam("sList") String[] sList) throws JsonProcessingException {

        String cList[] = {};// column name as in pojo not in database
        String gscList[] = {"type"};// column name as in pojo not in database
        DataTableModel dataModel = searchDao.executeDataTableObjectBuilderConstantsLists(Constantslistsdetails.class, start, length, sSearch, sList, cList, gscList);
        List<Constantslistsdetails> listt = new ArrayList<Constantslistsdetails>();
        for (Object dt : dataModel.getEntities()) {
            Constantslistsdetails ll = new Constantslistsdetails();
            ll.setType(((String) dt));
            listt.add(ll);
        }
        dataModel.setEntities(listt);
        System.out.print("DATAA________" + new ObjectMapper().writeValueAsString(dataModel));

        return new ObjectMapper().writeValueAsString(dataModel);
    }

    @RequestMapping(value = "/getRanksettingDataTableJson")
    public @ResponseBody
    String getRanksettingDataTableJson(@RequestParam("sSearch") String sSearch,
                                       @RequestParam("start") int start, @RequestParam("length") int length,
                                       @RequestParam("sList") String[] sList) throws JsonProcessingException {

        String cList[] = {"rank"};// column name as in pojo not in database
        String gscList[] = {"rank"};// column name as in pojo not in database
        DataTableModel dataModel = searchDao.executeDataTableObjectBuilder(Ranksetting.class, start, length, sSearch, sList, cList, gscList);
        System.out.print(new ObjectMapper().writeValueAsString(dataModel));

        return new ObjectMapper().writeValueAsString(dataModel);
    }

    @RequestMapping(value = "/generalentitylist")
    public @ResponseBody
    String generalentitylist(@RequestParam("sSearch") String sSearch,
                             @RequestParam("start") int start, @RequestParam("length") int length,
                             @RequestParam("sList") String[] sList) throws JsonProcessingException {

        List<Constantslistsdetails> accts = searchDao.findMasterDataa(start, length, sSearch, sList);
        //List<Constantslistsdetails> accts = new ArrayList<Constantslistsdetails>();

        return new ObjectMapper().writeValueAsString(accts);
    }

    @RequestMapping(value = "/generalentitylistcount")
    public @ResponseBody
    String generalentitylistCount(@RequestParam("sSearch") String sSearch,
                                  @RequestParam("start") int start, @RequestParam("length") int length,
                                  @RequestParam("sList") String[] sList) throws JsonProcessingException {

        int accts = searchDao.findMasterDataCountt(sSearch, sList);
        //List<Constantslistsdetails> accts = new ArrayList<Constantslistsdetails>();

        return new ObjectMapper().writeValueAsString(accts);
    }

    @RequestMapping(value = "/generalentity/{id}")
    public @ResponseBody
    String generalentityById(@PathVariable String id) throws JsonProcessingException {

        Constantslistsdetails accts = searchDao.findMasterDataById(id);
        //List<Constantslistsdetails> accts = new ArrayList<Constantslistsdetails>();

        return new ObjectMapper().writeValueAsString(accts);
    }

    @RequestMapping(value = "/generalentityylist")
    public @ResponseBody
    String generalentityylist() throws JsonProcessingException {

        List<Constantslistsdetails> accts = searchDao.findMasterData();
        //List<Constantslistsdetails> accts = new ArrayList<Constantslistsdetails>();

        return new ObjectMapper().writeValueAsString(accts);
    }

    @RequestMapping(value = "/generalentityy/{id}")
    public @ResponseBody
    String generalentityyById(@PathVariable String id) throws JsonProcessingException {

        Constantslistsdetails accts = searchDao.findMasterDataById(id);
        //List<Constantslistsdetails> accts = new ArrayList<Constantslistsdetails>();

        return new ObjectMapper().writeValueAsString(accts);
    }

    private String toJson(DataTablesTO<?> dt) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(dt);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

}
