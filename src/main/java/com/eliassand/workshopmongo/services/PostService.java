package com.eliassand.workshopmongo.services;

import com.eliassand.workshopmongo.domain.Post;
import com.eliassand.workshopmongo.repository.PostRepository;
import com.eliassand.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        Post post = repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
        return post;
    }

}
