package com.ddaddu.CrawlingApp.controller;

import com.ddaddu.CrawlingApp.Domain.AmazonPage;
import com.ddaddu.CrawlingApp.Service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    private PageService pageService;

    @Autowired
    public HomeController(PageService pageService) {
        this.pageService = pageService;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @PostMapping("/pages/new")
    public String create(PageForm form) {

        AmazonPage amazonPage = new AmazonPage();
        amazonPage.setPageUrl(form.getPageUrl());
        pageService.makePage(amazonPage);

        return "redirect:/";
    }

}
