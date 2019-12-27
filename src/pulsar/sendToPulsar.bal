import ballerina/io;
import ballerinax/pulsar;

// pulsar service url
string serviceUrl = "";
// pulsar topic name
string topicName = "";

public function main() {
pulsar:Producer producer = new(serviceUrl,topicName);

    io:println("Hello, Start!");
    var msg = "Hi Stephen!";
    error? a = producer->newProducer(serviceUrl,topicName);
    io:println("Hello, new producer!");
    error? ret = producer->send(msg);

    io:println("Hello, send!");
    io:println("Hello, END!");
}
