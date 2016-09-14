package com.relaxhaha.mapper;

import com.relaxhaha.entity.NovelAuthorEntity;

import java.util.List;
import java.util.Map;

public interface NovelAuthorEntityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(NovelAuthorEntity record);

    int insertSelective(NovelAuthorEntity record);

    NovelAuthorEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(NovelAuthorEntity record);

    int updateByPrimaryKey(NovelAuthorEntity record);

    List<NovelAuthorEntity> queryNovelAuthor(Map<String, Object> map);
}