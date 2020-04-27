package com.gyxmb.qywx.constant;

/**
 * 回调的常量接口
 */
public interface CallbackConstant {


    /**
     * 事件类型
     */
    enum Event implements CallbackConstant {

        /**
         * change_external_contact-外部联系人变更事件
         */
        CHANGE_EXTERNAL_CONTACT("change_external_contact", "外部联系人变更事件"),

        /**
         * change_external_chat-客户群变更事件
         */
        CHANGE_EXTERNAL_CHAT("change_external_chat", "客户群变更事件"),

        ;

        private String key;
        private String value;

        Event(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }
    }


    /**
     * ChangeType类型
     */
    enum ChangeType implements CallbackConstant {

        /**
         * add_external_contact-添加企业客户事件
         */
        ADD_EXTERNAL_CONTACT("add_external_contact", "添加企业客户事件"),

        /**
         * add_half_external_contact-外部联系人免验证添加成员事件
         */
        ADD_HALF_EXTERNAL_CONTACT("add_half_external_contact", "外部联系人免验证添加成员事件"),

        /**
         * del_external_contact-删除企业客户事件
         */
        DEL_EXTERNAL_CONTACT("del_external_contact", "删除企业客户事件"),

        /**
         * del_follow_user-删除跟进成员事件
         */
        DEL_FOLLOW_USER("del_follow_user", "删除跟进成员事件"),
        ;

        private String key;
        private String value;

        ChangeType(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }
    }

}
