package com.ujiuye.cust.service;

import com.ujiuye.cust.bean.Customer;
import com.ujiuye.cust.bean.CustomerExample;
import com.ujiuye.cust.mapper.CustomerMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Resource
    private CustomerMapper customerMapper;


    public void getInfo(Customer customer) {
        customerMapper.insert(customer);
    }

    public List<Customer> showCustomerList() {
        List<Customer> customers = customerMapper.selectByExample(new CustomerExample());
        return customers;
    }

    public Customer getCustomerDetail(Integer cid) {
        Customer customer = customerMapper.selectByPrimaryKey(cid);
        return customer;
    }

    public void updateCustomer(Customer customer) {
        customerMapper.updateByPrimaryKeySelective(customer);
    }

    public boolean batchDelete(Integer[] ids) {
        List<Integer> idList = Arrays.asList(ids);
        CustomerExample example = new CustomerExample();
        CustomerExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(idList);
        int i = customerMapper.deleteByExample(example);
        return ids.length == i;
    }

    public List<Customer> search(Integer cid, String keyword, Integer orderby) {
        CustomerExample example = new CustomerExample();
        CustomerExample.Criteria criteria = example.createCriteria();
        if(cid == 0){
            criteria.andComnameLike("%"+keyword+"%");
            CustomerExample.Criteria criteria1 = example.createCriteria();
            criteria1.andCompanypersonLike("%"+keyword+"%");
            example.or(criteria1);
        }else if(cid == 1){
            criteria.andComnameLike("%"+keyword+"%");
        }else {
            criteria.andCompanypersonLike("%"+keyword+"%");
        }
        if (orderby == 1){
            example.setOrderByClause("id desc");
        }

        List<Customer> customers = customerMapper.selectByExample(example);
        return customers;
    }
}
