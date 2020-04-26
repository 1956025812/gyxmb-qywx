package com.gyxmb.qywx.service.impl;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.gyxmb.qywx.constant.QywxCodeEnum;
import com.gyxmb.qywx.constant.QywxUrlEnum;
import com.gyxmb.qywx.service.QywxApiService;
import com.gyxmb.qywx.util.RedisKeyBuilder;
import com.gyxmb.qywx.util.RedisUtil;
import com.gyxmb.qywx.vo.qywxapi.AccessTokenApiVO;
import com.gyxmb.qywx.vo.qywxapi.DepartmentApiResultVO;
import com.gyxmb.qywx.vo.qywxapi.DepartmentApiVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

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

    @Value("${qywx.zhenai.corpsecret.gyxmb.kaojin}")
    private String corpsecretKaojin;

    @Autowired
    private RedisUtil redisUtil;


    @Override
    public String acquireKaojinAccessToken() {
        return this.commonAcquireAccessToken(RedisKeyBuilder.getAccessTokenKaojin(), this.qywxZhenaiCorpid, this.corpsecretKaojin);
    }


    @Override
    public List<DepartmentApiVO> selectDepartmentList(Integer deptId) {
        log.info("查询部门ID为：{} 的部门及其子部门列表", deptId);

        String url = String.format(QywxUrlEnum.GET_DEPARTMENT_LIST.getKey(), this.acquireKaojinAccessToken(), deptId);
        String result = HttpUtil.get(url);
        log.info("获取部门及其子部门列表返回的调用结果为：{}", result);
        result = result.replaceAll("name_en", "nameEn").replaceAll("parentid", "parentId");
        DepartmentApiResultVO departmentApiResultVO = JSONUtil.toBean(result, DepartmentApiResultVO.class);
        if (null == departmentApiResultVO || !QywxCodeEnum.SUCCESS.getKey().equals(departmentApiResultVO.getErrcode())) {
            log.error("获取部门及其子部门列表失败，参数为：[deptId= {}], 失败信息为：{}", deptId, QywxCodeEnum.acquireValue(departmentApiResultVO.getErrcode()));
            return null;
        }

        return departmentApiResultVO.getDepartment();
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
        this.redisUtil.setString(RedisKeyBuilder.getAccessTokenKaojin(), accesstoken, 7200);

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
