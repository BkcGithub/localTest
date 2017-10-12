package com.thrift;

import com.thrift.generate.QryResult;
import com.thrift.generate.TsetQry;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

public class ThriftClientDemo {
    private static final int DEFFAULT_QRY_CODE = 1;
    private static final int DEFAULT_PORT = 8181;
    private static final String HOST = "127.0.0.1";
    private static final int TIME_OUT = 5000;

    public static void main(String[] args) {

        try {
            TTransport tTransport = getTTransport();

            TProtocol tProtocol = new TBinaryProtocol(tTransport);

            TsetQry.Client client =new TsetQry.Client(tProtocol);
            QryResult result = client.qryTest(DEFFAULT_QRY_CODE);

            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static TTransport getTTransport() throws Exception {

        try {

            TTransport tTransport = getTTansport(HOST, DEFAULT_PORT, TIME_OUT);
            if (!tTransport.isOpen()) {
                tTransport.open();
            }
            return tTransport;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    private static TTransport getTTansport(String host, int port, int timeout) {
        final TSocket tSocket = new TSocket(host, port, timeout);
        final TTransport transport = new TFramedTransport(tSocket);
        return transport;
    }
}
