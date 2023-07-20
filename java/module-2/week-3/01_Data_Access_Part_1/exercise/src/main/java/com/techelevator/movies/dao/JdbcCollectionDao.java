package com.techelevator.movies.dao;

import com.techelevator.movies.model.Collection;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcCollectionDao implements CollectionDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcCollectionDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Collection> getCollections() {
        List<Collection> collections = new ArrayList<>();

        String sql = "SELECT * " +
                "FROM collection;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql,collections);

        if(results.next()) {
            collections = mapRowToCollection((results));
        }

        return collections;
    }

    @Override
    public Collection getCollectionById(int id) {
        Collection collectionsId = null;

        String sql = "SELECT collection_id" +
                "FROM collection " +
                "WHERE collection_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id;

        if (results.next()) {
            collectionsId = mapRowToCollection(results);
        }
            return collectionsId;
    }

        @Override
        public List<Collection> getCollectionsByName (String name,boolean useWildCard){
            return null;
        }
    }

    private Collection mapRowToCollection(SqlRowSet rowSet) {
        Collection collection = new Collection();
        collection.setId(rowSet.getInt("collection_id"));
        collection.setName(rowSet.getString("collection_name"));
        return collection;
    }

}

