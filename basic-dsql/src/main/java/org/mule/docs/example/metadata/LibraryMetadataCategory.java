package org.mule.docs.example.metadata;

import org.mule.api.annotations.MetaDataKeyRetriever;
import org.mule.api.annotations.MetaDataRetriever;
import org.mule.api.annotations.components.MetaDataCategory;
import org.mule.common.metadata.*;
import org.mule.common.metadata.builder.DefaultMetaDataBuilder;
import org.mule.docs.example.ExampleDsqlConnector;
import org.mule.docs.example.model.Author;
import org.mule.docs.example.model.Book;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Mulesoft, Inc
 */
@MetaDataCategory
public class LibraryMetadataCategory {

    @Inject
    ExampleDsqlConnector connector;

    public void setConnector(ExampleDsqlConnector connector) {
        this.connector = connector;
    }

    @MetaDataKeyRetriever
    public List<MetaDataKey> getEntities() throws Exception {

        List<MetaDataKey> entities = new ArrayList<MetaDataKey>();

        entities.add(new DefaultMetaDataKey("Book_id","Book"));
        entities.add(new DefaultMetaDataKey("Author_id","Author"));
        entities.add(new DefaultMetaDataKey("BookList_id","BookList"));

        return entities;
    }

    @MetaDataRetriever
    public MetaData describeEntity(MetaDataKey entityKey) throws Exception {

        //Here we describe the entity depending on the entity key

        if ("Author_id".equals(entityKey.getId())) {
            MetaDataModel authorModel =  new DefaultMetaDataBuilder().createPojo(Author.class).build();
            return new DefaultMetaData(authorModel);
        }

        if ("Book_id".equals(entityKey.getId())) {
            MetaDataModel bookModel =  new DefaultMetaDataBuilder().createPojo(Book.class).build();
            return new DefaultMetaData(bookModel);
        }

        if ("BookList_id".equals(entityKey.getId())) {
            MetaDataModel bookListModel =  new DefaultMetaDataBuilder().createList().ofPojo(Book.class).build();
            return new DefaultMetaData(bookListModel);
        }

        throw new RuntimeException(String.format("This entity %s is not supported",entityKey.getId()));

    }
}
