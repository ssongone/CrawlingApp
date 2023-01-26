package com.ddaddu.CrawlingApp.PageRepository;

import com.ddaddu.CrawlingApp.Domain.AmazonPage;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryPageRepository implements PageRepository{

    private static Map<Long, AmazonPage> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public AmazonPage save(AmazonPage amazonPage) {
        amazonPage.setId(++sequence);
        store.put(amazonPage.getId(), amazonPage);
        return amazonPage;
    }

    @Override
    public Optional<AmazonPage> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<AmazonPage> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
