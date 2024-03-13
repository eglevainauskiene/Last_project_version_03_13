package simulation;

import io.gatling.javaapi.core.Simulation;
import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;

public class GetBookingsSimulation extends Simulation {

    HttpProtocolBuilder httpProtocol =
            http.baseUrl("https://restful-booker.herokuapp.com")
                    .acceptHeader("application/json")
                    .contentTypeHeader("application/json")
                    .basicAuth("admin","password123");

    ScenarioBuilder myFirstScenario = scenario("GET bookings")
            .exec(http("GET").get("/booking/")

                    .check(status().is(200))
                    .check(bodyString().saveAs("responseBody")))
            .exec(session -> {
                System.out.println("Response Body:");
                System.out.println(session.getString("responseBody"));
                return session;
            });
    // Add the setUp block:
    {
        setUp(
                myFirstScenario.injectOpen(rampUsers(10).during(5))
        ).protocols(httpProtocol);
    }
}