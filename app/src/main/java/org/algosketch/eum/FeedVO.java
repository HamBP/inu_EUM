package org.algosketch.eum;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class FeedVO {
    Channel channel;
    ArrayList<Feeds> feeds;

    public class Channel {
        public String name;
        public String field1;
        public String field2;
        public String field3;
        public String created_at;
        public String updated_at;
        public String last_entry_id;
    }

    public class Feeds {
        public String created_at;
        public String entry_id;
        public String field1;
        public String field2;
        public String field3;
    }
}