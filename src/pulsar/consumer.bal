import ballerinax/java;


public type Consumer client object {
private string serviceUrl;
private string topicName;

 public function __init(string serviceUrl,string topicName){
     self.serviceUrl = serviceUrl;
     self.topicName = topicName;
 }


    public remote function newConsumer(string serviceUrl,string topicName,string subscriptionName) returns error?{
       return consumerNewConsumer(self,java:fromString(serviceUrl),java:fromString(topicName),java:fromString(subscriptionName));
   }

   public remote function get() returns handle {
       return consumerGet2(self);
}
};

function consumerNewConsumer(Consumer consumer,handle serviceUrl,handle topicName,handle subscriptionName) returns error? =
         @java:Method {
             name: "newPulsarConsumer",
             class: "org.ballerinalang.messaging.pulsar.NewPulsarConsumer"
    } external;


function consumerGet2(Consumer consumer) returns handle =
             @java:Method {
             name: "get",
             class: "org.ballerinalang.messaging.pulsar.Get"
        } external;

