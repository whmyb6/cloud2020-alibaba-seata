package com.mywhm.springcloud.service.impl;

import com.mywhm.springcloud.dao.AccountDao;
import com.mywhm.springcloud.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountDao accountDao;
    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("------------->account.service 开始扣减余额....");
//        try {
//            TimeUnit.SECONDS.sleep(12);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        accountDao.decrease(userId, money);
        log.info("------------->account.service 扣减账户余额完成！");
    }
}
