package in.ushatech.dsa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DsaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DsaApplication.class, args);
	}

	public static int[] middle(int[] input)
    {
        int[] result = new int[input.length-2];
        for(int i=0 ; i< input.length; ++i)
        {
            if(i==0 || i== input.length-1)
            {
                continue;
            }
            result[i-1]=input[i];
        }
        return result;
    }
}
