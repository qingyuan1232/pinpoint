/*
 * Copyright 2014 NAVER Corp.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.navercorp.pinpoint.web.alarm;

import com.navercorp.pinpoint.common.util.CollectionUtils;
import com.navercorp.pinpoint.common.util.StringUtils;
import com.navercorp.pinpoint.web.alarm.checker.AlarmChecker;
import com.navercorp.pinpoint.web.config.ExecutorFactory;
import com.navercorp.pinpoint.web.service.MessageSenderService;
import com.navercorp.pinpoint.web.service.UserGroupService;
import com.navercorp.pinpoint.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.concurrent.ExecutorService;

/**
 * @author minwoo.jung
 */
public class EmptyMessageSender implements AlarmMessageSender {

    @Autowired
    MessageSenderService messageSenderService;
    @Autowired
    UserGroupService userGroupService;

    @Override
    public void sendSms(AlarmChecker checker, int sequenceCount) {
        if (StringUtils.isEmpty(checker.getuserGroupId())) {
            return;
        }

        List<String> phones = userGroupService.selectPhoneNumberOfMember(checker.getuserGroupId());
        if (CollectionUtils.isEmpty(phones)) {
            return;
        }

        //asyn send
        ExecutorService service = ExecutorFactory.getInstance();
        for (String phone : phones) {
            List<String> messages = checker.getSmsMessage();
            for (String message : messages) {
                service.submit(new Runnable() {
                    @Override
                    public void run() {
                        messageSenderService.smsSend(phone, message);
                    }
                });
            }

        }

    }

    @Override
    public void sendEmail(AlarmChecker checker, int sequenceCount) {
        if (StringUtils.isEmpty(checker.getuserGroupId())) {
            return;
        }

        List<String> emails = userGroupService.selectEmailOfMember(checker.getuserGroupId());
        if (CollectionUtils.isEmpty(emails)) {
            return;
        }

        //asyn send
        ExecutorService service = ExecutorFactory.getInstance();
        for (String phone : emails) {
            service.submit(new Runnable() {
                @Override
                public void run() {
                    messageSenderService.smsSend(phone, checker.getEmailMessage());
                }
            });

        }
    }

}
