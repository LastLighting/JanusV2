package topprogersgroup.ws.endpoint;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import localhost.types.foreignsystem.ObjectFactory;
import localhost.types.foreignsystem.StatusFromForeignSystem;
import localhost.types.foreignsystem.VeterinaryCertificate;


import java.util.Random;

@Endpoint
public class ForeignSystemEndpoint {

    @PayloadRoot(namespace = "http://localhost/types/foreignSystem", localPart = "VeterinaryCertificate")
    @ResponsePayload
    public StatusFromForeignSystem setVeterinaryCertificateStatus(@RequestPayload VeterinaryCertificate certificate) {
        ObjectFactory factory = new ObjectFactory();
        StatusFromForeignSystem response = factory.createStatusFromForeignSystem();
        response.setStatus(getRandomStatus());
        return response;
    }

    public String getRandomStatus() {
        Random random = new Random();
        int value = random.nextInt(100);
        if (value < 50) return "Confirmed";
        else if (value >= 50 && value < 60) return "Rejected";
        else if (value >= 95 && value < 100) return "Fuck you, russians";
        else return ""; // забыли просмотреть
    }
}
