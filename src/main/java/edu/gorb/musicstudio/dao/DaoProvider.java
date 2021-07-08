package edu.gorb.musicstudio.dao;

import edu.gorb.musicstudio.dao.impl.CommentDaoImpl;
import edu.gorb.musicstudio.dao.impl.UserDaoImpl;

public class DaoProvider {
    private final UserDao userDao = new UserDaoImpl();
    private final CommentDao commentDao = new CommentDaoImpl();

    private DaoProvider() {
    }

    private static class DataProviderHolder {
        private static final DaoProvider instance = new DaoProvider();
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
}