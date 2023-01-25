package com.ddaddu.CrawlingApp.Service;

import com.ddaddu.CrawlingApp.Domain.AmazonPage;
import com.ddaddu.CrawlingApp.PageRepository.MemoryPageRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PageServiceTest {
    PageService pageService;
    MemoryPageRepository pageRepository;

    @BeforeEach
    public void beforeEach(){
        pageRepository = new MemoryPageRepository();
        pageService = new PageService(pageRepository);
    }

    @AfterEach
    public void afterEach(){
        pageRepository.clearStore();
    }


    @Test
    void 입력테스트() {
        //given
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.setPageUrl("James");

        //when
        Long saveId = pageService.makePage(amazonPage);

        //then
        AmazonPage findPage = pageService.findOne(saveId).get();
        assertThat(amazonPage.getPageUrl()).isEqualTo(findPage.getPageUrl());

    }
}