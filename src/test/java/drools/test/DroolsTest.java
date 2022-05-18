package drools.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;

public class DroolsTest {

    private static final Logger logger = LogManager.getLogger(DroolsTest.class);

    @Test
    public void removeFirstRuleFailsTest() {
        KieServices kieServices = KieServices.get();
        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
        kieFileSystem.write(ResourceFactory.newClassPathResource("test/failing.drl"));
        KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem);
        kieBuilder.buildAll();
        KieModule kieModule = kieBuilder.getKieModule();
        KieContainer kieContainer = kieServices.newKieContainer(kieModule.getReleaseId());
        KieBase kieBase = kieContainer.getKieBase();

        logger.info("Remove first rule");
        kieBase.removeRule("test", "firstRule");

        KieSession kieSession = kieBase.newKieSession();
        kieSession.insert(new String());
        kieSession.fireAllRules();
        kieSession.dispose();
    }

    @Test
    public void removeSecondRuleTest() {
        KieServices kieServices = KieServices.get();
        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
        kieFileSystem.write(ResourceFactory.newClassPathResource("test/failing.drl"));
        KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem);
        kieBuilder.buildAll();
        KieModule kieModule = kieBuilder.getKieModule();
        KieContainer kieContainer = kieServices.newKieContainer(kieModule.getReleaseId());
        KieBase kieBase = kieContainer.getKieBase();

        logger.info("Remove first rule");
        kieBase.removeRule("test", "secondRule");

        KieSession kieSession = kieBase.newKieSession();
        kieSession.insert(new String());
        kieSession.fireAllRules();
        kieSession.dispose();
    }

    @Test
    public void removeFirstRuleTest() {
        KieServices kieServices = KieServices.get();
        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
        kieFileSystem.write(ResourceFactory.newClassPathResource("test/not-failing.drl"));
        KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem);
        kieBuilder.buildAll();
        KieModule kieModule = kieBuilder.getKieModule();
        KieContainer kieContainer = kieServices.newKieContainer(kieModule.getReleaseId());
        KieBase kieBase = kieContainer.getKieBase();

        logger.info("Remove first rule");
        kieBase.removeRule("test", "firstRule");

        KieSession kieSession = kieBase.newKieSession();
        kieSession.insert(new String());
        kieSession.fireAllRules();
        kieSession.dispose();
    }
}
