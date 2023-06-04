package net.runsystem.s3field;

import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;
import software.amazon.awssdk.services.s3.presigner.model.PresignedPutObjectRequest;
import software.amazon.awssdk.services.s3.presigner.model.PutObjectPresignRequest;

import java.time.Duration;

public class PresignedUrlGenerator {
    public String generatePresignedUrl(String bucketName, String objectKey) {
        // Tạo một S3 Presigner với client mặc định.
        S3Presigner presigner = S3Presigner.create();

        // Tạo yêu cầu để tạo presigned URL.
        PutObjectPresignRequest presignRequest = PutObjectPresignRequest.builder()
                .signatureDuration(Duration.ofMinutes(10))
                .putObjectRequest(PutObjectRequest.builder()
                        .bucket(bucketName)
                        .key(objectKey)
                        .build())
                .build();

        // Tạo presigned URL.
        PresignedPutObjectRequest presignedRequest = presigner.presignPutObject(presignRequest);

        // Đóng S3Presigner để giải phóng các tài nguyên hệ thống.
        presigner.close();

        // Trả về URL.
        return presignedRequest.url().toString();
    }
}
