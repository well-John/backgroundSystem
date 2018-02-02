package com.dgut.dao;

import com.dgut.entity.Deposit;
import com.dgut.entity.DepositExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepositMapper extends BaseMapper<Deposit, DepositExample>{
    long countByExample(DepositExample example);

    int deleteByExample(DepositExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Deposit record);

    int insertSelective(Deposit record);

    List<Deposit> selectByExample(DepositExample example);

    Deposit selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Deposit record, @Param("example") DepositExample example);

    int updateByExample(@Param("record") Deposit record, @Param("example") DepositExample example);

    int updateByPrimaryKeySelective(Deposit record);

    int updateByPrimaryKey(Deposit record);
}