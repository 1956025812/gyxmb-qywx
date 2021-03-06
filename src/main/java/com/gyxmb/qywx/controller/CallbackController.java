package com.gyxmb.qywx.controller;

import com.alibaba.fastjson.JSONObject;
import com.gyxmb.qywx.constant.CallbackConstant;
import com.gyxmb.qywx.service.CallbackService;
import com.gyxmb.qywx.util.xml.JaxbXmlUtil;
import com.gyxmb.qywx.vo.common.ResultVO;
import com.gyxmb.qywx.vo.qywxapi.CallbackApiVO;
import com.gyxmb.qywx.vo.qywxapi.ChangeExternalChatApiVO;
import com.gyxmb.qywx.vo.qywxapi.ChangeExternalContactApiVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 企业微信回调控制类类
 * </p>
 *
 * @author DuXueBo
 * @since 2020-04-27 09:38
 */
@Api("企业微信回调控制类")
@RestController
@RequestMapping("/callback")
@Slf4j
@EnableAsync
public class CallbackController {

    @Resource
    private CallbackService callbackService;


    @ApiOperation("处理回调")
    @PostMapping("/handle")
    public ResultVO handleCallback(@RequestBody CallbackApiVO callbackApiVO) {
        log.info("接收外部回调，参数为：{}", JSONObject.toJSONString(callbackApiVO));

        try {
            String event = callbackApiVO.getEvent();
            String changeType = callbackApiVO.getChangeType();
            String callbackXml = callbackApiVO.getCallbackXml();

            // 企业客户变更
            if (CallbackConstant.Event.CHANGE_EXTERNAL_CONTACT.getKey().equals(event)) {
                ChangeExternalContactApiVO changeExternalContactApiVO = JaxbXmlUtil.xml2pojo(callbackXml, ChangeExternalContactApiVO.class);

                // 添加企业客户事件(配置了客户联系功能的成员添加外部联系人时，回调该事件)
                if (CallbackConstant.ChangeType.ADD_EXTERNAL_CONTACT.getKey().equals(changeType)) {
                    this.callbackService.handleAddExternalContact(changeExternalContactApiVO);
                    return ResultVO.getSuccess("处理添加企业客户事件成功");
                }

                // 删除企业客户事件
                if (CallbackConstant.ChangeType.DEL_EXTERNAL_CONTACT.getKey().equals(changeType)) {
                    this.callbackService.handleDelExternalContact(changeExternalContactApiVO);
                    return ResultVO.getSuccess("处理删除企业客户事件成功");
                }

                // 删除跟进成员事件
                if (CallbackConstant.ChangeType.DEL_FOLLOW_USER.getKey().equals(changeType)) {
                    this.callbackService.handleDelFollowUser(changeExternalContactApiVO);
                    return ResultVO.getSuccess("处理删除跟进成员事件成功");
                }

            }

            // 客户群变更
            if (CallbackConstant.Event.CHANGE_EXTERNAL_CHAT.getKey().equals(event)) {
                ChangeExternalChatApiVO changeExternalChatApiVO = JaxbXmlUtil.xml2pojo(callbackXml, ChangeExternalChatApiVO.class);
                this.callbackService.handleChangeExternalChat(changeExternalChatApiVO);
            }

        } catch (Exception e) {
            log.error("处理回调失败", e);
        }

        return ResultVO.getSuccess("处理回调成功");
    }


}
