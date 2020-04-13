package com.gyxmb.qywx;

import com.gyxmb.qywx.service.QywxApiService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class QywxApplicationTests {

    @Value("${qywx.zhenai.corpid}")
    private String qywxZhenaiCorpid;

    @Value("${qywx.zhenai.corpsecret.gyxmb.yuJian}")
    private String corpsecretYuJian;

    @Autowired
    private QywxApiService qywxApiService;


    @Test
    void contextLoads() {

        String accessToken = this.qywxApiService.acquireYujianAccessToken();
        log.info(accessToken);
    }

}
