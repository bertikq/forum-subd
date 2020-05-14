package ru.ulstu.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import ru.ulstu.model.Moderator;
import ru.ulstu.model.OffsetablePageRequest;
import ru.ulstu.model.PageableItems;
import ru.ulstu.repository.ModeratorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ModeratorService implements Crud<Moderator> {


    private final ModeratorRepository moderatorRepository;

    public ModeratorService(ModeratorRepository moderatorRepository) {
        this.moderatorRepository = moderatorRepository;
    }

    @Override
    public Moderator create(Moderator moderator) {
        return moderatorRepository.save(moderator);
    }

    @Override
    public List<Moderator> findAll() {
        return moderatorRepository.findAll();
    }

    @Override
    public Moderator get(Integer id) {
        return moderatorRepository.getOne(id);
    }

    @Override
    public Optional<Moderator> find(Integer id) {
        return moderatorRepository.findById(id);
    }

    @Override
    public PageableItems<Moderator> findAll(int offset, int count) {
        final Page<Moderator> page = moderatorRepository.findAll(new OffsetablePageRequest(offset, count));
        return new PageableItems<>(page.getTotalElements(), page.getContent());
    }

    @Override
    public Moderator update(Moderator moderator) {
        if (moderator.getId() == null) {
            throw new RuntimeException("Moderator id is null");
        }
        return moderatorRepository.save(moderator);
    }

    @Override
    public void delete(Moderator moderator) {
        moderatorRepository.delete(moderator);
    }
}
