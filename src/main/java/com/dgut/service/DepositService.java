package com.dgut.service;

import com.dgut.entity.Deposit;
import com.dgut.entity.DepositExample;

import java.util.List;

public interface DepositService extends BaseService<Deposit, DepositExample>{

	//根据充值人身份和充值人id查询所有的充值记录
	List<Deposit> selectAllDeposit(Integer organiser, Integer id);

}
