package com.gyxmb.qywx.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.gyxmb.qywx.service.CallbackService;
import com.gyxmb.qywx.vo.qywxapi.ChangeExternalChatReq;
import com.gyxmb.qywx.vo.qywxapi.ChangeExternalContactReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * <p>
 *
 * </p>
 *
 * @author DuXueBo
 * @since 2020-04-27 09:39
 */
@Service
@Slf4j
public class CallbackServiceImpl implements CallbackService {


    @Async
    @Override
    public void handleAddExternalContact(ChangeExternalContactReq changeExternalContactReq) {
        log.info("处理添加外部联系人事件回调，参数为：{}", JSONObject.toJSONString(changeExternalContactReq));
    }


    @Async
    @Override
    public void handleDelExternalContact(ChangeExternalContactReq changeExternalContactReq) {
        log.info("处理删除企业客户事件事件回调，参数为：{}", JSONObject.toJSONString(changeExternalContactReq));
    }


    @Async
    @Override
    public void handleDelFollowUser(ChangeExternalContactReq changeExternalContactReq) {
        log.info("处理删除跟进成员事件事件事件回调，参数为：{}", JSONObject.toJSONString(changeExternalContactReq));

    }


    @Async
    @Override
    public void handleChangeExternalChat(ChangeExternalChatReq changeExternalChatReq) {
        log.info("处理群变更回调，参数为：{}", JSONObject.toJSONString(changeExternalChatReq));
    }
}
