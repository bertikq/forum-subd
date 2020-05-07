package ru.ulstu.service;

import org.springframework.context.annotation.MBeanExportConfiguration;
import org.springframework.data.domain.Page;
import ru.ulstu.model.OffsetablePageRequest;
import ru.ulstu.model.PageableItems;
import ru.ulstu.model.Paper;
import ru.ulstu.repository.PaperRepository;

import java.util.List;
import java.util.Optional;

public class PaperService implements Crud<Paper> {

    private final PaperRepository paperRepository;

    public PaperService(PaperRepository paperRepository) {
        this.paperRepository = paperRepository;
    }

    @Override
    public Paper create(Paper paper) {
        return paperRepository.save(paper);
    }

    @Override
    public List<Paper> findAll() {
        return paperRepository.findAll();
    }

    @Override
    public Paper get(Integer id) {
        return paperRepository.getOne(id);
    }

    @Override
    public Optional<Paper> find(Integer id) {
        return paperRepository.findById(id);
    }

    @Override
    public PageableItems<Paper> findAll(int offset, int count) {
        final Page<Paper> page = paperRepository.findAll(new OffsetablePageRequest(offset, count));
        return new PageableItems<>(page.getTotalElements(), page.getContent());
    }

    @Override
    public Paper update(Paper paper) {
        if (paper.getId() == null) {
            throw new RuntimeException("Paper id is null");
        }
        return paperRepository.save(paper);
    }

    @Override
    public void delete(Paper paper) {
        paperRepository.delete(paper);
    }
}