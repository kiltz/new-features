module timeserver
{
    requires java.logging;
    
    exports com.server;
    exports com.server.internal to privatetimeclient, timeclient;
}