package com.cclinux.projects.enlesson.service.admin;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.cclinux.framework.config.AppConfig;
import com.cclinux.framework.core.mapper.Where;
import com.cclinux.framework.exception.AppException;
import com.cclinux.framework.helper.JWTHelper;
import com.cclinux.framework.helper.TimeHelper;
import com.cclinux.projects.enlesson.mapper.AdminMapper;
import com.cclinux.projects.enlesson.mapper.EnrollMapper;
import com.cclinux.projects.enlesson.mapper.NewsMapper;
import com.cclinux.projects.enlesson.mapper.UserMapper;
import com.cclinux.projects.enlesson.model.AdminModel;
import com.cclinux.projects.enlesson.model.EnrollModel;
import com.cclinux.projects.enlesson.model.NewsModel;
import com.cclinux.projects.enlesson.model.UserModel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @Notes: 后台首页模块
 * @Author: cclinux0730 (weixin)
 * @Date: 2024/2/16 9:35
 * @Ver: ccminicloud-framework 3.2.1
 */
@Service("EnLessonAdminHomeService")
public class AdminHomeService extends BaseMyAdminService {

    @Resource(name = "EnLessonAdminMapper")
    private AdminMapper adminMapper;

    @Resource(name = "EnLessonNewsMapper")
    private NewsMapper newsMapper;

    @Resource(name = "EnLessonEnrollMapper")
    private EnrollMapper enrollMapper;

    @Resource(name = "EnLessonUserMapper")
    private UserMapper userMapper;

    @Resource(name = "EnLessonAdminMgrService")
    private AdminMgrService adminMgrService;

    /**
     * 首页数据归集
     */
    public ArrayList adminHome() {
        long userCnt = userMapper.count(new Where<UserModel>());
        long newsCnt = newsMapper.count(new Where<NewsModel>());
        long enrollCnt = enrollMapper.count(new Where<EnrollModel>());

        ArrayList list = new ArrayList();

        Map<String, Object> ret = new HashMap<>();

        ret.put("cnt", userCnt);
        ret.put("title", "用户数");
        list.add(ret);

        ret = new HashMap<>();
        ret.put("cnt", newsCnt);
        ret.put("title", "公告数");
        list.add(ret);

        ret = new HashMap<>();
        ret.put("cnt", enrollCnt);
        ret.put("title", "报名项目数");
        list.add(ret);

        return list;
    }


    /**
     * 管理员登陆
     */
    public Map<String, Object> adminLogin(String name, String password) {
        // 判断是否存在
        Where<AdminModel> where = new Where<>();

        where.eq("ADMIN_STATUS", AdminModel.STATUS.NORMAL);
        where.eq("ADMIN_NAME", name);
        where.eq("ADMIN_PASSWORD", DigestUtil.md5Hex(password));


        AdminModel admin = adminMapper.getOne(where);

        if (ObjectUtil.isNull(admin)) throw new AppException("管理员不存在或者已停用");

        //  生成TOKEN
        String token = JWTHelper.genToken(admin.getAdminId(), admin.getAdminName(), "admin", AppConfig.JWT_ADMIN_EXPIRE);

        Map<String, Object> ret = new HashMap<>();
        ret.put("name", admin.getAdminName());
        ret.put("type", admin.getAdminType());
        ret.put("cnt", admin.getAdminLoginCnt());
        ret.put("token", token);
        ret.put("expire", AppConfig.JWT_ADMIN_EXPIRE);

        if (admin.getAdminLoginTime() == 0)
            ret.put("last", "尚未登录");
        else
            ret.put("last", TimeHelper.timestamp2Time(admin.getAdminLoginTime()));


        admin.setAdminLoginCnt(admin.getAdminLoginCnt() + 1);
        admin.setAdminLoginTime(TimeHelper.timestamp());
        adminMapper.update(admin, where);


        return ret;

    }
}
