package com.thrift;

import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TNonblockingServerSocket;

public class ThriftServerDemo {
    private static final int DEFAULT_PORT = 8181;

    private static TServer server = null;


    public static void main(String[] args) {
        try {
            TNonblockingServerSocket socket = new TNonblockingServerSocket(DEFAULT_PORT);

            com.thrift.TestQry.Processor processor = new com.thrift.TestQry.Processor(new QueryImpl());

            TNonblockingServer.Args arg = new TNonblockingServer.Args(socket);

            arg.protocolFactory(new TBinaryProtocol.Factory());

            arg.processorFactory(new TProcessorFactory(processor));

            server = new TNonblockingServer(arg);

            server.serve();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
