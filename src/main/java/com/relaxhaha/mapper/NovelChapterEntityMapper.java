package com.relaxhaha.mapper;

import com.relaxhaha.entity.NovelChapterEntity;

import java.util.List;

public interface NovelChapterEntityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(NovelChapterEntity record);

    int insertSelective(NovelChapterEntity record);

    NovelChapterEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(NovelChapterEntity record);

    int updateByPrimaryKeyWithBLOBs(NovelChapterEntity record);

    int updateByPrimaryKey(NovelChapterEntity record);

    List<NovelChapterEntity> selectByNovelId(Integer novelId);
}