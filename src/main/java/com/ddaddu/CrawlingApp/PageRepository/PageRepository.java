package com.ddaddu.CrawlingApp.PageRepository;

import com.ddaddu.CrawlingApp.Domain.AmazonPage;

import java.util.List;
import java.util.Optional;

public interface PageRepository {

    AmazonPage save(AmazonPage amazonPage);
    Optional<AmazonPage> findById(Long id);
    List<AmazonPage> findAll();
    void clearStore();
}
