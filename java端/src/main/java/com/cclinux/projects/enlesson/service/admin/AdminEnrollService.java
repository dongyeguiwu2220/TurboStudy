package com.cclinux.projects.enlesson.service.admin;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cclinux.framework.core.domain.PageParams;
import com.cclinux.framework.core.domain.PageResult;
import com.cclinux.framework.core.mapper.UpdateWhere;
import com.cclinux.framework.core.mapper.Where;
import com.cclinux.framework.core.mapper.WhereJoin;
import com.cclinux.framework.helper.FileHelper;
import com.cclinux.framework.helper.FormHelper;
import com.cclinux.projects.enlesson.comm.ProjectConfig;
import com.cclinux.projects.enlesson.mapper.EnrollJoinMapper;
import com.cclinux.projects.enlesson.mapper.EnrollMapper;
import com.cclinux.projects.enlesson.model.EnrollJoinModel;
import com.cclinux.projects.enlesson.model.EnrollModel;
import com.cclinux.projects.enlesson.model.UserModel;
import com.cclinux.projects.enlesson.service.cust.EnrollService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @Notes: 选课业务逻辑
 * @Author: cclinux0730 (weixin)
 * @Ver: ccminicloud-framework 3.2.1
 */


@Service("EnLessonAdminEnrollService")
public class AdminEnrollService extends BaseMyAdminService {


    @Resource(name = "EnLessonEnrollMapper")
    private EnrollMapper enrollMapper;

    @Resource(name = "EnLessonEnrollJoinMapper")
    private EnrollJoinMapper enrollJoinMapper;

    @Resource(name = "EnLessonEnrollService")
    private EnrollService enrollService;


    /**
     * 添加活动
     */
    public long insertEnroll(EnrollModel enroll) {
        appError("{选课}该功能暂不开放，如有需要请加作者微信：cclinux0730");
        return 0;
    }

    /**
     * 修改活动
     */
    public void editEnroll(EnrollModel enroll) {
        appError("{选课}该功能暂不开放，如有需要请加作者微信：cclinux0730");

    }


    /**
     * 活动列表
     */
    public PageResult getAdminEnrollList(PageParams pageRequest) {

        Where<EnrollModel> where = new Where<>();

        // 关键字查询
        String search = pageRequest.getSearch();
        if (StrUtil.isNotEmpty(search)) {
            where.and(wrapper -> {
                wrapper.or().like("ENROLL_TITLE", search);
            });
        }

        // 条件查询
        String sortType = pageRequest.getSortType();
        String sortVal = pageRequest.getSortVal();
        if (StrUtil.isNotEmpty(sortType) && StrUtil.isNotEmpty(sortVal)) {
            switch (sortType) {
                case "cateId": {
                    where.eq("ENROLL_CATE_ID", Convert.toLong(sortVal));
                    break;
                }
                case "status": {
                    where.eq("ENROLL_STATUS", Convert.toInt(sortVal));
                    break;
                }
                case "vouch": {
                    where.eq("ENROLL_VOUCH", 1);
                    break;
                }
                case "top": {
                    where.eq("ENROLL_ORDER", 0);
                    break;
                }
                case "sort": {
                    logger.info("SortVal" + sortVal);
                    where.fmtOrderBySort(sortVal, "");
                    break;
                }
            }

        }

        // 排序
        where.orderByAsc("ENROLL_ORDER");
        where.orderByDesc("ENROLL_ID");


        Page page = new Page(pageRequest.getPage(), pageRequest.getSize());
        return enrollMapper.getPageList(page, where, "*");
    }

    /**
     * 活动选课名单
     */
    public PageResult getAdminEnrollJoinList(PageParams pageRequest) {

        WhereJoin<EnrollJoinModel> where = new WhereJoin<>();
        where.leftJoin(UserModel.class, UserModel::getUserId, EnrollJoinModel::getEnrollJoinUserId);


        long enrollId = pageRequest.getParamLong("enrollId");
        where.eq("ENROLL_JOIN_ENROLL_ID", enrollId);

        // 关键字查询
        String search = pageRequest.getSearch();
        if (StrUtil.isNotEmpty(search)) {
            where.and(wrapper -> {
                wrapper.or().like("t1.USER_OBJ", search);
                wrapper.or().like("t1.USER_NAME", search);
            });
        }

        // 条件查询
        String sortType = pageRequest.getSortType();
        String sortVal = pageRequest.getSortVal();
        if (StrUtil.isNotEmpty(sortType) && StrUtil.isNotEmpty(sortVal)) {
            switch (sortType) {
                case "status": {
                    where.eq("ENROLL_JOIN_STATUS", Convert.toInt(sortVal));
                    break;
                }
                case "sort": {
                    logger.info("SortVal" + sortVal);
                    where.fmtOrderBySort(sortVal, "");
                    break;
                }
            }

        }

        // 排序
        where.orderByDesc("ENROLL_JOIN_ID");

        Page page = new Page(pageRequest.getPage(), pageRequest.getSize());
        return enrollJoinMapper.getPageJoinList(page, where, "t.*,t1.USER_NAME,t1.USER_FORMS,t1.USER_OBJ");
    }

    /**
     * 删除活动
     */
    public void delEnroll(long id) {
        appError("{选课}该功能暂不开放，如有需要请加作者微信：cclinux0730");

    }

    /**
     * 删除活动选课
     */
    public void delEnrollJoin(long enrollJoinId) {

        appError("{选课}该功能暂不开放，如有需要请加作者微信：cclinux0730");
    }


    /**
     * 获取单个活动
     */
    public Map<String, Object> getEnrollDetail(long id) {
        return enrollMapper.getOneMap(id);
    }

    /**
     * 修改活动状态
     */
    public void statusEnroll(long id, int status) {
        appError("{选课}该功能暂不开放，如有需要请加作者微信：cclinux0730");
    }


    /**
     * 修改排序
     */
    public void orderEnroll(long id, int order) {
        appError("{选课}该功能暂不开放，如有需要请加作者微信：cclinux0730");
    }


    /**
     * 首页设定
     */
    public void vouchEnroll(long id, int vouch) {
        appError("{选课}该功能暂不开放，如有需要请加作者微信：cclinux0730");
    }

    /**
     * 导出名单
     */
    public Map<String, Object> exportEnrollJoinExcel(long enrollId, String fmt) {
        appError("{选课}该功能暂不开放，如有需要请加作者微信：cclinux0730");

        return null;
    }

    /**
     * 清空名单
     */
    public void clearEnrollAll(long enrollId) {
        appError("{选课}该功能暂不开放，如有需要请加作者微信：cclinux0730");
    }


}
