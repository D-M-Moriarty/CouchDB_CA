package com.moriarty.couchdb_ca.db_repository;

import com.moriarty.couchdb_ca.entity.Post;
import org.ektorp.CouchDbConnector;
import org.ektorp.ViewQuery;
import org.ektorp.support.CouchDbRepositorySupport;
import org.ektorp.support.GenerateView;
import org.ektorp.support.View;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
@View( name = "all", map = "function(doc) { emit(doc.name, 1) }" )
public class PostRepository extends CouchDbRepositorySupport<Post> {

    protected PostRepository(CouchDbConnector db) {
        super(Post.class, db);
        try {
            initStandardDesignDocument();
        } catch (NullPointerException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }

    @View( name="all", map = "function(doc) { emit(doc.name, 1); }")
    @Override
    public List<Post> getAll() {
        ViewQuery q = createQuery("all")
                .descending(true)
                .includeDocs(true);
        return db.queryView(q, Post.class);
    }

    @GenerateView
    public List<Post> findByTitle(String name) {
        return queryView("by_title", name);
    }
}



