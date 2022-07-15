package com.discom.springmvc.service;
/*
import com.discom.springmvc.pojo.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//@FeignClient(name="admin-service", url="http://localhost:8091/admin-service",configuration = AccountClientConfiguration.class)
@FeignClient(name = "admin-service", url = "http://localhost:8091/admin-service")
//@FeignClient(name="admin-service", url="${admin.ribbon.listOfServers}")

public interface ApiService {
    String AUTH_TOKEN = "Authorization";

    @GetMapping("/api/testt1")

    public String testtR(@RequestHeader(AUTH_TOKEN) String bearerToken);

    //	public String testtR();
    @GetMapping("/internal_api/getAllPortfolioList")
    public List<Portfoliomaster> getAllPortfolioList();

    @GetMapping(value = "/internal_api/getAllStateList")
    public List<Statemaster> getAllState();

    @GetMapping(value = "/internal_api/getAllDiscomList")
    public List<Discommaster> getAllDiscom();

    @GetMapping(value = "/internal_api/getAllRegionList")
    public List<Regionmaster> getAllRegion();

    @GetMapping(value = "/internal_api/getAllCompanyList")
    public List<Companymaster> getAllCompany();

    @GetMapping("/internal_api/getPortfoliomaster")
    public String getPortfoliomaster(@RequestParam(name = "id") String id);

    @GetMapping(value = "/internal_api/getStatemaster")
    public String getStatemaster(@RequestParam(name = "id") String id);

    @GetMapping(value = "/internal_api/getDiscommaster")
    public String getDiscommaster(@RequestParam(name = "id") String id);

    @GetMapping(value = "/internal_api/getRegionmaster")
    public String getRegionmaster(@RequestParam(name = "id") String id);

    @GetMapping(value = "/internal_api/getCompanymaster")
    public String Companymaster(@RequestParam(name = "id") String id);

    @GetMapping("/internal_api/getAgreementmaster")
    public String getAgreementmaster(@RequestParam(name = "id") String id);

    @GetMapping("/internal_api/findLastAgreementSnapShotByAgreementId")
    public String findLastAgreementSnapShotByAgreementId(@RequestParam(name = "id") String id);

    @GetMapping("/internal_api/findLastAgreementSnapShotByAgreementSnapshotMasterId")
    public String findLastAgreementSnapShotByAgreementSnapshotMasterId(@RequestParam(name = "id") String id);

    @GetMapping("/internal_api/getWpdActiveAgreementsListByWPDIDForSchedule")
    public String getWpdActiveAgreementsListByWPDIDForSchedule(@RequestParam(name = "date") String date, @RequestParam(name = "sellerportfolio") String sellerportfolio, @RequestParam(name = "ltoano") String ltoano);

    @GetMapping("/internal_api/getWpdActiveAgreementsListByApprovalNoForSchedule")
    public String getWpdActiveAgreementsListByApprovalNoForSchedule(@RequestParam(name = "date") String date, @RequestParam(name = "ppadiscomname") String ppadiscomname, @RequestParam(name = "psadiscomname") String psadiscomname, @RequestParam(name = "approvalno") String approvalno);

    @GetMapping("/internal_api/getPortfoliomasterByNickname")
    public String getPortfoliomasterByNickname(@RequestParam(name = "id") String id);
}
*/
