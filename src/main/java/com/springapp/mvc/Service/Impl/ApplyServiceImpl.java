package com.springapp.mvc.Service.Impl;

import com.springapp.mvc.DAO.ApplyDao;
import com.springapp.mvc.DAO.NotificationDao;
import com.springapp.mvc.DAO.UserDao;
import com.springapp.mvc.Model.*;
import com.springapp.mvc.Service.ApplyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by hujiaxuan on 2016/4/10.
 */
@Service
public class ApplyServiceImpl implements ApplyService {
    @Resource
    public ApplyDao applyDao;
    @Resource
    public NotificationDao notificationDao;
    @Override
    public int insertApplyInfo(Apply apply) {

        return applyDao.insertApply(apply);
    }

    @Override
    public int insertBudget(BudgetBean budgetBean) {
        return applyDao.insertBudget(budgetBean);
    }

    @Override
    public List<ApplyShort> selectAllApplyShortByuserId(String user_id) {

        return applyDao.selectApplyShortByuserId(user_id);
    }

    @Override
    public Apply selectApplyByapplyId(String apply_id) {
        return applyDao.selectApplyByapply_id(apply_id);
    }

    @Override
    public List<BudgetBean> selectAllBudgetByApplyId(String apply_id) {
        return applyDao.selectAllBudgetByApplyId(apply_id);
    }

    @Override
    public int updateApplyInfo(Apply apply) {
        return applyDao.updateApplyInfo(apply);
    }

    @Override
    public int updateBudget(BudgetBean budgetBean) {
        return applyDao.updateBudget(budgetBean);
    }

    @Override
    public int deleteBudgetByApplyId(String apply_id) {
        return applyDao.deleteBudgetByApplyId(apply_id);
    }

    @Override
    public int insertBudgets(List<Budget> list) {
        return 0;
    }

    @Override
    public int caculateApplyBudget(List<Budget> list) {
        float totle_budget=0;
        String apply_id;
        for(Budget budget:list){
            float budget_price;
            int budget_num;
            budget_price = Float.parseFloat(budget.budget_price);
            budget_num = Integer.parseInt(budget.budget_num);
            totle_budget += budget_price*budget_num;
        }
       apply_id = list.get(0).apply_id;
       int res= applyDao.updateApplyMoney(totle_budget,apply_id);
        return res;
    }

    @Override
    public float getApplyBudgetMoney(String apply_id) {
        return applyDao.getApplyMoney(apply_id);
    }

    @Override
    public String getApplyStateByApplyId(String id) {
        return applyDao.getApplyStateByApplyId(id);
    }

    @Override
    public String getApplyRes(String apply_id) {
        return applyDao.getApplyRes(apply_id);
    }

    @Override
    public List<ApplyShort> selectAllApplyShortByUserDepartment(String department) {

        return applyDao.selectAllApplyShortByDepartment(department);
    }

    @Override
    public int updateApplyState(String applyState,String apply_id) {
        return applyDao.updateApplyState(applyState,apply_id);
    }

    @Override
    public int sendApplyNotification(UserClient userClient, String apply_id) {

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String date = df.format(new Date());
        java.sql.Date date_ = java.sql.Date.valueOf(date);
        Notification notification = new Notification(userClient.user_id,userClient.user_account,date_,"","unread",apply_id,"employee");

        int res = notificationDao.insertNotification(notification);

        return res;
    }
}
