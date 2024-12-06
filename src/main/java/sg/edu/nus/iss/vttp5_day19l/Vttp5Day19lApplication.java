package sg.edu.nus.iss.vttp5_day19l;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Vttp5Day19lApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Vttp5Day19lApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Read the file using FileReader / BufferedReader
		// Put the data into Redis Map
	}

}
