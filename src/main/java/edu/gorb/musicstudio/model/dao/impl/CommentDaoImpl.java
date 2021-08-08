package edu.gorb.musicstudio.model.dao.impl;

import edu.gorb.musicstudio.entity.Comment;
import edu.gorb.musicstudio.exception.DaoException;
import edu.gorb.musicstudio.model.dao.CommentDao;
import edu.gorb.musicstudio.model.dao.JdbcHelper;
import edu.gorb.musicstudio.model.dao.mapper.impl.CommentRowMapperImpl;
import edu.gorb.musicstudio.model.pool.ConnectionPool;

import java.util.List;
import java.util.Optional;

public class CommentDaoImpl implements CommentDao {

    public static final String INSERT_NEW_COMMENT =
            "INSERT INTO comments (id_student, id_course, content, date_time) VALUE (?, ?, ?, ?)";

    public static final String UPDATE_COMMENT = "UPDATE comments\n" +
            "SET id_student=?,\n" +
            "    id_course=?,\n" +
            "    content=?,\n" +
            "    date_time=?\n" +
            "WHERE id_comment = ?";

    private static final String SELECT_ALL_COMMENTS =
            "SELECT id_comment, id_student, id_course, content, date_time\n" +
                    "FROM comments\n" +
                    "ORDER BY date_time DESC";

    private static final String SELECT_COMMENT_BY_ID =
            "SELECT id_comment, id_student, id_course, content, date_time\n" +
                    "FROM comments\n" +
                    "WHERE id_comment=?";

    private static final String SELECT_COMMENTS_BY_COURSE_ID =
            "SELECT id_comment, id_student, id_course, content, date_time\n" +
                    "FROM comments\n" +
                    "WHERE id_course=?\n" +
                    "ORDER BY date_time DESC";

    private static final String SELECT_COMMENTS_BY_STUDENT_ID =
            "SELECT id_comment, id_student, id_course, content, date_time\n" +
                    "FROM comments\n" +
                    "WHERE id_student=?\n" +
                    "ORDER BY date_time DESC";

    private final JdbcHelper<Comment> jdbcHelper;

    public CommentDaoImpl() {
        jdbcHelper = new JdbcHelper<>(ConnectionPool.getInstance(), new CommentRowMapperImpl());
    }

    @Override
    public List<Comment> findAll() throws DaoException {
        return jdbcHelper.executeQuery(SELECT_ALL_COMMENTS);
    }

    @Override
    public Optional<Comment> findEntityById(long id) throws DaoException {
        return jdbcHelper.executeQueryForSingleResult(SELECT_COMMENT_BY_ID, id);
    }

    @Override
    public int insert(Comment comment) throws DaoException {
        return jdbcHelper.executeInsert(INSERT_NEW_COMMENT,
                comment.getStudentId(),
                comment.getCourseId(),
                comment.getContent(),
                comment.getDateTime());
    }

    @Override
    public void update(Comment comment) throws DaoException {
        jdbcHelper.executeUpdate(UPDATE_COMMENT,
                comment.getStudentId(),
                comment.getCourseId(),
                comment.getContent(),
                comment.getDateTime(),
                comment.getId());
    }

    @Override
    public List<Comment> findCommentsByCourseId(long courseId) throws DaoException {
        return jdbcHelper.executeQuery(SELECT_COMMENTS_BY_COURSE_ID, courseId);
    }

    @Override
    public List<Comment> findCommentsByStudentId(long studentId) throws DaoException {
        return jdbcHelper.executeQuery(SELECT_COMMENTS_BY_STUDENT_ID, studentId);
    }
}
