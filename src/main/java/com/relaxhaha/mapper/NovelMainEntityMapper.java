package com.relaxhaha.mapper;

import com.relaxhaha.entity.NovelMainEntity;

import java.util.List;
import java.util.Map;

public interface NovelMainEntityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(NovelMainEntity record);

    int insertSelective(NovelMainEntity record);

    NovelMainEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(NovelMainEntity record);

    int updateByPrimaryKey(NovelMainEntity record);

    List<NovelMainEntity> findAllNovel(Map<String, Object> map);
}