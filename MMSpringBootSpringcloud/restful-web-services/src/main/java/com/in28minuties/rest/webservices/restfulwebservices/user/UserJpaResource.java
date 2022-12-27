package com.in28minuties.rest.webservices.restfulwebservices.user;


import com.in28minuties.rest.webservices.restfulwebservices.jpa.PostRepository;
import com.in28minuties.rest.webservices.restfulwebservices.jpa.UserRepository;
import jakarta.validation.NoProviderFoundException;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserJpaResource {

    private UserRepository userRepository;
    private PostRepository postRepository;

    public UserJpaResource(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @GetMapping("/jpa/users")
    public List<User> obtainAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/jpa/users/{id}")
    public EntityModel<User> obtainOneUser(@PathVariable int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) throw new UserNotFoundException("User with id=" + id + " not found");
        EntityModel<User> entityModel = EntityModel.of(user.get());
        Link link = WebMvcLinkBuilder.linkTo(
                methodOn(this.getClass())
                        .obtainAllUsers())
                .withRel("all-users");
        entityModel.add(link);
        return entityModel;
    }

    @PostMapping("/jpa/users")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<User> addAnUser(@Valid @RequestBody User user) {
        User savedUser = userRepository.save(user);
        URI location = getUriLocation(savedUser.getId());

        return ResponseEntity.created(location).build();
    }

    private static URI getUriLocation(Integer id) {
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
        return location;
    }

    @DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable int id) {
        userRepository.deleteById(id);
    }

    @GetMapping("/jpa/users/{id}/posts")
    public List<Post> getUserPosts(@PathVariable int id) {
        Optional<User> optUser = userRepository.findById(id);
        if (optUser.isEmpty())
            throw new UserNotFoundException("User with id=" + id + " not found");

        return optUser.get().getPosts();
    }

    @PostMapping("/jpa/users/{id}/posts")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<Post> createUserPost(@Valid @RequestBody Post post, @PathVariable("id") int userId) {
        Optional<User> optUser = userRepository.findById(userId);
        if (optUser.isEmpty())
            throw new UserNotFoundException("User with id=" + userId + " not found");
        post.setUser(optUser.get());
        Post savedPost = postRepository.save(post);

        URI location = getUriLocation(savedPost.getId());
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/jpa/users/{id}/posts/{postId}")
    @ResponseStatus(HttpStatus.OK)
    public Post getPost(@PathVariable("id") int userId, @PathVariable int postId) {
        Optional<User> optUser = userRepository.findById(userId);
        if (optUser.isEmpty())
            throw new UserNotFoundException("User with id=" + userId + " not found");
        return optUser.get().getPosts().stream()
                .filter(post -> post.getId() == postId)
                .findFirst().get();
    }

}
