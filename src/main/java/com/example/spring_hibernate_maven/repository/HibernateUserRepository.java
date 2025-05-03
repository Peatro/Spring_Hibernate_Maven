package com.example.spring_hibernate_maven.repository;

import com.example.spring_hibernate_maven.entity.UserEntity;
import com.example.spring_hibernate_maven.entity.UserModel;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional("hibernateTransactionManager")
@RequiredArgsConstructor
public class HibernateUserRepository implements UserRepository {

    private final SessionFactory sessionFactory;

    @Override
    public UserModel save(UserModel userModel) {
        getCurrenSession().persist(userModel);
        return userModel;
    }

    @Override
    public UserModel findById(Long id) {
        return getCurrenSession().get(UserEntity.class, id);
    }

    @Override
    public List<UserModel> findAll() {
        return getCurrenSession().createQuery("FROM UserEntity", UserEntity.class)
                .getResultList()
                .stream()
                .map(UserModel.class::cast)
                .toList();
    }

    @Override
    public UserModel update(UserModel userModel) {
        getCurrenSession().merge(userModel);
        return userModel;
    }

    @Override
    public void deleteById(Long id) {
        getCurrenSession().remove(findById(id));
    }

    private Session getCurrenSession() {
        return sessionFactory.getCurrentSession();
    }
}
