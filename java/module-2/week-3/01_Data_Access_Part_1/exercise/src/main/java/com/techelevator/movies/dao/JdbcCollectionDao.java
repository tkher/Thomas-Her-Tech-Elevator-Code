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

    private Collection mapRowToCollection(SqlRowSet result) {
        Collection collection = new Collection();
        collection.setId(result.getInt("collection_id"));
        collection.setName(result.getString("collection_name"));
        if (result.wasNull()) {
            collection.setName(null);
        }
        return collection;
    }
    @Override
    public List<Collection> getCollections() {
        List<Collection> collections = new ArrayList<>();

        String sql = "SELECT * " +
                "FROM collection;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while(results.next()) {
            Collection collection = mapRowToCollection(results);
            collections.add(collection);
        }

        return collections;
    }

    @Override
    public Collection getCollectionById(int id) {
        Collection collectionsId = null;

        String sql = "SELECT * " +
                "FROM collection " +
                "WHERE collection_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);

        if (results.next()) {
            collectionsId = mapRowToCollection(results);
        }
            return collectionsId;
    }

        @Override
        public List<Collection> getCollectionsByName (String name,boolean useWildCard){
            List<Collection> collectionsByName = new ArrayList<>();

            if(useWildCard) {
                name= "%" + name + "%";
            }

            String sql = "SELECT * " +
                    "FROM collection " +
                    "WHERE collection_name LIKE ?;";


            SqlRowSet result = jdbcTemplate.queryForRowSet(sql, name);

            while (result.next()) {
                collectionsByName.add(mapRowToCollection(result));
            }


        return collectionsByName;
        }
    }



