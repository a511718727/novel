package com.relaxhaha.vo;

import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by yangyang on 2016/9/12.
 */
public class ChapterVO implements Serializable {

    private Integer id;

    private String title;

    private Integer novelId;

    private Integer authorId;

    private Integer wordCount;

    private String content;


    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("title", title)
                .append("novelId", novelId)
                .append("authorId", authorId)
                .append("wordCount", wordCount)
                .append("id", id)
                .toString();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getNovelId() {
        return novelId;
    }

    public void setNovelId(Integer novelId) {
        this.novelId = novelId;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public Integer getWordCount() {
        return wordCount;
    }

    public void setWordCount(Integer wordCount) {
        this.wordCount = wordCount;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
