package edu.gorb.musicstudio.controller.command.impl;

import edu.gorb.musicstudio.controller.command.Command;
import edu.gorb.musicstudio.controller.command.CommandResult;
import edu.gorb.musicstudio.controller.command.PagePath;
import edu.gorb.musicstudio.controller.command.SessionAttribute;

import javax.servlet.http.HttpServletRequest;

public class LogoutCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest request) {
        request.getSession().removeAttribute(SessionAttribute.USER);
        return new CommandResult(PagePath.HOME_PAGE_REDIRECT, CommandResult.RoutingType.REDIRECT);
    }
}
