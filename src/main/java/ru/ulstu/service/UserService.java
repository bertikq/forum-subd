package ru.ulstu.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import ru.ulstu.model.OffsetablePageRequest;
import ru.ulstu.model.PageableItems;
import ru.ulstu.model.User;
import ru.ulstu.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements Crud<User> {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User get(Integer id) {
        return userRepository.getOne(id);
    }

    @Override
    public Optional<User> find(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public PageableItems<User> findAll(int offset, int count) {
        final Page<User> page = userRepository.findAll(new OffsetablePageRequest(offset, count));
        return new PageableItems<>(page.getTotalElements(), page.getContent());
    }

    @Override
    public User update(User user) {
        if (user.getId() == null) {
            throw new RuntimeException("User id is null");
        }
        return userRepository.save(user);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    public List<User> findByStatus(String status){
        return userRepository.findByStatus(status);
    }
}
