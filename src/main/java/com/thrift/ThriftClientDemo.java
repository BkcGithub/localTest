package com.thrift;

import org.apache.http.HttpVersion;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.BasicClientConnectionManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.params.HttpConnectionParams;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.THttpClient;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import sun.jvm.hotspot.HelloWorld;

public class ThriftClientDemo {
    private static final int DEFFAULT_QRY_CODE = 1;
    private static final int DEFAULT_PORT = 8081;
    private static final String HOST = "172.16.103.230";
    private static final int TIME_OUT = 5000;

    public static void main(String[] args) {

        /*try {
            TTransport tTransport = getTTransport();

            TProtocol tProtocol = new TBinaryProtocol(tTransport);

            com.thrift.TestQry.Client client =new com.thrift.TestQry.Client(tProtocol);
            com.thrift.QryResult result = client.qryTest(DEFFAULT_QRY_CODE);

            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        String url = "http://127.0.0.1:8080/bkc/testQry";

        BasicHttpParams params = new BasicHttpParams();
        params.setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
        params.setParameter(CoreProtocolPNames.HTTP_CONTENT_CHARSET, "UTF-8");
        // Disable Expect-Continue
        params.setParameter(CoreProtocolPNames.USE_EXPECT_CONTINUE, false);
        // Enable staleness check
        params.setParameter("http.connection.stalecheck", true);
        HttpConnectionParams.setSoTimeout(params, 10000); // 10 secondes
        HttpConnectionParams.setConnectionTimeout(params, 10000); // 10 secondes

        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", 8080, PlainSocketFactory.getSocketFactory()));
        schemeRegistry.register(new Scheme("https", 443, SSLSocketFactory.getSocketFactory()));
        BasicClientConnectionManager cm = new BasicClientConnectionManager(schemeRegistry);
        THttpClient thc = null;
        try {
            thc = new THttpClient(url, new DefaultHttpClient(cm, params));
            TProtocol loPFactory = new TCompactProtocol(thc);
            TestQry.Client client = new TestQry.Client(loPFactory);
            System.out.println(client.qryTest(2));
        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (TException e) {
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
