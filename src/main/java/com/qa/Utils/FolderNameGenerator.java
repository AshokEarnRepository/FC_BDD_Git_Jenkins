package com.qa.Utils;

import com.github.javafaker.Faker;

public class FolderNameGenerator {
	
	  public static String generateRandomFolderName() {
          Faker faker = new Faker();
          return faker.lorem().word() + "Folder";
      }
	  


	      public static String two_generateRandomFolderName() {
	          Faker faker = new Faker();
	          String randomName = faker.regexify("[a-zA-Z0-9]{5,10}"); // Generate a random alphanumeric string with 5 to 10 characters
	          return randomName + "_Ashok";
	      }

	      public static void main(String[] args) {
	          System.out.println(generateRandomFolderName());
	      }


}
