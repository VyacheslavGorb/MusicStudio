package edu.gorb.musicstudio.conroller.command;

public class SessionAttribute {
    public static final String USER = "user";
    public static final String PREV_COMMAND = "previous_command";
    public static final String LOCALE = "locale";
    public static final String ERROR_KEY = "error_key";
    public static final String INFO_KEY = "info_key";

    /* Login error attributes */
    public static final String IS_LOGIN_ERROR = "is_login_error";
    public static final String EMAIL_NOT_CONFIRMED = "email_not_confirmed";

    /* SignUp error attributes */
    public static final String IS_SIGNUP_ERROR = "is_signup_error";

    /* Send email again error attributes*/
    public static final String IS_SEND_EMAIL_AGAIN_ERROR = "is_send_email_again_error";



    private SessionAttribute() {
    }
}