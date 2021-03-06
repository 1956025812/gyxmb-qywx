package com.gyxmb.qywx.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.gyxmb.qywx.service.CallbackService;
import com.gyxmb.qywx.service.QywxApiService;
import com.gyxmb.qywx.vo.qywxapi.ChangeExternalChatApiVO;
import com.gyxmb.qywx.vo.qywxapi.ChangeExternalContactApiVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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

    @Resource
    private QywxApiService qywxApiService;

    @Async
    @Override
    public void handleAddExternalContact(ChangeExternalContactApiVO changeExternalContactApiVO) {
        log.info("处理添加外部联系人事件回调，参数为：{}", JSONObject.toJSONString(changeExternalContactApiVO));
        this.qywxApiService.selectExternalUserInfo(changeExternalContactApiVO.getExternalUserID());
    }


    @Async
    @Override
    public void handleDelExternalContact(ChangeExternalContactApiVO changeExternalContactApiVO) {
        log.info("处理删除企业客户事件事件回调，参数为：{}", JSONObject.toJSONString(changeExternalContactApiVO));
    }


    @Async
    @Override
    public void handleDelFollowUser(ChangeExternalContactApiVO changeExternalContactApiVO) {
        log.info("处理删除跟进成员事件事件事件回调，参数为：{}", JSONObject.toJSONString(changeExternalContactApiVO));

    }


    @Async
    @Override
    public void handleChangeExternalChat(ChangeExternalChatApiVO changeExternalChatApiVO) {
        log.info("处理群变更回调，参数为：{}", JSONObject.toJSONString(changeExternalChatApiVO));
    }
}
