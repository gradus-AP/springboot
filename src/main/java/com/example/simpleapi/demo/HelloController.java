package com.example.simpleapi.demo;

import com.example.simpleapi.demo.domain.User;
import com.example.simpleapi.demo.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    UserRepository userRepository;

    /**
     * 全件取得
     * @return 取得結果
     */
    @RequestMapping("/api/users")
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * idを指定してユーザー情報取得
     * @param id
     * @return 取得したユーザー情報
     */
    @RequestMapping("/api/users/{id}")
    public User getUserById(@PathVariable(name = "id") Integer id) {
        return userRepository.findById(id).get();
    }

    /**
     * nameを指定してレコードを作成
     * @param name 登録するユーザー名
     * @return User
     */
    @PostMapping("/api/users")
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody String name) {
        return userRepository.save(new User(name));
    }

    /**
     * id, nameを指定して，レコードを更新
     * @param id
     */
    @PutMapping("/api/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public User updateUser(@PathVariable(name = "id") Integer id, @RequestBody String name) {
        return userRepository.save(new User(id, name));
    }

    /**
     * idを指定してユーザーを削除
     * @param id 
     */
    @DeleteMapping("/api/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUserById(@PathVariable(name = "id") Integer id) {
        userRepository.deleteById(id);
    }
}