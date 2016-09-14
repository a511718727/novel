package com.relaxhaha.web.controller;

import com.relaxhaha.common.ResponseVO;
import com.relaxhaha.service.NovelAuthorService;
import com.relaxhaha.service.NovelChapterService;
import com.relaxhaha.service.NovelMainService;
import com.relaxhaha.vo.AuthorVO;
import com.relaxhaha.vo.ChapterVO;
import com.relaxhaha.vo.NovelVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by yangyang on 2016/9/12.
 */
@Controller
@RequestMapping("/novel")
public class NovelController {
    private Logger logger = LoggerFactory.getLogger(NovelController.class);

    @Autowired
    private NovelAuthorService authorService;
    @Autowired
    private NovelChapterService chapterService;
    @Autowired
    private NovelMainService novelService;

    @RequestMapping(value = "/saveOrupdateAuthor")
    @ResponseBody
    public ResponseVO  saveOrupdateAuthor(@RequestBody AuthorVO vo,HttpServletRequest request){
        logger.info("NovelController.saveOrupdateAuthor,vo="+vo);
        if (!validate(vo)){
            return ResponseVO.failure();
        }
        if (authorService.saveOrupdateNovelAuthor(vo)){
            return ResponseVO.success();
        }else{
            return ResponseVO.failure();
        }
    }

    @RequestMapping(value = "/queryNovelAuthor")
    @ResponseBody
    public ResponseVO  queryNovelAuthor(@RequestBody AuthorVO vo,HttpServletRequest request){
        logger.info("NovelController.queryNovelAuthor,vo="+vo);
        if (vo == null || (vo.getId() == null && vo.getNickName() == null && vo.getName() == null)){
            return ResponseVO.failure();
        }
        return ResponseVO.success(authorService.queryNovelAuthor(vo));
    }

    @RequestMapping(value = "/saveOrupdateNovel")
    @ResponseBody
    public ResponseVO  saveOrupdateNovel(@RequestBody NovelVO vo,HttpServletRequest request){
        logger.info("NovelController.saveOrupdateNovel,vo="+vo);
        if (vo == null){
            return ResponseVO.failure();
        }
        if (novelService.saveOrupdateNovel(vo)){
            return ResponseVO.success();
        }else{
            return ResponseVO.failure();
        }

    }

    @RequestMapping(value = "/saveOrupdateChapter")
    @ResponseBody
    public ResponseVO  saveOrupdateChapter(@RequestBody ChapterVO vo,HttpServletRequest request){
        logger.info("NovelController.queryNovelAuthor,vo="+vo);
        if (vo == null){
            return ResponseVO.failure();
        }
        if (chapterService.saveOrupdateChapter(vo)){
            return ResponseVO.success();
        }else{
            return ResponseVO.failure();
        }
    }

    @RequestMapping(value = "/deleteChapter")
    @ResponseBody
    public ResponseVO  deleteChapter(@RequestBody ChapterVO vo,HttpServletRequest request){
        logger.info("NovelController.deleteChapter,vo="+vo);
        if (vo == null || vo.getId() == null){
            return ResponseVO.failure();
        }
        return ResponseVO.success(chapterService.deleteChapter(vo.getId()));
    }

    @RequestMapping(value = "/queryChapterList")
    @ResponseBody
    public ResponseVO  queryChapterList(@RequestBody ChapterVO vo,HttpServletRequest request){
        logger.info("NovelController.queryChapterList,vo="+vo);
        if (vo == null || vo.getNovelId() == null){
            return ResponseVO.failure();
        }
        return ResponseVO.success(chapterService.queryChapterList(vo.getNovelId()));
    }

    @RequestMapping(value = "/queryChapterContent")
    @ResponseBody
    public ResponseVO  queryChapterContent(@RequestBody ChapterVO vo,HttpServletRequest request){
        logger.info("NovelController.queryChapterContent,vo="+vo);
        if (vo == null || vo.getId() == null){
            return ResponseVO.failure();
        }
        return ResponseVO.success(chapterService.queryChapterContent(vo.getId()));
    }



    private boolean validate(AuthorVO vo) {
        if (vo == null){
            return false;
        }
        if (vo.getId() == null && (vo.getName()== null || vo.getNickName() == null)){
            return false;
        }
        return true;
    }

}
