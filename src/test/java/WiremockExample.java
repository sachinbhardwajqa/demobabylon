import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

public class WiremockExample {
    public static void main(String[] args){
        WireMockServer wireMockServer = new WireMockServer(wireMockConfig().port(8089)); //No-args constructor will start on port 8080, no HTTPS
        wireMockServer.start();
// Do some stuff
        WireMock.configureFor("wiremock.host", 8089);

        WireMock.reset();

// Finish doing stuff

        wireMockServer.stop();
    }

    /*
    * Download the stand alone jar from
    * https://repo1.maven.org/maven2/com/github/tomakehurst/wiremock-jre8-standalone/2.35.0/wiremock-jre8-standalone-2.35.0.jar
    *
    * Create the required directory and place downloaded jar in it
    * Navigate to required directory in terminal and run below commnad
    *
    * java -jar wiremock-jre8-standalone-2.35.0.jar --port 8082
    * --help: Show command line help
    *
    * When the WireMock server starts it creates two directories under the current one: mappings and __files.
    *
    * To create a stub like the one above by this method,
    * drop a file with a .json extension under mappings with the following content:
        {
            "request": {
                "method": "GET",
                "url": "/api/mytest"
            },
            "response": {
                "status": 200,
                "body": "More content\n"
            }
        }
     * After restarting the server we should be able to do this:
     * $ curl http://localhost:8080/api/mytest
     * More content
    *
    * JSON files containing multiple stub mappings can also be used. These are of the form:

        {
            "mappings": [
                {
                    "request": {
                        "method": "GET",
                        "url": "/one"
                    },
                    "response": {
                        "status": 200
                    }
                },
                {
                    "id": "8c5db8b0-2db4-4ad7-a99f-38c9b00da3f7",
                    "request": {
                        "url": "/two"
                    },
                    "response": {
                        "body": "Updated"
                    }
                }
            ]
        }
    *
    *
    * Push a collection of stub mappings and associated files to a remote WireMock
    * or WireMock Cloud instance via the Java API as follows:

        WireMock wireMock = WireMock.create()
            .scheme("http")
            .host("my-wiremock.example.com")
            .port(80)
            .build();

        // The root directory of the WireMock project, under which the mappings and __files directories should be found
        *

        wireMock.loadMappingsFrom("/wiremock-stuff");

        * File serving
        When running the standalone JAR,
        * files placed under the __files directory will be served up as if from under the docroot,
        * except if stub mapping matching the URL exists.
        *
        * For example if a file exists __files/things/myfile.html
        * and no stub mapping will match /things/myfile.html
        * then hitting http://<host>:<port>/things/myfile.html will serve the file.
    * */
}
