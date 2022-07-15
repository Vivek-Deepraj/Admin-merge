package com.discom.springmvc.serviceimpl;

import com.discom.springmvc.dao.SearchDao;
import com.discom.springmvc.pojo.Agreementmaster;
import com.discom.springmvc.pojo.Agreementmastersnapshot;
import com.discom.springmvc.pojo.Discommaster;
import com.discom.springmvc.pojo.Portfoliomaster;
import com.discom.springmvc.service.AdminDataService;
//import com.discom.springmvc.service.ApiService;
import com.discom.springmvc.service.ListService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("adminDataService")
public class AdminDataServiceImpl implements AdminDataService {
    //@Autowired
    //ApiService apiService;
    @Autowired
    ListService listService;
    @Autowired
    SearchDao searchDao;

    public Portfoliomaster getPortfoliomaster(String id) {
        //Portfoliomaster wpdmaster = null;
        Portfoliomaster wpdmaster=listService.findPortfolio(id, "portfolioMasterId");
        /*ObjectMapper mapper = new ObjectMapper();
        try {
            wpdmaster = mapper.readValue(port, Portfoliomaster.class);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        return wpdmaster;
    }

    public Portfoliomaster getPortfoliomasterByNickname(String id) {
       // Portfoliomaster portfoliomaster = null;
        Portfoliomaster portfoliomaster= listService.findPortfolio(id, "shortName");
       /* ObjectMapper mapper = new ObjectMapper();
        try {
            portfoliomaster = mapper.readValue(port, Portfoliomaster.class);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        return portfoliomaster;
    }

    public Agreementmaster getAgreementmaster(String agreementMasterId) {
        //Agreementmaster obj = null;
        Agreementmaster obj = listService.findAgreementmaster(agreementMasterId, "agreementMasterId");
        /*ObjectMapper mapper = new ObjectMapper();
        try {
            obj = mapper.readValue(port, Agreementmaster.class);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        return obj;
    }

    public Agreementmastersnapshot findLastAgreementSnapShotByAgreementId(String agreementMasterId) {
        Agreementmastersnapshot obj =searchDao.findLastAgreementSnapShotByAgreementId(agreementMasterId);
        /*String port = apiService.findLastAgreementSnapShotByAgreementId(agreementMasterId);
        ObjectMapper mapper = new ObjectMapper();
        try {
            obj = mapper.readValue(port, Agreementmastersnapshot.class);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        return obj;
    }

    public Discommaster getDiscommaster(String portfolio) {
        Discommaster obj =  listService.findDiscom(portfolio, "discomMasterId");
        /*String port = apiService.getDiscommaster(portfolio);
        ObjectMapper mapper = new ObjectMapper();
        try {
            obj = mapper.readValue(port, Discommaster.class);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        return obj;
    }

    public List<Agreementmaster> getWpdActiveAgreementsListByWPDIDForSchedule(String date, String sellerportfolio, String ltoano) {
        List<Agreementmaster> obj = searchDao.getWpdActiveAgreementsListByWPDIDForSchedule(date, sellerportfolio, ltoano);
        /*String port = apiService.getWpdActiveAgreementsListByWPDIDForSchedule(date, sellerportfolio, ltoano);
        ObjectMapper mapper = new ObjectMapper();
        try {
            obj = mapper.readValue(port, new TypeReference<List<Agreementmaster>>() {
            });

        } catch (Exception e) {
            e.printStackTrace();
        }*/
        return obj;
    }

    public List<Agreementmaster> getWpdActiveAgreementsListByWPDIDForSchedule(String date, String ppadiscomname, String psadiscomname, String approvalno) {
        System.out.println("getWpdActiveAgreementsListByWPDIDForSchedule api ");
        List<Agreementmaster> obj = searchDao.getWpdActiveAgreementsListByApprovalNoForSchedule(date, ppadiscomname, psadiscomname, approvalno);
       /* String port = apiService.getWpdActiveAgreementsListByApprovalNoForSchedule(date, ppadiscomname, psadiscomname, approvalno);
        ObjectMapper mapper = new ObjectMapper();
        try {
            obj = mapper.readValue(port, new TypeReference<List<Agreementmaster>>() {
            });

        } catch (Exception e) {
            e.printStackTrace();
        }*/
        return obj;
    }


}