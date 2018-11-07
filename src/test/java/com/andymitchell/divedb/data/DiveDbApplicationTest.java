//package com.andymitchell.divedb.data;
//
//import com.andymitchell.divedb.configuration.JdbcConfiguration;
//import com.andymitchell.divedb.logic.dives.Dive;
//import com.andymitchell.divedb.logic.dives.DiveRepository;
//import javafx.application.Application;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.context.support.AnnotationConfigContextLoader;
//
//import javax.annotation.Resource;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = {
//        JdbcConfiguration.class},   loader = AnnotationConfigContextLoader.class)
//)
//@ActiveProfiles("test")
//public class DiveDbApplicationTest {
//
//    @Resource
//    private DiveRepository diveRepository;
//
//    @Test
//    public void contextLoads() {
//    }
//
//    @Test
//    public void whenSaveDive_shouldReturnDive() {
//        Dive diveToSave = new Dive();
//        diveToSave.setLocation("here");
//
//        Dive savedDive = diveRepository.save(diveToSave);
//        Dive foundEntity = diveRepository.getDiveFromId(savedDive.getId());
//
//        assertNotNull(foundEntity);
//        assertEquals(savedDive.getLocation(), foundEntity.getLocation());
//    }
//}