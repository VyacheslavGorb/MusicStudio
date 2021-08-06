package edu.gorb.musicstudio.model.dao;

import edu.gorb.musicstudio.model.dao.impl.CommentDaoImpl;
import edu.gorb.musicstudio.model.dao.impl.CourseDaoImpl;
import edu.gorb.musicstudio.model.dao.impl.UserDaoImpl;
import edu.gorb.musicstudio.model.dao.impl.UserTokenDaoImpl;

public class DaoProvider {
    private final UserDao userDao = new UserDaoImpl();
    private final CommentDao commentDao = new CommentDaoImpl();
    private final UserTokenDao userTokenDao = new UserTokenDaoImpl();
    private final CourseDao courseDao = new CourseDaoImpl();

    private DaoProvider() {
    }

    public static DaoProvider getInstance() {
        return DataProviderHolder.instance;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public CommentDao getCommentDao() {
        return commentDao;
    }

    public UserTokenDao getUserTokenDao() {
        return userTokenDao;
    }

    public CourseDao getCourseDao() {
        return courseDao;
    }

    private static class DataProviderHolder {
        private static final DaoProvider instance = new DaoProvider();
    }
}