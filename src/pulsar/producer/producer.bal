import ballerinax/java;

public type Producer client object {
private string serviceUrl;
private string topicName;

 public function __init(string serviceUrl,string topicName){
     self.serviceUrl = serviceUrl;
     self.topicName = topicName;
 }


    public remote function newProducer(string serviceUrl,string topicName) returns error?{
       return producerNewProducer(self,java:fromString(serviceUrl),java:fromString(topicName));
   }

   public remote function send(string val) returns error? {
       return producerSend(self,java:fromString(val));
}
};

function producerNewProducer(Producer producer,handle serviceUrl,handle topicName) returns error? =
         @java:Method {
             name: "newPulsarProducer",
             class: "org.ballerinalang.messaging.pulsar.NewPulsarProducer"
    } external;

# Description
#
# + producer - producer Parameter Description
# + data - data Parameter Description
# + return - Return Value Description
function producerSend(Producer producer, handle data) returns error? =
             @java:Method {
             name: "send",
             class: "org.ballerinalang.messaging.pulsar.Send"
        } external;
