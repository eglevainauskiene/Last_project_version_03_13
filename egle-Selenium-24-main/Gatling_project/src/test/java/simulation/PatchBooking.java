package simulation;

import io.gatling.core.body.StringBody;
import io.gatling.http.response.ByteArrayResponseBody;
import io.gatling.http.response.Response;
import io.gatling.javaapi.core.Simulation;
import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class PatchBooking extends Simulation{
    HttpProtocolBuilder httpProtocol =
            http.baseUrl("https://restful-booker.herokuapp.com")
                    .acceptHeader("application/json")
                    .contentTypeHeader("application/json")
                    .basicAuth("admin","password123");
    FeederBuilder<String> feeder = csv("data/search.csv").random();
    ScenarioBuilder myFirstScenario = scenario("Patch booking")
            .feed(feeder)
            .exec(http("Patch booking").patch("/booking/1")
             .header("Content-type","application/json")
            .body(StringBody("{\"firstname\":\"${firstname}\","+
    "\"lastname\":\"${lastname}\"}"
//    "\"totalprice\":\${total_price},"+
//    "\"depositpaid\":\${deposit_paid},"+
//    "\"bookingdates\":\{"+
//    "\"checkin\":\"${checkin}\","+
//     "\"checkout\":\"${checkout}\"},+
//     "\additionalneeds\":\"${needs}\"}"
    ))

                    .transformResponse((response, session) -> {

                        if (response.status().code() == 200) {
                            System.out.println("RESPONSEaaa" + response.body().string());

                        }
                        System.out.println("REQUEST!!!bbb"+response.request());
                        return response;
                    })
                    .check(status().is(200),
                    jsonPath("$.firstname").ofString(),
                    jsonPath("$.firstname").is("John"),
                   // jsonPath("$.firstname").findAll(),
                    status().not(500)
                   // jsonPath("$[*]").count().is(8)

            ));

            //.pause(10);

    // Add the setUp block:
    {
        setUp(
                myFirstScenario.injectOpen(constantUsersPerSec(1).during(10))
        ).protocols(httpProtocol);
    }
}
