package simulation;

import io.gatling.http.response.ByteArrayResponseBody;
import io.gatling.http.response.Response;
import io.gatling.javaapi.core.Simulation;
import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class GetAllSimulation extends Simulation {
    HttpProtocolBuilder httpProtocol =
            http.baseUrl("https://restful-booker.herokuapp.com")
                    .acceptHeader("application/json")
                    .contentTypeHeader("application/json")
                    .basicAuth("admin","password123");
FeederBuilder<String> feeder = csv("data/search.csv").random();
    ScenarioBuilder myFirstScenario = scenario("GET ALL")
            .feed(feeder)
            .exec(http("GET ALL").get("/booking")
                    .queryParam("firstname", "#{firstname}")
                    .queryParam("lastname", "#{lastname}")
                    .transformResponse((response, session) -> {

                                if (response.status().code() == 200) {
                                    System.out.println("RESPONSE" + response.body().string());

                                }
                        System.out.println("REQUEST"+response.request());
                                    return response;
                            }).check(status().is(200))
                    )
            .pause(10);

    // Add the setUp block:
    {
        setUp(
                myFirstScenario.injectOpen(constantUsersPerSec(1).during(10))
        ).protocols(httpProtocol);
    }
}
