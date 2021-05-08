package com.tmsolution.settingsapi.services.gRPC;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import tmsolution.settings.SettingsGrpc;
import tmsolution.settings.Toggle2faRequest;
import tmsolution.settings.Toggle2faResponse;

@GrpcService
public class SettingsApiService extends SettingsGrpc.SettingsImplBase {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void toggle2fa(Toggle2faRequest request, StreamObserver<Toggle2faResponse> responseObserver) {
//        super.toggle2fa(request, responseObserver);

        var toggle2fa = modelMapper.map(request, Toggle2faRequest.class);
        System.out.println("Working gRPC endpoint");
        responseObserver.onCompleted();
    }
}
