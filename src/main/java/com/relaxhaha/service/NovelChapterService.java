package com.relaxhaha.service;

import com.google.inject.internal.Lists;
import com.relaxhaha.dao.NovelChapterDao;
import com.relaxhaha.entity.NovelChapterEntity;
import com.relaxhaha.util.BeanCopyHelper;
import com.relaxhaha.vo.ChapterVO;
import com.relaxhaha.vo.NovelVO;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by yangyang on 2016/9/12.
 */
@Service
public class NovelChapterService implements Serializable {

    private Logger logger = LoggerFactory.getLogger(NovelChapterService.class);
    @Autowired
    private NovelChapterDao dao;

    public boolean addChapter(ChapterVO chapterVO){
        logger.info("NovelChapterService.addChapter,chapterVO="+chapterVO);
        if (chapterVO == null || chapterVO.getAuthorId() == null || StringUtils.isBlank(chapterVO.getContent())){
            return false;
        }
        try {
            NovelChapterEntity entity = new NovelChapterEntity();
            BeanCopyHelper.copyProperties(chapterVO,entity);
            entity.setAddTime(new Date());
            entity.setUpdateTime(new Date());
            return  dao.insertNovelChapter(entity);
        }catch (Exception e){
            logger.error("NovelChapterService.addChapter error,"+e);
            return false;
        }
    }

    public boolean saveOrupdateChapter(ChapterVO chapterVO){
        logger.info("NovelChapterService.saveOrupdateChapter,chapterVO="+chapterVO);
        if (chapterVO == null  || StringUtils.isBlank(chapterVO.getContent())){
            return false;
        }
        try {
            NovelChapterEntity entity = new NovelChapterEntity();
            BeanCopyHelper.copyProperties(chapterVO,entity);
            entity.setUpdateTime(new Date());
            if (chapterVO.getId() == null){
                entity.setAddTime(new Date());
                entity.setWordCount(entity.getContent().length());
                return  dao.insertNovelChapter(entity);
            }else{
                return  dao.updateNovelChapterById(entity);
            }
        }catch (Exception e){
            logger.error("NovelChapterService.saveOrupdateChapter error,"+e);
            return false;
        }
    }



    public NovelVO queryChapterContent(Integer chapterId){
        logger.info("NovelChapterService.queryChapter,id="+chapterId);
        NovelVO vo = new NovelVO();
        if (chapterId == null){
            return vo;
        }
        try {
            BeanCopyHelper.copyProperties(dao.selectNovelChapterById(chapterId),vo);
            return vo;
        }catch (Exception e){
            logger.error("NovelChapterService.queryChapterContent error,"+e);
            return null;
        }
    }

    public List<NovelVO> queryChapterList(Integer novelId){
        logger.info("NovelChapterService.queryChapterList,novelId="+novelId);
        List<NovelVO> vos = Lists.newArrayList();
        if (novelId == null){
            return vos;
        }
        try {
            toVOs(vos, dao.selectByNovelId(novelId));
            return vos;
        }catch (Exception e){
            logger.error("NovelChapterService.queryChapterList error,"+e);
            return null;
        }
    }

    public boolean deleteChapter(Integer id){
        logger.info("NovelChapterService.deleteChapter,id="+id);
        if (id == null){
            return false;
        }
        try {
            return dao.deleteById(id);
        }catch (Exception e){
            logger.error("NovelChapterService.deleteChapter error,"+e);
            return false;
        }
    }

    private void toVOs(List<NovelVO> vos, List<NovelChapterEntity> novelChapterEntities) {
        for (NovelChapterEntity entity : novelChapterEntities){
            NovelVO vo = new NovelVO();
            BeanCopyHelper.copyProperties(entity,vo);
            vos.add(vo);
        }
    }
}
