package software.tnb.aws.s3.service;

import software.tnb.aws.common.account.AWSAccount;
import software.tnb.aws.common.service.AWSService;
import software.tnb.aws.s3.validation.S3Validation;
import software.tnb.common.deployment.WithDockerImage;

import java.net.URI;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

public abstract class Minio extends AWSService<AWSAccount, S3Client, S3Validation> implements WithDockerImage {
    protected static final int CONTAINER_API_PORT = 9000;
    protected static final int CONTAINER_UI_PORT = 9001;

    public abstract String hostname();

    protected abstract String clientHostname();

    @Override
    public AWSAccount account() {
        if (account == null) {
            LOG.debug("Creating new Minio account");
            account = new AWSAccount();
            account.setAccount_id("minio");
            account.setAccess_key("minio");
            account.setSecret_key("minio123minio123minio123");
            account.setRegion("us-west-1");
        }
        return account;
    }

    @Override
    protected S3Client client() {
        if (client == null) {
            client = S3Client.builder()
                .endpointOverride(URI.create(clientHostname()))
                .region(Region.of(account().region()))
                .credentialsProvider(() -> AwsBasicCredentials.create(account().accountId(), account().secretKey()))
                .forcePathStyle(true)
                .build();
        }
        return client;
    }

    @Override
    public String defaultImage() {
        return "quay.io/minio/minio:RELEASE.2024-10-13T13-34-11Z";
    }
}
