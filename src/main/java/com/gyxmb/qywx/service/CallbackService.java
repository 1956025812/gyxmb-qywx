package com.gyxmb.qywx.service;

import com.gyxmb.qywx.vo.qywxapi.ChangeExternalChatReq;
import com.gyxmb.qywx.vo.qywxapi.ChangeExternalContactReq;

/**
 * <p>
 * 回调SERVICE接口
 * </p>
 *
 * @author DuXueBo
 * @since 2020-04-27 09:39
 */
public interface CallbackService {

    /**
     * 处理添加企业客户事件
     *
     * @param changeExternalContactReq 添加企业客户事件回调参数
     */
    void handleAddExternalContact(ChangeExternalContactReq changeExternalContactReq);


    /**
     * 删除企业客户事件
     *
     * @param changeExternalContactReq 删除企业客户事件回调参数
     */
    void handleDelExternalContact(ChangeExternalContactReq changeExternalContactReq);


    /**
     * 删除跟进成员事件
     *
     * @param changeExternalContactReq 删除跟进成员事件回调参数
     */
    void handleDelFollowUser(ChangeExternalContactReq changeExternalContactReq);


    /**
     * 客户群变更事件
     *
     * @param changeExternalChatReq 客户群变更事件回调参数对象
     */
    void handleChangeExternalChat(ChangeExternalChatReq changeExternalChatReq);

}
