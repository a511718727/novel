package com.relaxhaha.mapper;

import com.relaxhaha.entity.NovelReaderEntity;

public interface NovelReaderEntityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(NovelReaderEntity record);

    int insertSelective(NovelReaderEntity record);

    NovelReaderEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(NovelReaderEntity record);

    int updateByPrimaryKey(NovelReaderEntity record);
}