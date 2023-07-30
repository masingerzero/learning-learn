package org.masingerzero.testcontainer;

import org.junit.jupiter.api.Test;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.output.OutputFrame;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.util.function.Consumer;

@Testcontainers
public class WaitStrategyIT {

    @Container
    private static GenericContainer<?> nginxWithHttpWait = new GenericContainer<>(DockerImageName.parse("nginx:1.9.4"))
                .withExposedPorts(80)
                .waitingFor(Wait.forHttp("/")
                        .forStatusCode(200));




    @Test
    void test() {
        System.out.println(nginxWithHttpWait.getExposedPorts());
    }
}
