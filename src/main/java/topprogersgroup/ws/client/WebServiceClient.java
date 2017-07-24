package topprogersgroup.ws.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;
import topprogersgroup.entity.VeterinaryCertificate;
import localhost.types.foreignsystem.ObjectFactory;
import localhost.types.foreignsystem.StatusFromForeignSystem;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.GregorianCalendar;

@Component
public class WebServiceClient {

    @Autowired
    private WebServiceTemplate webServiceTemplate;

    public String getVeterinaryCertificateStatus(VeterinaryCertificate veterinaryCertificate) throws DatatypeConfigurationException {
        ObjectFactory objectFactory = new ObjectFactory();
        localhost.types.foreignsystem.VeterinaryCertificate veterinaryCertificateWS = objectFactory.createVeterinaryCertificate();
        veterinaryCertificateWS.setCertificateId(veterinaryCertificate.getId());
        veterinaryCertificateWS.setCertificateNumber(veterinaryCertificate.getNumber());
        veterinaryCertificateWS.setVeterinaryDocumentNumber(veterinaryCertificate.getVeterinaryDocument().getNumber());
        veterinaryCertificateWS.setRegistrationPlace(veterinaryCertificate.getRegistrationPlace());
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(veterinaryCertificate.getIssueDate());
        XMLGregorianCalendar dateXML = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
        veterinaryCertificateWS.setIssueDate(dateXML);
        veterinaryCertificateWS.setCentralCompetentAuthority(veterinaryCertificate.getCentralCompetentAuthority());
        veterinaryCertificateWS.setLocalCompetentAuthority(veterinaryCertificate.getLocalCompetentAuthority());
        StatusFromForeignSystem statusFromForeignSystem =
                (StatusFromForeignSystem) webServiceTemplate.marshalSendAndReceive(veterinaryCertificateWS);
        return statusFromForeignSystem.getStatus();
    }
}
