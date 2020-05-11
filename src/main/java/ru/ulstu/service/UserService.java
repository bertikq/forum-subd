package ru.ulstu.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import ru.ulstu.model.OffsetablePageRequest;
import ru.ulstu.model.PageableItems;
import ru.ulstu.model.UserForum;
import ru.ulstu.model.UserStatistic;
import ru.ulstu.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements Crud<UserForum> {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserForum create(UserForum userForum) {
        return userRepository.save(userForum);
    }

    @Override
    public List<UserForum> findAll() {
        return userRepository.findAll();
    }

    @Override
    public UserForum get(Integer id) {
        return userRepository.getOne(id);
    }

    @Override
    public Optional<UserForum> find(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public PageableItems<UserForum> findAll(int offset, int count) {
        final Page<UserForum> page = userRepository.findAll(new OffsetablePageRequest(offset, count));
        return new PageableItems<>(page.getTotalElements(), page.getContent());
    }

    @Override
    public UserForum update(UserForum userForum) {
        if (userForum.getId() == null) {
            throw new RuntimeException("User id is null");
        }
        return userRepository.save(userForum);
    }

    @Override
    public void delete(UserForum userForum) {
        userRepository.delete(userForum);
    }

    public List<UserForum> findByStatus(String status){
        return userRepository.findByStatus(status);
    }

    public List<UserStatistic> getLoginUsersByThemeName(String themeName){
        return userRepository.getLoginUsersByThemeName(themeName);
    }
}
