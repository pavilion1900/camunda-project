package ru.clevertec;

import io.camunda.zeebe.client.ZeebeClient;
import io.camunda.zeebe.client.api.response.DeploymentEvent;
import io.camunda.zeebe.spring.client.EnableZeebeClient;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
        //deploy
        //check http://93.84.86.69:9081/swagger-ui/index.html#/Process/byKey_2
        DeploymentEvent event = client.newDeployResourceCommand()
                .addResourceFromClasspath("diagram_01.bpmn")
                .send()
                .join();
        long processDefinitionKey = event.getProcesses().get(0).getProcessDefinitionKey();
        System.out.println("processDefinitionKey " + processDefinitionKey);

        //start diagram
//        ProcessInstanceEvent event = client.newCreateInstanceCommand()
//                .bpmnProcessId("s_korolenkoID01")
//                .latestVersion()
//                .variables(Map.of("key", 123))
//                .send().join();
//        System.out.println("ProcessDefinitionKey " + event.getProcessDefinitionKey());
//        System.out.println("BpmnProcessId " + event.getBpmnProcessId());
//        System.out.println("Version " + event.getVersion());
//        System.out.println("ProcessInstanceKey " + event.getProcessInstanceKey());
    }
}
