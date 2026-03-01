package com.cclinux.projects.enlesson.mapper;

import com.cclinux.framework.core.mapper.ProjectBaseMapper;
import com.cclinux.projects.enlesson.model.UserModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository("EnLessonUserMapper")
@Mapper
public interface UserMapper extends ProjectBaseMapper<UserModel> {
}
