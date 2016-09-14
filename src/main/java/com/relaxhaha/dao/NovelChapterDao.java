package com.relaxhaha.dao;

import com.relaxhaha.entity.NovelChapterEntity;
import com.relaxhaha.mapper.NovelChapterEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by yangyang on 2016/9/12.
 */
@Repository
public class NovelChapterDao {

    @Autowired
    private NovelChapterEntityMapper mapper;

    public NovelChapterEntity selectNovelChapterById(Integer id){
        return mapper.selectByPrimaryKey(id);
    }

    public List<NovelChapterEntity> selectByNovelId(Integer novelId){
        return mapper.selectByNovelId(novelId);
    }

    public boolean insertNovelChapter(NovelChapterEntity entity){
        return mapper.insertSelective(entity) > 0;
    }

    public boolean updateNovelChapterById(NovelChapterEntity entity){
        return mapper.updateByPrimaryKeySelective(entity) > 0;
    }

    public boolean deleteById(Integer id){
        return mapper.deleteByPrimaryKey(id) > 0;
    }
}
