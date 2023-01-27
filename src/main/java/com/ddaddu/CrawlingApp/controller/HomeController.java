package com.ddaddu.CrawlingApp.controller;

import com.ddaddu.CrawlingApp.Domain.AmazonPage;
import com.ddaddu.CrawlingApp.Domain.ExcelFile;
import com.ddaddu.CrawlingApp.Service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

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

        //try catch 수정 필요
        try{
            amazonPage.setImgUrls();
        }catch(Exception e){
            System.out.println("주소가 이상한 거 같아여");
            e.getMessage();
            e.printStackTrace();
            return "redirect:/";
        }

        pageService.makePage(amazonPage);

        return "redirect:/";
    }
    @GetMapping("/excel")
    public String makeExcelFile() {
        List<AmazonPage> pages = pageService.findAllPages();
        ExcelFile excelFile = new ExcelFile();
        excelFile.makeExcelFile();
        return "redirect:/";
    }

    @GetMapping("/pages")
    public String list(Model model) {
        List<AmazonPage> pages = pageService.findAllPages();
        model.addAttribute("pages", pages);
        return "pages/pageList";
    }

}
