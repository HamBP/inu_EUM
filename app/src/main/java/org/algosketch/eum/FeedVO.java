package org.algosketch.eum;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class FeedVO {
    Channel channel;
    ArrayList<Feeds> feeds;

    public class Channel {
        String name;
        String field1;
        String field2;
        String field3;
        String created_at;
        String updated_at;
        String last_entry_id;
    }

    public class Feeds {
        String created_at;
        String entry_id;
        String field1;
        String field2;
        String field3;
    }
}
