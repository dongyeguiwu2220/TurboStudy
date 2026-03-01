package com.cclinux.projects.enlesson.service.cust;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.cclinux.framework.core.mapper.Where;
import com.cclinux.framework.helper.FakerHelper;
import com.cclinux.projects.enlesson.mapper.EnrollJoinMapper;
import com.cclinux.projects.enlesson.mapper.EnrollMapper;
import com.cclinux.projects.enlesson.mapper.UserMapper;
import com.cclinux.projects.enlesson.model.EnrollJoinModel;
import com.cclinux.projects.enlesson.model.EnrollModel;
import com.cclinux.projects.enlesson.model.UserModel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Notes: 活动模块业务逻辑
 * @Author: cclinux0730 (weixin)
 * @Date:  3/7 5:41
 * @Ver: ccminicloud-framework 3.2.1
 */

@Service("EnLessonTestService")
public class TestService extends BaseMyCustService {

    @Resource(name = "EnLessonEnrollMapper")
    private EnrollMapper enrollMapper;

    @Resource(name = "EnLessonEnrollJoinMapper")
    private EnrollJoinMapper enrollJoinMapper;

    @Resource(name = "EnLessonUserMapper")
    private UserMapper userMapper;

    @Resource(name = "EnLessonEnrollService")
    private EnrollService enrollService;


    public void test() {


    }


}
