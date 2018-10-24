package com.soapService.repository;

import com.soapService.model.Player;
import com.soapService.model.Players;
import com.soapService.model.Team;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TeamRepository {

    private static final List<Team> teams = new ArrayList<>();

    public TeamRepository(){
        initData();
    }

    public void initData() {

        Team blast = new Team();
        blast.setName("Blast");
        blast.setCity("Hongkong");

        Players players1 = new Players();

        Player u = new Player();
        u.setName("Uion");
        u.setSurname("Eeir");
        u.setTeamName(blast.getName());
        players1.getPlayer().add(u);

        Player o = new Player();
        o.setName("Opas");
        o.setSurname("Citsad");
        o.setTeamName(blast.getName());
        players1.getPlayer().add(o);

        blast.setPlayers(players1);

        teams.add(blast);


        Team quest = new Team();
        quest.setName("Quest");
        quest.setCity("Jakarta");

        Players players2 = new Players();

        Player n = new Player();
        n.setName("Nucio");
        n.setSurname("Terio");
        n.setTeamName(quest.getName());
        players2.getPlayer().add(n);

        Player m = new Player();
        m.setName("Moturo");
        m.setSurname("Varista");
        m.setTeamName(quest.getName());
        players2.getPlayer().add(m);

        quest.setPlayers(players2);

        teams.add(quest);

    }
    public Team findTeam(String name) {
        Team result = null;
        for (Team team : teams) {
            if (name.trim().equals(team.getName())) {
                result = team;
            }
        }
        return result;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public Team deleteTeam(String name) {
        Team result = null;
        for (Team team : teams) {
            if (name.trim().equals(team.getName())) {
                result = team;
            }
        }
        return teams.remove(result)? result :null;
    }

}
