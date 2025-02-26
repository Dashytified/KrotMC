package nl.kvinnekraft.games.ctw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

enum TeamName
{
    Blue, Red, Pink, Purple, Magenta
}

class TeamInfo
{
    public List<UUID> players = new ArrayList<>();

    public void EngageUser(UUID uuid)
    {

    }

    public void DisengageUser(UUID uuid)
    {

    }

    public boolean HasUser(UUID uuid)
    {
        return false;
    }
}

public class CaptureTheWool
{
    private final HashMap<TeamName, TeamInfo> players = new HashMap<>();

    public void ProvokeMagick()
    {

    }
}
