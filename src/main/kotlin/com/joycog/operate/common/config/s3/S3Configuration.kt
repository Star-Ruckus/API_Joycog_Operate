package com.joycog.operate.common.config.s3

import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.services.s3.AmazonS3Client
import com.amazonaws.services.s3.AmazonS3ClientBuilder
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * @fileName S3Config
 * @author yunjeong
 * @since  2023/08/17
 * @version 1.0
 *
 * @Modification Information
 * @
 * @  DATE          AUTHOR         NOTE
 * @ -----------   ------------   -------------------------------
 * @ 2023/08/17        yunjeong        최초 작성
 */
@Configuration
class S3Configuration {
    @Value("\${cloud.aws.credentials.access-key}")
    private lateinit var accessKey: String

    @Value("\${cloud.aws.credentials.secret-key}")
    private lateinit var secretKey: String

    @Value("\${cloud.aws.region.static}")
    private lateinit var region: String


    @Bean
    fun amazonS3Client(): AmazonS3Client? {
        val credentials = BasicAWSCredentials(accessKey, secretKey)
        return AmazonS3ClientBuilder
            .standard()
            .withRegion(region)
            .withCredentials(AWSStaticCredentialsProvider(credentials))
            .build() as AmazonS3Client
    }

}