package topprogersgroup.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import topprogersgroup.entity.Owner;

import static org.junit.Assert.*;

/**
 * Created by aalle on 21.06.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class OwnerServiceTest {

    @Autowired
    private OwnerService ownerService;

    @Test
    public void findOne() throws Exception {
        Owner owner = ownerService.findOne(1);
        System.out.print("df");
    }

}