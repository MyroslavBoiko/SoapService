package com.soapService.endpoint;

import com.soapService.model.*;
import com.soapService.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

@Endpoint
public class TeamEndpoint {

    private static final String NAMESPACE_URI = "http://tutorialspoint/schemas";
    private TeamRepository teamRepository;

    @Autowired
    public TeamEndpoint(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getTeamRequest")
    @ResponsePayload
    public GetTeamResponse getTeam(@RequestPayload GetTeamRequest request) {
        Team team = teamRepository.findTeam(request.getName());
        GetTeamResponse response = new GetTeamResponse();
        response.setTeam(team);
        return response;

    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteTeamRequest")
    @ResponsePayload
    public DeleteTeamResponse getTeam(@RequestPayload DeleteTeamRequest request) {
        Team team = teamRepository.deleteTeam(request.getName());
        DeleteTeamResponse response = new DeleteTeamResponse();
        response.setTeam(team);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getTeamsRequest")
    @ResponsePayload
    public GetTeamsResponse getTeams(@RequestPayload GetTeamsRequest request) {
        List<Team> teams = teamRepository.getTeams();
        GetTeamsResponse response = new GetTeamsResponse();
        response.getTeam().addAll(teams);
        return response;

    }

}
