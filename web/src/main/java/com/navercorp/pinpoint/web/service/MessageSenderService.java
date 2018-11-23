package com.navercorp.pinpoint.web.service;

/**
 * message sender service
 *
 * @author: zhao qingyuan
 * @date: 2018-11-23 8:56
 */
public interface MessageSenderService {
    /**
     * send sms
     *
     * @param mobile
     * @param content
     * @return
     */
    boolean smsSend(String mobile, String content);

    /**
     * send email
     *
     * @param email
     * @param content
     * @return
     */
    boolean emailSend(String email, String content);

}
