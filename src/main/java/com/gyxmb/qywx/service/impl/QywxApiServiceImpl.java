package com.gyxmb.qywx.service.impl;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSONObject;
import com.gyxmb.qywx.constant.QywxCodeEnum;
import com.gyxmb.qywx.constant.QywxUrlEnum;
import com.gyxmb.qywx.service.QywxApiService;
import com.gyxmb.qywx.util.RedisKeyBuilder;
import com.gyxmb.qywx.util.RedisUtil;
import com.gyxmb.qywx.vo.qywxapi.AccessTokenApiVO;
import com.gyxmb.qywx.vo.qywxapi.DepartmentApiVO;
import com.gyxmb.qywx.vo.qywxapi.DepartmentResultApiVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : DuXueBo
 * @date : 2020-04-12 14:51
 * @ Description :
 */
@Service
@Slf4j
public class QywxApiServiceImpl implements QywxApiService {

    @Value("${qywx.zhenai.corpid}")
    private String qywxZhenaiCorpid;

    @Value("${qywx.zhenai.corpsecret.txl}")
    private String corpsecretTxl;

    @Value("${qywx.zhenai.corpsecret.khlx}")
    private String corpsecretKhlx;

    @Value("${qywx.zhenai.corpsecret.app.kaojin}")
    private String corpsecretAppKaojin;

    @Resource
    private RedisUtil redisUtil;


    @Override
    public String acquireTxlAccessToken() {
        return this.commonAcquireAccessToken(RedisKeyBuilder.getAccessTokenTxl(), this.qywxZhenaiCorpid, this.corpsecretTxl);
    }


    @Override
    public String acquireKhlxAccessToken() {
        return this.commonAcquireAccessToken(RedisKeyBuilder.getAccessTokenKhlx(), this.qywxZhenaiCorpid, this.corpsecretKhlx);
    }


    @Override
    public String acquireAppKaojinAccessToken() {
        return this.commonAcquireAccessToken(RedisKeyBuilder.getAccessTokenAppKaojin(), this.qywxZhenaiCorpid, this.corpsecretAppKaojin);
    }


    @Override
    public List<DepartmentApiVO> selectDepartmentList(Integer deptId) {
        log.info("查询部门ID为：{} 的部门及其子部门列表", deptId);

        String url = String.format(QywxUrlEnum.GET_DEPARTMENT_LIST.getKey(), this.acquireTxlAccessToken(), deptId);
        String result = HttpUtil.get(url);
        log.info("获取部门及其子部门列表返回的调用结果为：{}", result);
        result = result.replaceAll("name_en", "nameEn").replaceAll("parentid", "parentId");
        DepartmentResultApiVO departmentResultApiVO = JSONUtil.toBean(result, DepartmentResultApiVO.class);
        if (null == departmentResultApiVO || !QywxCodeEnum.SUCCESS.getKey().equals(departmentResultApiVO.getErrcode())) {
            log.error("获取部门及其子部门列表失败，参数为：[deptId= {}], 失败信息为：{}", deptId, QywxCodeEnum.acquireValue(departmentResultApiVO.getErrcode()));
            return null;
        }

        return departmentResultApiVO.getDepartment();
    }


    @Override
    public void selectExternalUserInfo(String externalUserId) {
        log.info("进入selectExternalUserInfo方法，参数为：externalUserId= {}", externalUserId);
        if (StringUtils.isEmpty(externalUserId)) {
            return;
        }

        String url = String.format(QywxUrlEnum.GET_EXTERNAL_USER_INFO.getKey(), this.acquireKhlxAccessToken(), externalUserId);
        String result = HttpUtil.get(url);
        log.info("获取外部联系人详情响应结果为:{}", JSONObject.toJSONString(result));


    }


    /**
     * 先从REDIS中获取ACCESS_TOKEN，获取不到再发API请求获取
     *
     * @param accessTokenRedisKey accessToken在redis中存储的key
     * @param corpid              企业ID
     * @param corpsecret          应用SECRET
     * @return ACCESS_TOKEN
     */
    private String commonAcquireAccessToken(String accessTokenRedisKey, String corpid, String corpsecret) {
        String accesstoken;

        accesstoken = this.redisUtil.getStrOfStr(accessTokenRedisKey);
        if (StringUtils.isNotEmpty(accesstoken)) {
            return accesstoken;
        }

        accesstoken = this.acquireAccessToken(corpid, corpsecret);
        this.redisUtil.setString(accessTokenRedisKey, accesstoken, 7200);

        return accesstoken;
    }


    /**
     * 直接调用API获取ACCESS_TOKEN
     *
     * @param corpid     企业ID
     * @param corpsecret 应用的SECRET
     * @return ACCESS_TOKEN
     */
    private String acquireAccessToken(String corpid, String corpsecret) {
        log.info("获取ACCESS_TOKEN,参数为：[corpid= {}， corpsecret= {}]", corpid, corpsecret);

        String url = String.format(QywxUrlEnum.GET_ACCESS_TOKEN.getKey(), corpid, corpsecret);
        String result = HttpUtil.get(url);
        log.info("获取access_token返回的调用结果为：{}", result);

        AccessTokenApiVO accessTokenApiVO = JSONUtil.toBean(result, AccessTokenApiVO.class);
        if (null == accessTokenApiVO || !QywxCodeEnum.SUCCESS.getKey().equals(accessTokenApiVO.getErrcode())) {
            log.error("获取ACCESS_TOKEN失败，参数为：[corpid= {}， corpsecret= {}], 失败信息为：{}", corpid, corpsecret,
                    QywxCodeEnum.acquireValue(accessTokenApiVO.getErrcode()));
            return null;
        }

        return accessTokenApiVO.getAccessToken();
    }
}
