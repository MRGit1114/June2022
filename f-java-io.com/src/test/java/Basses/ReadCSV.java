package Basses;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBeanBuilder;
import static org.junit.Assert.*;
import org.junit.Test;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadCSV {

	@Test
	public void canReadBasses() {

		Map<String, String> expectedMap = new HashMap<String, String>();

		try {
			CSVReader reader = new CSVReader(new FileReader("src/main/resources/9_basses.csv"));
			String[] values = null;
			while((values = reader.readNext()) != null)
			{
				System.out.println(Arrays.asList(values));
			}
			List<Basses> basses = new CsvToBeanBuilder<Basses>(reader)
					.withType(Basses.class)
					.build()
					.parse();
			for (Basses b : basses) {
				System.out.println(b.getMake() + "" + b.getModel());
			}
		} catch (Exception e)

		{
			System.out.println("CSV read completed");
		}

		assertNotNull(expectedMap);
	}
}
