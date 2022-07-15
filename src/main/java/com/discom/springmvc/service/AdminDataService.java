package com.discom.springmvc.service;

import com.discom.springmvc.pojo.Agreementmaster;
import com.discom.springmvc.pojo.Agreementmastersnapshot;
import com.discom.springmvc.pojo.Discommaster;
import com.discom.springmvc.pojo.Portfoliomaster;

import java.util.List;


public interface AdminDataService {
    public Portfoliomaster getPortfoliomaster(String id);

    Agreementmaster getAgreementmaster(String agreementMasterId);

    Agreementmastersnapshot findLastAgreementSnapShotByAgreementId(String agreementMasterId);

    Discommaster getDiscommaster(String portfolio);

    public List<Agreementmaster> getWpdActiveAgreementsListByWPDIDForSchedule(String date, String sellerportfolio, String ltoano);

    public List<Agreementmaster> getWpdActiveAgreementsListByWPDIDForSchedule(String date, String ppadiscomname, String psadiscomname, String approvalno);

    public Portfoliomaster getPortfoliomasterByNickname(String id);
}

