package com.discom.springmvc.controller;

import com.discom.springmvc.dao.SearchDao;
import com.discom.springmvc.pojo.*;
import com.discom.springmvc.service.ListService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/internal_api")
public class ProducerController {
    @Autowired
    ListService listService;
    @Autowired
    SearchDao searchDao;

    @GetMapping(value = "/testt1")
    public String testtR() {

        String msg = "test1";
        return msg;
    }

    @RequestMapping(value = "/getAll_Id_And_MasterId_PortfolioList")
    public @ResponseBody
    String getPortfolioList() {
        return listService.getAllPortfolioIdandMasterid();

    }

    @RequestMapping(value = "/getAllPortfolioList")
    public @ResponseBody
    List<Portfoliomaster> getAllPortfolioList() {
        return listService.getAllPortfolio();
    }

    @RequestMapping(value = "/getAllStateList")
    public @ResponseBody
    List<Statemaster> getAllStateList() {
        return listService.getAllState();
    }

    @RequestMapping(value = "/getAllDiscomList")
    public @ResponseBody
    List<Discommaster> getAllDiscomList() {
        return listService.getAllDiscom();
    }

    @RequestMapping(value = "/getAllRegionList")
    public @ResponseBody
    List<Regionmaster> getAllRegionList() {
        return listService.getAllRegion();
    }

    @RequestMapping(value = "/getAllCompanyList")
    public @ResponseBody
    List<Companymaster> getAllCompanyList() {
        return listService.getAllCompany();
    }

    @RequestMapping(value = "/getPortfoliomaster", method = RequestMethod.GET)
    public @ResponseBody
    String getPortfoliomaster(@RequestParam String id) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(listService.findPortfolio(id, "portfolioMasterId"));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
        //return listService.findPortfolio(id,"portfolioMasterId");
    }

    @GetMapping(value = "/getStatemaster")
    public @ResponseBody
    Statemaster getStatemaster(@RequestParam String id) {
        return listService.findState(id, "stateMasterId");
    }

    @GetMapping(value = "/getDiscommaster")
    public @ResponseBody
    Discommaster getDiscommaster(@RequestParam String id) {
        return listService.findDiscom(id, "discomMasterId");
    }

    @GetMapping(value = "/getRegionmaster")
    public @ResponseBody
    Regionmaster getRegionmaster(@RequestParam String id) {
        return listService.findRegionmaster(id, "portfolioMasterId");
    }

    @GetMapping(value = "/getCompanymaster")
    public @ResponseBody
    Companymaster Companymaster(@RequestParam String id) {
        return listService.findCompanymaster(id, "portfolioMasterId");
    }

    @GetMapping(value = "/getAgreementmaster")
    public @ResponseBody
    String getAgreementmaster(@RequestParam String id) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(listService.findAgreementmaster(id, "agreementMasterId"));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }

    }

    @GetMapping(value = "/findLastAgreementSnapShotByAgreementId")
    public @ResponseBody
    Agreementmastersnapshot findLastAgreementSnapShotByAgreementId(@RequestParam String id) {
        return searchDao.findLastAgreementSnapShotByAgreementId(id);
    }

    @GetMapping(value = "/findLastAgreementSnapShotByAgreementSnapshotMasterId")
    public @ResponseBody
    Agreementmastersnapshot findLastAgreementSnapShotByAgreementSnapshotMasterId(@RequestParam String id) {
        return searchDao.findLastAgreementSnapShotByAgreementSnapshotMasterId(id);
    }

    @GetMapping(value = "/getWpdActiveAgreementsListByWPDIDForSchedule")
    public List<Agreementmaster> getWpdActiveAgreementsListByWPDIDForSchedule(String date, String sellerportfolio, String ltoano) {
        return searchDao.getWpdActiveAgreementsListByWPDIDForSchedule(date, sellerportfolio, ltoano);
    }

    @GetMapping(value = "/getWpdActiveAgreementsListByApprovalNoForSchedule")
    public List<Agreementmaster> getWpdActiveAgreementsListByWPDIDForSchedule(String date, String ppadiscomname, String psadiscomname, String approvalno) {
        return searchDao.getWpdActiveAgreementsListByApprovalNoForSchedule(date, ppadiscomname, psadiscomname, approvalno);
    }

    @RequestMapping(value = "/getPortfoliomasterByNickname", method = RequestMethod.GET)
    public @ResponseBody
    String getPortfoliomasterByNickname(@RequestParam String id) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(listService.findPortfolio(id, "shortName"));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
        //return listService.findPortfolio(id,"portfolioMasterId");
    }

}
