package edu.gorb.musicstudio.controller.command.impl.admin;

import edu.gorb.musicstudio.controller.command.Command;
import edu.gorb.musicstudio.controller.command.CommandResult;
import edu.gorb.musicstudio.controller.command.PagePath;
import edu.gorb.musicstudio.controller.command.RequestParameter;
import edu.gorb.musicstudio.entity.Course;
import edu.gorb.musicstudio.exception.ServiceException;
import edu.gorb.musicstudio.model.service.CourseService;
import edu.gorb.musicstudio.model.service.ServiceProvider;
import edu.gorb.musicstudio.validator.IntegerNumberValidator;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class DeactivateCourseCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest request) {
        String courseIdParameter = request.getParameter(RequestParameter.COURSE_ID);
        if (!IntegerNumberValidator.isNonNegativeIntegerNumber(courseIdParameter)) {
            return new CommandResult(PagePath.ERROR_404_PAGE, CommandResult.RoutingType.REDIRECT);
        }
        long courseId = Long.parseLong(courseIdParameter);
        CourseService courseService = ServiceProvider.getInstance().getCourseService();
        try {
            Optional<Course> courseOptional = courseService.findCourseById(courseId);
            if (courseOptional.isEmpty()) {
                return new CommandResult(PagePath.ERROR_404_PAGE, CommandResult.RoutingType.REDIRECT);
            }
            Course course = courseOptional.get();
            course.setActive(false);
            courseService.updateCourse(course);
        } catch (ServiceException e) {
            return new CommandResult(PagePath.ERROR_500_PAGE, CommandResult.RoutingType.REDIRECT);
        }
        return new CommandResult(PagePath.ALL_COURSES_REDIRECT, CommandResult.RoutingType.REDIRECT);
    }
}
