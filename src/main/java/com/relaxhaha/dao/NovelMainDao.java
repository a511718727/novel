package com.relaxhaha.dao;

import com.google.inject.internal.Maps;
import com.relaxhaha.entity.NovelChapterEntity;
import com.relaxhaha.entity.NovelMainEntity;
import com.relaxhaha.mapper.NovelMainEntityMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by yangyang on 2016/9/12.
 */
@Repository
public class NovelMainDao {

    @Autowired
    private NovelMainEntityMapper mapper;

    public List<NovelMainEntity> findAllNovel(NovelMainEntity entity){
        return mapper.findAllNovel(toMap(entity));
    }


    private Map<String, Object> toMap(NovelMainEntity entity) {
        Map<String,Object> map = Maps.newHashMap();
        if (entity == null){
            return map;
        }
        if (entity.getType() != null){
            map.put("type",entity.getType());
        }
        if (StringUtils.isNotBlank(entity.getName())){
            map.put("name",entity.getName());
        }
        if (entity.getId() == null){
            map.put("id",entity.getId());
        }
        return map;
    }

    public boolean insertNovelMain(NovelMainEntity novel){
        return mapper.insertSelective(novel) > 0;
    }

    public boolean updateById(NovelMainEntity entity){
        return mapper.updateByPrimaryKeySelective(entity) > 0;
    }

    public boolean deleteById(Integer id){
        return mapper.deleteByPrimaryKey(id) > 0;
    }
}
