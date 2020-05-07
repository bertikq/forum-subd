package ru.ulstu.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import ru.ulstu.model.OffsetablePageRequest;
import ru.ulstu.model.PageableItems;
import ru.ulstu.model.Theme;
import ru.ulstu.repository.ThemeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ThemeService implements Crud<Theme> {

    private final ThemeRepository themeRepository;

    public ThemeService(ThemeRepository themeRepository) {
        this.themeRepository = themeRepository;
    }

    @Override
    public Theme create(Theme theme) {
        return themeRepository.save(theme);
    }

    @Override
    public List<Theme> findAll() {
        return themeRepository.findAll();
    }

    @Override
    public Theme get(Integer id) {
        return themeRepository.getOne(id);
    }

    @Override
    public Optional<Theme> find(Integer id) {
        return themeRepository.findById(id);
    }

    @Override
    public PageableItems<Theme> findAll(int offset, int count) {
        final Page<Theme> page = themeRepository.findAll(new OffsetablePageRequest(offset, count));
        return new PageableItems<>(page.getTotalElements(), page.getContent());
    }

    @Override
    public Theme update(Theme theme) {
        if (theme.getId() == null) {
            throw new RuntimeException("Theme id is null");
        }
        return themeRepository.save(theme);
    }

    @Override
    public void delete(Theme theme) {
        themeRepository.delete(theme);
    }

    public List<Theme> findByName(String name){
        return themeRepository.findByName(name);
    }
}
