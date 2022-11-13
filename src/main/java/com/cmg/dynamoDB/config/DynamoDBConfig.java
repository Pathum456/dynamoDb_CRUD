package com.cmg.dynamoDB.config;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

@Configuration
@EnableDynamoDBRepositories(basePackages = "com.cmg.dynamoDB.repo")
public class DynamoDBConfig {
	@Bean
	public AmazonDynamoDB amazonDynamoDB(AWSCredentialsProvider awsCredentialsProvider) {
		AmazonDynamoDB amazonDynamoDB=AmazonDynamoDBClientBuilder.standard()
				.withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("http://localhost:8000/", "asia-pacific-3"))
				.withCredentials(awsCredentialsProvider).build();
		return amazonDynamoDB;
	}
	
	@Bean
	public AWSCredentialsProvider awsCredentialsProvider() {
		return new AWSStaticCredentialsProvider(new BasicAWSCredentials("root","root"));
	}
}
