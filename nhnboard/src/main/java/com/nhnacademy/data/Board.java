package com.nhnacademy.data;

import java.time.LocalDateTime;

public class Board implements Boards {
    private long id;
    private String userId;
    private String title;
    private String content;
    private LocalDateTime time;
    private int viewCount;

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String getUserId() {
        return this.userId;
    }

    @Override
    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getContent() {
        return this.content;
    }

    @Override
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public LocalDateTime getWriteTime() {
        return this.time;
    }

    @Override
    public void setWriteTime(LocalDateTime writeTime) {
        this.time = writeTime;
    }

    @Override
    public int getViewCount() {
        return this.viewCount;
    }

    @Override
    public void increaseViewCount() {
        this.viewCount = this.viewCount + 1;
    }
}
