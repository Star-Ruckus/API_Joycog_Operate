package com.joycog.operate.api.s3Upload.service

import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.model.ObjectMetadata
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.PropertySource
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.text.SimpleDateFormat

/**
 * @fileName S3UploadService
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

@Service
class S3UploadService (
    private val  amazonS3 : AmazonS3
){

    @Value("\${cloud.aws.s3.bucket}")
    private lateinit var bucket: String

    fun saveFile(multipartFile : MultipartFile, folder : String) : String {
        // 파일명 중복을 막기 위해 현재 서버 날짜
        val currentTime = System.currentTimeMillis()
        val sdf = SimpleDateFormat("yyyy-MM-dd-hh:mm:ss")
        val newFilename = sdf.format(currentTime)

        val metadata = ObjectMetadata()
        metadata.contentLength = multipartFile.size
        metadata.contentType = multipartFile.contentType

        amazonS3.putObject("$bucket$folder", newFilename, multipartFile.inputStream, metadata)

        return amazonS3.getUrl(bucket,newFilename).toString()
    }

}