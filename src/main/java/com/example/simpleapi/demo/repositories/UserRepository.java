package com.example.simpleapi.demo.repositories;

import java.util.Optional;

import com.example.simpleapi.demo.domain.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    
    /**
     * 全件取得
     */
    Iterable<User> findAll();

    /**
     * ユーザーのidからユーザーエンティティを取得
     * @param id 
     * @return 該当ユーザーエンティティ
     */
    Optional<User> findById(Integer id);

    /**
     * ユーザーエンティティの更新を行う．
     * @param user 登録したいユーザーエンティティ
     */
    User save(User user); 

    /** 
     * ユーザーのidから，削除を行う
     * @param id 
    */
    void deleteById(Integer id);

}