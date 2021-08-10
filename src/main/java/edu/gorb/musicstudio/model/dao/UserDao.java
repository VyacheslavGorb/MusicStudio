package edu.gorb.musicstudio.model.dao;

import edu.gorb.musicstudio.entity.User;
import edu.gorb.musicstudio.entity.UserStatus;
import edu.gorb.musicstudio.exception.DaoException;

import java.util.List;
import java.util.Optional;

public interface UserDao extends BaseDao<User> {
    List<User> findUsersByStatus(UserStatus status) throws DaoException;

    Optional<User> findUserByLogin(String login) throws DaoException;

    Optional<User> findUserByEmail(String email) throws DaoException;

    void updateUserStatus(long userId, UserStatus userStatus) throws DaoException;

    List<User> selectTeachersForPage(int skipAmount, int coursePerPageAmount) throws DaoException;

    int countTeachers() throws DaoException;

    List<User> selectTeachersWithSearchForPage(int skipAmount, int coursePerPageAmount, String search) throws DaoException;

    int countTeachersWithSearch(String searchParameter) throws DaoException;

    List<User> selectTeachersForCourse(long courseId) throws DaoException;
}
