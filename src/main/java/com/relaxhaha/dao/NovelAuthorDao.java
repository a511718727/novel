package com.relaxhaha.dao;

import com.google.inject.internal.Maps;
import com.relaxhaha.entity.NovelAuthorEntity;
import com.relaxhaha.mapper.NovelAuthorEntityMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by yangyang on 2016/9/12.
 */
@Repository
public class NovelAuthorDao {

    @Autowired
    private NovelAuthorEntityMapper mapper;

    public boolean insertNovelAuthor(NovelAuthorEntity entity){
       return mapper.insert(entity) > 0;
    }

    public List<NovelAuthorEntity> queryNovelAuthor(NovelAuthorEntity entity){
        Map<String,Object> map = toMap(entity);
        return mapper.queryNovelAuthor(map);
    }

    private Map<String, Object> toMap(NovelAuthorEntity entity) {
        Map<String,Object> map = Maps.newHashMap();
        if (entity == null){
            return map;
        }
        if (StringUtils.isNotBlank(entity.getName())){
            map.put("name",entity.getName());
        }
        if (StringUtils.isNotBlank(entity.getNickName())){
            map.put("name",entity.getNickName());
        }
        if (entity.getId() != null){
            map.put("id",entity.getId());
        }
        return map;
    }

    public boolean updateById(NovelAuthorEntity entity){
        return mapper.updateByPrimaryKey(entity) > 0;
    }

    public boolean deleteById(Integer id){
        return mapper.deleteByPrimaryKey(id) > 0;
    }
}
