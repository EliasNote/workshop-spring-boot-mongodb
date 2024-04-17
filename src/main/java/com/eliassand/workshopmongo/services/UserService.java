package com.eliassand.workshopmongo.services;

import com.eliassand.workshopmongo.domain.User;
import com.eliassand.workshopmongo.dto.UserDTO;
import com.eliassand.workshopmongo.repository.UserRepository;
import com.eliassand.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;
    public List<User> findAll() {
        return repo.findAll();
    }

    public User findById(String id) {
        User user = repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
        return user;
    }

    public User insert(User obj) {
        return repo.insert(obj);
    }

    public void delete(String id) {
        findById(id);
        repo.deleteById(id);
    }

    public User update(User obj) {
        User newObj = repo.findById(obj.getId()).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
        updateData(newObj, obj);
        return repo.save(newObj);
    }

    private void updateData(User newObj, User obj) {
        newObj.setEmail(obj.getEmail());
        newObj.setName(obj.getName());
    }

    public User fromDTO(UserDTO objDto) {
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }
}
