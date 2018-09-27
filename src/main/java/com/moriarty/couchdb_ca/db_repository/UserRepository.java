package com.moriarty.couchdb_ca.db_repository;


import com.moriarty.couchdb_ca.entity.User;
import org.ektorp.CouchDbConnector;
import org.ektorp.ViewQuery;
import org.ektorp.ViewResult;
import org.ektorp.support.CouchDbRepositorySupport;
import org.ektorp.support.GenerateView;
import org.ektorp.support.View;
import org.ektorp.support.Views;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Configuration
@Views({ // Defining views used by the repository through annotations
        @View(name = "all", map = "function(doc) { emit(doc.name, 1) }"),
        @View(name="by_createdAt", map = "function(doc) { emit(doc.name, 1) }")
        })// class extends CouchDbRepositorySupport and then creates a
          // design document for the user class
public class UserRepository extends CouchDbRepositorySupport<User> {

    @Autowired
    public UserRepository(CouchDbConnector db) {
        super(User.class, db);
        initStandardDesignDocument();
    }
    // annotation for the auto generation of views, only finder methods
    @GenerateView
    public List<User> findByName(String name) {
        return queryView("by_name", name);
    }

    @GenerateView
    public List<User> findByCreatedAt(String createdAt) {
        return queryView("by_createdAt", createdAt);
    }

    @View( name = "by_name_cust",
            map = "function(doc) { emit(doc.name, doc.createdAt) }")
    public String getNameCust() {
        ViewResult r = db.queryView(createQuery("by_name_cust"));
        return r.getRows().get(0).toString();
    }

    @View( name="all", map = "function(doc) { emit(doc.name, 1); }")
    @Override
    public List<User> getAll() {
        ViewQuery q = createQuery("all")
                .descending(true)
                .includeDocs(true);
        return db.queryView(q, User.class);
    }
}


// Ektorps default behaviour is not to alter existing views
// however if the @View annotation view declaration differs from the
// existing view it will update it in the design document in the DB