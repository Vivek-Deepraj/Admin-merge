package com.discom.springmvc.dao;

import com.discom.springmvc.model.CompanyJobAdsResponse;
import com.discom.springmvc.model.CompanyJobPost;
import com.discom.springmvc.model.DataTableModel;
import com.discom.springmvc.model.DataTableModelSch;
import com.discom.springmvc.pojo.*;

import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface MultiActionDao {

    //save update delete actions on pojo object
    public boolean executePojoSaveObjectBuilder(Object object);

    public boolean executePojoUpdateObjectBuilder(Object object);

    public boolean executePojoDeleteObjectBuilder(Object object);

    //datalist/count of pojo object
    public List<?> executeDataListObjectBuilder(Class<?> pojoClass);

    public int executeDataListCountObjectBuilder(Class<?> pojoClass);

    //datalist/count of pojo object with search columns
    public List<?> executeDataListObjectBuilder(Class<?> pojoClass, String cList[], String vList[]);

    public int executeDataListCountObjectBuilder(Class<?> pojoClass, String cList[], String vList[]);

    //datalist using in/not in operator
    public List<?> executeDataListObjectBuilder(Class<?> pojoClass, String columns, boolean in, String vList[]);

    //pojo object search by columns
    public Class<?> executePojoObjectBuilder(Class<?> pojoClass, String cList[], String vList[]);

    public Object executePojoObjectBuilder2(Class<?> pojoClass, String cList[], String vList[]);

    //pojo datalist with start and end globalsearch and specific search for datatables
    public DataTableModel executeDataTableObjectBuilder(Class<?> pojoClass, int start, int length, String sSearch, String sList[], String cList[], String gscList[]);

    public DataTableModel executeDataTableObjectBuilderJSON(String pojoClass, int start, int length, String sSearch, String sList[], String cList[], String fList[]) throws Exception;

    public List<?> getRankByDepartmentId(Class<?> pojoClass, int departmentId);

    public TemplateGroupsFieldsChilds getTemplateGroupsFieldsChilds();

    public DataTableModel executeDataTableAgreementObjectBuilder(Class<?> pojoClass, int start, int length, String sSearch, String sList[], String cList[], String gscList[]);

    public DataTableModel executeDataTableIOMObjectBuilder(Class<?> pojoClass, int start, int length, String sSearch, String sList[], String cList[], String gscList[]);

    public List<?> executeDataTablePortfolioObjectBuilder(Class<?> pojoClass);

    public List<?> executeDataTableIOMObjectBuilder(Class<?> pojoClass);

    public List<?> executePojoIomDetailsBuilder2(String cList[], String vList[]);

    public List<?> executePojoAgreementDetailsBuilder2(String cList[], String vList[]);

    public List<?> executePojoAgreementTariffDetailsBuilder2(String cList[], String vList[]);

    public List<?> executePojoAgreementBuilder2(String cList[], String vList[]);

    public List<?> executePojoSubAgreementsListBuilder(String cList[], String vList[]);

    public List<?> executeDataTableDiscomObjectBuilder(Class<?> pojoClass, String cList[], String vList[]);


    //schedul

    int executePojoSaveObject(Object object);

    boolean executePojoUpdateObject(Object object);

    boolean executePojoDeleteObjectBuilder1(Companyjobposts object);

    boolean executePojoDeleteObjectBuilder2(Companyjobposts object);

    Object getCompanyjobpostByid(Class<?> pojoClass, String id);

    List<?> getAllCompany();

    Map<String, Object> executePojoObjectBuilder2sch(Class<?> pojoClass, String cList[], String vList[]);

    Object getjobPostDetails(List<Companyjobposts> jobPostDetails);

    Object getjobPostDetailsFilter1(Class<?> pojoClass, String companyName, String salaryfrom, String salaryto,
                                    int start, int length, String[] sList,
                                    String[] cList, String[] fList);

    List<CompanyJobPost> dataForMainTable(List<Companyjobposts> jobPostDetails, Map<Integer, Set<Integer>> companyJobPostlist);

    Map<Integer, Set<Integer>> jobpostList(String salaryfrom, String salaryto, int start, int length, String[] sList,
                                           String[] cList, String[] fList);

    Object executePojoObjectBuilder2(Class<?> pojoClass, String companyId);

    CompanyJobAds getCompanyJobAds(Class<?> pojoClass, String companyId, String templateId);


    public Object executePojoObjectCompany(Class<?> pojoClass, String companyId);

    public Object executePojoObjectBuilderForCandidate(Class<?> pojoClass, int start, int length, String companyName);

    public Object executePojoObjectBuilder3(Class<?> pojoClass, String cList[], String vList[]);
    //pojo datalist with start and end globalsearch and specific search for datatables


    public CompanyJobAds getCompanyJobAdsById(Class<?> pojoClass, String companyId);

    public Object getCompanyJobAdsByCompanyId(Class<?> pojoClass, String companyId, String templateId);

    public List<?> getCompanyJobAds(Class<?> pojoClass);

    public CompanyJobAdsResponse getCompanyjobadsById(Class<?> pojoClass, String id);

    public List<Companyjobposts> getjobpostIdByCompanyId(Class<?> pojoClass, String companyId);

    public List<CompanyJobAdsResponse> getCompanyjobadsByFilter(Class<?> pojoClass, List<Integer> jobpostIdList);

    public List<JobAdsAndJobPostMapping> getCompanyjobadsAndJoBPost(Class<?> pojoClass);

    public Object getCompanyjobpostsByIds(Class<?> pojoClass, List<Integer> jobpostIds);

    public boolean saveProductList(ProductMaster entity);

    public boolean saveProductBanner(ProductBanner entity);

    public boolean saveProductFetauredUser(ProductFeaturedUser entity);

    public boolean saveProductMixedService(ProductMixedServices entity);

    public boolean saveProductAccessList(ProductAccessList entity);

    public ProductMixedServices getProductMixedServiceByid(Class<?> pojoClass, String id);

    public ProductBanner getProductBannerByid(Class<?> pojoClass, String id);

    public ProductFeaturedUser getProductFeaturedUserByid(Class<?> pojoClass, String id);

    public ProductMaster getProductListByid(Class<?> pojoClass, String id);

    public ProductAccessList getProductAccessListByid(Class<?> pojoClass, String id);

    public DataTableModelSch executeDataTableObjectBuildersch(Class<?> pojoClass, int start, int length, String sSearch,
                                                              String sList[], String cList[], String gscList[]);

    public DataTableModelSch executeDataTableObject(String pojoClass, int start, int length, String sSearch,
                                                    String sList[], String cList[], String fList[]) throws Exception;

    public DataTableModelSch executeDataTableObjectBuilderJSONsch(String pojoClass, int start, int length, String sSearch,
                                                                  String sList[], String cList[], String fList[]) throws Exception;

    public DataTableModelSch executeDataTableObjectBuilderJSON2(String pojoClass, int start, int length, String sSearch,
                                                                String sList[], String cList[], String fList[], String subFList[], String companyName, String status,
                                                                String startDate, String endDate) throws Exception;

    public DataTableModelSch getAllBillingProduct(String pojoClass, int start, int length, String sSearch, String[] dbList) throws ParseException;

    public DataTableModelSch executeDataTableObjectBuilderJSON3(String pojoClass, int start, int length, int companyId, String sSearch,
                                                                String sList[], String cList[], String fList[], String subFList[], String status, String startDate, String endDate) throws Exception;


}