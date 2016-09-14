package com.relaxhaha.mapper;

import com.relaxhaha.entity.NovelRecommendEntity;

public interface NovelRecommendEntityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(NovelRecommendEntity record);

    int insertSelective(NovelRecommendEntity record);

    NovelRecommendEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(NovelRecommendEntity record);

    int updateByPrimaryKey(NovelRecommendEntity record);
}