package com.cclinux.projects.enlesson.mapper;

import com.cclinux.framework.core.mapper.ProjectBaseMapper;
import com.cclinux.projects.enlesson.model.EnrollJoinModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Repository("EnLessonEnrollJoinMapper")
@Mapper
public interface EnrollJoinMapper extends ProjectBaseMapper<EnrollJoinModel> {

}
