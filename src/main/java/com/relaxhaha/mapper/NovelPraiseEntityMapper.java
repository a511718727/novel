package com.relaxhaha.mapper;

import com.relaxhaha.entity.NovelPraiseEntity;

public interface NovelPraiseEntityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(NovelPraiseEntity record);

    int insertSelective(NovelPraiseEntity record);

    NovelPraiseEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(NovelPraiseEntity record);

    int updateByPrimaryKey(NovelPraiseEntity record);
}