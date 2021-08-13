package edu.gorb.musicstudio.model.dao;

import edu.gorb.musicstudio.entity.Comment;
import edu.gorb.musicstudio.exception.DaoException;

import java.util.List;

public interface CommentDao extends BaseDao<Comment> {
    List<Comment> findActiveCommentsByCourseId(long teacherId) throws DaoException;

    List<Comment> findCommentsByStudentId(long teacherId) throws DaoException;

    void deactivateComment(long commentId) throws DaoException;
}