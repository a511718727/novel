package com.relaxhaha.service;

import com.google.inject.internal.Lists;
import com.relaxhaha.dao.NovelAuthorDao;
import com.relaxhaha.entity.NovelAuthorEntity;
import com.relaxhaha.util.BeanCopyHelper;
import com.relaxhaha.vo.AuthorVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by yangyang on 2016/9/12.
 */
@Service
public class NovelAuthorService {

    private Logger logger = LoggerFactory.getLogger(NovelAuthorService.class);
    @Autowired
    private NovelAuthorDao dao;

    public boolean saveOrupdateNovelAuthor(AuthorVO vo){
        logger.info("NovelAuthorService.saveOrupdateNovelAuthor vo =" + vo);
        if (vo == null){
            return false;
        }
        try {
            NovelAuthorEntity entity = new NovelAuthorEntity();
            BeanCopyHelper.copyProperties(vo,entity);
            entity.setUpdateTime(new Date());
            if (vo.getId() == null){
                entity.setAddTime(new Date());
                return dao.insertNovelAuthor(entity);
            }else{
                return dao.updateById(entity);
            }
        }catch (Exception e){
            logger.error("NovelAuthorService.saveOrupdateNovelAuthor error,"+e);
            return false;
        }
    }


    public boolean deleteNovelAuthor(Integer id){
        logger.info("NovelAuthorService.deleteNovelAuthor id =" + id);
        if (id == null){
            return false;
        }
        try {
            return dao.deleteById(id);
        }catch (Exception e){
            logger.error("NovelAuthorService.deleteNovelAuthor error,"+e);
            return false;
        }
    }

    public List<AuthorVO> queryNovelAuthor(AuthorVO vo){
        logger.info("NovelAuthorService.deleteNovelAuthor vo =" + vo);
        List<AuthorVO> authorVOs = Lists.newArrayList();
        if (vo == null){
            return authorVOs;
        }
        try {
            NovelAuthorEntity entity = new NovelAuthorEntity();
            BeanCopyHelper.copyProperties(vo,entity);
            return toVOs(authorVOs, dao.queryNovelAuthor(entity));
        }catch (Exception e){
            logger.error("NovelAuthorService.deleteNovelAuthor error,"+e);
            return null;
        }
    }

    private List<AuthorVO> toVOs(List<AuthorVO> authorVOs, List<NovelAuthorEntity> novelAuthorEntities) {
        for (NovelAuthorEntity entity: novelAuthorEntities){
            AuthorVO vo = new AuthorVO();
            BeanCopyHelper.copyProperties(entity,vo);
            authorVOs.add(vo);
        }
        return authorVOs;
    }


}
