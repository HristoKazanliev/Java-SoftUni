package bg.softuni.pathfinder.model.demo_uuid;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class TestUuidInitService implements CommandLineRunner{
    private final TestUuidEntityRepository entityRepository;

    public TestUuidInitService(TestUuidEntityRepository entityRepository) {
        this.entityRepository = entityRepository;
    }

    @Override
    public void run(String... args) throws Exception {
//        TestUuidEntity testUuidEntity = new TestUuidEntity();
//        testUuidEntity.setContent("Test content");
//
//        TestUuidEntity savedEntity = entityRepository.save(testUuidEntity);
    }
}
