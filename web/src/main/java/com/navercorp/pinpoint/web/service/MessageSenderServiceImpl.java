package com.navercorp.pinpoint.web.service;

import org.springframework.stereotype.Service;

/**
 * @author: zhao qingyuan
 * @date: 2018-11-23 8:57
 */
@Service
public class MessageSenderServiceImpl implements MessageSenderService {

    @Override
    public boolean smsSend(String mobile, String content) {
        return false;
    }

    @Override
    public boolean emailSend(String email, String content) {
        return false;
    }
}
