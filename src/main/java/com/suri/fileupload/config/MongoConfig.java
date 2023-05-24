package com.suri.fileupload.config;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.suri.fileupload")
public class MongoConfig extends AbstractMongoClientConfiguration {

  
  private String mongoUri="mongodb+srv://suri:9610389885@cluster0.pw3scij.mongodb.net/?retryWrites=true&w=majority";

  @Override
  protected String getDatabaseName() {
    // Specify the name of your MongoDB database
    return "Files";
  }

  @Override
  @Bean
  public MongoClient mongoClient() {
    ConnectionString connectionString = new ConnectionString(mongoUri);
    MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
        .applyConnectionString(connectionString)
        .build();
    return MongoClients.create(mongoClientSettings);
  }
}