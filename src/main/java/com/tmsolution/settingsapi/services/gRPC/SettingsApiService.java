package com.tmsolution.settingsapi.services.gRPC;

import io.grpc.stub.StreamObserver;
import settingsapi.SettingsApiGrpc;
import settingsapi.toggle2faRequest;
import settingsapi.toggle2faRqsponse;

public class SettingsApiService extends SettingsApiGrpc.SettingsApiImplBase {
    @Override
    public void toggle2fa(toggle2faRequest request, StreamObserver<toggle2faRqsponse> responseObserver) {
        super.toggle2fa(request, responseObserver);
    }
}
