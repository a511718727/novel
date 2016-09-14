package com.relaxhaha.mapper;

import com.relaxhaha.entity.NovelCommentEntity;

public interface NovelCommentEntityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(NovelCommentEntity record);

    int insertSelective(NovelCommentEntity record);

    NovelCommentEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(NovelCommentEntity record);

    int updateByPrimaryKeyWithBLOBs(NovelCommentEntity record);

    int updateByPrimaryKey(NovelCommentEntity record);
}