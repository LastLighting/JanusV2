package topprogersgroup;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import topprogersgroup.entity.Pet;
import topprogersgroup.entity.VeterinaryCertificate;
import topprogersgroup.entity.VeterinaryDocument;
import topprogersgroup.service.PetService;
import topprogersgroup.service.VeterinaryCertificateService;

import javax.xml.datatype.DatatypeConfigurationException;
import java.io.File;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class JanusApplicationTests {

	@Autowired
	private VeterinaryCertificateService veterinaryCertificateService;

	@Autowired
	private PetService petService;

	@Test
	public void testWS() throws DatatypeConfigurationException {
		VeterinaryDocument document = new VeterinaryDocument();
		document.setNumber(1);
		VeterinaryCertificate certificate = new VeterinaryCertificate();
		certificate.setId(1);
		certificate.setNumber(1);
		certificate.setRegistrationPlace("Что-то там регистрация");
		certificate.setVeterinaryDocument(document);
		certificate.setLocalCompetentAuthority("Что-то там локальное");
		certificate.setCentralCompetentAuthority("Что-то там центральное");
		certificate.setIssueDate(new Date());
		assertThat(veterinaryCertificateService.getStatusFromForeignSystem(certificate)).isEqualTo("Confirmed");
	}
}
