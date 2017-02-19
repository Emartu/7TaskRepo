package com.epam.page_object.business_objects;

public class MailData {

    private static String password;
    private static String login;
    private static String to;
    private static String subject;
    private static String mailBody;

    public MailData(String login, String password, String to, String subject, String mailBody) {
        this.login = login;
        this.password = password;
        this.to = to;
        this.subject = subject;
        this.mailBody = mailBody;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        MailData.password = password;
    }

    public static String getLogin() {
        return login;
    }

    public static void setLogin(String login) {
        MailData.login = login;
    }

    public static String getTo() {
        return to;
    }

    public static void setTo(String to) {
        MailData.to = to;
    }

    public static String getSubject() {
        return subject;
    }

    public static void setSubject(String subject) {
        MailData.subject = subject;
    }

    public static String getMailBody() {
        return mailBody;
    }

    public static void setMailBody(String mailBody) {
        MailData.mailBody = mailBody;
    }
}
