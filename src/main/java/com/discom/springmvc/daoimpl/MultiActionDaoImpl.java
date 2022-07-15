package com.discom.springmvc.daoimpl;

import com.discom.springmvc.dao.MultiActionDao;
import com.discom.springmvc.model.*;
import com.discom.springmvc.pojo.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.*;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;
import org.hibernate.type.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Repository("multiActionDao")
@Transactional
public class MultiActionDaoImpl implements MultiActionDao {

    @Autowired
    private SessionFactory sessionFactory;

    //save update delete actions on pojo object
    @Transactional
    public boolean executePojoSaveObjectBuilder(Object object) {
        boolean status = false;
        try {
            sessionFactory.getCurrentSession().save(object);
            status = true;
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
        return status;
    }

    @Transactional
    public boolean executePojoUpdateObjectBuilder(Object object) {
        boolean status = false;
        try {
            sessionFactory.getCurrentSession().update(object);
            status = true;
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
        return status;
    }

    @Transactional
    public boolean executePojoDeleteObjectBuilder(Object object) {
        boolean status = false;
        try {
            sessionFactory.getCurrentSession().delete(object);
            status = true;
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
        return status;
    }

    //datalist/count of pojo object
    @Transactional
    public List<?> executeDataListObjectBuilder(Class<?> pojoClass) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(pojoClass).addOrder(Order.asc("id"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<?> dataListObject = (List<?>) criteria.list();
        return dataListObject;
    }

    @Transactional
    public int executeDataListCountObjectBuilder(Class<?> pojoClass) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(pojoClass).addOrder(Order.asc("id"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        int dataListCount = ((Number) criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();
        return dataListCount;
    }

    //datalist/count of pojo object with search columns
    @Transactional
    public List<?> executeDataListObjectBuilder(Class<?> pojoClass, String cList[], String vList[]) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(pojoClass).addOrder(Order.asc("id"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        for (int i = 0; i < cList.length; i++) {
            if (vList[i] != null && !vList[i].equals("")) {
                criteria.add(Restrictions.eq(cList[i], vList[i]));
            }
        }
        List<?> dataListObject = (List<?>) criteria.list();
        return dataListObject;
    }

    @Transactional
    public int executeDataListCountObjectBuilder(Class<?> pojoClass, String cList[], String vList[]) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(pojoClass).addOrder(Order.asc("id"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        for (int i = 0; i < cList.length; i++) {
            if (vList[i] != null && !vList[i].equals("")) {
                criteria.add(Restrictions.eq(cList[i], vList[i]));
            }
        }
        int dataListCount = ((Number) criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();
        return dataListCount;
    }

    //datalist using in/not in operator
    @Transactional
    public List<?> executeDataListObjectBuilder(Class<?> pojoClass, String columns, boolean in, String vList[]) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(pojoClass).addOrder(Order.asc("id"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        if (vList.length > 0) {
            if (in == true) {
                criteria.add(Restrictions.in(columns, vList));
            } else {
                criteria.add(Restrictions.not(Restrictions.in(columns, vList)));
            }
        }
        List<?> dataListObject = (List<?>) criteria.list();
        return dataListObject;
    }


    //pojo object search by columns
    @Transactional
    public Class<?> executePojoObjectBuilder(Class<?> pojoClass, String cList[], String vList[]) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(pojoClass).addOrder(Order.asc("id"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        for (int i = 0; i < cList.length; i++) {
            if (vList[i] != null && !vList[i].equals("")) {
                criteria.add(Restrictions.eq(cList[i], vList[i]));
            }
        }
        Class<?> pojoObject = (Class<?>) criteria.uniqueResult();
        return pojoObject;
    }

    @Transactional
    public Object executePojoObjectBuilder2(Class<?> pojoClass, String cList[], String vList[]) {
        System.out.println(pojoClass);
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(pojoClass).addOrder(Order.asc("id"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        for (int i = 0; i < cList.length; i++) {
            if (vList[i] != null && !vList[i].equals("")) {
                Object val = applyAutoCasting(pojoClass, cList[i], vList[i]);
                criteria.add(Restrictions.eq(cList[i], val));
                //criteria.add(Restrictions.eq(cList[i], (cList[i].equals("id")?Integer.valueOf(vList[i]):vList[i])));
            }
        }
        Object result = null;
        try {
            result = criteria.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    //pojo datalist with start and end globalsearch and specific search for datatables
    @Transactional
    public DataTableModel executeDataTableObjectBuilder(Class<?> pojoClass, int start, int length, String sSearch, String sList[], String cList[], String gscList[]) {

        DataTableModel dataModel = new DataTableModel();
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(pojoClass).addOrder(Order.asc("id"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        for (int i = 0; i < sList.length; i++) {
            if (sList[i] != null && !sList[i].equals("")) {
                criteria.add(Restrictions.eq(cList[i], sList[i]));
            }
        }
        if (sSearch != null && !sSearch.equals("")) {
            Disjunction disjunction = Restrictions.disjunction();
            for (String column : gscList) {
                disjunction.add(Restrictions.like(column, "%" + sSearch + "%", MatchMode.START));
            }
            criteria.add(disjunction);
        }
        criteria.setFirstResult(start);
        criteria.setMaxResults(length);
        List<?> dataList = (List<?>) criteria.list();
        dataModel.setEntities(dataList);
        criteria.setFirstResult(0);
        criteria.setMaxResults(1000000000);
        int total = ((Number) criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();
        dataModel.setTotalCount(total);
        return dataModel;
    }

    public List<?> getRankByDepartmentId(Class<?> pojoClass, int departmentId) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(pojoClass).addOrder(Order.asc("id"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);// To avoid duplicates.
        Object val = applyAutoCasting(pojoClass, "departmentId", String.valueOf(departmentId));
        criteria.add(Restrictions.eq("departmentId", val));
        List<DepartmentRankMapping> list = criteria.list();
        Set<Long> departmentIdList = new HashSet<>();
        for (DepartmentRankMapping departmentRank : list) {
            departmentIdList.add(Long.valueOf(departmentRank.getRankId()));
        }

        Criteria criteria1 = sessionFactory.getCurrentSession().createCriteria(TemplateGroupsFieldsChilds.class).addOrder(Order.asc("id"));
        criteria1.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);// To avoid duplicates.
        //Object val1 = applyAutoCasting(TemplateGroupsFieldsChilds.class, "id", String.valueOf(departmentId));
        //criteria.add(Restrictions.eq("rankId", val1));
        criteria1.add(Restrictions.in("id", departmentIdList));

        return criteria1.list();
    }


    //pojo datalist with start and end globalsearch and specific search for datatables
    @Transactional
    public DataTableModel executeDataTableObjectBuilderJSON(String pojoClass, int start, int length, String sSearch, String sList[], String cList[], String fList[]) throws Exception {

        //CtClass clazz = new DynamicModel().generatePojo(fList);
        Map<String, Class<?>> clazz = new HashMap<String, Class<?>>();
        //props.put("foo", Integer.class);
        for (String field : fList) {
            clazz.put(field.trim(), Object.class);
        }
        DataTableModel dataModel = new DataTableModel();
        int c = 0;
        String qry = "", qry2 = "";
        if (sSearch == null)
            sSearch = "";
        if (sSearch.trim().equals("")) {
            qry2 += "";
        } else {
            qry2 += " JSON_SEARCH(a.data, 'all', '%" + sSearch + "%') IS NOT NULL ";
        }
        for (int i = 0; i < sList.length; i++) {
            if (sList[i] != null && !sList[i].equals("")) {
                if (c == 0) {
                    qry += " where JSON_EXTRACT(a.data, '$." + cList[i] + "') ='" + sList[i] + "' ";
                } else {
                    qry += " and JSON_EXTRACT(a.data, '$." + cList[i] + "') ='" + sList[i] + "' ";
                }
                c++;
            }
        }
        //a.data->'$.name'='';
        //System.out.println("query is::"+qry);
        if (qry.equals("")) {
            if (qry2.equals("")) {

            } else {
                qry += " where ";
            }
        } else {
            if (qry2.equals("")) {

            } else {
                qry += " and ";
            }
        }


        String extractFields = "";
        for (int ind = 0; ind < fList.length; ind++) {
            if (ind == 0) {
                extractFields += " JSON_UNQUOTE(JSON_EXTRACT(data, '$." + fList[ind] + "')) as " + fList[ind] + " ";
            } else {
                extractFields += " ,JSON_UNQUOTE(JSON_EXTRACT(data, '$." + fList[ind] + "')) as " + fList[ind] + " ";
            }
        }
        //select JSON_OBJECT('col1',col1,'col2',col2) from contactjobships;
        SQLQuery sqlQuery = sessionFactory.getCurrentSession().createSQLQuery("select id as id, " + extractFields + " from " + pojoClass + " a " + qry + qry2 + " ");
        sqlQuery.addScalar("id", IntegerType.INSTANCE);
        for (int ind = 0; ind < fList.length; ind++) {
            sqlQuery.addScalar(fList[ind], StringType.INSTANCE);
        }
        sqlQuery.setResultTransformer(Transformers.aliasToBean(clazz.getClass())).setMaxResults(length).setFirstResult(start);

        List<?> dataList = sqlQuery.list();
        dataModel.setEntities(dataList);
        sqlQuery.setMaxResults(1000000000).setFirstResult(0).list();
        int total = ((Number) sqlQuery.list().size()).intValue();
        dataModel.setTotalCount(total);
        return dataModel;
    }

    public Object applyAutoCasting(Class<?> pojoClass, String fieldName, String fieldValue) {
        Object catsedValue = null;
        try {
            java.lang.reflect.Field[] attributes = pojoClass.getDeclaredFields();
            for (Field field : attributes) {
                System.out.println("Field Name: " + field.getName());
                if (field.getName().equals(fieldName)) {
                    System.out.println("Field Type: " + field.getType());
                    //Class c= Class.forName(field.getType()+"");
                    //Object afterApplyCatingValue = (field.getType().cast(catsedValue));
                    //field.getType().cast(fieldValue);
                    CLAZZ z = CLAZZ.valueOf(field.getType().getSimpleName());
                    switch (z) {
                        case Long:
                            catsedValue = Long.valueOf(fieldValue);
                            break;
                        case Integer:
                            catsedValue = Integer.valueOf(fieldValue);
                            break;
                        case BigDecimal:
                            catsedValue = new BigDecimal(fieldValue);
                            break;
                        case Boolean:
                            catsedValue = Boolean.valueOf(fieldValue);
                            break;
                        case Date:
                            catsedValue = new SimpleDateFormat("dd-MM-yyyy").parse(fieldValue);
                            break;
                        case String:
                            catsedValue = fieldValue;
                            break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return catsedValue;
    }


    @Transactional
    public DataTableModel executeDataTableAgreementObjectBuilder(Class<?> pojoClass, int start, int length, String sSearch, String sList[], String cList[], String gscList[]) {

        DataTableModel dataModel = new DataTableModel();
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(pojoClass).addOrder(Order.asc("id"));

        ProjectionList projList = Projections.projectionList();
        projList.add(Projections.property("agreementMasterId").as("agreementMasterId"));

        projList.add(Projections.sqlProjection("(select p.portfolioname from Portfoliomaster p where this_.buyerportfolio=p.portfolioMasterId) as buyerportfolio",
                new String[]{"buyerportfolio"}, new Type[]{StandardBasicTypes.STRING}));
        //projList.add(Projections.sqlProjection("(select p.portfolioname from Portfoliomaster p where buyerportfolio=p.portfolioMasterId)").as("buyerportfolio"));

        projList.add(Projections.sqlProjection("(select p.portfolioname from Portfoliomaster p where this_.sellerportfolio=p.portfolioMasterId) as sellerportfolio",
                new String[]{"sellerportfolio"}, new Type[]{StandardBasicTypes.STRING}));

        //	projList.add(Projections.property("sellerportfolio").as("sellerportfolio"));
        projList.add(Projections.sqlProjection("Date_Format(stratDate,'%d-%m-%Y') as stratDate",
                new String[]{"stratDate"}, new Type[]{StandardBasicTypes.STRING}));

        //projList.add(Projections.property("stratDate").as("stratDate"));
        projList.add(Projections.sqlProjection("Date_Format(endDate,'%d-%m-%Y') as endDate",
                new String[]{"endDate"}, new Type[]{StandardBasicTypes.STRING}));

        //projList.add(Projections.property("endDate").as("endDate"));


        projList.add(Projections.property("ltoano").as("ltoano"));
        projList.add(Projections.property("status").as("status"));
        projList.add(Projections.property("contractno").as("contractno"));
        projList.add(Projections.property("fileName").as("fileName"));
        projList.add(Projections.property("parentAgreementMasterId").as("parentAgreementMasterId"));
        criteria.setProjection(projList);
        criteria.setResultTransformer(Transformers.aliasToBean(Agreementmaster.class));//To avoid duplicates.
        for (int i = 0; i < sList.length; i++) {
            if (sList[i] != null && !sList[i].equals("")) {
                criteria.add(Restrictions.eq(cList[i], sList[i]));
            }
        }
        if (sSearch != null && !sSearch.equals("")) {
            Disjunction disjunction = Restrictions.disjunction();
            for (String column : gscList) {
                disjunction.add(Restrictions.like(column, "%" + sSearch + "%", MatchMode.START));
            }
            criteria.add(disjunction);
        }
        criteria.setFirstResult(start);
        criteria.setMaxResults(length);
        List<?> dataList = (List<?>) criteria.list();
        dataModel.setEntities(dataList);
        criteria.setFirstResult(0);
        criteria.setMaxResults(1000000000);
        int total = ((Number) criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();
        dataModel.setTotalCount(total);
        return dataModel;
    }


    @Transactional
    public List<?> executeDataTablePortfolioObjectBuilder(Class<?> pojoClass) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(pojoClass).addOrder(Order.asc("portfolioMasterId"));
        ProjectionList projList = Projections.projectionList();
        projList.add(Projections.property("portfolioMasterId").as("portfolioMasterId"));
        projList.add(Projections.property("portfolioId").as("portfolioId"));

        criteria.setProjection(projList);
        criteria.setResultTransformer(Transformers.aliasToBean(PortfolioListModel.class));//To avoid duplicates.
        List<?> dataListObject = (List<?>) criteria.list();
        return dataListObject;
    }


    @Transactional
    public List<?> executeDataTableIOMObjectBuilder(Class<?> pojoClass) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(pojoClass).addOrder(Order.asc("id"));
        ProjectionList projList = Projections.projectionList();
        projList.add(Projections.property("id").as("id"));
        projList.add(Projections.property("iomNumber").as("iomNumber"));

        criteria.setProjection(projList);
        criteria.setResultTransformer(Transformers.aliasToBean(IOMListModel.class));//To avoid duplicates.
        List<?> dataListObject = (List<?>) criteria.list();
        return dataListObject;
    }

    @Override
    public TemplateGroupsFieldsChilds getTemplateGroupsFieldsChilds() {
        int pageSize = 1;
        int currPosition = 0;
        List<TemplateGroupsFieldsChilds> list = sessionFactory.getCurrentSession()
                .createSQLQuery("select * from template_groups_fields_childs order by id DESC").addScalar("id", IntegerType.INSTANCE)
                .addScalar("fieldcode", StringType.INSTANCE)
                .addScalar("code", StringType.INSTANCE)
                .addScalar("label", StringType.INSTANCE)
                .addScalar("createdby", StringType.INSTANCE)
                .addScalar("createdon", DateType.INSTANCE)
                .addScalar("updatedon", DateType.INSTANCE)
                .setResultTransformer(Transformers.aliasToBean(TemplateGroupsFieldsChilds.class)).setMaxResults(pageSize)
                .setFirstResult(currPosition).list();
        if (list.size() > 0)
            return list.get(0);
        else
            return null;
    }

    @Transactional
    public DataTableModel executeDataTableIOMObjectBuilder(Class<?> pojoClass, int start, int length, String sSearch, String sList[], String cList[], String gscList[]) {

        DataTableModel dataModel = new DataTableModel();
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(pojoClass).addOrder(Order.asc("id"));

        ProjectionList projList = Projections.projectionList();
        projList.add(Projections.property("id").as("id"));

        projList.add(Projections.sqlProjection("(select p.portfolioname from Portfoliomaster p where this_.buyerPortfolio=p.portfolioMasterId) as buyerPortfolio",
                new String[]{"buyerPortfolio"}, new Type[]{StandardBasicTypes.STRING}));
        //projList.add(Projections.sqlProjection("(select p.portfolioname from Portfoliomaster p where buyerportfolio=p.portfolioMasterId)").as("buyerportfolio"));

        projList.add(Projections.sqlProjection("(select p.portfolioname from Portfoliomaster p where this_.sellerPortfolio=p.portfolioMasterId) as sellerPortfolio",
                new String[]{"sellerPortfolio"}, new Type[]{StandardBasicTypes.STRING}));

        //	projList.add(Projections.property("sellerportfolio").as("sellerportfolio"));
        projList.add(Projections.sqlProjection("Date_Format(fromDate,'%d-%m-%Y') as fromDate",
                new String[]{"fromDate"}, new Type[]{StandardBasicTypes.STRING}));

        //projList.add(Projections.property("stratDate").as("stratDate"));
        projList.add(Projections.sqlProjection("Date_Format(toDate,'%d-%m-%Y') as toDate",
                new String[]{"toDate"}, new Type[]{StandardBasicTypes.STRING}));

        //projList.add(Projections.property("endDate").as("endDate"));


        projList.add(Projections.property("iomNumber").as("iomNumber"));
        projList.add(Projections.property("quantum").as("quantum"));
        projList.add(Projections.property("contractType").as("contractType"));


        criteria.setProjection(projList);
        criteria.setResultTransformer(Transformers.aliasToBean(Iommaster.class));//To avoid duplicates.


        for (int i = 0; i < sList.length; i++) {
            if (sList[i] != null && !sList[i].equals("")) {
                criteria.add(Restrictions.eq(cList[i], sList[i]));
            }
        }
        if (sSearch != null && !sSearch.equals("")) {
            Disjunction disjunction = Restrictions.disjunction();
            for (String column : gscList) {
                disjunction.add(Restrictions.like(column, "%" + sSearch + "%", MatchMode.START));
            }
            criteria.add(disjunction);
        }
        criteria.setFirstResult(start);
        criteria.setMaxResults(length);
        List<?> dataList = (List<?>) criteria.list();
        dataModel.setEntities(dataList);
        criteria.setFirstResult(0);
        criteria.setMaxResults(1000000000);
        int total = ((Number) criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();
        dataModel.setTotalCount(total);
        return dataModel;
    }

    public List<?> executePojoIomDetailsBuilder2(String cList[], String vList[]) {
        //Criteria criteria = sessionFactory.getCurrentSession().createCriteria(IomDetails.class).addOrder(Order.asc("id"));

        //	criteria.setResultTransformer(Transformers.aliasToBean(IomDetails.class));//To avoid duplicates.
        /*
         * for (int i = 0; i < cList.length; i++) { if (vList[i] != null &&
         * !vList[i].equals("")) {
         *
         * criteria.add(Restrictions.eq(cList[i], vList[i])); } }
         */
        List<?> dataListObject = (List<?>) sessionFactory.getCurrentSession().createQuery(" from IomDetails where id=" + vList[0]).list();
        //	List<?> dataListObject = (List<?>) criteria.list();

        System.out.println("dataListObject size " + dataListObject.size());
        return dataListObject;
    }

    public List<?> executePojoAgreementDetailsBuilder2(String cList[], String vList[]) {
        List<?> dataListObject = (List<?>) sessionFactory.getCurrentSession().createQuery(" from AgreementDetails where agreementMasterId=" + vList[0]).list();

        return dataListObject;
    }

    public List<?> executePojoAgreementTariffDetailsBuilder2(String cList[], String vList[]) {

        List<?> dataListObject = (List<?>) sessionFactory.getCurrentSession().createQuery(" from AgreementTariffDetails where agreementMasterId=" + vList[0]).list();

        return dataListObject;
    }

    public List<?> executePojoAgreementBuilder2(String cList[], String vList[]) {
        List<?> dataListObject = (List<?>) sessionFactory.getCurrentSession().createQuery(" from Agreementmaster where iomNumber=" + vList[0]).list();

        return dataListObject;
    }

    public List<?> executePojoSubAgreementsListBuilder(String cList[], String vList[]) {
        List<?> dataListObject = (List<?>) sessionFactory.getCurrentSession().createQuery(" from Agreementmaster where parent_agreementmaster_id=" + vList[0]).list();

        return dataListObject;
    }

    @Transactional
    public List<?> executeDataTableDiscomObjectBuilder(Class<?> pojoClass, String cList[], String vList[]) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(pojoClass).addOrder(Order.asc("discomName"));

        for (int i = 0; i < cList.length; i++) {
            if (vList[i] != null && !vList[i].equals("")) {
                Object val = applyAutoCasting(pojoClass, cList[i], vList[i]);
                criteria.add(Restrictions.eq(cList[i], val));
            }
        }
        ProjectionList projList = Projections.projectionList();
        projList.add(Projections.property("discomName").as("discomName"));
        //projList.add(Projections.property("discomName").as("discomName"));

        criteria.setProjection(projList);
        criteria.setResultTransformer(Transformers.aliasToBean(DiscomListModel.class));//To avoid duplicates.
        List<?> dataListObject = (List<?>) criteria.list();
        return dataListObject;
    }

    @Transactional
    public int executePojoSaveObject(Object object) {
        int primaryId = 0;
        try {
            primaryId = (int) sessionFactory.getCurrentSession().save(object);
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
        return primaryId;
    }


    //scheduling

    @Transactional
    public boolean executePojoUpdateObject(Object object) {
        boolean status = false;
        try {
            sessionFactory.getCurrentSession().update(object);
            status = true;
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
        return status;
    }

    @Transactional
    public boolean executePojoDeleteObjectBuilder1(Companyjobposts object) {
        boolean status = false;
        try {
            String deleteQuery = "delete from CompanyjobpostsDetails where companyjobpostid = '" + object.getId() + "'";
            Query query = sessionFactory.getCurrentSession().createQuery(deleteQuery);
            int result = query.executeUpdate();
            if (result > 0) {
                System.out.println("Expensive products was removed");
                sessionFactory.getCurrentSession().delete(object);
                status = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
        return status;
    }

    @Transactional
    public boolean executePojoDeleteObjectBuilder2(Companyjobposts object) {
        boolean status = false;
        try {
            String deleteQuery = "delete from CompanyjobpostsDetails where companyjobpostid = '" + object.getId() + "'";
            Query query = sessionFactory.getCurrentSession().createQuery(deleteQuery);
            int result = query.executeUpdate();
            if (result > 0) {
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
        return status;
    }

    public Object getCompanyjobpostByid(Class<?> pojoClass, String id) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(pojoClass);
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);// To avoid duplicates.
        Object val = applyAutoCasting(CompanyjobpostsDetails.class, "id", id);
        criteria.add(Restrictions.eq("id", val));
        Object pojoObject = (Object) criteria.uniqueResult();
        return pojoObject;
    }

    @Transactional
    public List<?> getAllCompany() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Company.class).addOrder(Order.asc("id"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);// To avoid duplicates.
        List<?> company = (List<Company>) criteria.list();
        return company;
    }

    @Transactional
    public Map<String, Object> executePojoObjectBuilder2sch(Class<?> pojoClass, String cList[], String vList[]) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(pojoClass).addOrder(Order.asc("id"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);// To avoid duplicates.
        for (int i = 0; i < cList.length; i++) {
            if (vList[i] != null && !vList[i].equals("")) {
                Object val = applyAutoCasting(pojoClass, cList[i], vList[i]);
                criteria.add(Restrictions.eq(cList[i], val));
                // criteria.add(Restrictions.eq(cList[i],
                // (cList[i].equals("id")?Integer.valueOf(vList[i]):vList[i])));
            }
        }
        Object comp = criteria.uniqueResult();
        ObjectMapper oMapper = new ObjectMapper();
        Map<String, Object> dataJobPosts = oMapper.convertValue(comp, Map.class);

        // SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date startDate = null;
        Date endDate = null;
        SimpleDateFormat outputFormat1 = new SimpleDateFormat("yyyy-MM-dd");

        try {
            startDate = outputFormat1.parse(dataJobPosts.get("job_post_start_date").toString());
            endDate = outputFormat1.parse(dataJobPosts.get("job_post_end_date").toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Long CompantId = Long.parseLong(dataJobPosts.get("com_name").toString());
        CompanyJobPostResponse companyJobPost = new CompanyJobPostResponse();
        Company company = (Company) sessionFactory.getCurrentSession().get(Company.class, CompantId);

        if (company != null) {
            companyJobPost.setCom_name(company.getName());
            dataJobPosts.put("com_name", company.getName());
        }
        companyJobPost.setId(Integer.parseInt(dataJobPosts.get("id").toString()));
        companyJobPost.setJob_post_end_date(outputFormat.format(startDate));
        companyJobPost.setJob_post_start_date(outputFormat.format(endDate));

        return dataJobPosts;
    }

    @Transactional
    public Object getjobPostDetails(List<Companyjobposts> jobPostDetails) {
        List<CompanyJobPost> jobPostList = new ArrayList<>();
        DataTableModelSch dataModel = new DataTableModelSch();
        for (Companyjobposts jobPost : jobPostDetails) {
            CompanyJobPost jobpostObject = new CompanyJobPost();
            jobpostObject.setStartDate(jobPost.getJob_post_start_date());
            jobpostObject.setEndDate(jobPost.getJob_post_end_date());
            jobpostObject.setId(jobPost.getId());
            Long CompantId = Long.valueOf(jobPost.getCom_name());
            Company company = (Company) sessionFactory.getCurrentSession().get(Company.class, CompantId);

            if (company != null) {
                jobpostObject.setCom_name(company.getName());
            }

            Criteria criteria = sessionFactory.getCurrentSession().createCriteria(CompanyjobpostsDetails.class)
                    .addOrder(Order.asc("id"));
            criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);// To avoid duplicates.

            Object val = applyAutoCasting(CompanyjobpostsDetails.class, "companyjobpostid", jobPost.getId().toString());
            criteria.add(Restrictions.eq("companyjobpostid", val));
            List<CompanyjobpostsDetails> list = (List<CompanyjobpostsDetails>) criteria.list();

            ObjectMapper oMapper = new ObjectMapper();
            Map<String, Object> mapObject = new HashMap<>();
            List<Map<String, Object>> dataList = new ArrayList<>();
            int flag = -1;
            for (CompanyjobpostsDetails obj : list) {

                String mapkey = "";
                String mapValue = "";
                if (flag != obj.getFlag()) {
                    flag = flag + 1;
                    if (flag != 0) {
                        dataList.add(new HashMap<>(mapObject));
                        mapObject.clear();
                    }
                    Map<String, Object> dataJobPosts = oMapper.convertValue(obj, Map.class);
                    Set set = dataJobPosts.entrySet();
                    for (Object objSet : set) {
                        Map.Entry<String, Object> m = (Map.Entry<String, Object>) objSet;

                        if (m.getKey().equals("jobPostkey")) {
                            mapkey = m.getValue().toString();
                        }
                        if (m.getKey().equals("jobPostvalue")) {
                            mapValue = m.getValue().toString();
                        }
                    }
                    // count = count + 1;
                    mapObject.put(mapkey, mapValue);
                } else {
                    Map<String, Object> dataJobPosts = oMapper.convertValue(obj, Map.class);
                    Set set = dataJobPosts.entrySet();
                    for (Object objSet : set) {
                        Map.Entry<String, Object> m = (Map.Entry<String, Object>) objSet;
                        if (m.getKey().equals("jobPostkey")) {
                            mapkey = m.getValue().toString();
                        }
                        if (m.getKey().equals("jobPostvalue")) {
                            mapValue = m.getValue().toString();
                        }
                    }
                    mapObject.put(mapkey, mapValue);
                }
            }
            dataList.add(mapObject);
            jobpostObject.setPojoClassList(dataList);
            jobPostList.add(jobpostObject);
        }

        dataModel.setPojoClassList(jobPostList);
        return dataModel;
    }

    public Object getjobPostDetailsFilter1(Class<?> pojoClass, String companyName, String salaryfrom, String salaryto,
                                           int start, int length, String[] sList,
                                           String[] cList, String[] fList) {
        DataTableModelSch dataModel = new DataTableModelSch();
        if (companyName != null) {
            Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Company.class).addOrder(Order.asc("id"));
            criteria.add(Restrictions.like("name", companyName, MatchMode.ANYWHERE));
            criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);// To avoid duplicates.
            List<Company> company = (List<Company>) criteria.list();
            List<Integer> companyIdList = new ArrayList<>();
            for (Company comp : company) {
                companyIdList.add(comp.getId().intValue());
            }

            Criteria criteria1 = sessionFactory.getCurrentSession().createCriteria(pojoClass).addOrder(Order.asc("id"));
            criteria1.add(Restrictions.in("com_name", companyIdList));
            criteria1.add(Restrictions.in("isactive", true));
            criteria1.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);// To avoid duplicates.
            criteria1.setFirstResult(start);
            criteria1.setMaxResults(length);
            List<Companyjobposts> jobPostDetails = (List<Companyjobposts>) criteria1.list();
            criteria1.setFirstResult(0);
            criteria1.setMaxResults(1000000000);
            int total = ((Number) criteria1.setProjection(Projections.rowCount()).uniqueResult()).intValue();
            dataModel.setTotal(total);
            Map<Integer, Set<Integer>> companyJobPostlist = jobpostList(salaryfrom, salaryto, start, length, sList, cList, fList);
            List<CompanyJobPost> dataList = dataForMainTable(jobPostDetails, companyJobPostlist);
            dataModel.setPojoClassList(dataList);

        } else {
            Criteria criteria1 = sessionFactory.getCurrentSession().createCriteria(pojoClass).addOrder(Order.asc("id"));
            criteria1.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);// To avoid duplicates.
            criteria1.setFirstResult(start);
            criteria1.setMaxResults(length);
            //List<Companyjobposts> dataList = (List<CompanyJobPost>) criteria1.list();
            List<Companyjobposts> jobPostDetails = (List<Companyjobposts>) criteria1.list();
            criteria1.setFirstResult(0);
            criteria1.setMaxResults(1000000000);
            int total = ((Number) criteria1.setProjection(Projections.rowCount()).uniqueResult()).intValue();
            dataModel.setTotal(total);
            Map<Integer, Set<Integer>> companyJobPostlist = jobpostList(salaryfrom, salaryto, start, length, sList, cList, fList);
            List<CompanyJobPost> dataList = dataForMainTable(jobPostDetails, companyJobPostlist);
            dataModel.setPojoClassList(dataList);

        }

        return dataModel;
    }

    /*
     * public Object getjobPostDetailsFilter(List<Companyjobposts>
     * jobPostDetails,int start, int length, String[] sList, String[] cList,
     * String[] fList) { List<CompanyJobPost> jobPostList = new ArrayList<>();
     * Set<Integer> companyJobPostlist = jobpostList(start, length, sList, cList,
     * fList );
     *
     * for (Companyjobposts jobPost : jobPostDetails) { for(Integer postId :
     * companyJobPostlist) { if(jobPost.getId() == postId) { CompanyJobPost
     * jobpostObject = new CompanyJobPost();
     * jobpostObject.setStartDate(jobPost.getJob_post_start_date());
     * jobpostObject.setEndDate(jobPost.getJob_post_end_date());
     *
     * Long CompantId = Long.valueOf(jobPost.getCom_name()); Company company =
     * (Company) sessionFactory.getCurrentSession().get(Company.class, CompantId);
     *
     * if (company != null) { jobpostObject.setCom_name(company.getName()); }
     * Criteria criteria =
     * sessionFactory.getCurrentSession().createCriteria(CompanyjobpostsDetails.
     * class) .addOrder(Order.asc("id"));
     * criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);// To avoid
     * duplicates. Object val = applyAutoCasting(CompanyjobpostsDetails.class,
     * "companyjobpostid", jobPost.getId().toString());
     * criteria.add(Restrictions.eq("companyjobpostid", val));
     * criteria.addOrder(Order.desc("createdon")); List<CompanyjobpostsDetails> list
     * = (List<CompanyjobpostsDetails>) criteria.list();
     *
     * ObjectMapper oMapper = new ObjectMapper(); Map<String, Object> mapObject =
     * new HashMap<>(); List<Map<String, Object>> dataList = new ArrayList<>(); int
     * flag = -1; for (CompanyjobpostsDetails obj : list) {
     *
     * String mapkey = ""; String mapValue = ""; if (flag != obj.getFlag()) { flag =
     * flag + 1; if (flag != 0) { dataList.add(new HashMap<>(mapObject));
     * mapObject.clear(); } Map<String, Object> dataJobPosts =
     * oMapper.convertValue(obj, Map.class); Set set = dataJobPosts.entrySet(); for
     * (Object objSet : set) { Map.Entry<String, Object> m = (Map.Entry<String,
     * Object>) objSet;
     *
     * if (m.getKey().equals("jobPostkey")) { mapkey = m.getValue().toString(); } if
     * (m.getKey().equals("jobPostvalue")) { mapValue = m.getValue().toString(); } }
     * // count = count + 1; mapObject.put(mapkey, mapValue); } else { Map<String,
     * Object> dataJobPosts = oMapper.convertValue(obj, Map.class); Set set =
     * dataJobPosts.entrySet(); for (Object objSet : set) { Map.Entry<String,
     * Object> m = (Map.Entry<String, Object>) objSet; if
     * (m.getKey().equals("jobPostkey")) { mapkey = m.getValue().toString(); } if
     * (m.getKey().equals("jobPostvalue")) { mapValue = m.getValue().toString(); } }
     * mapObject.put(mapkey, mapValue); } } dataList.add(mapObject);
     * jobpostObject.setPojoClassList(dataList); jobPostList.add(jobpostObject);
     *
     * } } }
     *
     * return jobPostList; }
     */

    public List<CompanyJobPost> dataForMainTable(List<Companyjobposts> jobPostDetails, Map<Integer, Set<Integer>> companyJobPostlist) {
        List<CompanyJobPost> jobPostList = new ArrayList<>();

        for (Companyjobposts jobPost : jobPostDetails) {
            Set setData = companyJobPostlist.entrySet();
            for (Object postId : setData) {
                Map.Entry<Integer, Set<Integer>> mapData = (Map.Entry<Integer, Set<Integer>>) postId;
                if (jobPost.getId() == mapData.getKey()) {
                    CompanyJobPost jobpostObject = new CompanyJobPost();
                    jobpostObject.setId(jobPost.getId());
                    jobpostObject.setStartDate(jobPost.getJob_post_start_date());
                    jobpostObject.setEndDate(jobPost.getJob_post_end_date());

                    Long CompantId = Long.valueOf(jobPost.getCom_name());
                    Company company = (Company) sessionFactory.getCurrentSession().get(Company.class, CompantId);

                    if (company != null) {
                        jobpostObject.setCom_name(company.getName());
                    }
                    Criteria criteria = sessionFactory.getCurrentSession().createCriteria(CompanyjobpostsDetails.class)
                            .addOrder(Order.asc("id"));
                    criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);// To avoid duplicates.
                    Object val = applyAutoCasting(CompanyjobpostsDetails.class, "companyjobpostid", jobPost.getId().toString());
                    criteria.add(Restrictions.eq("companyjobpostid", val));
                    criteria.add(Restrictions.in("flag", mapData.getValue()));
                    criteria.addOrder(Order.desc("createdon"));
                    List<CompanyjobpostsDetails> list = (List<CompanyjobpostsDetails>) criteria.list();

                    ObjectMapper oMapper = new ObjectMapper();
                    Map<String, Object> mapObject = new HashMap<>();
                    List<Map<String, Object>> dataList = new ArrayList<>();
                    int flag = -1;
                    int oldFlag = -1;
                    for (CompanyjobpostsDetails obj : list) {

                        String mapkey = "";
                        String mapValue = "";
                        if (flag != obj.getFlag()) {
                            flag = obj.getFlag();
                            if (oldFlag != -1 && oldFlag != flag) {
                                dataList.add(new HashMap<>(mapObject));
                                mapObject.clear();
                            }
                            oldFlag = flag;
                            Map<String, Object> dataJobPosts = oMapper.convertValue(obj, Map.class);
                            Set set = dataJobPosts.entrySet();
                            for (Object objSet : set) {
                                Map.Entry<String, Object> m = (Map.Entry<String, Object>) objSet;

                                if (m.getKey().equals("jobPostkey")) {
                                    mapkey = m.getValue().toString();
                                }
                                if (m.getKey().equals("jobPostvalue")) {
                                    mapValue = m.getValue().toString();
                                }
                            }
                            mapObject.put(mapkey, mapValue);
                        } else {
                            Map<String, Object> dataJobPosts = oMapper.convertValue(obj, Map.class);
                            Set set = dataJobPosts.entrySet();
                            for (Object objSet : set) {
                                Map.Entry<String, Object> m = (Map.Entry<String, Object>) objSet;
                                if (m.getKey().equals("jobPostkey")) {
                                    mapkey = m.getValue().toString();
                                }
                                if (m.getKey().equals("jobPostvalue")) {
                                    mapValue = m.getValue().toString();
                                }
                            }
                            mapObject.put(mapkey, mapValue);
                        }
                    }
                    dataList.add(mapObject);
                    jobpostObject.setPojoClassList(dataList);
                    jobPostList.add(jobpostObject);

                }
            }
        }
        return jobPostList;
    }

    public Map<Integer, Set<Integer>> jobpostList(String salaryfrom, String salaryto, int start, int length, String[] sList,
                                                  String[] cList, String[] fList) {
        Map<String, Class<?>> clazz = new HashMap<String, Class<?>>();
        for (String field : fList) {
            clazz.put(field.trim(), Object.class);
        }
        DataTableModel dataModel = new DataTableModel();
        String qry = "", qry2 = "";
        int c = 0;
        if (fList.length > 0) {
            for (int i = 0; i < fList.length; i++) {
                if (sList[i] != null && !sList[i].equals("")) {
                    if (c == 0) {
                        qry += " where  (jobPostkey ='" + fList[i] + "' AND jobPostvalue LIKE '" + sList[i] + "%') ";
                    } else {
                        qry += " OR (jobPostkey ='" + fList[i] + "' AND jobPostvalue LIKE '" + sList[i] + "%')";
                    }
                    c++;
                }
            }
        }

        if (c == 0 && (!salaryfrom.isEmpty())) {
            qry2 += "where (jobPostkey ='job_post_salary' AND jobPostvalue >= '" + salaryfrom + "')";
        } else if (c > 0) {
            qry2 += " OR ((jobPostkey ='job_post_salary' AND jobPostvalue >= '" + salaryfrom + "')";
        }

        if (c == 0 && (!salaryto.isEmpty())) {
            if (!salaryfrom.isEmpty()) {
                qry2 += "AND (jobPostkey ='job_post_salary' AND jobPostvalue <= '" + salaryto + "'))";
            } else {
                qry2 += "where (jobPostkey ='job_post_salary' AND jobPostvalue <= '" + salaryto + "')";
            }
        } else if (c > 0) {
            qry2 += " AND (jobPostkey ='job_post_salary' AND jobPostvalue <= '" + salaryto + "'))";
        }


        SQLQuery sqlQuery = sessionFactory.getCurrentSession()
                .createSQLQuery("select * from  companyjobpostsDetails " + qry + qry2);
        sqlQuery.addScalar("id", IntegerType.INSTANCE);
        for (int ind = 0; ind < cList.length; ind++) {
            sqlQuery.addScalar(cList[ind], StringType.INSTANCE);
        }

        List<Object> jobPostDetailslist = (List<Object>) sqlQuery.list();

        Set<Integer> companyJobPostId = new HashSet<>();
        Map<Integer, Set<Integer>> companyJobPostIdMap = new HashMap<>();


        Iterator it = jobPostDetailslist.iterator();
        while (it.hasNext()) {
            Object[] obj = (Object[]) it.next();
            Integer id = Integer.parseInt(obj[3].toString());
            Integer flagValue = Integer.parseInt(obj[4].toString());
            companyJobPostId.add(id);
            if (companyJobPostIdMap.containsKey(id)) {
                companyJobPostIdMap.get(id).add(flagValue);
            } else {
                Set<Integer> flagSet = new HashSet<>();
                flagSet.add(flagValue);
                companyJobPostIdMap.put(id, flagSet);
            }

        }

        return companyJobPostIdMap;
    }

    @Transactional
    public Object executePojoObjectBuilder2(Class<?> pojoClass, String companyId) {
        DataTableModel dataTableModel = new DataTableModel();
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(pojoClass).addOrder(Order.asc("id"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);// To avoid duplicates.

        Object val = applyAutoCasting(pojoClass, "com_name", companyId);
        criteria.add(Restrictions.eq("com_name", val));
        // criteria.add(Restrictions.eq(cList[i],
        // (cList[i].equals("id")?Integer.valueOf(vList[i]):vList[i])));
        //dataTableModel.setTotal(criteria.list().size());
        //dataTableModel.setPojoClassList(criteria.list());
        return criteria.list();
    }

    @Transactional
    public CompanyJobAds getCompanyJobAds(Class<?> pojoClass, String companyId, String templateId) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(pojoClass).addOrder(Order.asc("id"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);// To avoid duplicates.

        Object valCompanyId = applyAutoCasting(pojoClass, "companyId", companyId);
        criteria.add(Restrictions.eq("companyId", valCompanyId));
        Object valJobAdsTemplateId = applyAutoCasting(pojoClass, "jobAdsTemplateId", templateId);
        criteria.add(Restrictions.eq("jobAdsTemplateId", valJobAdsTemplateId));
        CompanyJobAds companyJobAds = (CompanyJobAds) criteria.uniqueResult();
        return companyJobAds;
    }

    @Transactional
    public List<JobAdsAndJobPostMapping> getCompanyjobadsAndJoBPost(Class<?> pojoClass) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(pojoClass).addOrder(Order.asc("id"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);// To avoid duplicates.
        List<JobAdsAndJobPostMapping> companyJobAds = (List<JobAdsAndJobPostMapping>) criteria.list();
        return companyJobAds;
    }

    @Transactional
    public List<CompanyJobAdsResponse> getCompanyjobadsByFilter(Class<?> pojoClass, List<Integer> jobpostIdList) {

        String IdList = "";
        Integer[] IdArray = new Integer[jobpostIdList.size()];
        jobpostIdList.toArray(IdArray);
        for (int i = 0; i < IdArray.length; i++) {
            if (i < (IdArray.length - 1)) {
                IdList = IdList + IdArray[i].toString() + ",";
            } else if (i == (IdArray.length - 1)) {
                IdList = IdList + IdArray[i].toString();
            }
        }
        SQLQuery sqlQuery = sessionFactory.getCurrentSession().createSQLQuery("select * from jobAdsAndJobPostMapping where jobpost_id "
                + "IN(" + IdList + ") GROUP BY jobads_id");
        List<Object> dataListObj = (List<Object>) sqlQuery.list();
        //List<JobAdsAndJobPostMapping> dataList = (List<JobAdsAndJobPostMapping>) dataListObj;

        List<CompanyJobAdsResponse> companyJobAdsList = new ArrayList<>();
        if (dataListObj != null) {
            Iterator it = dataListObj.iterator();
            while (it.hasNext()) {
                Object[] obj = (Object[]) it.next();
                Integer jobadsId = Integer.parseInt(obj[1].toString());
                Criteria criteria = sessionFactory.getCurrentSession().createCriteria(pojoClass).addOrder(Order.asc("id"));
                criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
                Object valCompanyId = applyAutoCasting(pojoClass, "id", jobadsId.toString());
                criteria.add(Restrictions.eq("id", valCompanyId));
                CompanyJobAds companyJobAds = (CompanyJobAds) criteria.uniqueResult();
                CompanyJobAdsResponse companyJobAdsResponse = new CompanyJobAdsResponse();
                BeanUtils.copyProperties(companyJobAds, companyJobAdsResponse);
                Company company = (Company) sessionFactory.getCurrentSession().get(Company.class, Long.valueOf(companyJobAds.getCompanyId()));
                if (company != null) {
                    companyJobAdsResponse.setCompanyName(company.getName());
                }
                companyJobAdsList.add(companyJobAdsResponse);

            }
        }
        return companyJobAdsList;
    }

    @Transactional
    public CompanyJobAds getCompanyJobAdsById(Class<?> pojoClass, String id) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(pojoClass).addOrder(Order.asc("id"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);// To avoid duplicates.
        Object valCompanyId = applyAutoCasting(pojoClass, "id", id);
        criteria.add(Restrictions.eq("id", valCompanyId));
        CompanyJobAds companyJobAds = (CompanyJobAds) criteria.uniqueResult();
        return companyJobAds;
    }

    @Transactional
    public List<Companyjobposts> getjobpostIdByCompanyId(Class<?> pojoClass, String companyId) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(pojoClass).addOrder(Order.asc("id"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);// To avoid duplicates.
        Object valCompanyId = applyAutoCasting(pojoClass, "com_name", companyId);
        criteria.add(Restrictions.eq("com_name", valCompanyId));
        List<Companyjobposts> companyJobPost = criteria.list();
        return companyJobPost;
    }

    @Transactional
    public Object getCompanyJobAdsByCompanyId(Class<?> pojoClass, String comapanyId, String templateId) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(pojoClass).addOrder(Order.asc("id"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);// To avoid duplicates.
        Object valCompanyId = applyAutoCasting(pojoClass, "companyId", comapanyId);
        criteria.add(Restrictions.eq("companyId", valCompanyId));
        Object valTemplateId = applyAutoCasting(pojoClass, "jobAdsTemplateId", templateId);
        criteria.add(Restrictions.eq("jobAdsTemplateId", valTemplateId));
        Object pojoObject = (Object) criteria.uniqueResult();
        return pojoObject;
    }

    @Transactional
    public List<?> getCompanyJobAds(Class<?> pojoClass) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(pojoClass).addOrder(Order.asc("id"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);// To avoid duplicates.
        List<CompanyJobAds> pojoObject = (List<CompanyJobAds>) criteria.list();
        List<CompanyJobAdsResponse> jobAdsList = new ArrayList<>();
        for (CompanyJobAds jobAds : pojoObject) {
            CompanyJobAdsResponse companyJobAdsResponse = new CompanyJobAdsResponse();
            BeanUtils.copyProperties(jobAds, companyJobAdsResponse);
            Company company = (Company) sessionFactory.getCurrentSession().get(Company.class, Long.valueOf(jobAds.getCompanyId()));
            if (company != null) {
                companyJobAdsResponse.setCompanyName(company.getName());
            }
            jobAdsList.add(companyJobAdsResponse);
        }
        return jobAdsList;
    }

    @Transactional
    public CompanyJobAdsResponse getCompanyjobadsById(Class<?> pojoClass, String id) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(pojoClass).addOrder(Order.asc("id"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);// To avoid duplicates.
        Object valCompanyId = applyAutoCasting(pojoClass, "id", id);
        criteria.add(Restrictions.eq("id", valCompanyId));
        CompanyJobAds companyJobAds = (CompanyJobAds) criteria.uniqueResult();

        CompanyJobAdsResponse companyJobAdsResponse = new CompanyJobAdsResponse();
        BeanUtils.copyProperties(companyJobAds, companyJobAdsResponse);
        Company company = (Company) sessionFactory.getCurrentSession().get(Company.class, Long.valueOf(companyJobAds.getCompanyId()));
        if (company != null) {
            companyJobAdsResponse.setCompanyName(company.getName());
        }
        return companyJobAdsResponse;
    }

    @Transactional
    public Object executePojoObjectCompany(Class<?> pojoClass, String companyId) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(pojoClass).addOrder(Order.asc("id"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);// To avoid duplicates.
        Object val = applyAutoCasting(pojoClass, "id", companyId);
        criteria.add(Restrictions.eq("id", val));
        Object pojoObject = (Object) criteria.uniqueResult();
        return criteria.list();
    }

    @Transactional
    public Object executePojoObjectBuilderForCandidate(Class<?> pojoClass, int start, int length, String companyName) {
        DataTableModel dataModel = new DataTableModel();
        if (companyName != null) {
            Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Company.class).addOrder(Order.asc("id"));
            criteria.add(Restrictions.like("name", companyName, MatchMode.ANYWHERE));
            criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);// To avoid duplicates.
            List<Company> company = (List<Company>) criteria.list();
            List<Integer> companyIdList = new ArrayList<>();
            for (Company comp : company) {
                companyIdList.add(comp.getId().intValue());
            }

            Criteria criteria1 = sessionFactory.getCurrentSession().createCriteria(pojoClass).addOrder(Order.asc("id"));
            criteria1.add(Restrictions.in("com_name", companyIdList));
            criteria1.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);// To avoid duplicates.
            return criteria1.list();
        } else {
            Criteria criteria1 = sessionFactory.getCurrentSession().createCriteria(pojoClass).addOrder(Order.asc("id"));
            criteria1.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);// To avoid duplicates.
            return criteria1.list();
        }
    }

    @Transactional
    public Object executePojoObjectBuilder3(Class<?> pojoClass, String cList[], String vList[]) {
        DataTableModel dataModel = new DataTableModel();
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(pojoClass).addOrder(Order.asc("id"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);// To avoid duplicates.
        for (int i = 0; i < cList.length; i++) {
            if (vList[i] != null && !vList[i].equals("")) {
                Object val = applyAutoCasting(pojoClass, cList[i], vList[i]);
                criteria.add(Restrictions.eq(cList[i], val));
            }
        }
        List<CompanyjobpostsDetails> list = (List<CompanyjobpostsDetails>) criteria.list();
        ObjectMapper oMapper = new ObjectMapper();
        Map<String, Object> mapObject = new HashMap<>();
        List<Map<String, Object>> dataList = new ArrayList<>();
        int flag = -1;
        for (CompanyjobpostsDetails obj : list) {

            String mapkey = "";
            String mapValue = "";
            if (flag != obj.getFlag()) {
                flag = flag + 1;
                if (flag != 0) {
                    dataList.add(new HashMap<>(mapObject));
                    mapObject.clear();
                }
                Map<String, Object> dataJobPosts = oMapper.convertValue(obj, Map.class);
                Set set = dataJobPosts.entrySet();
                for (Object objSet : set) {
                    Map.Entry<String, Object> m = (Map.Entry<String, Object>) objSet;

                    if (m.getKey().equals("jobPostkey")) {
                        mapkey = m.getValue().toString();
                    }
                    if (m.getKey().equals("jobPostvalue")) {
                        mapValue = m.getValue().toString();
                    }
                }
                // count = count + 1;
                mapObject.put(mapkey, mapValue);
            } else {
                Map<String, Object> dataJobPosts = oMapper.convertValue(obj, Map.class);
                Set set = dataJobPosts.entrySet();
                for (Object objSet : set) {
                    Map.Entry<String, Object> m = (Map.Entry<String, Object>) objSet;
                    if (m.getKey().equals("jobPostkey")) {
                        mapkey = m.getValue().toString();
                    }
                    if (m.getKey().equals("jobPostvalue")) {
                        mapValue = m.getValue().toString();
                    }
                }
                mapObject.put(mapkey, mapValue);
            }
        }
        dataList.add(mapObject);
        return dataList;
    }

    // pojo datalist with start and end globalsearch and specific search for
    // datatables
    @Transactional
    public DataTableModelSch executeDataTableObjectBuildersch(Class<?> pojoClass, int start, int length, String sSearch,
                                                              String sList[], String cList[], String gscList[]) {

        DataTableModelSch dataModel = new DataTableModelSch();
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(pojoClass).addOrder(Order.asc("id"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);// To avoid duplicates.
        for (int i = 0; i < sList.length; i++) {
            if (sList[i] != null && !sList[i].equals("")) {
                criteria.add(Restrictions.eq(cList[i], sList[i]));
            }
        }
        if (sSearch != null && !sSearch.equals("")) {
            Disjunction disjunction = Restrictions.disjunction();
            for (String column : gscList) {
                disjunction.add(Restrictions.like(column, "%" + sSearch + "%", MatchMode.START));
            }
            criteria.add(disjunction);
        }
        criteria.setFirstResult(start);
        criteria.setMaxResults(length);
        List<?> dataList = (List<?>) criteria.list();
        dataModel.setPojoClassList(dataList);
        criteria.setFirstResult(0);
        criteria.setMaxResults(1000000000);
        int total = ((Number) criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();
        dataModel.setTotal(total);
        return dataModel;
    }

    @Override
    public DataTableModelSch executeDataTableObject(String pojoClass, int start, int length, String sSearch,
                                                    String sList[], String cList[], String fList[]) throws Exception {
        Map<String, Class<?>> clazz = new HashMap<String, Class<?>>();
        DataTableModelSch dataModel = new DataTableModelSch();
        SQLQuery sqlQuery = sessionFactory.getCurrentSession().createSQLQuery("select * from " + pojoClass);

        sqlQuery.setResultTransformer(Transformers.aliasToBean(clazz.getClass())).setMaxResults(length)
                .setFirstResult(start);

        List<?> dataList = sqlQuery.list();
        dataModel.setPojoClassList(dataList);
        sqlQuery.setMaxResults(1000000000).setFirstResult(0).list();
        int total = ((Number) sqlQuery.list().size()).intValue();
        dataModel.setTotal(total);
        return dataModel;
    }

    // pojo datalist with start and end globalsearch and specific search for
    // datatables
    @Transactional
    public DataTableModelSch executeDataTableObjectBuilderJSONsch(String pojoClass, int start, int length, String sSearch,
                                                                  String sList[], String cList[], String fList[]) throws Exception {

        for (int ind = 0; ind < fList.length; ind++) {
            if (fList[ind].equalsIgnoreCase("Status")) {
                fList[ind] = "isactive";
            }
        }
        // CtClass clazz = new DynamicModel().generatePojo(fList);
        Map<String, Class<?>> clazz = new HashMap<String, Class<?>>();
        // props.put("foo", Integer.class);
        for (String field : fList) {
            clazz.put(field.trim(), Object.class);
        }
        DataTableModelSch dataModel = new DataTableModelSch();
        int c = 0;
        String qry = "", qry2 = "";
        if (sSearch == null)
            sSearch = "";
        if (sSearch.trim().equals("")) {
            qry2 += "";
        } else {
            qry2 += " JSON_SEARCH(a.data, 'all', '%" + sSearch + "%') IS NOT NULL ";
        }
        for (int i = 0; i < sList.length; i++) {
            if (sList[i] != null && !sList[i].equals("")) {
                if (c == 0) {
                    qry += " where JSON_EXTRACT(a.data, '$." + cList[i] + "') ='" + sList[i] + "' ";
                } else {
                    qry += " and JSON_EXTRACT(a.data, '$." + cList[i] + "') ='" + sList[i] + "' ";
                }
                c++;
            }
        }
        // a.data->'$.name'='';
        // System.out.println("query is::"+qry);
        if (qry.equals("")) {
            if (qry2.equals("")) {

            } else {
                qry += " where ";
            }
        } else {
            if (qry2.equals("")) {

            } else {
                qry += " and ";
            }
        }

        String extractFields = "";
        for (int ind = 0; ind < fList.length; ind++) {
            if (ind == 0) {
                extractFields += " " + fList[ind] + " ";
            } else {
                extractFields += ", " + fList[ind] + " ";
            }
        }
        // select JSON_OBJECT('col1',col1,'col2',col2) from contactjobships;
        SQLQuery sqlQuery = sessionFactory.getCurrentSession()
                .createSQLQuery("select id as id, " + extractFields + " from " + pojoClass + " a " + qry + qry2 + " ");
        sqlQuery.addScalar("id", IntegerType.INSTANCE);

        for (int ind = 0; ind < fList.length; ind++) {
            sqlQuery.addScalar(fList[ind], StringType.INSTANCE);
        }

        sqlQuery.setResultTransformer(Transformers.aliasToBean(clazz.getClass())).setMaxResults(length)
                .setFirstResult(start);

        List<?> dataList = sqlQuery.list();
        List<CompanyJobPostResponse> pojoClassList = new ArrayList<>();

        for (Object comp : dataList) {

            ObjectMapper oMapper = new ObjectMapper();
            Map<String, Object> dataJobPosts = oMapper.convertValue(comp, Map.class);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date startDate = outputFormat.parse(dataJobPosts.get("job_post_start_date").toString());
            Date endDate = outputFormat.parse(dataJobPosts.get("job_post_end_date").toString());
            Date createdOnDate = outputFormat.parse(dataJobPosts.get("createdon").toString());

            Long CompantId = Long.parseLong(dataJobPosts.get("com_name").toString());
            CompanyJobPostResponse companyJobPostList = new CompanyJobPostResponse();
            Company company = (Company) sessionFactory.getCurrentSession().get(Company.class, CompantId);

            if (company != null) {
                companyJobPostList.setCom_name(company.getName());
            }
            companyJobPostList.setId(Integer.parseInt(dataJobPosts.get("id").toString()));
            companyJobPostList.setJob_post_end_date(dateFormat.format(startDate));
            companyJobPostList.setJob_post_start_date(dateFormat.format(endDate));
            companyJobPostList.setCreatedon(dateFormat.format(createdOnDate));
            companyJobPostList.setCreatedby(dataJobPosts.get("createdby").toString());
            if (dataJobPosts.get("isactive").toString().equalsIgnoreCase("1")) {
                companyJobPostList.setStatus("Active");
            } else {
                companyJobPostList.setStatus("InActive");
            }

            pojoClassList.add(companyJobPostList);
        }
        dataModel.setPojoClassList(pojoClassList);

        sqlQuery.setMaxResults(1000000000).setFirstResult(0).list();
        int total = ((Number) sqlQuery.list().size()).intValue();
        dataModel.setTotal(total);
        return dataModel;
    }

    public DataTableModelSch executeDataTableObjectBuilderJSON2(String pojoClass, int start, int length, String sSearch,
                                                                String sList[], String cList[], String fList[], String subFList[], String companyName, String status, String startDate, String endDate) throws Exception {

        for (int ind = 0; ind < fList.length; ind++) {
            if (fList[ind].equalsIgnoreCase("Status")) {
                fList[ind] = "isactive";
            }
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat inputFormat = new SimpleDateFormat(
                "E MMM dd yyyy HH:mm:ss");
        String fromDate = null;
        String toDate = null;

        if (startDate != null && !startDate.isEmpty()) {
            String[] startDates = startDate.split("GMT");
            Date fDate = inputFormat.parse(startDates[0]);
            fromDate = outputFormat.format(fDate);
        }

        if (endDate != null && !endDate.isEmpty()) {
            String[] endDates = endDate.split("GMT");
            Date fDate = inputFormat.parse(endDates[0]);
            toDate = outputFormat.format(fDate);
        }

        Map<String, Class<?>> clazz = new HashMap<String, Class<?>>();
        for (String field : fList) {
            clazz.put(field.trim(), Object.class);
        }
        DataTableModelSch dataModel = new DataTableModelSch();
        int c = 0;
        String qry = "", qry2 = "", qry3 = "";
        if (sSearch == null)
            sSearch = "";
        if (sSearch.trim().equals("")) {
            qry2 += "";
        } else {
            qry2 += " JSON_SEARCH(a.data, 'all', '%" + sSearch + "%') IS NOT NULL ";
        }

        if (subFList.length > 0) {
            for (int i = 0; i < subFList.length; i++) {
                if (sList[i] != null && !sList[i].equals("")) {
                    if (c == 0) {
                        if (companyName != null || !companyName.isEmpty()) {
                            qry += " , companyjobpostsdetails cd, company com where  ((cd.jobPostkey ='" + subFList[i] + "' AND cd.jobPostvalue LIKE '" + sList[i] + "%') ";
                        } else {
                            qry += " , companyjobpostsdetails cd where  ((cd.jobPostkey ='" + subFList[i] + "' AND cd.jobPostvalue LIKE '" + sList[i] + "%')";
                        }
                    } else {
                        qry += " OR (cd.jobPostkey ='" + subFList[i] + "' AND cd.jobPostvalue LIKE '" + sList[i] + "%')";
                    }
                    c++;
                }
            }
            if ((companyName != null || !companyName.isEmpty()) && c > 0) {
                qry += ") AND com.name LIKE '" + companyName + "%' AND com.id=a.com_name";
            } else if (c > 0) {
                qry += ")";
            }

        }

        if ((companyName != null || !companyName.isEmpty()) && c == 0) {
            qry3 += ", company com where com.name LIKE '" + companyName + "%' AND com.id=a.com_name";
        }

        if (status != null && !status.isEmpty()) {
            if (companyName != null || !companyName.isEmpty()) {
                if (c > 0) {
                    if (status.equalsIgnoreCase("Active")) {
                        qry3 += " AND a.isactive = 1";
                    } else {
                        qry3 += " AND a.isactive = 0";
                    }
                } else {
                    if (status.equalsIgnoreCase("Active")) {
                        qry3 += " AND a.isactive = 1";
                    } else {
                        qry3 += " AND a.isactive = 0";
                    }
                }
            } else {
                if (c > 0) {
                    if (status.equalsIgnoreCase("Active")) {
                        qry3 += " AND a.isactive = 1";
                    } else {
                        qry3 += " AND a.isactive = 0";
                    }
                } else {
                    if (status.equalsIgnoreCase("Active")) {
                        qry3 += " where a.isactive = 1";
                    } else {
                        qry3 += " where a.isactive = 0";
                    }
                }
            }
        }

        if (fromDate != null) {
            if (c > 0 || (companyName != null || !companyName.isEmpty()) || (status != null && !status.isEmpty())) {
                qry3 += " AND a.createdon >= " + fromDate;
            } else {
                qry3 += " where a.createdon >= " + fromDate;
            }
        }


        if (toDate != null) {
            if (c > 0 || (companyName != null || !companyName.isEmpty()) || (fromDate != null)
                    || (status != null && !status.isEmpty())) {
                qry3 += " AND a.createdon <= '" + toDate + "'";
            } else {
                qry3 += " where a.createdon <= '" + toDate + "'";
            }
        }

        String extractFields = "";
        for (int ind = 0; ind < fList.length; ind++) {
            if (ind == 0) {
                extractFields += " a." + fList[ind] + " ";
            } else {
                extractFields += ", a." + fList[ind] + " ";
            }
        }
        SQLQuery sqlQuery = sessionFactory.getCurrentSession()
                .createSQLQuery("select DISTINCT(a.id) as id, " + extractFields + " from " + pojoClass + " a " + qry + qry2 + qry3 + " ");
        sqlQuery.addScalar("id", IntegerType.INSTANCE);

        for (int ind = 0; ind < fList.length; ind++) {
            sqlQuery.addScalar(fList[ind], StringType.INSTANCE);
        }

        sqlQuery.setResultTransformer(Transformers.aliasToBean(clazz.getClass())).setMaxResults(length)
                .setFirstResult(start);

        List<?> dataList = sqlQuery.list();
        List<CompanyJobPostResponse> pojoClassList = new ArrayList<>();

        for (Object comp : dataList) {

            ObjectMapper oMapper = new ObjectMapper();
            Map<String, Object> dataJobPosts = oMapper.convertValue(comp, Map.class);
            SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd-MM-yyyy");
            SimpleDateFormat outputFormat1 = new SimpleDateFormat("yyyy-MM-dd");
            Date sstartDate = outputFormat1.parse(dataJobPosts.get("job_post_start_date").toString());
            Date eendDate = outputFormat1.parse(dataJobPosts.get("job_post_end_date").toString());
            Date createdOnDate = outputFormat1.parse(dataJobPosts.get("createdon").toString());

            Long CompantId = Long.parseLong(dataJobPosts.get("com_name").toString());
            CompanyJobPostResponse companyJobPostList = new CompanyJobPostResponse();
            Company company = (Company) sessionFactory.getCurrentSession().get(Company.class, CompantId);

            if (company != null) {
                companyJobPostList.setCom_name(company.getName());
            }
            companyJobPostList.setId(Integer.parseInt(dataJobPosts.get("id").toString()));
            companyJobPostList.setJob_post_end_date(dateFormat1.format(sstartDate));
            companyJobPostList.setJob_post_start_date(dateFormat1.format(eendDate));
            companyJobPostList.setCreatedon(dateFormat1.format(createdOnDate));
            companyJobPostList.setCreatedby(dataJobPosts.get("createdby").toString());
            if (dataJobPosts.get("isactive").toString().equalsIgnoreCase("1")) {
                companyJobPostList.setStatus("Active");
            } else {
                companyJobPostList.setStatus("InActive");
            }

            pojoClassList.add(companyJobPostList);
        }
        dataModel.setPojoClassList(pojoClassList);

        sqlQuery.setMaxResults(1000000000).setFirstResult(0).list();
        int total = ((Number) sqlQuery.list().size()).intValue();
        dataModel.setTotal(total);
        return dataModel;
    }

    public DataTableModelSch executeDataTableObjectBuilderJSON3(String pojoClass, int start, int length, int companyId, String sSearch,
                                                                String sList[], String cList[], String fList[], String subFList[], String status, String startDate, String endDate) throws Exception {

        for (int ind = 0; ind < fList.length; ind++) {
            if (fList[ind].equalsIgnoreCase("Status")) {
                fList[ind] = "isactive";
            }
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat inputFormat = new SimpleDateFormat(
                "E MMM dd yyyy HH:mm:ss");
        String fromDate = null;
        String toDate = null;

        if (startDate != null && !startDate.isEmpty()) {
            String[] startDates = startDate.split("GMT");
            Date fDate = inputFormat.parse(startDates[0]);
            fromDate = outputFormat.format(fDate);
        }

        if (endDate != null && !endDate.isEmpty()) {
            String[] endDates = endDate.split("GMT");
            Date fDate = inputFormat.parse(endDates[0]);
            toDate = outputFormat.format(fDate);
        }

        Map<String, Class<?>> clazz = new HashMap<String, Class<?>>();
        for (String field : fList) {
            clazz.put(field.trim(), Object.class);
        }
        DataTableModelSch dataModel = new DataTableModelSch();
        int c = 0;
        String qry = "", qry2 = "", qry3 = "";
        if (sSearch == null)
            sSearch = "";
        if (sSearch.trim().equals("")) {
            qry2 += "";
        } else {
            qry2 += " JSON_SEARCH(a.data, 'all', '%" + sSearch + "%') IS NOT NULL ";
        }

        if (subFList.length > 0) {
            for (int i = 0; i < subFList.length; i++) {
                if (sList[i] != null && !sList[i].equals("")) {
                    if (c == 0) {
                        qry += " , companyjobpostsdetails cd where  ((cd.jobPostkey ='" + subFList[i] + "' AND cd.jobPostvalue LIKE '" + sList[i] + "%')";
                    } else {
                        qry += " OR (cd.jobPostkey ='" + subFList[i] + "' AND cd.jobPostvalue LIKE '" + sList[i] + "%'))";
                    }
                    c++;
                }
            }

        }

        if (status != null && !status.isEmpty()) {
            if (c > 0) {
                if (status.equalsIgnoreCase("Active")) {
                    qry3 += " AND a.isactive = 1";
                } else {
                    qry3 += " AND a.isactive = 0";
                }
            } else {
                if (status.equalsIgnoreCase("Active")) {
                    qry3 += " where a.isactive = 1";
                } else {
                    qry3 += " where a.isactive = 0";
                }
            }
        }

        if (fromDate != null) {
            if (c > 0 || (status != null && !status.isEmpty())) {
                qry3 += " AND a.createdon >= " + fromDate;
            } else {
                qry3 += " where a.createdon >= " + fromDate;
            }
        }


        if (toDate != null) {
            if (c > 0 || (fromDate != null)
                    || (status != null && !status.isEmpty())) {
                qry3 += " AND a.createdon <= '" + toDate + "'";
            } else {
                qry3 += " where a.createdon <= '" + toDate + "'";
            }
        }

        String extractFields = "";
        for (int ind = 0; ind < fList.length; ind++) {
            if (ind == 0) {
                extractFields += " a." + fList[ind] + " ";
            } else {
                extractFields += ", a." + fList[ind] + " ";
            }
        }

        SQLQuery sqlQuery = null;
        if (qry.isEmpty() && qry2.isEmpty() && qry3.isEmpty()) {
            sqlQuery = sessionFactory.getCurrentSession()
                    .createSQLQuery("select DISTINCT(a.id) as id, " + extractFields + " from " + pojoClass + " a where com_name=" + companyId);

        } else {
            sqlQuery = sessionFactory.getCurrentSession()
                    .createSQLQuery("select DISTINCT(a.id) as id, " + extractFields + " from " + pojoClass + " a " + qry + qry2 + qry3 + " com_name=" + companyId);

        }

        sqlQuery.addScalar("id", IntegerType.INSTANCE);

        for (int ind = 0; ind < fList.length; ind++) {
            sqlQuery.addScalar(fList[ind], StringType.INSTANCE);
        }

        sqlQuery.setResultTransformer(Transformers.aliasToBean(clazz.getClass())).setMaxResults(length)
                .setFirstResult(start);

        List<?> dataList = sqlQuery.list();
        List<CompanyJobPostResponse> pojoClassList = new ArrayList<>();

        for (Object comp : dataList) {

            ObjectMapper oMapper = new ObjectMapper();
            Map<String, Object> dataJobPosts = oMapper.convertValue(comp, Map.class);
            SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd-MM-yyyy");
            SimpleDateFormat outputFormat1 = new SimpleDateFormat("yyyy-MM-dd");
            Date sstartDate = outputFormat1.parse(dataJobPosts.get("job_post_start_date").toString());
            Date eendDate = outputFormat1.parse(dataJobPosts.get("job_post_end_date").toString());
            Date createdOnDate = outputFormat1.parse(dataJobPosts.get("createdon").toString());

            Long CompantId = Long.parseLong(dataJobPosts.get("com_name").toString());
            CompanyJobPostResponse companyJobPostList = new CompanyJobPostResponse();
            Company company = (Company) sessionFactory.getCurrentSession().get(Company.class, CompantId);

            if (company != null) {
                companyJobPostList.setCom_name(company.getName());
            }
            companyJobPostList.setId(Integer.parseInt(dataJobPosts.get("id").toString()));
            companyJobPostList.setJob_post_end_date(dateFormat1.format(sstartDate));
            companyJobPostList.setJob_post_start_date(dateFormat1.format(eendDate));
            companyJobPostList.setCreatedon(dateFormat1.format(createdOnDate));
            companyJobPostList.setCreatedby(dataJobPosts.get("createdby").toString());
            if (dataJobPosts.get("isactive").toString().equalsIgnoreCase("1")) {
                companyJobPostList.setStatus("Active");
            } else {
                companyJobPostList.setStatus("InActive");
            }

            pojoClassList.add(companyJobPostList);
        }
        dataModel.setPojoClassList(pojoClassList);

        sqlQuery.setMaxResults(1000000000).setFirstResult(0).list();
        int total = ((Number) sqlQuery.list().size()).intValue();
        dataModel.setTotal(total);
        return dataModel;
    }

    @Override
    public Object getCompanyjobpostsByIds(Class<?> pojoClass, List<Integer> jobpostIds) {
        if (jobpostIds.size() > 0) {
            Criteria criteria = sessionFactory.getCurrentSession().createCriteria(pojoClass).addOrder(Order.asc("id"));
            criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);// To avoid duplicates.
            //Object val = applyAutoCasting(pojoClass, "id", companyId);
            criteria.add(Restrictions.in("id", jobpostIds));
            return criteria.list();
        } else {
            return null;
        }
    }

    @Override
    public boolean saveProductList(ProductMaster entity) {
        if (entity.getId() == 0) {
            entity.setCreatedon(getTimeStampDate());
            return executePojoSaveObjectBuilder(entity);
        } else {
            entity.setUpdatedon(getTimeStampDate());
            return executePojoUpdateObjectBuilder(entity);
        }
    }

    @Override
    public boolean saveProductBanner(ProductBanner entity) {
        if (entity.getId() == 0) {
            entity.setCreatedon(getTimeStampDate());
            return executePojoSaveObjectBuilder(entity);
        } else {
            entity.setUpdatedon(getTimeStampDate());
            return executePojoUpdateObjectBuilder(entity);
        }
    }

    @Override
    public boolean saveProductFetauredUser(ProductFeaturedUser entity) {
        if (entity.getId() == 0) {
            entity.setCreatedon(getTimeStampDate());
            return executePojoSaveObjectBuilder(entity);
        } else {
            entity.setUpdatedon(getTimeStampDate());
            return executePojoUpdateObjectBuilder(entity);
        }
    }

    @Override
    public boolean saveProductMixedService(ProductMixedServices entity) {
        if (entity.getId() == 0) {
            entity.setCreatedon(getTimeStampDate());
            return executePojoSaveObjectBuilder(entity);
        } else {
            entity.setUpdatedon(getTimeStampDate());
            return executePojoUpdateObjectBuilder(entity);
        }
    }

    @Override
    public boolean saveProductAccessList(ProductAccessList entity) {
        if (entity.getId() == 0) {
            entity.setCreatedon(getTimeStampDate());
            return executePojoSaveObjectBuilder(entity);
        } else {
            entity.setUpdatedon(getTimeStampDate());
            return executePojoUpdateObjectBuilder(entity);
        }
    }

    java.sql.Timestamp getTimeStampDate() {
        Date saveDate = new Date();
        java.sql.Timestamp timeStampDate = new Timestamp(saveDate.getTime());
        return timeStampDate;
    }

    @Override
    public DataTableModelSch getAllBillingProduct(String pojoClass, int start, int length, String sSearch, String[] dbList) throws ParseException {

        Map<String, Class<?>> clazz = new HashMap<String, Class<?>>();
        DataTableModelSch dataModel = new DataTableModelSch();

        SQLQuery sqlQuery = sessionFactory.getCurrentSession().createSQLQuery("select * from " + pojoClass);
        sqlQuery.addScalar("id", IntegerType.INSTANCE);

        for (int ind = 0; ind < dbList.length; ind++) {
            sqlQuery.addScalar(dbList[ind], StringType.INSTANCE);
        }
        sqlQuery.setMaxResults(length).setFirstResult(start);
        List<?> dataList = sqlQuery.list();
        List<ProductDetails> pojoClassList = new ArrayList<>();

        Iterator it = dataList.iterator();
        while (it.hasNext()) {
            Object[] obj = (Object[]) it.next();
            ProductDetails productList = new ProductDetails();
            SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd-MM-yyyy");
            SimpleDateFormat outputFormat1 = new SimpleDateFormat("yyyy-MM-dd");
            Date fromDate = outputFormat1.parse(obj[4].toString());
            Date toDate = outputFormat1.parse(obj[5].toString());

            productList.setId(Integer.parseInt(obj[0].toString()));
            productList.setName(obj[1].toString());
            productList.setShortDescription(obj[2].toString());
            productList.setDetailedDescription(obj[3].toString());
            productList.setFromDate(dateFormat1.format(fromDate));
            productList.setToDate(dateFormat1.format(toDate));
            pojoClassList.add(productList);
        }

        dataModel.setPojoClassList(pojoClassList);
        sqlQuery.setMaxResults(1000000000).setFirstResult(0).list();
        int total = ((Number) sqlQuery.list().size()).intValue();
        dataModel.setTotal(total);
        return dataModel;
    }

    public ProductMixedServices getProductMixedServiceByid(Class<?> pojoClass, String id) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(pojoClass);
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);// To avoid duplicates.
        Object val = applyAutoCasting(ProductMixedServices.class, "id", id);
        criteria.add(Restrictions.eq("id", val));
        ProductMixedServices pojoObject = (ProductMixedServices) criteria.uniqueResult();
        return pojoObject;
    }

    public ProductMaster getProductListByid(Class<?> pojoClass, String id) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(pojoClass);
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);// To avoid duplicates.
        Object val = applyAutoCasting(ProductMaster.class, "id", id);
        criteria.add(Restrictions.eq("id", val));
        ProductMaster pojoObject = (ProductMaster) criteria.uniqueResult();
        return pojoObject;
    }

    public ProductFeaturedUser getProductFeaturedUserByid(Class<?> pojoClass, String id) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(pojoClass);
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);// To avoid duplicates.
        Object val = applyAutoCasting(ProductFeaturedUser.class, "id", id);
        criteria.add(Restrictions.eq("id", val));
        ProductFeaturedUser pojoObject = (ProductFeaturedUser) criteria.uniqueResult();
        return pojoObject;
    }

    public ProductBanner getProductBannerByid(Class<?> pojoClass, String id) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(pojoClass);
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);// To avoid duplicates.
        Object val = applyAutoCasting(ProductBanner.class, "id", id);
        criteria.add(Restrictions.eq("id", val));
        ProductBanner pojoObject = (ProductBanner) criteria.uniqueResult();
        return pojoObject;
    }

    public ProductAccessList getProductAccessListByid(Class<?> pojoClass, String id) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(pojoClass);
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);// To avoid duplicates.
        Object val = applyAutoCasting(ProductAccessList.class, "id", id);
        criteria.add(Restrictions.eq("id", val));
        ProductAccessList pojoObject = (ProductAccessList) criteria.uniqueResult();
        return pojoObject;
    }

    enum CLAZZ {
        Long, Integer, BigDecimal, Boolean, Date, String;
    }
}
