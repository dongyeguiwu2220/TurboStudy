package com.cclinux.projects.enlesson.mapper;

import com.cclinux.framework.core.mapper.ProjectBaseMapper;
import com.cclinux.projects.enlesson.model.EnrollModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Repository("EnLessonEnrollMapper")
@Mapper
public interface EnrollMapper extends ProjectBaseMapper<EnrollModel> {
}
