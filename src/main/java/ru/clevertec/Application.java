package ru.clevertec;

import io.camunda.zeebe.client.ZeebeClient;
import io.camunda.zeebe.client.api.response.DeploymentEvent;
import io.camunda.zeebe.client.api.response.ProcessInstanceEvent;
import io.camunda.zeebe.spring.client.EnableZeebeClient;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Duration;
import java.util.Map;

@SpringBootApplication
@EnableZeebeClient
@RequiredArgsConstructor
public class Application implements CommandLineRunner {

    private final ZeebeClient client;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //deploy process
//        DeploymentEvent event = client.newDeployResourceCommand()
//                .addResourceFile("D:\\camunda\\trainer023.bpmn")
////                .addResourceFromClasspath("intermsg_01.bpmn")
//                .send()
//                .join();
//        long processDefinitionKey = event.getProcesses().get(0).getProcessDefinitionKey();
//        System.out.println("processDefinitionKey " + processDefinitionKey);

        //Проверить, что процесс задеплоин можно через REST API Operate
        //http://93.84.86.69:9081/swagger-ui/index.html#/Process/byKey_2
        //http://localhost:8081/swagger-ui/index.html#/Process/byKey_2

        //start diagram
//        ProcessInstanceEvent event = client.newCreateInstanceCommand()
//                .bpmnProcessId("trainerID023")
////                .version(3)
//                .latestVersion()
//                .variables(Map.of("key", 123))
//                .send().join();
//        System.out.println("ProcessDefinitionKey " + event.getProcessDefinitionKey());
//        System.out.println("BpmnProcessId " + event.getBpmnProcessId());
//        System.out.println("Version " + event.getVersion());
//        System.out.println("ProcessInstanceKey " + event.getProcessInstanceKey());


        //stop process
        long processInstanceKey = 2251799813772745L;
        client.newCancelInstanceCommand(processInstanceKey).send().join();

        //publish message
//        client.newPublishMessageCommand()
//                .messageName("intermsg_01")
//                .correlationKey("100")
//                .timeToLive(Duration.ZERO)
//                .send()
//                .join();
    }
}
