package com.relaxhaha.service;

import com.google.inject.internal.Lists;
import com.relaxhaha.dao.NovelMainDao;
import com.relaxhaha.entity.NovelMainEntity;
import com.relaxhaha.util.BeanCopyHelper;
import com.relaxhaha.vo.NovelVO;
import org.apache.commons.lang.StringUtils;
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
public class NovelMainService {
    private Logger logger = LoggerFactory.getLogger(NovelMainService.class);

    @Autowired
    private NovelMainDao dao;


    public boolean saveOrupdateNovel(NovelVO vo){
        logger.info("NovelMainService.saveOrupdateNovel,vo="+vo);
        if (vo == null){
            return false;
        }
        try {
            NovelMainEntity entity = new NovelMainEntity();
            BeanCopyHelper.copyProperties(vo,entity);
            entity.setUpdateTime(new Date());
            if (vo.getId() == null){
                entity.setAddTime(new Date());
                entity.setWordCount(vo.getIntro().length());
                return dao.insertNovelMain(entity);
            }else{
                if (StringUtils.isNotBlank(vo.getIntro())){
                    entity.setWordCount(vo.getIntro().length());
                }
                return dao.updateById(entity);
            }

        }catch (Exception e){
            logger.error("NovelMainService.saveOrupdateNovel error," + e);
            return false;
        }
    }


    public List<NovelVO> queryNovel(NovelVO vo){
        logger.info("NovelMainService.queryNovel,vo="+vo);
        List<NovelVO> novelVOs = Lists.newArrayList();
        if (vo == null){
          return novelVOs;
        }
        try {
            NovelMainEntity entity = new NovelMainEntity();
            BeanCopyHelper.copyProperties(vo, entity);
            return toVOs(novelVOs, dao.findAllNovel(entity));
        }catch (Exception e){
            logger.error("NovelMainService.queryNovel error,"+e);
            return novelVOs;
        }
    }

    public boolean deleteNovelById(Integer id){
        logger.info("NovelMainService.deleteNovelById,id="+id);
        List<NovelVO> novelVOs = Lists.newArrayList();
        if (id == null){
            return false;
        }
        try {
            return dao.deleteById(id);
        }catch (Exception e){
            logger.error("NovelMainService.deleteNovelById error,"+e);
            return false;
        }
    }


    private List<NovelVO> toVOs(List<NovelVO> novelVOs, List<NovelMainEntity> novels) {
        for (NovelMainEntity entity:novels){
            NovelVO novelVO = new NovelVO();
            BeanCopyHelper.copyProperties(entity,novelVO);
            novelVOs.add(novelVO);
        }
        return novelVOs;
    }
}
