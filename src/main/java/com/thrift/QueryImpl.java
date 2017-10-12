package com.thrift;

import com.thrift.generate.QryResult;
import com.thrift.generate.TsetQry;
import org.apache.thrift.TException;

public class QueryImpl implements TsetQry.Iface {
    @Override public QryResult qryTest(int qryCode) throws TException {
        QryResult result = new QryResult();


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
