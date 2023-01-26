package com.ddaddu.CrawlingApp.Service;

import com.ddaddu.CrawlingApp.Domain.AmazonPage;
import com.ddaddu.CrawlingApp.PageRepository.PageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PageService {

    private final PageRepository pageRepository;

    public PageService(PageRepository pageRepository) {
        this.pageRepository = pageRepository;
    }

    public Long makePage(AmazonPage amazonPage) {
        pageRepository.save(amazonPage);
        return amazonPage.getId();
    }


    public Optional<AmazonPage> findOne(Long memberId) {
        return pageRepository.findById(memberId);
    }


    public List<AmazonPage> findMembers() {
        return pageRepository.findAll();
    }
}
