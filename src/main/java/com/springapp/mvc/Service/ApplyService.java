package com.springapp.mvc.Service;

import com.springapp.mvc.Model.*;

import java.util.List;

/**
 * Created by hujiaxuan on 2016/4/10.
 */
public interface ApplyService {
        public int insertApplyInfo(Apply apply);
        public int insertBudget(BudgetBean budgetBean);
        public List<ApplyShort> selectAllApplyShortByuserId(String user_id);
        public Apply selectApplyByapplyId(String apply_id);
        public List<BudgetBean> selectAllBudgetByApplyId(String apply_id);
        public int updateApplyInfo(Apply apply);
        public int updateBudget(BudgetBean budgetBean);
        public int deleteBudgetByApplyId(String applyid);
        public int insertBudgets(List<Budget> list);
        public int caculateApplyBudget(List<Budget> list);
        public float getApplyBudgetMoney(String apply_id);
        public String getApplyStateByApplyId(String id);
        public String getApplyRes(String apply_id);
        public List<ApplyShort> selectAllApplyShortByUserDepartment(String department);
        public int updateApplyState(String applyState,String apply_id);
        public int sendApplyNotification(UserClient userClient,String apply_id);
}
