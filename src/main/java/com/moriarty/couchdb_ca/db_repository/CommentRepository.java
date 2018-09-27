package com.moriarty.couchdb_ca.db_repository;

import com.moriarty.couchdb_ca.entity.Comment;
import org.ektorp.CouchDbConnector;
import org.ektorp.support.CouchDbRepositorySupport;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommentRepository extends CouchDbRepositorySupport<Comment> {
    protected CommentRepository(CouchDbConnector db) {
        super(Comment.class, db);
    }
}
