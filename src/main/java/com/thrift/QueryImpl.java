package com.thrift;

import org.apache.thrift.TException;

public class QueryImpl implements com.thrift.TestQry.Iface {
    @Override public com.thrift.QryResult qryTest(int qryCode) throws TException {
        com.thrift.QryResult result = new com.thrift.QryResult();


        if (qryCode == 1) {
            result.code = 1;
            result.msg = "success";
        } else {
            result.code = 0;
            result.msg = "fail";
        }
        System.out.println("recieve from client.....");
        return result;
    }
}
