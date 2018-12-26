package com.globant.alozano.celebrity;

import com.globant.alozano.celebrity.exception.CelebrityException;
import com.globant.alozano.celebrity.model.Person;
import com.globant.alozano.celebrity.service.ICelebrityService;
import com.globant.alozano.celebrity.service.IGroupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

/**
 * The principal's project class
 */
@SpringBootApplication
public class CelebrityApplication implements CommandLineRunner {

	@Autowired
	private IGroupService groupService;

	@Autowired
	private ICelebrityService celebrityService;

	private static Logger LOGGER = LoggerFactory
			.getLogger(CelebrityApplication.class);

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(CelebrityApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}

	@Override
	public void run(String... args) {
	    if(args.length > 0) {

            try {
                String strGroupId = args[0];
                Integer groupId = Integer.parseInt(strGroupId);
                LOGGER.info(String.format("Starting to find the celebrity for the %d group, using the brute force algorithm",groupId));
                try {
                    Optional<Person> optionalCelebrity = celebrityService.findTheCelebrityByBruteForce(groupId);
                    if (optionalCelebrity.isPresent()) {
                        Person celebrity = optionalCelebrity.get();
                        LOGGER.info(String.format("The celebrity in the group %d is %s", groupId, celebrity.getName()));
                    }
                } catch (CelebrityException ex) {
                    LOGGER.error(ex.getMessage());
                }
                LOGGER.info(String.format("Finishing to find the celebrity for the %d group, using the brute force algorithm",groupId));

                LOGGER.info(String.format("Starting to find the celebrity for the %d group, using the stack algorithm",groupId));
                try {
                    Optional<Person> optionalCelebrity = celebrityService.findTheCelebrityUsingAStack(groupId);
                    if (optionalCelebrity.isPresent()) {
                        Person celebrity = optionalCelebrity.get();
                        LOGGER.info(String.format("The celebrity in the group %d is %s", groupId, celebrity.getName()));
                    }
                } catch (CelebrityException ex) {
                    LOGGER.error(ex.getMessage());
                }
                LOGGER.info(String.format("Finishing to find the celebrity for the %d group, using the stack algorithm",groupId));
            }catch (NumberFormatException ex) {
                LOGGER.error("The groupId should be a valid integer");
            }
        }else {
            LOGGER.error("You must specify a groupId");
        }

	}
}

