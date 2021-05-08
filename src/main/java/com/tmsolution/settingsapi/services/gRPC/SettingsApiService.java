package com.tmsolution.settingsapi.services.gRPC;


import com.tmsolution.settingsapi.requestmodels.Toggle2faRequest;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import settingsapi.SettingsApiGrpc;
import settingsapi.toggle2faRequest;
import settingsapi.toggle2faResponse;

@GrpcService
public class SettingsApiService extends SettingsApiGrpc.SettingsApiImplBase {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void toggle2fa(toggle2faRequest request, StreamObserver<toggle2faResponse> responseObserver) {
//        super.toggle2fa(request, responseObserver);

        var toggle2fa = modelMapper.map(request, Toggle2faRequest.class);
        System.out.println("Working gRPC endpoint");
        responseObserver.onCompleted();

    }
}
