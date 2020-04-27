package com.gyxmb.qywx.service;

import com.gyxmb.qywx.vo.qywxapi.ChangeExternalChatApiVO;
import com.gyxmb.qywx.vo.qywxapi.ChangeExternalContactApiVO;

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
     * @param changeExternalContactApiVO 添加企业客户事件回调参数
     */
    void handleAddExternalContact(ChangeExternalContactApiVO changeExternalContactApiVO);


    /**
     * 删除企业客户事件
     *
     * @param changeExternalContactApiVO 删除企业客户事件回调参数
     */
    void handleDelExternalContact(ChangeExternalContactApiVO changeExternalContactApiVO);


    /**
     * 删除跟进成员事件
     *
     * @param changeExternalContactApiVO 删除跟进成员事件回调参数
     */
    void handleDelFollowUser(ChangeExternalContactApiVO changeExternalContactApiVO);


    /**
     * 客户群变更事件
     *
     * @param changeExternalChatApiVO 客户群变更事件回调参数对象
     */
    void handleChangeExternalChat(ChangeExternalChatApiVO changeExternalChatApiVO);

}
